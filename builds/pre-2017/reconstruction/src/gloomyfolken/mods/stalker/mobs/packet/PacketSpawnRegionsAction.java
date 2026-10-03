/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSpawnRegionsAction
extends PacketSpawnRegionsBase {
    public int actionId;

    public PacketSpawnRegionsAction(int n) {
        this.actionId = 0;
        this.actionId = n;
    }

    public PacketSpawnRegionsAction() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.actionId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this.actionId);
    }
}

