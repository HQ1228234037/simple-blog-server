package com.hq.simpleblog.security;

import com.hq.simpleblog.entity.UserEntity;
import com.hq.simpleblog.service.UserService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.utils.WebUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:30
 **/
@Component
public class HqAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 获取用户信息
        String email = authentication.getName();
        UserEntity userEntity = userService.getByEmail(email);
        userEntity.setPassword(null);

        // 返回登录成功
        ResultVO resultVO = new ResultVO();
        resultVO.setData(JSONUtils.getJSONObject(userEntity));
        WebUtils.write(response, resultVO);
    }
}
