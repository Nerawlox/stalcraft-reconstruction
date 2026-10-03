/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketEditTileConfig
extends PacketConfig {
    public boolean forgetTile;

    public PacketEditTileConfig(boolean bl) {
        this.forgetTile = false;
        this.forgetTile = bl;
    }

    public PacketEditTileConfig() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.forgetTile = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeBoolean(this.forgetTile);
    }
}

