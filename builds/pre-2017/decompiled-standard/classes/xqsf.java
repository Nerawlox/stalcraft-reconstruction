/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;

public class xqsf
implements mssh {
    public HashMap<Integer, cvzo> _a = new HashMap();
    private final String _b;
    private final String _c;

    public xqsf(String string, String string2) {
        this._b = string;
        this._c = string2;
    }

    public void _a(cvzo cvzo2) {
        int n = 0;
        while (this._a.get(n) != null) {
            ++n;
        }
        this.func_70299_a(n, cvzo2);
    }

    public void _a(cvzo[] cvzoArray) {
        int n = 0;
        int n2 = -1;
        while (n < cvzoArray.length) {
            if (this.func_70301_a(++n2) != null) continue;
            this.func_70299_a(n2, cvzoArray[n++]);
        }
    }

    public void _a(qoac qoac2) {
        bsyv bsyv2 = qoac2._n(this._c);
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f("Slot");
            this.func_70299_a(n, cvzo._a(qoac3));
        }
    }

    public void _b(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (int n : this._a.keySet()) {
            if (this._a.get(n) == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", n);
            this._a.get(n)._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a(this._c, bsyv2);
    }

    public HashMap<Integer, cvzo> _a() {
        return this._a;
    }

    public int _b() {
        int n = 0;
        for (int n2 : this._a.keySet()) {
            if (n2 <= n) continue;
            n = n2;
        }
        int n3 = n + 2;
        if (n3 % this.func_70302_i_() == 0) {
            return n3 / this.func_70302_i_();
        }
        return n3 / this.func_70302_i_() + 1;
    }

    @Override
    public int func_70302_i_() {
        return 27;
    }

    @Override
    public cvzo func_70301_a(int n) {
        if (this._a.containsKey(n)) {
            return this._a.get(n);
        }
        return null;
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._a.containsKey(n)) {
            if (this._a.get((Object)Integer.valueOf((int)n))._b <= n2) {
                cvzo cvzo2 = this._a.get(n);
                this._a.remove(n);
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this._a.get(n)._a(n2);
            if (this._a.get((Object)Integer.valueOf((int)n))._b == 0) {
                this._a.remove(n);
            }
            this.func_70296_d();
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._a.containsKey(n) && this._a.get(n) != null) {
            cvzo cvzo2 = this._a.get(n);
            this._a.remove(n);
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (cvzo2 == null) {
            this._a.remove(n);
        } else {
            this._a.put(n, cvzo2);
        }
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return this._b;
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

