/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;

public class CommandKill
extends CommandBase {
    @Override
    public String getCommandName() {
        return "kill";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.kill.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = CommandKill.getCommandSenderAsPlayer(iCommandSender);
        ((EntityPlayer)entityPlayerMP).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
        iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.kill.success"));
    }
}

