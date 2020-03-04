package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.GoldcardReal;

public interface GoldcardRealDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(GoldcardReal record);

    int insertSelective(GoldcardReal record);

    GoldcardReal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoldcardReal record);

    int updateByPrimaryKey(GoldcardReal record);
}