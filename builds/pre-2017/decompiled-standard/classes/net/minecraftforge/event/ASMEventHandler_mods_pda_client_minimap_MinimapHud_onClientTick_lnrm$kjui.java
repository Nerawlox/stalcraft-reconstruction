/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.pda.client.minimap.MinimapHud;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_pda_client_minimap_MinimapHud_onClientTick_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_pda_client_minimap_MinimapHud_onClientTick_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((MinimapHud)this.instance).onClientTick((lnrm.kjui)event);
    }
}

