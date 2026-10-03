/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class MappedInventoryAccess
implements mssh {
    public static final InventoryAccessor fullAccess = new InventoryAccessor(){

        @Override
        public boolean canAccessSlot(int n) {
            return true;
        }
    };
    private ArrayList<Integer> slotMap = new ArrayList();
    private mssh inv;
    private ArrayList<InventoryAccessor> accessors = new ArrayList();

    public MappedInventoryAccess(mssh mssh2, InventoryAccessor ... inventoryAccessorArray) {
        this.inv = mssh2;
        for (InventoryAccessor inventoryAccessor : inventoryAccessorArray) {
            this.accessors.add(inventoryAccessor);
        }
        this.reset();
    }

    public void reset() {
        this.slotMap.clear();
        block0: for (int i = 0; i < this.inv.func_70302_i_(); ++i) {
            for (InventoryAccessor inventoryAccessor : this.accessors) {
                if (inventoryAccessor.canAccessSlot(i)) continue;
                continue block0;
            }
            this.slotMap.add(i);
        }
    }

    @Override
    public int func_70302_i_() {
        return this.slotMap.size();
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.inv.func_70301_a(this.slotMap.get(n));
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        return this.inv.func_70298_a(this.slotMap.get(n), n2);
    }

    @Override
    public cvzo func_70304_b(int n) {
        return this.inv.func_70304_b(this.slotMap.get(n));
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.inv.func_70299_a(this.slotMap.get(n), cvzo2);
    }

    @Override
    public String func_70303_b() {
        return this.inv.func_70303_b();
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        this.inv.func_70296_d();
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this.inv.func_70300_a(entityPlayer);
    }

    @Override
    public void func_70295_k_() {
        this.inv.func_70295_k_();
    }

    @Override
    public void func_70305_f() {
        this.inv.func_70305_f();
    }

    public void addAccessor(InventoryAccessor inventoryAccessor) {
        this.accessors.add(inventoryAccessor);
        this.reset();
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return this.inv.func_94041_b(this.slotMap.get(n), cvzo2);
    }

    @Override
    public boolean func_94042_c() {
        return true;
    }

    public List<InventoryAccessor> accessors() {
        return this.accessors;
    }

    public static interface InventoryAccessor {
        public boolean canAccessSlot(int var1);
    }
}

