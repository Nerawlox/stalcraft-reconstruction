/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;

public class InventoryNBT
implements mssh {
    protected cvzo[] items;
    protected qoac tag;

    public InventoryNBT(int n, qoac qoac2) {
        this.tag = qoac2;
        this.items = new cvzo[n];
        this.readNBT();
    }

    private void writeNBT() {
        this.tag._a("items", InventoryUtils.writeItemStacksToTag(this.items, this.func_70297_j_()));
    }

    private void readNBT() {
        if (this.tag._c("items")) {
            InventoryUtils.readItemStacksFromTag(this.items, this.tag._n("items"));
        }
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
        return "NBT";
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        this.writeNBT();
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
}

