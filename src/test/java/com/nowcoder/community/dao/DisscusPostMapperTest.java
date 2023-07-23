package com.nowcoder.community.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DisscusPostMapperTest {
    @Autowired
    DisscusPostMapper disscusPostMapper;

    @Test
    void selectDiscussPosts() {
        var res = disscusPostMapper.selectDiscussPosts(101, 0, 10);
        assertThat(res).isNotNull();
        assertThat(res.size()).isEqualTo(10);
    }

    @Test
    void selectDiscussPostRows() {
        var res = disscusPostMapper.selectDiscussPostRows(132);
        assertThat(res).isNotNull();
        assertThat(res).isEqualTo(2);
    }
}