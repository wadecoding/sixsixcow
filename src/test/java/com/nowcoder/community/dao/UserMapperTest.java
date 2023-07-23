package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void selectById() {
        User user = userMapper.selectById(1);
        assertThat(user.getUsername()).isEqualTo("SYSTEM");
        assertThat(user.getEmail()).isEqualTo("nowcoder1@sina.com");
        assertThat(user.getType()).isEqualTo(0);
    }

    @Test
    void selectByName() {
        User user = userMapper.selectByName("nowcoder11");
        assertThat(user.getId()).isEqualTo(11);
        assertThat(user.getType()).isEqualTo(1);
        assertThat(user.getEmail()).isEqualTo("nowcoder11@sina.com");
    }

    @Test
    void selectByEmail() {
        User user = userMapper.selectByEmail("nowcoder25@sina.com");
        assertThat(user.getId()).isEqualTo(25);
        assertThat(user.getUsername()).isEqualTo("nowcoder25");
        assertThat(user.getType()).isEqualTo(2);
    }

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("userROOT");
        user.setPassword("9856E9B8693DA16711FFACAC3ED9F549");
        user.setSalt("49f10");
        user.setEmail("root.user@nowcoder.com");
        user.setType(2);
        user.setStatus(1);
        user.setActivationCode("");
        user.setHeaderUrl("http://images.nowcoder.com/head/45t.png");
        user.setCreateTime(new Date());
        int res = userMapper.insertUser(user);
        assertThat(res).isNotZero();
    }

    @Test
    void updateStatus() {
        User user = userMapper.selectById(101);
        assertThat(user.getStatus()).isEqualTo(1);
        int res = userMapper.updateStatus(101, 0);
        assertThat(res).isNotZero();
        User user1 = userMapper.selectById(101);
        assertThat(user1.getStatus()).isEqualTo(0);
    }

    @Test
    void updateHeader() {
        User user = userMapper.selectById(1);
        assertThat(user.getUsername()).isEqualTo("SYSTEM");
        assertThat(user.getHeaderUrl()).isEqualTo("http://static.nowcoder.com/images/head/notify.png");
        int res = userMapper.updateHeader(1, "http://images.nowcoder.com/head/834t.png");
        assertThat(res).isNotZero();
        User user1 = userMapper.selectById(1);
        assertThat(user1.getUsername()).isEqualTo("SYSTEM");
        assertThat(user1.getHeaderUrl()).isEqualTo("http://images.nowcoder.com/head/834t.png");
    }

    @Test
    void updatePassword() {
        User user = userMapper.selectById(149);
        assertThat(user.getSalt()).isEqualTo("90196");
        assertThat(user.getPassword()).isEqualTo("ebce124c4ba2de3be92dc9a3bc1ea75b");
        int res = userMapper.updatePassword(149, "B92FC525E40CFF84D3BD9B174FE2DC62");
        assertThat(res).isNotZero();
        User user1 = userMapper.selectById(149);
        assertThat(user1.getPassword()).isEqualTo("B92FC525E40CFF84D3BD9B174FE2DC62");
    }
}