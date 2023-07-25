package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class LoginTicketMapperTest {

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    int res;

    @BeforeEach
    void insertRow() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("bkreKhHGKhgsaBgasdRB");
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 3));
        loginTicket.setStatus(0);

        res = loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    void insertLoginTicket() {
        assertThat(res).isNotZero();
    }

    @Test
    void selectByTicket() {
        LoginTicket loginTicket1 = loginTicketMapper.selectByTicket("bkreKhHGKhgsaBgasdRB");
        assertThat(loginTicket1.getUserId()).isEqualTo(101);
    }

    @Test
    void updateStatus() {
        LoginTicket res = loginTicketMapper.selectByTicket("bkreKhHGKhgsaBgasdRB");
        assertThat(res.getUserId()).isEqualTo(101);
        assertThat(res.getStatus()).isEqualTo(0);

        int res1 = loginTicketMapper.updateStatus("bkreKhHGKhgsaBgasdRB", 1);
        assertThat(res1).isEqualTo(1);
    }
}