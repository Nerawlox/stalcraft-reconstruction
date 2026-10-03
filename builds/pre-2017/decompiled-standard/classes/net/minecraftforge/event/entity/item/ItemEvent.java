/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class ItemEvent
extends EntityEvent {
    public final EntityItem entityItem;
    private static ListenerList LISTENER_LIST;

    public ItemEvent(EntityItem entityItem) {
        super(entityItem);
        this.entityItem = entityItem;
    }

    public ItemEvent() {
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

