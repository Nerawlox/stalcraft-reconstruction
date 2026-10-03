/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.GameRules;

public class CommandGameRule
extends CommandBase {
    @Override
    public String getCommandName() {
        return "gamerule";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.gamerule.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[0];
            String string2 = stringArray[1];
            GameRules gameRules = this._a();
            if (gameRules._c(string)) {
                gameRules._b(string, string2);
                CommandGameRule.notifyAdmins(iCommandSender, "commands.gamerule.success", new Object[0]);
            } else {
                CommandGameRule.notifyAdmins(iCommandSender, "commands.gamerule.norule", string);
            }
            return;
        }
        if (stringArray.length == 1) {
            String string = stringArray[0];
            GameRules gameRules = this._a();
            if (gameRules._c(string)) {
                String string3 = gameRules._a(string);
                iCommandSender.sendChatToPlayer(ChatMessageComponent._d(string)._a(" = ")._a(string3));
            } else {
                CommandGameRule.notifyAdmins(iCommandSender, "commands.gamerule.norule", string);
            }
            return;
        }
        if (stringArray.length == 0) {
            GameRules gameRules = this._a();
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(CommandGameRule.joinNiceString(gameRules._b())));
            return;
        }
        throw new pksd("commands.gamerule.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandGameRule.getListOfStringsMatchingLastWord(stringArray, this._a()._b());
        }
        if (stringArray.length == 2) {
            return CommandGameRule.getListOfStringsMatchingLastWord(stringArray, "true", "false");
        }
        return null;
    }

    public GameRules _a() {
        return MinecraftServer._I()._a(0).getGameRules();
    }
}

