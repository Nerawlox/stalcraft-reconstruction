/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.stalker.player.qlgf;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_onRenderPlayerPre1_gloomyfolken_mods_stalker_player_qlgf$pidb
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_onRenderPlayerPre1_gloomyfolken_mods_stalker_player_qlgf$pidb(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((RagdollsMod)this.instance).onRenderPlayerPre1((qlgf.pidb)event);
    }
}

