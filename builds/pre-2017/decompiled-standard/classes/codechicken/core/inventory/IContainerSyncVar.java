/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.lib.packet.PacketCustom;

public interface IContainerSyncVar {
    public boolean changed();

    public void reset();

    public void writeChange(PacketCustom var1);

    public void readChange(PacketCustom var1);
}

