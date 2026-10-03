/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;

public class InventorySimple
implements mssh {
    public cvzo[] items;
    public int limit;
    public String name;

    public InventorySimple(cvzo[] cvzoArray, int n, String string) {
        this.items = cvzoArray;
        this.limit = n;
        this.name = string;
    }

    public InventorySimple(cvzo[] cvzoArray, String string) {
        this(cvzoArray, 64, string);
    }

    public InventorySimple(cvzo[] cvzoArray, int n) {
        this(cvzoArray, n, "inv");
    }

    public InventorySimple(cvzo[] cvzoArray) {
        this(cvzoArray, 64, "inv");
    }

    public InventorySimple(int n, int n2, String string) {
        this(new cvzo[n], n2, string);
    }

    public InventorySimple(int n, int n2) {
        this(n, n2, "inv");
    }

    public InventorySimple(int n, String string) {
        this(n, 64, string);
    }

    public InventorySimple(int n) {
        this(n, 64, "inv");
    }

    @Override
    public int func_70302_i_() {
        return this.items.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.items[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        return InventoryUtils.decrStackSize(this, n, n2);
    }

    @Override
    public cvzo func_70304_b(int n) {
        return InventoryUtils.getStackInSlotOnClosing(this, n);
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.items[n] = cvzo2;
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return this.name;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    @Override
    public boolean func_94042_c() {
        return true;
    }

    @Override
    public void func_70296_d() {
    }
}

