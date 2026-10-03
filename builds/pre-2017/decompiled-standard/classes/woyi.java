/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class woyi
extends ekfs {
    public final /* synthetic */ uzta _g;

    public woyi(uzta uzta2) {
        this._g = uzta2;
        super(uzta2);
        this._b = new ArrayList();
        for (huss huss2 : dzif._e) {
            boolean bl = false;
            int n = huss2._a();
            if (uzta._c(uzta2)._a(huss2) > 0) {
                bl = true;
            } else if (dzif._E[n] != null && uzta._c(uzta2)._a(dzif._E[n]) > 0) {
                bl = true;
            } else if (dzif._D[n] != null && uzta._c(uzta2)._a(dzif._D[n]) > 0) {
                bl = true;
            }
            if (!bl) continue;
            this._b.add(huss2);
        }
        this._c = new aoyv(this, uzta2);
    }

    @Override
    public void func_77222_a(int n, int n2, htvf htvf2) {
        super.func_77222_a(n, n2, htvf2);
        if (this._a == 0) {
            uzta._a(this._g, n + 115 - 18 + 1, n2 + 1 + 1, 18, 18);
        } else {
            uzta._a(this._g, n + 115 - 18, n2 + 1, 18, 18);
        }
        if (this._a == 1) {
            uzta._a(this._g, n + 165 - 18 + 1, n2 + 1 + 1, 36, 18);
        } else {
            uzta._a(this._g, n + 165 - 18, n2 + 1, 36, 18);
        }
        if (this._a == 2) {
            uzta._a(this._g, n + 215 - 18 + 1, n2 + 1 + 1, 54, 18);
        } else {
            uzta._a(this._g, n + 215 - 18, n2 + 1, 54, 18);
        }
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        huss huss2 = this._a(n);
        int n5 = huss2._a();
        uzta._a(this._g, n2 + 40, n3, n5);
        this._a((huss)dzif._D[n5], n2 + 115, n3, n % 2 == 0);
        this._a((huss)dzif._E[n5], n2 + 165, n3, n % 2 == 0);
        this._a(huss2, n2 + 215, n3, n % 2 == 0);
    }

    @Override
    public String _b(int n) {
        if (n == 0) {
            return "stat.crafted";
        }
        if (n == 1) {
            return "stat.used";
        }
        return "stat.mined";
    }
}

