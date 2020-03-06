package com.ks.qianjiang;

import com.ks.qianjiang.bll.MailBLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QianjiangApplication {
    public static void main(String[] args) {
        SpringApplication.run(QianjiangApplication.class, args);
        //mailBLL.sendSimpleMail("757624760@qq.com","757624760@qq.com","757624760@qq.com","zw","test");
    }

}
