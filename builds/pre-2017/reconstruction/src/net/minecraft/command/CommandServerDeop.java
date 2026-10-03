/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerDeop
extends CommandBase {
    @Override
    public String getCommandName() {
        return "deop";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.deop.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            MinecraftServer._I().__ag()._b(stringArray[0]);
            CommandServerDeop.notifyAdmins(iCommandSender, "commands.deop.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.deop.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerDeop.getListOfStringsFromIterableMatchingLastWord(stringArray, MinecraftServer._I().__ag()._p());
        }
        return null;
    }
}

