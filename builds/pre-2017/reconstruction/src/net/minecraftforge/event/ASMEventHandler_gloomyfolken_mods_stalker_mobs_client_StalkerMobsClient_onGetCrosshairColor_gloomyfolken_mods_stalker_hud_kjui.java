/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.hud.kjui;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_mobs_client_StalkerMobsClient_onGetCrosshairColor_gloomyfolken_mods_stalker_hud_kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_mobs_client_StalkerMobsClient_onGetCrosshairColor_gloomyfolken_mods_stalker_hud_kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((StalkerMobsClient)this.instance).onGetCrosshairColor((kjui)event);
    }
}

