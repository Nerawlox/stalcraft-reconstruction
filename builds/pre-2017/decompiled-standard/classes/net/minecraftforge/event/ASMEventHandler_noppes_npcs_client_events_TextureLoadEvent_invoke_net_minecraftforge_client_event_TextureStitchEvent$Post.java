/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import noppes.npcs.client.events.TextureLoadEvent;

public class ASMEventHandler_noppes_npcs_client_events_TextureLoadEvent_invoke_net_minecraftforge_client_event_TextureStitchEvent$Post
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_client_events_TextureLoadEvent_invoke_net_minecraftforge_client_event_TextureStitchEvent$Post(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((TextureLoadEvent)this.instance).invoke((TextureStitchEvent.Post)event);
    }
}

