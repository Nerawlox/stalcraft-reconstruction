/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class EntityRendererProxy
extends EntityRenderer {
    public static final String fmlMarker = "This is an FML marker";
    private Minecraft game;

    public EntityRendererProxy(Minecraft minecraft) {
        super(minecraft);
        this.game = minecraft;
    }

    @Override
    public void updateCameraAndRender(float f) {
        super.updateCameraAndRender(f);
    }
}

