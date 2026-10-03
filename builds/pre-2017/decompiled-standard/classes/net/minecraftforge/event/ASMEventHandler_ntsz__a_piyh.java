/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_ntsz__a_piyh
implements IEventListener {
    public Object instance;

    public ASMEventHandler_ntsz__a_piyh(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ntsz)this.instance)._a((piyh)event);
    }
}

