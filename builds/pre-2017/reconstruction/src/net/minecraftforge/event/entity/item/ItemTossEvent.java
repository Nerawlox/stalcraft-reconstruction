/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.item.ItemEvent;

@Cancelable
public class ItemTossEvent
extends ItemEvent {
    public final EntityPlayer player;
    private static ListenerList LISTENER_LIST;

    public ItemTossEvent(EntityItem entityItem, EntityPlayer entityPlayer) {
        super(entityItem);
        this.player = entityPlayer;
    }

    public ItemTossEvent() {
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

