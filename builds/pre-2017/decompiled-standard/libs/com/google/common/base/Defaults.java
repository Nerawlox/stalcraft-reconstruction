/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Defaults {
    private static final Map<Class<?>, Object> DEFAULTS;

    private Defaults() {
    }

    private static <T> void put(Map<Class<?>, Object> map2, Class<T> type2, T value) {
        map2.put(type2, value);
    }

    public static <T> T defaultValue(Class<T> type2) {
        return (T)DEFAULTS.get(Preconditions.checkNotNull(type2));
    }

    static {
        HashMap map2 = new HashMap();
        Defaults.put(map2, Boolean.TYPE, false);
        Defaults.put(map2, Character.TYPE, Character.valueOf('\u0000'));
        Defaults.put(map2, Byte.TYPE, (byte)0);
        Defaults.put(map2, Short.TYPE, (short)0);
        Defaults.put(map2, Integer.TYPE, 0);
        Defaults.put(map2, Long.TYPE, 0L);
        Defaults.put(map2, Float.TYPE, Float.valueOf(0.0f));
        Defaults.put(map2, Double.TYPE, 0.0);
        DEFAULTS = Collections.unmodifiableMap(map2);
    }
}

