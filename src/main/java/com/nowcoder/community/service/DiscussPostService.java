package com.nowcoder.community.service;

import com.nowcoder.community.dao.DisscusPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    DisscusPostMapper disscusPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return disscusPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return disscusPostMapper.selectDiscussPostRows(userId);
    }
}
