/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import noppes.npcs.events.PlayerEvent;

public class ASMEventHandler_noppes_npcs_events_PlayerEvent_onPlayerTick_lnrm$eidj
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_PlayerEvent_onPlayerTick_lnrm$eidj(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PlayerEvent)this.instance).onPlayerTick((lnrm.eidj)event);
    }
}

