/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.HashMap;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class lqls {
    private static final int _a = 16;
    private static final double _b = 0.5;
    private static final double _c = 1.5;
    private static final double _d = 2.0;
    private static ResourceLocation _e = new ResourceLocation("stalkerguide", "textures/other/arrowhint.png");
    private static ResourceLocation _f = new ResourceLocation("stalkerguide", "textures/other/govno.png");
    private HashMap<Class<? extends cfum>, kjui> _g = Maps.newHashMap();
    private pkix _h;
    private divz _i;
    private cvgz _j;
    private float _k;
    private xpzm _l;

    public lqls(pkix pkix2) {
        this._h = pkix2;
        this._a();
        this._l = xpzm._E();
    }

    private void _a() {
        this._g.clear();
        this._g.put(oiwg.class, cfum2 -> this._a((oiwg)cfum2));
    }

    public void _a(cvgz cvgz2, divz divz2, float f) {
        this._j = cvgz2;
        this._k = f;
        this._i = divz2;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2884);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        thfd thfd2 = divz2._i();
        if (thfd2 != null && thfd2._j() != null) {
            for (cfum cfum2 : thfd2._j()) {
                kjui kjui2 = this._g.get(cfum2.getClass());
                if (kjui2 == null) continue;
                kjui2.renderTask(cfum2);
            }
        }
        GL11.glDepthMask(true);
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    private void _a(oiwg oiwg2) {
        if (oiwg2._b()) {
            return;
        }
        double d = this._l._t.field_70142_S + (this._l._t.field_70165_t - this._l._t.field_70142_S) * (double)this._k;
        double d2 = this._l._t.field_70137_T + (this._l._t.field_70163_u - this._l._t.field_70137_T) * (double)this._k;
        double d3 = this._l._t.field_70136_U + (this._l._t.field_70161_v - this._l._t.field_70136_U) * (double)this._k;
        double d4 = oiwg2._i()._c - d;
        double d5 = oiwg2._i()._d - d2;
        double d6 = oiwg2._i()._e - d3;
        if (oiwg2._d() == 1) {
            double d7 = oiwg2._c()._e - oiwg2._i()._c;
            double d8 = oiwg2._c()._f - oiwg2._i()._d;
            double d9 = oiwg2._c()._g - oiwg2._i()._e;
            GL11.glEnable(3553);
            GL11.glBlendFunc(770, 1);
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78382_b();
            htvf2.func_78369_a(0.6f, 0.71f, 0.43f, 0.5f);
            htvf2.func_78377_a(d4, d5, d6);
            htvf2.func_78377_a(d4 + d7, d5, d6);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6);
            htvf2.func_78377_a(d4, d5 + d8, d6);
            htvf2.func_78377_a(d4, d5, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4, d5, d6);
            htvf2.func_78377_a(d4, d5, d6 + d9);
            htvf2.func_78377_a(d4, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4, d5 + d8, d6);
            htvf2.func_78377_a(d4 + d7, d5, d6);
            htvf2.func_78377_a(d4 + d7, d5, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6);
            htvf2.func_78377_a(d4, d5 + d8, d6);
            htvf2.func_78377_a(d4, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5 + d8, d6);
            htvf2.func_78377_a(d4, d5, d6);
            htvf2.func_78377_a(d4, d5, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5, d6 + d9);
            htvf2.func_78377_a(d4 + d7, d5, d6);
            htvf2.func_78381_a();
            GL11.glDisable(3553);
        } else if (oiwg2._d() == 0) {
            double d10;
            double d11;
            double d12;
            double d13;
            double d14 = oiwg2._e();
            double d15 = oiwg2._e();
            double d16 = 0.39269908169872414;
            double d17 = (double)System.currentTimeMillis() * 0.004;
            d14 += Math.cos(d17) * 0.25;
            this._l._h._a(_f);
            GL11.glEnable(3553);
            GL11.glBlendFunc(770, 1);
            htvf htvf3 = htvf.field_78398_a;
            htvf3.func_78382_b();
            htvf3.func_78369_a(0.6f, 0.71f, 0.43f, 0.5f);
            for (d13 = 0.0; d13 < Math.PI * 2; d13 += d16) {
                d12 = Math.sin(d13);
                d11 = Math.cos(d13);
                d10 = Math.sin(d13 + d16);
                double d18 = Math.cos(d13 + d16);
                htvf3.func_78374_a(d4 + d18 * d14, d5, d6 + d10 * d14, 0.0, 1.0);
                htvf3.func_78374_a(d4 + d11 * d14, d5, d6 + d12 * d14, 1.0, 1.0);
                htvf3.func_78374_a(d4 + d11 * d14, d5 + d15, d6 + d12 * d14, 1.0, 0.0);
                htvf3.func_78374_a(d4 + d18 * d14, d5 + d15, d6 + d10 * d14, 0.0, 0.0);
            }
            htvf3.func_78381_a();
            d5 += d15 * 2.0 + Math.cos(d17) * 0.25;
            d13 = Math.toRadians(45.0) + Math.atan2(d6, d4);
            d12 = (Math.cos(d13) - Math.sin(d13)) * 2.0 / 2.0;
            d11 = 2.0;
            d10 = (Math.sin(d13) + Math.cos(d13)) * 2.0 / 2.0;
            this._l._h._a(_e);
            GL11.glBlendFunc(770, 771);
            htvf3.func_78382_b();
            htvf3.func_78369_a(1.0f, 1.0f, 1.0f, 0.5f);
            htvf3.func_78374_a(d4 - d12, d5 - d11, d6 - d10, 1.0, 0.0);
            htvf3.func_78374_a(d4 - d12, d5 + d11, d6 - d10, 0.0, 0.0);
            htvf3.func_78374_a(d4 + d12, d5 + d11, d6 + d10, 0.0, 1.0);
            htvf3.func_78374_a(d4 + d12, d5 - d11, d6 + d10, 1.0, 1.0);
            htvf3.func_78381_a();
            GL11.glDisable(3553);
        }
    }

    static interface kjui {
        public void renderTask(cfum var1);
    }
}

