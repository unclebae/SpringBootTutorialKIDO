package com.example.demo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class RestResponseStatusExceptionResolver extends DefaultHandlerExceptionResolver {

  @Autowired
  private MappingJackson2JsonView jsonView;

  @Override
  protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
      Exception ex) {
    try {
      if (ex instanceof RuntimeException) {
        return handleIllegalArgument((RuntimeException) ex, request, response, handler);
      }
    } catch (Exception handlerException) {
      logger.warn("Handling of [" + ex.getClass().getName() + "]  resulted in Exception", handlerException);
    }
    return null;
  }

  private ModelAndView handleIllegalArgument(RuntimeException ex, HttpServletRequest request,
      HttpServletResponse response, Object handler) throws IOException {
    String accept = request.getHeader(HttpHeaders.ACCEPT);
    System.out.println("------------ 0101: " + accept);

    ModelAndView mav = new ModelAndView(jsonView);
    mav.addObject("error", ex.getMessage());
    mav.addObject("request", request.getRequestURI());

    return mav;
  }
}
