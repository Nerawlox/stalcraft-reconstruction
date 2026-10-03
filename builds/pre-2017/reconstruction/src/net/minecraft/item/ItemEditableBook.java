/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class ItemEditableBook
extends Item {
    public ItemEditableBook(int n) {
        super(n);
        this.setMaxStackSize(1);
    }

    public static boolean _a(NBTTagCompound nBTTagCompound) {
        if (!sdgq._a(nBTTagCompound)) {
            return false;
        }
        if (!nBTTagCompound._c("title")) {
            return false;
        }
        String string = nBTTagCompound._j("title");
        if (string == null || string.length() > 16) {
            return false;
        }
        return nBTTagCompound._c("author");
    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound;
        NBTTagString nBTTagString;
        if (itemStack._p() && (nBTTagString = (NBTTagString)(nBTTagCompound = itemStack._q())._b("title")) != null) {
            return nBTTagString.toString();
        }
        return super.getItemDisplayName(itemStack);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bl) {
        NBTTagCompound nBTTagCompound;
        NBTTagString nBTTagString;
        if (itemStack._p() && (nBTTagString = (NBTTagString)(nBTTagCompound = itemStack._q())._b("author")) != null) {
            list.add((Object)((Object)EnumChatFormatting._h) + String.format(tdpx._a("book.byAuthor", nBTTagString._c), new Object[0]));
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.displayGUIBook(itemStack);
        return itemStack;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }
}

