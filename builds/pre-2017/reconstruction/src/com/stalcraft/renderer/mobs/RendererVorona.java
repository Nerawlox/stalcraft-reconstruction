/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import com.stalcraft.renderer.mobs.ModelVorona;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererVorona
extends RenderLiving {
    private static final ResourceLocation voronaTexture = new ResourceLocation("stalcraft:textures/mobs/vorona.dds");
    private final ModelVorona model;

    public RendererVorona() {
        super(new ModelVorona(), 0.25f);
        this.model = (ModelVorona)this.mainModel;
        fmib._b(voronaTexture);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return voronaTexture;
    }
}

