package com.hq.simpleblog.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 23:17
 **/
@Configuration
@Log4j2
public class MyCorsConfig implements WebMvcConfigurer {

    @Value("${accessControlAllowOrigins}")
    private String[] accessControlAllowOrigins;

    static final String[] ORIGINS = new String[]{"OPTIONS", "GET", "POST", "PUT", "DELETE"};

    /**
     * 处理跨域
     *
     * @param registry 配置类
     * @author HQ
     * @since 2020/3/26 23:19
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        for (String accessControlAllowOrigin : accessControlAllowOrigins) {
            log.info("跨域处理：" + accessControlAllowOrigin);
        }
        registry.addMapping("/**").allowedOrigins(accessControlAllowOrigins).allowCredentials(true).allowedMethods(ORIGINS);
    }

    /**
     * 允许请求携带 cookie
     *
     * @author HQ
     * @since 2020/3/26 23:19
     **/
    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName("token");
        cookieSerializer.setUseHttpOnlyCookie(false);
        cookieSerializer.setSameSite(null);
        return cookieSerializer;
    }

}
