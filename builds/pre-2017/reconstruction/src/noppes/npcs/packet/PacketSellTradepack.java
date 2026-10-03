/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSellTradepack
extends zwat {
    private int supplierId;

    public PacketSellTradepack(int n) {
        this.supplierId = n;
    }

    public PacketSellTradepack() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.supplierId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.supplierId);
    }
}

