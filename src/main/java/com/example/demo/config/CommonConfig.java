package com.example.demo.config;

import com.example.demo.filters.SecondFilter;
import com.example.demo.filters.TrafficLogFilter;
import com.example.demo.hooks.GreetingInterceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<TrafficLogFilter> trafficLogFilter() {
        FilterRegistrationBean<TrafficLogFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TrafficLogFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilter() {
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SecondFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).addPathPatterns("/*").excludePathPatterns("/except/*");
    }
}