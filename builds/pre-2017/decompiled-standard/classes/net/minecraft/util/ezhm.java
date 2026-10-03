/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.vjsq;

public class ezhm {
    public static vjsq _a() {
        String string = System.getProperty("os.name").toLowerCase();
        if (string.contains("win")) {
            return vjsq._c;
        }
        if (string.contains("mac")) {
            return vjsq._d;
        }
        if (string.contains("solaris")) {
            return vjsq._b;
        }
        if (string.contains("sunos")) {
            return vjsq._b;
        }
        if (string.contains("linux")) {
            return vjsq._a;
        }
        if (string.contains("unix")) {
            return vjsq._a;
        }
        return vjsq._e;
    }
}

