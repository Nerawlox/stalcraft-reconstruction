/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.network.IChatListener;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet3Chat;

public class ModLoaderChatListener
implements IChatListener {
    private BaseModProxy mod;

    public ModLoaderChatListener(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public Packet3Chat serverChat(NetHandler netHandler, Packet3Chat packet3Chat) {
        this.mod.serverChat((NetServerHandler)netHandler, packet3Chat._a);
        return packet3Chat;
    }

    @Override
    public Packet3Chat clientChat(NetHandler netHandler, Packet3Chat packet3Chat) {
        this.mod.clientChat(packet3Chat._a);
        return packet3Chat;
    }
}

