/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui;

import com.mcf.davidee.paintinggui.CommandPainting;
import com.mcf.davidee.paintinggui.forge.ClientPacketHandler;
import com.mcf.davidee.paintinggui.forge.ServerPacketHandler;
import com.mcf.davidee.paintinggui.gui.ArtComparator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.ugqi;

@Mod(modid="PaintingSelGui", name="PaintingSelectionGui", version="1.6.4.0", dependencies="after:guilib")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, clientPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"PaintingSelGui"}, packetHandler=ClientPacketHandler.class), serverPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"PaintingSelGui"}, packetHandler=ServerPacketHandler.class))
public class PaintingSelectionMod {
    public static final String CHANNEL = "PaintingSelGui";
    public static final char COLOR = '\u00a7';
    public static final ArtComparator ART_COMPARATOR = new ArtComparator();

    public static ugqi getEnumArt(String string) {
        for (ugqi ugqi2 : ugqi.values()) {
            if (!ugqi2.__aK.equals(string)) continue;
            return ugqi2;
        }
        return ugqi._a;
    }

    public static void setPaintingArt(EntityPainting entityPainting, ugqi ugqi2) {
        entityPainting.field_70522_e = ugqi2;
        entityPainting.func_82328_a(entityPainting.field_82332_a);
    }

    public static jjqf createPacket(int n, String[] stringArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(stringArray.length);
            for (String string : stringArray) {
                dataOutputStream.writeUTF(string);
            }
            return new jjqf(CHANNEL, byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        dzfd dzfd2 = fMLServerStartingEvent.getServer();
        jjbh jjbh2 = (jjbh)dzfd2._J();
        jjbh2.func_71560_a(new CommandPainting());
    }
}

