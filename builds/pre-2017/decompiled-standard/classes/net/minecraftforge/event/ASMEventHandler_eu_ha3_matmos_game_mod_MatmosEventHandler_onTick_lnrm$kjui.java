/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import eu.ha3.matmos.game.mod.MatmosEventHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_eu_ha3_matmos_game_mod_MatmosEventHandler_onTick_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_eu_ha3_matmos_game_mod_MatmosEventHandler_onTick_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((MatmosEventHandler)this.instance).onTick((lnrm.kjui)event);
    }
}

