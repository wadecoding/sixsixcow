package com.nowcoder.community.util;

// todo: 枚举类或什么
public interface CommunityConstant {
    // 激活账号相关
    int ACTIVATION_SUCCESS = 0;
    int ACTIVATION_REPEAT = 1;
    int ACTIVATION_FAILURE = 2;

    // 登录凭证超时时间
    int REMEMBER_EXPIRED_SECONDS = 3600 * 12 * 30;
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;
}
