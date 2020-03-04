package com.ks.qianjiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QianjiangApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianjiangApplication.class, args);
    }

}
