/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.tdpf;
import net.minecraft.entity.ai.zwat;

public class idpz {
    public List _a = new ArrayList();
    public List _b = new ArrayList();
    public final fokl _c;
    public int _d;
    public int _e = 3;

    public idpz(fokl fokl2) {
        this._c = fokl2;
    }

    public void _a(int n, zwat zwat2) {
        this._a.add(new tdpf(this, n, zwat2));
    }

    public void _a(zwat zwat2) {
        Iterator iterator2 = this._a.iterator();
        while (iterator2.hasNext()) {
            tdpf tdpf2 = (tdpf)iterator2.next();
            zwat zwat3 = tdpf2._a;
            if (zwat3 != zwat2) continue;
            if (this._b.contains(tdpf2)) {
                zwat3.func_75251_c();
                this._b.remove(tdpf2);
            }
            iterator2.remove();
        }
    }

    public void _a() {
        ArrayList<tdpf> arrayList = new ArrayList<tdpf>();
        if (this._d++ % this._e == 0) {
            for (tdpf tdpf2 : this._a) {
                boolean bl = this._b.contains(tdpf2);
                if (bl) {
                    if (this._b(tdpf2) && this._a(tdpf2)) continue;
                    tdpf2._a.func_75251_c();
                    this._b.remove(tdpf2);
                }
                if (!this._b(tdpf2) || !tdpf2._a.func_75250_a()) continue;
                arrayList.add(tdpf2);
                this._b.add(tdpf2);
            }
        } else {
            Iterator iterator2 = this._b.iterator();
            while (iterator2.hasNext()) {
                tdpf tdpf2;
                tdpf2 = (tdpf)iterator2.next();
                if (tdpf2._a.func_75253_b()) continue;
                tdpf2._a.func_75251_c();
                iterator2.remove();
            }
        }
        this._c._a("goalStart");
        for (tdpf tdpf2 : arrayList) {
            this._c._a(tdpf2._a.getClass().getSimpleName());
            tdpf2._a.func_75249_e();
            this._c._b();
        }
        this._c._b();
        this._c._a("goalTick");
        for (tdpf tdpf2 : this._b) {
            tdpf2._a.func_75246_d();
        }
        this._c._b();
    }

    public boolean _a(tdpf tdpf2) {
        this._c._a("canContinue");
        boolean bl = tdpf2._a.func_75253_b();
        this._c._b();
        return bl;
    }

    public boolean _b(tdpf tdpf2) {
        this._c._a("canUse");
        for (tdpf tdpf3 : this._a) {
            if (tdpf3 == tdpf2) continue;
            if (tdpf2._b >= tdpf3._b) {
                if (!this._b.contains(tdpf3) || this._a(tdpf2, tdpf3)) continue;
                this._c._b();
                return false;
            }
            if (!this._b.contains(tdpf3) || tdpf3._a.func_75252_g()) continue;
            this._c._b();
            return false;
        }
        this._c._b();
        return true;
    }

    public boolean _a(tdpf tdpf2, tdpf tdpf3) {
        return (tdpf2._a.func_75247_h() & tdpf3._a.func_75247_h()) == 0;
    }
}

