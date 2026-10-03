/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class dhnh
extends htys {
    public htvc _a;

    public void _a(mcbr mcbr2, double d, double d2, double d3, float f) {
        twgu twgu2 = twgu.field_71973_m[mcbr2._a()];
        if (twgu2 != null && mcbr2._a(f) < 1.0f) {
            htvf htvf2 = htvf.field_78398_a;
            this.func_110628_a(sctd._c);
            qnon._a();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            if (xpzm._C()) {
                GL11.glShadeModel(7425);
            } else {
                GL11.glShadeModel(7424);
            }
            htvf2.func_78382_b();
            htvf2.func_78373_b((float)d - (float)mcbr2.field_70329_l + mcbr2._b(f), (float)d2 - (float)mcbr2.field_70330_m + mcbr2._c(f), (float)d3 - (float)mcbr2.field_70327_n + mcbr2._d(f));
            htvf2.func_78376_a(1, 1, 1);
            if (twgu2 == twgu.field_72099_aa && mcbr2._a(f) < 0.5f) {
                this._a._b(twgu2, mcbr2.field_70329_l, mcbr2.field_70330_m, mcbr2.field_70327_n, false);
            } else if (mcbr2._d() && !mcbr2._b()) {
                twgu.field_72099_aa._a(((cdvp)twgu2)._a());
                this._a._b((twgu)twgu.field_72099_aa, mcbr2.field_70329_l, mcbr2.field_70330_m, mcbr2.field_70327_n, mcbr2._a(f) < 0.5f);
                twgu.field_72099_aa._a();
                htvf2.func_78373_b((float)d - (float)mcbr2.field_70329_l, (float)d2 - (float)mcbr2.field_70330_m, (float)d3 - (float)mcbr2.field_70327_n);
                this._a._e(twgu2, mcbr2.field_70329_l, mcbr2.field_70330_m, mcbr2.field_70327_n);
            } else {
                this._a._a(twgu2, mcbr2.field_70329_l, mcbr2.field_70330_m, mcbr2.field_70327_n);
            }
            htvf2.func_78373_b(0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            qnon._b();
        }
    }

    @Override
    public void func_76896_a(ozlu ozlu2) {
        this._a = new htvc(ozlu2);
    }

    @Override
    public /* synthetic */ void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((mcbr)hurg2, d, d2, d3, f);
    }
}

