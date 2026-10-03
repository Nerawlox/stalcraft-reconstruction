/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_piuf__a_lnrm$ezey
implements IEventListener {
    public Object instance;

    public ASMEventHandler_piuf__a_lnrm$ezey(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((piuf)this.instance)._a((lnrm.ezey)event);
    }
}

