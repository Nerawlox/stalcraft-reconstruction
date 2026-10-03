/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.IContainerSyncVar;
import codechicken.lib.packet.PacketCustom;

public abstract class IntegerSync
implements IContainerSyncVar {
    public int c_value;

    @Override
    public boolean changed() {
        return this.getValue() != this.c_value;
    }

    @Override
    public void reset() {
        this.c_value = this.getValue();
    }

    @Override
    public void writeChange(PacketCustom packetCustom) {
        packetCustom.writeInt(this.getValue());
    }

    @Override
    public void readChange(PacketCustom packetCustom) {
        this.c_value = packetCustom.readInt();
    }

    public abstract int getValue();
}

