package com.ks.qianjiang.service;
;
import com.google.gson.Gson;
import com.ks.qianjiang.Util.DESUtil;
import com.ks.qianjiang.config.GoldcardConfig;
import com.ks.qianjiang.mapper.GoldcardRealDAO;
import com.ks.qianjiang.model.GoldcardReal;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.ks.qianjiang.mapper.KsManagerDAO;
import com.ks.qianjiang.model.KsManager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@Service
public class GoldcardService {
    @Autowired
    public   GoldcardRealDAO goldcardRealDAO;

    Logger logger = LoggerFactory.getLogger(getClass());


    //2.4.16物联网明细查询
   // @Scheduled(fixedRateString ="${goldcard.getMeterRealDataTime}", initialDelay=3000)
    public void getMeterIotInfData() throws IOException {
        logger.info(new Throwable()
                .getStackTrace()[0]
                .getMethodName());
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("goldcard.yml");
        GoldcardConfig goldcardConfig= yaml.loadAs(inputStream,GoldcardConfig.class);
        String url = goldcardConfig.getUrl()+"v1/collect/meter/1016";

        String appCode = goldcardConfig.getAppCode();
        String appSecret = goldcardConfig.getAppSecret();
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String postdata = "";
        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod(url);
        //HTTP基本认证
        post.setRequestHeader("Content-Type","application/json;charset=utf-8");
        post.setRequestHeader("AccessToken", DESUtil.encodeMd5(appCode + appSecret + time));
        post.setRequestHeader("Authorization",DESUtil.encodeString(appCode + ":" + time));
        logger.info("AccessToken："+DESUtil.encodeMd5(appCode + appSecret + time)+"-----------"+
                "Authorization:"+ DESUtil.encodeString(appCode + ":" + time));
//        Gson gson = new Gson();
//        String jsondata = gson.toJson({ "companyCode":"10001058", "meterNo":"",
//                "factorNo":"1001", "readingDate":"", "serialNo":"950c892a6b384d3890af48aa69e37a98" });
//        log.info("---------请求cis前,组装的数据："+jsondata+"-----------");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("serialNo", DESUtil.getRandomString(32));
        map.put("companyCode", goldcardConfig.getCompanyCode());
        map.put("factorNo", goldcardConfig.getFactorNo());
        map.put("meterNo", "");
        map.put("meterType", "");
        map.put("customerType","");
        map.put("readStatus", "0");
        map.put("valveSatus","0");
        map.put("expType", "");
        map.put("currentPage","1");
        map.put("pageSize","100");

        String jsondata = new Gson().toJson(map);

        logger.info(jsondata);
        // System.out.println(jsondata);

        RequestEntity requestEntity= new StringRequestEntity(jsondata, "application/json", "UTF-8");
        post.setRequestEntity(requestEntity);
        try {
            httpclient.executeMethod(post);
        } catch (Exception e) {
            logger.info("--------请求cis连接超时-------");
        }

        String response = new String(post.getResponseBody(),"UTF-8");
        logger.info(response);

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject echoMsgObject = (JSONObject) jsonObject.get("echoMsg");
            JSONObject readingDataObject = (JSONObject) echoMsgObject.get("readingData");
            //JSONObject dataObject = (JSONObject) readingDataObject.get("data");
            JSONArray list = (JSONArray) readingDataObject.get("data");
            this.insertGoldcardReal(list);
        }catch (JSONException err){
            logger.info("Error", err.toString());
        }
    }

    //插入数据
    public int insertGoldcardReal(JSONArray list){ ;
        JSONObject goldcardRealJson;
        ArrayList<GoldcardReal> goldcardReals = new ArrayList<GoldcardReal>(list.length());
        // Process each result in json array, decode and convert to business object
        for (int i=0; i < list.length(); i++) {
            try {
                goldcardRealJson = list.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            GoldcardReal goldcardRealobj = GoldcardReal.fromJson(goldcardRealJson);
            if (goldcardRealobj != null) {
                //goldcardReals.add(goldcardRealobj);
                goldcardRealDAO.insertUnique2(goldcardRealobj);
               //goldcardRealDAO.insertAll(goldcardRealobj);
            }
        }
       //goldcardRealDAO.insertUnique(goldcardReals);
      //goldcardRealDAO.insertGoldcardRealList(goldcardReals);
        //goldcardRealDAO.insertUnique(g)
       // List<GoldcardReal> mythings = (List<GoldcardReal>) (Object) list;
        return 1;

    }

}
