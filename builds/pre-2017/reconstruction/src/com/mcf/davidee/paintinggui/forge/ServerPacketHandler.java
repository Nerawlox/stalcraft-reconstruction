/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui.forge;

import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ugqi;

public class ServerPacketHandler
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        if (player instanceof EntityPlayerMP) {
            this.serverPayload((EntityPlayerMP)player, packet250CustomPayload.data);
        }
    }

    private void serverPayload(EntityPlayerMP entityPlayerMP, byte[] byArray) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));
            int n = dataInputStream.readInt();
            if (dataInputStream.readInt() == 1) {
                this.setPainting(n, dataInputStream.readUTF(), entityPlayerMP);
            } else {
                this.sendPossiblePaintings(n, entityPlayerMP);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void setPainting(int n, String string, EntityPlayerMP entityPlayerMP) {
        Entity entity = entityPlayerMP.getServerForPlayer().getEntityByID(n);
        if (entity instanceof EntityPainting) {
            EntityPainting entityPainting = (EntityPainting)entity;
            PaintingSelectionMod.setPaintingArt(entityPainting, PaintingSelectionMod.getEnumArt(string));
            PacketDispatcher.sendPacketToAllInDimension(PaintingSelectionMod.createPacket(n, new String[]{string}), entityPainting.dimension);
        } else {
            entityPlayerMP.addChatMessage("\u00a7cError - Could not locate painting");
        }
    }

    private void sendPossiblePaintings(int n, EntityPlayerMP entityPlayerMP) {
        Entity entity = entityPlayerMP.getServerForPlayer().getEntityByID(n);
        if (entity instanceof EntityPainting) {
            EntityPainting entityPainting = (EntityPainting)entity;
            ugqi ugqi2 = entityPainting.art;
            ArrayList<ugqi> arrayList = new ArrayList<ugqi>();
            for (ugqi ugqi3 : ugqi.values()) {
                PaintingSelectionMod.setPaintingArt(entityPainting, ugqi3);
                if (!entityPainting.onValidSurface()) continue;
                arrayList.add(ugqi3);
            }
            ugqi[] ugqiArray = arrayList.toArray(new ugqi[0]);
            Arrays.sort(ugqiArray, PaintingSelectionMod.ART_COMPARATOR);
            String[] stringArray = new String[ugqiArray.length];
            for (int i = 0; i < ugqiArray.length; ++i) {
                stringArray[i] = ugqiArray[i].__aK;
            }
            entityPlayerMP.playerNetServerHandler.func_72567_b(PaintingSelectionMod.createPacket(n, stringArray));
            PaintingSelectionMod.setPaintingArt(entityPainting, ugqi2);
        } else {
            entityPlayerMP.addChatMessage("\u00a7cError - Could not locate painting");
        }
    }
}

