/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.hank;

public class yeub
extends bsum {
    public yeub(int n) {
        super(n, false);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        hank hank2 = this.func_77621_a(ozlu2, entityPlayer, true);
        if (hank2 == null) {
            return cvzo2;
        }
        if (hank2._c == amww._a) {
            int n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            if (!ozlu2.func_72962_a(entityPlayer, n, n2, n3)) {
                return cvzo2;
            }
            if (!entityPlayer.func_82247_a(n, n2, n3, hank2._g, cvzo2)) {
                return cvzo2;
            }
            if (ozlu2.func_72803_f(n, n2, n3) == tflj._h && ozlu2.func_72805_g(n, n2, n3) == 0 && ozlu2.func_72799_c(n, n2 + 1, n3)) {
                ozlu2.func_94575_c(n, n2 + 1, n3, twgu.field_71991_bz.field_71990_ca);
                if (!entityPlayer.field_71075_bZ._d) {
                    --cvzo2._b;
                }
            }
        }
        return cvzo2;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return twgu.field_71991_bz.func_71889_f_(cvzo2._j());
    }
}

