package com.hq.simpleblog.aop;

import com.alibaba.fastjson.JSON;
import com.hq.simpleblog.entity.Log;
import com.hq.simpleblog.entity.UserEntity;
import com.hq.simpleblog.mapper.UserMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * aop 获取日志
 *
 * @author HQ
 * @since 2020/4/13 下午8:52
 **/
public class LogUtils {

    public static Log getLog(ProceedingJoinPoint proceedingJoinPoint, UserMapper userMapper) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        // 获取请求参数
        Object[] args = proceedingJoinPoint.getArgs();

        // 请求参数转 json 字符串
        StringBuilder requestParams = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i == (args.length - 1)) {
                if (args[i].getClass().getSimpleName().equals("StandardMultipartFile")) {
                    requestParams.append(((MultipartFile) args[i]).getOriginalFilename());
                } else {
                    requestParams.append(JSON.toJSONString(args[i]));
                }
            } else {
                if (args[i].getClass().getSimpleName().equals("StandardMultipartFile")) {
                    requestParams.append(((MultipartFile) args[i]).getOriginalFilename()).append(",");
                } else {
                    requestParams.append(JSON.toJSONString(args[i])).append(",");
                }
            }
        }

        // 请求方法
        StringBuilder requestMethod = new StringBuilder();
        // 类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        requestMethod.append(className).append(".").append(methodName).append("(");
        for (int i = 0; i < args.length; i++) {
            if (i == (args.length - 1)) {
                requestMethod.append(args[i].getClass().getSimpleName());
            } else {
                requestMethod.append(args[i].getClass().getSimpleName()).append(",");
            }
        }
        requestMethod.append(")");

        // 记录操作日志
        Log operationLog = new Log();
        // 登录用户
        if (!"anonymousUser".equals(authentication.getPrincipal())) {
            UserEntity user = userMapper.getUserByEmail(authentication.getName());
            operationLog.setUserId(user.getUserId());
            operationLog.setUserEmail(user.getEmail());
        }
        // uri
        operationLog.setRequestUri(request.getRequestURI());
        // 通过 nginx 反向代理后，获取该请求头得到用户 ip
        Enumeration<String> enumeration = request.getHeaders("X-Forwarded-For");
        StringBuilder ips = new StringBuilder();
        while (enumeration.hasMoreElements()) {
            ips.append(enumeration.nextElement());
        }
        operationLog.setIp(ips.toString());
        // 请求方法
        operationLog.setRequestMethod(requestMethod.toString());
        // 请求参数
        operationLog.setRequestParams(requestParams.toString());
        return operationLog;
    }

}
