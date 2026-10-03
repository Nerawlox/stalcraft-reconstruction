/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketGuideTeleportRequest
extends zwat {
    private int guideId;
    private String targetLocation;

    public PacketGuideTeleportRequest(int n, String string) {
        this.guideId = n;
        this.targetLocation = string;
    }

    public PacketGuideTeleportRequest() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.guideId = dataInput.readInt();
        this.targetLocation = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.guideId);
        dataOutput.writeUTF(this.targetLocation);
    }
}

