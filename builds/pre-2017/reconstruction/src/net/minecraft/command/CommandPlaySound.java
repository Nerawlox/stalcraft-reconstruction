/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandPlaySound
extends CommandBase {
    @Override
    public String getCommandName() {
        return "playsound";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.playsound.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 2) {
            throw new pksd(this.getCommandUsage(iCommandSender), new Object[0]);
        }
        int n = 0;
        String string = stringArray[n++];
        EntityPlayerMP entityPlayerMP = CommandPlaySound.getPlayer(iCommandSender, stringArray[n++]);
        double d = entityPlayerMP.func_82114_b()._a;
        double d2 = entityPlayerMP.func_82114_b()._b;
        double d3 = entityPlayerMP.func_82114_b()._c;
        double d4 = 1.0;
        double d5 = 1.0;
        double d6 = 0.0;
        if (stringArray.length > n) {
            d = CommandPlaySound.func_110666_a(iCommandSender, d, stringArray[n++]);
        }
        if (stringArray.length > n) {
            d2 = CommandPlaySound.func_110665_a(iCommandSender, d2, stringArray[n++], 0, 0);
        }
        if (stringArray.length > n) {
            d3 = CommandPlaySound.func_110666_a(iCommandSender, d3, stringArray[n++]);
        }
        if (stringArray.length > n) {
            d4 = CommandPlaySound.func_110661_a(iCommandSender, stringArray[n++], 0.0, 3.4028234663852886E38);
        }
        if (stringArray.length > n) {
            d5 = CommandPlaySound.func_110661_a(iCommandSender, stringArray[n++], 0.0, 2.0);
        }
        if (stringArray.length > n) {
            d6 = CommandPlaySound.func_110661_a(iCommandSender, stringArray[n++], 0.0, 1.0);
        }
        double d7 = d4 > 1.0 ? d4 * 16.0 : 16.0;
        double d8 = entityPlayerMP.getDistance(d, d2, d3);
        if (d8 > d7) {
            if (!(d6 > 0.0)) throw new cekk("commands.playsound.playerTooFar", entityPlayerMP.getEntityName());
            double d9 = d - entityPlayerMP.posX;
            double d10 = d2 - entityPlayerMP.posY;
            double d11 = d3 - entityPlayerMP.posZ;
            double d12 = Math.sqrt(d9 * d9 + d10 * d10 + d11 * d11);
            double d13 = entityPlayerMP.posX;
            double d14 = entityPlayerMP.posY;
            double d15 = entityPlayerMP.posZ;
            if (d12 > 0.0) {
                d13 += d9 / d12 * 2.0;
                d14 += d10 / d12 * 2.0;
                d15 += d11 / d12 * 2.0;
            }
            entityPlayerMP.playerNetServerHandler.func_72567_b(new lpza(string, d13, d14, d15, (float)d6, (float)d5));
        } else {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new lpza(string, d, d2, d3, (float)d4, (float)d5));
        }
        CommandPlaySound.notifyAdmins(iCommandSender, "commands.playsound.success", string, entityPlayerMP.getEntityName());
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 1;
    }
}

