/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandServerSay
extends CommandBase {
    @Override
    public String getCommandName() {
        return "say";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.say.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0 && stringArray[0].length() > 0) {
            String string = CommandServerSay.func_82361_a(iCommandSender, stringArray, 0, true);
            MinecraftServer._I().__ag()._a(ChatMessageComponent._b("chat.type.announcement", iCommandSender.getCommandSenderName(), string));
            return;
        }
        throw new pksd("commands.say.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1) {
            return CommandServerSay.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }
}

