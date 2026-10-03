/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;

public class ForgeInternalHandler {
    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void onEntityJoinWorld(EntityJoinWorldEvent entityJoinWorldEvent) {
        Entity entity;
        if (!entityJoinWorldEvent.world.field_72995_K) {
            ForgeChunkManager.loadEntity(entityJoinWorldEvent.entity);
        }
        if ((entity = entityJoinWorldEvent.entity).getClass().equals(EntityItem.class)) {
            Entity entity2;
            cvzo cvzo2 = entity.func_70096_w()._f(10);
            if (cvzo2 == null) {
                return;
            }
            tgdv tgdv2 = cvzo2._a();
            if (tgdv2 == null) {
                FMLLog.warning("Attempted to add a EntityItem to the world with a invalid item: ID %d at (%2.2f,  %2.2f, %2.2f), this is most likely a config issue between you and the server. Please double check your configs", cvzo2._d, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
                entity.func_70106_y();
                entityJoinWorldEvent.setCanceled(true);
                return;
            }
            if (tgdv2.hasCustomEntity(cvzo2) && (entity2 = tgdv2.createEntity(entityJoinWorldEvent.world, entity, cvzo2)) != null) {
                entity.func_70106_y();
                entityJoinWorldEvent.setCanceled(true);
                entityJoinWorldEvent.world.func_72838_d(entity2);
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

