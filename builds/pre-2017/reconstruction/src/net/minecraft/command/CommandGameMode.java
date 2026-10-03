/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;

public class CommandGameMode
extends CommandBase {
    @Override
    public String getCommandName() {
        return "gamemode";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.gamemode.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0) {
            EnumGameType enumGameType = this._a(iCommandSender, stringArray[0]);
            EntityPlayerMP entityPlayerMP = stringArray.length >= 2 ? CommandGameMode.getPlayer(iCommandSender, stringArray[1]) : CommandGameMode.getCommandSenderAsPlayer(iCommandSender);
            ((EntityPlayer)entityPlayerMP).setGameType(enumGameType);
            entityPlayerMP.fallDistance = 0.0f;
            ChatMessageComponent chatMessageComponent = ChatMessageComponent._e("gameMode." + enumGameType._b());
            if (entityPlayerMP != iCommandSender) {
                CommandGameMode.notifyAdmins(iCommandSender, 1, "commands.gamemode.success.other", entityPlayerMP.getEntityName(), chatMessageComponent);
            } else {
                CommandGameMode.notifyAdmins(iCommandSender, 1, "commands.gamemode.success.self", chatMessageComponent);
            }
            return;
        }
        throw new pksd("commands.gamemode.usage", new Object[0]);
    }

    public EnumGameType _a(ICommandSender iCommandSender, String string) {
        if (string.equalsIgnoreCase(EnumGameType._b._b()) || string.equalsIgnoreCase("s")) {
            return EnumGameType._b;
        }
        if (string.equalsIgnoreCase(EnumGameType._c._b()) || string.equalsIgnoreCase("c")) {
            return EnumGameType._c;
        }
        if (string.equalsIgnoreCase(EnumGameType._d._b()) || string.equalsIgnoreCase("a")) {
            return EnumGameType._d;
        }
        return WorldSettings._a(CommandGameMode.parseIntBounded(iCommandSender, string, 0, EnumGameType.values().length - 2));
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandGameMode.getListOfStringsMatchingLastWord(stringArray, "survival", "creative", "adventure");
        }
        if (stringArray.length == 2) {
            return CommandGameMode.getListOfStringsMatchingLastWord(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return MinecraftServer._I()._i();
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 1;
    }
}

