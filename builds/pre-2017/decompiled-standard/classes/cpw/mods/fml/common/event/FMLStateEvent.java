/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.relauncher.Side;

public abstract class FMLStateEvent
extends FMLEvent {
    public FMLStateEvent(Object ... objectArray) {
    }

    public abstract LoaderState.ModState getModState();

    public Side getSide() {
        return FMLCommonHandler.instance().getSide();
    }
}

