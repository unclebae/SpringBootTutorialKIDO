package com.example.demo.binds.argresolver;

import com.example.demo.binds.converter.FamilyType;

public class SKFamilyInfo {
    private FamilyType familyType;
    private String userId;
    private String name;

    public FamilyType getFamilyType() {
        return familyType;
    }

    public void setFamilyType(FamilyType familyType) {
        this.familyType = familyType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SKFamilyInfo [familyType=" + familyType + ", name=" + name + ", userId=" + userId + "]";
    }

    public SKFamilyInfo(FamilyType familyType, String userId, String name) {
        this.familyType = familyType;
        this.userId = userId;
        this.name = name;
    }

    public SKFamilyInfo() {

    }

}