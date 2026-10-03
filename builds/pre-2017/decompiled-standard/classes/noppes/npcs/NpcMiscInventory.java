/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NBTTags;

public class NpcMiscInventory
implements mssh {
    public HashMap<Integer, cvzo> items = new HashMap();
    public int stackLimit = 64;
    private int size;

    public NpcMiscInventory(int n) {
        this.size = n;
    }

    public qoac getToNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("NpcMiscInv", NBTTags.nbtItemStackList(this.items));
        return qoac2;
    }

    public void setFromNBT(qoac qoac2) {
        this.items = NBTTags.getItemStackList(qoac2._n("NpcMiscInv"));
    }

    @Override
    public int func_70302_i_() {
        return this.size;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.items.get(n);
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        cvzo cvzo2 = null;
        if (this.items.get(n) != null) {
            if (this.items.get((Object)Integer.valueOf((int)n))._b <= n2) {
                cvzo2 = this.items.get(n);
                this.items.put(n, null);
            } else {
                cvzo2 = this.items.get(n)._a(n2);
                if (this.items.get((Object)Integer.valueOf((int)n))._b == 0) {
                    this.items.put(n, null);
                }
            }
        }
        return cvzo2;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this.items.get(n) != null) {
            cvzo cvzo2 = this.items.get(n);
            this.items.put(n, null);
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.items.put(n, cvzo2);
    }

    @Override
    public String func_70303_b() {
        return "Npc Misc Inventory";
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
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
    public boolean func_94042_c() {
        return true;
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

