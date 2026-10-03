/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.Arrays;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class CommandServerMessage
extends CommandBase {
    @Override
    public List getCommandAliases() {
        return Arrays.asList("w", "msg");
    }

    @Override
    public String getCommandName() {
        return "tell";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.message.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 2) {
            throw new pksd("commands.message.usage", new Object[0]);
        }
        EntityPlayerMP entityPlayerMP = CommandServerMessage.getPlayer(iCommandSender, stringArray[0]);
        if (entityPlayerMP == null) {
            throw new mskk();
        }
        if (entityPlayerMP == iCommandSender) {
            throw new mskk("commands.message.sameTarget", new Object[0]);
        }
        String string = CommandServerMessage.func_82361_a(iCommandSender, stringArray, 1, !(iCommandSender instanceof EntityPlayer));
        entityPlayerMP.sendChatToPlayer(ChatMessageComponent._b("commands.message.display.incoming", iCommandSender.getCommandSenderName(), string)._a(EnumChatFormatting._h)._b(true));
        iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.message.display.outgoing", entityPlayerMP.getCommandSenderName(), string)._a(EnumChatFormatting._h)._b(true));
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        return CommandServerMessage.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

