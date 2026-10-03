/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import api.player.server.IServerPlayer;
import api.player.server.ServerPlayerAPI;
import net.minecraft.entity.player.EntityPlayerMP;

public interface IServerPlayerAPI
extends IServerPlayer {
    public ServerPlayerAPI getServerPlayerAPI();

    public EntityPlayerMP getEntityPlayerMP();
}

