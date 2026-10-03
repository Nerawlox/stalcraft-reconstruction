/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSortTrader
extends zwat {
    private boolean reversed;

    public PacketSortTrader(boolean bl) {
        this.reversed = bl;
    }

    public PacketSortTrader() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.reversed = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this.reversed);
    }
}

