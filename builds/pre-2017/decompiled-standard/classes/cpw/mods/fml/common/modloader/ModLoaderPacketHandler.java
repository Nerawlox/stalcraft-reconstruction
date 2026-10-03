/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayerMP;

public class ModLoaderPacketHandler
implements IPacketHandler {
    private BaseModProxy mod;

    public ModLoaderPacketHandler(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
        if (player instanceof EntityPlayerMP) {
            this.mod.serverCustomPayload(((EntityPlayerMP)player).field_71135_a, jjqf2);
        } else {
            ModLoaderHelper.sidedHelper.sendClientPacket(this.mod, jjqf2);
        }
    }
}

