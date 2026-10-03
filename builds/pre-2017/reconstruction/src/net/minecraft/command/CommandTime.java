/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandTime
extends CommandBase {
    @Override
    public String getCommandName() {
        return "time";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.time.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 1) {
            if (stringArray[0].equals("set")) {
                int n = stringArray[1].equals("day") ? 0 : (stringArray[1].equals("night") ? 12500 : CommandTime.parseIntWithMin(iCommandSender, stringArray[1], 0));
                this._a(iCommandSender, n);
                CommandTime.notifyAdmins(iCommandSender, "commands.time.set", n);
                return;
            }
            if (stringArray[0].equals("add")) {
                int n = CommandTime.parseIntWithMin(iCommandSender, stringArray[1], 0);
                this._b(iCommandSender, n);
                CommandTime.notifyAdmins(iCommandSender, "commands.time.added", n);
                return;
            }
        }
        throw new pksd("commands.time.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandTime.getListOfStringsMatchingLastWord(stringArray, "set", "add");
        }
        if (stringArray.length == 2 && stringArray[0].equals("set")) {
            return CommandTime.getListOfStringsMatchingLastWord(stringArray, "day", "night");
        }
        return null;
    }

    public void _a(ICommandSender iCommandSender, int n) {
        for (int i = 0; i < MinecraftServer._I()._j.length; ++i) {
            MinecraftServer._I()._j[i].setWorldTime(n);
        }
    }

    public void _b(ICommandSender iCommandSender, int n) {
        for (int i = 0; i < MinecraftServer._I()._j.length; ++i) {
            WorldServer worldServer = MinecraftServer._I()._j[i];
            worldServer.setWorldTime(worldServer.getWorldTime() + (long)n);
        }
    }
}

