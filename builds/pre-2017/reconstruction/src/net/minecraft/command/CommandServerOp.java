/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerOp
extends CommandBase {
    @Override
    public String getCommandName() {
        return "op";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.op.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            MinecraftServer._I().__ag()._a(stringArray[0]);
            CommandServerOp.notifyAdmins(iCommandSender, "commands.op.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.op.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            String string = stringArray[stringArray.length - 1];
            ArrayList<String> arrayList = new ArrayList<String>();
            for (String string2 : MinecraftServer._I()._i()) {
                if (MinecraftServer._I().__ag()._g(string2) || !CommandServerOp.doesStringStartWith(string, string2)) continue;
                arrayList.add(string2);
            }
            return arrayList;
        }
        return null;
    }
}

