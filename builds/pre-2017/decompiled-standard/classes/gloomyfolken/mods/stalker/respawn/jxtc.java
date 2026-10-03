/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.tupg;
import java.lang.invoke.LambdaMetafactory;
import java.util.EnumSet;

public class jxtc
extends hurg {
    private static int _a;
    private final int _b = _a++;
    public String _k = "";
    public int _l = 30;
    public boolean _m;
    public EnumSet<tupg> _n = EnumSet.allOf(tupg.class);
    public boolean _o;
    private hrvl _c;

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void func_70316_g() {
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((jxtc)this));
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("savepoint_name", this._k);
        qoac2._a("radius", this._l);
        qoac2._a("force", this._m);
        qoac2._a("showIcon", this._o);
        qoac2._a("respawnLoc", (huhy)this._a()._a());
        byte[] byArray = new byte[this._n.size()];
        int n = 0;
        for (tupg tupg2 : this._n) {
            byArray[n++] = (byte)tupg2.ordinal();
        }
        qoac2._a("factions", byArray);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._k = qoac2._j("savepoint_name");
        this._l = qoac2._f("radius");
        this._m = qoac2._o("force");
        this._o = qoac2._o("showIcon");
        if (qoac2._c("respawnLoc")) {
            this._c = new hrvl(qoac2._m("respawnLoc"));
        }
        this._n = EnumSet.noneOf(tupg.class);
        for (byte by : qoac2._k("factions")) {
            this._n.add(tupg.values()[by]);
        }
    }

    @Override
    public void func_70308_a(ozlu ozlu2) {
        super.func_70308_a(ozlu2);
        if (!ozlu2.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public hrvl _a() {
        if (this._c == null) {
            this._c = new hrvl(new einh(this.field_70331_k, (double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5), new satm(0.0f, 0.0f));
        }
        return this._c;
    }
}

