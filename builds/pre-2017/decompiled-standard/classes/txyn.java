/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class txyn
extends foqg {
    public foqh _f;
    public float _g;
    public float _h;

    public txyn(foqh foqh2, float f, float f2) {
        this._f = foqh2;
        this._g = f;
        this._h = f2;
    }

    @Override
    public foqh _a(int n, int n2) {
        return this._f;
    }

    @Override
    public foqh[] _a(foqh[] foqhArray, int n, int n2, int n3, int n4) {
        if (foqhArray == null || foqhArray.length < n3 * n4) {
            foqhArray = new foqh[n3 * n4];
        }
        Arrays.fill(foqhArray, 0, n3 * n4, this._f);
        return foqhArray;
    }

    @Override
    public float[] _b(float[] fArray, int n, int n2, int n3, int n4) {
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        Arrays.fill(fArray, 0, n3 * n4, this._g);
        return fArray;
    }

    @Override
    public float[] _a(float[] fArray, int n, int n2, int n3, int n4) {
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        Arrays.fill(fArray, 0, n3 * n4, this._h);
        return fArray;
    }

    @Override
    public foqh[] _b(foqh[] foqhArray, int n, int n2, int n3, int n4) {
        if (foqhArray == null || foqhArray.length < n3 * n4) {
            foqhArray = new foqh[n3 * n4];
        }
        Arrays.fill(foqhArray, 0, n3 * n4, this._f);
        return foqhArray;
    }

    @Override
    public foqh[] _a(foqh[] foqhArray, int n, int n2, int n3, int n4, boolean bl) {
        return this._b(foqhArray, n, n2, n3, n4);
    }

    @Override
    public xtcd _a(int n, int n2, int n3, List list, Random random) {
        if (list.contains(this._f)) {
            return new xtcd(n - n3 + random.nextInt(n3 * 2 + 1), 0, n2 - n3 + random.nextInt(n3 * 2 + 1));
        }
        return null;
    }

    @Override
    public boolean _a(int n, int n2, int n3, List list) {
        return list.contains(this._f);
    }
}

