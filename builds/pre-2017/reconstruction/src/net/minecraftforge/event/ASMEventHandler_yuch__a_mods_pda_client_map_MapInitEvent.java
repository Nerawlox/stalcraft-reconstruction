/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.pda.client.map.MapInitEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_yuch__a_mods_pda_client_map_MapInitEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_yuch__a_mods_pda_client_map_MapInitEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((yuch)this.instance)._a((MapInitEvent)event);
    }
}

