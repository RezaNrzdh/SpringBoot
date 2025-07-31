package com.rezanrzdh.springboot.services.reflections;

import org.springframework.stereotype.Service;

@Service
public class ReflectionService {

    private Integer age = 36;
    private String name = "reza";

    public ReflectionService() {}

    public ReflectionService(Integer age, String name) {}

    public void getNumber() {
        System.out.println(17);
    }

    public void getName() {
        System.out.println("RezaNrzdh");
    }
}
