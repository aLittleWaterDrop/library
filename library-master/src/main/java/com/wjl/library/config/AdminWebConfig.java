package com.wjl.library.config;

import com.wjl.library.intercept.LoginIntercept;
import com.wjl.library.intercept.TourIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 这是
 * @create 2022-02-21 14:56
 */
@Configuration
//@ServletComponentScan(basePackages = "com.wjl.library")
public class AdminWebConfig implements WebMvcConfigurer {

    //解决拦截器无法调用services的问题
    @Bean
    public LoginIntercept getLoginIntercept() {
        return new LoginIntercept();
    }

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercept())
                .addPathPatterns("/**")//逻辑所有请求
                .excludePathPatterns("/", "/index", "/login2", "/login", "/manager", "/hot", "/sort", "/sortBook/**",
                        "/css/**", "/fonts/**", "/images/**", "/js/**", "/favicon.ico", "/bootstrap/**");//放行

        registry.addInterceptor(new TourIntercept())
                .addPathPatterns("/", "/index", "/hot", "/sort", "/sortBook/**");
    }
}
