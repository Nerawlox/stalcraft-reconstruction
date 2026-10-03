/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;

public class ModLoaderPacketHandler
implements IPacketHandler {
    private BaseModProxy mod;

    public ModLoaderPacketHandler(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        if (player instanceof EntityPlayerMP) {
            this.mod.serverCustomPayload(((EntityPlayerMP)player).playerNetServerHandler, packet250CustomPayload);
        } else {
            ModLoaderHelper.sidedHelper.sendClientPacket(this.mod, packet250CustomPayload);
        }
    }
}

