/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.ModelSpecialRenderer;
import org.lwjgl.opengl.GL11;

public class ModelCapeRenderer
extends ModelSpecialRenderer {
    private final ModelRotationRenderer outer;
    private EntityPlayer entityplayer;
    private float setFactor;

    public ModelCapeRenderer(ModelBase modelBase, int n, int n2, ModelRotationRenderer modelRotationRenderer, ModelRotationRenderer modelRotationRenderer2) {
        super(modelBase, n, n2, modelRotationRenderer);
        this.outer = modelRotationRenderer2;
    }

    public void beforeRender(EntityPlayer entityPlayer, float f) {
        this.entityplayer = entityPlayer;
        this.setFactor = f;
        super.beforeRender(true);
    }

    @Override
    public void preTransform(float f, boolean bl) {
        super.preTransform(f, bl);
        double d = this.entityplayer.field_71091_bM + (this.entityplayer.field_71094_bP - this.entityplayer.field_71091_bM) * (double)this.setFactor - (this.entityplayer.field_70169_q + (this.entityplayer.field_70165_t - this.entityplayer.field_70169_q) * (double)this.setFactor);
        double d2 = this.entityplayer.field_71096_bN + (this.entityplayer.field_71095_bQ - this.entityplayer.field_71096_bN) * (double)this.setFactor - (this.entityplayer.field_70167_r + (this.entityplayer.field_70163_u - this.entityplayer.field_70167_r) * (double)this.setFactor);
        double d3 = this.entityplayer.field_71097_bO + (this.entityplayer.field_71085_bR - this.entityplayer.field_71097_bO) * (double)this.setFactor - (this.entityplayer.field_70166_s + (this.entityplayer.field_70161_v - this.entityplayer.field_70166_s) * (double)this.setFactor);
        float f2 = this.entityplayer.field_70760_ar + (this.entityplayer.field_70761_aq - this.entityplayer.field_70760_ar) * this.setFactor;
        double d4 = sajh._a(f2 * 3.141593f / 180.0f);
        double d5 = -sajh._b(f2 * 3.141593f / 180.0f);
        float f3 = (float)d2 * 10.0f;
        if (f3 < -6.0f) {
            f3 = -6.0f;
        }
        if (f3 > 32.0f) {
            f3 = 32.0f;
        }
        float f4 = (float)(d * d4 + d3 * d5) * 100.0f;
        float f5 = (float)(d * d5 - d3 * d4) * 100.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        float f6 = this.entityplayer.field_71107_bF + (this.entityplayer.field_71109_bG - this.entityplayer.field_71107_bF) * this.setFactor;
        float f7 = 6.0f + f4 / 2.0f + (f3 += sajh._a((this.entityplayer.field_70141_P + (this.entityplayer.field_70140_Q - this.entityplayer.field_70141_P) * this.setFactor) * 6.0f) * 32.0f * f6);
        float f8 = Math.max(70.523f - this.outer.field_78795_f * 57.295776f, 6.0f);
        float f9 = Math.min(f7, f8);
        GL11.glRotatef(f9, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(f5 / 2.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-f5 / 2.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
    }

    @Override
    public boolean canBeRandomBoxSource() {
        return false;
    }
}

