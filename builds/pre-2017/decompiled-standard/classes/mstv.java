/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;

public class mstv
extends tgdv {
    public mstv(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78038_k);
    }

    @Override
    public dwan func_77617_a(int n) {
        return tgdv.field_77726_bs.func_77617_a(0);
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
            if (ozlu2.func_72803_f(n, n2, n3) == tflj._h) {
                --cvzo2._b;
                if (cvzo2._b <= 0) {
                    return new cvzo(tgdv.field_77726_bs);
                }
                if (!entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77726_bs))) {
                    entityPlayer.func_71021_b(new cvzo(tgdv.field_77726_bs.field_77779_bT, 1, 0));
                }
            }
        }
        return cvzo2;
    }

    @Override
    public void func_94581_a(nege nege2) {
    }
}

