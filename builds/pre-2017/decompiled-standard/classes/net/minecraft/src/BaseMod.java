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
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@Deprecated
public abstract class BaseMod
implements BaseModProxy {
    @Override
    @Deprecated
    public final boolean doTickInGame(TickType tickType, boolean bl, Object ... objectArray) {
        boolean bl2;
        xpzm xpzm2 = FMLClientHandler.instance().getClient();
        boolean bl3 = bl2 = xpzm2._r != null;
        if (bl && (tickType == TickType.RENDER || tickType == TickType.CLIENT) && bl2) {
            return this.onTickInGame(((Float)objectArray[0]).floatValue(), xpzm2);
        }
        return true;
    }

    @Override
    @Deprecated
    public final boolean doTickInGUI(TickType tickType, boolean bl, Object ... objectArray) {
        boolean bl2;
        xpzm xpzm2 = FMLClientHandler.instance().getClient();
        boolean bl3 = bl2 = xpzm2._r != null;
        if (bl && (tickType == TickType.RENDER || tickType == TickType.CLIENT && bl2)) {
            return this.onTickInGUI(((Float)objectArray[0]).floatValue(), xpzm2, xpzm2._B);
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
    public void addRenderer(Map<Class<? extends Entity>, tfvm> map) {
    }

    @Override
    @Deprecated
    public void generateNether(ozlu ozlu2, Random random, int n, int n2) {
    }

    @Override
    @Deprecated
    public void generateSurface(ozlu ozlu2, Random random, int n, int n2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public zybc getContainerGUI(EntityClientPlayerMP entityClientPlayerMP, int n, int n2, int n3, int n4) {
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
    public void keyboardEvent(eidj eidj2) {
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
    public void onItemPickup(EntityPlayer entityPlayer, cvzo cvzo2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean onTickInGame(float f, xpzm xpzm2) {
        return false;
    }

    @Deprecated
    public boolean onTickInGame(dzfd dzfd2) {
        return false;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean onTickInGUI(float f, xpzm xpzm2, gqjz gqjz2) {
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
    public void receiveCustomPacket(jjqf jjqf2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void registerAnimation(xpzm xpzm2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void renderInvBlock(htvc htvc2, twgu twgu2, int n, int n2) {
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public boolean renderWorldBlock(htvc htvc2, sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4) {
        return false;
    }

    @Override
    @Deprecated
    public void serverConnect(elai elai2) {
    }

    @Override
    @Deprecated
    public void serverCustomPayload(xbvu xbvu2, jjqf jjqf2) {
    }

    @Override
    @Deprecated
    public void serverDisconnect() {
    }

    @Override
    @Deprecated
    public void takenFromCrafting(EntityPlayer entityPlayer, cvzo cvzo2, mssh mssh2) {
    }

    @Override
    @Deprecated
    public void takenFromFurnace(EntityPlayer entityPlayer, cvzo cvzo2) {
    }

    public String toString() {
        return this.getName() + " " + this.getVersion();
    }

    @Override
    @Deprecated
    public void serverChat(xbvu xbvu2, String string) {
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
    public Entity spawnEntity(int n, ozlu ozlu2, double d, double d2, double d3) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public void clientCustomPayload(bscn bscn2, jjqf jjqf2) {
    }
}

