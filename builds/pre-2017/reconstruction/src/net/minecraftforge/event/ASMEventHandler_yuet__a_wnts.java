/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_yuet__a_wnts
implements IEventListener {
    public Object instance;

    public ASMEventHandler_yuet__a_wnts(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((yuet)this.instance)._a((wnts)event);
    }
}

