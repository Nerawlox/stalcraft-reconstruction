/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.respawn.jxtc;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class fmle
extends jxtc
implements mssh {
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public String _a;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public String _b;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _c;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _d;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _e;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _f;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _g;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int _h;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean _i;
    public final xqsf _j = new xqsf("\u0421\u043a\u043b\u0430\u0434 \u0431\u0430\u0437\u044b", "Items");
    private einh _p;
    private int _q = -1;

    @Override
    public void func_70316_g() {
        super.func_70316_g();
        if (this.field_70331_k != null && !this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverUpdate(), ()V)((fmle)this));
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._j._a(qoac2);
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        this._j._b(qoac2);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        this._a = string;
        this._b = string2;
        this._c = n;
        this._d = n2;
        this._e = n3;
        this._f = n4;
        this._g = n5;
        this._h = n6;
        this._i = bl;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public eidj getRenderBoundingBox() {
        return eidj._a()._a(this._c - 1, this._d - 1, this._e - 1, this._f + 1, this._g + 50, this._h + 1);
    }

    @Override
    public int func_70302_i_() {
        return this._j.func_70302_i_();
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._j.func_70301_a(n);
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        return this._j.func_70298_a(n, n2);
    }

    @Override
    public cvzo func_70304_b(int n) {
        return this._j.func_70304_b(n);
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._j.func_70299_a(n, cvzo2);
    }

    @Override
    public String func_70303_b() {
        return this._j.func_70303_b();
    }

    @Override
    public boolean func_94042_c() {
        return this._j.func_94042_c();
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        this._j.func_70296_d();
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this._j.func_70300_a(entityPlayer);
    }

    @Override
    public void func_70295_k_() {
        this._j.func_70295_k_();
    }

    @Override
    public void func_70305_f() {
        this._j.func_70305_f();
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return this._j.func_94041_b(n, cvzo2);
    }
}

