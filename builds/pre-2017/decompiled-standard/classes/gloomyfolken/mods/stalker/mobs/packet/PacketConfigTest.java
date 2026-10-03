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

public class PacketConfigTest
extends PacketConfig {
    public String json;

    public PacketConfigTest(MutantConfiguration mutantConfiguration) {
        this.json = ConfigJsonHelper.write(mutantConfiguration);
    }

    public PacketConfigTest() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.json = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this.json);
    }
}

