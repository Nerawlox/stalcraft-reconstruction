/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
    public static Field findField(Class<?> clazz, String ... stringArray) {
        Exception exception = null;
        for (String string : stringArray) {
            try {
                Field field = clazz.getDeclaredField(string);
                field.setAccessible(true);
                return field;
            }
            catch (Exception exception2) {
                exception = exception2;
            }
        }
        throw new UnableToFindFieldException(stringArray, exception);
    }

    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, int n) {
        try {
            Field field = clazz.getDeclaredFields()[n];
            field.setAccessible(true);
            return (T)field.get(e);
        }
        catch (Exception exception) {
            throw new UnableToAccessFieldException(new String[0], exception);
        }
    }

    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, String ... stringArray) {
        try {
            return (T)ReflectionHelper.findField(clazz, stringArray).get(e);
        }
        catch (Exception exception) {
            throw new UnableToAccessFieldException(stringArray, exception);
        }
    }

    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, E e, int n) {
        try {
            Field field = clazz.getDeclaredFields()[n];
            field.setAccessible(true);
            field.set(t, e);
        }
        catch (Exception exception) {
            throw new UnableToAccessFieldException(new String[0], exception);
        }
    }

    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, E e, String ... stringArray) {
        try {
            ReflectionHelper.findField(clazz, stringArray).set(t, e);
        }
        catch (Exception exception) {
            throw new UnableToAccessFieldException(stringArray, exception);
        }
    }

    public static Class<? super Object> getClass(ClassLoader classLoader, String ... stringArray) {
        Exception exception = null;
        for (String string : stringArray) {
            try {
                return Class.forName(string, false, classLoader);
            }
            catch (Exception exception2) {
                exception = exception2;
            }
        }
        throw new UnableToFindClassException(stringArray, exception);
    }

    public static <E> Method findMethod(Class<? super E> clazz, E e, String[] stringArray, Class<?> ... classArray) {
        Exception exception = null;
        for (String string : stringArray) {
            try {
                Method method = clazz.getDeclaredMethod(string, classArray);
                method.setAccessible(true);
                return method;
            }
            catch (Exception exception2) {
                exception = exception2;
            }
        }
        throw new UnableToFindMethodException(stringArray, exception);
    }

    public static class UnableToFindFieldException
    extends RuntimeException {
        private String[] fieldNameList;

        public UnableToFindFieldException(String[] stringArray, Exception exception) {
            super(exception);
            this.fieldNameList = stringArray;
        }
    }

    public static class UnableToAccessFieldException
    extends RuntimeException {
        private String[] fieldNameList;

        public UnableToAccessFieldException(String[] stringArray, Exception exception) {
            super(exception);
            this.fieldNameList = stringArray;
        }
    }

    public static class UnableToFindClassException
    extends RuntimeException {
        private String[] classNames;

        public UnableToFindClassException(String[] stringArray, Exception exception) {
            super(exception);
            this.classNames = stringArray;
        }
    }

    public static class UnableToFindMethodException
    extends RuntimeException {
        private String[] methodNames;

        public UnableToFindMethodException(String[] stringArray, Exception exception) {
            super(exception);
            this.methodNames = stringArray;
        }
    }
}

