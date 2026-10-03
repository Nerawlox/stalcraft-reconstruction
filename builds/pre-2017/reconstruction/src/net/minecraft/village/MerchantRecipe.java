/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MerchantRecipe {
    public ItemStack _a;
    public ItemStack _b;
    public ItemStack _c;
    public int _d;
    public int _e;

    public MerchantRecipe(NBTTagCompound nBTTagCompound) {
        this._a(nBTTagCompound);
    }

    public MerchantRecipe(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        this._a = itemStack;
        this._b = itemStack2;
        this._c = itemStack3;
        this._e = 7;
    }

    public MerchantRecipe(ItemStack itemStack, ItemStack itemStack2) {
        this(itemStack, null, itemStack2);
    }

    public MerchantRecipe(ItemStack itemStack, Item item) {
        this(itemStack, new ItemStack(item));
    }

    public ItemStack _a() {
        return this._a;
    }

    public ItemStack _b() {
        return this._b;
    }

    public boolean _c() {
        return this._b != null;
    }

    public ItemStack _d() {
        return this._c;
    }

    public boolean _a(MerchantRecipe merchantRecipe) {
        if (this._a._d != merchantRecipe._a._d || this._c._d != merchantRecipe._c._d) {
            return false;
        }
        return this._b == null && merchantRecipe._b == null || this._b != null && merchantRecipe._b != null && this._b._d == merchantRecipe._b._d;
    }

    public boolean _b(MerchantRecipe merchantRecipe) {
        return this._a(merchantRecipe) && (this._a._b < merchantRecipe._a._b || this._b != null && this._b._b < merchantRecipe._b._b);
    }

    public void _e() {
        ++this._d;
    }

    public void _a(int n) {
        this._e += n;
    }

    public boolean _f() {
        return this._d >= this._e;
    }

    public void _g() {
        this._d = this._e;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("buy");
        this._a = ItemStack._a(nBTTagCompound2);
        NBTTagCompound nBTTagCompound3 = nBTTagCompound._m("sell");
        this._c = ItemStack._a(nBTTagCompound3);
        if (nBTTagCompound._c("buyB")) {
            this._b = ItemStack._a(nBTTagCompound._m("buyB"));
        }
        if (nBTTagCompound._c("uses")) {
            this._d = nBTTagCompound._f("uses");
        }
        this._e = nBTTagCompound._c("maxUses") ? nBTTagCompound._f("maxUses") : 7;
    }

    public NBTTagCompound _h() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("buy", this._a._b(new NBTTagCompound("buy")));
        nBTTagCompound._a("sell", this._c._b(new NBTTagCompound("sell")));
        if (this._b != null) {
            nBTTagCompound._a("buyB", this._b._b(new NBTTagCompound("buyB")));
        }
        nBTTagCompound._a("uses", this._d);
        nBTTagCompound._a("maxUses", this._e);
        return nBTTagCompound;
    }
}

