/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class twjd
extends ogyy {
    public int _a;
    public boolean[] _b = new boolean[4];
    public int[] _c = new int[4];

    public twjd(int n, tflj tflj2) {
        super(n, tflj2);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca + 1, n4, 2);
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return this.field_72018_cp != tflj._i;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        int n5 = this._e(ozlu2, n, n2, n3);
        int n6 = 1;
        if (this.field_72018_cp == tflj._i && !ozlu2.field_73011_w._f) {
            n6 = 2;
        }
        boolean bl = true;
        int n7 = this.func_71859_p_(ozlu2);
        if (n5 > 0) {
            int n8 = -100;
            this._a = 0;
            int n9 = this._b(ozlu2, n - 1, n2, n3, n8);
            n9 = this._b(ozlu2, n + 1, n2, n3, n9);
            n9 = this._b(ozlu2, n, n2, n3 - 1, n9);
            n4 = (n9 = this._b(ozlu2, n, n2, n3 + 1, n9)) + n6;
            if (n4 >= 8 || n9 < 0) {
                n4 = -1;
            }
            if (this._e(ozlu2, n, n2 + 1, n3) >= 0) {
                int n10 = this._e(ozlu2, n, n2 + 1, n3);
                n4 = n10 >= 8 ? n10 : n10 + 8;
            }
            if (this._a >= 2 && this.field_72018_cp == tflj._h) {
                if (ozlu2.func_72803_f(n, n2 - 1, n3)._a()) {
                    n4 = 0;
                } else if (ozlu2.func_72803_f(n, n2 - 1, n3) == this.field_72018_cp && ozlu2.func_72805_g(n, n2 - 1, n3) == 0) {
                    n4 = 0;
                }
            }
            if (this.field_72018_cp == tflj._i && n5 < 8 && n4 < 8 && n4 > n5 && random.nextInt(4) != 0) {
                n7 *= 4;
            }
            if (n4 == n5) {
                if (bl) {
                    this._a(ozlu2, n, n2, n3);
                }
            } else {
                n5 = n4;
                if (n4 < 0) {
                    ozlu2.func_94571_i(n, n2, n3);
                } else {
                    ozlu2.func_72921_c(n, n2, n3, n4, 2);
                    ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, n7);
                    ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
                }
            }
        } else {
            this._a(ozlu2, n, n2, n3);
        }
        if (this._d(ozlu2, n, n2 - 1, n3)) {
            if (this.field_72018_cp == tflj._i && ozlu2.func_72803_f(n, n2 - 1, n3) == tflj._h) {
                ozlu2.func_94575_c(n, n2 - 1, n3, twgu.field_71981_t.field_71990_ca);
                this._g(ozlu2, n, n2 - 1, n3);
                return;
            }
            if (n5 >= 8) {
                this._a(ozlu2, n, n2 - 1, n3, n5);
            } else {
                this._a(ozlu2, n, n2 - 1, n3, n5 + 8);
            }
        } else if (n5 >= 0 && (n5 == 0 || this._c(ozlu2, n, n2 - 1, n3))) {
            boolean[] blArray = this._b(ozlu2, n, n2, n3);
            n4 = n5 + n6;
            if (n5 >= 8) {
                n4 = 1;
            }
            if (n4 >= 8) {
                return;
            }
            if (blArray[0]) {
                this._a(ozlu2, n - 1, n2, n3, n4);
            }
            if (blArray[1]) {
                this._a(ozlu2, n + 1, n2, n3, n4);
            }
            if (blArray[2]) {
                this._a(ozlu2, n, n2, n3 - 1, n4);
            }
            if (blArray[3]) {
                this._a(ozlu2, n, n2, n3 + 1, n4);
            }
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._d(ozlu2, n, n2, n3)) {
            int n5 = ozlu2.func_72798_a(n, n2, n3);
            if (n5 > 0) {
                if (this.field_72018_cp == tflj._i) {
                    this._g(ozlu2, n, n2, n3);
                } else if (n5 != twgu.field_72037_aS.field_71990_ca) {
                    twgu.field_71973_m[n5].func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                }
            }
            ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, n4, 3);
        }
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1000;
        for (int i = 0; i < 4; ++i) {
            int n7;
            if (i == 0 && n5 == 1 || i == 1 && n5 == 0 || i == 2 && n5 == 3 || i == 3 && n5 == 2) continue;
            int n8 = n;
            int n9 = n3;
            if (i == 0) {
                n8 = n - 1;
            }
            if (i == 1) {
                ++n8;
            }
            if (i == 2) {
                n9 = n3 - 1;
            }
            if (i == 3) {
                ++n9;
            }
            if (this._c(ozlu2, n8, n2, n9) || ozlu2.func_72803_f(n8, n2, n9) == this.field_72018_cp && ozlu2.func_72805_g(n8, n2, n9) == 0) continue;
            if (!this._c(ozlu2, n8, n2 - 1, n9)) {
                return n4;
            }
            if (n4 >= 4 || (n7 = this._a(ozlu2, n8, n2, n9, n4 + 1, i)) >= n6) continue;
            n6 = n7;
        }
        return n6;
    }

    public boolean[] _b(ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        for (n5 = 0; n5 < 4; ++n5) {
            this._c[n5] = 1000;
            n4 = n;
            int n6 = n3;
            if (n5 == 0) {
                n4 = n - 1;
            }
            if (n5 == 1) {
                ++n4;
            }
            if (n5 == 2) {
                n6 = n3 - 1;
            }
            if (n5 == 3) {
                ++n6;
            }
            if (this._c(ozlu2, n4, n2, n6) || ozlu2.func_72803_f(n4, n2, n6) == this.field_72018_cp && ozlu2.func_72805_g(n4, n2, n6) == 0) continue;
            this._c[n5] = this._c(ozlu2, n4, n2 - 1, n6) ? this._a(ozlu2, n4, n2, n6, 1, n5) : 0;
        }
        n5 = this._c[0];
        for (n4 = 1; n4 < 4; ++n4) {
            if (this._c[n4] >= n5) continue;
            n5 = this._c[n4];
        }
        for (n4 = 0; n4 < 4; ++n4) {
            this._b[n4] = this._c[n4] == n5;
        }
        return this._b;
    }

    public boolean _c(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        if (n4 != twgu.field_72054_aE.field_71990_ca && n4 != twgu.field_72045_aL.field_71990_ca && n4 != twgu.field_72053_aD.field_71990_ca && n4 != twgu.field_72055_aF.field_71990_ca && n4 != twgu.field_72040_aX.field_71990_ca) {
            if (n4 == 0) {
                return false;
            }
            tflj tflj2 = twgu.field_71973_m[n4].field_72018_cp;
            return tflj2 == tflj._D ? true : tflj2._c();
        }
        return true;
    }

    public int _b(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = this._e(ozlu2, n, n2, n3);
        if (n5 < 0) {
            return n4;
        }
        if (n5 == 0) {
            ++this._a;
        }
        if (n5 >= 8) {
            n5 = 0;
        }
        return n4 >= 0 && n5 >= n4 ? n4 : n5;
    }

    public boolean _d(ozlu ozlu2, int n, int n2, int n3) {
        tflj tflj2 = ozlu2.func_72803_f(n, n2, n3);
        return tflj2 == this.field_72018_cp ? false : (tflj2 == tflj._i ? false : !this._c(ozlu2, n, n2, n3));
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
    }

    @Override
    public boolean func_82506_l() {
        return true;
    }
}

