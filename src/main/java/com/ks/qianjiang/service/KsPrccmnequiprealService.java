package com.ks.qianjiang.service;

import com.ks.qianjiang.mapper.KsPrccmnequiprealDAO;
import com.ks.qianjiang.model.KsPrccmnequipreal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KsPrccmnequiprealService {

    @Autowired
    KsPrccmnequiprealDAO ksPrccmnequiprealDAO;
    public List<KsPrccmnequipreal> selectAll(){
        return ksPrccmnequiprealDAO.selectAll();

    }

}
