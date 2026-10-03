/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;

public class InventoryNPC
implements mssh {
    private String inventoryTitle;
    private int slotsCount;
    private cvzo[] inventoryContents;
    private jjgc con;

    public InventoryNPC(String string, int n, jjgc jjgc2) {
        this.con = jjgc2;
        this.inventoryTitle = string;
        this.slotsCount = n;
        this.inventoryContents = new cvzo[n];
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.inventoryContents[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            if (this.inventoryContents[n]._b <= n2) {
                cvzo cvzo2 = this.inventoryContents[n];
                this.inventoryContents[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = this.inventoryContents[n]._a(n2);
            if (this.inventoryContents[n]._b == 0) {
                this.inventoryContents[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.inventoryContents[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
    }

    @Override
    public int func_70302_i_() {
        return this.slotsCount;
    }

    @Override
    public String func_70303_b() {
        return this.inventoryTitle;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        this.con.func_75130_a(this);
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public cvzo func_70304_b(int n) {
        return null;
    }

    @Override
    public boolean func_94042_c() {
        return true;
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

