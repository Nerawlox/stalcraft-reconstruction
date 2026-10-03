/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandServerSaveOn
extends CommandBase {
    @Override
    public String getCommandName() {
        return "save-on";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.save-on.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        MinecraftServer minecraftServer = MinecraftServer._I();
        boolean bl = false;
        for (int i = 0; i < minecraftServer._j.length; ++i) {
            if (minecraftServer._j[i] == null) continue;
            WorldServer worldServer = minecraftServer._j[i];
            if (!worldServer.field_73058_d) continue;
            worldServer.field_73058_d = false;
            bl = true;
        }
        if (!bl) {
            throw new cekk("commands.save-on.alreadyOn", new Object[0]);
        }
        CommandServerSaveOn.notifyAdmins(iCommandSender, "commands.save.enabled", new Object[0]);
    }
}

