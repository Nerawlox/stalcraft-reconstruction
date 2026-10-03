/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import noppes.npcs.controllers.Faction;

public class FriendlyCheckEvent
extends Event {
    public final Faction faction;
    public final EntityPlayer player;
    public boolean isFriendly;
    private static ListenerList LISTENER_LIST;

    public FriendlyCheckEvent(Faction faction, EntityPlayer entityPlayer, boolean bl) {
        this.faction = faction;
        this.player = entityPlayer;
        this.isFriendly = bl;
    }

    public FriendlyCheckEvent() {
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

