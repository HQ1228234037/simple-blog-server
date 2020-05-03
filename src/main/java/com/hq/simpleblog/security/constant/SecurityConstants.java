package com.hq.simpleblog.security.constant;

/**
 * spring security 常量类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 21:48
 **/
public class SecurityConstants {

    /**
     * 登录 URI
     *
     * @since 2020/3/26 22:29
     **/
    public final static String LOGIN_URI = "/api/login";

    /**
     * 登出 URI
     *
     * @since 2020/3/26 22:29
     **/
    public final static String LOGOUT_URI = "/api/logout";

    /**
     * 图片验证码存储key
     *
     * @since 2020/3/26 22:28
     **/
    public final static String IMAGE_CODE_KEY = "imageCode";

}
