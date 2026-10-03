/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.bundle.kjui;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_bundle_kjui__a_ycvh
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_bundle_kjui__a_ycvh(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((kjui)this.instance)._a((ycvh)event);
    }
}

