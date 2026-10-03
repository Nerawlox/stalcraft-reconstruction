/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

public class InventoryRange {
    public mssh inv;
    public int side;
    public gaaa sidedInv;
    public int[] slots;

    public InventoryRange(mssh mssh2, int n) {
        this.inv = mssh2;
        this.side = n;
        if (mssh2 instanceof gaaa) {
            this.sidedInv = (gaaa)mssh2;
            this.slots = this.sidedInv._a(n);
        } else {
            this.slots = new int[mssh2.func_70302_i_()];
            for (int i = 0; i < this.slots.length; ++i) {
                this.slots[i] = i;
            }
        }
    }

    public InventoryRange(mssh mssh2) {
        this(mssh2, 0);
    }

    public InventoryRange(mssh mssh2, int n, int n2) {
        this.inv = mssh2;
        this.slots = new int[n2 - n];
        for (int i = 0; i < this.slots.length; ++i) {
            this.slots[i] = n + i;
        }
    }

    public InventoryRange(mssh mssh2, InventoryRange inventoryRange) {
        this.inv = mssh2;
        this.slots = inventoryRange.slots;
        this.side = inventoryRange.side;
        if (mssh2 instanceof gaaa) {
            this.sidedInv = (gaaa)mssh2;
        }
    }

    public boolean canInsertItem(int n, cvzo cvzo2) {
        return this.sidedInv == null ? this.inv.func_94041_b(n, cvzo2) : this.sidedInv._a(n, cvzo2, this.side);
    }

    public boolean canExtractItem(int n, cvzo cvzo2) {
        return this.sidedInv == null ? this.inv.func_94041_b(n, cvzo2) : this.sidedInv._b(n, cvzo2, this.side);
    }

    public int lastSlot() {
        int n = 0;
        for (int n2 : this.slots) {
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }
}

