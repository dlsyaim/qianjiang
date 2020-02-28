package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.KsPrccmnequipreal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KsPrccmnequiprealDAO {
    int deleteByPrimaryKey(Integer prccmnequiprealid);

    int insert(KsPrccmnequipreal record);

    int insertSelective(KsPrccmnequipreal record);

    KsPrccmnequipreal selectByPrimaryKey(Integer prccmnequiprealid);

    int updateByPrimaryKeySelective(KsPrccmnequipreal record);

    int updateByPrimaryKey(KsPrccmnequipreal record);

    List<KsPrccmnequipreal> selectAll();
}