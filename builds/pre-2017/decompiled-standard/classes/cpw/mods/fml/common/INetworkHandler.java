/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

public interface INetworkHandler {
    public boolean onChat(Object ... var1);

    public void onPacket250Packet(Object ... var1);

    public void onServerLogin(Object var1);
}

