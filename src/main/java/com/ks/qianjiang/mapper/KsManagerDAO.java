package com.ks.qianjiang.mapper;

import com.ks.qianjiang.model.KsManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KsManagerDAO {
    int deleteByPrimaryKey(Long managerid);

    int insert(KsManager record);

    int insertSelective(KsManager record);

    KsManager selectByPrimaryKey(Long managerid);

    int updateByPrimaryKeySelective(KsManager record);

    int updateByPrimaryKey(KsManager record);

    int selectByUserAndPassword(@Param("ManagerName") String ManagerName, @Param("Password") String Password);
}