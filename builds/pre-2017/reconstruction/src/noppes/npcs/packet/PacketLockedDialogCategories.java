/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.global.GuiNPCManageDialogs;
import noppes.npcs.controllers.DialogCategory;

public class PacketLockedDialogCategories
extends zwat {
    private Set<Integer> ids;

    public PacketLockedDialogCategories(Collection<DialogCategory> collection) {
        this.ids = collection.stream().filter(dialogCategory -> dialogCategory.locked).map(dialogCategory -> dialogCategory.id).collect(Collectors.toSet());
    }

    public PacketLockedDialogCategories(Set<Integer> set) {
        this.ids = set;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.ids.size());
        for (int n : this.ids) {
            dataOutput.writeInt(n);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.ids = new HashSet<Integer>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.ids.add(dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen instanceof GuiNPCManageDialogs) {
            ((GuiNPCManageDialogs)guiScreen).lockedCategories = this.ids;
        }
    }

    public PacketLockedDialogCategories() {
    }
}

