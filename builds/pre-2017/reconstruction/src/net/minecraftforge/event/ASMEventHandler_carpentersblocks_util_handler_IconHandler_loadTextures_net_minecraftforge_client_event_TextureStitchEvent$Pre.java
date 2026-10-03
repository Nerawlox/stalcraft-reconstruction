/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import carpentersblocks.util.handler.IconHandler;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_carpentersblocks_util_handler_IconHandler_loadTextures_net_minecraftforge_client_event_TextureStitchEvent$Pre
implements IEventListener {
    public Object instance;

    public ASMEventHandler_carpentersblocks_util_handler_IconHandler_loadTextures_net_minecraftforge_client_event_TextureStitchEvent$Pre(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((IconHandler)this.instance).loadTextures((TextureStitchEvent.Pre)event);
    }
}

