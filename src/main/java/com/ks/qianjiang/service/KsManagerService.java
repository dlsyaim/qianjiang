package com.ks.qianjiang.service;

import com.ks.qianjiang.mapper.KsManagerDAO;
import com.ks.qianjiang.model.KsManager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KsManagerService {

    @Autowired
    KsManagerDAO ksManagerDAO;
    public KsManager selectByPrimaryKey(Long id){
        return ksManagerDAO.selectByPrimaryKey(id);
                
    }

    public int selectByUserAndPassword(@Param("ManagerName") String ManagerName, @Param("Password") String Password)
    {
        return ksManagerDAO.selectByUserAndPassword( ManagerName, Password);
    }
}
