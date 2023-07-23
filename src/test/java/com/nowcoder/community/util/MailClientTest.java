package com.nowcoder.community.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailClientTest {
    @Autowired
    MailClient mailClient;

    @Test
    void sendSimpleMail() {
        mailClient.sendSimpleMail("zhouhjdev@126.com", "spring mail test", "这是从Spring客户端发来的一封邮件");
    }
}