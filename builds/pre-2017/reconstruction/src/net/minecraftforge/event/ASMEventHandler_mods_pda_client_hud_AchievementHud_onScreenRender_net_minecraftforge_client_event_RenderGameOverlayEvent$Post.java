/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.pda.client.hud.AchievementHud;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_pda_client_hud_AchievementHud_onScreenRender_net_minecraftforge_client_event_RenderGameOverlayEvent$Post
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_pda_client_hud_AchievementHud_onScreenRender_net_minecraftforge_client_event_RenderGameOverlayEvent$Post(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((AchievementHud)this.instance).onScreenRender((RenderGameOverlayEvent.Post)event);
    }
}

