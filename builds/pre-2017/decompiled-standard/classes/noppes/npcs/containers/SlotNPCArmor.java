/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.util.dwan;
import noppes.npcs.containers.ContainerNPCInv;

class SlotNPCArmor
extends yeso {
    final int armorType;
    final ContainerNPCInv field_75224_c;

    SlotNPCArmor(ContainerNPCInv containerNPCInv, mssh mssh2, int n, int n2, int n3, int n4) {
        super(mssh2, n, n2, n3);
        this.field_75224_c = containerNPCInv;
        this.armorType = n4;
    }

    @Override
    public int func_75219_a() {
        return 1;
    }

    @Override
    public dwan func_75212_b() {
        return lpno.func_94602_b(this.armorType);
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return cvzo2._a() instanceof lpno ? ((lpno)cvzo2._a()).field_77881_a == this.armorType : (cvzo2._a() instanceof mbpd ? this.armorType == 0 : false);
    }
}

