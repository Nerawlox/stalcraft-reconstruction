/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketIgnoreAction
extends zwat {
    private String player;
    private boolean ignore;

    public PacketIgnoreAction(String string, boolean bl) {
        this.player = string;
        this.ignore = bl;
    }

    public PacketIgnoreAction() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.player = dataInput.readUTF();
        this.ignore = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.player);
        dataOutput.writeBoolean(this.ignore);
    }
}

