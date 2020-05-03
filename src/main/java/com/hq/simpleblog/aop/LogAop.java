package com.hq.simpleblog.aop;

import com.alibaba.fastjson.JSON;
import com.hq.simpleblog.entity.Log;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.UserMapper;
import com.hq.simpleblog.vo.ResultVO;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 日志记录
 *
 * @author HQ
 * @since 2020/4/13 下午8:51
 **/
@Aspect
@Component
@Log4j2
public class LogAop {

    @Autowired
    private UserMapper userMapper;

    @Pointcut("execution(public * com.hq.simpleblog.controller.*.*(..)) && !execution(public * com.hq.simpleblog.controller.CodeController.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public ResultVO around(ProceedingJoinPoint proceedingJoinPoint) {
        Log operationLog = LogUtils.getLog(proceedingJoinPoint, userMapper);

        try {
            // 执行方法
            Object result = proceedingJoinPoint.proceed();
            // 记录返回结果
            operationLog.setResponseParams(JSON.toJSONString(result));
            // 打印日志请求信息
            log.info(JSON.toJSONString(operationLog));
            return (ResultVO) result;
        } catch (Throwable throwable) {
            // 获取异常详细信息
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            throwable.printStackTrace(writer);
            StringBuffer errorData = stringWriter.getBuffer();
            operationLog.setErrorData(throwable.getMessage() + ": " + errorData);

            ResultVO resultVO = new ResultVO();
            resultVO.setCode(Code.Error);
            operationLog.setResponseParams(JSON.toJSONString(resultVO));

            // 打印日志请求信息
            log.error(JSON.toJSONString(operationLog));

            return resultVO;
        }
    }

}
