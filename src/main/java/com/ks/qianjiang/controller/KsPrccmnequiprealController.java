package com.ks.qianjiang.controller;

import com.ks.qianjiang.model.KsPrccmnequipreal;
import com.ks.qianjiang.service.KsPrccmnequiprealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KsPrccmnequiprealController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    KsPrccmnequiprealService ksPrccmnequiprealService;


    @ResponseBody
    @GetMapping("/real")
   public List<KsPrccmnequipreal> selectAll(){
       return ksPrccmnequiprealService.selectAll();
   }
}
