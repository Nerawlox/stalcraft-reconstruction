/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.client.tuning.gui.RegionEdit;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSpawnStatistics
extends PacketSpawnRegionsBase {
    public int maxMutantCount;
    public int mutantCount;

    public PacketSpawnStatistics(int n, int n2) {
        this.maxMutantCount = 0;
        this.mutantCount = 0;
        this.maxMutantCount = n;
        this.mutantCount = n2;
    }

    @Override
    public void processClient(boolean bl) {
        if (RegionEdit.instance != null) {
            RegionEdit.instance.setMutantCount(this.mutantCount, this.maxMutantCount);
        }
    }

    public PacketSpawnStatistics() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.maxMutantCount = dataInput.readInt();
        this.mutantCount = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this.maxMutantCount);
        dataOutput.writeInt(this.mutantCount);
    }
}

