package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.GoldcardReal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoldcardRealDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(GoldcardReal record);

    int insertAll(GoldcardReal record);

    int insertSelective(GoldcardReal record);

    GoldcardReal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoldcardReal record);

    int updateByPrimaryKey(GoldcardReal record);

    void insertGoldcardRealList(List<GoldcardReal> goldcardReals);

    //int insertUnique(GoldcardReal record);
    int insertUnique(List<GoldcardReal> goldcardReals);
    int insertUnique2(GoldcardReal record);
    List<Map<String,Object >> userNO_List();

}