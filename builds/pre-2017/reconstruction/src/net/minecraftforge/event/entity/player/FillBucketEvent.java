/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@Event.HasResult
public class FillBucketEvent
extends PlayerEvent {
    public final ItemStack current;
    public final World world;
    public final MovingObjectPosition target;
    public ItemStack result;
    private static ListenerList LISTENER_LIST;

    public FillBucketEvent(EntityPlayer entityPlayer, ItemStack itemStack, World world, MovingObjectPosition movingObjectPosition) {
        super(entityPlayer);
        this.current = itemStack;
        this.world = world;
        this.target = movingObjectPosition;
    }

    public FillBucketEvent() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (LISTENER_LIST != null) {
            return;
        }
        LISTENER_LIST = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return LISTENER_LIST;
    }
}

