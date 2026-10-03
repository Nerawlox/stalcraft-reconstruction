/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import mods.sound.client.ClientSoundController;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;

public class SoundTickCommand
extends CommandBase {
    @Override
    public String getCommandName() {
        return "soundtick";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/soundtick";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return iCommandSender instanceof EntityPlayer && ((EntityPlayer)iCommandSender).capabilities._d;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        ClientSoundController.enableSoundTick = !ClientSoundController.enableSoundTick;
        iCommandSender.sendChatToPlayer(new ChatMessageComponent()._a("Sound tick active = " + ClientSoundController.enableSoundTick));
    }
}

