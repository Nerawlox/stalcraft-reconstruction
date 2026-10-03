/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon;

import net.minecraft.network.packet.Packet250CustomPayload;

public interface SupportsIncomingMessages {
    public void onIncomingMessage(Packet250CustomPayload var1);
}

