/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.trade.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class wohx
extends ytyx {
    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        if (Minecraft._E()._B instanceof pidb) {
            Minecraft._E()._t.closeScreen();
            Minecraft._E()._a((GuiScreen)null);
        }
    }
}

