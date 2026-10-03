/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class AddReputationEvent
extends PlayerEvent {
    public final int reputation;
    private static ListenerList LISTENER_LIST;

    public AddReputationEvent(EntityPlayer entityPlayer, int n) {
        super(entityPlayer);
        this.reputation = n;
    }

    public AddReputationEvent() {
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

