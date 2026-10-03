/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.misc.jgro;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_misc_jgro__a_ccvb
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_misc_jgro__a_ccvb(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jgro)this.instance)._a((ccvb)event);
    }
}

