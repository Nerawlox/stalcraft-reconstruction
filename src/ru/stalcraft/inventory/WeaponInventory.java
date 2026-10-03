/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 */
package ru.stalcraft.inventory;

public class WeaponInventory
implements mo {
    public ye[] contents = new ye[3];

    public int j_() {
        return 3;
    }

    public ye a(int i2) {
        return this.contents[i2];
    }

    public ye a(int slot, int count) {
        if (this.contents[slot] != null) {
            if (this.contents[slot].b <= count) {
                ye itemstack = this.contents[slot];
                this.contents[slot] = null;
                return itemstack;
            }
            ye itemstack = this.contents[slot].a(count);
            if (this.contents[slot].b == 0) {
                this.contents[slot] = null;
            }
            return itemstack;
        }
        return null;
    }

    public ye a_(int slot) {
        if (this.contents[slot] != null) {
            ye itemstack = this.contents[slot];
            this.contents[slot] = null;
            return itemstack;
        }
        return null;
    }

    public void a(int i2, ye itemstack) {
        this.contents[i2] = itemstack;
    }

    public String b() {
        return "StalkerWeapon";
    }

    public boolean c() {
        return false;
    }

    public int d() {
        return 1;
    }

    public void e() {
    }

    public boolean a(uf entityplayer) {
        return true;
    }

    public void k_() {
    }

    public void g() {
    }

    public boolean b(int i2, ye itemstack) {
        return true;
    }
}

