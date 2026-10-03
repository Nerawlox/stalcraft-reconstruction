/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.iurn;
import net.minecraftforge.common.ForgeDirection;

public class zzie
implements sdrg {
    public int _a;
    public int _b;
    public ixzi[][] _c;
    public boolean _d;
    public ozlu _e;

    public zzie(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        ixzi ixzi2;
        int n8;
        int n9;
        this._e = ozlu2;
        this._a = n - n7 >> 4;
        this._b = n3 - n7 >> 4;
        int n10 = n4 + n7 >> 4;
        int n11 = n6 + n7 >> 4;
        this._c = new ixzi[n10 - this._a + 1][n11 - this._b + 1];
        this._d = true;
        for (n9 = this._a; n9 <= n10; ++n9) {
            for (n8 = this._b; n8 <= n11; ++n8) {
                ixzi2 = ozlu2.func_72964_e(n9, n8);
                if (ixzi2 == null) continue;
                this._c[n9 - this._a][n8 - this._b] = ixzi2;
            }
        }
        for (n9 = n >> 4; n9 <= n4 >> 4; ++n9) {
            for (n8 = n3 >> 4; n8 <= n6 >> 4; ++n8) {
                ixzi2 = this._c[n9 - this._a][n8 - this._b];
                if (ixzi2 == null || ixzi2._e(n2, n5)) continue;
                this._d = false;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_72806_N() {
        return this._d;
    }

    @Override
    public int func_72798_a(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            return 0;
        }
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            ixzi ixzi2 = this._c[n4][n5];
            return ixzi2 == null ? 0 : ixzi2._d(n & 0xF, n2, n3 & 0xF);
        }
        return 0;
    }

    @Override
    public hurg func_72796_p(int n, int n2, int n3) {
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            ixzi ixzi2 = this._c[n4][n5];
            return ixzi2 == null ? null : ixzi2._g(n & 0xF, n2, n3 & 0xF);
        }
        return null;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_72808_j(int n, int n2, int n3, int n4) {
        int n5 = this._a(n, n2, n3);
        if (n5 < n4) {
            n5 = n4;
        }
        return this._e.field_73011_w._h[n5];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_72802_i(int n, int n2, int n3, int n4) {
        int n5 = this._a(rrqi._a, n, n2, n3);
        int n6 = this._a(rrqi._b, n, n2, n3);
        if (n6 < n4) {
            n6 = n4;
        }
        return n5 << 20 | n6 << 4;
    }

    @Override
    public int func_72805_g(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            return 0;
        }
        int n4 = (n >> 4) - this._a;
        int n5 = (n3 >> 4) - this._b;
        if (n4 >= 0 && n4 < this._c.length && n5 >= 0 && n5 < this._c[n4].length) {
            ixzi ixzi2 = this._c[n4][n5];
            return ixzi2 == null ? 0 : ixzi2._e(n & 0xF, n2, n3 & 0xF);
        }
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_72801_o(int n, int n2, int n3) {
        return this._e.field_73011_w._h[this._a(n, n2, n3)];
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2, int n3) {
        return this._a(n, n2, n3, true);
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            int n4;
            if (bl && ((n4 = this.func_72798_a(n, n2, n3)) == twgu.field_72079_ak.field_71990_ca || n4 == twgu.field_72092_bO.field_71990_ca || n4 == twgu.field_72050_aA.field_71990_ca || n4 == twgu.field_72063_at.field_71990_ca || n4 == twgu.field_72057_aH.field_71990_ca)) {
                int n5 = this._a(n, n2 + 1, n3, false);
                int n6 = this._a(n + 1, n2, n3, false);
                int n7 = this._a(n - 1, n2, n3, false);
                int n8 = this._a(n, n2, n3 + 1, false);
                int n9 = this._a(n, n2, n3 - 1, false);
                if (n6 > n5) {
                    n5 = n6;
                }
                if (n7 > n5) {
                    n5 = n7;
                }
                if (n8 > n5) {
                    n5 = n8;
                }
                if (n9 > n5) {
                    n5 = n9;
                }
                return n5;
            }
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                n4 = 15 - this._e.field_73008_k;
                if (n4 < 0) {
                    n4 = 0;
                }
                return n4;
            }
            n4 = (n >> 4) - this._a;
            int n10 = (n3 >> 4) - this._b;
            return this._c[n4][n10]._c(n & 0xF, n2, n3 & 0xF, this._e.field_73008_k);
        }
        return 15;
    }

    @Override
    public tflj func_72803_f(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        return n4 == 0 ? tflj._a : twgu.field_71973_m[n4].field_72018_cp;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public foqh func_72807_a(int n, int n2) {
        return this._e.func_72807_a(n, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_72804_r(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        return twgu2 == null ? false : twgu2.func_71926_d();
    }

    @Override
    public boolean func_72809_s(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        return twgu2 == null ? false : twgu2.field_72018_cp._c() && twgu2.func_71886_c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_72797_t(int n, int n2, int n3) {
        return this._e.func_72797_t(n, n2, n3);
    }

    @Override
    public iurn func_82732_R() {
        return this._e.func_82732_R();
    }

    @Override
    public boolean func_72799_c(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        return n4 == 0 || twgu.field_71973_m[n4] == null || twgu.field_71973_m[n4].isAirBlock(this._e, n, n2, n3);
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(rrqi rrqi2, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n2 >= 0 && n2 < 256 && n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            if (rrqi2 == rrqi._a && this._e.field_73011_w._g) {
                return 0;
            }
            if (twgu.field_71982_s[this.func_72798_a(n, n2, n3)]) {
                int n4 = this._b(rrqi2, n, n2 + 1, n3);
                int n5 = this._b(rrqi2, n + 1, n2, n3);
                int n6 = this._b(rrqi2, n - 1, n2, n3);
                int n7 = this._b(rrqi2, n, n2, n3 + 1);
                int n8 = this._b(rrqi2, n, n2, n3 - 1);
                if (n5 > n4) {
                    n4 = n5;
                }
                if (n6 > n4) {
                    n4 = n6;
                }
                if (n7 > n4) {
                    n4 = n7;
                }
                if (n8 > n4) {
                    n4 = n8;
                }
                return n4;
            }
            int n9 = (n >> 4) - this._a;
            int n10 = (n3 >> 4) - this._b;
            return this._c[n9][n10]._a(rrqi2, n & 0xF, n2, n3 & 0xF);
        }
        return rrqi2._c;
    }

    @SideOnly(value=Side.CLIENT)
    public int _b(rrqi rrqi2, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n2 >= 0 && n2 < 256 && n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 <= 30000000) {
            int n4 = (n >> 4) - this._a;
            int n5 = (n3 >> 4) - this._b;
            return this._c[n4][n5]._a(rrqi2, n & 0xF, n2, n3 & 0xF);
        }
        return rrqi2._c;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_72800_K() {
        return 256;
    }

    @Override
    public int func_72879_k(int n, int n2, int n3, int n4) {
        int n5 = this.func_72798_a(n, n2, n3);
        return n5 == 0 ? 0 : twgu.field_71973_m[n5].func_71855_c(this, n, n2, n3, n4);
    }

    @Override
    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection, boolean bl) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return bl;
        }
        int n4 = this.func_72798_a(n, n2, n3);
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 != null) {
            return twgu2.isBlockSolidOnSide(this._e, n, n2, n3, forgeDirection);
        }
        return false;
    }
}

