/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.client.gui.player.GuiTradepacks;

public class PacketTradepackSold
extends zwat {
    @Override
    public void processClient(boolean bl) {
        Minecraft minecraft = Minecraft._E();
        GuiScreen guiScreen = minecraft._B;
        if (guiScreen instanceof GuiTradepacks) {
            tupg._a((EntityPlayer)minecraft._t)._c._c(null);
            guiScreen.setWorldAndResolution(minecraft, guiScreen.width, guiScreen.height);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

