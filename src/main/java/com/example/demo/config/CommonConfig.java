package com.example.demo.config;

import java.util.List;

import com.example.demo.binds.argresolver.SKFamilyArgumentResolver;
import com.example.demo.binds.converter.FamilyTypeConverter;
import com.example.demo.binds.converter.StringToLocalDateTimeConverter;
import com.example.demo.common.RestResponseStatusExceptionResolver;
import com.example.demo.filters.SecondFilter;
import com.example.demo.filters.TrafficLogFilter;
import com.example.demo.hooks.GreetingInterceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableAspectJAutoProxy
public class CommonConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<TrafficLogFilter> trafficLogFilter() {
        FilterRegistrationBean<TrafficLogFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TrafficLogFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilter() {
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SecondFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SKFamilyArgumentResolver());
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).addPathPatterns("/*").excludePathPatterns("/except/*");
    }

    public void addFormatter(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateTimeConverter());
        registry.addConverter(new FamilyTypeConverter());
    }

    @Bean
    public HandlerExceptionResolver createRestResponseStatusExceptionResolver() {
        RestResponseStatusExceptionResolver resolver = new RestResponseStatusExceptionResolver();
        return resolver;
    }

    @Bean
    public MappingJackson2JsonView createMappingJsonView() {
        return new MappingJackson2JsonView();
    }
}