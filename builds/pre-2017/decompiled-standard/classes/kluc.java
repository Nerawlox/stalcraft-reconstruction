/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.xpzm;

public class kluc
extends gqjz {
    public final int _a = 666;
    public final gqjz _b;
    public final Thread _c;
    public volatile String _d = "";
    public volatile boolean _e;
    public volatile String _f;
    public volatile boolean _g;
    public int _h;
    public dydp _i;
    public static final String[] _j = new String[]{"\u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192", "_ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e", "_ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026", "_ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020", "_ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021", "_ _ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6", "_ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021", "_ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020", "_ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026", "_ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e", "\u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192", "\u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _", "\u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _", "\u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _", "\u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _", "\u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _ _", "\u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _", "\u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _", "\u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _", "\u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _"};

    public kluc(xpzm xpzm2, gqjz gqjz2, dydp dydp2) {
        this.field_73887_h = Collections.synchronizedList(new ArrayList());
        this.field_73882_e = xpzm2;
        this._b = gqjz2;
        this._i = dydp2;
        dydp2._a(this);
        this._c = new Thread(dydp2);
    }

    public void _a() {
        this._c.start();
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._h;
        this._i._c();
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73866_w_() {
        this._i._d();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 666) {
            this._g = true;
            this.field_73882_e._a(this._b);
        }
        this._i._a(jiok2);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._d, this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "", this.field_73880_f / 2, this.field_73881_g / 2 - 10, 0xFFFFFF);
        if (!this._e) {
            this.func_73732_a(this.field_73886_k, _j[this._h % _j.length], this.field_73880_f / 2, this.field_73881_g / 2 + 15, 0x808080);
        }
        if (this._e) {
            this.func_73732_a(this.field_73886_k, this._f, this.field_73880_f / 2, this.field_73881_g / 2 + 15, 0xFF0000);
        }
        super.func_73863_a(n, n2, f);
    }

    public void _a(String string) {
        this._e = true;
        this._f = string;
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(666, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, "Back"));
    }

    public xpzm _b() {
        return this.field_73882_e;
    }

    public void _b(String string) {
        this._d = string;
    }

    public boolean _c() {
        return this._g;
    }
}

