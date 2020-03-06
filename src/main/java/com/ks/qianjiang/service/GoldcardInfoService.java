package com.ks.qianjiang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.qianjiang.mapper.GoldcardInfoDAO;
import com.ks.qianjiang.mapper.GoldcardRealDAO;
import com.ks.qianjiang.model.GoldcardInfo;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoldcardInfoService {
    @Autowired
    public  GoldcardInfoDAO  goldcardInfoDAO;

    Logger logger = LoggerFactory.getLogger(getClass());

    //插入Web获取过来的数据
    public int insertWebData(JSONObject obj) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        GoldcardInfo info = objectMapper.readValue(obj.toString(), GoldcardInfo.class);
        //goldcardInfoDAO.insert(info);
        goldcardInfoDAO.insertUnique(info);
        return 1;
    } ;
    public int insertUniqueWebData(JSONObject obj) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        GoldcardInfo info = objectMapper.readValue(obj.toString(), GoldcardInfo.class);
        goldcardInfoDAO.insertUnique(info);
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

    public void insertGoldcardInfoList(List<GoldcardInfo> goldcardInfos){
        goldcardInfoDAO.insertGoldcardInfoList(goldcardInfos);
    }
}
