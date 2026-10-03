/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;

public interface IModLoaderSidedHelper {
    public void finishModLoading(ModLoaderModContainer var1);

    public Object getClientGui(BaseModProxy var1, EntityPlayer var2, int var3, int var4, int var5, int var6);

    public Entity spawnEntity(BaseModProxy var1, EntitySpawnPacket var2, EntityRegistry.EntityRegistration var3);

    public void sendClientPacket(BaseModProxy var1, Packet250CustomPayload var2);

    public void clientConnectionOpened(NetHandler var1, jjpj var2, BaseModProxy var3);

    public boolean clientConnectionClosed(jjpj var1, BaseModProxy var2);
}

