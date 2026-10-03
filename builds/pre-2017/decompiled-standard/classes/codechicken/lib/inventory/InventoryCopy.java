/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryRange;
import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;

public class InventoryCopy
implements mssh {
    public boolean[] accessible;
    public cvzo[] items;
    public mssh inv;

    public InventoryCopy(mssh mssh2) {
        this.items = new cvzo[mssh2.func_70302_i_()];
        this.accessible = new boolean[mssh2.func_70302_i_()];
        this.inv = mssh2;
        this.update();
    }

    public void update() {
        for (int i = 0; i < this.items.length; ++i) {
            cvzo cvzo2 = this.inv.func_70301_a(i);
            if (cvzo2 == null) continue;
            this.items[i] = cvzo2._l();
        }
    }

    public InventoryCopy open(InventoryRange inventoryRange) {
        int n = inventoryRange.lastSlot();
        if (n > this.accessible.length) {
            boolean[] objectArray = new boolean[n];
            cvzo[] cvzoArray = new cvzo[n];
            System.arraycopy(this.accessible, 0, objectArray, 0, this.accessible.length);
            System.arraycopy(this.items, 0, cvzoArray, 0, this.items.length);
            this.accessible = objectArray;
            this.items = cvzoArray;
        }
        for (int n2 : inventoryRange.slots) {
            this.accessible[n2] = true;
        }
        return this;
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
        return "copy";
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
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return this.inv.func_94041_b(n, cvzo2);
    }

    @Override
    public boolean func_94042_c() {
        return true;
    }
}

