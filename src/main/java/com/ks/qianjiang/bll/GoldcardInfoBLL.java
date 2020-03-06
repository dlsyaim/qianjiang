package com.ks.qianjiang.bll;

import com.google.gson.Gson;
import com.ks.qianjiang.Util.DESUtil;
import com.ks.qianjiang.config.GoldcardConfig;
import com.ks.qianjiang.model.GoldcardInfo;
import com.ks.qianjiang.model.GoldcardReal;
import com.ks.qianjiang.service.GoldcardInfoService;
import com.ks.qianjiang.service.GoldcardService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class GoldcardInfoBLL {

    @Autowired
    GoldcardInfoService goldcardInfoService;

    @Autowired
    GoldcardService goldcardService;
    Logger logger = LoggerFactory.getLogger(getClass());
    //2.3.14 表具详细信息查询   @Async
    //@Scheduled(fixedRateString ="${goldcard.getMeterRealDataTime}", initialDelay=10000)
    //0 0 1 * * ?每天凌晨执行一次
    //@Scheduled(cron ="${goldcard.cronInfo}")
    @Scheduled(fixedRateString ="${goldcard.getMeterInfoDateTime}", initialDelay=20000)
    public void getMeterInfData(){
        //List<Map<String,Object>>  aMap =
        List<Map<String, Object>> list=  goldcardService.goldcardRealDAO.userNO_List(); //获取所有表编号和用户编号
        ArrayList<GoldcardInfo> goldcards = new ArrayList<GoldcardInfo>(100); //有100条数据插入到数据库
        for(Map<String,Object> obj:list){

          String data= this.postRequest(obj.get("userArchivesNum").toString(),obj.get("gasMeterNo").toString());

            logger.info("Error", data);
            // String response = new String(post.getResponseBody(),"UTF-8");
            //logger.info(response);
            try {
                JSONObject jsonObject = new JSONObject(data);

                if(jsonObject.get("echoCode").equals("0000") ){
                    JSONObject echoMsgObject = (JSONObject) jsonObject.get("echoMsg");
                   {
                       //goldcardInfoService.insertWebData(echoMsgObject);
                      goldcardInfoService.insertUniqueWebData(echoMsgObject);
                      // GoldcardInfo info = goldcardInfoService.parseObj(echoMsgObject);
                       //goldcards.add(info);
                    }
                    logger.info("成功:"+obj.get("gasMeterNo").toString()+":"+data);
                    //post.releaseConnection();

                }else{
                    logger.info("错误:"+obj.get("gasMeterNo").toString());
                }


            }catch (JSONException err){
                logger.info("Error", err.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

//            if(goldcards.size()>=100){
//                //有一百条数据，插入SQLServer
//                goldcardInfoService.insertGoldcardInfoList(goldcards);
//                goldcards.clear();
//            }
        }//end of for

        //刚好整数，还是判断下
        if(goldcards.size()>0){
            goldcardInfoService.insertGoldcardInfoList(goldcards);
            goldcards.clear();
        }
    }
    public String postRequest(String userNo,String meterNo) {
        logger.info(new Throwable()
                .getStackTrace()[0]
                .getMethodName());
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("goldcard.yml");
        GoldcardConfig goldcardConfig= yaml.loadAs(inputStream,GoldcardConfig.class);
        String url = goldcardConfig.getUrl()+"v2/collect/meter/1014";

        String appCode = goldcardConfig.getAppCode();
        String appSecret = goldcardConfig.getAppSecret();
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String postdata = "";
        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod(url);
        //HTTP基本认证
        post.setRequestHeader("Content-Type","application/json;charset=utf-8");
        post.setRequestHeader("AccessToken", DESUtil.encodeMd5(appCode + appSecret + time));
        try {
            post.setRequestHeader("Authorization",DESUtil.encodeString(appCode + ":" + time));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logger.info("AccessToken："+DESUtil.encodeMd5(appCode + appSecret + time)+"-----------"+
                    "Authorization:"+ DESUtil.encodeString(appCode + ":" + time));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("serialNo", DESUtil.getRandomString(32));

        map.put("userName","");
        map.put("deviceId","");
        map.put("factorNo", goldcardConfig.getFactorNo());

        map.put("companyCode", goldcardConfig.getCompanyCode());
        map.put("userNo", userNo);
        map.put("meterNo", meterNo);

        String jsondata = new Gson().toJson(map);
        logger.info(jsondata);
        //Thread.sleep(10);

        //logger.info(jsondata);
        // System.out.println(jsondata);

        RequestEntity requestEntity= null;
        try {
            requestEntity = new StringRequestEntity(jsondata, "application/json", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setRequestEntity(requestEntity);
        String response=null;
        try {
            httpclient.executeMethod(post);
            //post.releaseConnection();;
            response= new String(post.getResponseBody(),"UTF-8");
            logger.info(response);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("--------请求cis连接超时-------");
        }finally {
            post.releaseConnection();
        }
        return response;




    }
}
