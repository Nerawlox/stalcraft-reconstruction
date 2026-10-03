/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.ejection.pidb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class ezey {
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public static void _a() {
        if (kjui._a._b != null) {
            EntityRenderer entityRenderer = Minecraft._E()._D;
            pidb pidb2 = kjui._a._b;
            float f = pidb2._c();
            if (f < 0.5f) {
                entityRenderer.fogColorRed = entityRenderer.fogColorRed * (1.0f - (f *= 2.0f)) + 0.8f * f;
                entityRenderer.fogColorGreen = entityRenderer.fogColorGreen * (1.0f - f) + 0.4f * f;
                entityRenderer.fogColorBlue *= 1.0f - f;
            } else {
                f = (f - 0.5f) * 2.0f;
                entityRenderer.fogColorRed = 0.8f;
                entityRenderer.fogColorGreen = 0.4f * (1.0f - f);
                entityRenderer.fogColorBlue = 0.0f;
            }
            GL11.glClearColor(entityRenderer.fogColorRed, entityRenderer.fogColorGreen, entityRenderer.fogColorBlue, 0.0f);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public static Vec3 _a(Vec3 vec3) {
        if (kjui._a._b != null) {
            pidb pidb2 = kjui._a._b;
            float f = pidb2._c();
            if (f < 0.5f) {
                vec3._c = vec3._c * (double)(1.0f - (f *= 2.0f)) + (double)(1.0f * f);
                vec3._d = vec3._d * (double)(1.0f - f) + (double)(0.45f * f);
                vec3._e *= (double)(1.0f - f);
            } else {
                f = (f - 0.5f) * 2.0f;
                vec3._c = 1.0;
                vec3._d = 0.45f * (1.0f - f);
                vec3._e = 0.0;
            }
        }
        vec3._e = 0.0;
        vec3._d = 0.0;
        vec3._c = 0.0;
        return vec3;
    }
}

