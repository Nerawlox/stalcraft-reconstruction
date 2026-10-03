/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;

public class CommandServerBan
extends CommandBase {
    @Override
    public String getCommandName() {
        return "ban";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.ban.usage";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return MinecraftServer._I().__ag()._l()._a() && super.canCommandSenderUseCommand(iCommandSender);
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].length() > 0) {
            EntityPlayerMP entityPlayerMP = MinecraftServer._I().__ag()._h(stringArray[0]);
            BanEntry banEntry = new BanEntry(stringArray[0]);
            banEntry._a(iCommandSender.getCommandSenderName());
            if (stringArray.length >= 2) {
                banEntry._b(CommandServerBan.func_82360_a(iCommandSender, stringArray, 1));
            }
            MinecraftServer._I().__ag()._l()._a(banEntry);
            if (entityPlayerMP != null) {
                entityPlayerMP.playerNetServerHandler.func_72565_c("You are banned from this server.");
            }
            CommandServerBan.notifyAdmins(iCommandSender, "commands.ban.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.ban.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1) {
            return CommandServerBan.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }
}

