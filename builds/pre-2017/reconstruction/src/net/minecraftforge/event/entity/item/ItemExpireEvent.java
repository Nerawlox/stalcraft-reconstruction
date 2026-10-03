/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.item.ItemEvent;

@Cancelable
public class ItemExpireEvent
extends ItemEvent {
    public int extraLife;
    private static ListenerList LISTENER_LIST;

    public ItemExpireEvent(EntityItem entityItem, int n) {
        super(entityItem);
        this.extraLife = n;
    }

    public ItemExpireEvent() {
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

