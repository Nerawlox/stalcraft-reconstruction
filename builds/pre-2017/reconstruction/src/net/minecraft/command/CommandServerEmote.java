/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandServerEmote
extends CommandBase {
    @Override
    public String getCommandName() {
        return "me";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.me.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0) {
            String string = CommandServerEmote.func_82361_a(iCommandSender, stringArray, 0, iCommandSender.canCommandSenderUseCommand(1, "me"));
            MinecraftServer._I().__ag()._a(ChatMessageComponent._b("chat.type.emote", iCommandSender.getCommandSenderName(), string));
            return;
        }
        throw new pksd("commands.me.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        return CommandServerEmote.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
    }
}

