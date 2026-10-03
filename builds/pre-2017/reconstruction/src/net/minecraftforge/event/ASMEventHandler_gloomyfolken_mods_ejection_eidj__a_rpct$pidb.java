/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.ejection.eidj;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_ejection_eidj__a_rpct$pidb
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_ejection_eidj__a_rpct$pidb(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((eidj)this.instance)._a((rpct.pidb)event);
    }
}

