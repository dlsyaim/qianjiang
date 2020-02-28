package com.ks.qianjiang.controller;

import com.ks.qianjiang.model.KsManager;
import com.ks.qianjiang.service.KsManagerService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class KsManagerController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    KsManagerService ksManagerService;

    @ResponseBody
    @GetMapping("/manager/{id}")
    public KsManager getKsManager(@PathVariable("id") Integer id) {
        //System.out.println("controller");
        logger.info(String.valueOf(id));
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
        return ksManagerService.selectByPrimaryKey((long) id);
    }


    @ResponseBody
    @RequestMapping("/manager")
    public int selectByUserAndPassword(@Param("ManagerName") String ManagerName, @Param("Password") String Password)
    {

        logger.info("进去方法");
        return ksManagerService.selectByUserAndPassword( ManagerName,Password);
    }

}
