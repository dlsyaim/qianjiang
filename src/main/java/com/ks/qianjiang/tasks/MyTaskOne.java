package com.ks.qianjiang.tasks;

import com.google.gson.Gson;
import com.ks.qianjiang.Util.DESUtil;
import com.ks.qianjiang.config.GoldcardConfig;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyTaskOne implements Tasklet {
//   @Autowired
//    private GoldcardConfig goldcardConfig;
//    String url2 = goldcardConfig.toString();

    Logger log = LoggerFactory.getLogger(getClass());

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskOne start..");
        //System.out.println(url2);
        log.trace("MyTaskOne接口");
        // ... your code
//        appCode 00000086  appSecret F1F26046CDCA7D9572B0367F0FB043FD
        Yaml yaml = new Yaml();
//        InputStream inputStream = this.getClass()
//                .getClassLoader()
//                .getResourceAsStream("application.yml");
//        Map<String, Object> obj = yaml.load(inputStream);
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("goldcard.yml");
       GoldcardConfig goldcardConfig= yaml.loadAs(inputStream,GoldcardConfig.class);
        String url = goldcardConfig.getUrl();


       // String url =  goldcardConfig.getUrl();
        //System.out.println(url);
        String appCode = goldcardConfig.getAppCode();
        String appSecret = goldcardConfig.getAppSecret();
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String postdata = "";
        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod(url);
        //HTTP基本认证
        post.setRequestHeader("Content-Type","application/json;charset=utf-8");
        post.setRequestHeader("AccessToken",DESUtil.encodeMd5(appCode + appSecret + time));
        post.setRequestHeader("Authorization",DESUtil.encodeString(appCode + ":" + time));
        log.info("AccessToken："+DESUtil.encodeMd5(appCode + appSecret + time)+"-----------"+
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

        System.out.println(jsondata);

        RequestEntity requestEntity= new StringRequestEntity(jsondata, "application/json", "UTF-8");
        post.setRequestEntity(requestEntity);
        try {
           httpclient.executeMethod(post);
        } catch (Exception e) {
            log.info("--------请求cis连接超时-------");
        }

        String response = new String(post.getResponseBody(),"UTF-8");
        System.out.println(response);
        System.out.println("MyTaskOne done..");



        return RepeatStatus.FINISHED;
    }
}