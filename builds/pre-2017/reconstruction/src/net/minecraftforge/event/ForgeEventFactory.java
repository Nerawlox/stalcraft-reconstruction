/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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
    public static boolean doPlayerHarvestCheck(EntityPlayer entityPlayer, Block block, boolean bl) {
        PlayerEvent.HarvestCheck harvestCheck = new PlayerEvent.HarvestCheck(entityPlayer, block, bl);
        MinecraftForge.EVENT_BUS.post(harvestCheck);
        return harvestCheck.success;
    }

    public static float getBreakSpeed(EntityPlayer entityPlayer, Block block, int n, float f) {
        PlayerEvent.BreakSpeed breakSpeed = new PlayerEvent.BreakSpeed(entityPlayer, block, n, f);
        return MinecraftForge.EVENT_BUS.post(breakSpeed) ? -1.0f : breakSpeed.newSpeed;
    }

    public static PlayerInteractEvent onPlayerInteract(EntityPlayer entityPlayer, PlayerInteractEvent.Action action, int n, int n2, int n3, int n4) {
        PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent(entityPlayer, action, n, n2, n3, n4);
        MinecraftForge.EVENT_BUS.post(playerInteractEvent);
        return playerInteractEvent;
    }

    public static void onPlayerDestroyItem(EntityPlayer entityPlayer, ItemStack itemStack) {
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, itemStack));
    }

    public static Event.Result canEntitySpawn(EntityLiving entityLiving, World world, float f, float f2, float f3) {
        LivingSpawnEvent.CheckSpawn checkSpawn = new LivingSpawnEvent.CheckSpawn(entityLiving, world, f, f2, f3);
        MinecraftForge.EVENT_BUS.post(checkSpawn);
        return checkSpawn.getResult();
    }

    public static boolean doSpecialSpawn(EntityLiving entityLiving, World world, float f, float f2, float f3) {
        return MinecraftForge.EVENT_BUS.post(new LivingSpawnEvent.SpecialSpawn(entityLiving, world, f, f2, f3));
    }

    public static Event.Result canEntityDespawn(EntityLiving entityLiving) {
        LivingSpawnEvent.AllowDespawn allowDespawn = new LivingSpawnEvent.AllowDespawn(entityLiving);
        MinecraftForge.EVENT_BUS.post(allowDespawn);
        return allowDespawn.getResult();
    }

    public static List getPotentialSpawns(WorldServer worldServer, EnumCreatureType enumCreatureType, int n, int n2, int n3, List list2) {
        WorldEvent.PotentialSpawns potentialSpawns = new WorldEvent.PotentialSpawns(worldServer, enumCreatureType, n, n2, n3, list2);
        if (MinecraftForge.EVENT_BUS.post(potentialSpawns)) {
            return null;
        }
        return potentialSpawns.list;
    }

    public static int getMaxSpawnPackSize(EntityLiving entityLiving) {
        LivingPackSizeEvent livingPackSizeEvent = new LivingPackSizeEvent(entityLiving);
        MinecraftForge.EVENT_BUS.post(livingPackSizeEvent);
        return livingPackSizeEvent.getResult() == Event.Result.ALLOW ? livingPackSizeEvent.maxPackSize : entityLiving.getMaxSpawnedInChunk();
    }

    public static String getPlayerDisplayName(EntityPlayer entityPlayer, String string) {
        PlayerEvent.NameFormat nameFormat = new PlayerEvent.NameFormat(entityPlayer, string);
        MinecraftForge.EVENT_BUS.post(nameFormat);
        return nameFormat.displayname;
    }

    public static float fireBlockHarvesting(ArrayList<ItemStack> arrayList, World world, Block block, int n, int n2, int n3, int n4, int n5, float f, boolean bl, EntityPlayer entityPlayer) {
        BlockEvent.HarvestDropsEvent harvestDropsEvent = new BlockEvent.HarvestDropsEvent(n, n2, n3, world, block, n4, n5, f, arrayList, entityPlayer, bl);
        MinecraftForge.EVENT_BUS.post(harvestDropsEvent);
        return harvestDropsEvent.dropChance;
    }

    public static ItemTooltipEvent onItemTooltip(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2, boolean bl) {
        ItemTooltipEvent itemTooltipEvent = new ItemTooltipEvent(itemStack, entityPlayer, list2, bl);
        MinecraftForge.EVENT_BUS.post(itemTooltipEvent);
        return itemTooltipEvent;
    }

    public static ZombieEvent.SummonAidEvent fireZombieSummonAid(EntityZombie entityZombie, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, double d) {
        ZombieEvent.SummonAidEvent summonAidEvent = new ZombieEvent.SummonAidEvent(entityZombie, world, n, n2, n3, entityLivingBase, d);
        MinecraftForge.EVENT_BUS.post(summonAidEvent);
        return summonAidEvent;
    }
}

