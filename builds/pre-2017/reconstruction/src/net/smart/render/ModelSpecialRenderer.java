/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.model.ModelBase;
import net.smart.render.ModelRotationRenderer;
import org.lwjgl.opengl.GL11;

public class ModelSpecialRenderer
extends ModelRotationRenderer {
    public boolean doPopPush;

    public ModelSpecialRenderer(ModelBase modelBase, int n, int n2, ModelRotationRenderer modelRotationRenderer) {
        super(modelBase, n, n2, modelRotationRenderer);
        this.ignoreRender = true;
    }

    public void beforeRender(boolean bl) {
        this.doPopPush = bl;
        this.ignoreRender = false;
    }

    @Override
    public void doRender(float f, boolean bl) {
        if (this.doPopPush) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
        }
        super.doRender(f, true);
    }

    public void afterRender() {
        this.ignoreRender = true;
        this.doPopPush = false;
    }
}

