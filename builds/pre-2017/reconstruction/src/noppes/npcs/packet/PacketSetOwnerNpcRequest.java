/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSetOwnerNpcRequest
extends ytyx {
    public int entityId;
    public boolean clearOwner;

    public PacketSetOwnerNpcRequest(int n, boolean bl) {
        this.entityId = n;
        this.clearOwner = bl;
    }

    public PacketSetOwnerNpcRequest() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.clearOwner = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        dataOutput.writeBoolean(this.clearOwner);
    }
}

