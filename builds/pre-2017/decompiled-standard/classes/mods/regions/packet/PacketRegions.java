/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import cpw.mods.fml.common.FMLLog;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import mods.regions.Region;
import mods.regions.RegionFlag;
import mods.regions.RegionsMod;

public class PacketRegions
extends zwat {
    private List<Region> regions;

    public PacketRegions(Collection<Region> collection) {
        this.regions = new ArrayList<Region>(collection);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.regions.size());
        for (Region region : this.regions) {
            dataOutput.writeUTF(region.getTitle());
            dataOutput.writeInt(region.getBoxes().size());
            for (dfkn dfkn2 : region.getBoxes()) {
                dataOutput.writeDouble(dfkn2._a);
                dataOutput.writeDouble(dfkn2._b);
                dataOutput.writeDouble(dfkn2._c);
                dataOutput.writeDouble(dfkn2._d);
                dataOutput.writeDouble(dfkn2._e);
                dataOutput.writeDouble(dfkn2._f);
            }
            for (Map.Entry entry : Region.registeredFlags.entrySet()) {
                Object object = region.get((RegionFlag)entry.getValue());
                if (object == null || !((RegionFlag)entry.getValue()).synced) continue;
                dataOutput.writeBoolean(true);
                dataOutput.writeUTF((String)entry.getKey());
                ((RegionFlag)entry.getValue()).adapter.write(object, dataOutput);
            }
            dataOutput.writeBoolean(false);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.regions = new ArrayList<Region>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            int n2 = dataInput.readInt();
            HashSet<dfkn> hashSet = new HashSet<dfkn>();
            for (int j = 0; j < n2; ++j) {
                hashSet.add(new dfkn(dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble()));
            }
            Region region = new Region(string, "", -1L, hashSet);
            while (dataInput.readBoolean()) {
                String string2 = dataInput.readUTF();
                RegionFlag regionFlag = Region.registeredFlags.get(string2);
                if (regionFlag == null) {
                    FMLLog.warning("Unknown region flag: " + string2, new Object[0]);
                    continue;
                }
                region.set(regionFlag, regionFlag.adapter.read(dataInput));
            }
            this.regions.add(region);
        }
    }

    @Override
    public void processClient(boolean bl) {
        RegionsMod.regionsClient.setRegions(this.regions);
    }

    public PacketRegions() {
    }
}

