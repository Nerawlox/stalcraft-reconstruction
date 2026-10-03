/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public class foqg {
    public static ArrayList<foqh> _a = new ArrayList<foqh>(Arrays.asList(foqh._f, foqh._c, foqh._g, foqh._u, foqh._t, foqh._w, foqh._x));
    public lqgz _b;
    public lqgz _c;
    public plnl _d = new plnl(this);
    public List _e = new ArrayList();

    public foqg() {
        this._e.addAll(_a);
    }

    public foqg(long l, nwix nwix2) {
        this();
        lqgz[] lqgzArray = lqgz._a(l, nwix2);
        lqgzArray = this._a(nwix2, l, lqgzArray);
        this._b = lqgzArray[0];
        this._c = lqgzArray[1];
    }

    public foqg(ozlu ozlu2) {
        this(ozlu2.func_72905_C(), ozlu2.func_72912_H()._u());
    }

    public List _a() {
        return this._e;
    }

    public foqh _a(int n, int n2) {
        return this._d._b(n, n2);
    }

    public float[] _a(float[] fArray, int n, int n2, int n3, int n4) {
        dins._a();
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            float f = (float)foqh._a[nArray[i]]._h() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            fArray[i] = f;
        }
        return fArray;
    }

    @SideOnly(value=Side.CLIENT)
    public float _a(float f, int n) {
        return f;
    }

    public float[] _b(float[] fArray, int n, int n2, int n3, int n4) {
        dins._a();
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            float f = (float)foqh._a[nArray[i]]._i() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            fArray[i] = f;
        }
        return fArray;
    }

    public foqh[] _a(foqh[] foqhArray, int n, int n2, int n3, int n4) {
        dins._a();
        if (foqhArray == null || foqhArray.length < n3 * n4) {
            foqhArray = new foqh[n3 * n4];
        }
        int[] nArray = this._b._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            foqhArray[i] = foqh._a[nArray[i]];
        }
        return foqhArray;
    }

    public foqh[] _b(foqh[] foqhArray, int n, int n2, int n3, int n4) {
        return this._a(foqhArray, n, n2, n3, n4, true);
    }

    public foqh[] _a(foqh[] foqhArray, int n, int n2, int n3, int n4, boolean bl) {
        dins._a();
        if (foqhArray == null || foqhArray.length < n3 * n4) {
            foqhArray = new foqh[n3 * n4];
        }
        if (bl && n3 == 16 && n4 == 16 && (n & 0xF) == 0 && (n2 & 0xF) == 0) {
            foqh[] foqhArray2 = this._d._c(n, n2);
            System.arraycopy(foqhArray2, 0, foqhArray, 0, n3 * n4);
            return foqhArray;
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            foqhArray[i] = foqh._a[nArray[i]];
        }
        return foqhArray;
    }

    public boolean _a(int n, int n2, int n3, List list2) {
        dins._a();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this._b._a(n4, n5, n8, n9);
        for (int i = 0; i < n8 * n9; ++i) {
            foqh foqh2 = foqh._a[nArray[i]];
            if (list2.contains(foqh2)) continue;
            return false;
        }
        return true;
    }

    public xtcd _a(int n, int n2, int n3, List list2, Random random) {
        dins._a();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this._b._a(n4, n5, n8, n9);
        xtcd xtcd2 = null;
        int n10 = 0;
        for (int i = 0; i < n8 * n9; ++i) {
            int n11 = n4 + i % n8 << 2;
            int n12 = n5 + i / n8 << 2;
            foqh foqh2 = foqh._a[nArray[i]];
            if (!list2.contains(foqh2) || xtcd2 != null && random.nextInt(n10 + 1) != 0) continue;
            xtcd2 = new xtcd(n11, 0, n12);
            ++n10;
        }
        return xtcd2;
    }

    public void _b() {
        this._d._a();
    }

    public lqgz[] _a(nwix nwix2, long l, lqgz[] lqgzArray) {
        WorldTypeEvent.InitBiomeGens initBiomeGens = new WorldTypeEvent.InitBiomeGens(nwix2, l, lqgzArray);
        MinecraftForge.TERRAIN_GEN_BUS.post(initBiomeGens);
        return initBiomeGens.newBiomeGens;
    }
}

