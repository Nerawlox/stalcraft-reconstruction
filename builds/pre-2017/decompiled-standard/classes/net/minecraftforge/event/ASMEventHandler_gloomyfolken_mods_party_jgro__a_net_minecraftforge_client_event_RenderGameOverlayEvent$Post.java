/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.party.jgro;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_party_jgro__a_net_minecraftforge_client_event_RenderGameOverlayEvent$Post
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_party_jgro__a_net_minecraftforge_client_event_RenderGameOverlayEvent$Post(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jgro)this.instance)._a((RenderGameOverlayEvent.Post)event);
    }
}

