/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FMLLoadCompleteEvent
extends FMLStateEvent {
    public FMLLoadCompleteEvent(Object ... objectArray) {
        super(objectArray);
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.AVAILABLE;
    }
}

