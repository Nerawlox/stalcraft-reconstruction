/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class vlkf
extends iwgt {
    public vlkf(int n) {
        super(n, tflj._f);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new oiid();
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            boolean bl;
            boolean bl2 = ozlu2.func_72864_z(n, n2, n3);
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            boolean bl3 = bl = (n5 & 1) != 0;
            if (bl2 && !bl) {
                ozlu2.func_72921_c(n, n2, n3, n5 | 1, 4);
                ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
            } else if (!bl2 && bl) {
                ozlu2.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFE, 4);
            }
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 != null && hurg2 instanceof oiid) {
            oiid oiid2 = (oiid)hurg2;
            oiid2._a(oiid2._a(ozlu2));
            ozlu2.func_96440_m(n, n2, n3, this.field_71990_ca);
        }
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 1;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        oiid oiid2 = (oiid)ozlu2.func_72796_p(n, n2, n3);
        if (oiid2 != null) {
            entityPlayer.func_71014_a(oiid2);
        }
        return true;
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 != null && hurg2 instanceof oiid) {
            return ((oiid)hurg2)._b();
        }
        return 0;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        oiid oiid2 = (oiid)ozlu2.func_72796_p(n, n2, n3);
        if (cvzo2._u()) {
            oiid2._b(cvzo2._s());
        }
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }
}

