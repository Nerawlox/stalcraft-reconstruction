/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerStop
extends CommandBase {
    @Override
    public String getCommandName() {
        return "stop";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.stop.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        CommandServerStop.notifyAdmins(iCommandSender, "commands.stop.start", new Object[0]);
        MinecraftServer._I()._z();
    }
}

