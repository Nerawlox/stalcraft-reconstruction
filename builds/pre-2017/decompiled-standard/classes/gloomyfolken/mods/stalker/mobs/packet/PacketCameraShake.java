/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketCameraShake
extends zwat {
    public int shakeAmount;
    public double sourceX;
    public double sourceY;
    public double sourceZ;

    public PacketCameraShake(int n, double d, double d2, double d3) {
        this.shakeAmount = 0;
        this.sourceX = 0.0;
        this.sourceY = 0.0;
        this.sourceZ = 0.0;
        this.shakeAmount = n;
        this.sourceX = d;
        this.sourceY = d2;
        this.sourceZ = d3;
    }

    @Override
    public void processClient(boolean bl) {
    }

    public PacketCameraShake() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.shakeAmount = dataInput.readInt();
        this.sourceX = dataInput.readDouble();
        this.sourceY = dataInput.readDouble();
        this.sourceZ = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.shakeAmount);
        dataOutput.writeDouble(this.sourceX);
        dataOutput.writeDouble(this.sourceY);
        dataOutput.writeDouble(this.sourceZ);
    }
}

