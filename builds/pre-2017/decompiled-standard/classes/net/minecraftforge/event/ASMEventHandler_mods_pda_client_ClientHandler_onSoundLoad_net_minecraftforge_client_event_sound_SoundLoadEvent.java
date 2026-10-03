/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.pda.client.ClientHandler;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_pda_client_ClientHandler_onSoundLoad_net_minecraftforge_client_event_sound_SoundLoadEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_pda_client_ClientHandler_onSoundLoad_net_minecraftforge_client_event_sound_SoundLoadEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ClientHandler)this.instance).onSoundLoad((SoundLoadEvent)event);
    }
}

