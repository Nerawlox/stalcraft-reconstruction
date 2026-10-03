/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import noppes.npcs.containers.ContainerNPCTrader;

class SlotNpcTraderCurrency
extends yeso {
    final ContainerNPCTrader field_75224_c;

    public SlotNpcTraderCurrency(ContainerNPCTrader containerNPCTrader, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this.field_75224_c = containerNPCTrader;
    }

    @Override
    public int func_75219_a() {
        return 64;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return true;
    }
}

