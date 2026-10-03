/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.regions.RegionsMod;

public class PacketSelectionUpdate
extends zwat {
    public einh selectionA;
    public einh selectionB;

    public PacketSelectionUpdate(einh einh2, einh einh3) {
        this.selectionA = einh2;
        this.selectionB = einh3;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.writeLocation(this.selectionA, dataOutput);
        this.writeLocation(this.selectionB, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.selectionA = this.readLocation(dataInput);
        this.selectionB = this.readLocation(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        RegionsMod.regionsClient.setSelection(this.selectionA, this.selectionB);
    }

    private void writeLocation(einh einh2, DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(einh2._b);
        dataOutput.writeDouble(einh2._c);
        dataOutput.writeDouble(einh2._d);
        dataOutput.writeDouble(einh2._e);
    }

    private einh readLocation(DataInput dataInput) throws IOException {
        return new einh(dataInput.readInt(), dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble());
    }

    public PacketSelectionUpdate() {
    }
}

