package com.example.demo.binds.argresolver;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.binds.converter.FamilyType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class SKFamilyArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(SKFamily.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
         System.out.println("--->>>>> 11");
         HttpServletRequest request = (HttpServletRequest)
         webRequest.getNativeRequest();

         StringBuffer jb = new StringBuffer();
         String line = null;

         try {
            BufferedReader reader = request.getReader();
         while ((line = reader.readLine()) != null)
            jb.append(line);
         } catch (Exception e) {
             System.out.println(e);
         }

        String body = jb.toString();
        System.out.println("--->>>>> " + body);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(body);
        final String familyTypeStr = actualObj.get("familyType").asText();
        final String userId = actualObj.get("userId").asText();
        final String name = actualObj.get("name").asText();

        return new SKFamilyInfo(FamilyType.valueOf(familyTypeStr), userId, name);
    }

}