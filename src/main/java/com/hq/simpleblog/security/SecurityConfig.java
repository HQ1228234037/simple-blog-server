package com.hq.simpleblog.security;

import com.hq.simpleblog.security.code.ImageCodeFilter;
import com.hq.simpleblog.security.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * spring security配置类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 21:45
 **/
@Configuration
// 开启权限注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsServiceImpl;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private ImageCodeFilter imageCodeFilter;
    @Autowired
    private DataSource dataSource;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 添加记住我功能
     *
     * @author HQ
     * @since 2020/3/26 22:34
     **/
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        // 启动创建数据表，第一次启动打开
//        tokenRepositoryImpl.setCreateTableOnStartup(true);
        return tokenRepositoryImpl;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 自定义密码加密方式
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .formLogin()
                // 自定义登录接口
                .loginProcessingUrl(SecurityConstants.LOGIN_URI)
                // 登录成功处理
                .successHandler(authenticationSuccessHandler)
                // 登录失败处理
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout()
                // 自定义登出接口
                .logoutUrl(SecurityConstants.LOGOUT_URI)
                // 登出成功处理
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                // 记住我功能
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                // 过期时间：一周
                .tokenValiditySeconds(604800)
                .and()
                .exceptionHandling()
                // 未登录处理
                .authenticationEntryPoint(new HqLoginUrlAuthenticationEntryPoint(SecurityConstants.LOGIN_URI))
                // 无权限处理
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                // 添加过滤器校验验证码是否正确
                .addFilterBefore(imageCodeFilter, UsernamePasswordAuthenticationFilter.class)
                // 启用资源跨域共享
                .cors()
                .and()
                // 关闭csrf保护
                .csrf().disable();
    }
}
