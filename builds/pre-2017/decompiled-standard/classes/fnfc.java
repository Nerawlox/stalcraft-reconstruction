/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;

public class fnfc
extends wovy {
    public final /* synthetic */ fnfu _a;

    public fnfc(fnfu fnfu2) {
        this._a = fnfu2;
        super(fnfu2.field_73882_e, fnfu2.field_73880_f, fnfu2.field_73881_g, 32, fnfu2.field_73881_g - 64, 36);
    }

    @Override
    public int func_77217_a() {
        return fnfu._a(this._a).size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        boolean bl2;
        fnfu._a(this._a, n);
        fnfu._c((fnfu)this._a).field_73742_g = bl2 = fnfu._b(this._a) >= 0 && fnfu._b(this._a) < this.func_77217_a();
        fnfu._d((fnfu)this._a).field_73742_g = bl2;
        fnfu._e((fnfu)this._a).field_73742_g = bl2;
        fnfu._f((fnfu)this._a).field_73742_g = bl2;
        if (bl && bl2) {
            this._a._c(n);
        }
    }

    @Override
    public boolean func_77218_a(int n) {
        return n == fnfu._b(this._a);
    }

    @Override
    public int func_77212_b() {
        return fnfu._a(this._a).size() * 36;
    }

    @Override
    public void func_77221_c() {
        this._a.func_73873_v_();
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        cfrv cfrv2 = (cfrv)fnfu._a(this._a).get(n);
        String string = cfrv2._b();
        if (string == null || sajh._a(string)) {
            string = fnfu._g(this._a) + " " + (n + 1);
        }
        String string2 = cfrv2._a();
        string2 = string2 + " (" + fnfu._h(this._a).format(new Date(cfrv2._d()));
        string2 = string2 + ")";
        String string3 = "";
        if (cfrv2._c()) {
            string3 = fnfu._i(this._a) + " " + string3;
        } else {
            string3 = fnfu._j(this._a)[cfrv2._e()._a()];
            if (cfrv2._f()) {
                string3 = (Object)((Object)ezfc._e) + wpcz._a("gameMode.hardcore") + (Object)((Object)ezfc._v);
            }
            if (cfrv2._g()) {
                string3 = string3 + ", " + wpcz._a("selectWorld.cheats");
            }
        }
        this._a.func_73731_b(this._a.field_73886_k, string, n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.func_73731_b(this._a.field_73886_k, string2, n2 + 2, n3 + 12, 0x808080);
        this._a.func_73731_b(this._a.field_73886_k, string3, n2 + 2, n3 + 12 + 10, 0x808080);
    }
}

