/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import com.stalcraft.renderer.mobs.ModelWolf;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererWolf
extends ceev {
    private static final ResourceLocation wolfTexture = new ResourceLocation("stalcraft:textures/mobs/wolf.dds");
    private final ModelWolf model;

    public RendererWolf() {
        super(new ModelWolf(), 0.25f);
        this.model = (ModelWolf)this.field_77045_g;
        fmib._b(wolfTexture);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return wolfTexture;
    }
}

