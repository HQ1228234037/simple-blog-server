package com.hq.simpleblog.security;

import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.utils.WebUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录处理器
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:42
 **/
public class HqLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public HqLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Code.NotLogin);
        WebUtils.write(response, resultVO);
    }
}
