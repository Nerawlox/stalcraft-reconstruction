/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandServerTp
extends CommandBase {
    @Override
    public String getCommandName() {
        return "tp";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.tp.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1) {
            EntityPlayerMP entityPlayerMP;
            if (stringArray.length == 2 || stringArray.length == 4) {
                entityPlayerMP = CommandServerTp.getPlayer(iCommandSender, stringArray[0]);
                if (entityPlayerMP == null) {
                    throw new mskk();
                }
            } else {
                entityPlayerMP = CommandServerTp.getCommandSenderAsPlayer(iCommandSender);
            }
            if (stringArray.length == 3 || stringArray.length == 4) {
                if (entityPlayerMP.worldObj != null) {
                    int n = stringArray.length - 3;
                    double d = CommandServerTp.func_110666_a(iCommandSender, entityPlayerMP.posX, stringArray[n++]);
                    double d2 = CommandServerTp.func_110665_a(iCommandSender, entityPlayerMP.posY, stringArray[n++], 0, 0);
                    double d3 = CommandServerTp.func_110666_a(iCommandSender, entityPlayerMP.posZ, stringArray[n++]);
                    entityPlayerMP.mountEntity(null);
                    entityPlayerMP.setPositionAndUpdate(d, d2, d3);
                    CommandServerTp.notifyAdmins(iCommandSender, "commands.tp.success.coordinates", entityPlayerMP.getEntityName(), d, d2, d3);
                }
            } else if (stringArray.length == 1 || stringArray.length == 2) {
                EntityPlayerMP entityPlayerMP2 = CommandServerTp.getPlayer(iCommandSender, stringArray[stringArray.length - 1]);
                if (entityPlayerMP2 == null) {
                    throw new mskk();
                }
                if (entityPlayerMP2.worldObj != entityPlayerMP.worldObj) {
                    CommandServerTp.notifyAdmins(iCommandSender, "commands.tp.notSameDimension", new Object[0]);
                    return;
                }
                entityPlayerMP.mountEntity(null);
                entityPlayerMP.playerNetServerHandler.setPlayerLocation(entityPlayerMP2.posX, entityPlayerMP2.posY, entityPlayerMP2.posZ, entityPlayerMP2.rotationYaw, entityPlayerMP2.rotationPitch);
                CommandServerTp.notifyAdmins(iCommandSender, "commands.tp.success", entityPlayerMP.getEntityName(), entityPlayerMP2.getEntityName());
            }
            return;
        }
        throw new pksd("commands.tp.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 || stringArray.length == 2) {
            return CommandServerTp.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

