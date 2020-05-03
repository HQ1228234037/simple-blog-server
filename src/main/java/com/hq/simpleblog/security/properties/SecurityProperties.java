package com.hq.simpleblog.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring security 自定义配置类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 22:18
 **/
@ConfigurationProperties(prefix = "hq.security")
@Data
public class SecurityProperties {

    private URLProperties url = new URLProperties();

}
