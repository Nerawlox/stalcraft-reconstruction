/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.regions.RegionsMod;

public class PacketClearSelection
extends zwat {
    @Override
    public void processClient(boolean bl) {
        RegionsMod.regionsClient.clearSelection();
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

