package com.hq.simpleblog.security.code;

import com.hq.simpleblog.exception.ImageCodeException;
import com.hq.simpleblog.security.constant.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图片验证码过滤器
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 22:27
 **/
@Component
public class ImageCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private final AuthenticationFailureHandler authenticationFailureHandler;

    public ImageCodeFilter(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (StringUtils.equalsAnyIgnoreCase(requestURI, SecurityConstants.LOGIN_URI)) {
            ImageCode imageCode = (ImageCode) request.getSession().getAttribute(SecurityConstants.IMAGE_CODE_KEY);
            if (validate(request, response, imageCode)) {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 校验验证码是否正确
     *
     * @param imageCode session中保存的验证码
     * @author HQ
     * @since 2020/3/26 22:29
     **/
    private boolean validate(HttpServletRequest request, HttpServletResponse response, ImageCode imageCode) throws IOException, ServletException {
        if (imageCode == null) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, new ImageCodeException("验证码不存在"));
            return false;
        }
        if (imageCode.isExpire()) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, new ImageCodeException("验证码已过期"));
            return false;
        }
        String code = request.getParameter(SecurityConstants.IMAGE_CODE_KEY);
        if (StringUtils.isBlank(code)) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, new ImageCodeException("验证码不能为空"));
            return false;
        }
        if (StringUtils.equalsAnyIgnoreCase(code, imageCode.getCode())) {
            request.getSession().removeAttribute(SecurityConstants.IMAGE_CODE_KEY);
            return true;
        } else {
            authenticationFailureHandler.onAuthenticationFailure(request, response, new ImageCodeException("验证码错误"));
            return false;
        }
    }

}
