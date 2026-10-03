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
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;
import net.minecraft.util.ugqi;

public class ClientPacketHandler
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
        this.clientPayload(jjqf2.field_73629_c, (EntityPlayer)player);
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
                hank hank2 = xpzm._E()._L;
                if (hank2 != null && hank2._i instanceof EntityPainting) {
                    PacketDispatcher.sendPacketToServer(PaintingSelectionMod.createPacket(hank2._i.field_70157_k, new String[0]));
                } else {
                    entityPlayer.func_71035_c("\u00a7cError - No painting selected");
                }
            } else if (stringArray.length == 1) {
                ugqi ugqi2 = PaintingSelectionMod.getEnumArt(stringArray[0]);
                Entity entity = entityPlayer.field_70170_p.func_73045_a(n);
                if (entity instanceof EntityPainting) {
                    PaintingSelectionMod.setPaintingArt((EntityPainting)entity, ugqi2);
                }
            } else {
                xpzm xpzm2 = xpzm._E();
                if (xpzm2._B == null) {
                    xpzm2._a(new PaintingSelectionScreen(stringArray, n));
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

