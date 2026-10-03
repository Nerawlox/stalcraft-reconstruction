/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.RegionEdit;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;

public class PacketSpawnRegionsState
extends PacketSpawnRegionsBase {
    public NBTTagCompound overrideEnabledStatesNbt;
    public boolean isRequest;

    public PacketSpawnRegionsState(Map<String, Boolean> map) {
        this.overrideEnabledStatesNbt = new NBTTagCompound();
        this.isRequest = false;
        if (map == null) {
            this.isRequest = true;
        } else {
            map.forEach((string, bl) -> this.overrideEnabledStatesNbt._a((String)string, (boolean)bl));
        }
    }

    private Map<String, Boolean> getMap() {
        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        this.overrideEnabledStatesNbt._c.forEach((object, object2) -> hashMap.put((String)object, this.overrideEnabledStatesNbt._o((String)object)));
        return hashMap;
    }

    @Override
    public void processClient(boolean bl) {
        RegionEdit.instance.overrideRegionsState.clear();
        RegionEdit.instance.overrideRegionsState.putAll(this.getMap());
    }

    public PacketSpawnRegionsState() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.overrideEnabledStatesNbt = qlgf.readNBTTagCompound(dataInput);
        this.isRequest = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        qlgf.writeNBTTagCompound(this.overrideEnabledStatesNbt, dataOutput);
        dataOutput.writeBoolean(this.isRequest);
    }
}

