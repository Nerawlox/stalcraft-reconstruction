/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketDeleteCorpse
extends zwat {
    public int corpseId;

    public PacketDeleteCorpse(int n) {
        this.corpseId = -1;
        this.corpseId = n;
    }

    public PacketDeleteCorpse() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.corpseId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.corpseId);
    }
}

