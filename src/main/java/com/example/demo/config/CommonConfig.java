package com.example.demo.config;

import com.example.demo.filters.SecondFilter;
import com.example.demo.filters.TrafficLogFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

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
}