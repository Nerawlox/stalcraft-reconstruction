/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandSetPlayerTimeout
extends CommandBase {
    @Override
    public String getCommandName() {
        return "setidletimeout";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.setidletimeout.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            int n = CommandSetPlayerTimeout.parseIntWithMin(iCommandSender, stringArray[0], 0);
            MinecraftServer._I()._e(n);
            CommandSetPlayerTimeout.notifyAdmins(iCommandSender, "commands.setidletimeout.success", n);
            return;
        }
        throw new pksd("commands.setidletimeout.usage", new Object[0]);
    }
}

