/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import net.minecraft.util.ofbx;

public class tdpf {
    public static ofbx _a(ofbx ofbx2, double d) {
        return tdpf._b(ofbx2, ofbx2._c * d, ofbx2._d * d, ofbx2._e * d);
    }

    public static ofbx _a(ofbx ofbx2, double d, double d2, double d3) {
        return tdpf._b(ofbx2, ofbx2._c + d, ofbx2._d + d2, ofbx2._e + d3);
    }

    public static ofbx _a(ofbx ofbx2, ofbx ofbx3) {
        ofbx2._c += ofbx3._c;
        ofbx2._d += ofbx3._d;
        ofbx2._e += ofbx3._e;
        return ofbx2;
    }

    public static ofbx _a(ofbx ofbx2) {
        return tdpf._a(ofbx2, 1.0 / ofbx2._b());
    }

    public static ofbx _b(ofbx ofbx2, double d, double d2, double d3) {
        ofbx2._c = d;
        ofbx2._d = d2;
        ofbx2._e = d3;
        return ofbx2;
    }

    public static double _c(ofbx ofbx2, double d, double d2, double d3) {
        double d4 = ofbx2._c - d;
        double d5 = ofbx2._d - d2;
        double d6 = ofbx2._e - d3;
        return Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
    }
}

