/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ejection.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class eidj {
    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(fmab fmab2) {
        pidb pidb2 = gloomyfolken.mods.ejection.kjui._a._b;
        if (pidb2 != null) {
            float f = pidb2._c();
            fmab2._c = fmab2._c * (1.0f - f) + fmab2._c * (1.0f - fmab2._f) * f;
            fmab2._d = fmab2._d * (1.0f - f) + fmab2._d * (1.0f - fmab2._g) * f;
            fmab2._e = fmab2._e * (1.0f - f) + fmab2._e * (1.0f - fmab2._h) * f;
            fmab2._f = fmab2._f * (1.0f - f) + fmab2._f * f * 3.0f;
            fmab2._g = fmab2._g * (1.0f - f) + fmab2._g * f * 0.3f;
            fmab2._h = fmab2._h * (1.0f - f) + fmab2._h * f * 0.3f;
        }
    }

    @ForgeSubscribe
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(rpct.pidb pidb2) {
        if (gloomyfolken.mods.ejection.kjui._a._b != null) {
            float[] fArray = gloomyfolken.mods.ejection.kjui._a._a(pidb2._a);
            GL11.glTranslatef(fArray[0], fArray[1], fArray[2]);
            GL11.glRotatef(fArray[3], 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(fArray[4], 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(fArray[5], 0.0f, 0.0f, 1.0f);
        }
    }

    @ForgeSubscribe
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(ofxs.pidb pidb2) {
        if (gloomyfolken.mods.ejection.kjui._a._b != null) {
            pidb pidb3 = gloomyfolken.mods.ejection.kjui._a._b;
            float f = pidb3._c();
            pidb2._a("ejection", f);
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("ejection", new kjui(mquk2._a));
    }

    public static class kjui
    extends tehy {
        private static final String _b = "ejection";
        public boolean _a = false;

        public kjui(ccxr ccxr2) {
            super(ccxr2);
        }

        public static kjui _a(EntityPlayer entityPlayer) {
            return (kjui)ncwh._a((EntityPlayer)entityPlayer)._h.get(_b);
        }
    }
}

