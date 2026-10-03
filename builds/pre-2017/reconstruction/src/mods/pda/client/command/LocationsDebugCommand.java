/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.command;

import mods.pda.client.PdaClient;
import mods.pda.client.map.MapSettings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class LocationsDebugCommand
extends CommandBase {
    @Override
    public String getCommandName() {
        return "locations";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/locations <show/hide>";
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
        MapSettings mapSettings = PdaClient.mapSettings;
        if (stringArray.length <= 1) {
            mapSettings.locationsDebug = !mapSettings.locationsDebug;
        } else {
            String string = stringArray[1];
            if ("hide".equals(string)) {
                mapSettings.locationsDebug = false;
            } else if ("show".equals(string)) {
                mapSettings.locationsDebug = true;
            }
        }
    }
}

