/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.client.gui.player.GuiTradepacks;

public class PacketTradepackSold
extends zwat {
    @Override
    public void processClient(boolean bl) {
        xpzm xpzm2 = xpzm._E();
        gqjz gqjz2 = xpzm2._B;
        if (gqjz2 instanceof GuiTradepacks) {
            tupg._a((EntityPlayer)xpzm2._t)._c._c(null);
            gqjz2.func_73872_a(xpzm2, gqjz2.field_73880_f, gqjz2.field_73881_g);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

