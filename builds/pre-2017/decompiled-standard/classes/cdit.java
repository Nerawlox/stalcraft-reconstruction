/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.amxi;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.srli;
import gloomyfolken.mods.core.misc.tdmn;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public class cdit
extends kjwj
implements aofo,
amxi,
ezfa,
srli,
tdmn {
    public final xafi _b;
    private boolean _f;
    public final float _c;
    public final float _d;
    public String _e = null;
    private static final xafi _g = new xafi();

    public cdit(int n, String string, String string2, List<String> list2, int n2, xafi xafi2, boolean bl, float f, float f2, String string3) {
        super(n, string, "stalker:" + string2, list2, n2);
        this._f = bl;
        this._b = xafi2;
        this._c = f;
        this._d = f2;
        this._e = string3;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (!this._f) {
            this._c(list2, "\u041f\u043e\u0432\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: " + jgro._h(this._c) + " \u0435\u0434/\u043c\u0438\u043d");
            if (this._a(cvzo2)) {
                float f = this._e(cvzo2);
                jgro._a(list2, "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", jgro._a(f));
                list2.addAll(this._a(f)._a());
            } else {
                list2.add((Object)((Object)ezfc._o) + "\u041d\u0435 \u0438\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u043e");
            }
        }
    }

    @Override
    public cvzo _g() {
        cvzo cvzo2 = new cvzo(this);
        ncwh._b(cvzo2)._a("stats_random", 0.0f);
        return cvzo2;
    }

    @Override
    public int getEntityLifespan(cvzo cvzo2, ozlu ozlu2) {
        return 72000;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return this._a(cvzo2) ? 0xFFFFFF : 0x555555;
    }

    @Override
    public xafi _g_(cvzo cvzo2) {
        if (this._a(cvzo2)) {
            return this._a(this._e(cvzo2));
        }
        return _g;
    }

    @Override
    public int getItemStackLimit(cvzo cvzo2) {
        return this._a(cvzo2) ? 1 : super.getItemStackLimit(cvzo2);
    }

    public xafi _a(float f) {
        xafi xafi2 = this._b._c();
        xafi2._f(f);
        return xafi2;
    }

    @Override
    public float _a() {
        return this._d;
    }

    @Override
    public kjui.kjui _c(cvzo cvzo2) {
        return this._a(cvzo2) ? kjui.kjui._c : kjui.kjui._a;
    }

    @Override
    public int _a(cvzo cvzo2, int n) {
        return this._a(cvzo2) ? (int)((float)n * this._e(cvzo2)) : n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean _l_(cvzo cvzo2) {
        return anoq._a(cvzo2._a()) != null;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public gqjz _a(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        anoq anoq2 = anoq._a(cvzo2._a());
        return anoq2 == null ? null : new teuq(gqjz2, cvzo2, anoq2);
    }
}

