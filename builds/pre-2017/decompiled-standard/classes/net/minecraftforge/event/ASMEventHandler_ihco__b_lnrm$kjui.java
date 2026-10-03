/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_ihco__b_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_ihco__b_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ihco)this.instance)._b((lnrm.kjui)event);
    }
}

