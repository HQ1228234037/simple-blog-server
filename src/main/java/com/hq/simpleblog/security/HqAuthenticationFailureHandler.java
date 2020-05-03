package com.hq.simpleblog.security;

import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.utils.WebUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录失败处理器
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:36
 **/
@Component
public class HqAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(Code.LoginFailure);
        if (exception instanceof BadCredentialsException) {
            resultVo.getData().put("message", "用户名或密码错误");
        } else if (exception instanceof LockedException) {
            resultVo.getData().put("message", "账号被锁定");
        } else {
            resultVo.getData().put("message", exception.getMessage());
        }
        WebUtils.write(response, resultVo);
    }
}
