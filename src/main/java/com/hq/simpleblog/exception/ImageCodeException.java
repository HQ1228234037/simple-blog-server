package com.hq.simpleblog.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义图片验证码异常类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 22:31
 **/
public class ImageCodeException extends AuthenticationException {

    public ImageCodeException(String explanation) {
        super(explanation);
    }

}
