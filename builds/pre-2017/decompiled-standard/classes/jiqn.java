/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public class jiqn
extends wovy {
    public final List _a;
    public final Map _b;
    public final /* synthetic */ twpa _c;

    public jiqn(twpa twpa2) {
        this._c = twpa2;
        super(twpa2.field_73882_e, twpa2.field_73880_f, twpa2.field_73881_g, 32, twpa2.field_73881_g - 65 + 4, 18);
        this._a = Lists.newArrayList();
        this._b = Maps.newHashMap();
        for (zhkm zhkm2 : twpa._a(twpa2)._d()) {
            this._b.put(zhkm2._a(), zhkm2);
            this._a.add(zhkm2._a());
        }
    }

    @Override
    public int func_77217_a() {
        return this._a.size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        zhkm zhkm2 = (zhkm)this._b.get(this._a.get(n));
        twpa._a(this._c)._a(zhkm2);
        twpa._b((twpa)this._c).field_74363_ab = zhkm2._a();
        this._c.field_73882_e._c();
        this._c.field_73886_k._a(twpa._a(this._c)._a());
        this._c.field_73886_k._b(twpa._a(this._c)._b());
        twpa._c((twpa)this._c).field_73744_e = wpcz._a("gui.done");
        twpa._b(this._c).func_74303_b();
    }

    @Override
    public boolean func_77218_a(int n) {
        return ((String)this._a.get(n)).equals(twpa._a(this._c)._c()._a());
    }

    @Override
    public int func_77212_b() {
        return this.func_77217_a() * 18;
    }

    @Override
    public void func_77221_c() {
        this._c.func_73873_v_();
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        this._c.field_73886_k._b(true);
        this._c.func_73732_a(this._c.field_73886_k, ((zhkm)this._b.get(this._a.get(n))).toString(), this._c.field_73880_f / 2, n3 + 1, 0xFFFFFF);
        this._c.field_73886_k._b(twpa._a(this._c)._c()._b());
    }
}

