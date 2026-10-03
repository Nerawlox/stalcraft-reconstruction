/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.lwjgl.input.Keyboard;

public class tfkf
extends gqjz {
    public static xsbj _a = new xsbj();
    public static final List _b = new ArrayList();
    public final stik _c;
    public String _d;
    public String _e;
    public String _f;
    public mavq _g;
    public jiok _h;
    public ifms _i;

    public tfkf(stik stik2) {
        this._c = stik2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        this._d = wpcz._a("createWorld.customize.presets.title");
        this._e = wpcz._a("createWorld.customize.presets.share");
        this._f = wpcz._a("createWorld.customize.presets.list");
        this._i = new ifms(this.field_73886_k, 50, 40, this.field_73880_f - 100, 20);
        this._g = new mavq(this);
        this._i.func_73804_f(1230);
        this._i.func_73782_a(this._c._a());
        this._h = new jiok(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, wpcz._a("createWorld.customize.presets.select"));
        this.field_73887_h.add(this._h);
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, wpcz._a("gui.cancel")));
        this._a();
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        this._i.func_73793_a(n, n2, n3);
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (!this._i.func_73802_a(c, n)) {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0 && this._b()) {
            this._c._a(this._i.func_73781_b());
            this.field_73882_e._a(this._c);
        } else if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(this._c);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._g.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._d, this.field_73880_f / 2, 8, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, this._e, 50, 30, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, this._f, 50, 70, 0xA0A0A0);
        this._i.func_73795_f();
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void func_73876_c() {
        this._i.func_73780_a();
        super.func_73876_c();
    }

    public void _a() {
        boolean bl;
        this._h.field_73742_g = bl = this._b();
    }

    public boolean _b() {
        return this._g._a > -1 && this._g._a < _b.size() || this._i.func_73781_b().length() > 1;
    }

    public static void _a(String string, int n, foqh foqh2, suyo ... suyoArray) {
        tfkf._a(string, n, foqh2, null, suyoArray);
    }

    public static void _a(String string, int n, foqh foqh2, List list2, suyo ... suyoArray) {
        elpk elpk2 = new elpk();
        for (int i = suyoArray.length - 1; i >= 0; --i) {
            elpk2._c().add(suyoArray[i]);
        }
        elpk2._a(foqh2._P);
        elpk2._d();
        if (list2 != null) {
            for (String string2 : list2) {
                elpk2._b().put(string2, new HashMap());
            }
        }
        _b.add(new htjk(n, string, elpk2.toString()));
    }

    public static /* synthetic */ xsbj _c() {
        return _a;
    }

    public static /* synthetic */ List _d() {
        return _b;
    }

    public static /* synthetic */ mavq _a(tfkf tfkf2) {
        return tfkf2._g;
    }

    public static /* synthetic */ ifms _b(tfkf tfkf2) {
        return tfkf2._i;
    }

    static {
        tfkf._a("Classic Flat", twgu.field_71980_u.field_71990_ca, foqh._c, Arrays.asList("village"), new suyo(1, twgu.field_71980_u.field_71990_ca), new suyo(2, twgu.field_71979_v.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Tunnelers' Dream", twgu.field_71981_t.field_71990_ca, foqh._e, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new suyo(1, twgu.field_71980_u.field_71990_ca), new suyo(5, twgu.field_71979_v.field_71990_ca), new suyo(230, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Water World", twgu.field_71942_A.field_71990_ca, foqh._c, Arrays.asList("village", "biome_1"), new suyo(90, twgu.field_71943_B.field_71990_ca), new suyo(5, twgu.field_71939_E.field_71990_ca), new suyo(5, twgu.field_71979_v.field_71990_ca), new suyo(5, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Overworld", twgu.field_71962_X.field_71990_ca, foqh._c, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new suyo(1, twgu.field_71980_u.field_71990_ca), new suyo(3, twgu.field_71979_v.field_71990_ca), new suyo(59, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Snowy Kingdom", twgu.field_72037_aS.field_71990_ca, foqh._n, Arrays.asList("village", "biome_1"), new suyo(1, twgu.field_72037_aS.field_71990_ca), new suyo(1, twgu.field_71980_u.field_71990_ca), new suyo(3, twgu.field_71979_v.field_71990_ca), new suyo(59, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Bottomless Pit", tgdv.field_77676_L.field_77779_bT, foqh._c, Arrays.asList("village", "biome_1"), new suyo(1, twgu.field_71980_u.field_71990_ca), new suyo(3, twgu.field_71979_v.field_71990_ca), new suyo(2, twgu.field_71978_w.field_71990_ca));
        tfkf._a("Desert", twgu.field_71939_E.field_71990_ca, foqh._d, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new suyo(8, twgu.field_71939_E.field_71990_ca), new suyo(52, twgu.field_71957_Q.field_71990_ca), new suyo(3, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
        tfkf._a("Redstone Ready", tgdv.field_77767_aC.field_77779_bT, foqh._d, new suyo(52, twgu.field_71957_Q.field_71990_ca), new suyo(3, twgu.field_71981_t.field_71990_ca), new suyo(1, twgu.field_71986_z.field_71990_ca));
    }
}

