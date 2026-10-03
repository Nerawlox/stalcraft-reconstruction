/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;

public class ifno
extends gqjz {
    public final gqjz _a;
    public final GameSettings _b;
    public final List _c = new ArrayList();
    public final List _d = new ArrayList();
    public String _e;
    public String[] _f;
    public aoxf _g;
    public jiok _h;

    public ifno(gqjz gqjz2, GameSettings gameSettings) {
        this._a = gqjz2;
        this._b = gameSettings;
    }

    @Override
    public void func_73866_w_() {
        this._e = wpcz._a("options.snooper.title");
        String string = wpcz._a("options.snooper.desc");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Iterator iterator2 : this.field_73886_k._c(string, this.field_73880_f - 30)) {
            arrayList.add((String)((Object)iterator2));
        }
        this._f = arrayList.toArray(new String[0]);
        this._c.clear();
        this._d.clear();
        this._h = new jiok(1, this.field_73880_f / 2 - 152, this.field_73881_g - 30, 150, 20, this._b.func_74297_c(kjui._x));
        this.field_73887_h.add(this._h);
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 + 2, this.field_73881_g - 30, 150, 20, wpcz._a("gui.done")));
        boolean bl = this.field_73882_e._J() != null && this.field_73882_e._J().__am() != null;
        for (Map.Entry entry : new TreeMap(this.field_73882_e._L()._e()).entrySet()) {
            this._c.add((bl ? "C " : "") + (String)entry.getKey());
            this._d.add(this.field_73886_k._a((String)entry.getValue(), this.field_73880_f - 220));
        }
        if (bl) {
            for (Map.Entry entry : new TreeMap(this.field_73882_e._J().__am()._e()).entrySet()) {
                this._c.add("S " + (String)entry.getKey());
                this._d.add(this.field_73886_k._a((String)entry.getValue(), this.field_73880_f - 220));
            }
        }
        this._g = new aoxf(this);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 2) {
            this._b.func_74303_b();
            this._b.func_74303_b();
            this.field_73882_e._a(this._a);
        }
        if (jiok2.field_73741_f == 1) {
            this._b.func_74306_a(kjui._x, 1);
            this._h.field_73744_e = this._b.func_74297_c(kjui._x);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._g.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._e, this.field_73880_f / 2, 8, 0xFFFFFF);
        int n3 = 22;
        for (String string : this._f) {
            this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2, n3, 0x808080);
            n3 += this.field_73886_k._c;
        }
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ List _a(ifno ifno2) {
        return ifno2._c;
    }

    public static /* synthetic */ List _b(ifno ifno2) {
        return ifno2._d;
    }
}

