/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;
import net.minecraft.server.MinecraftServer;

public class FMLServerAboutToStartEvent
extends FMLStateEvent {
    private MinecraftServer server;

    public FMLServerAboutToStartEvent(Object ... objectArray) {
        super(objectArray);
        this.server = (MinecraftServer)objectArray[0];
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.AVAILABLE;
    }

    public MinecraftServer getServer() {
        return this.server;
    }
}

