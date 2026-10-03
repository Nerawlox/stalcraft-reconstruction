/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.owak;

public class ejzq
extends ejzs {
    public final vmgb _f = new bbmo();

    public ejzq(int n) {
        super(n);
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("furnace_side");
        this._c = nege2._b("furnace_top");
        this._d = nege2._b(this.func_111023_E() + "_front_horizontal");
        this._e = nege2._b(this.func_111023_E() + "_front_vertical");
    }

    @Override
    public vmgb _a(cvzo cvzo2) {
        return this._f;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new hdtl();
    }

    @Override
    public void _b(ozlu ozlu2, int n, int n2, int n3) {
        rqep rqep2 = new rqep(ozlu2, n, n2, n3);
        jjzo jjzo2 = (jjzo)rqep2._i();
        if (jjzo2 == null) {
            return;
        }
        int n4 = jjzo2._a();
        if (n4 < 0) {
            ozlu2.func_72926_e(1001, n, n2, n3, 0);
        } else {
            cvzo cvzo2;
            cvzo cvzo3 = jjzo2.func_70301_a(n4);
            int n5 = ozlu2.func_72805_g(n, n2, n3) & 7;
            mssh mssh2 = cffd._b(ozlu2, n + owak._b[n5], (double)(n2 + owak._c[n5]), (double)(n3 + owak._d[n5]));
            if (mssh2 != null) {
                cvzo2 = cffd._a(mssh2, cvzo3._l()._a(1), owak._a[n5]);
                if (cvzo2 == null) {
                    cvzo2 = cvzo3._l();
                    if (--cvzo2._b == 0) {
                        cvzo2 = null;
                    }
                } else {
                    cvzo2 = cvzo3._l();
                }
            } else {
                cvzo2 = this._f._a(rqep2, cvzo3);
                if (cvzo2 != null && cvzo2._b == 0) {
                    cvzo2 = null;
                }
            }
            jjzo2.func_70299_a(n4, cvzo2);
        }
    }
}

