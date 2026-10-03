/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.pibk;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;

public class pljx {
    public final yfgy field_85192_a;
    public final Random field_77187_a;
    public final pibk field_85191_c = new pibk();
    public final List field_85190_d = new ArrayList();

    public pljx(yfgy yfgy2) {
        this.field_85192_a = yfgy2;
        this.field_77187_a = new Random(yfgy2.func_72905_C());
    }

    public void func_77185_a(Entity entity, double d, double d2, double d3, float f) {
        if (this.field_85192_a.field_73011_w._i == 1) {
            int n = sajh._c(entity.field_70165_t);
            int n2 = sajh._c(entity.field_70163_u) - 1;
            int n3 = sajh._c(entity.field_70161_v);
            int n4 = 1;
            int n5 = 0;
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -1; k < 3; ++k) {
                        int n6 = n + j * n4 + i * n5;
                        int n7 = n2 + k;
                        int n8 = n3 + j * n5 - i * n4;
                        boolean bl = k < 0;
                        this.field_85192_a.func_94575_c(n6, n7, n8, bl ? twgu.field_72089_ap.field_71990_ca : 0);
                    }
                }
            }
            entity.func_70012_b(n, n2, n3, entity.field_70177_z, 0.0f);
            entity.field_70179_y = 0.0;
            entity.field_70181_x = 0.0;
            entity.field_70159_w = 0.0;
            return;
        }
        if (this.func_77184_b(entity, d, d2, d3, f)) {
            return;
        }
        this.func_85188_a(entity);
        this.func_77184_b(entity, d, d2, d3, f);
    }

    public boolean func_77184_b(Entity entity, double d, double d2, double d3, float f) {
        double d4;
        int n = 128;
        double d5 = -1.0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = sajh._c(entity.field_70165_t);
        int n6 = sajh._c(entity.field_70161_v);
        long l = jjym._a(n5, n6);
        boolean bl = true;
        if (this.field_85191_c._c(l)) {
            zifw zifw2 = (zifw)this.field_85191_c._b(l);
            d5 = 0.0;
            n2 = zifw2._a;
            n3 = zifw2._b;
            n4 = zifw2._c;
            zifw2._d = this.field_85192_a.func_82737_E();
            bl = false;
        } else {
            for (int i = n5 - n; i <= n5 + n; ++i) {
                double d6 = (double)i + 0.5 - entity.field_70165_t;
                for (int j = n6 - n; j <= n6 + n; ++j) {
                    double d7 = (double)j + 0.5 - entity.field_70161_v;
                    for (int k = this.field_85192_a.func_72940_L() - 1; k >= 0; --k) {
                        if (this.field_85192_a.func_72798_a(i, k, j) != twgu.field_72015_be.field_71990_ca) continue;
                        while (this.field_85192_a.func_72798_a(i, k - 1, j) == twgu.field_72015_be.field_71990_ca) {
                            --k;
                        }
                        d4 = (double)k + 0.5 - entity.field_70163_u;
                        double d8 = d6 * d6 + d4 * d4 + d7 * d7;
                        if (!(d5 < 0.0) && !(d8 < d5)) continue;
                        d5 = d8;
                        n2 = i;
                        n3 = k;
                        n4 = j;
                    }
                }
            }
        }
        if (d5 >= 0.0) {
            int n7 = n2;
            int n8 = n3;
            int n9 = n4;
            if (bl) {
                this.field_85191_c._a(l, new zifw(this, n7, n8, n9, this.field_85192_a.func_82737_E()));
                this.field_85190_d.add(l);
            }
            double d9 = (double)n7 + 0.5;
            double d10 = (double)n8 + 0.5;
            d4 = (double)n9 + 0.5;
            int n10 = -1;
            if (this.field_85192_a.func_72798_a(n7 - 1, n8, n9) == twgu.field_72015_be.field_71990_ca) {
                n10 = 2;
            }
            if (this.field_85192_a.func_72798_a(n7 + 1, n8, n9) == twgu.field_72015_be.field_71990_ca) {
                n10 = 0;
            }
            if (this.field_85192_a.func_72798_a(n7, n8, n9 - 1) == twgu.field_72015_be.field_71990_ca) {
                n10 = 3;
            }
            if (this.field_85192_a.func_72798_a(n7, n8, n9 + 1) == twgu.field_72015_be.field_71990_ca) {
                n10 = 1;
            }
            int n11 = entity.func_82148_at();
            if (n10 > -1) {
                boolean bl2;
                int n12 = ugqx._a[n10];
                int n13 = ugqx._h[n10];
                int n14 = ugqx._a[n13];
                int n15 = ugqx._b[n10];
                int n16 = ugqx._b[n13];
                boolean bl3 = !this.field_85192_a.func_72799_c(n7 + n12 + n14, n8, n9 + n15 + n16) || !this.field_85192_a.func_72799_c(n7 + n12 + n14, n8 + 1, n9 + n15 + n16);
                boolean bl4 = bl2 = !this.field_85192_a.func_72799_c(n7 + n12, n8, n9 + n15) || !this.field_85192_a.func_72799_c(n7 + n12, n8 + 1, n9 + n15);
                if (bl3 && bl2) {
                    n10 = ugqx._f[n10];
                    n13 = ugqx._f[n13];
                    n12 = ugqx._a[n10];
                    n15 = ugqx._b[n10];
                    n14 = ugqx._a[n13];
                    n16 = ugqx._b[n13];
                    d9 -= (double)n14;
                    d4 -= (double)n16;
                    bl3 = !this.field_85192_a.func_72799_c((n7 -= n14) + n12 + n14, n8, (n9 -= n16) + n15 + n16) || !this.field_85192_a.func_72799_c(n7 + n12 + n14, n8 + 1, n9 + n15 + n16);
                    bl2 = !this.field_85192_a.func_72799_c(n7 + n12, n8, n9 + n15) || !this.field_85192_a.func_72799_c(n7 + n12, n8 + 1, n9 + n15);
                }
                float f2 = 0.5f;
                float f3 = 0.5f;
                if (!bl3 && bl2) {
                    f2 = 1.0f;
                } else if (bl3 && !bl2) {
                    f2 = 0.0f;
                } else if (bl3 && bl2) {
                    f3 = 0.0f;
                }
                d9 += (double)((float)n14 * f2 + f3 * (float)n12);
                d4 += (double)((float)n16 * f2 + f3 * (float)n15);
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                float f7 = 0.0f;
                if (n10 == n11) {
                    f4 = 1.0f;
                    f5 = 1.0f;
                } else if (n10 == ugqx._f[n11]) {
                    f4 = -1.0f;
                    f5 = -1.0f;
                } else if (n10 == ugqx._g[n11]) {
                    f6 = 1.0f;
                    f7 = -1.0f;
                } else {
                    f6 = -1.0f;
                    f7 = 1.0f;
                }
                double d11 = entity.field_70159_w;
                double d12 = entity.field_70179_y;
                entity.field_70159_w = d11 * (double)f4 + d12 * (double)f7;
                entity.field_70179_y = d11 * (double)f6 + d12 * (double)f5;
                entity.field_70177_z = f - (float)(n11 * 90) + (float)(n10 * 90);
            } else {
                entity.field_70179_y = 0.0;
                entity.field_70181_x = 0.0;
                entity.field_70159_w = 0.0;
            }
            entity.func_70012_b(d9, d10, d4, entity.field_70177_z, entity.field_70125_A);
            return true;
        }
        return false;
    }

    public boolean func_85188_a(Entity entity) {
        double d;
        double d2;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        double d3;
        int n10;
        double d4;
        int n11;
        int n12 = 16;
        double d5 = -1.0;
        int n13 = sajh._c(entity.field_70165_t);
        int n14 = sajh._c(entity.field_70163_u);
        int n15 = sajh._c(entity.field_70161_v);
        int n16 = n13;
        int n17 = n14;
        int n18 = n15;
        int n19 = 0;
        int n20 = this.field_77187_a.nextInt(4);
        for (n11 = n13 - n12; n11 <= n13 + n12; ++n11) {
            d4 = (double)n11 + 0.5 - entity.field_70165_t;
            for (n10 = n15 - n12; n10 <= n15 + n12; ++n10) {
                d3 = (double)n10 + 0.5 - entity.field_70161_v;
                block2: for (n9 = this.field_85192_a.func_72940_L() - 1; n9 >= 0; --n9) {
                    if (!this.field_85192_a.func_72799_c(n11, n9, n10)) continue;
                    while (n9 > 0 && this.field_85192_a.func_72799_c(n11, n9 - 1, n10)) {
                        --n9;
                    }
                    for (n8 = n20; n8 < n20 + 4; ++n8) {
                        n7 = n8 % 2;
                        n6 = 1 - n7;
                        if (n8 % 4 >= 2) {
                            n7 = -n7;
                            n6 = -n6;
                        }
                        for (n5 = 0; n5 < 3; ++n5) {
                            for (n4 = 0; n4 < 4; ++n4) {
                                for (n3 = -1; n3 < 4; ++n3) {
                                    n2 = n11 + (n4 - 1) * n7 + n5 * n6;
                                    n = n9 + n3;
                                    int n21 = n10 + (n4 - 1) * n6 - n5 * n7;
                                    if (n3 < 0 && !this.field_85192_a.func_72803_f(n2, n, n21)._a() || n3 >= 0 && !this.field_85192_a.func_72799_c(n2, n, n21)) continue block2;
                                }
                            }
                        }
                        d2 = (double)n9 + 0.5 - entity.field_70163_u;
                        d = d4 * d4 + d2 * d2 + d3 * d3;
                        if (!(d5 < 0.0) && !(d < d5)) continue;
                        d5 = d;
                        n16 = n11;
                        n17 = n9;
                        n18 = n10;
                        n19 = n8 % 4;
                    }
                }
            }
        }
        if (d5 < 0.0) {
            for (n11 = n13 - n12; n11 <= n13 + n12; ++n11) {
                d4 = (double)n11 + 0.5 - entity.field_70165_t;
                for (n10 = n15 - n12; n10 <= n15 + n12; ++n10) {
                    d3 = (double)n10 + 0.5 - entity.field_70161_v;
                    block10: for (n9 = this.field_85192_a.func_72940_L() - 1; n9 >= 0; --n9) {
                        if (!this.field_85192_a.func_72799_c(n11, n9, n10)) continue;
                        while (n9 > 0 && this.field_85192_a.func_72799_c(n11, n9 - 1, n10)) {
                            --n9;
                        }
                        for (n8 = n20; n8 < n20 + 2; ++n8) {
                            n7 = n8 % 2;
                            n6 = 1 - n7;
                            for (n5 = 0; n5 < 4; ++n5) {
                                for (n4 = -1; n4 < 4; ++n4) {
                                    n3 = n11 + (n5 - 1) * n7;
                                    n2 = n9 + n4;
                                    n = n10 + (n5 - 1) * n6;
                                    if (n4 < 0 && !this.field_85192_a.func_72803_f(n3, n2, n)._a() || n4 >= 0 && !this.field_85192_a.func_72799_c(n3, n2, n)) continue block10;
                                }
                            }
                            d2 = (double)n9 + 0.5 - entity.field_70163_u;
                            d = d4 * d4 + d2 * d2 + d3 * d3;
                            if (!(d5 < 0.0) && !(d < d5)) continue;
                            d5 = d;
                            n16 = n11;
                            n17 = n9;
                            n18 = n10;
                            n19 = n8 % 2;
                        }
                    }
                }
            }
        }
        n11 = n19;
        int n22 = n16;
        int n23 = n17;
        n10 = n18;
        int n24 = n11 % 2;
        int n25 = 1 - n24;
        if (n11 % 4 >= 2) {
            n24 = -n24;
            n25 = -n25;
        }
        if (d5 < 0.0) {
            if (n17 < 70) {
                n17 = 70;
            }
            if (n17 > this.field_85192_a.func_72940_L() - 10) {
                n17 = this.field_85192_a.func_72940_L() - 10;
            }
            n23 = n17;
            for (n9 = -1; n9 <= 1; ++n9) {
                for (n8 = 1; n8 < 3; ++n8) {
                    for (n7 = -1; n7 < 3; ++n7) {
                        n6 = n22 + (n8 - 1) * n24 + n9 * n25;
                        n5 = n23 + n7;
                        n4 = n10 + (n8 - 1) * n25 - n9 * n24;
                        n3 = n7 < 0 ? 1 : 0;
                        this.field_85192_a.func_94575_c(n6, n5, n4, n3 != 0 ? twgu.field_72089_ap.field_71990_ca : 0);
                    }
                }
            }
        }
        for (n9 = 0; n9 < 4; ++n9) {
            for (n8 = 0; n8 < 4; ++n8) {
                for (n7 = -1; n7 < 4; ++n7) {
                    n6 = n22 + (n8 - 1) * n24;
                    n5 = n23 + n7;
                    n4 = n10 + (n8 - 1) * n25;
                    n3 = n8 == 0 || n8 == 3 || n7 == -1 || n7 == 3 ? 1 : 0;
                    this.field_85192_a.func_72832_d(n6, n5, n4, n3 != 0 ? twgu.field_72089_ap.field_71990_ca : twgu.field_72015_be.field_71990_ca, 0, 2);
                }
            }
            for (n8 = 0; n8 < 4; ++n8) {
                for (n7 = -1; n7 < 4; ++n7) {
                    n6 = n22 + (n8 - 1) * n24;
                    n5 = n23 + n7;
                    n4 = n10 + (n8 - 1) * n25;
                    this.field_85192_a.func_72898_h(n6, n5, n4, this.field_85192_a.func_72798_a(n6, n5, n4));
                }
            }
        }
        return true;
    }

    public void func_85189_a(long l) {
        if (l % 100L == 0L) {
            Iterator iterator2 = this.field_85190_d.iterator();
            long l2 = l - 600L;
            while (iterator2.hasNext()) {
                Long l3 = (Long)iterator2.next();
                zifw zifw2 = (zifw)this.field_85191_c._b(l3);
                if (zifw2 != null && zifw2._d >= l2) continue;
                iterator2.remove();
                this.field_85191_c._e(l3);
            }
        }
    }
}

