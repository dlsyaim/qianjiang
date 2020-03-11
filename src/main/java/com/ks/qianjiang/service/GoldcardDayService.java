package com.ks.qianjiang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.qianjiang.mapper.GoldcardDayDAO;
import com.ks.qianjiang.mapper.GoldcardInfoDAO;
import com.ks.qianjiang.model.GoldcardDay;
import com.ks.qianjiang.model.GoldcardInfo;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoldcardDayService {
    @Autowired
    public GoldcardDayDAO goldcardDayDAO;

    Logger logger = LoggerFactory.getLogger(getClass());
    public int insertUniqueWebData(JSONObject obj) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        GoldcardDay info = objectMapper.readValue(obj.toString(), GoldcardDay.class);
        goldcardDayDAO.insertUnique(info);
        return 1;
    } ;


    //解析获取过来的JSON转GoldcardInfo
    public  GoldcardInfo parseObj(JSONObject obj) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        GoldcardInfo info = objectMapper.readValue(obj.toString(), GoldcardInfo.class);
        return info;
    }
}
