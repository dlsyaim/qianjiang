package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.GoldcardInfo;
import com.ks.qianjiang.model.GoldcardReal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoldcardInfoDAO {
    int deleteByPrimaryKey(Integer ID);

    int insert(GoldcardInfo record);

    int insertSelective(GoldcardInfo record);

    GoldcardInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(GoldcardInfo record);

    int updateByPrimaryKey(GoldcardInfo record);

    void insertGoldcardInfoList(List<GoldcardInfo> goldcardInfos);
    int insertUnique(GoldcardInfo record);
}