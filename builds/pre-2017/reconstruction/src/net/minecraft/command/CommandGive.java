/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class CommandGive
extends CommandBase {
    @Override
    public String getCommandName() {
        return "give";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.give.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 2) {
            EntityPlayerMP entityPlayerMP = CommandGive.getPlayer(iCommandSender, stringArray[0]);
            int n = CommandGive.parseIntWithMin(iCommandSender, stringArray[1], 1);
            int n2 = 1;
            int n3 = 0;
            if (Item.itemsList[n] == null) {
                throw new jjcb("commands.give.notFound", n);
            }
            if (stringArray.length >= 3) {
                n2 = CommandGive.parseIntBounded(iCommandSender, stringArray[2], 1, 64);
            }
            if (stringArray.length >= 4) {
                n3 = CommandGive.parseInt(iCommandSender, stringArray[3]);
            }
            ItemStack itemStack = new ItemStack(n, n2, n3);
            EntityItem entityItem = ((EntityPlayer)entityPlayerMP).dropPlayerItem(itemStack);
            entityItem.delayBeforeCanPickup = 0;
            CommandGive.notifyAdmins(iCommandSender, "commands.give.success", Item.itemsList[n].getItemStackDisplayName(itemStack), n, n2, entityPlayerMP.getEntityName());
            return;
        }
        throw new pksd("commands.give.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandGive.getListOfStringsMatchingLastWord(stringArray, this._a());
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

