/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketClientNoise
extends zwat {
    private float noiseAdd;

    public PacketClientNoise(float f) {
        this.noiseAdd = 0.0f;
        this.noiseAdd = f;
    }

    public PacketClientNoise() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.noiseAdd = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.noiseAdd);
    }
}

