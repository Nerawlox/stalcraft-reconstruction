/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.potion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;

public class PotionEffect {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    @SideOnly(value=Side.CLIENT)
    public boolean _f;
    public List<ItemStack> _g;

    public PotionEffect(int n, int n2) {
        this(n, n2, 0);
    }

    public PotionEffect(int n, int n2, int n3) {
        this(n, n2, n3, false);
    }

    public PotionEffect(int n, int n2, int n3, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._e = bl;
        this._g = new ArrayList<ItemStack>();
        this._g.add(new ItemStack(Item.bucketMilk));
    }

    public PotionEffect(PotionEffect potionEffect) {
        this._a = potionEffect._a;
        this._b = potionEffect._b;
        this._c = potionEffect._c;
        this._g = potionEffect._d();
    }

    public void _a(PotionEffect potionEffect) {
        if (this._a != potionEffect._a) {
            System.err.println("This method should only be called for matching effects!");
        }
        if (potionEffect._c > this._c) {
            this._c = potionEffect._c;
            this._b = potionEffect._b;
        } else if (potionEffect._c == this._c && this._b < potionEffect._b) {
            this._b = potionEffect._b;
        } else if (!potionEffect._e && this._e) {
            this._e = potionEffect._e;
        }
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public List<ItemStack> _d() {
        return this._g;
    }

    public boolean _a(ItemStack itemStack) {
        boolean bl = false;
        for (ItemStack itemStack2 : this._g) {
            if (!itemStack2._b(itemStack)) continue;
            bl = true;
        }
        return bl;
    }

    public void _a(List<ItemStack> list2) {
        this._g = list2;
    }

    public void _b(ItemStack itemStack) {
        boolean bl = false;
        for (ItemStack itemStack2 : this._g) {
            if (!itemStack2._b(itemStack)) continue;
            bl = true;
        }
        if (!bl) {
            this._g.add(itemStack);
        }
    }

    public void _a(boolean bl) {
        this._d = bl;
    }

    public boolean _e() {
        return this._e;
    }

    public boolean _a(EntityLivingBase entityLivingBase) {
        if (this._b > 0) {
            if (Potion._a[this._a]._b(this._b, this._c)) {
                this._b(entityLivingBase);
            }
            this._f();
        }
        return this._b > 0;
    }

    public int _f() {
        return --this._b;
    }

    public void _b(EntityLivingBase entityLivingBase) {
        if (this._b > 0) {
            Potion._a[this._a]._a(entityLivingBase, this._c);
        }
    }

    public String _g() {
        return Potion._a[this._a]._c();
    }

    public int hashCode() {
        return this._a;
    }

    public String toString() {
        String string = "";
        string = this._c() > 0 ? this._g() + " x " + (this._c() + 1) + ", Duration: " + this._b() : this._g() + ", Duration: " + this._b();
        if (this._d) {
            string = string + ", Splash: true";
        }
        return Potion._a[this._a]._h() ? "(" + string + ")" : string;
    }

    public boolean equals(Object object) {
        if (!(object instanceof PotionEffect)) {
            return false;
        }
        PotionEffect potionEffect = (PotionEffect)object;
        return this._a == potionEffect._a && this._c == potionEffect._c && this._b == potionEffect._b && this._d == potionEffect._d && this._e == potionEffect._e;
    }

    public NBTTagCompound _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Id", (byte)this._a());
        nBTTagCompound._a("Amplifier", (byte)this._c());
        nBTTagCompound._a("Duration", this._b());
        nBTTagCompound._a("Ambient", this._e());
        return nBTTagCompound;
    }

    public static PotionEffect _b(NBTTagCompound nBTTagCompound) {
        byte by = nBTTagCompound._d("Id");
        byte by2 = nBTTagCompound._d("Amplifier");
        int n = nBTTagCompound._f("Duration");
        boolean bl = nBTTagCompound._o("Ambient");
        return new PotionEffect(by, n, by2, bl);
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(boolean bl) {
        this._f = bl;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _h() {
        return this._f;
    }
}

