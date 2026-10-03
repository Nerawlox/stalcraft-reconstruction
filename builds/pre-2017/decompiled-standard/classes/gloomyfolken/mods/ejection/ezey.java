/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.ejection.pidb;
import net.minecraft.client.xpzm;
import net.minecraft.util.ofbx;
import org.lwjgl.opengl.GL11;

public class ezey {
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public static void _a() {
        if (kjui._a._b != null) {
            tfsl tfsl2 = xpzm._E()._D;
            pidb pidb2 = kjui._a._b;
            float f = pidb2._c();
            if (f < 0.5f) {
                tfsl2.field_78518_n = tfsl2.field_78518_n * (1.0f - (f *= 2.0f)) + 0.8f * f;
                tfsl2.field_78519_o = tfsl2.field_78519_o * (1.0f - f) + 0.4f * f;
                tfsl2.field_78533_p *= 1.0f - f;
            } else {
                f = (f - 0.5f) * 2.0f;
                tfsl2.field_78518_n = 0.8f;
                tfsl2.field_78519_o = 0.4f * (1.0f - f);
                tfsl2.field_78533_p = 0.0f;
            }
            GL11.glClearColor(tfsl2.field_78518_n, tfsl2.field_78519_o, tfsl2.field_78533_p, 0.0f);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public static ofbx _a(ofbx ofbx2) {
        if (kjui._a._b != null) {
            pidb pidb2 = kjui._a._b;
            float f = pidb2._c();
            if (f < 0.5f) {
                ofbx2._c = ofbx2._c * (double)(1.0f - (f *= 2.0f)) + (double)(1.0f * f);
                ofbx2._d = ofbx2._d * (double)(1.0f - f) + (double)(0.45f * f);
                ofbx2._e *= (double)(1.0f - f);
            } else {
                f = (f - 0.5f) * 2.0f;
                ofbx2._c = 1.0;
                ofbx2._d = 0.45f * (1.0f - f);
                ofbx2._e = 0.0;
            }
        }
        ofbx2._e = 0.0;
        ofbx2._d = 0.0;
        ofbx2._c = 0.0;
        return ofbx2;
    }
}

