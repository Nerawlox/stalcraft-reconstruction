/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class PlayerInteractEvent
extends PlayerEvent {
    public final Action action;
    public final int x;
    public final int y;
    public final int z;
    public final int face;
    public Event.Result useBlock;
    public Event.Result useItem;
    private static ListenerList LISTENER_LIST;

    public PlayerInteractEvent(EntityPlayer entityPlayer, Action action, int n, int n2, int n3, int n4) {
        super(entityPlayer);
        this.useBlock = Event.Result.DEFAULT;
        this.useItem = Event.Result.DEFAULT;
        this.action = action;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.face = n4;
        if (n4 == -1) {
            this.useBlock = Event.Result.DENY;
        }
    }

    @Override
    public void setCanceled(boolean bl) {
        super.setCanceled(bl);
        Event.Result result = bl ? Event.Result.DENY : (this.useBlock = this.useBlock == Event.Result.DENY ? Event.Result.DEFAULT : this.useBlock);
        this.useItem = bl ? Event.Result.DENY : (this.useItem == Event.Result.DENY ? Event.Result.DEFAULT : this.useItem);
    }

    public PlayerInteractEvent() {
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

    public static enum Action {
        RIGHT_CLICK_AIR,
        RIGHT_CLICK_BLOCK,
        LEFT_CLICK_BLOCK;

    }
}

