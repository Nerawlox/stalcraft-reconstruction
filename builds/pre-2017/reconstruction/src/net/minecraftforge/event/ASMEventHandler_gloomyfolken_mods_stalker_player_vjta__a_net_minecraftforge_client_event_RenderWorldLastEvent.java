/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.player.vjta;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_player_vjta__a_net_minecraftforge_client_event_RenderWorldLastEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_player_vjta__a_net_minecraftforge_client_event_RenderWorldLastEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((vjta)this.instance)._a((RenderWorldLastEvent)event);
    }
}

