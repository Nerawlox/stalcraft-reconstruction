/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.client.tuning.gui.RegionEdit;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketSpawnRegionsData
extends PacketSpawnRegionsBase {
    public String regionsJson;
    public int action;

    public PacketSpawnRegionsData(String string, int n) {
        this.regionsJson = "";
        this.action = 0;
        this.regionsJson = string;
        this.action = n;
    }

    @Override
    public void processClient(boolean bl) {
        if (this.action == 1) {
            RegionEdit.instance.setRegionsData(this.regionsJson);
            try {
                RegionEdit.instance.saveRegionsToFileAndSetActive();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public PacketSpawnRegionsData() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.regionsJson = dataInput.readUTF();
        this.action = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this.regionsJson);
        dataOutput.writeInt(this.action);
    }
}

