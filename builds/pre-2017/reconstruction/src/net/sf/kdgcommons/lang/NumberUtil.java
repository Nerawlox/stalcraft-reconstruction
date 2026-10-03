/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NumberUtil {
    public static Number parse(String string, Class<? extends Number> clazz) {
        if (clazz == Byte.class || clazz == Byte.TYPE) {
            return Byte.valueOf(string);
        }
        if (clazz == Short.class || clazz == Short.TYPE) {
            return Short.valueOf(string);
        }
        if (clazz == Integer.class || clazz == Integer.TYPE) {
            return Integer.valueOf(string);
        }
        if (clazz == Long.class || clazz == Long.TYPE) {
            return Long.valueOf(string);
        }
        if (clazz == Float.class || clazz == Float.TYPE) {
            return Float.valueOf(string);
        }
        if (clazz == Double.class || clazz == Double.TYPE) {
            return Double.valueOf(string);
        }
        if (clazz == BigInteger.class) {
            return new BigInteger(string);
        }
        if (clazz == BigDecimal.class) {
            return new BigDecimal(string);
        }
        throw new IllegalArgumentException("unknown class: " + clazz.getName());
    }

    public static String toHexString(long l, int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        while (n > 0) {
            int n2 = (int)(l & 0xFL);
            stringBuilder.insert(0, "0123456789ABCDEF".charAt(n2));
            l >>= 4;
            --n;
        }
        return stringBuilder.toString();
    }

    public static <T extends Number> T dynamicCast(Object object, Class<T> clazz) {
        if (object == null) {
            return null;
        }
        Number number = (Number)object;
        if (object.getClass() == clazz) {
            return (T)((Number)clazz.cast(object));
        }
        if (clazz == Byte.class || clazz == Byte.TYPE) {
            return (T)((Number)clazz.cast(number.byteValue()));
        }
        if (clazz == Short.class || clazz == Short.TYPE) {
            return (T)((Number)clazz.cast(number.byteValue()));
        }
        if (clazz == Integer.class || clazz == Integer.TYPE) {
            return (T)((Number)clazz.cast(number.byteValue()));
        }
        if (clazz == Long.class || clazz == Long.TYPE) {
            return (T)((Number)clazz.cast(number.byteValue()));
        }
        if (clazz == Float.class || clazz == Float.TYPE) {
            return (T)((Number)clazz.cast(Float.valueOf(number.byteValue())));
        }
        if (clazz == Double.class || clazz == Double.TYPE) {
            return (T)((Number)clazz.cast(number.byteValue()));
        }
        throw new ClassCastException("unsupported destination type: " + clazz.getName());
    }
}

