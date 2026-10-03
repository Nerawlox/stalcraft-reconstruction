/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class zwat
extends tehy {
    public static final String _a = "donateinv";
    private xqsf _b;

    public zwat(ccxr ccxr2) {
        super(ccxr2);
    }

    @Override
    public void resetHandler() {
        if (this._b == null) {
            this._b = new dghc();
        }
    }

    public xqsf _a() {
        return this._b;
    }

    public ItemStack _a(ItemStack itemStack) {
        return zwat._a(itemStack, this.player.username);
    }

    public static ItemStack _a(ItemStack itemStack, String string) {
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        itemStack._e._a("buyer", string);
        return itemStack;
    }

    public static zwat _a(EntityPlayer entityPlayer) {
        return (zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public static xqsf _b(EntityPlayer entityPlayer) {
        return ((zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a))._a();
    }
}

