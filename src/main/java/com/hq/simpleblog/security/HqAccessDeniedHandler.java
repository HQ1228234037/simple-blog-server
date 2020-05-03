package com.hq.simpleblog.security;

import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.utils.WebUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限处理器
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:46
 **/
@Component
public class HqAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Code.AccessDenied);
        WebUtils.write(httpServletResponse, resultVO);
    }

}
