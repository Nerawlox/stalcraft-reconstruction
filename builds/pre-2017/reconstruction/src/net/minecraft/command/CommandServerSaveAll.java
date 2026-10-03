/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.WorldServer;

public class CommandServerSaveAll
extends CommandBase {
    @Override
    public String getCommandName() {
        return "save-all";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.save.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        MinecraftServer minecraftServer = MinecraftServer._I();
        iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.save.start"));
        if (minecraftServer.__ag() != null) {
            minecraftServer.__ag()._n();
        }
        try {
            boolean bl;
            WorldServer worldServer;
            int n;
            for (n = 0; n < minecraftServer._j.length; ++n) {
                if (minecraftServer._j[n] == null) continue;
                worldServer = minecraftServer._j[n];
                bl = worldServer.field_73058_d;
                worldServer.field_73058_d = false;
                worldServer.saveAllChunks(true, null);
                worldServer.field_73058_d = bl;
            }
            if (stringArray.length > 0 && "flush".equals(stringArray[0])) {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.save.flushStart"));
                for (n = 0; n < minecraftServer._j.length; ++n) {
                    if (minecraftServer._j[n] == null) continue;
                    worldServer = minecraftServer._j[n];
                    bl = worldServer.field_73058_d;
                    worldServer.field_73058_d = false;
                    worldServer.saveChunkData();
                    worldServer.field_73058_d = bl;
                }
                iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.save.flushEnd"));
            }
        }
        catch (xcad xcad2) {
            CommandServerSaveAll.notifyAdmins(iCommandSender, "commands.save.failed", xcad2.getMessage());
            return;
        }
        CommandServerSaveAll.notifyAdmins(iCommandSender, "commands.save.success", new Object[0]);
    }
}

