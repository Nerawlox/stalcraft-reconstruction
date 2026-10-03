/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fovt
extends plsd {
    public foqg _e;
    public boolean _f;
    public foqh _g;
    public int _h;
    public ihas _i;
    public List _j;
    public List _k = new ArrayList();
    public List _l = new ArrayList();

    public fovt() {
    }

    public fovt(foqg foqg2, int n, Random random, int n2, int n3, List list2, int n4) {
        super(null, 0, random, n2, n3);
        this._e = foqg2;
        this._j = list2;
        this._h = n4;
        foqh foqh2 = foqg2._a(n2, n3);
        this._f = foqh2 == foqh._d || foqh2 == foqh._s;
        this._g = foqh2;
    }

    public foqg _b() {
        return this._e;
    }
}

