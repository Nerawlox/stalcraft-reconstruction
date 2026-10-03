/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import java.util.ArrayList;
import java.util.Iterator;

public class wnhj
extends mqld {
    public int _c;
    public static final int _d = 60;
    public int _e = -60;
    public ArrayList<jhcr> _f = new ArrayList();

    @ezey(_a={eidj.CLIENT})
    public void _a() {
        this.field_70331_k.func_72980_b((float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, "anomalies:electra_hit", 1.0f, 1.0f, false);
        pidb._a(new bqmy(this));
        this._e = this._c;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_70316_g() {
        super.func_70316_g();
        ++this._c;
        Iterator<jhcr> iterator2 = this._f.iterator();
        while (iterator2.hasNext()) {
            jhcr jhcr2 = iterator2.next();
            if (jhcr2._g) {
                iterator2.remove();
                continue;
            }
            jhcr2._a();
        }
        if (this._c > this._e + 60 && this.field_70331_k.field_73012_v.nextFloat() < 0.2f) {
            ((mqip)this._c())._a();
            this._f.add(new jhcr(this));
        }
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._c = qoac2._f("counter");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("counter", this._c);
    }

    @Override
    protected Class<? extends iekw> _d() {
        return mqip.class;
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 3) {
            this._a();
            return true;
        }
        return super.func_70315_b(n, n2);
    }
}

