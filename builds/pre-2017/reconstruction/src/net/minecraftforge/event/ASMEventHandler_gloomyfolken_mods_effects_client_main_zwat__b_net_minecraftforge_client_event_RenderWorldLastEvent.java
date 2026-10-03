/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.effects.client.main.zwat;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_effects_client_main_zwat__b_net_minecraftforge_client_event_RenderWorldLastEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_effects_client_main_zwat__b_net_minecraftforge_client_event_RenderWorldLastEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((zwat)this.instance)._b((RenderWorldLastEvent)event);
    }
}

