package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TrafficLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestInfo = String.format("Log request infos: %s from %s at %s", req.getRequestURI(),
                req.getRemoteAddr(), "" + System.currentTimeMillis());
        System.out.println(requestInfo);

        // chain 은 필터가 순서대로 체이닝 된다는 의미이다.
        // 상단에 설정한 Order 의 순서대로 체이닝이 일어나며, 들어갔다가 나오는 순서대로 처리된다.
        chain.doFilter(request, response);

        HttpServletResponse res = (HttpServletResponse) response;
        String responseInfo = String.format("Log Response infos: %s at %s.", res.getStatus(),
                System.currentTimeMillis());
        System.out.println(responseInfo);

    }
}