/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.time.Instant;
import net.minecraft.util.eidj;

public class hbio
extends yfav {
    private int _m = 27;
    private satl _n;
    private Instant _o = null;
    private boolean _p = false;
    private int _q = 0;

    public hbio() {
    }

    public hbio(uyqj uyqj2) {
        this._n = uyqj2._a();
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._p = qoac2._o("EnableLoot") || qoac2._c("LootId");
        this._o = qoac2._c("NextLoot") ? Instant.ofEpochMilli(qoac2._g("NextLoot")) : null;
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("EnableLoot", this._p);
        if (this._o != null) {
            qoac2._a("NextLoot", this._o.toEpochMilli());
        }
    }

    private String _d() {
        twgu twgu2 = this.func_70311_o();
        if (twgu2 instanceof uyqj) {
            return ((uyqj)twgu2)._i;
        }
        return "";
    }

    private String _e() {
        twgu twgu2 = this.func_70311_o();
        if (twgu2 instanceof uyqj) {
            return ((uyqj)twgu2)._j;
        }
        return "";
    }

    @Override
    public void func_70316_g() {
        InvokeSideOnly.frontend(!this.field_70331_k.field_72995_K, () -> {});
    }

    public boolean _a() {
        return this._p;
    }

    public void _a(boolean bl) {
        this._p = bl;
    }

    private void _a(cvzo cvzo2, double d) {
        int n = cvzo2._k();
        if (n > 0) {
            int n2 = (int)((double)n * (1.0 - d) * (double)this.field_70331_k.field_73012_v.nextFloat());
            if (cvzo2._a() instanceof culm) {
                ((culm)((Object)cvzo2._a()))._b(cvzo2, n2);
            }
            cvzo2._f = n2;
        }
    }

    private satl _f() {
        twgu twgu2;
        if (this._n == null && (twgu2 = this.func_70311_o()) instanceof uyqj) {
            this._n = ((uyqj)twgu2)._a();
        }
        return this._n;
    }

    @Override
    public void func_70295_k_() {
        super.func_70295_k_();
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public void func_70305_f() {
        super.func_70305_f();
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public boolean canUpdate() {
        return GloomyCore.side.isServer();
    }

    @Override
    public int func_70302_i_() {
        return this._m;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public eidj getRenderBoundingBox() {
        twgu twgu2 = this.func_70311_o();
        if (twgu2 == null) {
            return hurg.INFINITE_EXTENT_AABB;
        }
        return eidj._a()._a((double)this.field_70329_l + twgu2.field_72026_ch - 4.0, (double)this.field_70330_m + twgu2.field_72023_ci - 4.0, (double)this.field_70327_n + twgu2.field_72024_cj - 4.0, (double)this.field_70329_l + twgu2.field_72021_ck + 5.0, (double)this.field_70330_m + twgu2.field_72022_cl + 5.0, (double)this.field_70327_n + twgu2.field_72019_cm + 5.0);
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, qoac2);
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.func_70307_a(wpte2._e);
    }

    @Override
    public void func_70308_a(ozlu ozlu2) {
        super.func_70308_a(ozlu2);
        InvokeSideOnly.frontend(!ozlu2.field_72995_K, () -> {});
    }

    @Override
    public void func_70312_q() {
        super.func_70312_q();
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }
}

