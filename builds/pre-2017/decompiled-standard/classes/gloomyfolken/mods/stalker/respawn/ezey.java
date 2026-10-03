/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.eidj;

@gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
public class ezey
extends jzpo {
    public int _a;
    private int _c = 0;

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this._a > 0) {
            String string = "\u041e\u0441\u0442\u0430\u043b\u043e\u0441\u044c: " + (this._a / 20 + 1 >= 60 ? this._a / 1200 + " \u043c\u0438\u043d." : this._a / 20 + 1 + " \u0441\u0435\u043a.");
            this.func_73732_a(this.field_73882_e._z, string, this.field_73880_f / 2, 110, 0xFFFFFF);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        --this._a;
        ++this._c;
        for (jiok jiok2 : this.field_73887_h) {
            if (jiok2.field_73741_f != 1) continue;
            jiok2.field_73742_g = this._c >= 20 && this._a <= 0;
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        switch (jiok2.field_73741_f) {
            case 1: {
                this.field_73882_e._t.field_71174_a._b(new ndnf(1));
                this.field_73882_e._a((gqjz)null);
                break;
            }
            case 2: {
                this.field_73882_e._r.func_72882_A();
                this.field_73882_e._a((pkix)null);
                this.field_73882_e._a(new fngq());
            }
        }
    }
}

