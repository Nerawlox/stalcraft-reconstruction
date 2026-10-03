/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.model.ModelBase;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.ModelSpecialRenderer;
import org.lwjgl.opengl.GL11;

public class ModelEarsRenderer
extends ModelSpecialRenderer {
    private int _i = 0;

    public ModelEarsRenderer(ModelBase modelBase, int n, int n2, ModelRotationRenderer modelRotationRenderer) {
        super(modelBase, n, n2, modelRotationRenderer);
    }

    public void beforeRender() {
        super.beforeRender(true);
    }

    @Override
    public void doRender(float f, boolean bl) {
        this.reset();
        super.doRender(f, bl);
    }

    @Override
    public void preTransform(float f, boolean bl) {
        super.preTransform(f, bl);
        int n = this._i++ % 2;
        GL11.glTranslatef(0.375f * (float)(n * 2 - 1), 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, -0.375f, 0.0f);
        GL11.glScalef(1.333333f, 1.333333f, 1.333333f);
    }

    @Override
    public boolean canBeRandomBoxSource() {
        return false;
    }
}

