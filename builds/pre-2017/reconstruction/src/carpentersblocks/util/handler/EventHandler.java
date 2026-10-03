/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.block.BlockBase;
import carpentersblocks.util.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventHandler {
    public static int eventFace;
    public static Entity eventEntity;

    @ForgeSubscribe
    public void playerInteractEvent(PlayerInteractEvent playerInteractEvent) {
        int n = playerInteractEvent.entity.worldObj.getBlockId(playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z);
        if (n > 0 && Block.blocksList[n] instanceof BlockBase) {
            ItemStack itemStack;
            BlockBase blockBase = (BlockBase)Block.blocksList[n];
            eventEntity = playerInteractEvent.entity;
            if (playerInteractEvent.action.equals((Object)PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
                eventFace = playerInteractEvent.face;
            } else if (playerInteractEvent.entityPlayer.isSneaking() && (itemStack = playerInteractEvent.entityPlayer.getHeldItem()) != null && itemStack._d == ItemHandler.itemCarpentersHammerID) {
                blockBase.onBlockActivated(playerInteractEvent.entity.worldObj, playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z, playerInteractEvent.entityPlayer, playerInteractEvent.face, 1.0f, 1.0f, 1.0f);
            }
        }
    }
}

