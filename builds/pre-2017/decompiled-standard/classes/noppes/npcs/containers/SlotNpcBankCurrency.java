/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import noppes.npcs.containers.ContainerNPCBankInterface;

public class SlotNpcBankCurrency
extends yeso {
    public cvzo item;

    public SlotNpcBankCurrency(ContainerNPCBankInterface containerNPCBankInterface, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
    }

    @Override
    public int func_75219_a() {
        return 64;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return this.item == null ? false : this.item._d == cvzo2._d && (!this.item._g() || this.item._j() == cvzo2._j());
    }
}

