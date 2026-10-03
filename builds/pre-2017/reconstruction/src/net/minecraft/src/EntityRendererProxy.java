/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

@Deprecated
public class EntityRendererProxy
extends EntityRenderer {
    public static final String fmlMarker = "This is an FML marker";
    public Minecraft game;

    @Deprecated
    public EntityRendererProxy(Minecraft minecraft) {
        super(minecraft);
        this.game = minecraft;
    }

    @Override
    @Deprecated
    public void updateCameraAndRender(float f) {
        super.updateCameraAndRender(f);
    }
}

