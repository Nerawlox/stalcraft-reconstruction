/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandToggleDownfall
extends CommandBase {
    @Override
    public String getCommandName() {
        return "toggledownfall";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.downfall.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        this._a();
        CommandToggleDownfall.notifyAdmins(iCommandSender, "commands.downfall.success", new Object[0]);
    }

    public void _a() {
        MinecraftServer._I()._j[0].func_72913_w();
        MinecraftServer._I()._j[0].getWorldInfo()._a(true);
    }
}

