package com.ks.qianjiang.bll;

import com.google.gson.Gson;
import com.ks.qianjiang.Util.DESUtil;
import com.ks.qianjiang.config.GoldcardConfig;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class GoldcardRealBLL {
    @Autowired
    GoldcardService goldcardService;
    Logger logger = LoggerFactory.getLogger(getClass());

    //获取设备实时数据
    @Async
    @Scheduled(fixedRateString ="${goldcard.getMeterRealDataTime}", initialDelay=1000)
    public void getMeterRealData() throws IOException {
        logger.info(new Throwable()
                .getStackTrace()[0]
                .getMethodName());
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("goldcard.yml");
        GoldcardConfig goldcardConfig= yaml.loadAs(inputStream,GoldcardConfig.class);
        String url = goldcardConfig.getUrl()+"v2/collect/meter/1013";

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
        map.put("readingDate", "");

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
            goldcardService.insertGoldcardReal(list);   //插入数据
        }catch (JSONException err){
            logger.info("Error", err.toString());
        }
    }
}
