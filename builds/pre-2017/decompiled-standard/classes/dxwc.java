/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Iterables;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public abstract class dxwc
extends kjwj
implements culm,
tdmn,
oxnm {
    public final eidj _b;
    private String _h;
    private String _i;
    public Set<ezey> _c;
    public final String _d;
    public net.minecraft.util.eidj _e;
    public int _f;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private iefv _j;
    public kjui _g;

    public dxwc(int n, String string, String string2, List<String> list, eidj eidj2) {
        super(n, string, "weapons:" + string2, list, 1);
        this._b = eidj2;
        this._d = string;
    }

    public void _a(Set<ezey> set, String string, String string2, kjui kjui2, net.minecraft.util.eidj eidj2) {
        this._c = set;
        this._h = string;
        this._i = string2;
        this._g = kjui2;
        this._e = eidj2;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        this._g._a(list);
    }

    @Override
    public void _b(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        super._b(cvzo2, entityPlayer, list);
        list.add((Object)((Object)ezfc._r) + "\u041f\u043e\u0434\u0445\u043e\u0434\u0438\u0442 \u0434\u043b\u044f: ");
        Iterable<ifcv> iterable = Iterables.concat(wolf._c(), ifdp._b(), ifcv._b());
        for (yusn yusn2 : iterable) {
            if (!yusn2._a(this)) continue;
            list.add(yusn2._h().func_77628_j(null));
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _c() {
        try {
            if (this._h != null) {
                this._j = new iefv("/assets/weapons/models/attachments/", this._h, this._i);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public iefv _d() {
        return this._j;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public jxtc _e() {
        return (jxtc)this._j._d._u_();
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean _f() {
        return this._j == null || this._j._d._u_() != null;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public jywl _i() {
        jxtc jxtc2 = this._e();
        return jxtc2 == null ? null : jxtc2.getSkeleton();
    }

    public boolean _a_(pidb pidb2) {
        return true;
    }

    @Override
    public boolean isDamaged(cvzo cvzo2) {
        return this.getDamage(cvzo2) > 0;
    }

    @Override
    public int getMaxDamage(cvzo cvzo2) {
        return this.func_77612_l();
    }

    @Override
    public int getDisplayDamage(cvzo cvzo2) {
        return this.getDamage(cvzo2);
    }

    @Override
    public int getDamage(cvzo cvzo2) {
        return (int)this._h(cvzo2);
    }

    @Override
    public void setDamage(cvzo cvzo2, int n) {
        this._a(cvzo2, n);
    }

    @Override
    public int _h_(cvzo cvzo2) {
        return this._f;
    }

    public static class ezey {
        public final String _a;
        private static HashMap<String, ezey> _b = new HashMap();

        private ezey(String string) {
            this._a = string;
        }

        public static ezey _a(String string) {
            if (!_b.containsKey(string)) {
                _b.put(string, new ezey(string));
            }
            return _b.get(string);
        }
    }

    public static class dxwc$kjui {
        public final float _a;
        public final float _b;
        public final float _c;
        public final float _d;
        public final float _e;
        public final float _f;
        public final float _g;
        public final float _h;
        public final float _i;
        public final float _j;
        public final float _k;

        public dxwc$kjui(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
            this._a = f;
            this._b = f2;
            this._c = f3;
            this._d = f4;
            this._e = f5;
            this._f = f6;
            this._g = f7;
            this._h = f8;
            this._i = f9;
            this._j = f10;
            this._k = f11;
        }

        public void _a(List<String> list) {
            for (kjui kjui2 : kjui.values()) {
                jgro._a(list, kjui2._m, kjui2._b(this), !kjui2._o, true);
            }
        }

        static enum kjui {
            _a("\u0423\u0440\u043e\u043d", false, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._a;
                }
            }
            ,
            _b("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u0440\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c", false, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._b;
                }
            }
            ,
            _c("\u0414\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f", false, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._j;
                }
            }
            ,
            _d("\u041e\u0442\u0434\u0430\u0447\u0430", false, false){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._d;
                }
            }
            ,
            _e("\u0413\u043e\u0440\u0438\u0437. \u043e\u0442\u0434\u0430\u0447\u0430", false, false){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._e;
                }
            }
            ,
            _f("\u0420\u0430\u0437\u0431\u0440\u043e\u0441", false, false){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._f;
                }
            }
            ,
            _g("\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u043e\u0442 \u0431\u0435\u0434\u0440\u0430", false, false){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._g;
                }
            }
            ,
            _h("\u041f\u043e\u043a\u0430\u0447\u0438\u0432\u0430\u043d\u0438\u0435", false, false){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._c;
                }
            }
            ,
            _i("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u044f", true, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._h;
                }
            }
            ,
            _j("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0434\u043e\u0441\u0442\u0430\u0432\u0430\u043d\u0438\u044f", true, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._i;
                }
            }
            ,
            _k("\u041f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c \u043e\u0440\u0443\u0436\u0438\u044f", false, true){

                @Override
                float _a(dxwc$kjui kjui2) {
                    return kjui2._k;
                }
            };

            public final String _l = this.name() + "_FACTOR";
            public final String _m;
            public final boolean _n;
            public final boolean _o;

            private kjui(String string2, boolean bl, boolean bl2) {
                this._m = string2;
                this._n = bl;
                this._o = bl2;
            }

            abstract float _a(dxwc$kjui var1);

            float _a(float f) {
                float f2 = jgro._a(f);
                if (this._n) {
                    f2 = -f2;
                }
                return f2;
            }

            float _b(dxwc$kjui kjui2) {
                return this._a(this._a(kjui2));
            }
        }
    }

    public static enum pidb {
        _a("\u0426\u0435\u0432\u044c\u0435", EnumSet.of(eidj._a), null, 0xFFFFFF),
        _b("\u041d\u0438\u0436\u043d\u0435\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._c, eidj._d, eidj._e), _a, 0xFF0000),
        _c("\u0412\u0435\u0440\u0445\u043d\u0435\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e, eidj._g), _a, 0xFF00FF, 180.0f),
        _d("\u041f\u0440\u0430\u0432\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e), _a, 0xFFFF00, 90.0f),
        _e("\u041b\u0435\u0432\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e), _a, 0xFF8800, -90.0f),
        _f("\u0421\u0442\u0432\u043e\u043b", EnumSet.of(eidj._a), null, 0xFFFFFF),
        _g("\u041d\u0438\u0436\u043d\u0435\u0435 \u043d\u0430\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._d, eidj._e), _f, 0xFF0000),
        _h("\u0412\u0435\u0440\u0445\u043d\u0435\u0435 \u043d\u0430\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e), _f, 0xFF00FF, 180.0f),
        _i("\u041f\u0440\u0430\u0432\u043e\u0435 \u043d\u0430\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e), _f, 0xFFFF00, 90.0f),
        _j("\u041b\u0435\u0432\u043e\u0435 \u043d\u0430\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435", EnumSet.of(eidj._e), _f, 0xFF8800, -90.0f),
        _k("\u0421\u0442\u0432\u043e\u043b", EnumSet.of(eidj._f), null, 255),
        _l("\u041f\u0440\u0438\u0446\u0435\u043b", EnumSet.of(eidj._g, eidj._h), null, 65535),
        _m("\u041f\u0440\u0438\u0446\u0435\u043b \u043d\u0430 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0438", EnumSet.of(eidj._g), _l, 65535),
        _n("\u041c\u0430\u0433\u0430\u0437\u0438\u043d", EnumSet.of(eidj._i), null, 65280),
        _o("\u041f\u0440\u0438\u043a\u043b\u0430\u0434", EnumSet.of(eidj._j), null, 0x8888FF);

        public final pidb _p;
        public final EnumSet<eidj> _q;
        public final String _r = this.name().toLowerCase();
        public final String _s = "slot_" + this._r;
        public final String _t = "default_" + this._r;
        public final String _u;
        public final int _v;
        public final float _w;
        public static final pidb[] _x;
        public static final pidb[] _y;

        private pidb(String string2, EnumSet<eidj> enumSet, pidb pidb2, int n2) {
            this(string2, enumSet, pidb2, n2, 0.0f);
        }

        private pidb(String string2, EnumSet<eidj> enumSet, pidb pidb2, int n2, float f) {
            this._q = enumSet;
            this._u = string2;
            this._p = pidb2;
            this._v = n2;
            this._w = f;
        }

        public String _a(wolf wolf2) {
            if (wolf2._g.containsKey((Object)this)) {
                return wolf2._g.get((Object)this);
            }
            return this._u;
        }

        public String toString() {
            return this._s;
        }

        static {
            _x = pidb.values();
            _y = new pidb[]{_b, _c, _d, _e, _g, _h, _i, _j};
        }
    }

    public static enum eidj {
        _a,
        _b,
        _c,
        _d,
        _e,
        _f,
        _g,
        _h,
        _i,
        _j;

        public final String _k = this.name().toLowerCase();

        public List<pidb> _a() {
            ArrayList<pidb> arrayList = new ArrayList<pidb>(2);
            for (pidb pidb2 : pidb._x) {
                if (!pidb2._q.contains((Object)this)) continue;
                arrayList.add(pidb2);
            }
            return arrayList;
        }
    }
}

