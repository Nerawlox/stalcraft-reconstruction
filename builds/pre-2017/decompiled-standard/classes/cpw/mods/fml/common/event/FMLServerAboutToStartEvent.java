/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FMLServerAboutToStartEvent
extends FMLStateEvent {
    private dzfd server;

    public FMLServerAboutToStartEvent(Object ... objectArray) {
        super(objectArray);
        this.server = (dzfd)objectArray[0];
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.AVAILABLE;
    }

    public dzfd getServer() {
        return this.server;
    }
}

