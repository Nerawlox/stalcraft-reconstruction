/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandXP
extends CommandBase {
    @Override
    public String getCommandName() {
        return "xp";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.xp.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length > 0) {
            int n;
            boolean bl;
            boolean bl2;
            String string = stringArray[0];
            boolean bl3 = bl2 = string.endsWith("l") || string.endsWith("L");
            if (bl2 && string.length() > 1) {
                string = string.substring(0, string.length() - 1);
            }
            boolean bl4 = bl = (n = CommandXP.parseInt(iCommandSender, string)) < 0;
            if (bl) {
                n *= -1;
            }
            EntityPlayerMP entityPlayerMP = stringArray.length > 1 ? CommandXP.getPlayer(iCommandSender, stringArray[1]) : CommandXP.getCommandSenderAsPlayer(iCommandSender);
            if (bl2) {
                if (bl) {
                    ((EntityPlayer)entityPlayerMP).addExperienceLevel(-n);
                    CommandXP.notifyAdmins(iCommandSender, "commands.xp.success.negative.levels", n, entityPlayerMP.getEntityName());
                } else {
                    ((EntityPlayer)entityPlayerMP).addExperienceLevel(n);
                    CommandXP.notifyAdmins(iCommandSender, "commands.xp.success.levels", n, entityPlayerMP.getEntityName());
                }
            } else {
                if (bl) {
                    throw new pksd("commands.xp.failure.widthdrawXp", new Object[0]);
                }
                ((EntityPlayer)entityPlayerMP).addExperience(n);
                CommandXP.notifyAdmins(iCommandSender, "commands.xp.success", n, entityPlayerMP.getEntityName());
            }
            return;
        }
        throw new pksd("commands.xp.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 2) {
            return CommandXP.getListOfStringsMatchingLastWord(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return MinecraftServer._I()._i();
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 1;
    }
}

