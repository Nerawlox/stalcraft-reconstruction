/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_sbzn__a_xqrl
implements IEventListener {
    public Object instance;

    public ASMEventHandler_sbzn__a_xqrl(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((sbzn)this.instance)._a((xqrl)event);
    }
}

