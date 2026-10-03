/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_piuf__a_net_minecraftforge_client_event_sound_SoundLoadEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_piuf__a_net_minecraftforge_client_event_sound_SoundLoadEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((piuf)this.instance)._a((SoundLoadEvent)event);
    }
}

