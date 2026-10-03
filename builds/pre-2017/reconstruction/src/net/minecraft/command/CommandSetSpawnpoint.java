/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetSpawnpoint
extends CommandBase {
    @Override
    public String getCommandName() {
        return "spawnpoint";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.spawnpoint.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        EntityPlayerMP entityPlayerMP;
        EntityPlayerMP entityPlayerMP2 = entityPlayerMP = stringArray.length == 0 ? CommandSetSpawnpoint.getCommandSenderAsPlayer(iCommandSender) : CommandSetSpawnpoint.getPlayer(iCommandSender, stringArray[0]);
        if (stringArray.length == 4) {
            if (entityPlayerMP.worldObj != null) {
                int n = 1;
                int n2 = 30000000;
                int n3 = CommandSetSpawnpoint.parseIntBounded(iCommandSender, stringArray[n++], -n2, n2);
                int n4 = CommandSetSpawnpoint.parseIntBounded(iCommandSender, stringArray[n++], 0, 256);
                int n5 = CommandSetSpawnpoint.parseIntBounded(iCommandSender, stringArray[n++], -n2, n2);
                entityPlayerMP.setSpawnChunk(new ChunkCoordinates(n3, n4, n5), true);
                CommandSetSpawnpoint.notifyAdmins(iCommandSender, "commands.spawnpoint.success", entityPlayerMP.getEntityName(), n3, n4, n5);
            }
        } else if (stringArray.length <= 1) {
            ChunkCoordinates chunkCoordinates = entityPlayerMP.func_82114_b();
            entityPlayerMP.setSpawnChunk(chunkCoordinates, true);
            CommandSetSpawnpoint.notifyAdmins(iCommandSender, "commands.spawnpoint.success", entityPlayerMP.getEntityName(), chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c);
        } else {
            throw new pksd("commands.spawnpoint.usage", new Object[0]);
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 || stringArray.length == 2) {
            return CommandSetSpawnpoint.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

