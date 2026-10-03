/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.sound.client.ClientSoundController;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_sound_client_ClientSoundController_onRenderWorld_net_minecraftforge_client_event_RenderWorldLastEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_sound_client_ClientSoundController_onRenderWorld_net_minecraftforge_client_event_RenderWorldLastEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ClientSoundController)this.instance).onRenderWorld((RenderWorldLastEvent)event);
    }
}

