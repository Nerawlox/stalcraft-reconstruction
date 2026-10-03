/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_kkzb__a_qmds$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_kkzb__a_qmds$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((kkzb)this.instance)._a((qmds.kjui)event);
    }
}

