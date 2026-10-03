/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraftforge.common.network.ForgePacket;
import net.minecraftforge.fluids.FluidIdMapPacket;

public class ForgeConnectionHandler
implements IConnectionHandler {
    @Override
    public void playerLoggedIn(Player player, elai elai2, jjpj jjpj2) {
        jjqf[] jjqfArray = ForgePacket.makePacketSet(new FluidIdMapPacket());
        for (int i = 0; i < jjqfArray.length; ++i) {
            PacketDispatcher.sendPacketToPlayer(jjqfArray[i], player);
        }
    }

    @Override
    public String connectionReceived(yezc yezc2, jjpj jjpj2) {
        return null;
    }

    @Override
    public void connectionOpened(elai elai2, String string, int n, jjpj jjpj2) {
    }

    @Override
    public void connectionOpened(elai elai2, dzfd dzfd2, jjpj jjpj2) {
    }

    @Override
    public void connectionClosed(jjpj jjpj2) {
    }

    @Override
    public void clientLoggedIn(elai elai2, jjpj jjpj2, txpf txpf2) {
    }
}

