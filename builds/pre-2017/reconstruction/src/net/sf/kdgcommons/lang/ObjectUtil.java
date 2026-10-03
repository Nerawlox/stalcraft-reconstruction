/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.lang.reflect.Array;
import net.sf.kdgcommons.lang.ObjectFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ObjectUtil {
    public static boolean equals(Object object, Object object2) {
        int n;
        if (object == object2) {
            return true;
        }
        if (object == null && object2 != null) {
            return false;
        }
        if (object != null && object2 == null) {
            return false;
        }
        if (!object.getClass().isArray() || !object2.getClass().isArray()) {
            return object.equals(object2);
        }
        if (object.getClass() != object2.getClass()) {
            return false;
        }
        int n2 = Array.getLength(object);
        if (n2 != (n = Array.getLength(object2))) {
            return false;
        }
        for (int i = 0; i < n2; ++i) {
            if (ObjectUtil.equals(Array.get(object, i), Array.get(object2, i))) continue;
            return false;
        }
        return true;
    }

    public static int hashCode(Object object) {
        return object == null ? 0 : object.hashCode();
    }

    public static String identityToString(Object object) {
        return object == null ? "null" : object.getClass().getName() + "@" + System.identityHashCode(object);
    }

    public static <T> T defaultValue(T t, T t2) {
        return t != null ? t : t2;
    }

    public static <T> T defaultValue(T t, ObjectFactory<T> objectFactory) {
        return t != null ? t : objectFactory.newInstance();
    }
}

