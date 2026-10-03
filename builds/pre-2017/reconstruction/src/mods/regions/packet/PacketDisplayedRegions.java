/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mods.regions.RegionsMod;

public class PacketDisplayedRegions
extends zwat {
    private List<String> regions;

    public PacketDisplayedRegions(Set<String> set) {
        this.regions = new ArrayList<String>(set);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        PacketDisplayedRegions.writeStringList(this.regions, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.regions = PacketDisplayedRegions.readStringList(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        RegionsMod.regionsClient.displayedRegions = new HashSet<String>(this.regions);
    }

    public PacketDisplayedRegions() {
    }
}

