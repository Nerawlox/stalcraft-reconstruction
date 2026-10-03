/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import codechicken.lib.asm.ObfMapping;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionManager {
    public static HashMap<Class<?>, Class<?>> primitiveWrappers = new HashMap();

    public static boolean isInstance(Class<?> clazz, Object object) {
        Class<?> clazz2 = primitiveWrappers.get(clazz);
        if (clazz2 != null) {
            if (clazz2 == Long.class && Long.class.isInstance(object)) {
                return true;
            }
            if ((clazz2 == Long.class || clazz2 == Integer.class) && Integer.class.isInstance(object)) {
                return true;
            }
            if ((clazz2 == Long.class || clazz2 == Integer.class || clazz2 == Short.class) && Short.class.isInstance(object)) {
                return true;
            }
            if ((clazz2 == Long.class || clazz2 == Integer.class || clazz2 == Short.class || clazz2 == Byte.class) && Integer.class.isInstance(object)) {
                return true;
            }
            if (clazz2 == Double.class && Double.class.isInstance(object)) {
                return true;
            }
            if ((clazz2 == Double.class || clazz2 == Float.class) && Float.class.isInstance(object)) {
                return true;
            }
            return clazz2.isInstance(object);
        }
        return clazz.isInstance(object);
    }

    public static Class<?> findClass(String string) {
        return ReflectionManager.findClass(string, true);
    }

    public static boolean classExists(String string) {
        return ReflectionManager.findClass(string, false) != null;
    }

    public static Class<?> findClass(String string, boolean bl) {
        try {
            return Class.forName(string, bl, ReflectionManager.class.getClassLoader());
        }
        catch (ClassNotFoundException classNotFoundException) {
            try {
                return Class.forName("net.minecraft.src." + string, bl, ReflectionManager.class.getClassLoader());
            }
            catch (ClassNotFoundException classNotFoundException2) {
                return null;
            }
        }
    }

    public static void setField(Class<?> clazz, Object object, String string, Object object2) throws IllegalAccessException, IllegalArgumentException {
        ReflectionManager.setField(clazz, object, new String[]{string}, object2);
    }

    public static void setField(Class<?> clazz, Object object, String[] stringArray, Object object2) throws IllegalAccessException, IllegalArgumentException {
        for (Field field : clazz.getDeclaredFields()) {
            boolean bl = false;
            for (String string : stringArray) {
                if (!field.getName().equals(string)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            field.setAccessible(true);
            field.set(object, object2);
            return;
        }
    }

    public static void setField(Class<?> clazz, Object object, int n, Object object2) throws IllegalAccessException, IllegalArgumentException {
        Field field = clazz.getDeclaredFields()[n];
        field.setAccessible(true);
        field.set(object, object2);
    }

    public static void callMethod(Class<?> clazz, String string, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReflectionManager.callMethod(clazz, null, new String[]{string}, objectArray);
    }

    public static void callMethod(Class<?> clazz, String[] stringArray, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReflectionManager.callMethod(clazz, null, stringArray, objectArray);
    }

    public static void callMethod(Class<?> clazz, Object object, String string, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReflectionManager.callMethod(clazz, null, object, new String[]{string}, objectArray);
    }

    public static void callMethod(Class<?> clazz, Object object, String[] stringArray, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReflectionManager.callMethod(clazz, null, object, stringArray, objectArray);
    }

    public static <R> R callMethod(Class<?> clazz, Class<R> clazz2, String string, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return ReflectionManager.callMethod(clazz, clazz2, null, new String[]{string}, objectArray);
    }

    public static <R> R callMethod(Class<?> clazz, Class<R> clazz2, String[] stringArray, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return ReflectionManager.callMethod(clazz, clazz2, null, stringArray, objectArray);
    }

    public static <R> R callMethod(Class<?> clazz, Class<R> clazz2, Object object, String string, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return ReflectionManager.callMethod(clazz, clazz2, object, new String[]{string}, objectArray);
    }

    public static <R> R callMethod(Class<?> clazz, Class<R> clazz2, Object object, String[] stringArray, Object ... objectArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        block0: for (Method method : clazz.getDeclaredMethods()) {
            boolean bl = false;
            Object[] objectArray2 = stringArray;
            int n = objectArray2.length;
            for (int i = 0; i < n; ++i) {
                String string = objectArray2[i];
                if (!method.getName().equals(string)) continue;
                bl = true;
                break;
            }
            if (!bl || (objectArray2 = method.getParameterTypes()).length != objectArray.length) continue;
            for (n = 0; n < objectArray.length; ++n) {
                if (!ReflectionManager.isInstance(objectArray2[n], objectArray[n])) continue block0;
            }
            method.setAccessible(true);
            return (R)method.invoke(object, objectArray);
        }
        return null;
    }

    public static <T> T getField(Class<?> clazz, Class<T> clazz2, Object object, int n) throws IllegalAccessException, IllegalArgumentException {
        Field field = clazz.getDeclaredFields()[n];
        field.setAccessible(true);
        return (T)field.get(object);
    }

    public static <T> T getField(Class<?> clazz, Class<T> clazz2, Object object, String string) {
        try {
            Field field = clazz.getDeclaredField(string);
            field.setAccessible(true);
            return (T)field.get(object);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> T newInstance(Class<T> clazz, Object ... objectArray) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        block0: for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            Class<?>[] classArray = constructor.getParameterTypes();
            if (classArray.length != objectArray.length) continue;
            for (int i = 0; i < objectArray.length; ++i) {
                if (!ReflectionManager.isInstance(classArray[i], objectArray[i])) continue block0;
            }
            constructor.setAccessible(true);
            return (T)constructor.newInstance(objectArray);
        }
        return null;
    }

    public static boolean hasField(Class<?> clazz, String string) {
        try {
            clazz.getDeclaredField(string);
            return true;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return false;
        }
    }

    public static <T> T get(Field field, Class<T> clazz) {
        return ReflectionManager.get(field, clazz, null);
    }

    public static <T> T get(Field field, Class<T> clazz, Object object) {
        try {
            return (T)field.get(object);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void set(Field field, Object object) {
        ReflectionManager.set(field, null, object);
    }

    public static void set(Field field, Object object, Object object2) {
        try {
            field.set(object, object2);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Field getField(ObfMapping obfMapping) {
        obfMapping.toRuntime();
        try {
            Class<?> clazz = ReflectionManager.class.getClassLoader().loadClass(obfMapping.javaClass());
            Field field = clazz.getDeclaredField(obfMapping.s_name);
            field.setAccessible(true);
            return field;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    static {
        primitiveWrappers.put(Integer.TYPE, Integer.class);
        primitiveWrappers.put(Short.TYPE, Short.class);
        primitiveWrappers.put(Byte.TYPE, Byte.class);
        primitiveWrappers.put(Long.TYPE, Long.class);
        primitiveWrappers.put(Double.TYPE, Double.class);
        primitiveWrappers.put(Float.TYPE, Float.class);
        primitiveWrappers.put(Boolean.TYPE, Boolean.class);
        primitiveWrappers.put(Character.TYPE, Character.class);
    }
}

