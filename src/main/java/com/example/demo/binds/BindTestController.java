package com.example.demo.binds;

import java.time.LocalDateTime;

import com.example.demo.binds.argresolver.SKFamily;
import com.example.demo.binds.argresolver.SKFamilyInfo;
import com.example.demo.binds.converter.FamilyType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BindTestController {

    @GetMapping("/bind/{date}")
    public ResponseEntity<String> stringToLocalDateTimeTest(@PathVariable("date") LocalDateTime time) {
        System.out.println("LocalDateTime: " + time);
        return new ResponseEntity<String>(time.toString(), HttpStatus.OK);

    }

    @GetMapping("/bind/familytype/{type}")
    public ResponseEntity<String> stringToEnumTest(@PathVariable("type") FamilyType familyType) {
        System.out.println("FamilyType: " + familyType);
        return new ResponseEntity<>(familyType.toString(), HttpStatus.OK);
    }

    @PostMapping("/bind/family/info")
    public ResponseEntity<String> parameterToObject(@RequestBody SKFamilyInfo familyInfo) {
        System.out.println(familyInfo);
        return new ResponseEntity<>(familyInfo.toString(), HttpStatus.OK);
    }

    @PostMapping("/bind/family/info2")
    public ResponseEntity<String> parameterToObject2(@SKFamily SKFamilyInfo familyInfo) {
        System.out.println(familyInfo);
        return new ResponseEntity<>(familyInfo.toString(), HttpStatus.OK);
    }
}
