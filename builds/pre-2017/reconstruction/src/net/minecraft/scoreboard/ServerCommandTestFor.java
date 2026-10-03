/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class ServerCommandTestFor
extends CommandBase {
    @Override
    public String getCommandName() {
        return "testfor";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.testfor.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length != 1) {
            throw new pksd("commands.testfor.usage", new Object[0]);
        }
        if (!(iCommandSender instanceof TileEntityCommandBlock)) {
            throw new cekk("commands.testfor.failed", new Object[0]);
        }
        ServerCommandTestFor.getPlayer(iCommandSender, stringArray[0]);
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

