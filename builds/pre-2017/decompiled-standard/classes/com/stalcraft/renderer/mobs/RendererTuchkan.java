/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import com.stalcraft.renderer.mobs.ModelTuchkan;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererTuchkan
extends ceev {
    private static final ResourceLocation tuchkanTexture = new ResourceLocation("stalcraft:textures/mobs/tuchkan.dds");
    private final ModelTuchkan model;

    public RendererTuchkan() {
        super(new ModelTuchkan(), 0.25f);
        this.model = (ModelTuchkan)this.field_77045_g;
        fmib._b(tuchkanTexture);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return tuchkanTexture;
    }
}

