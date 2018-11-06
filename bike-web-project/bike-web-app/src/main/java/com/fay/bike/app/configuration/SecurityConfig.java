package com.fay.bike.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.PrintWriter;

/**
 * Security configuration.
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PERMIT_URLS = new String[]{
            "/index/index","/index/test",
            // 静态页面无需权限
            "/js/*", "/css/*", "/img/*"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/app/**").hasRole("APP")
                .antMatchers("/h5/**").hasRole("H5")
                .antMatchers("/backend/**").hasRole("BK")
                .anyRequest().denyAll()
                .and().exceptionHandling().accessDeniedHandler(deniedHandler())
                .and().formLogin().disable().csrf().disable().httpBasic();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(PERMIT_URLS);
    }

    private AccessDeniedHandler deniedHandler() {
        return (request, response, exception) -> {
            response.setHeader("content-type", "application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("{\n" +
                    "\"code\": 401,\n" +
                    "\"data\": \"\",\n" +
                    "\"msg\": \"登录已失效,请重新登录\",\n" +
                    "\"success\": true\n" +
                    "}");
            writer.flush();
            writer.close();
        };
    }

}