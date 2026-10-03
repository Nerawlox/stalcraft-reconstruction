/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class ifhy
extends dgwv {
    public ifhy(int n) {
        super(n, "ice", tflj._w, false);
        this.field_72016_cq = 0.98f;
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return super.func_71877_c(sdrg2, n, n2, n3, 1 - n4);
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        entityPlayer.func_71064_a(dzif._C[this.field_71990_ca], 1);
        entityPlayer.func_71020_j(0.025f);
        if (this.func_71906_q_() && zhty._d(entityPlayer)) {
            cvzo cvzo2 = this.func_71880_c_(n4);
            if (cvzo2 != null) {
                this.func_71929_a(ozlu2, n, n2, n3, cvzo2);
            }
        } else {
            if (ozlu2.field_73011_w._f) {
                ozlu2.func_94571_i(n, n2, n3);
                return;
            }
            int n5 = zhty._e(entityPlayer);
            this.func_71897_c(ozlu2, n, n2, n3, n4, n5);
            tflj tflj2 = ozlu2.func_72803_f(n, n2 - 1, n3);
            if (tflj2._c() || tflj2._d()) {
                ozlu2.func_94575_c(n, n2, n3, twgu.field_71942_A.field_71990_ca);
            }
        }
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.func_72972_b(rrqi._b, n, n2, n3) > 11 - twgu.field_71971_o[this.field_71990_ca]) {
            if (ozlu2.field_73011_w._f) {
                ozlu2.func_94571_i(n, n2, n3);
                return;
            }
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94575_c(n, n2, n3, twgu.field_71943_B.field_71990_ca);
        }
    }

    @Override
    public int func_71915_e() {
        return 0;
    }
}

