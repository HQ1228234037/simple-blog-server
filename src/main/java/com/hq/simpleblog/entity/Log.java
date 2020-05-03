package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体类
 *
 * @author HQ
 * @since 2020/4/13 下午8:50
 **/
@Data
public class Log implements Serializable {

    private Long logId;

    private Long userId;

    private String userEmail;

    private String ip;

    private String requestUri;

    private String requestMethod;

    private String requestParams;

    private String responseParams;

    private String errorData;

    private Boolean deleted;

    private Date createDate;

    private Date updateDate;

}