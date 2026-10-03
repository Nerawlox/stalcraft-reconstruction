/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerPardon
extends CommandBase {
    @Override
    public String getCommandName() {
        return "pardon";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.unban.usage";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return MinecraftServer._I().__ag()._l()._a() && super.canCommandSenderUseCommand(iCommandSender);
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            MinecraftServer._I().__ag()._l()._b(stringArray[0]);
            CommandServerPardon.notifyAdmins(iCommandSender, "commands.unban.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.unban.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerPardon.getListOfStringsFromIterableMatchingLastWord(stringArray, MinecraftServer._I().__ag()._l()._b().keySet());
        }
        return null;
    }
}

