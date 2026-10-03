/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.shop.pidb;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import znw.mods.stalkerguide.kjui;

public class ASMEventHandler_znw_mods_stalkerguide_kjui__a_gloomyfolken_mods_shop_pidb
implements IEventListener {
    public Object instance;

    public ASMEventHandler_znw_mods_stalkerguide_kjui__a_gloomyfolken_mods_shop_pidb(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((kjui)this.instance)._a((pidb)event);
    }
}

