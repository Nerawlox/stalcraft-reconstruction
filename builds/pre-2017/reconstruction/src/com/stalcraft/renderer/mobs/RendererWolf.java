/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import com.stalcraft.renderer.mobs.ModelWolf;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererWolf
extends RenderLiving {
    private static final ResourceLocation wolfTexture = new ResourceLocation("stalcraft:textures/mobs/wolf.dds");
    private final ModelWolf model;

    public RendererWolf() {
        super(new ModelWolf(), 0.25f);
        this.model = (ModelWolf)this.mainModel;
        fmib._b(wolfTexture);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return wolfTexture;
    }
}

