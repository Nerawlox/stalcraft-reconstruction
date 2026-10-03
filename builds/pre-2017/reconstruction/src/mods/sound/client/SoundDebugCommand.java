/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import mods.sound.SoundMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class SoundDebugCommand
extends CommandBase {
    @Override
    public String getCommandName() {
        return "sounds";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/sounds <show/hide>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return iCommandSender instanceof EntityPlayer && ((EntityPlayer)iCommandSender).capabilities._d;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (!(iCommandSender instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
        if (!entityPlayer.capabilities._d) {
            return;
        }
        if (stringArray.length <= 1) {
            SoundMod.visualDebug = !SoundMod.visualDebug;
        } else {
            String string = stringArray[1];
            if ("hide".equals(string)) {
                SoundMod.visualDebug = false;
            } else if ("show".equals(string)) {
                SoundMod.visualDebug = true;
            }
        }
    }
}

