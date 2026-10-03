/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui.forge;

import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import com.mcf.davidee.paintinggui.gui.PaintingSelectionScreen;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ugqi;

public class ClientPacketHandler
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        this.clientPayload(packet250CustomPayload.data, (EntityPlayer)player);
    }

    private void clientPayload(byte[] byArray, EntityPlayer entityPlayer) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));
            int n = dataInputStream.readInt();
            String[] stringArray = new String[dataInputStream.readInt()];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = dataInputStream.readUTF();
            }
            if (n == -1) {
                MovingObjectPosition movingObjectPosition = Minecraft._E()._L;
                if (movingObjectPosition != null && movingObjectPosition._i instanceof EntityPainting) {
                    PacketDispatcher.sendPacketToServer(PaintingSelectionMod.createPacket(movingObjectPosition._i.entityId, new String[0]));
                } else {
                    entityPlayer.addChatMessage("\u00a7cError - No painting selected");
                }
            } else if (stringArray.length == 1) {
                ugqi ugqi2 = PaintingSelectionMod.getEnumArt(stringArray[0]);
                Entity entity = entityPlayer.worldObj.getEntityByID(n);
                if (entity instanceof EntityPainting) {
                    PaintingSelectionMod.setPaintingArt((EntityPainting)entity, ugqi2);
                }
            } else {
                Minecraft minecraft = Minecraft._E();
                if (minecraft._B == null) {
                    minecraft._a(new PaintingSelectionScreen(stringArray, n));
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

