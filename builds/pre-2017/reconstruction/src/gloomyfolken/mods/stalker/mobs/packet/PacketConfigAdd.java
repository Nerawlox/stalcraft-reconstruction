/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketConfigAdd
extends PacketConfig {
    public String name;
    public String json;

    public PacketConfigAdd(String string, MutantConfiguration mutantConfiguration) {
        this.name = string;
        this.json = ConfigJsonHelper.write(mutantConfiguration);
    }

    public PacketConfigAdd(MutantConfiguration mutantConfiguration) {
        this.name = mutantConfiguration.getCommon().getName();
        this.json = ConfigJsonHelper.write(mutantConfiguration);
    }

    public PacketConfigAdd() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.name = dataInput.readUTF();
        this.json = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this.name);
        dataOutput.writeUTF(this.json);
    }
}

