/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui;

import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandPainting
extends CommandBase {
    @Override
    public String getCommandName() {
        return "painting";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/painting";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)iCommandSender;
        entityPlayerMP.playerNetServerHandler.func_72567_b(PaintingSelectionMod.createPacket(-1, new String[0]));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return iCommandSender instanceof EntityPlayer;
    }
}

