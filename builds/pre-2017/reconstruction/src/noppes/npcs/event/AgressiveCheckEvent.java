/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import noppes.npcs.controllers.Faction;

public class AgressiveCheckEvent
extends Event {
    public final Faction faction;
    public final EntityPlayer player;
    public boolean isAgressive;
    private static ListenerList LISTENER_LIST;

    public AgressiveCheckEvent(Faction faction, EntityPlayer entityPlayer, boolean bl) {
        this.faction = faction;
        this.player = entityPlayer;
        this.isAgressive = bl;
    }

    public AgressiveCheckEvent() {
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

