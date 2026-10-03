/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketBuyTradepack
extends zwat {
    private int supplierId;
    private int slotId;

    public PacketBuyTradepack(int n, int n2) {
        this.supplierId = n;
        this.slotId = n2;
    }

    public PacketBuyTradepack() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.supplierId = dataInput.readInt();
        this.slotId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.supplierId);
        dataOutput.writeInt(this.slotId);
    }
}

