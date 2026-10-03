/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.misc.ybzs;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.eidj;
import gloomyfolken.mods.weapon.entity.EntityFlashlight;
import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
import java.util.EnumSet;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;

public class ugqx
extends tehy {
    public static final String _a = "weapon";
    public bqwg<Boolean> _b;
    public bqwg<cvzo> _c;
    public bqwg<cvzo> _d;
    private float _q;
    private float _r;
    private int _s;
    private long _t;
    private int _u;
    private cvzo _v = null;
    private int _w;
    private boolean _x;
    private int _y;
    private int _z;
    private qoac _A;
    private boolean _B;
    private boolean _C;
    private int[] _D;
    private int _E = -1;
    public cvzo _e = null;
    public eidj _f = null;
    public float _g = 1.0f;
    private float _F;
    public int _h = 0;
    public int _i = 10000;
    public int _j;
    public String _k;
    private kjui _G = kjui._c;
    private boolean _H = false;
    public boolean _l = false;
    private float _I;
    private float _J;
    public boolean _m = false;
    public long _n = 0L;
    public float _o = 0.0f;
    public int _p = 0;

    public ugqx(ccxr ccxr2) {
        super(ccxr2);
        this._b = new bqwg.kjui<Boolean>(ccxr2, "fl", false)._a()._f();
        this._c = new bqwg.kjui<Class<cvzo>>(ccxr2, "pst", cvzo.class)._a()._f();
        this._d = new bqwg.kjui<Class<cvzo>>(ccxr2, "rfl", cvzo.class)._a()._f();
    }

    @Override
    public void tick() {
        this._A();
        this._u();
        this._z();
        this._v();
        if (this.player.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(this::_c);
        } else {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((ugqx)this));
        }
    }

    private void _u() {
        if (this._t > 0L && !cvzo._b(this._v, this.player.func_71045_bC())) {
            this._t = 0L;
            this._v = null;
            InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K && this._z > 0, () -> {});
        }
    }

    private void _v() {
        if (this._o > 0.0f) {
            long l = System.currentTimeMillis() - this._n;
            if (l > 300L) {
                this._o *= htcn._a()._a;
            }
            if (l > htcn._a()._b) {
                this._o = 0.0f;
            }
            if (this._o <= 0.0f) {
                tupg._a(this.player)._c();
            }
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean _a() {
        wolf wolf2;
        dxvq dxvq2;
        return this._J == 1.0f && this._I == 1.0f && this._e != null && xpzm._E()._M.field_74320_O == 0 && (dxvq2 = (wolf2 = (wolf)this._e._a())._M(this._e)) != null && dxvq2._n;
    }

    public void _a(float f) {
        this._n = System.currentTimeMillis();
        float f2 = this._o;
        this._o = Math.min(1.0f, this._o + f);
        if (!this.player.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
            if (f2 == 0.0f && this._o > 0.0f) {
                tupg._a(this.player)._c();
            }
        }
    }

    void _b() {
        this._q = Math.max(this._q - 1.0f, 0.0f);
        ++this._s;
    }

    private void _e(float f) {
        this._q = f;
        this._r = f;
    }

    private void _f(float f) {
        this._e(f + Math.min(this._q, 1.0f));
    }

    @Override
    public void resetHandler() {
        this._q = 0.0f;
        this._v = null;
        this._m = false;
        this._D = null;
        this._E = -1;
        this._e = null;
        this._h = 0;
        this._I = 0.0f;
        this._J = 0.0f;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _c() {
        this._w();
        this._x();
        this._y();
        ++this._i;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(jxtc jxtc2, float f) {
        tgdv tgdv2;
        int n;
        if (this._f() && this._B() != null && (n = this._B()._z(this._e)) != 0 && (tgdv2 = tgdv.field_77698_e[n]) != null && tgdv2 instanceof ybzs) {
            jxtc2._a(f, (ybzs)tgdv2, 1.0f);
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _w() {
        if (this.player.func_110143_aJ() > 0.0f && !this.player.field_70128_L && this._b._b().booleanValue() && ClientProxy.dynamicLights.enabled && !this._m && this._h() != null) {
            this.player.field_70170_p.func_72838_d(new EntityFlashlight(this.player));
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _x() {
        if (this._v != null) {
            wolf wolf2 = (wolf)this._v._a();
            if (wolf2._v) {
                long l;
                long l2 = System.currentTimeMillis() - this._t;
                if (l2 > (long)wolf2._w && (l = (l2 - (long)wolf2._w) / (long)wolf2._x) >= (long)this._w && this._w < this._z) {
                    ++this._w;
                    this.player.field_70170_p.func_72980_b(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, wolf2._a(wolf2._J + "_step", (EntityLivingBase)this.player, this._v), 1.0f, this.player.field_70170_p.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                }
                if (l2 > (long)(wolf2._w + wolf2._x * this._z) && !this._x) {
                    this._x = true;
                    this.player.field_70170_p.func_72980_b(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, wolf2._a(wolf2._J + "_end", (EntityLivingBase)this.player, this._v), 1.0f, this.player.field_70170_p.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                }
            }
            if (wolf2._Y > 0 && sbzn._g.enabled && !this._C && this._c(1.0f) > (float)wolf2._Z / (float)this._u) {
                for (int i = 0; i < Math.min(wolf2._Y, this._z); ++i) {
                    wolf2._j(this.player);
                }
                this._C = true;
            }
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _y() {
        wolf wolf2 = this._B();
        this._J = this._I;
        if (wolf2 == null) {
            this._I = 0.0f;
        } else {
            float f = 50.0f / (float)wolf2._v(this._e);
            this._I = sajh._a(this._I + f * (float)(this._l() ? 1 : -1), 0.0f, 1.0f);
        }
    }

    private void _z() {
        wolf wolf2 = this._B();
        if (wolf2 != null) {
            this._F = (float)this._s <= this._r * 2.0f ? 0.0f : wolf2._o;
        }
        this._g = Math.max(1.0f, this._g - this._F);
    }

    private void _A() {
        wolf wolf2;
        ++this._j;
        if (this._E != this.player.field_71071_by._c || this._e == null != (this.player.func_71045_bC() == null) || this._e != null && this._e._a() != this.player.func_71045_bC()._a()) {
            this._j = 0;
        }
        this._E = this.player.field_71071_by._c;
        this._e = this.player.func_71045_bC();
        if (this._j == 0 && this._B() != null && (wolf2 = this._B()) != null) {
            this._a(wolf2);
        }
    }

    private wolf _B() {
        if (this._e != null && this._e._a() instanceof wolf) {
            return (wolf)this._e._a();
        }
        return null;
    }

    private void _a(wolf wolf2) {
        this._e(wolf2._w(this._e));
        if (this.player.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(() -> this._b(wolf2));
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _b(wolf wolf2) {
        if (this.player == xpzm._E()._t) {
            xpzm._E()._N._a(wolf2._a(wolf2._L, (EntityLivingBase)this.player, this._e), 1.0f, 1.0f);
            this._G = wolf2._y(this._e).contains((Object)kjui._a) ? kjui._a : kjui._c;
            this._H = false;
        }
        this._J = 0.0f;
        this._I = 0.0f;
        MinecraftForge.EVENT_BUS.post(new yund.kjui(this.player));
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(int n) {
        cvzo cvzo2;
        if (this._f != null) {
            new ogta(-1).sendToServer();
        }
        if ((cvzo2 = this.player.func_70694_bm()) == null) {
            return;
        }
        if (!(cvzo2._a() instanceof wolf)) {
            return;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        if (this._f()) {
            int n2;
            xrox xrox2 = wolf2._a(this.player.func_70694_bm(), dxwc.pidb._b, xrox.class);
            if (xrox2 != null && (n2 = ncwh._a(this.player, xrox2._i)) != 0) {
                new ogta(n2).sendToServer();
            }
        } else {
            if (n == 0) {
                nusq nusq2 = wolf._C(cvzo2);
                if (nusq2 != null) {
                    if (ncwh._a(this.player, nusq2.field_77779_bT)) {
                        n = nusq2.field_77779_bT;
                    } else if (wolf._E(cvzo2) == 0) {
                        n = this._c(wolf2);
                    }
                } else {
                    n = this._c(wolf2);
                }
            }
            if (n != 0 || wolf._A(cvzo2)) {
                new ogta(n).sendToServer();
            }
        }
    }

    private int _c(wolf wolf2) {
        return Arrays.stream(wolf2._b).filter(n -> ncwh._a(this.player, n)).findFirst().orElse(0);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _d() {
        this._b(1);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _e() {
        cvzo cvzo2 = this.player.func_71045_bC();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return;
        }
        if (this._n()) {
            return;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        xrox xrox2 = wolf2._a(cvzo2, dxwc.pidb._b, xrox.class);
        if (xrox2 != null) {
            if (this._f()) {
                if (xrox2._n != null) {
                    xpzm._E()._N._a(xrox2._n, 1.0f, 1.0f);
                }
            } else if (xrox2._o != null) {
                xpzm._E()._N._a(xrox2._o, 1.0f, 1.0f);
            }
            this._H = !this._H;
            this._a(this._H ? "\u041f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u044b\u0439 \u0433\u0440\u0430\u043d\u0430\u0442\u043e\u043c\u0435\u0442" : this._G._d);
            MinecraftForge.EVENT_BUS.post(new yund.zwat(this.player, this._H));
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean _f() {
        return this._H;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _b(int n) {
        cvzo cvzo2 = this.player.func_71045_bC();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return;
        }
        if (this._n()) {
            return;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        EnumSet<kjui> enumSet = wolf2._y(cvzo2);
        kjui kjui2 = this._G;
        this._G = (kjui)this._a(kjui.values(), kjui2, enumSet, n);
        if (kjui2 != this._G) {
            this._a(this._G._d);
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(String string) {
        this._i = 0;
        this._k = string;
    }

    private <T extends Enum> T _a(T[] TArray, T t, EnumSet enumSet, int n) {
        int n2;
        T t2 = t;
        do {
            if ((n2 = t2.ordinal() + n) >= TArray.length) {
                n2 = 0;
            }
            if (n2 >= 0) continue;
            n2 = TArray.length - 1;
        } while (!enumSet.contains(t2 = TArray[n2]) && t2 != t);
        return t2;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public kjui _g() {
        if (this._f != null) {
            return kjui._a;
        }
        return this._G;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public hank _h() {
        ofbx ofbx2 = this.player.field_70170_p.func_82732_R()._a(this.player.field_70165_t, this.player.field_70163_u + (double)this.player.func_70047_e(), this.player.field_70161_v);
        ofbx ofbx3 = this.player.func_70676_i(0.0f);
        if (this._D()) {
            ofbx3._b((float)Math.toRadians(75.0));
        }
        ofbx ofbx4 = this.player.field_70170_p.func_82732_R()._a(ofbx2._c + ofbx3._c * 50.0, ofbx2._d + ofbx3._d * 50.0, ofbx2._e + ofbx3._e * 50.0);
        return this.player.field_70170_p.func_72933_a(ofbx2, ofbx4);
    }

    public cvzo _i() {
        return this._c._b();
    }

    public cvzo _j() {
        return this._d._b();
    }

    public void _k() {
        if (this._b._b().booleanValue()) {
            this._b._a(Boolean.FALSE);
        } else if (this._C()) {
            this._b._a(Boolean.TRUE);
        }
    }

    private boolean _C() {
        if (this.player.func_110143_aJ() <= 0.0f || this.player.field_70128_L) {
            return false;
        }
        for (int i = 0; i < 5; ++i) {
            cvzo cvzo2 = this.player.func_71124_b(i);
            if (cvzo2 == null || !(cvzo2._a() instanceof tfdj) || !((tfdj)((Object)cvzo2._a()))._j(cvzo2)) continue;
            return true;
        }
        return false;
    }

    private boolean _D() {
        if (!rpdf.instance.isPlayerRunning(this.player)) {
            return false;
        }
        for (int i = 0; i < 5; ++i) {
            tfdj tfdj2;
            cvzo cvzo2 = this.player.func_71124_b(i);
            if (cvzo2 == null || !(cvzo2._a() instanceof tfdj) || !(tfdj2 = (tfdj)((Object)cvzo2._a()))._j(cvzo2) || tfdj2._b()) continue;
            return false;
        }
        return true;
    }

    public pidb _a(cvzo cvzo2) {
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return pidb._b;
        }
        if (cvzo2._f() && cvzo2._j() >= cvzo2._k()) {
            return pidb._e;
        }
        if (rpdf.instance.isPlayerRunning(this.player)) {
            return pidb._h;
        }
        if (this._n()) {
            return pidb._g;
        }
        if (this._F()) {
            return pidb._f;
        }
        return pidb._a;
    }

    public pidb _b(cvzo cvzo2) {
        pidb pidb2 = this._a(cvzo2);
        if (pidb2 == pidb._a) {
            if (!this._d(cvzo2)) {
                return pidb._c;
            }
            if (this.player.field_70170_p.field_72995_K && wolf._A(cvzo2)) {
                return pidb._d;
            }
        }
        return pidb2;
    }

    public pidb _c(cvzo cvzo2) {
        pidb pidb2 = this._a(cvzo2);
        if (pidb2 == pidb._a && !this._e(cvzo2)) {
            return pidb._c;
        }
        return pidb2;
    }

    public boolean _d(cvzo cvzo2) {
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return false;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        int n = this.player.field_70170_p.field_72995_K ? this._h : wolf._E(cvzo2);
        return n > 0 || wolf2._r(cvzo2) == 0;
    }

    public boolean _e(cvzo cvzo2) {
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return false;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        return wolf2._z(cvzo2) != 0;
    }

    public void _a(xrox xrox2) {
        this._f(xrox2._j);
        if (this.player.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(this::_E);
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _E() {
        MinecraftForge.EVENT_BUS.post(new yund.pidb(this.player));
    }

    private boolean _F() {
        return this._q > 1.0f;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean _l() {
        return this.player == xpzm._E()._t && (jzcs._a || yuni._c) && !this._n() && this.player.func_71045_bC() != null && this.player.func_71045_bC()._a() instanceof wolf && !rpdf.instance.isPlayerRunning(this.player) && rpdf.instance.getClientCrawlChangeTicks() <= 0 && this._j > ((wolf)this.player.func_71045_bC()._a())._u / 50;
    }

    public boolean _m() {
        return this._I == 1.0f || this._l;
    }

    public boolean _n() {
        return this._v != null;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(cvzo cvzo2, float f) {
        wolf wolf2 = (wolf)cvzo2._a();
        float f2 = ((wolf)cvzo2._a())._n(cvzo2);
        this._f(f2);
        --this._h;
        this._g = Math.min(wolf2._n, this._g + wolf2._m);
        MinecraftForge.EVENT_BUS.post(new yund.jgro.kjui(this.player));
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(int n, int n2, boolean bl, String string) {
        if (this.player.func_70694_bm() == null || !(this.player.func_70694_bm()._a() instanceof wolf)) {
            return;
        }
        this._B = bl;
        this._t = System.currentTimeMillis();
        this._u = n;
        this._v = this.player.func_70694_bm();
        this._z = n2;
        this._w = 0;
        this._x = false;
        this._C = false;
        MinecraftForge.EVENT_BUS.post(new yund.ezey(this.player, this._u, bl));
        boolean bl2 = this.player == xpzm._E()._t;
        EnvironmentProcessor.instance.playSoundRelatively(string, (float)this.player.field_70165_t, (float)this.player.field_70163_u + this.player.func_70047_e(), (float)this.player.field_70161_v + 0.3f, 1.0f, 1.0f, bl2, false);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _o() {
        this._B = false;
        this._t = 0L;
        this._u = 0;
        this._v = null;
        MinecraftForge.EVENT_BUS.post(new yund.eidj(this.player));
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public float _b(float f) {
        if (this._u <= 0) {
            return 0.0f;
        }
        float f2 = this._c(f);
        long l = System.currentTimeMillis() - this._t;
        if (f2 > 0.5f) {
            return sajh._a((float)((long)this._u - l) / 250.0f, 0.0f, 1.0f);
        }
        return sajh._a((float)l / 250.0f, 0.0f, 1.0f);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public float _c(float f) {
        if (this._u <= 0) {
            return 0.0f;
        }
        long l = System.currentTimeMillis() - this._t;
        float f2 = (float)l / (float)this._u;
        return sajh._a(f2, 0.0f, 1.0f);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public float _d(float f) {
        return jywc._a(this._J, this._I, f);
    }

    public float _p() {
        return this._I;
    }

    public float _q() {
        return this._q;
    }

    public wolf _r() {
        return this._v == null ? null : (wolf)this._v._a();
    }

    public boolean _s() {
        return this._b._b();
    }

    public boolean _t() {
        return this._f != null;
    }

    public static ugqx _a(EntityPlayer entityPlayer) {
        return (ugqx)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public static enum kjui {
        _a("\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0430\u044f \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u0430", "\u0410"),
        _b("\u041e\u0442\u0441\u0435\u0447\u043a\u0430 \u043e\u0447\u0435\u0440\u0435\u0434\u0438", "3"),
        _c("\u041e\u0434\u0438\u043d\u043e\u0447\u043d\u044b\u0435 \u0432\u044b\u0441\u0442\u0440\u0435\u043b\u044b", "1");

        public final String _d;
        public final String _e;

        private kjui(String string2, String string3) {
            this._d = string2;
            this._e = string3;
        }
    }

    public static enum pidb {
        _a,
        _b,
        _c,
        _d,
        _e,
        _f,
        _g,
        _h;

    }
}

