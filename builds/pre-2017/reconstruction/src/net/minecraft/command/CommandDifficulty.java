/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandDifficulty
extends CommandBase {
    public static final String[] _a = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};

    @Override
    public String getCommandName() {
        return "difficulty";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.difficulty.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0) {
            int n = this._a(iCommandSender, stringArray[0]);
            MinecraftServer._I()._c(n);
            CommandDifficulty.notifyAdmins(iCommandSender, "commands.difficulty.success", ChatMessageComponent._e(_a[n]));
            return;
        }
        throw new pksd("commands.difficulty.usage", new Object[0]);
    }

    public int _a(ICommandSender iCommandSender, String string) {
        if (string.equalsIgnoreCase("peaceful") || string.equalsIgnoreCase("p")) {
            return 0;
        }
        if (string.equalsIgnoreCase("easy") || string.equalsIgnoreCase("e")) {
            return 1;
        }
        if (string.equalsIgnoreCase("normal") || string.equalsIgnoreCase("n")) {
            return 2;
        }
        if (string.equalsIgnoreCase("hard") || string.equalsIgnoreCase("h")) {
            return 3;
        }
        return CommandDifficulty.parseIntBounded(iCommandSender, string, 0, 3);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandDifficulty.getListOfStringsMatchingLastWord(stringArray, "peaceful", "easy", "normal", "hard");
        }
        return null;
    }
}

