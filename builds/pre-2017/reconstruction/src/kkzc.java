/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import mods.pda.client.screens.GuiPda;

public class kkzc {
    public String _a = null;
    public vjsq _b = null;
    public EnumSet<amww> _c = EnumSet.noneOf(amww.class);
    public String _d = "";
    public String _e = "";
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;
    public int _l;
    public int _m;
    public int _n;
    public int _o;
    public String _p = "";
    public ArrayList<kjui> _q = new ArrayList();
    public ArrayList<pidb> _r = new ArrayList();
    public ArrayList<eidj> _s = new ArrayList();
    public HashMap<String, owak> _t = new HashMap();

    public void _a(String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this._d = string;
        this._e = string2;
        this._f = n;
        this._l = n2;
        this._h = n3;
        this._i = n4;
        this._j = n5;
        this._m = n6;
        this._n = n7;
        this._k = n8;
        this._o = n9;
        if (GuiPda.getCurrentTab() instanceof mack) {
            GuiPda.getCurrentTab().refresh();
        }
    }

    public void _a(long l, List<ezfa> list2) {
        this._r.clear();
        for (ezfa ezfa2 : list2) {
            this._r.add(new pidb(ezfa2._a, ezfa2._a(), ezfa2._b() ? -1L : l - ezfa2._c(), ezfa2._e(), ezfa2._f(), ezfa2._g()));
        }
    }

    public void _a(HashMap<String, owak> hashMap) {
        this._t = hashMap;
    }

    public void _a(String string) {
        this._p = string;
    }

    public void _a(List<saoy.kjui> list2) {
        this._s.clear();
        this._s.ensureCapacity(list2.size());
        for (saoy.kjui kjui2 : list2) {
            this._s.add(new eidj(kjui2));
        }
    }

    public void _b(List<zfdc.kjui> list2) {
        this._q.clear();
        this._q.ensureCapacity(list2.size());
        for (zfdc.kjui kjui2 : list2) {
            this._q.add(new kjui(kjui2));
        }
    }

    public boolean _b(String string) {
        return yuch._a._a != null && yuch._a._c.contains((Object)amww._a) && yuch._a._r.stream().noneMatch(pidb2 -> pidb2._a.equals(string));
    }

    public boolean _a() {
        return !this._a.isEmpty() && this._c.contains((Object)amww._g);
    }

    public class eidj
    implements gloomyfolken.mods.core.misc.vjsq {
        public saoy.kjui _a;

        public eidj(saoy.kjui kjui2) {
            this._a = kjui2;
        }

        @Override
        public String getString() {
            return this._a._a;
        }

        @Override
        public int getColor() {
            if (this._a._c._h) {
                return 0xFF6611;
            }
            if (this._a._c == owak._d) {
                return 0x2266FF;
            }
            return 0x11AA11;
        }
    }

    public class kjui
    implements gloomyfolken.mods.core.misc.vjsq {
        public zfdc.kjui _a;

        public kjui(zfdc.kjui kjui2) {
            this._a = kjui2;
        }

        @Override
        public String getString() {
            return this._a._a;
        }

        @Override
        public int getColor() {
            if (this._a._i.isEmpty()) {
                return -5592576;
            }
            if (kkzc.this._t.containsKey(this._a._i) && kkzc.this._t.get((Object)this._a._i)._h) {
                return -5631727;
            }
            if (this._a._i.equals(kkzc.this._a)) {
                return -15619567;
            }
            return -1;
        }
    }

    public class pidb
    implements gloomyfolken.mods.core.misc.vjsq {
        public String _a;
        public vjsq _b;
        public long _c;
        public int _d;
        public int _e;
        public boolean _f;

        public pidb(String string, vjsq vjsq2, long l, int n, int n2, boolean bl) {
            this._a = string;
            this._b = vjsq2;
            this._c = l;
            this._d = n;
            this._e = n2;
            this._f = bl;
        }

        @Override
        public String getString() {
            return this._a;
        }

        @Override
        public int getColor() {
            return 0x939393;
        }
    }
}

