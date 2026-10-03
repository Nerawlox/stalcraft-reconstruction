/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;

public class ASMEventHandler_poersch_minecraft_bettergrassandleaves_BetterGrassAndLeavesMod_registerIcons_net_minecraftforge_client_event_TextureStitchEvent$Pre
implements IEventListener {
    public Object instance;

    public ASMEventHandler_poersch_minecraft_bettergrassandleaves_BetterGrassAndLeavesMod_registerIcons_net_minecraftforge_client_event_TextureStitchEvent$Pre(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((BetterGrassAndLeavesMod)this.instance).registerIcons((TextureStitchEvent.Pre)event);
    }
}

