/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.GuiApproveNpc;

public class PacketOpenApproveGui
extends zwat {
    public int entityId;
    public boolean canApprove;
    public boolean canReapprove;
    public List<String> selectedDungeons;
    public List<String> allDungeons;

    public PacketOpenApproveGui(int n, boolean bl, boolean bl2, Set<String> set, Set<String> set2) {
        this.entityId = n;
        this.canApprove = bl;
        this.canReapprove = bl2;
        this.selectedDungeons = new ArrayList<String>(set);
        this.allDungeons = new ArrayList<String>(set2);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        dataOutput.writeBoolean(this.canApprove);
        dataOutput.writeBoolean(this.canReapprove);
        PacketOpenApproveGui.writeStringList(this.selectedDungeons, dataOutput);
        PacketOpenApproveGui.writeStringList(this.allDungeons, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.canApprove = dataInput.readBoolean();
        this.canReapprove = dataInput.readBoolean();
        this.selectedDungeons = PacketOpenApproveGui.readStringList(dataInput);
        this.allDungeons = PacketOpenApproveGui.readStringList(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = Minecraft._E()._r.getEntityByID(this.entityId);
        if (entity instanceof EntityNPCInterface) {
            Minecraft._E()._a(new GuiApproveNpc(entity.entityId, ((EntityNPCInterface)entity).status, this.canApprove, this.canReapprove, this.selectedDungeons, this.allDungeons));
        }
    }

    public PacketOpenApproveGui() {
    }
}

