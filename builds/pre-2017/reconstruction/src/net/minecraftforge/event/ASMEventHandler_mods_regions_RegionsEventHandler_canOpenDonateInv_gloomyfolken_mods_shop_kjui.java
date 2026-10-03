/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.shop.kjui;
import mods.regions.RegionsEventHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_regions_RegionsEventHandler_canOpenDonateInv_gloomyfolken_mods_shop_kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_regions_RegionsEventHandler_canOpenDonateInv_gloomyfolken_mods_shop_kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((RegionsEventHandler)this.instance).canOpenDonateInv((kjui)event);
    }
}

