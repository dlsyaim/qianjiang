package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.GoldcardDay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoldcardDayDAO {
    int deleteByPrimaryKey(Integer ID);

    int insert(GoldcardDay record);

    int insertSelective(GoldcardDay record);

    GoldcardDay selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(GoldcardDay record);

    int updateByPrimaryKey(GoldcardDay record);
    int insertUnique(GoldcardDay record);
}