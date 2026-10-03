/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;

public class CommandServerBanIp
extends CommandBase {
    public static final Pattern _a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public String getCommandName() {
        return "ban-ip";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return MinecraftServer._I().__ag()._m()._a() && super.canCommandSenderUseCommand(iCommandSender);
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.banip.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].length() > 1) {
            Matcher matcher = _a.matcher(stringArray[0]);
            String string = null;
            if (stringArray.length >= 2) {
                string = CommandServerBanIp.func_82360_a(iCommandSender, stringArray, 1);
            }
            if (matcher.matches()) {
                this._a(iCommandSender, stringArray[0], string);
            } else {
                EntityPlayerMP entityPlayerMP = MinecraftServer._I().__ag()._h(stringArray[0]);
                if (entityPlayerMP == null) {
                    throw new mskk("commands.banip.invalid", new Object[0]);
                }
                this._a(iCommandSender, entityPlayerMP.getPlayerIP(), string);
            }
            return;
        }
        throw new pksd("commands.banip.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerBanIp.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
        }
        return null;
    }

    public void _a(ICommandSender iCommandSender, String string, String string2) {
        BanEntry banEntry = new BanEntry(string);
        banEntry._a(iCommandSender.getCommandSenderName());
        if (string2 != null) {
            banEntry._b(string2);
        }
        MinecraftServer._I().__ag()._m()._a(banEntry);
        List list = MinecraftServer._I().__ag()._i(string);
        Object[] objectArray = new String[list.size()];
        int n = 0;
        for (EntityPlayerMP entityPlayerMP : list) {
            entityPlayerMP.playerNetServerHandler.func_72565_c("You have been IP banned.");
            objectArray[n++] = entityPlayerMP.getEntityName();
        }
        if (list.isEmpty()) {
            CommandServerBanIp.notifyAdmins(iCommandSender, "commands.banip.success", string);
        } else {
            CommandServerBanIp.notifyAdmins(iCommandSender, "commands.banip.success.players", string, CommandServerBanIp.joinNiceString(objectArray));
        }
    }
}

