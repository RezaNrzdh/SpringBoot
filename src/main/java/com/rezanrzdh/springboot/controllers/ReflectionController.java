package com.rezanrzdh.springboot.controllers;

import com.rezanrzdh.springboot.services.reflections.ReflectionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@RestController
@RequestMapping("reflections")
public class ReflectionController {

    @GetMapping("class")
    public void getClassRuntime() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");

        for(Method m : clazz.getMethods()) {
            System.out.println(m.getName());
        }
    }

    @GetMapping("object")
    public void createObjectOnClass() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println(obj.toString());
    }

    @GetMapping("field")
    public void accessPrivateFields() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        for(Field f: clazz.getDeclaredFields()) {
            System.out.println(f.getName());
            f.setAccessible(true);
            String a = f.get(obj).toString();
            System.out.println(a);
        }
    }

    @GetMapping("method")
    public void getMethods() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method[] m = obj.getClass().getMethods();

        for(Method method : m){
            if(method.getName().equals("getNumber")) {
                method.invoke(obj);
            }
        }
    }

    @GetMapping("annotation")
    public void readAnnotations() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");
        if(clazz.isAnnotationPresent(Service.class)){
            System.out.println("YES");
        }
        else
            System.out.println("NO");

    }

    @GetMapping("constructor")
    public void checkConstructors() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.rezanrzdh.springboot.services.reflections.ReflectionService");
        Constructor<?>[] constructor = clazz.getDeclaredConstructors();

        for(Constructor<?> c : constructor){
            System.out.println(c);
        }
    }
}
