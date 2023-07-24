package com.nowcoder.community.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailClientTest {
    @Autowired
    MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void sendSimpleMail() {
        mailClient.sendSimpleMail("zhouhjdev@126.com", "spring mail test", "这是从Spring客户端发来的一封邮件");
    }

    @Test
    void sendTemplateMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendSimpleMail("zhouhjdev@126.com", "HTML模板邮件测试", content);
    }
}