package com.ks.qianjiang.bll;

import com.google.gson.Gson;
import com.ks.qianjiang.Util.DESUtil;
import com.ks.qianjiang.config.GoldcardConfig;
import com.ks.qianjiang.model.GoldcardDay;
import com.ks.qianjiang.model.GoldcardInfo;
import com.ks.qianjiang.model.GoldcardReal;
import com.ks.qianjiang.service.GoldcardDayService;
import com.ks.qianjiang.service.GoldcardInfoService;
import com.ks.qianjiang.service.GoldcardService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class GoldcardDayBLL {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    GoldcardDayService goldcardDayService;
    @Autowired
    GoldcardService goldcardService;
    @Scheduled(fixedRateString ="${goldcard.getMeterDayDateTime}", initialDelay=20000)
    public void getMeterInfData() throws JSONException {
        //List<Map<String,Object>>  aMap =
        List<Map<String, Object>> list=  goldcardService.goldcardRealDAO.userNO_List(); //获取所有表编号和用户编号
        ArrayList<GoldcardInfo> goldcards = new ArrayList<GoldcardInfo>(100); //有100条数据插入到数据库
        for(Map<String,Object> obj:list){

         String data= this.postRequest(obj.get("userArchivesNum").toString(),obj.get("gasMeterNo").toString());

            //String data= this.postRequest("202003031503","202003031503");

            logger.info("Error", data);
            // String response = new String(post.getResponseBody(),"UTF-8");
            //logger.info(response);

            final JSONObject jsonObject =  new JSONObject(data);
            if(jsonObject.get("echoCode").equals("0000") ){
                    JSONObject echoMsgObject = (JSONObject) jsonObject.get("echoMsg");
                    JSONArray listData = (JSONArray)echoMsgObject.get("gasData");
                    for (int i=0; i < listData.length(); i++) {

                        try {
                            goldcardDayService.insertUniqueWebData( listData.getJSONObject(i));
                            logger.info("成功每日用气量:"+listData.getJSONObject(i));
                        } catch (IOException e) {
                            e.printStackTrace();
                            logger.info("失败每日用气量:"+listData.getJSONObject(i));
                        }
                    }
            }
                    logger.info("成功:"+obj.get("gasMeterNo").toString()+":"+data);
                    //post.releaseConnection();
        }//end of for


    }

    //发送日用气量请求
    public String postRequest(String userNo,String meterNo) {
        logger.info(new Throwable()
                .getStackTrace()[0]
                .getMethodName());
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("goldcard.yml");
        GoldcardConfig goldcardConfig= yaml.loadAs(inputStream,GoldcardConfig.class);
        String url = goldcardConfig.getUrl()+"v1/collect/meter/1015";

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
        map.put("userNo", userNo);
        map.put("userName","");
        map.put("deviceId","");
        map.put("factorNo", goldcardConfig.getFactorNo());
        map.put("meterNo", meterNo);
        Date dateStart = DateUtils.addDays(new Date(), -61);
        SimpleDateFormat sdfDD = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
        String strMonth =  sdfMonth.format(dateStart);


        //map.put("startTime",sdfStartTime.format(date));
        Date dateEnd = DateUtils.addDays(new Date(), -1);
        String strEndMonth = getLastMonth(sdfDD.format(dateEnd));
        if(strMonth.equals(strEndMonth)){
            map.put("startTime",sdfDD.format(dateStart));
        }else {
            map.put("startTime",strEndMonth+"-01");
        }

    ;
        //sdfEndTime.
        //sdfEndTime.
        map.put("endTime",sdfDD.format(dateEnd));
        map.put("companyCode", goldcardConfig.getCompanyCode());
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

/**
     * 获取任意时间的上一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
public  String getLastMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
        month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
        month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month-2,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
 }

}
