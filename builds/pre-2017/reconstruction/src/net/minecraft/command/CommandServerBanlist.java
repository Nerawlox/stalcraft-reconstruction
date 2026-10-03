/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandServerBanlist
extends CommandBase {
    @Override
    public String getCommandName() {
        return "banlist";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return (MinecraftServer._I().__ag()._m()._a() || MinecraftServer._I().__ag()._l()._a()) && super.canCommandSenderUseCommand(iCommandSender);
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.banlist.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].equalsIgnoreCase("ips")) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.banlist.ips", MinecraftServer._I().__ag()._m()._b().size()));
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(CommandServerBanlist.joinNiceString(MinecraftServer._I().__ag()._m()._b().keySet().toArray())));
        } else {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.banlist.players", MinecraftServer._I().__ag()._l()._b().size()));
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(CommandServerBanlist.joinNiceString(MinecraftServer._I().__ag()._l()._b().keySet().toArray())));
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerBanlist.getListOfStringsMatchingLastWord(stringArray, "players", "ips");
        }
        return null;
    }
}

