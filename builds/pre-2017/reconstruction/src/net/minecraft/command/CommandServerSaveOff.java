/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandServerSaveOff
extends CommandBase {
    @Override
    public String getCommandName() {
        return "save-off";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.save-off.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        MinecraftServer minecraftServer = MinecraftServer._I();
        boolean bl = false;
        for (int i = 0; i < minecraftServer._j.length; ++i) {
            if (minecraftServer._j[i] == null) continue;
            WorldServer worldServer = minecraftServer._j[i];
            if (worldServer.field_73058_d) continue;
            worldServer.field_73058_d = true;
            bl = true;
        }
        if (!bl) {
            throw new cekk("commands.save-off.alreadyOff", new Object[0]);
        }
        CommandServerSaveOff.notifyAdmins(iCommandSender, "commands.save.disabled", new Object[0]);
    }
}

