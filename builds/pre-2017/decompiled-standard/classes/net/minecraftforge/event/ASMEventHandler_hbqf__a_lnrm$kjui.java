/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_hbqf__a_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_hbqf__a_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((hbqf)this.instance)._a((lnrm.kjui)event);
    }
}

