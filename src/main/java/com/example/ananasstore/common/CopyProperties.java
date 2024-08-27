package com.example.ananasstore.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyProperties {
    public static final String SETMETHOD = "set";
    public static final String GETMETHOD = "get";

    public static void copy(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        for(Field sourcefield : sourceFields) {

            String fieldName = sourcefield.getName();
            try {
                //check exist field target
                targetClass.getDeclaredField(fieldName);


                //handle copy
                char firstChar = Character.toUpperCase(fieldName.charAt(0));
                // create method name
                String getterAttribute = GETMETHOD + firstChar + fieldName.substring(1);
                String setterAttribute = SETMETHOD + firstChar + fieldName.substring(1);

                //create paramtype of method
                Class<?> paramType =  sourcefield.getType();

                Method methodGet = sourceClass.getMethod(getterAttribute);
                Object value = methodGet.invoke(source);

                Method methodSet = targetClass.getMethod(setterAttribute, paramType);
                methodSet.invoke(target, value);

            } catch (NoSuchFieldException e) {
                continue;
            } catch (NoSuchMethodException e) {
                // khong get duoc method trong class
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
