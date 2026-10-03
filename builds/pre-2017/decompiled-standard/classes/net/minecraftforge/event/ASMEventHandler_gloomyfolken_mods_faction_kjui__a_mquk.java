/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.faction.kjui;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_faction_kjui__a_mquk
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_faction_kjui__a_mquk(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((kjui)this.instance)._a((mquk)event);
    }
}

