/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;

public class pidb {
    public static mtms _a(mtms mtms2, String string) {
        if ("DIM0".equals(string)) {
            return dzfd._I().func_130014_f_().func_72860_G();
        }
        return mtms2;
    }

    public static String _a(String string) {
        if ("DIM0".equals(string)) {
            return dzfd._I().func_130014_f_().func_72912_H()._k();
        }
        return string;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static String _a(rrte rrte2) {
        int n = rrte2._i;
        if (rrte2._b == null || !rrte2._b.field_72995_K) {
            n = InvokeWithResult.frontend(() -> null);
        }
        return n == 0 ? null : "DIM" + n;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(rrte rrte2, long l, float f) {
        double d = (double)(l % 160000L) + (double)f;
        double d2 = d > 120000.0 ? (d - 120000.0) / 80000.0 + 0.25 : d / 240000.0 - 0.25;
        if (d2 < 0.0) {
            d2 += 1.0;
        }
        if (d2 > 1.0) {
            d2 -= 1.0;
        }
        double d3 = d2;
        d2 = 1.0f - (float)((Math.cos(d2 * Math.PI) + 1.0) / 2.0);
        d2 = d3 + (d2 - d3) / 3.0;
        return (float)d2;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int _a(rrte rrte2, long l) {
        return (int)(l / 160000L) % 8;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(ozlu ozlu2) {
        if (!ozlu2.field_73011_w._g) {
            ozlu2.field_73003_n = ozlu2.field_73004_o;
            ozlu2.field_73004_o = ozlu2.field_73004_o + (ozlu2.field_72986_A._p() ? 0.01f : -0.01f);
            ozlu2.field_73004_o = sajh._a(ozlu2.field_73004_o, 0.0f, 1.0f);
            ozlu2.field_73018_p = ozlu2.field_73017_q;
            ozlu2.field_73017_q = ozlu2.field_73017_q + (ozlu2.field_72986_A._n() ? 0.01f : -0.01f);
            ozlu2.field_73017_q = sajh._a(ozlu2.field_73017_q, 0.0f, 1.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void _a(fngq fngq2, char c, int n) {
        if (n == 46) {
            xpzm xpzm2 = xpzm._E();
            xpzm2._a(new ivbz(xpzm2._B, false));
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(xpzm xpzm2) {
        ntpl._a();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="startSection")
    public static void _a(fokl fokl2, String string) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._a(string);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="endSection")
    public static void _a(fokl fokl2) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._b();
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="endStartSection")
    public static void _b(fokl fokl2, String string) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._c(string);
        }
    }
}

