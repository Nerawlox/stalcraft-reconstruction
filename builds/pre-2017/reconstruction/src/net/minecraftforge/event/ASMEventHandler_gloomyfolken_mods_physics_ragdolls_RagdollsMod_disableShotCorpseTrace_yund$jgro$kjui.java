/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_disableShotCorpseTrace_yund$jgro$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_disableShotCorpseTrace_yund$jgro$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((RagdollsMod)this.instance).disableShotCorpseTrace((yund.jgro.kjui)event);
    }
}

