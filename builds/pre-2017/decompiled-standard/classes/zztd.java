/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.util.owak;
import net.minecraft.util.ugqx;
import net.minecraft.util.vjvn;

public abstract class zztd {
    public uken _m;
    public int _n;
    public int _o;

    public zztd() {
    }

    public zztd(int n) {
        this._o = n;
        this._n = -1;
    }

    public qoac _c() {
        if (cfps._a(this) == null) {
            throw new RuntimeException("StructureComponent \"" + this.getClass().getName() + "\" missing ID Mapping, Modder see MapGenStructureIO");
        }
        qoac qoac2 = new qoac();
        qoac2._a("id", cfps._a(this));
        qoac2._a("BB", this._m._a("BB"));
        qoac2._a("O", this._n);
        qoac2._a("GD", this._o);
        this._a(qoac2);
        return qoac2;
    }

    public abstract void _a(qoac var1);

    public void _a(ozlu ozlu2, qoac qoac2) {
        if (qoac2._c("BB")) {
            this._m = new uken(qoac2._l("BB"));
        }
        this._n = qoac2._f("O");
        this._o = qoac2._f("GD");
        this._b(qoac2);
    }

    public abstract void _b(qoac var1);

    public void _a(zztd zztd2, List list, Random random) {
    }

    public abstract boolean _a(ozlu var1, Random var2, uken var3);

    public uken _d() {
        return this._m;
    }

    public int _e() {
        return this._o;
    }

