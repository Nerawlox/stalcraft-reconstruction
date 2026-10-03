/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.network.ForgePacket;

public class ForgePacketHandler
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
        ForgePacket forgePacket = ForgePacket.readPacket(jjpj2, jjqf2.field_73629_c);
        if (forgePacket == null) {
            return;
        }
        forgePacket.execute(jjpj2, (EntityPlayer)player);
    }
}

