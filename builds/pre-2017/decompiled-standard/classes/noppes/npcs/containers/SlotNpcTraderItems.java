/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

class SlotNpcTraderItems
extends yeso {
    public SlotNpcTraderItems(mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
    }

    public void onPickupFromSlot(cvzo cvzo2) {
        if (cvzo2 != null && this.func_75211_c() != null && cvzo2._d == this.func_75211_c()._d) {
            --cvzo2._b;
        }
    }

    @Override
    public int func_75219_a() {
        return 64;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return false;
    }
}

