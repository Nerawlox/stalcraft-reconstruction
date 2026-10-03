/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ItemTooltipEvent
extends PlayerEvent {
    public final boolean showAdvancedItemTooltips;
    public final cvzo itemStack;
    public final List<String> toolTip;
    private static ListenerList LISTENER_LIST;

    public ItemTooltipEvent(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list, boolean bl) {
        super(entityPlayer);
        this.itemStack = cvzo2;
        this.toolTip = list;
        this.showAdvancedItemTooltips = bl;
    }

    public ItemTooltipEvent() {
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

