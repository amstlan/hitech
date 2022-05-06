package com.hitech.hitech.config;

import com.hitech.hitech.intercaptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//拦截器注册
@Configuration //加载配置
public class LoginInterceptorConfig implements WebMvcConfigurer {
    //创建自定义的拦截器对象
    HandlerInterceptor interceptor = new LoginInterceptor();


    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置不拦截路径的List集合
        List<String> patterns = new ArrayList<>();
        //css.js,样式图片等等，全都不拦截
        patterns.add("/assets/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        //部分页面不拦截
        patterns.add("/register");
        patterns.add("/login");
        patterns.add("/log");
        patterns.add("/reg");
        patterns.add("/index");
        patterns.add("/product");
        //最基本的注册和登录请求不拦截
        patterns.add("/registration");
        patterns.add("/login");
        patterns.add("/");
        patterns.add("/teat");
        patterns.add("/teat");
        patterns.add("/upload");
        patterns.add("/upfile");
        patterns.add("/admin_login_reg");
        patterns.add("/admin_login");

                //完成拦截器注册
        registry.addInterceptor(interceptor).addPathPatterns("/**")//拦截那些路径
                .excludePathPatterns(patterns);                            //除这些路径不拦截
    }
}
