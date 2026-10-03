/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import com.stalcraft.renderer.mobs.ModelTuchkan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererTuchkan
extends RenderLiving {
    private static final ResourceLocation tuchkanTexture = new ResourceLocation("stalcraft:textures/mobs/tuchkan.dds");
    private final ModelTuchkan model;

    public RendererTuchkan() {
        super(new ModelTuchkan(), 0.25f);
        this.model = (ModelTuchkan)this.mainModel;
        fmib._b(tuchkanTexture);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return tuchkanTexture;
    }
}

