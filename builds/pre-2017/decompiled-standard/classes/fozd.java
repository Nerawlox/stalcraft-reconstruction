/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.sajh;

public class fozd
extends tycn {
    public static ArrayList<foqh> _d = new ArrayList<foqh>(Arrays.asList(foqh._d, foqh._f, foqh._e, foqh._h, foqh._g, foqh._n, foqh._o, foqh._s, foqh._t, foqh._v, foqh._w, foqh._x));
    public foqh[] _e = _d.toArray(new foqh[0]);
    public boolean _f;
    public jjym[] _g = new jjym[3];
    public double _h = 32.0;
    public int _i = 3;

    public fozd() {
    }

    public fozd(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if (((String)entry.getKey()).equals("distance")) {
                this._h = sajh._a((String)entry.getValue(), this._h, 1.0);
                continue;
            }
            if (((String)entry.getKey()).equals("count")) {
                this._g = new jjym[sajh._a((String)entry.getValue(), this._g.length, 1)];
                continue;
            }
            if (!((String)entry.getKey()).equals("spread")) continue;
            this._i = sajh._a((String)entry.getValue(), this._i, 1);
        }
    }

    @Override
    public String _a() {
        return "Stronghold";
    }

    @Override
    public boolean _a(int n, int n2) {
        if (!this._f) {
            Random random = new Random();
            random.setSeed(this._c.func_72905_C());
            double d = random.nextDouble() * Math.PI * 2.0;
            int n3 = 1;
            for (int i = 0; i < this._g.length; ++i) {
                double d2 = (1.25 * (double)n3 + random.nextDouble()) * this._h * (double)n3;
                int n4 = (int)Math.round(Math.cos(d) * d2);
                int n5 = (int)Math.round(Math.sin(d) * d2);
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, this._e);
                xtcd xtcd2 = this._c.func_72959_q()._a((n4 << 4) + 8, (n5 << 4) + 8, 112, arrayList, random);
                if (xtcd2 != null) {
                    n4 = xtcd2._d >> 4;
                    n5 = xtcd2._f >> 4;
                }
                this._g[i] = new jjym(n4, n5);
                d += Math.PI * 2 * (double)n3 / (double)this._i;
                if (i != this._i) continue;
                n3 += 2 + random.nextInt(5);
                this._i += 1 + random.nextInt(2);
            }
            this._f = true;
        }
        for (jjym jjym2 : this._g) {
            if (n != jjym2._a || n2 != jjym2._b) continue;
            return true;
        }
        return false;
    }

    @Override
    public List _b() {
        ArrayList<xtcd> arrayList = new ArrayList<xtcd>();
        for (jjym jjym2 : this._g) {
            if (jjym2 == null) continue;
            arrayList.add(jjym2._a(64));
        }
        return arrayList;
    }

    @Override
    public tycc _b(int n, int n2) {
        razs razs2 = new razs(this._c, this._b, n, n2);
        while (razs2._b().isEmpty() || ((xciz)razs2._b().get((int)0))._d == null) {
            razs2 = new razs(this._c, this._b, n, n2);
        }
        return razs2;
    }
}

