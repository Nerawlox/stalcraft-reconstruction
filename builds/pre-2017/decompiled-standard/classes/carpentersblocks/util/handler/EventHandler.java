/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.block.BlockBase;
import carpentersblocks.util.handler.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventHandler {
    public static int eventFace;
    public static Entity eventEntity;

    @ForgeSubscribe
    public void playerInteractEvent(PlayerInteractEvent playerInteractEvent) {
        int n = playerInteractEvent.entity.field_70170_p.func_72798_a(playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z);
        if (n > 0 && twgu.field_71973_m[n] instanceof BlockBase) {
            cvzo cvzo2;
            BlockBase blockBase = (BlockBase)twgu.field_71973_m[n];
            eventEntity = playerInteractEvent.entity;
            if (playerInteractEvent.action.equals((Object)PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
                eventFace = playerInteractEvent.face;
            } else if (playerInteractEvent.entityPlayer.func_70093_af() && (cvzo2 = playerInteractEvent.entityPlayer.func_70694_bm()) != null && cvzo2._d == ItemHandler.itemCarpentersHammerID) {
                blockBase.func_71903_a(playerInteractEvent.entity.field_70170_p, playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z, playerInteractEvent.entityPlayer, playerInteractEvent.face, 1.0f, 1.0f, 1.0f);
            }
        }
    }
}

