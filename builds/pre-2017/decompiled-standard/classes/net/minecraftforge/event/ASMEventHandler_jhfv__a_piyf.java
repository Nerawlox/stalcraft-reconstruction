/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_jhfv__a_piyf
implements IEventListener {
    public Object instance;

    public ASMEventHandler_jhfv__a_piyf(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jhfv)this.instance)._a((piyf)event);
    }
}

