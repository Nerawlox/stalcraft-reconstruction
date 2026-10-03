/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class PacketIgnoredList
extends zwat {
    private List<String> ignored = new ArrayList<String>();

    public PacketIgnoredList() {
    }

    public PacketIgnoredList(List<String> list2) {
        this.ignored = list2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        PacketIgnoredList.writeStringList(this.ignored, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.ignored = PacketIgnoredList.readStringList(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen instanceof GuiPda && ((GuiPda)guiScreen).currentTab instanceof IgnoreListConsumer) {
            ((IgnoreListConsumer)((Object)((GuiPda)guiScreen).currentTab)).updateIgnored(this.ignored);
        }
    }

    public static interface IgnoreListConsumer {
        public void updateIgnored(List<String> var1);
    }
}

