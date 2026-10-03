/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandServerKick
extends CommandBase {
    @Override
    public String getCommandName() {
        return "kick";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.kick.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0 && stringArray[0].length() > 1) {
            EntityPlayerMP entityPlayerMP = MinecraftServer._I().__ag()._h(stringArray[0]);
            String string = "Kicked by an operator.";
            boolean bl = false;
            if (entityPlayerMP == null) {
                throw new mskk();
            }
            if (stringArray.length >= 2) {
                string = CommandServerKick.func_82360_a(iCommandSender, stringArray, 1);
                bl = true;
            }
            entityPlayerMP.playerNetServerHandler.func_72565_c(string);
            if (bl) {
                CommandServerKick.notifyAdmins(iCommandSender, "commands.kick.success.reason", entityPlayerMP.getEntityName(), string);
            } else {
                CommandServerKick.notifyAdmins(iCommandSender, "commands.kick.success", entityPlayerMP.getEntityName());
            }
            return;
        }
        throw new pksd("commands.kick.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1) {
            return CommandServerKick.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }
}

