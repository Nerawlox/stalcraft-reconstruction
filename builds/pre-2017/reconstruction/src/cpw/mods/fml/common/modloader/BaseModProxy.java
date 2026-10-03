/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.TickType;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public interface BaseModProxy {
    public void modsLoaded();

    public void load();

    public String getName();

    public String getPriorities();

    public String getVersion();

    public boolean doTickInGUI(TickType var1, boolean var2, Object ... var3);

    public boolean doTickInGame(TickType var1, boolean var2, Object ... var3);

    public void generateSurface(World var1, Random var2, int var3, int var4);

    public void generateNether(World var1, Random var2, int var3, int var4);

    public int addFuel(int var1, int var2);

    public void takenFromCrafting(EntityPlayer var1, ItemStack var2, IInventory var3);

    public void takenFromFurnace(EntityPlayer var1, ItemStack var2);

    public void onClientLogout(jjpj var1);

    public void onClientLogin(EntityPlayer var1);

    public void serverDisconnect();

    public void serverConnect(NetHandler var1);

    public void receiveCustomPacket(Packet250CustomPayload var1);

    public void clientChat(String var1);

    public void onItemPickup(EntityPlayer var1, ItemStack var2);

    public void serverCustomPayload(NetServerHandler var1, Packet250CustomPayload var2);

    public void serverChat(NetServerHandler var1, String var2);
}

