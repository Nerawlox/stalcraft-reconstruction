/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class CommandHelp
extends CommandBase {
    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.help.usage";
    }

    @Override
    public List getCommandAliases() {
        return Arrays.asList("?");
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        List list = this._a(iCommandSender);
        int n = 7;
        int n2 = (list.size() - 1) / n;
        int n3 = 0;
        try {
            n3 = stringArray.length == 0 ? 0 : CommandHelp.parseIntBounded(iCommandSender, stringArray[0], 1, n2 + 1) - 1;
        }
        catch (jjcb jjcb2) {
            Map map = this._a();
            ICommand iCommand = (ICommand)map.get(stringArray[0]);
            if (iCommand != null) {
                throw new pksd(iCommand.getCommandUsage(iCommandSender), new Object[0]);
            }
            throw new dhob();
        }
        int n4 = Math.min((n3 + 1) * n, list.size());
        iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.help.header", n3 + 1, n2 + 1)._a(EnumChatFormatting._c));
        for (int i = n3 * n; i < n4; ++i) {
            ICommand iCommand = (ICommand)list.get(i);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._e(iCommand.getCommandUsage(iCommandSender)));
        }
        if (n3 == 0 && iCommandSender instanceof EntityPlayer) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.help.footer")._a(EnumChatFormatting._k));
        }
    }

    public List _a(ICommandSender iCommandSender) {
        List list = MinecraftServer._I()._J().getPossibleCommands(iCommandSender);
        Collections.sort(list);
        return list;
    }

    public Map _a() {
        return MinecraftServer._I()._J().getCommands();
    }
}

