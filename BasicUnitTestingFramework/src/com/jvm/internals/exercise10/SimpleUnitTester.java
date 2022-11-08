package com.jvm.internals.exercise10;
import java.lang.reflect.Method;

public class SimpleUnitTester {
    public static void main(String[] args) throws Exception {
        Class reflectionClass = Reflection.class;
        System.out.println("Number of failures: " + execute(reflectionClass));
    }

    public static int execute(Class clazz) throws Exception {
        int failedCount = 0;
        Method[] methodsArray = clazz.getDeclaredMethods();

        for (Method method : methodsArray) {
            if (method.getName().startsWith("test") && method.getReturnType() == boolean.class) {
                failedCount++;
            }
        }
        return failedCount;
    }
}

