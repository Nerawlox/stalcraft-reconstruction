/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.core.misc.xpzm;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.entity.EntityShell;
import gloomyfolken.mods.weapon.entity.kjui;
import gloomyfolken.mods.weapon.qlgf;
import gloomyfolken.mods.weapon.ugqx;
import gloomyfolken.mods.weapon.zwat;
import gloomyfolken.mods.weapon.zwaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class wolf
extends kjwj
implements culm,
ezfa,
tdmn,
vjta,
xpzm<dxwc, dxwc.pidb>,
zwat<EntityLivingBase>,
oxnm,
tezq,
tfdj,
yusn {
    public int[] _b = new int[0];
    public int[] _c = new int[0];
    public HashMap<Integer, Integer> _d = new HashMap();
    public EnumMap<dxwc.pidb, Float> _e = new EnumMap(dxwc.pidb.class);
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _f = new EnumMap(dxwc.pidb.class);
    public EnumMap<dxwc.pidb, String> _g = new EnumMap(dxwc.pidb.class);
    private float __ao;
    private float __ap;
    private float __aq;
    private int __ar;
    public float _h;
    public float _i;
    public float _j;
    public float _k;
    public float _l;
    public float _m;
    public float _n;
    public float _o;
    public float _p;
    public float _q;
    public float _r;
    public float _s;
    private float __as;
    private float __at;
    private float __au;
    private float __av;
    private float __aw;
    public boolean _t;
    private int __ax;
    public int _u;
    public boolean _v;
    public int _w;
    public int _x;
    public int _y;
    public int _z;
    public Set<String> _A = Collections.EMPTY_SET;
    public int _B = 0;
    public String _C = "";
    public String _D = "";
    public String _E;
    public String _F;
    public String _G;
    public String _H;
    public String _I;
    public String _J;
    public String _K;
    public String _L;
    public String _M;
    public String _N;
    public boolean _O;
    public boolean _P;
    public boolean _Q;
    public float _R;
    public float _S;
    public float _T;
    public boolean _U;
    public String _V;
    public ResourceLocation _W;
    public float _X;
    public int _Y;
    public int _Z;
    public ofbx __aa = ofbx._a(0.0, 0.0, 0.0);
    public Set<String> __ab = Collections.EMPTY_SET;
    public boolean __ac;
    public boolean __ad;
    public zywl __ae;
    public xrpu __af;
    public String __ag;
    public String[] __ah;
    public klka __ai;
    public qlgf __aj;
    public float __ak = -1.0f;
    public float __al = -1.0f;
    public float __am = 0.0f;
    public int __an;
    private static List<wolf> __ay = new ArrayList<wolf>();
    private static final String __az = "upgrades";
    private static final String __aA = "id";
    private static final String __aB = "level";
    private static final String __aC = "attach";
    private final dxwf __aD = new dxwf(false, 0.0f, 1.0f, -1);

    public wolf(int n, String string, String string2, List<String> list) {
        super(n, string, "weapons:" + string2, list, 1);
        __ay.add(this);
    }

    public static List<wolf> _c() {
        return __ay;
    }

    public void _a(String string, String string2) {
        this._V = string;
        if (string != null) {
            if (string.isEmpty()) {
                this._V = null;
                this._W = null;
            } else if (GloomyCore.side.isClient() && string2 != null && !string2.isEmpty()) {
                InvokeSideOnly.client(() -> this._a(string2));
            }
        } else {
            this._W = null;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(String string) {
        this._W = new ResourceLocation("weapons", "models/sleeves/" + string);
        fmib._b(this._W);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLivingBase, cvzo cvzo2) {
        return true;
    }

    @Override
    public boolean onBlockStartBreak(cvzo cvzo2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public boolean onLeftClickEntity(cvzo cvzo2, EntityPlayer entityPlayer, Entity entity) {
        return true;
    }

    @Override
    public boolean onItemUseFirst(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public zywl func_77613_e(cvzo cvzo2) {
        return this.__ae == null ? super.func_77613_e(cvzo2) : this.__ae;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        this._c(list, "\u041f\u0430\u0442\u0440\u043e\u043d\u043e\u0432: " + wolf._E(cvzo2) + "/" + this._r(cvzo2));
        this._c(cvzo2, entityPlayer, list);
        this._c(cvzo2, list, true);
    }

    @Override
    public void _c(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        this._a(cvzo2, list);
        this._b(cvzo2, list, true);
        this._a(cvzo2, list, true);
    }

    public void _a(cvzo cvzo2, List<String> list) {
        for (String string : this._l(cvzo2)) {
            this._c(list, string);
        }
    }

    public void _a(cvzo cvzo2, List<String> list, boolean bl) {
        HashMap<stap, Integer> hashMap = wolf._K(cvzo2);
        if (bl && hashMap.size() > 0) {
            list.add("");
        }
        for (Map.Entry<stap, Integer> entry : hashMap.entrySet()) {
            this._a(list, entry.getKey()._c + " " + entry.getValue());
        }
    }

    public void _b(cvzo cvzo2, List<String> list, boolean bl) {
        EnumMap<dxwc.kjui.kjui, Float> enumMap = wolf._L(cvzo2);
        if (bl && enumMap.size() > 0) {
            list.add("");
        }
        for (Map.Entry<dxwc.kjui.kjui, Float> entry : enumMap.entrySet()) {
            dxwc.kjui.kjui kjui2 = entry.getKey();
            float f = entry.getValue().floatValue();
            String string = jgro._g(kjui2._a(f));
            list.add((Object)((Object)ezfc._j) + entry.getKey()._m + ": " + string);
        }
    }

    public void _c(cvzo cvzo2, List<String> list, boolean bl) {
        qoac qoac2 = ncwh._c(cvzo2);
        boolean bl2 = false;
        for (dxwc.eidj eidj2 : dxwc.eidj.values()) {
            cvzo cvzo3 = cvzo._a(qoac2._m(eidj2.name()));
            if (cvzo3 == null || !(cvzo3._a() instanceof dxwc)) continue;
            if (!bl2 && bl) {
                list.add("");
                bl2 = true;
            }
            this._a(list, ((dxwc)cvzo3._a())._d);
        }
    }

    public List<String> _k(cvzo cvzo2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<stap, Integer> hashMap = wolf._K(cvzo2);
        for (Map.Entry<stap, Integer> entry : hashMap.entrySet()) {
            this._a(arrayList, entry.getKey()._c + " " + entry.getValue());
        }
        return arrayList;
    }

    @Override
    public void _b(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        super._b(cvzo2, entityPlayer, list);
        this._a(list);
    }

    @Override
    public List<String> _a(cvzo cvzo2, EntityPlayer entityPlayer) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(String.join((CharSequence)" ", this._b_));
        this._a((List<String>)arrayList);
        return arrayList;
    }

    public void _a(List<String> list) {
        list.add((Object)((Object)ezfc._r) + "\u041f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0435 \u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u044b:");
        for (int n : this._b) {
            tgdv tgdv2 = tgdv.field_77698_e[n];
            if (!(tgdv2 instanceof nusq)) continue;
            list.add(tgdv2.func_77628_j(null));
        }
    }

    public List<String> _l(cvzo cvzo2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("\u0423\u0440\u043e\u043d: " + jgro._f(this._R(cvzo2)) + " \u0435\u0434.");
        arrayList.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u0440\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c: " + jgro._h(this._m(cvzo2)) + " \u0432\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432/\u043c\u0438\u043d.");
        arrayList.add("\u041f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430: " + jgro._a(this._a(cvzo2, this._r(cvzo2))));
        arrayList.add("\u0414\u043e\u0441\u0442\u0430\u0432\u0430\u043d\u0438\u0435: " + jgro._a(this._x(cvzo2)));
        arrayList.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u044f: " + jgro._a(this._v(cvzo2)));
        arrayList.add("\u0420\u0430\u0437\u0431\u0440\u043e\u0441: " + jgro._h(this._a(cvzo2, true)) + "\u00b0");
        arrayList.add("\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u043e\u0442 \u0431\u0435\u0434\u0440\u0430: " + jgro._h(this._a(cvzo2, false)) + "\u00b0");
        arrayList.add("\u041e\u0442\u0434\u0430\u0447\u0430: " + jgro._h(this._o(cvzo2)) + "\u00b0");
        arrayList.add("\u0413\u043e\u0440\u0438\u0437. \u043e\u0442\u0434\u0430\u0447\u0430: " + jgro._h(this._p(cvzo2)) + "\u00b0");
        arrayList.add("\u042d\u0444\u0444\u0435\u043a\u0442\u0438\u0432\u043d\u0430\u044f \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f: " + jgro._h(this._u(cvzo2)) + " \u043c.");
        arrayList.add("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u0430\u044f \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f: " + jgro._h(this._t(cvzo2)) + " \u043c.");
        arrayList.add("\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u0432\u0430\u043d\u0438\u0435: " + jgro._j(this._B(cvzo2)));
        return arrayList;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean func_77662_d() {
        return true;
    }

    @Override
    public boolean _j(cvzo cvzo2) {
        boolean bl = false;
        for (dxwc.pidb pidb2 : dxwc.pidb._y) {
            htce htce2 = this._a(cvzo2, pidb2, htce.class);
            if (htce2 == null || !htce2._h) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean _b() {
        return false;
    }

    public void _a(float f) {
        this._h = f;
    }

    public void _b(float f) {
        this._i = f;
    }

    public void _c(float f) {
        this.__as = f;
    }

    public void _a(int n) {
        this.__ar = n;
    }

    public void _d(float f) {
        this.__ao = f;
    }

    public float _m(cvzo cvzo2) {
        float f = this.__ao;
        return f *= this._a(cvzo2, dxwc.kjui.kjui._b);
    }

    public float _n(cvzo cvzo2) {
        return 1200.0f / this._m(cvzo2);
    }

    public void _b(int n) {
        this.__ax = n * 50;
    }

    public void _e(float f) {
        this.__av = f;
    }

    public void _a(float f, float f2) {
        this.__at = f;
        this.__au = f2;
    }

    public void _b(float f, float f2) {
        this.__ap = f;
        this.__aq = f2;
    }

    public void _a(int n, int n2, int n3) {
        this._v = true;
        this._w = n * 50;
        this._x = n2 * 50;
        this._y = n3 * 50;
    }

    public void _f(float f) {
        this.__aw = f;
    }

    public float _o(cvzo cvzo2) {
        float f = this._h;
        f *= this._a(cvzo2, dxwc.kjui.kjui._d);
        return f /= jgro._b(wolf._a(cvzo2, stap.kjui._e));
    }

    public float _p(cvzo cvzo2) {
        float f = this._i;
        f *= this._a(cvzo2, dxwc.kjui.kjui._e);
        return f /= jgro._b(wolf._a(cvzo2, stap.kjui._e));
    }

    public float _a(cvzo cvzo2, boolean bl) {
        float f = this._j;
        nusq nusq2 = wolf._C(cvzo2);
        if (nusq2 != null) {
            f *= nusq2._i;
        }
        if (!bl) {
            f += Math.max(this._l, this._k * this._a(cvzo2, dxwc.kjui.kjui._g));
        }
        f *= this._a(cvzo2, dxwc.kjui.kjui._f);
        return f /= jgro._b(wolf._a(cvzo2, stap.kjui._c));
    }

    public float _q(cvzo cvzo2) {
        float f = this.__as;
        f *= this._a(cvzo2, dxwc.kjui.kjui._h);
        return f /= jgro._b(wolf._a(cvzo2, stap.kjui._e));
    }

    public int _r(cvzo cvzo2) {
        pjxf pjxf2 = this._a(cvzo2, dxwc.pidb._n, pjxf.class);
        return pjxf2 == null ? this.__ar : pjxf2._h;
    }

    public float _s(cvzo cvzo2) {
        float f = 1.0f;
        f *= this._a(cvzo2, dxwc.kjui.kjui._c);
        return f *= jgro._b(wolf._a(cvzo2, stap.kjui._b));
    }

    public float _b(cvzo cvzo2, float f) {
        float f2 = this._s(cvzo2);
        float f3 = this.__at * f2;
        float f4 = this.__au * f2;
        float f5 = wolf._b(f3, f4, f);
        float f6 = this.__ap - this.__aq;
        float f7 = this.__ap - f6 * f5;
        return f7 / this.__ap;
    }

    public float _t(cvzo cvzo2) {
        return this.__av * this._s(cvzo2);
    }

    public float _u(cvzo cvzo2) {
        return (this.__at + this.__au) / 2.0f * this._s(cvzo2);
    }

    public int _a(cvzo cvzo2, int n) {
        return this._v ? this._w + this._x * n + this._y : this.__ax;
    }

    public int _v(cvzo cvzo2) {
        return (int)((float)this._z * this._a(cvzo2, dxwc.kjui.kjui._i));
    }

    public float _w(cvzo cvzo2) {
        return (int)((float)this._u * this._a(cvzo2, dxwc.kjui.kjui._j));
    }

    public int _x(cvzo cvzo2) {
        return (int)(this._w(cvzo2) * 50.0f);
    }

    public boolean _c(int n) {
        for (int n2 : this._b) {
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    public EnumSet<ugqx.kjui> _y(cvzo cvzo2) {
        EnumSet<ugqx.kjui> enumSet = EnumSet.of(ugqx.kjui._c);
        if (this._P) {
            enumSet.add(ugqx.kjui._a);
        }
        if (this._Q) {
            enumSet.add(ugqx.kjui._b);
        }
        return enumSet;
    }

    public int _z(cvzo cvzo2) {
        cvzo cvzo3 = this._c(cvzo2, dxwc.pidb._b);
        if (cvzo3 == null || !(cvzo3._a() instanceof xrox)) {
            return 0;
        }
        return ncwh._c(cvzo3)._f("grenade");
    }

    public void _b(cvzo cvzo2, int n) {
        cvzo cvzo3 = this._c(cvzo2, dxwc.pidb._b);
        if (cvzo3 == null || !(cvzo3._a() instanceof xrox)) {
            return;
        }
        ncwh._b(cvzo3)._a("grenade", n);
        this._a(cvzo2, cvzo3, dxwc.pidb._b);
    }

    public static boolean _A(cvzo cvzo2) {
        return ncwh._c(cvzo2)._o("jamming");
    }

    public static void _b(cvzo cvzo2, boolean bl) {
        ncwh._b(cvzo2)._a("jamming", bl);
    }

    public float _B(cvzo cvzo2) {
        pjxf pjxf2;
        nusq nusq2;
        float f = this.__aw;
        if (cvzo2._k() > 0) {
            f *= 1.0f + (float)cvzo2._j() / (float)cvzo2._k();
        }
        if ((nusq2 = wolf._C(cvzo2)) != null) {
            f += nusq2._g;
        }
        if ((pjxf2 = this._a(cvzo2, dxwc.pidb._n, pjxf.class)) != null) {
            f += pjxf2._i;
        }
        return f;
    }

    public static nusq _C(cvzo cvzo2) {
        int n = wolf._F(cvzo2);
        if (n <= 0 || n >= 32000) {
            return null;
        }
        if (!(tgdv.field_77698_e[n] instanceof nusq)) {
            return null;
        }
        return (nusq)tgdv.field_77698_e[n];
    }

    public static void _a(cvzo cvzo2, int n, int n2, qoac qoac2) {
        qoac qoac3 = ncwh._b(cvzo2);
        qoac3._a("bulletId", n);
        qoac3._a("numBullets", n2);
        if (qoac2 == null) {
            qoac3._p("bulletTag");
        } else {
            qoac3._a("bulletTag", (huhy)qoac2);
        }
    }

    public static void _D(cvzo cvzo2) {
        wolf._a(cvzo2, wolf._F(cvzo2), 0, null);
    }

    public static int _E(cvzo cvzo2) {
        return ncwh._c(cvzo2)._f("numBullets");
    }

    public static int _F(cvzo cvzo2) {
        return ncwh._c(cvzo2)._f("bulletId");
    }

    public static qoac _G(cvzo cvzo2) {
        wolf._I(cvzo2);
        qoac qoac2 = ncwh._c(cvzo2);
        return qoac2._c("bulletTag") ? qoac2._m("bulletTag") : null;
    }

    public static cvzo _H(cvzo cvzo2) {
        if (!wolf._I(cvzo2)) {
            return null;
        }
        cvzo cvzo3 = new cvzo(wolf._F(cvzo2), wolf._E(cvzo2), 0);
        cvzo3._e = wolf._G(cvzo2);
        return cvzo3;
    }

    public static boolean _I(cvzo cvzo2) {
        nusq nusq2 = wolf._C(cvzo2);
        int n = wolf._E(cvzo2);
        if (ncwh._c(cvzo2)._f("bulletId") != 0 && (nusq2 == null || n == 0)) {
            wolf._D(cvzo2);
        }
        return nusq2 != null && n > 0;
    }

    public static void _J(cvzo cvzo2) {
        int n = wolf._E(cvzo2);
        if (--n <= 0) {
            wolf._D(cvzo2);
        } else {
            ncwh._b(cvzo2)._a("numBullets", n);
        }
    }

    public static HashMap<stap, Integer> _K(cvzo cvzo2) {
        HashMap<stap, Integer> hashMap = new HashMap<stap, Integer>();
        qoac qoac2 = ncwh._c(cvzo2);
        qoac qoac3 = qoac2._m(__az);
        for (stap.kjui kjui2 : stap.kjui.values()) {
            if (!qoac3._c(kjui2.name())) continue;
            qoac qoac4 = qoac3._m(kjui2.name());
            int n = qoac4._f(__aA);
            int n2 = qoac4._f(__aB);
            if (n <= 0 || n >= 32000 || !(tgdv.field_77698_e[n] instanceof stap)) continue;
            stap stap2 = (stap)tgdv.field_77698_e[n];
            hashMap.put(stap2, n2);
        }
        return hashMap;
    }

    public static EnumMap<dxwc.kjui.kjui, Float> _L(cvzo cvzo2) {
        EnumMap<dxwc.kjui.kjui, Float> enumMap = new EnumMap<dxwc.kjui.kjui, Float>(dxwc.kjui.kjui.class);
        for (dxwc.kjui.kjui kjui2 : dxwc.kjui.kjui.values()) {
            if (cvzo2._e == null || !cvzo2._e._c(kjui2._l)) continue;
            enumMap.put(kjui2, Float.valueOf(cvzo2._e._h(kjui2._l)));
        }
        return enumMap;
    }

    public static float _a(cvzo cvzo2, stap.kjui kjui2) {
        qoac qoac2 = ncwh._c(cvzo2)._m(__az);
        qoac qoac3 = qoac2._m(kjui2.name());
        int n = qoac3._f(__aA);
        if (n > 0 && n < 32000 && tgdv.field_77698_e[n] instanceof stap) {
            return (float)qoac3._f(__aB) * ((stap)tgdv.field_77698_e[n])._e;
        }
        return 0.0f;
    }

    public static int _a(cvzo cvzo2, stap stap2) {
        qoac qoac2 = ncwh._c(cvzo2)._m(__az);
        qoac qoac3 = qoac2._m(stap2._b.name());
        if (qoac3._f(__aA) == stap2.field_77779_bT) {
            return qoac3._f(__aB);
        }
        return 0;
    }

    public static stap _b(cvzo cvzo2, stap.kjui kjui2) {
        qoac qoac2 = ncwh._c(cvzo2)._m(__az);
        qoac qoac3 = qoac2._m(kjui2.name());
        int n = qoac3._f(__aA);
        if (n > 0 && n < 32000 && tgdv.field_77698_e[n] instanceof stap) {
            return (stap)tgdv.field_77698_e[n];
        }
        return null;
    }

    public static void _a(cvzo cvzo2, stap stap2, int n) {
        qoac qoac2 = ncwh._b(cvzo2);
        if (!qoac2._c(__az)) {
            qoac2._a(__az, (huhy)new qoac());
        }
        qoac qoac3 = qoac2._m(__az);
        if (n > 0) {
            qoac qoac4 = new qoac();
            qoac4._a(__aA, stap2.field_77779_bT);
            qoac4._a(__aB, n);
            qoac3._a(stap2._b.name(), qoac4);
        } else {
            qoac3._p(stap2._b.name());
        }
    }

    public boolean _a(cvzo cvzo2, dxwc.pidb pidb2) {
        return this._c(cvzo2, pidb2)._a(pidb2) != null;
    }

    public boolean _a(cvzo cvzo2, dxwc dxwc2, dxwc.pidb pidb2) {
        if (cvzo2 == null || dxwc2 == null) {
            return false;
        }
        return this._c(cvzo2, pidb2)._a(dxwc2, pidb2);
    }

    public dxwc _b(cvzo cvzo2, dxwc.pidb pidb2) {
        dxwc dxwc2;
        if (pidb2._p != null && (dxwc2 = (dxwc)this._d(cvzo2, pidb2._p)) instanceof yusn) {
            return dxwc2;
        }
        return null;
    }

    private yusn _c(cvzo cvzo2, dxwc.pidb pidb2) {
        dxwc dxwc2;
        yusn yusn2 = this;
        if (pidb2._p != null && (dxwc2 = (dxwc)this._d(cvzo2, pidb2._p)) instanceof yusn) {
            yusn2 = (yusn)((Object)dxwc2);
        }
        return yusn2;
    }

    public <T extends dxwc> T _a(cvzo cvzo2, dxwc.pidb pidb2, Class<T> clazz) {
        dxwc dxwc2 = (dxwc)this._d(cvzo2, pidb2);
        if (dxwc2 != null && clazz.isAssignableFrom(dxwc2.getClass())) {
            return (T)dxwc2;
        }
        return null;
    }

    public <T extends dxwc> cvzo _b(cvzo cvzo2, dxwc.pidb pidb2, Class<T> clazz) {
        cvzo cvzo3 = this._c(cvzo2, pidb2);
        if (cvzo3 != null && clazz.isAssignableFrom(cvzo3._a().getClass())) {
            return cvzo3;
        }
        return null;
    }

    public cvzo _a(cvzo cvzo2, dxwc.eidj eidj2) {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            cvzo cvzo3;
            if (!pidb2._q.contains((Object)eidj2) || (cvzo3 = this._c(cvzo2, pidb2)) == null) continue;
            return cvzo3;
        }
        return null;
    }

    public <T extends dxwc> T _a(cvzo cvzo2, dxwc.eidj eidj2, Class<T> clazz) {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            dxwc dxwc2;
            if (!pidb2._q.contains((Object)eidj2) || (dxwc2 = (dxwc)this._d(cvzo2, pidb2)) == null || !clazz.isAssignableFrom(dxwc2.getClass())) continue;
            return (T)dxwc2;
        }
        return null;
    }

    public boolean _b(cvzo cvzo2, dxwc.eidj eidj2) {
        return this._a(cvzo2, eidj2) != null;
    }

    public dxvq _M(cvzo cvzo2) {
        dxwc.pidb pidb2 = this._O(cvzo2);
        return pidb2 == null ? null : this._a(cvzo2, pidb2, dxvq.class);
    }

    public cvzo _N(cvzo cvzo2) {
        dxwc.pidb pidb2 = this._O(cvzo2);
        return pidb2 == null ? null : this._b(cvzo2, pidb2, dxvq.class);
    }

    public dxwc.pidb _O(cvzo cvzo2) {
        dxwc dxwc2 = (dxwc)this._d(cvzo2, dxwc.pidb._l);
        if (dxwc2 instanceof dxvq) {
            return dxwc.pidb._l;
        }
        if (dxwc2 instanceof ifcv && this._a(cvzo2, dxwc.pidb._m, dxvq.class) != null) {
            return dxwc.pidb._m;
        }
        dxwc dxwc3 = (dxwc)this._d(cvzo2, dxwc.pidb._c);
        if (dxwc3 instanceof dxvq) {
            return dxwc.pidb._c;
        }
        return null;
    }

    public float _a(cvzo cvzo2, dxwc.kjui.kjui kjui2) {
        float f = 1.0f;
        if (cvzo2._e != null && cvzo2._e._c(kjui2._l)) {
            f *= cvzo2._e._h(kjui2._l);
        }
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            dxwc dxwc2 = (dxwc)this._d(cvzo2, pidb2);
            if (dxwc2 == null) continue;
            f *= kjui2._a(dxwc2._g);
        }
        return f;
    }

    private cvzo _m(EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = entityLivingBase.func_70694_bm();
        if (cvzo2 == null || cvzo2._d != this.field_77779_bT) {
            throw new zwaw(this, cvzo2);
        }
        return cvzo2;
    }

    public float _a(EntityLivingBase entityLivingBase) {
        return this._t(this._m(entityLivingBase));
    }

    public int _b(EntityLivingBase entityLivingBase) {
        return this._P(this._m(entityLivingBase));
    }

    public int _P(cvzo cvzo2) {
        nusq nusq2 = wolf._C(cvzo2);
        if (nusq2 != null) {
            return nusq2._l;
        }
        return 1;
    }

    public float _a(EntityLivingBase entityLivingBase, float f) {
        cvzo cvzo2 = this._m(entityLivingBase);
        float f2 = entityLivingBase instanceof kjui ? ((kjui)((Object)entityLivingBase)).getDamage() : this._Q(cvzo2);
        return this._a(cvzo2, f2, f);
    }

    public float _a(cvzo cvzo2, float f, float f2) {
        return f * this._b(cvzo2, f2);
    }

    public float _Q(cvzo cvzo2) {
        float f = this.__ap;
        f *= this._a(cvzo2, dxwc.kjui.kjui._a);
        f *= jgro._b(wolf._a(cvzo2, stap.kjui._a));
        nusq nusq2 = wolf._C(cvzo2);
        if (nusq2 != null) {
            f *= nusq2._d;
        }
        return f;
    }

    public float _R(cvzo cvzo2) {
        return this._Q(cvzo2) * (float)this._P(cvzo2);
    }

    private static float _b(float f, float f2, float f3) {
        return sajh._a((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    public float _c(EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = this._m(entityLivingBase);
        ugqx ugqx2 = entityLivingBase instanceof EntityPlayer ? ugqx._a((EntityPlayer)entityLivingBase) : null;
        boolean bl = true;
        if (ugqx2 != null) {
            bl = ugqx2._m();
        }
        float f = this._a(cvzo2, bl);
        if (ugqx2 != null) {
            f *= ugqx2._g;
            tupg tupg2 = tupg._a((EntityPlayer)entityLivingBase);
            float f2 = xafi._a(tupg2._d._A);
            f *= f2;
            if (entityLivingBase.field_70131_O < 1.0f) {
                f *= this._r;
            } else if (entityLivingBase.func_70093_af()) {
                f *= this._q;
            }
            float f3 = (float)Math.sqrt(entityLivingBase.field_70159_w * entityLivingBase.field_70159_w + entityLivingBase.field_70179_y * entityLivingBase.field_70179_y);
            float f4 = wolf._b(0.0f, 0.1f, f3);
            f *= jywc._a(1.0f, this._p, f4);
        }
        return f;
    }

    public float _S(cvzo cvzo2) {
        dxvq dxvq2 = this._M(cvzo2);
        return dxvq2 == null ? this._R : dxvq2._i;
    }

    public float _d(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 1.0f : nusq2._e;
    }

    public float _e(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 0.0f : nusq2._f;
    }

    public float _f(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 0.0f : nusq2._h;
    }

    @ezey(_a={eidj.CLIENT})
    public String _g(EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = this._m(entityLivingBase);
        return this._a(this._l(entityLivingBase) ? this._K : this._I, entityLivingBase, cvzo2);
    }

    public boolean _h(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayer) {
            cvzo cvzo2 = this._m(entityLivingBase);
            ugqx ugqx2 = ugqx._a((EntityPlayer)entityLivingBase);
            ugqx.pidb pidb2 = ugqx2._b(cvzo2);
            if (pidb2 != ugqx.pidb._a) {
                Logger.warning("Player " + ((EntityPlayer)entityLivingBase).field_71092_bJ + " made impossible shot: " + (Object)((Object)pidb2), new Object[0]);
                return false;
            }
        }
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public void _i(EntityLivingBase entityLivingBase) {
        if (this._Y < 1) {
            this._j(entityLivingBase);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _j(EntityLivingBase entityLivingBase) {
        entityLivingBase.field_70170_p.func_72838_d(new EntityShell(entityLivingBase.field_70170_p, entityLivingBase, this));
    }

    @ezey(_a={eidj.CLIENT})
    public void _k(EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = this._m(entityLivingBase);
        boolean bl = entityLivingBase == net.minecraft.client.xpzm._E()._u && net.minecraft.client.xpzm._E()._M.field_74320_O == 0;
        dxwf dxwf2 = this._U(cvzo2);
        sbzn._a._a(entityLivingBase, dxwf2._a(this), this.__af._p + dxwf2._b, this.__af._o * dxwf2._c, bl);
        if (entityLivingBase == net.minecraft.client.xpzm._E()._t) {
            Random random = entityLivingBase.func_70681_au();
            tupg tupg2 = tupg._a((EntityPlayer)entityLivingBase);
            float f = xafi._a(tupg2._d._B);
            jzcs._c = this._p(cvzo2) * f * (random.nextFloat() * 2.0f - 1.0f);
            jzcs._b = this._o(cvzo2) * f * (0.8f + random.nextFloat() * 0.2f);
        }
    }

    public int _T(cvzo cvzo2) {
        dxwf dxwf2 = this._U(cvzo2);
        if (dxwf2._d < 0) {
            return this.__af._n;
        }
        return dxwf2._d;
    }

    public dxwf _U(cvzo cvzo2) {
        maoa maoa2 = this._a(cvzo2, dxwc.pidb._k, maoa.class);
        if (maoa2 != null) {
            return maoa2._h;
        }
        jzia jzia2 = this._a(cvzo2, dxwc.pidb._b, jzia.class);
        if (jzia2 != null) {
            return jzia2._h;
        }
        return this.__aD;
    }

    @Override
    public int getDamage(cvzo cvzo2) {
        return (int)this._h(cvzo2);
    }

    @Override
    public int getMaxDamage(cvzo cvzo2) {
        if (cvzo2._e != null && cvzo2._e._o("unbreakable")) {
            return 0;
        }
        float f = this.func_77612_l();
        f *= jgro._b(wolf._a(cvzo2, stap.kjui._d));
        f *= this._a(cvzo2, dxwc.kjui.kjui._k);
        return (int)(f *= this._e_(cvzo2));
    }

    @Override
    public void setDamage(cvzo cvzo2, int n) {
        this._a(cvzo2, (double)n);
    }

    @Override
    public int getDisplayDamage(cvzo cvzo2) {
        return this.getDamage(cvzo2);
    }

    @Override
    public boolean isDamaged(cvzo cvzo2) {
        return this.getDamage(cvzo2) > 0;
    }

    public String _a(String string, cvzo cvzo2) {
        return this._a(string, wolf._E(cvzo2));
    }

    @ezey(_a={eidj.CLIENT})
    public String _a(String string, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        EntityClientPlayerMP entityClientPlayerMP = net.minecraft.client.xpzm._E()._t;
        if (entityClientPlayerMP == entityLivingBase) {
            return this._a(string, ugqx._a((EntityPlayer)entityClientPlayerMP)._h);
        }
        return this._a(string, cvzo2);
    }

    public boolean _l(EntityLivingBase entityLivingBase) {
        return this._t || this._U((cvzo)this._m((EntityLivingBase)entityLivingBase))._a;
    }

    public String _a(String string, int n) {
        String string2 = string + "_" + n + "_";
        if (this._A.contains(string2)) {
            return string2;
        }
        return string;
    }

    @Override
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _w_() {
        return this._f;
    }

    public dxwc _c(tgdv tgdv2) {
        return (dxwc)tgdv2;
    }

    @Override
    public float _x_() {
        return this.__ak;
    }

    @Override
    public float _y_() {
        return this.__al;
    }

    @Override
    public int _h_(cvzo cvzo2) {
        return this._B;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return n < 0 ? new jibd(gqjz2, cvzo2) : new sbzo(gqjz2, entityPlayer, n);
    }

    @Override
    public float _i() {
        return this.__am;
    }

    public float _a(EntityPlayer entityPlayer) {
        return this._s;
    }

    @Override
    public /* synthetic */ boolean _a(Entity entity) {
        return this._l((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void onShootClient(Entity entity) {
        this._k((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void spawnShell(Entity entity) {
        this._i((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ boolean canShoot(Entity entity) {
        return this._h((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ String getShootSoundName(Entity entity) {
        return this._g((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getBleedingProbability(Entity entity) {
        return this._f((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getIncendiaryProbability(Entity entity) {
        return this._e((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getPiercingFactor(Entity entity) {
        return this._d((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getSpread(Entity entity) {
        return this._c((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getDamage(Entity entity, float f) {
        return this._a((EntityLivingBase)entity, f);
    }

    @Override
    public /* synthetic */ int getNumBullets(Entity entity) {
        return this._b((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getMaxDistance(Entity entity) {
        return this._a((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ gqjz _a(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return this._b(gqjz2, entityPlayer, cvzo2, n);
    }

    @Override
    public /* synthetic */ tgdv _b(tgdv tgdv2) {
        return this._c(tgdv2);
    }

    @Override
    public /* synthetic */ boolean _b(cvzo cvzo2, tgdv tgdv2, Object object) {
        return this._a(cvzo2, (dxwc)tgdv2, (dxwc.pidb)((Object)object));
    }
}

