package com.example.demo.binds.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String source) {
        System.out.println("--------- Source : " + source);
        // ISO 8601을 이용하여 스트링을 날짜로 변경하는 처리하는 컨버터.
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

}