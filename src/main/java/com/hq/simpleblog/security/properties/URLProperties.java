package com.hq.simpleblog.security.properties;

import lombok.Data;

/**
 * spring security URL 配置类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:26
 **/
@Data
public class URLProperties {

    private String loginUrl = "/api/login";

    private String logoutUrl = "/api/logout";

}
