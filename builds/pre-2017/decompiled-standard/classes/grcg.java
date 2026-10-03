/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class grcg
extends mbpd {
    public final boolean _a;
    public final ndvn _b;
    public final ndvn _c;

    public grcg(int n, ndvn ndvn2, ndvn ndvn3, boolean bl) {
        super(n);
        this._b = ndvn2;
        this._c = ndvn3;
        this._a = bl;
        this.func_77656_e(0);
        this.func_77627_a(true);
    }

    @Override
    public dwan func_77617_a(int n) {
        return twgu.field_71973_m[this.field_77779_bT].func_71858_a(2, n);
    }

    @Override
    public int func_77647_b(int n) {
        return n;
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        return this._b._b(cvzo2._j());
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        boolean bl;
        if (this._a) {
            return super.func_77648_a(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
        }
        if (cvzo2._b == 0) {
            return false;
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        int n6 = ozlu2.func_72805_g(n, n2, n3);
        int n7 = n6 & 7;
        boolean bl2 = bl = (n6 & 8) != 0;
        if ((n4 == 1 && !bl || n4 == 0 && bl) && n5 == this._b.field_71990_ca && n7 == cvzo2._j()) {
            if (ozlu2.func_72855_b(this._c.func_71872_e(ozlu2, n, n2, n3)) && ozlu2.func_72832_d(n, n2, n3, this._c.field_71990_ca, n7, 3)) {
                ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._c.field_72020_cn._e(), (this._c.field_72020_cn._a() + 1.0f) / 2.0f, this._c.field_72020_cn._b() * 0.8f);
                --cvzo2._b;
            }
            return true;
        }
        if (this._a(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4)) {
            return true;
        }
        return super.func_77648_a(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
    }

    @Override
    public boolean func_77884_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer, cvzo cvzo2) {
        boolean bl;
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        int n8 = ozlu2.func_72798_a(n, n2, n3);
        int n9 = ozlu2.func_72805_g(n, n2, n3);
        int n10 = n9 & 7;
        boolean bl2 = bl = (n9 & 8) != 0;
        if ((n4 == 1 && !bl || n4 == 0 && bl) && n8 == this._b.field_71990_ca && n10 == cvzo2._j()) {
            return true;
        }
        if (n4 == 0) {
            --n2;
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
        n8 = ozlu2.func_72798_a(n, n2, n3);
        n9 = ozlu2.func_72805_g(n, n2, n3);
        n10 = n9 & 7;
        boolean bl3 = bl = (n9 & 8) != 0;
        if (n8 == this._b.field_71990_ca && n10 == cvzo2._j()) {
            return true;
        }
        return super.func_77884_a(ozlu2, n5, n6, n7, n4, entityPlayer, cvzo2);
    }

    public boolean _a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
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
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        int n6 = ozlu2.func_72805_g(n, n2, n3);
        int n7 = n6 & 7;
        if (n5 == this._b.field_71990_ca && n7 == cvzo2._j()) {
            if (ozlu2.func_72855_b(this._c.func_71872_e(ozlu2, n, n2, n3)) && ozlu2.func_72832_d(n, n2, n3, this._c.field_71990_ca, n7, 3)) {
                ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._c.field_72020_cn._e(), (this._c.field_72020_cn._a() + 1.0f) / 2.0f, this._c.field_72020_cn._b() * 0.8f);
                --cvzo2._b;
            }
            return true;
        }
        return false;
    }
}

