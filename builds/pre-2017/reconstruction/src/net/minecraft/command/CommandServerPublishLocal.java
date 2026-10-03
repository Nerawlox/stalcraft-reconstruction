/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;

public class CommandServerPublishLocal
extends CommandBase {
    @Override
    public String getCommandName() {
        return "publish";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.publish.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        String string = MinecraftServer._I()._a(EnumGameType._b, false);
        if (string != null) {
            CommandServerPublishLocal.notifyAdmins(iCommandSender, "commands.publish.started", string);
        } else {
            CommandServerPublishLocal.notifyAdmins(iCommandSender, "commands.publish.failed", new Object[0]);
        }
    }
}

