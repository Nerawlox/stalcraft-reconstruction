/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;

public class ForgeInternalHandler {
    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void onEntityJoinWorld(EntityJoinWorldEvent entityJoinWorldEvent) {
        Entity entity;
        if (!entityJoinWorldEvent.world.isRemote) {
            ForgeChunkManager.loadEntity(entityJoinWorldEvent.entity);
        }
        if ((entity = entityJoinWorldEvent.entity).getClass().equals(EntityItem.class)) {
            Entity entity2;
            ItemStack itemStack = entity.getDataWatcher()._f(10);
            if (itemStack == null) {
                return;
            }
            Item item = itemStack._a();
            if (item == null) {
                FMLLog.warning("Attempted to add a EntityItem to the world with a invalid item: ID %d at (%2.2f,  %2.2f, %2.2f), this is most likely a config issue between you and the server. Please double check your configs", itemStack._d, entity.posX, entity.posY, entity.posZ);
                entity.setDead();
                entityJoinWorldEvent.setCanceled(true);
                return;
            }
            if (item.hasCustomEntity(itemStack) && (entity2 = item.createEntity(entityJoinWorldEvent.world, entity, itemStack)) != null) {
                entity.setDead();
                entityJoinWorldEvent.setCanceled(true);
                entityJoinWorldEvent.world.spawnEntityInWorld(entity2);
            }
        }
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void onDimensionLoad(WorldEvent.Load load) {
        ForgeChunkManager.loadWorld(load.world);
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void onDimensionSave(WorldEvent.Save save) {
        ForgeChunkManager.saveWorld(save.world);
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void onDimensionUnload(WorldEvent.Unload unload) {
        ForgeChunkManager.unloadWorld(unload.world);
    }
}

