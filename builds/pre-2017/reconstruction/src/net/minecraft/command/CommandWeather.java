/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import java.util.Random;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandWeather
extends CommandBase {
    @Override
    public String getCommandName() {
        return "weather";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.weather.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 1 || stringArray.length > 2) {
            throw new pksd("commands.weather.usage", new Object[0]);
        }
        int n = (300 + new Random().nextInt(600)) * 20;
        if (stringArray.length >= 2) {
            n = CommandWeather.parseIntBounded(iCommandSender, stringArray[1], 1, 1000000) * 20;
        }
        WorldServer worldServer = MinecraftServer._I()._j[0];
        WorldInfo worldInfo = worldServer.getWorldInfo();
        worldInfo._f(n);
        worldInfo._e(n);
        if ("clear".equalsIgnoreCase(stringArray[0])) {
            worldInfo._b(false);
            worldInfo._a(false);
            CommandWeather.notifyAdmins(iCommandSender, "commands.weather.clear", new Object[0]);
        } else if ("rain".equalsIgnoreCase(stringArray[0])) {
            worldInfo._b(true);
            worldInfo._a(false);
            CommandWeather.notifyAdmins(iCommandSender, "commands.weather.rain", new Object[0]);
        } else if ("thunder".equalsIgnoreCase(stringArray[0])) {
            worldInfo._b(true);
            worldInfo._a(true);
            CommandWeather.notifyAdmins(iCommandSender, "commands.weather.thunder", new Object[0]);
        } else {
            throw new pksd("commands.weather.usage", new Object[0]);
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandWeather.getListOfStringsMatchingLastWord(stringArray, "clear", "rain", "thunder");
        }
        return null;
    }
}

