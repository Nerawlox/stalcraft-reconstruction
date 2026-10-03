/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.model.ModelCarpentryBench;
import org.lwjgl.opengl.GL11;

public class BlockCarpentryBenchRenderer
extends htys {
    private static final ResourceLocation field_110631_g = new ResourceLocation("customnpcs", "textures/misc/CarpentryBench.png");
    private ModelCarpentryBench model = new ModelCarpentryBench();

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        int n = hurg2.field_70331_k.func_72805_g(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 1.4f, (float)d3 + 0.5f);
        GL11.glScalef(0.95f, 0.95f, 0.95f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(90 * n, 0.0f, 1.0f, 0.0f);
        this.func_110628_a(field_110631_g);
        this.model.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

