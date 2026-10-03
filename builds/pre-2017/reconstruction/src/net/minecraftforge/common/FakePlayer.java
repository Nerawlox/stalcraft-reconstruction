/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FakePlayer
extends EntityPlayerMP {
    public FakePlayer(World world, String string) {
        super(FMLCommonHandler.instance().getMinecraftServerInstance(), world, string, new ItemInWorldManager(world));
    }

    public void sendChatToPlayer(String string) {
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return false;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(0, 0, 0);
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
    }

    @Override
    public void addStat(StatBase statBase, int n) {
    }

    @Override
    public void openGui(Object object, int n, World world, int n2, int n3, int n4) {
    }

    @Override
    public boolean isEntityInvulnerable() {
        return true;
    }

    @Override
    public boolean canAttackPlayer(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void travelToDimension(int n) {
    }

    @Override
    public void updateClientInfo(Packet204ClientInfo packet204ClientInfo) {
    }
}

