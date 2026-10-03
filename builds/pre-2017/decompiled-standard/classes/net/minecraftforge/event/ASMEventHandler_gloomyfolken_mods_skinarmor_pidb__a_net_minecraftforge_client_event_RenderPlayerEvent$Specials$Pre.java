/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.skinarmor.pidb;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_skinarmor_pidb__a_net_minecraftforge_client_event_RenderPlayerEvent$Specials$Pre
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_skinarmor_pidb__a_net_minecraftforge_client_event_RenderPlayerEvent$Specials$Pre(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((pidb)this.instance)._a((RenderPlayerEvent.Specials.Pre)event);
    }
}

