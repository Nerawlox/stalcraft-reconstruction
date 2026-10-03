/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderPlayer
 */
package api.player.render;

import api.player.render.IRenderPlayer;
import api.player.render.RenderPlayerAPI;
import net.minecraft.client.renderer.entity.RenderPlayer;

public interface IRenderPlayerAPI
extends IRenderPlayer {
    public RenderPlayerAPI getRenderPlayerAPI();

    public RenderPlayer getRenderPlayer();
}

