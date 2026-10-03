/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.packet.DebugPathTest;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketPathMark
extends zwat {
    public int x;
    public int y;
    public int z;

    public PacketPathMark(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    @Override
    public void processClient(boolean bl) {
        DebugPathTest.markPoint(this.x, this.y, this.z);
    }

    public PacketPathMark() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.x = dataInput.readInt();
        this.y = dataInput.readInt();
        this.z = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.x);
        dataOutput.writeInt(this.y);
        dataOutput.writeInt(this.z);
    }
}

