/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_onRenderPlayerPre_net_minecraftforge_client_event_RenderPlayerEvent$Pre
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_onRenderPlayerPre_net_minecraftforge_client_event_RenderPlayerEvent$Pre(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((RagdollsMod)this.instance).onRenderPlayerPre((RenderPlayerEvent.Pre)event);
    }
}

