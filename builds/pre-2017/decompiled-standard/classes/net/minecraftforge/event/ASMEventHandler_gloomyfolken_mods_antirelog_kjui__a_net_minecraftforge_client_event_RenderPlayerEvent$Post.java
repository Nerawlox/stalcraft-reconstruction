/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.antirelog.kjui;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_antirelog_kjui__a_net_minecraftforge_client_event_RenderPlayerEvent$Post
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_antirelog_kjui__a_net_minecraftforge_client_event_RenderPlayerEvent$Post(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((kjui)this.instance)._a((RenderPlayerEvent.Post)event);
    }
}

