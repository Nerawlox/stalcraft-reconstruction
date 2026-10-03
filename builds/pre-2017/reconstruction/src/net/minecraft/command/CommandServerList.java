/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandServerList
extends CommandBase {
    @Override
    public String getCommandName() {
        return "list";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.players.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.players.list", MinecraftServer._I()._g(), MinecraftServer._I()._h()));
        iCommandSender.sendChatToPlayer(ChatMessageComponent._d(MinecraftServer._I().__ag()._j()));
    }
}

