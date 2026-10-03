/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

public class PacketSetDungeons
extends zwat {
    private int entityId;
    private List<String> dungeons;

    public PacketSetDungeons(int n, List<String> list) {
        this.entityId = n;
        this.dungeons = list;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        PacketSetDungeons.writeStringList(this.dungeons, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.dungeons = PacketSetDungeons.readStringList(dataInput);
    }

    public PacketSetDungeons() {
    }
}

