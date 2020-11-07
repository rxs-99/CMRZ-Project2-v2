package com.revature.web;

/**
 * This class is not needed. Was trying to use this class with
 * @Configuration and @EnableWebMvc so that i did not have
 * to configure the interceptor in the dispatcherContext.xml
 * but it did not work. So, i opted to use the xml configuration.
 * I left it here so that i could come back and try again 
 * to use the java config instead of xml config
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())/**.addPathPatterns("/**").excludePathPatterns("/login/**")/**/;
    }
}
