/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_zgpv__a_zxrk
implements IEventListener {
    public Object instance;

    public ASMEventHandler_zgpv__a_zxrk(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((zgpv)this.instance)._a((zxrk)event);
    }
}

