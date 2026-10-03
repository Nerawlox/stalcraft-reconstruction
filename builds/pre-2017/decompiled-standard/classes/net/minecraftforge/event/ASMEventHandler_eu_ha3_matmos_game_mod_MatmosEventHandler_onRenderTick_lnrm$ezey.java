/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import eu.ha3.matmos.game.mod.MatmosEventHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_eu_ha3_matmos_game_mod_MatmosEventHandler_onRenderTick_lnrm$ezey
implements IEventListener {
    public Object instance;

    public ASMEventHandler_eu_ha3_matmos_game_mod_MatmosEventHandler_onRenderTick_lnrm$ezey(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((MatmosEventHandler)this.instance).onRenderTick((lnrm.ezey)event);
    }
}

