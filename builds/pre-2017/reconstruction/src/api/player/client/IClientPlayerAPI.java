/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import api.player.client.ClientPlayerAPI;
import api.player.client.IClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

public interface IClientPlayerAPI
extends IClientPlayer {
    public ClientPlayerAPI getClientPlayerAPI();

    public EntityPlayerSP getEntityPlayerSP();
}

