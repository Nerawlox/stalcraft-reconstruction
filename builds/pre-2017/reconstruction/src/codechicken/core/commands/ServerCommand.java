/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.commands.CoreCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public abstract class ServerCommand
extends CoreCommand {
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        this.handleCommand(stringArray, (MinecraftServer)iCommandSender);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        if (!super.canCommandSenderUseCommand(iCommandSender)) {
            return false;
        }
        return iCommandSender instanceof MinecraftServer;
    }

    public abstract void handleCommand(String[] var1, MinecraftServer var2);

    @Override
    public final boolean OPOnly() {
        return false;
    }
}

