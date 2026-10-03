/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class cvvn
extends yeso {
    public final /* synthetic */ ozlu _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ int _c;
    public final /* synthetic */ int _d;
    public final /* synthetic */ sdci _e;

    public cvvn(sdci sdci2, mssh mssh2, int n, int n2, int n3, ozlu ozlu2, int n4, int n5, int n6) {
        this._e = sdci2;
        this._a = ozlu2;
        this._b = n4;
        this._c = n5;
        this._d = n6;
        super(mssh2, n, n2, n3);
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return false;
    }

    @Override
    public boolean func_82869_a(EntityPlayer entityPlayer) {
        return (entityPlayer.field_71075_bZ._d || entityPlayer.field_71068_ca >= this._e._g) && this._e._g > 0 && this.func_75216_d();
    }

    @Override
    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (!entityPlayer.field_71075_bZ._d) {
            entityPlayer.func_82242_a(-this._e._g);
        }
        sdci._a(this._e).func_70299_a(0, null);
        if (sdci._b(this._e) > 0) {
            cvzo cvzo3 = sdci._a(this._e).func_70301_a(1);
            if (cvzo3 != null && cvzo3._b > sdci._b(this._e)) {
                cvzo3._b -= sdci._b(this._e);
                sdci._a(this._e).func_70299_a(1, cvzo3);
            } else {
                sdci._a(this._e).func_70299_a(1, null);
            }
        } else {
            sdci._a(this._e).func_70299_a(1, null);
        }
        this._e._g = 0;
        if (!entityPlayer.field_71075_bZ._d && !this._a.field_72995_K && this._a.func_72798_a(this._b, this._c, this._d) == twgu.field_82510_ck.field_71990_ca && entityPlayer.func_70681_au().nextFloat() < 0.12f) {
            int n = this._a.func_72805_g(this._b, this._c, this._d);
            int n2 = n & 3;
            int n3 = n >> 2;
            if (++n3 > 2) {
                this._a.func_94571_i(this._b, this._c, this._d);
                this._a.func_72926_e(1020, this._b, this._c, this._d, 0);
            } else {
                this._a.func_72921_c(this._b, this._c, this._d, n2 | n3 << 2, 2);
                this._a.func_72926_e(1021, this._b, this._c, this._d, 0);
            }
        } else if (!this._a.field_72995_K) {
            this._a.func_72926_e(1021, this._b, this._c, this._d, 0);
        }
    }
}

