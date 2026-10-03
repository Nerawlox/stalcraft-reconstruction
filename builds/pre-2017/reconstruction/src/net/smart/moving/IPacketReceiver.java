/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.network.packet.Packet250CustomPayload;
import net.smart.moving.IEntityPlayerMP;

public interface IPacketReceiver {
    public boolean processStatePacket(Packet250CustomPayload var1, IEntityPlayerMP var2, int var3, long var4);
}

