/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ClassUtil {
    public static String internalNameToExternal(String string) {
        if (string.length() == 1) {
            switch (string.charAt(0)) {
                case 'V': {
                    return "void";
                }
                case 'Z': {
                    return "boolean";
                }
                case 'C': {
                    return "char";
                }
                case 'B': {
                    return "byte";
                }
                case 'S': {
                    return "short";
                }
                case 'I': {
                    return "int";
                }
                case 'J': {
                    return "long";
                }
                case 'F': {
                    return "float";
                }
                case 'D': {
                    return "double";
                }
            }
            throw new IllegalArgumentException("invalid type name: " + string);
        }
        int n = string.lastIndexOf("[") + 1;
        String string2 = "";
        for (int i = 0; i < n; ++i) {
            string2 = string2 + "[]";
        }
        if (n > 0) {
            string = string.substring(n);
        }
        if (string.startsWith("L")) {
            string = string.substring(1, string.length() - 1);
            string = string.replace('/', '.');
        } else {
            string = ClassUtil.internalNameToExternal(string);
        }
        return string + string2;
    }

    public static Method[] getAllMethods(Class<?> clazz) {
        if (clazz == null) {
            return new Method[0];
        }
        Method[] methodArray = clazz.getDeclaredMethods();
        Method[] methodArray2 = ClassUtil.getAllMethods(clazz.getSuperclass());
        ArrayList<Method> arrayList = new ArrayList<Method>(methodArray.length + methodArray2.length);
        arrayList.addAll(Arrays.asList(methodArray));
        for (Method method : methodArray2) {
            if (ClassUtil.isOverridden(method, methodArray)) continue;
            arrayList.add(method);
        }
        return arrayList.toArray(new Method[arrayList.size()]);
    }

    public static Method[] getAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> clazz2) {
        Method[] methodArray = ClassUtil.getAllMethods(clazz);
        ArrayList<Method> arrayList = new ArrayList<Method>();
        for (Method method : methodArray) {
            if (method.getAnnotation(clazz2) == null) continue;
            arrayList.add(method);
        }
        return arrayList.toArray(new Method[arrayList.size()]);
    }

    public static boolean isOverridden(Method method, Method[] methodArray) {
        for (Method method2 : methodArray) {
            if (!method2.getName().equals(method.getName()) || !Arrays.equals(method2.getParameterTypes(), method.getParameterTypes())) continue;
            return true;
        }
        return false;
    }
}

