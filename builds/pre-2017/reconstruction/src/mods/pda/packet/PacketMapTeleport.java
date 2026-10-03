/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketMapTeleport
extends zwat {
    public int x;
    public int z;

    public PacketMapTeleport(int n, int n2) {
        this.x = n;
        this.z = n2;
    }

    public PacketMapTeleport() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.x = dataInput.readInt();
        this.z = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.x);
        dataOutput.writeInt(this.z);
    }
}

