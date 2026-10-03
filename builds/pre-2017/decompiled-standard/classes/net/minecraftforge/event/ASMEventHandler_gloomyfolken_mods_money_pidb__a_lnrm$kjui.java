/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.money.pidb;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_money_pidb__a_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_money_pidb__a_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((pidb)this.instance)._a((lnrm.kjui)event);
    }
}

