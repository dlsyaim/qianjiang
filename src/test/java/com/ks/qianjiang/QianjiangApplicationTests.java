package com.ks.qianjiang;

import com.ks.qianjiang.bll.MailBLL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QianjiangApplicationTests {

    @Autowired
    MailBLL mailBLL;
    @Test
    public void contextLoads() {
        //测试
        System.out.println("sb");
        mailBLL.sendSimpleMail("757624760@qq.com","757624760@qq.com","757624760@qq.com","757624760@qq.com","757624760@qq.com");

    }

}
