/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@Deprecated
public abstract class BaseMod
implements BaseModProxy {
    @Override
    @Deprecated
    public final boolean doTickInGame(TickType tickType, boolean bl, Object ... objectArray) {
        boolean bl2;
        Minecraft minecraft = FMLClientHandler.instance().getClient();
        boolean bl3 = bl2 = minecraft._r != null;
        if (bl && (tickType == TickType.RENDER || tickType == TickType.CLIENT) && bl2) {
            return this.onTickInGame(((Float)objectArray[0]).floatValue(), minecraft);
        }
        return true;
    }

    @Override
    @Deprecated
    public final boolean doTickInGUI(TickType tickType, boolean bl, Object ... objectArray) {
        boolean bl2;
        Minecraft minecraft = FMLClientHandler.instance().getClient();
        boolean bl3 = bl2 = minecraft._r != null;
        if (bl && (tickType == TickType.RENDER || tickType == TickType.CLIENT && bl2)) {
            return this.onTickInGUI(((Float)objectArray[0]).floatValue(), minecraft, minecraft._B);
        }
        return true;
    }

    @Override
    @Deprecated
    public int addFuel(int n, int n2) {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void addRenderer(Map<Class<? extends Entity>, Render> map) {
    }

    @Override
    @Deprecated
    public void generateNether(World world, Random random, int n, int n2) {
    }

    @Override
    @Deprecated
    public void generateSurface(World world, Random random, int n, int n2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public GuiContainer getContainerGUI(EntityClientPlayerMP entityClientPlayerMP, int n, int n2, int n3, int n4) {
        return null;
    }

    @Override
    @Deprecated
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    @Deprecated
    public String getPriorities() {
        return "";
    }

    @Override
    @Deprecated
    public abstract String getVersion();

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void keyboardEvent(KeyBinding keyBinding) {
    }

    @Override
    @Deprecated
    public abstract void load();

    @Override
    @Deprecated
    public void modsLoaded() {
    }

    @Override
    @Deprecated
    public void onItemPickup(EntityPlayer entityPlayer, ItemStack itemStack) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean onTickInGame(float f, Minecraft minecraft) {
        return false;
    }

    @Deprecated
    public boolean onTickInGame(MinecraftServer minecraftServer) {
        return false;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiScreen) {
        return false;
    }

    @Override
    @Deprecated
    public void clientChat(String string) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void clientConnect(bscn bscn2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void clientDisconnect(bscn bscn2) {
    }

    @Override
    @Deprecated
    public void receiveCustomPacket(Packet250CustomPayload packet250CustomPayload) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void registerAnimation(Minecraft minecraft) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void renderInvBlock(RenderBlocks renderBlocks, Block block, int n, int n2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4) {
        return false;
    }

    @Override
    @Deprecated
    public void serverConnect(NetHandler netHandler) {
    }

    @Override
    @Deprecated
    public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {
    }

    @Override
    @Deprecated
    public void serverDisconnect() {
    }

    @Override
    @Deprecated
    public void takenFromCrafting(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {
    }

    @Override
    @Deprecated
    public void takenFromFurnace(EntityPlayer entityPlayer, ItemStack itemStack) {
    }

    public String toString() {
        return this.getName() + " " + this.getVersion();
    }

    @Override
    @Deprecated
    public void serverChat(NetServerHandler netServerHandler, String string) {
    }

    @Override
    @Deprecated
    public void onClientLogin(EntityPlayer entityPlayer) {
    }

    @Override
    @Deprecated
    public void onClientLogout(jjpj jjpj2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public Entity spawnEntity(int n, World world, double d, double d2, double d3) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void clientCustomPayload(bscn bscn2, Packet250CustomPayload packet250CustomPayload) {
    }
}

