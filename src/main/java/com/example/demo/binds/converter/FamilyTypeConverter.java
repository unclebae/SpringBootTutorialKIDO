package com.example.demo.binds.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FamilyTypeConverter implements Converter<String, FamilyType> {

    @Override
    public FamilyType convert(String source) {
        System.out.println("FamilyType: " + source);
        return FamilyType.valueOf(source);
    }

}