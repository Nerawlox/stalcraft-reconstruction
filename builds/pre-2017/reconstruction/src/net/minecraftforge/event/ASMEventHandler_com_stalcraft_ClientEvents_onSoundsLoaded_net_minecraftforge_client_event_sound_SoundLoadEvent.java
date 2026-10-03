/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import com.stalcraft.ClientEvents;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_com_stalcraft_ClientEvents_onSoundsLoaded_net_minecraftforge_client_event_sound_SoundLoadEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_com_stalcraft_ClientEvents_onSoundsLoaded_net_minecraftforge_client_event_sound_SoundLoadEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ClientEvents)this.instance).onSoundsLoaded((SoundLoadEvent)event);
    }
}

