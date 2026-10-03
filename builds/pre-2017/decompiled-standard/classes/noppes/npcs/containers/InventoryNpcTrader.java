/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.containers.ContainerNPCTrader;

public class InventoryNpcTrader
implements mssh {
    private String inventoryTitle;
    private int slotsCount;
    private cvzo[] inventoryContents;
    private ContainerNPCTrader con;

    public InventoryNpcTrader(String string, int n, ContainerNPCTrader containerNPCTrader) {
        this.con = containerNPCTrader;
        this.inventoryTitle = string;
        this.slotsCount = n;
        this.inventoryContents = new cvzo[n];
    }

    @Override
    public cvzo func_70301_a(int n) {
        cvzo cvzo2 = this.inventoryContents[n];
        return cvzo2 == null ? null : cvzo._c(cvzo2);
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            cvzo cvzo2 = this.inventoryContents[n];
            return cvzo._c(cvzo2);
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (cvzo2 != null) {
            this.inventoryContents[n] = cvzo2._l();
        }
        this.func_70296_d();
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
        return true;
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

