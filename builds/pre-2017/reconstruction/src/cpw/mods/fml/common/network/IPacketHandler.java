/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import cpw.mods.fml.common.network.Player;
import net.minecraft.network.packet.Packet250CustomPayload;

public interface IPacketHandler {
    public void onPacketData(jjpj var1, Packet250CustomPayload var2, Player var3);
}

