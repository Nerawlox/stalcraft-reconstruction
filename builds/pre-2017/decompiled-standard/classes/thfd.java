/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraftforge.common.Configuration;

public class thfd
implements dzyj {
    public static final String _a = "[+] ";
    public static final String _b = "~ ";
    protected int _c;
    protected int _d = -1;
    protected int _e;
    protected Map<Integer, xcqb> _f;
    protected Map<Integer, List<ywts>> _g;
    protected Map<Integer, List<cfum>> _h;
    protected Set<Integer> _i;
    protected divz _j;
    protected String _k;
    protected String _l;
    protected nwuc _m;
    protected int _n;

    public void _a(int n) {
        this._n = n;
    }

    public int _a() {
        return this._n;
    }

    public String _b() {
        return this._k;
    }

    public nwuc _d() {
        return this._m;
    }

    public void _b(int n) {
        this._j._e();
        this._c = n;
        this._j._c(this);
    }

    public int _e() {
        return this._c;
    }

    protected void _a(int n, ywts ywts2) {
        List<ywts> list2 = this._g.get(n);
        if (list2 == null) {
            list2 = new ArrayList<ywts>();
        }
        list2.add(ywts2);
        this._g.put(n, list2);
    }

    protected void _a(int n, cfum cfum2) {
        List<cfum> list2 = this._h.get(n);
        if (list2 == null) {
            list2 = new ArrayList<cfum>();
        }
        list2.add(cfum2);
        this._h.put(n, list2);
    }

    public void _a(ywts ywts2) {
        this._g.get(this._e()).remove(ywts2);
        this._j._b(ywts2);
    }

    public boolean _f() {
        xpzm xpzm2 = xpzm._E();
        String string = this._g();
        if (string == null || string.isEmpty()) {
            return true;
        }
        return !xpzm2._N._c.playing("speech");
    }

    public String _g() {
        return this._l;
    }

    private void _o() {
        if (this._g() != null && !this._g().isEmpty()) {
            xpzm xpzm2 = xpzm._E();
            xavs xavs2 = xpzm2._N._e._c(this._g());
            if (xavs2 != null) {
                xpzm2._N._c.backgroundMusic("speech", xavs2._b(), xavs2._a(), false);
                xpzm2._N._c.setVolume("speech", xpzm._E()._M.field_74340_b * 0.25f);
                xpzm2._N._c.play("speech");
            }
        }
    }

    public boolean _h() {
        return this._j._d();
    }

    public List<ywts> _i() {
        return this._g.get(this._e());
    }

    public List<cfum> _j() {
        return this._h.get(this._e());
    }

    public xcqb _k() {
        return this._f.get(this._e());
    }

    public boolean _l() {
        return this._e() > this._e;
    }

    public void _m() {
        this._i.add(this._e());
        this._b(this._e() + 1);
        if (this._l()) {
            this._n();
        }
    }

    public static kjui _a(String string) {
        thfd thfd2 = new thfd();
        thfd2.getClass();
        return thfd2.new kjui(string);
    }

    @Override
    public btsm _c() {
        return this._j;
    }

    public void _n() {
        new xcpd(1, this._n, this._b()).sendToServer();
        this._j._g();
    }

    public void _a(divz divz2) {
        this._j = divz2;
        new xcpd(0, this._n, this._b()).sendToServer();
        this._j._c(this);
        this._o();
    }

    public class kjui {
        private thfd _b;

        protected kjui(String string) {
            this._b = thfd.this;
            this._b._k = string;
            this._b._i = new HashSet<Integer>();
            this._b._f = new LinkedHashMap<Integer, xcqb>();
            this._b._g = new LinkedHashMap<Integer, List<ywts>>();
            this._b._h = new LinkedHashMap<Integer, List<cfum>>();
        }

        public thfd _a() {
            return this._b;
        }

        public kjui _a(int n) {
            this._b._c = n;
            return this;
        }

        public kjui _a(mcqq mcqq2, Configuration configuration) {
            return mcqq2._a(this, configuration);
        }

        public kjui _a(mcqq mcqq2, Configuration configuration, String string) {
            return mcqq2._a(this, configuration, string);
        }

        public kjui _a(int n, xcqb xcqb2) {
            this._b._f.put(n, xcqb2);
            this._b._d = n;
            if (n > this._b._e) {
                this._b._e = n;
            }
            return this;
        }

        public kjui _a(xcqb xcqb2) {
            return this._a(this._b._d + 1, xcqb2);
        }

        public kjui _b(int n) {
            this._b._i.add(n);
            return this;
        }

        public int _b() {
            return this._b._d;
        }

        private thfj _a(xcpu xcpu2, boolean bl) {
            return (cfum2, ywts2) -> {
                if (xcpu2.taskFits(cfum2)) {
                    this._b._a(ywts2);
                    if (!this._b._h() || bl) {
                        if (this._b._e() + 1 > this._b._e) {
                            this._b._m = this._d();
                        } else {
                            this._b._m();
                        }
                    }
                }
            };
        }

        private nwuc _d() {
            return new nwuc.kjui(this._b){

                @Override
                public void _a_(lnrm.kjui kjui2) {
                    if (kjui.this._b._f()) {
                        kjui.this._b._m();
                        ((kjui)kjui.this)._b._m = null;
                    }
                }
            };
        }

        public kjui _a(cfum cfum3) {
            return this._a(cfum3, (cfum cfum2) -> true);
        }

        public kjui _a(cfum cfum2, xcpu xcpu2) {
            ywts ywts2 = cfum2._a(this._b);
            cfum2._a(this._a(xcpu2, false));
            this._b._a(this._b._d, ywts2);
            this._b._a(this._b._d, cfum2);
            return this;
        }

        public kjui _b(cfum cfum2) {
            this._b._a(this._b._d, cfum2);
            return this;
        }

        public kjui _c(cfum cfum3) {
            return this._b(cfum3, cfum2 -> true);
        }

        public kjui _b(cfum cfum2, xcpu xcpu2) {
            ywts ywts2 = cfum2._a(this._b);
            cfum2._a(this._a(xcpu2, true));
            this._b._a(this._b._d, ywts2);
            this._b._a(this._b._d, cfum2);
            return this;
        }

        public kjui _a(String string) {
            this._b._l = "stalkerguide:" + string;
            return this;
        }

        public thfd _c() {
            this._a(thfd.this._b());
            return this._b;
        }
    }
}

