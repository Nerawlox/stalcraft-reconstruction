/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import noppes.npcs.constants.EnumRoleType;

public class PacketInteractClosestNpc
extends zwat {
    public EnumRoleType role;

    public PacketInteractClosestNpc(EnumRoleType enumRoleType) {
        this.role = enumRoleType;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.role.ordinal());
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.role = EnumRoleType.values()[dataInput.readByte()];
    }

    public PacketInteractClosestNpc() {
    }
}