    public static zztd _a(List list, uken uken2) {
        zztd zztd2;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return null;
        } while ((zztd2 = (zztd)iterator.next())._d() == null || !zztd2._d()._a(uken2));
        return zztd2;
    }

    public xtcd _a() {
        return new xtcd(this._m._e(), this._m._f(), this._m._g());
    }

    public boolean _b(ozlu ozlu2, uken uken2) {
        int n;
        int n2;
        int n3;
        int n4 = Math.max(this._m._a - 1, uken2._a);
        int n5 = Math.max(this._m._b - 1, uken2._b);
        int n6 = Math.max(this._m._c - 1, uken2._c);
        int n7 = Math.min(this._m._d + 1, uken2._d);
        int n8 = Math.min(this._m._e + 1, uken2._e);
        int n9 = Math.min(this._m._f + 1, uken2._f);
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n6; n2 <= n9; ++n2) {
                n = ozlu2.func_72798_a(n3, n5, n2);
                if (n > 0 && twgu.field_71973_m[n].field_72018_cp._d()) {
                    return true;
                }
                n = ozlu2.func_72798_a(n3, n8, n2);
                if (n <= 0 || !twgu.field_71973_m[n].field_72018_cp._d()) continue;
                return true;
            }
        }
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = ozlu2.func_72798_a(n3, n2, n6);
                if (n > 0 && twgu.field_71973_m[n].field_72018_cp._d()) {
                    return true;
                }
                n = ozlu2.func_72798_a(n3, n2, n9);
                if (n <= 0 || !twgu.field_71973_m[n].field_72018_cp._d()) continue;
                return true;
            }
        }
        for (n3 = n6; n3 <= n9; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = ozlu2.func_72798_a(n4, n2, n3);
                if (n > 0 && twgu.field_71973_m[n].field_72018_cp._d()) {
                    return true;
                }
                n = ozlu2.func_72798_a(n7, n2, n3);
                if (n <= 0 || !twgu.field_71973_m[n].field_72018_cp._d()) continue;
                return true;
            }
        }
        return false;
    }

    public int _c(int n, int n2) {
        switch (this._n) {
            case 0: 
            case 2: {
                return this._m._a + n;
            }
            case 1: {
                return this._m._d - n2;
            }
            case 3: {
                return this._m._a + n2;
            }
        }
        return n;
    }

    public int _b(int n) {
        return this._n == -1 ? n : n + this._m._b;
    }

    public int _d(int n, int n2) {
        switch (this._n) {
            case 0: {
                return this._m._c + n2;
            }
            case 1: 
            case 3: {
                return this._m._c + n;
            }
            case 2: {
                return this._m._f - n2;
            }
        }
        return n2;
    }

    public int _e(int n, int n2) {
        if (n == twgu.field_72056_aG.field_71990_ca) {
            if (this._n == 1 || this._n == 3) {
                if (n2 == 1) {
                    return 0;
                }
                return 1;
            }
        } else if (n != twgu.field_72054_aE.field_71990_ca && n != twgu.field_72045_aL.field_71990_ca) {
            if (n != twgu.field_72057_aH.field_71990_ca && n != twgu.field_72063_at.field_71990_ca && n != twgu.field_72100_bC.field_71990_ca && n != twgu.field_71995_bx.field_71990_ca && n != twgu.field_72088_bQ.field_71990_ca) {
                if (n == twgu.field_72055_aF.field_71990_ca) {
                    if (this._n == 0) {
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 3) {
                            return 2;
                        }
                    } else if (this._n == 1) {
                        if (n2 == 2) {
                            return 4;
                        }
                        if (n2 == 3) {
                            return 5;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 5) {
                            return 3;
                        }
                    } else if (this._n == 3) {
                        if (n2 == 2) {
                            return 5;
                        }
                        if (n2 == 3) {
                            return 4;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 5) {
                            return 3;
                        }
                    }
                } else if (n == twgu.field_72034_aR.field_71990_ca) {
                    if (this._n == 0) {
                        if (n2 == 3) {
                            return 4;
                        }
                        if (n2 == 4) {
                            return 3;
                        }
                    } else if (this._n == 1) {
                        if (n2 == 3) {
                            return 1;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 1) {
                            return 4;
                        }
                    } else if (this._n == 3) {
                        if (n2 == 3) {
                            return 2;
                        }
                        if (n2 == 4) {
                            return 1;
                        }
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 1) {
                            return 4;
                        }
                    }
                } else if (!(n == twgu.field_72064_bT.field_71990_ca || twgu.field_71973_m[n] != null && twgu.field_71973_m[n] instanceof gqau)) {
                    if (n == twgu.field_71963_Z.field_71990_ca || n == twgu.field_71956_V.field_71990_ca || n == twgu.field_72043_aJ.field_71990_ca || n == twgu.field_71958_P.field_71990_ca) {
                        if (this._n == 0) {
                            if (n2 == 2 || n2 == 3) {
                                return owak._a[n2];
                            }
                        } else if (this._n == 1) {
                            if (n2 == 2) {
                                return 4;
                            }
                            if (n2 == 3) {
                                return 5;
                            }
                            if (n2 == 4) {
                                return 2;
                            }
                            if (n2 == 5) {
                                return 3;
                            }
                        } else if (this._n == 3) {
                            if (n2 == 2) {
                                return 5;
                            }
                            if (n2 == 3) {
                                return 4;
                            }
                            if (n2 == 4) {
                                return 2;
                            }
                            if (n2 == 5) {
                                return 3;
                            }
                        }
                    }
                } else if (this._n == 0) {
                    if (n2 == 0 || n2 == 2) {
                        return ugqx._f[n2];
                    }
                } else if (this._n == 1) {
                    if (n2 == 2) {
                        return 1;
                    }
                    if (n2 == 0) {
                        return 3;
                    }
                    if (n2 == 1) {
                        return 2;
                    }
                    if (n2 == 3) {
                        return 0;
                    }
                } else if (this._n == 3) {
                    if (n2 == 2) {
                        return 3;
                    }
                    if (n2 == 0) {
                        return 1;
                    }
                    if (n2 == 1) {
                        return 2;
                    }
                    if (n2 == 3) {
                        return 0;
                    }
                }
            } else if (this._n == 0) {
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 3) {
                    return 2;
                }
            } else if (this._n == 1) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 0;
                }
                if (n2 == 3) {
                    return 1;
                }
            } else if (this._n == 3) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 1;
                }
                if (n2 == 3) {
                    return 0;
                }
            }
        } else if (this._n == 0) {
            if (n2 == 0) {
                return 2;
            }
            if (n2 == 2) {
                return 0;
            }
        } else {
            if (this._n == 1) {
                return n2 + 1 & 3;
            }
            if (this._n == 3) {
                return n2 + 3 & 3;
            }
        }
        return n2;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6;
        int n7;
        int n8 = this._c(n3, n5);
        if (uken2._b(n8, n7 = this._b(n4), n6 = this._d(n3, n5))) {
            ozlu2.func_72832_d(n8, n7, n6, n, n2, 2);
        }
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3, uken uken2) {
        int n4;
        int n5;
        int n6 = this._c(n, n3);
        return !uken2._b(n6, n5 = this._b(n2), n4 = this._d(n, n3)) ? 0 : ozlu2.func_72798_a(n6, n5, n4);
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    this._a(ozlu2, 0, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(ozlu2, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(ozlu2, n8, 0, j, i, k, uken2);
                        continue;
                    }
                    this._a(ozlu2, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(ozlu2, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(ozlu2, n9, n10, j, i, k, uken2);
                        continue;
                    }
                    this._a(ozlu2, n7, n8, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, boolean bl, Random random, yfoy yfoy2) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(ozlu2, j, i, k, uken2) == 0) continue;
                    yfoy2._a(random, j, i, k, i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6);
                    this._a(ozlu2, yfoy2._a(), yfoy2._b(), j, i, k, uken2);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, uken uken2, Random random, float f, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!(random.nextFloat() <= f) || bl && this._a(ozlu2, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(ozlu2, n8, 0, j, i, k, uken2);
                        continue;
                    }
                    this._a(ozlu2, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, uken uken2, Random random, float f, int n, int n2, int n3, int n4, int n5) {
        if (random.nextFloat() < f) {
            this._a(ozlu2, n4, n5, n, n2, n3, uken2);
        }
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        float f = n4 - n + 1;
        float f2 = n5 - n2 + 1;
        float f3 = n6 - n3 + 1;
        float f4 = (float)n + f / 2.0f;
        float f5 = (float)n3 + f3 / 2.0f;
        for (int i = n2; i <= n5; ++i) {
            float f6 = (float)(i - n2) / f2;
            for (int j = n; j <= n4; ++j) {
                float f7 = ((float)j - f4) / (f * 0.5f);
                for (int k = n3; k <= n6; ++k) {
                    float f8;
                    float f9 = ((float)k - f5) / (f3 * 0.5f);
                    if (bl && this._a(ozlu2, j, i, k, uken2) == 0 || !((f8 = f7 * f7 + f6 * f6 + f9 * f9) <= 1.05f)) continue;
                    this._a(ozlu2, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3, uken uken2) {
        int n4;
        int n5;
        int n6 = this._c(n, n3);
        if (uken2._b(n6, n5 = this._b(n2), n4 = this._d(n, n3))) {
            while (!ozlu2.func_72799_c(n6, n5, n4) && n5 < 255) {
                ozlu2.func_72832_d(n6, n5, n4, 0, 0, 2);
                ++n5;
            }
        }
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6;
        int n7;
        int n8 = this._c(n3, n5);
        if (uken2._b(n8, n7 = this._b(n4), n6 = this._d(n3, n5))) {
            while ((ozlu2.func_72799_c(n8, n7, n6) || ozlu2.func_72803_f(n8, n7, n6)._d()) && n7 > 1) {
                ozlu2.func_72832_d(n8, n7, n6, n, n2, 2);
                --n7;
            }
        }
    }

    public boolean _a(ozlu ozlu2, uken uken2, Random random, int n, int n2, int n3, vjvn[] vjvnArray, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3)) && ozlu2.func_72798_a(n7, n6, n5) != twgu.field_72077_au.field_71990_ca) {
            ozlu2.func_72832_d(n7, n6, n5, twgu.field_72077_au.field_71990_ca, 0, 2);
            yfav yfav2 = (yfav)ozlu2.func_72796_p(n7, n6, n5);
            if (yfav2 != null) {
                vjvn._a(random, vjvnArray, yfav2, n4);
            }
            return true;
        }
        return false;
    }

    public boolean _a(ozlu ozlu2, uken uken2, Random random, int n, int n2, int n3, int n4, vjvn[] vjvnArray, int n5) {
        int n6;
        int n7;
        int n8 = this._c(n, n3);
        if (uken2._b(n8, n7 = this._b(n2), n6 = this._d(n, n3)) && ozlu2.func_72798_a(n8, n7, n6) != twgu.field_71958_P.field_71990_ca) {
            ozlu2.func_72832_d(n8, n7, n6, twgu.field_71958_P.field_71990_ca, this._e(twgu.field_71958_P.field_71990_ca, n4), 2);
            jjzo jjzo2 = (jjzo)ozlu2.func_72796_p(n8, n7, n6);
            if (jjzo2 != null) {
                vjvn._a(random, vjvnArray, jjzo2, n5);
            }
            return true;
        }
        return false;
    }

    public void _a(ozlu ozlu2, uken uken2, Random random, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3))) {
            yvwy._a(ozlu2, n7, n6, n5, n4, twgu.field_72054_aE);
        }
    }
}

