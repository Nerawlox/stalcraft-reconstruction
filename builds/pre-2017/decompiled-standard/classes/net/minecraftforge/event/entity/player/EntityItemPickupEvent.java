/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@Event.HasResult
public class EntityItemPickupEvent
extends PlayerEvent {
    public final EntityItem item;
    private boolean handled;
    private static ListenerList LISTENER_LIST;

    public EntityItemPickupEvent(EntityPlayer entityPlayer, EntityItem entityItem) {
        super(entityPlayer);
        this.handled = false;
        this.item = entityItem;
    }

    public EntityItemPickupEvent() {
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

