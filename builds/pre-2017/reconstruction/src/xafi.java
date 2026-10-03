/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.ezey;
import gloomyfolken.mods.core.misc.jgro;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;

public final class xafi
implements Cloneable {
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
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
    public float _t;
    public float _u;
    public float _v;
    public float _w;
    public float _x;
    public float _y;
    public float _z;
    public float _A;
    public float _B;
    private static List<Field> _C;
    private static List<Field> _D;
    private static List<Field> _E;

    public List<String> _a() {
        ArrayList<String> arrayList = new ArrayList<String>();
        jgro._a(arrayList, "\u041f\u0443\u043b\u0435\u0441\u0442\u043e\u0439\u043a\u043e\u0441\u0442\u044c", this._a, false, true);
        jgro._a(arrayList, "\u042d\u043b\u0435\u043a\u0442\u0440\u043e\u0448\u043e\u043a", -this._b, true, true);
        jgro._a(arrayList, "\u041e\u0436\u043e\u0433", -this._c, true, true);
        jgro._a(arrayList, "\u0425\u0438\u043c. \u043e\u0436\u043e\u0433", -this._d, true, true);
        jgro._a(arrayList, "\u0420\u0430\u0437\u0440\u044b\u0432", -this._e, true, true);
        jgro._a(arrayList, "\u0412\u0437\u0440\u044b\u0432", -this._f, true, true);
        jgro._a(arrayList, "\u0420\u0430\u0434\u0438\u0430\u0446\u0438\u044f", this._h, true, false);
        jgro._a(arrayList, "\u041f\u043e\u0432\u044b\u0448\u0435\u043d\u043d\u0430\u044f \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430", this._i, true, false);
        jgro._a(arrayList, "\u0411\u0438\u043e\u043b. \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u0435", this._j, true, false);
        jgro._a(arrayList, "\u0422\u0435\u043b\u0435\u043f\u0430\u0442", this._k, true, false);
        jgro._a(arrayList, "\u041a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435", this._l, true, false);
        jgro._a(arrayList, "\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c", this._g, false, true);
        jgro._a(arrayList, "\u0420\u0435\u0433\u0435\u043d\u0435\u0440\u0430\u0446\u0438\u044f", this._r, false, true);
        jgro._a(arrayList, "\u041f\u0435\u0440\u0435\u043d\u043e\u0441\u0438\u043c\u044b\u0439 \u0432\u0435\u0441", this._s, false, false);
        jgro._a(arrayList, "\u0412\u044b\u0441\u043e\u0442\u0430 \u043f\u0440\u044b\u0436\u043a\u0430", this._t, false, false);
        jgro._a(arrayList, "\u0423\u0440\u043e\u043d \u0432 \u0441\u0435\u043a\u0443\u043d\u0434\u0443", jgro._e(this._u), true, false);
        jgro._a(arrayList, "\u041b\u0435\u0447\u0435\u043d\u0438\u0435 \u0432 \u0441\u0435\u043a\u0443\u043d\u0434\u0443", jgro._e(this._v), false, false);
        jgro._a(arrayList, "\u0412\u043e\u0441\u0441\u0442. \u0432\u044b\u043d\u043e\u0441\u043b\u0438\u0432\u043e\u0441\u0442\u0438", this._x, false, true);
        jgro._a(arrayList, "\u041c\u0430\u043a\u0441. \u0437\u0430\u043f\u0430\u0441 \u0441\u0438\u043b", this._y, false, true);
        jgro._a(arrayList, "\u041c\u0430\u043a\u0441. \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435", this._z, false, true);
        jgro._a(arrayList, "\u0420\u0430\u0437\u0431\u0440\u043e\u0441", this._A, true, true);
        jgro._a(arrayList, "\u041e\u0442\u0434\u0430\u0447\u0430", this._B, true, true);
        jgro._a(arrayList, "\u0420\u0430\u0434\u0438\u043e\u0437\u0430\u0449\u0438\u0442\u0430", this._m, false, true);
        jgro._a(arrayList, "\u0422\u0435\u0440\u043c\u043e\u0437\u0430\u0449\u0438\u0442\u0430", this._n, false, true);
        jgro._a(arrayList, "\u0411\u0438\u043e\u0437\u0430\u0449\u0438\u0442\u0430", this._o, false, true);
        jgro._a(arrayList, "\u041f\u0441\u0438-\u0437\u0430\u0449\u0438\u0442\u0430", this._p, false, true);
        jgro._a(arrayList, "\u0417\u0430\u0449\u0438\u0442\u0430 \u043e\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u044f", this._q, false, true);
        return arrayList;
    }

    public void _a(xafi xafi2) {
        this._a(xafi2, 1.0f);
    }

    public void _a(xafi xafi2, float f) {
        xafi2._a = this._a(xafi2._a, this._a, f);
        xafi2._b = this._a(xafi2._b, this._b, f);
        xafi2._c = this._a(xafi2._c, this._c, f);
        xafi2._d = this._a(xafi2._d, this._d, f);
        xafi2._e = this._a(xafi2._e, this._e, f);
        xafi2._f = this._a(xafi2._f, this._f, f);
        xafi2._h += this._h * f;
        xafi2._i += this._i * f;
        xafi2._j += this._j * f;
        xafi2._k += this._k * f;
        xafi2._l += this._l * f;
        xafi2._g += this._g * f;
        xafi2._r += this._r * f;
        xafi2._s += this._s * f;
        xafi2._t += this._t * f;
        xafi2._u += this._u * f;
        xafi2._v += this._v * f;
        xafi2._w += this._w * f;
        xafi2._x += this._x * f;
        xafi2._y += this._y * f;
        xafi2._z += this._z * f;
        xafi2._A += this._A * f;
        xafi2._B += this._B * f;
        xafi2._m = this._a(xafi2._m, this._m, f);
        xafi2._n = this._a(xafi2._n, this._n, f);
        xafi2._o = this._a(xafi2._o, this._o, f);
        xafi2._p = this._a(xafi2._p, this._p, f);
        xafi2._q = this._a(xafi2._q, this._q, f);
    }

    private float _a(float f, float f2, float f3) {
        if (f3 == 0.0f || f2 == 0.0f) {
            return f;
        }
        float f4 = f / 100.0f;
        float f5 = f2 / 100.0f;
        float f6 = 1.0f - (1.0f - f4) * (float)Math.pow(1.0f - f5, f3);
        return f6 * 100.0f;
    }

    private static float _g(float f) {
        return sajh._a(f / 100.0f, 0.0f, 1.0f);
    }

    public static float _a(float f) {
        return Math.max(0.0f, 1.0f + f / 100.0f);
    }

    public static float _b(float f) {
        return Math.max(0.0f, 1.0f - f / 100.0f);
    }

    public static float _c(float f) {
        if (f >= 0.0f) {
            return 1.0f + f / 100.0f;
        }
        float f2 = -f / 100.0f;
        return 1.0f / f2 / (1.0f + 1.0f / f2);
    }

    public static float _d(float f) {
        return xafi._c(-f);
    }

    public float _a(DamageSource damageSource) {
        ezey.kjui kjui2 = ezey._a(damageSource);
        switch (kjui2) {
            case _a: {
                return xafi._g(this._b);
            }
            case _b: {
                return xafi._g(this._c);
            }
            case _c: {
                return xafi._g(this._d);
            }
            case _d: {
                return xafi._g(this._e);
            }
            case _e: {
                return xafi._g(this._f);
            }
            case _f: {
                float f = this._a;
                if (damageSource instanceof gloomyfolken.mods.weapon.kjui) {
                    float f2 = ((gloomyfolken.mods.weapon.kjui)damageSource)._a;
                    f = f2 > 0.0f ? (f /= f2) : 100.0f;
                }
                return xafi._g(f);
            }
        }
        return 0.0f;
    }

    public xafi _e(float f) {
        xafi xafi2 = this._c();
        xafi2._f(f);
        return xafi2;
    }

    public void _f(float f) {
        if (f == 1.0f) {
            return;
        }
        if (!Float.isFinite(f)) {
            throw new IllegalArgumentException("Infinite factor");
        }
        try {
            for (int i = 0; i < _C.size(); ++i) {
                Field field = _C.get(i);
                field.setFloat(this, field.getFloat(this) * f);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _b() {
        try {
            int n;
            for (n = 0; n < _C.size(); ++n) {
                _C.get(n).setFloat(this, 0.0f);
            }
            for (n = 0; n < _D.size(); ++n) {
                _D.get(n).setInt(this, 0);
            }
            for (n = 0; n < _E.size(); ++n) {
                _E.get(n).setBoolean(this, false);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("bulletDmgFactor", this._a);
        nBTTagCompound._a("electraDmgFactor", this._b);
        nBTTagCompound._a("burnDmgFactor", this._c);
        nBTTagCompound._a("chemicalBurnDmgFactor", this._d);
        nBTTagCompound._a("tearDmgFactor", this._e);
        nBTTagCompound._a("explosionDmgFactor", this._f);
        nBTTagCompound._a("speedModifier", this._g);
        nBTTagCompound._a("radiationAccumulation", this._h);
        nBTTagCompound._a("thermalAccumulation", this._i);
        nBTTagCompound._a("biologicalAccumulation", this._j);
        nBTTagCompound._a("psychoAccumulation", this._k);
        nBTTagCompound._a("bleedingAccumulation", this._l);
        nBTTagCompound._a("radiationProtection", this._m);
        nBTTagCompound._a("thermalProtection", this._n);
        nBTTagCompound._a("biologicalProtection", this._o);
        nBTTagCompound._a("psychoProtection", this._p);
        nBTTagCompound._a("bleedingProtection", this._q);
        nBTTagCompound._a("regenerationBonus", this._r);
        nBTTagCompound._a("maxWeightBonus", this._s);
        nBTTagCompound._a("jumpIncrease", this._t);
        nBTTagCompound._a("artefaktDamage", this._u);
        nBTTagCompound._a("artefaktHeal", this._v);
        nBTTagCompound._a("fallProtection", this._w);
        nBTTagCompound._a("healthBonus", this._z);
        nBTTagCompound._a("staminaRegenerationBonus", this._x);
        nBTTagCompound._a("staminaBonus", this._y);
        nBTTagCompound._a("spreadBonus", this._A);
        nBTTagCompound._a("recoilBonus", this._B);
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        this._a = nBTTagCompound._h("bulletDmgFactor");
        this._b = nBTTagCompound._h("electraDmgFactor");
        this._c = nBTTagCompound._h("burnDmgFactor");
        this._d = nBTTagCompound._h("chemicalBurnDmgFactor");
        this._e = nBTTagCompound._h("tearDmgFactor");
        this._f = nBTTagCompound._h("explosionDmgFactor");
        this._g = nBTTagCompound._h("speedModifier");
        this._h = nBTTagCompound._h("radiationAccumulation");
        this._i = nBTTagCompound._h("thermalAccumulation");
        this._j = nBTTagCompound._h("biologicalAccumulation");
        this._k = nBTTagCompound._h("psychoAccumulation");
        this._l = nBTTagCompound._h("bleedingAccumulation");
        this._m = nBTTagCompound._h("radiationProtection");
        this._n = nBTTagCompound._h("thermalProtection");
        this._o = nBTTagCompound._h("biologicalProtection");
        this._p = nBTTagCompound._h("psychoProtection");
        this._q = nBTTagCompound._h("bleedingProtection");
        this._r = nBTTagCompound._h("regenerationBonus");
        this._s = nBTTagCompound._h("maxWeightBonus");
        this._t = nBTTagCompound._h("jumpIncrease");
        this._u = nBTTagCompound._h("artefaktDamage");
        this._v = nBTTagCompound._h("artefaktHeal");
        this._w = nBTTagCompound._h("fallProtection");
        this._z = nBTTagCompound._h("healthBonus");
        this._x = nBTTagCompound._h("staminaRegenerationBonus");
        this._y = nBTTagCompound._h("staminaBonus");
        this._A = nBTTagCompound._h("spreadBonus");
        this._B = nBTTagCompound._h("recoilBonus");
    }

    public xafi _c() {
        try {
            return (xafi)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this._c();
    }

    static {
        Field[] fieldArray;
        _C = new ArrayList<Field>();
        _D = new ArrayList<Field>();
        _E = new ArrayList<Field>();
        for (Field field : fieldArray = xafi.class.getDeclaredFields()) {
            if (field.getGenericType() == Float.TYPE) {
                _C.add(field);
                continue;
            }
            if (field.getGenericType() == Integer.TYPE) {
                _D.add(field);
                continue;
            }
            if (field.getGenericType() != Boolean.TYPE) continue;
            _E.add(field);
        }
        Collections.sort(_C, new kjui());
        Collections.sort(_D, new kjui());
        Collections.sort(_E, new kjui());
    }

    private static class kjui
    implements Comparator<Field> {
        private kjui() {
        }

        public int _a(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this._a((Field)object, (Field)object2);
        }
    }
}

