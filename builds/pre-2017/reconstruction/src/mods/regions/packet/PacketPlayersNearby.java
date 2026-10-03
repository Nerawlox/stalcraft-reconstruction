/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.pda.PdaMod;

public class PacketPlayersNearby
extends zwat {
    private int players;

    public PacketPlayersNearby(int n) {
        this.players = n;
    }

    @Override
    public void processClient(boolean bl) {
        PdaMod.instance.minimap.updatePlayersCount(this.players);
    }

    public PacketPlayersNearby() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.players = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.players);
    }
}

