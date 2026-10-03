/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import noppes.npcs.constants.EnumRoleType;

public class NpcSyncPacket
extends zwat {
    private List<MapNpc> npcs;
    private boolean clear;

    public NpcSyncPacket(List<MapNpc> list2, boolean bl) {
        this.npcs = list2;
        this.clear = bl;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this.clear);
        dataOutput.writeInt(this.npcs.size());
        for (MapNpc mapNpc : this.npcs) {
            dataOutput.writeInt(mapNpc.role.ordinal());
            dataOutput.writeInt(mapNpc.entityId);
            dataOutput.writeUTF(mapNpc.iconName);
            dataOutput.writeFloat(mapNpc.xPos);
            dataOutput.writeFloat(mapNpc.yPos);
            dataOutput.writeFloat(mapNpc.zPos);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.clear = dataInput.readBoolean();
        int n = dataInput.readInt();
        this.npcs = new ArrayList<MapNpc>();
        for (int i = 0; i < n; ++i) {
            EnumRoleType enumRoleType = EnumRoleType.values()[dataInput.readInt()];
            int n2 = dataInput.readInt();
            String string = dataInput.readUTF();
            float f = dataInput.readFloat();
            float f2 = dataInput.readFloat();
            float f3 = dataInput.readFloat();
            MapNpc mapNpc = new MapNpc(enumRoleType, n2, string, f, f2, f3);
            this.npcs.add(mapNpc);
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(boolean bl) {
        Map<Integer, MapNpc> map = PdaMod.getClientPda().npcs;
        if (this.clear) {
            map.clear();
        }
        this.npcs.forEach(mapNpc -> map.put(mapNpc.entityId, (MapNpc)mapNpc));
    }

    public NpcSyncPacket() {
    }
}

