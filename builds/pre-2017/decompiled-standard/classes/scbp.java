/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class scbp
extends aorr {
    public scbp(int n) {
        super(n, tflj._l);
        float f = 0.4f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    public boolean _a(int n) {
        return n == twgu.field_71939_E.field_71990_ca;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K && entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._d == tgdv.field_77745_be.field_77779_bT) {
            entityPlayer.func_71064_a(dzif._C[this.field_71990_ca], 1);
            this.func_71929_a(ozlu2, n, n2, n3, new cvzo(twgu.field_71961_Y, 1, n4));
        } else {
            super.func_71893_a(ozlu2, entityPlayer, n, n2, n3, n4);
        }
    }
}

