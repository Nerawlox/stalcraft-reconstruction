/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.server.MinecraftServer;

public class FMLServerStartingEvent
extends FMLStateEvent {
    private MinecraftServer server;

    public FMLServerStartingEvent(Object ... objectArray) {
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

    public void registerServerCommand(ICommand iCommand) {
        CommandHandler commandHandler = (CommandHandler)this.getServer()._J();
        commandHandler.registerCommand(iCommand);
    }
}

