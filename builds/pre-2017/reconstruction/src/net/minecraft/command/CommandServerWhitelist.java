/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandServerWhitelist
extends CommandBase {
    @Override
    public String getCommandName() {
        return "whitelist";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.whitelist.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 1) {
            if (stringArray[0].equals("on")) {
                MinecraftServer._I().__ag()._a(true);
                CommandServerWhitelist.notifyAdmins(iCommandSender, "commands.whitelist.enabled", new Object[0]);
                return;
            }
            if (stringArray[0].equals("off")) {
                MinecraftServer._I().__ag()._a(false);
                CommandServerWhitelist.notifyAdmins(iCommandSender, "commands.whitelist.disabled", new Object[0]);
                return;
            }
            if (stringArray[0].equals("list")) {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.whitelist.list", MinecraftServer._I().__ag()._o().size(), MinecraftServer._I().__ag()._s().length));
                Set set = MinecraftServer._I().__ag()._o();
                iCommandSender.sendChatToPlayer(ChatMessageComponent._d(CommandServerWhitelist.joinNiceString(set.toArray(new String[set.size()]))));
                return;
            }
            if (stringArray[0].equals("add")) {
                if (stringArray.length < 2) {
                    throw new pksd("commands.whitelist.add.usage", new Object[0]);
                }
                MinecraftServer._I().__ag()._d(stringArray[1]);
                CommandServerWhitelist.notifyAdmins(iCommandSender, "commands.whitelist.add.success", stringArray[1]);
                return;
            }
            if (stringArray[0].equals("remove")) {
                if (stringArray.length < 2) {
                    throw new pksd("commands.whitelist.remove.usage", new Object[0]);
                }
                MinecraftServer._I().__ag()._c(stringArray[1]);
                CommandServerWhitelist.notifyAdmins(iCommandSender, "commands.whitelist.remove.success", stringArray[1]);
                return;
            }
            if (stringArray[0].equals("reload")) {
                MinecraftServer._I().__ag()._a();
                CommandServerWhitelist.notifyAdmins(iCommandSender, "commands.whitelist.reloaded", new Object[0]);
                return;
            }
        }
        throw new pksd("commands.whitelist.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandServerWhitelist.getListOfStringsMatchingLastWord(stringArray, "on", "off", "list", "add", "remove", "reload");
        }
        if (stringArray.length == 2) {
            if (stringArray[0].equals("add")) {
                String[] stringArray2 = MinecraftServer._I().__ag()._s();
                ArrayList<String> arrayList = new ArrayList<String>();
                String string = stringArray[stringArray.length - 1];
                for (String string2 : stringArray2) {
                    if (!CommandServerWhitelist.doesStringStartWith(string, string2) || MinecraftServer._I().__ag()._o().contains(string2)) continue;
                    arrayList.add(string2);
                }
                return arrayList;
            }
            if (stringArray[0].equals("remove")) {
                return CommandServerWhitelist.getListOfStringsFromIterableMatchingLastWord(stringArray, MinecraftServer._I().__ag()._o());
            }
        }
        return null;
    }
}

