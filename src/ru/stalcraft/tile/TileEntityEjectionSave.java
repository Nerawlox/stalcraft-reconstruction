/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.tile;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.player.PlayerServerInfo;

public class TileEntityEjectionSave
extends asp {
    @Override
    public void h() {
        if (this.o()) {
            asx boxSave = asx.a().a((double)this.l - 20.0, (double)this.m, (double)this.n - 20.0, (double)this.l + 21.0, (double)this.m + 10.0, (double)this.n + 21.0);
            List playersInBoxSaves = this.az().a(jv.class, boxSave);
            for (jv player : MinecraftServer.F().af().a) {
                ((PlayerServerInfo)PlayerUtils.getInfo((uf)player)).isEjectionSave = playersInBoxSaves.contains(player);
            }
        }
    }
}

