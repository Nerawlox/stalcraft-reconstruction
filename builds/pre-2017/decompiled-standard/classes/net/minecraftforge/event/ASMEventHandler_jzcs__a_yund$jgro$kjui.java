/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_jzcs__a_yund$jgro$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_jzcs__a_yund$jgro$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jzcs)this.instance)._a((yund.jgro.kjui)event);
    }
}

