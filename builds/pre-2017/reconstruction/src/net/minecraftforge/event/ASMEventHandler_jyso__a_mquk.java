/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_jyso__a_mquk
implements IEventListener {
    public Object instance;

    public ASMEventHandler_jyso__a_mquk(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jyso)this.instance)._a((mquk)event);
    }
}

