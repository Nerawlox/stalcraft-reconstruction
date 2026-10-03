/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FMLServerStartingEvent
extends FMLStateEvent {
    private dzfd server;

    public FMLServerStartingEvent(Object ... objectArray) {
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

    public void registerServerCommand(kmew kmew2) {
        ohmz ohmz2 = (ohmz)this.getServer()._J();
        ohmz2.func_71560_a(kmew2);
    }
}

