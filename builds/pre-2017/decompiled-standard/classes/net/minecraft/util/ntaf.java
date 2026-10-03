/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class ntaf {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Field field : this.getClass().getFields()) {
            if (ntaf._a(field)) continue;
            try {
                stringBuilder.append(field.getName()).append("=").append(field.get(this)).append(" ");
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static boolean _a(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }
}

