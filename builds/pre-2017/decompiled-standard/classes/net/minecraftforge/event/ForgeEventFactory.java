/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.living.LivingPackSizeEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;

public class ForgeEventFactory {
    public static boolean doPlayerHarvestCheck(EntityPlayer entityPlayer, twgu twgu2, boolean bl) {
        PlayerEvent.HarvestCheck harvestCheck = new PlayerEvent.HarvestCheck(entityPlayer, twgu2, bl);
        MinecraftForge.EVENT_BUS.post(harvestCheck);
        return harvestCheck.success;
    }

    public static float getBreakSpeed(EntityPlayer entityPlayer, twgu twgu2, int n, float f) {
        PlayerEvent.BreakSpeed breakSpeed = new PlayerEvent.BreakSpeed(entityPlayer, twgu2, n, f);
        return MinecraftForge.EVENT_BUS.post(breakSpeed) ? -1.0f : breakSpeed.newSpeed;
    }

    public static PlayerInteractEvent onPlayerInteract(EntityPlayer entityPlayer, PlayerInteractEvent.Action action, int n, int n2, int n3, int n4) {
        PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent(entityPlayer, action, n, n2, n3, n4);
        MinecraftForge.EVENT_BUS.post(playerInteractEvent);
        return playerInteractEvent;
    }

    public static void onPlayerDestroyItem(EntityPlayer entityPlayer, cvzo cvzo2) {
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, cvzo2));
    }

    public static Event.Result canEntitySpawn(EntityLiving entityLiving, ozlu ozlu2, float f, float f2, float f3) {
        LivingSpawnEvent.CheckSpawn checkSpawn = new LivingSpawnEvent.CheckSpawn(entityLiving, ozlu2, f, f2, f3);
        MinecraftForge.EVENT_BUS.post(checkSpawn);
        return checkSpawn.getResult();
    }

    public static boolean doSpecialSpawn(EntityLiving entityLiving, ozlu ozlu2, float f, float f2, float f3) {
        return MinecraftForge.EVENT_BUS.post(new LivingSpawnEvent.SpecialSpawn(entityLiving, ozlu2, f, f2, f3));
    }

    public static Event.Result canEntityDespawn(EntityLiving entityLiving) {
        LivingSpawnEvent.AllowDespawn allowDespawn = new LivingSpawnEvent.AllowDespawn(entityLiving);
        MinecraftForge.EVENT_BUS.post(allowDespawn);
        return allowDespawn.getResult();
    }

    public static List getPotentialSpawns(yfgy yfgy2, jxsn jxsn2, int n, int n2, int n3, List list2) {
        WorldEvent.PotentialSpawns potentialSpawns = new WorldEvent.PotentialSpawns(yfgy2, jxsn2, n, n2, n3, list2);
        if (MinecraftForge.EVENT_BUS.post(potentialSpawns)) {
            return null;
        }
        return potentialSpawns.list;
    }

    public static int getMaxSpawnPackSize(EntityLiving entityLiving) {
        LivingPackSizeEvent livingPackSizeEvent = new LivingPackSizeEvent(entityLiving);
        MinecraftForge.EVENT_BUS.post(livingPackSizeEvent);
        return livingPackSizeEvent.getResult() == Event.Result.ALLOW ? livingPackSizeEvent.maxPackSize : entityLiving.func_70641_bl();
    }

    public static String getPlayerDisplayName(EntityPlayer entityPlayer, String string) {
        PlayerEvent.NameFormat nameFormat = new PlayerEvent.NameFormat(entityPlayer, string);
        MinecraftForge.EVENT_BUS.post(nameFormat);
        return nameFormat.displayname;
    }

    public static float fireBlockHarvesting(ArrayList<cvzo> arrayList, ozlu ozlu2, twgu twgu2, int n, int n2, int n3, int n4, int n5, float f, boolean bl, EntityPlayer entityPlayer) {
        BlockEvent.HarvestDropsEvent harvestDropsEvent = new BlockEvent.HarvestDropsEvent(n, n2, n3, ozlu2, twgu2, n4, n5, f, arrayList, entityPlayer, bl);
        MinecraftForge.EVENT_BUS.post(harvestDropsEvent);
        return harvestDropsEvent.dropChance;
    }

    public static ItemTooltipEvent onItemTooltip(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2, boolean bl) {
        ItemTooltipEvent itemTooltipEvent = new ItemTooltipEvent(cvzo2, entityPlayer, list2, bl);
        MinecraftForge.EVENT_BUS.post(itemTooltipEvent);
        return itemTooltipEvent;
    }

    public static ZombieEvent.SummonAidEvent fireZombieSummonAid(EntityZombie entityZombie, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, double d) {
        ZombieEvent.SummonAidEvent summonAidEvent = new ZombieEvent.SummonAidEvent(entityZombie, ozlu2, n, n2, n3, entityLivingBase, d);
        MinecraftForge.EVENT_BUS.post(summonAidEvent);
        return summonAidEvent;
    }
}

