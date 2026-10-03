/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandClearInventory
extends CommandBase {
    @Override
    public String getCommandName() {
        return "clear";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.clear.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = stringArray.length == 0 ? CommandClearInventory.getCommandSenderAsPlayer(iCommandSender) : CommandClearInventory.getPlayer(iCommandSender, stringArray[0]);
        int n = stringArray.length >= 2 ? CommandClearInventory.parseIntWithMin(iCommandSender, stringArray[1], 1) : -1;
        int n2 = stringArray.length >= 3 ? CommandClearInventory.parseIntWithMin(iCommandSender, stringArray[2], 0) : -1;
        int n3 = entityPlayerMP.inventory._b(n, n2);
        entityPlayerMP.inventoryContainer.detectAndSendChanges();
        if (!entityPlayerMP.capabilities._d) {
            entityPlayerMP.updateHeldItem();
        }
        if (n3 == 0) {
            throw new cekk("commands.clear.failure", entityPlayerMP.getEntityName());
        }
        CommandClearInventory.notifyAdmins(iCommandSender, "commands.clear.success", entityPlayerMP.getEntityName(), n3);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandClearInventory.getListOfStringsMatchingLastWord(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return MinecraftServer._I()._i();
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return n == 0;
    }
}

