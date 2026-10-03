/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class raaa
extends tgdv {
    public raaa(int n) {
        super(n);
        this.field_77777_bU = 16;
        this.func_77637_a(tgbl.field_78031_c);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 == 0) {
            return false;
        }
        if (!ozlu2.func_72803_f(n, n2, n3)._a()) {
            return false;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (!twgu.field_72053_aD.func_71930_b(ozlu2, n, n2, n3)) {
            return false;
        }
        if (ozlu2.field_72995_K) {
            return true;
        }
        if (n4 == 1) {
            int n5 = sajh._c((double)((entityPlayer.field_70177_z + 180.0f) * 16.0f / 360.0f) + 0.5) & 0xF;
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72053_aD.field_71990_ca, n5, 3);
        } else {
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72042_aI.field_71990_ca, n4, 3);
        }
        --cvzo2._b;
        jjza jjza2 = (jjza)ozlu2.func_72796_p(n, n2, n3);
        if (jjza2 != null) {
            entityPlayer.func_71014_a(jjza2);
        }
        return true;
    }
}

