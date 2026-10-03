/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;

public class CommandEnchant
extends CommandBase {
    @Override
    public String getCommandName() {
        return "enchant";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.enchant.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length >= 2) {
            NBTTagList nBTTagList;
            EntityPlayerMP entityPlayerMP = CommandEnchant.getPlayer(iCommandSender, stringArray[0]);
            int n = CommandEnchant.parseIntBounded(iCommandSender, stringArray[1], 0, Enchantment._a.length - 1);
            int n2 = 1;
            ItemStack itemStack = entityPlayerMP.getCurrentEquippedItem();
            if (itemStack == null) {
                throw new cekk("commands.enchant.noItem", new Object[0]);
            }
            Enchantment enchantment = Enchantment._a[n];
            if (enchantment == null) {
                throw new jjcb("commands.enchant.notFound", n);
            }
            if (!enchantment._a(itemStack)) {
                throw new cekk("commands.enchant.cantEnchant", new Object[0]);
            }
            if (stringArray.length >= 3) {
                n2 = CommandEnchant.parseIntBounded(iCommandSender, stringArray[2], enchantment._b(), enchantment._c());
            }
            if (itemStack._p() && (nBTTagList = itemStack._r()) != null) {
                for (int i = 0; i < nBTTagList._d(); ++i) {
                    Enchantment enchantment2;
                    short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                    if (Enchantment._a[s] == null || (enchantment2 = Enchantment._a[s])._a(enchantment)) continue;
                    throw new cekk("commands.enchant.cantCombine", enchantment._c(n2), enchantment2._c(((NBTTagCompound)nBTTagList._b(i))._e("lvl")));
                }
            }
            itemStack._a(enchantment, n2);
            CommandEnchant.notifyAdmins(iCommandSender, "commands.enchant.success", new Object[0]);
            return;
        }
        throw new pksd("commands.enchant.usage", new Object[0]);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return CommandEnchant.getListOfStringsMatchingLastWord(stringArray, this._a());
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

