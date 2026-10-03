/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandGameMode;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;

public class CommandDefaultGameMode
extends CommandGameMode {
    @Override
    public String getCommandName() {
        return "defaultgamemode";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.defaultgamemode.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0) {
            EnumGameType enumGameType = this._a(iCommandSender, stringArray[0]);
            this._a(enumGameType);
            CommandDefaultGameMode.notifyAdmins(iCommandSender, "commands.defaultgamemode.success", ChatMessageComponent._e("gameMode." + enumGameType._b()));
            return;
        }
        throw new pksd("commands.defaultgamemode.usage", new Object[0]);
    }

    public void _a(EnumGameType enumGameType) {
        MinecraftServer minecraftServer = MinecraftServer._I();
        minecraftServer._a(enumGameType);
        if (minecraftServer.__ao()) {
            for (EntityPlayerMP entityPlayerMP : MinecraftServer._I().__ag()._e) {
                entityPlayerMP.setGameType(enumGameType);
                entityPlayerMP.fallDistance = 0.0f;
            }
        }
    }
}

