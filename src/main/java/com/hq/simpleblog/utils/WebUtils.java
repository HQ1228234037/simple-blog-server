package com.hq.simpleblog.utils;

import com.alibaba.fastjson.JSONObject;
import com.hq.simpleblog.vo.ResultVO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * web 工具类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:34
 **/
@Log4j2
public class WebUtils {

    /**
     * 返回信息
     *
     * @author HQ
     * @since 2020/3/22 22:35
     **/
    public static void write(HttpServletResponse response, ResultVO resultVo) {
        try {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSONObject.toJSONString(resultVo));
            response.getWriter().close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
