/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import net.minecraft.util.Vec3;

public class tdpf {
    public static Vec3 _a(Vec3 vec3, double d) {
        return tdpf._b(vec3, vec3._c * d, vec3._d * d, vec3._e * d);
    }

    public static Vec3 _a(Vec3 vec3, double d, double d2, double d3) {
        return tdpf._b(vec3, vec3._c + d, vec3._d + d2, vec3._e + d3);
    }

    public static Vec3 _a(Vec3 vec3, Vec3 vec32) {
        vec3._c += vec32._c;
        vec3._d += vec32._d;
        vec3._e += vec32._e;
        return vec3;
    }

    public static Vec3 _a(Vec3 vec3) {
        return tdpf._a(vec3, 1.0 / vec3._b());
    }

    public static Vec3 _b(Vec3 vec3, double d, double d2, double d3) {
        vec3._c = d;
        vec3._d = d2;
        vec3._e = d3;
        return vec3;
    }

    public static double _c(Vec3 vec3, double d, double d2, double d3) {
        double d4 = vec3._c - d;
        double d5 = vec3._d - d2;
        double d6 = vec3._e - d3;
        return Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
    }
}

