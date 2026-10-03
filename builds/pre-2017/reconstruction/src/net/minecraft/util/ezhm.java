/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.EnumOS;

public class ezhm {
    public static EnumOS _a() {
        String string = System.getProperty("os.name").toLowerCase();
        if (string.contains("win")) {
            return EnumOS._c;
        }
        if (string.contains("mac")) {
            return EnumOS._d;
        }
        if (string.contains("solaris")) {
            return EnumOS._b;
        }
        if (string.contains("sunos")) {
            return EnumOS._b;
        }
        if (string.contains("linux")) {
            return EnumOS._a;
        }
        if (string.contains("unix")) {
            return EnumOS._a;
        }
        return EnumOS._e;
    }
}

