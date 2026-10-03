/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import java.util.regex.Matcher;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandServerBanIp;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerPardonIp
extends CommandBase {
    @Override
    public String getCommandName() {
        return "pardon-ip";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return MinecraftServer._I().__ag()._m()._a() && super.canCommandSenderUseCommand(iCommandSender);
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.unbanip.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 1) {
            Matcher matcher = CommandServerBanIp._a.matcher(stringArray[0]);
            if (matcher.matches()) {
                MinecraftServer._I().__ag()._m()._b(stringArray[0]);
                CommandServerPardonIp.notifyAdmins(iCommandSender, "commands.unbanip.success", stringArray[0]);
                return;
            }
            throw new cene("commands.unbanip.invalid", new Object[0]);
        }
        throw new pksd("commands.unbanip.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerPardonIp.getListOfStringsFromIterableMatchingLastWord(stringArray, MinecraftServer._I().__ag()._m()._b().keySet());
        }
        return null;
    }
}

