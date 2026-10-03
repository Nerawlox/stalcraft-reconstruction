/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.ejection.eidj;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_ejection_eidj__a_fmab
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_ejection_eidj__a_fmab(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((eidj)this.instance)._a((fmab)event);
    }
}

