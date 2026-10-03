/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketConfigDelete
extends PacketConfig {
    public String name;

    public PacketConfigDelete(String string) {
        this.name = string;
    }

    public PacketConfigDelete() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.name = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this.name);
    }
}

