/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.ugqx;
import net.minecraftforge.common.IShearable;

public class lort
extends twgu
implements IShearable {
    public lort(int n) {
        super(n, tflj._l);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public int func_71857_b() {
        return 20;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        boolean bl;
        float f = 0.0625f;
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        float f2 = 1.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl2 = bl = n4 > 0;
        if ((n4 & 2) != 0) {
            f5 = Math.max(f5, 0.0625f);
            f2 = 0.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            bl = true;
        }
        if ((n4 & 8) != 0) {
            f2 = Math.min(f2, 0.9375f);
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            bl = true;
        }
        if ((n4 & 4) != 0) {
            f7 = Math.max(f7, 0.0625f);
            f4 = 0.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            bl = true;
        }
        if ((n4 & 1) != 0) {
            f4 = Math.min(f4, 0.9375f);
            f7 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            bl = true;
        }
        if (!bl && this._a(sdrg2.func_72798_a(n, n2 + 1, n3))) {
            f3 = Math.min(f3, 0.9375f);
            f6 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
        }
        this.func_71905_a(f2, f3, f4, f5, f6, f7);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        switch (n4) {
            case 1: {
                return this._a(ozlu2.func_72798_a(n, n2 + 1, n3));
            }
            case 2: {
                return this._a(ozlu2.func_72798_a(n, n2, n3 + 1));
            }
            case 3: {
                return this._a(ozlu2.func_72798_a(n, n2, n3 - 1));
            }
            case 4: {
                return this._a(ozlu2.func_72798_a(n + 1, n2, n3));
            }
            case 5: {
                return this._a(ozlu2.func_72798_a(n - 1, n2, n3));
            }
        }
        return false;
    }

    public boolean _a(int n) {
        if (n == 0) {
            return false;
        }
        twgu twgu2 = twgu.field_71973_m[n];
        return twgu2.func_71886_c() && twgu2.field_72018_cp._c();
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5 = n4 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 > 0) {
            for (int i = 0; i <= 3; ++i) {
                int n6 = 1 << i;
                if ((n4 & n6) == 0 || this._a(ozlu2.func_72798_a(n + ugqx._a[i], n2, n3 + ugqx._b[i])) || ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca && (ozlu2.func_72805_g(n, n2 + 1, n3) & n6) != 0) continue;
                n5 &= ~n6;
            }
        }
        if (n5 == 0 && !this._a(ozlu2.func_72798_a(n, n2 + 1, n3))) {
            return false;
        }
        if (n5 != n4) {
            ozlu2.func_72921_c(n, n2, n3, n5, 2);
        }
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        return igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71889_f_(int n) {
        return igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72807_a(n, n3)._m();
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K && !this._a(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K && ozlu2.field_73012_v.nextInt(4) == 0) {
            int n4;
            int n5;
            int n6;
            int n7 = 4;
            int n8 = 5;
            boolean bl = false;
            block0: for (n6 = n - n7; n6 <= n + n7; ++n6) {
                for (n5 = n3 - n7; n5 <= n3 + n7; ++n5) {
                    for (n4 = n2 - 1; n4 <= n2 + 1; ++n4) {
                        if (ozlu2.func_72798_a(n6, n4, n5) != this.field_71990_ca || --n8 > 0) continue;
                        bl = true;
                        break block0;
                    }
                }
            }
            n6 = ozlu2.func_72805_g(n, n2, n3);
            n5 = ozlu2.field_73012_v.nextInt(6);
            n4 = ugqx._e[n5];
            if (n5 == 1 && n2 < 255 && ozlu2.func_72799_c(n, n2 + 1, n3)) {
                if (bl) {
                    return;
                }
                int n9 = ozlu2.field_73012_v.nextInt(16) & n6;
                if (n9 > 0) {
                    for (int i = 0; i <= 3; ++i) {
                        if (this._a(ozlu2.func_72798_a(n + ugqx._a[i], n2 + 1, n3 + ugqx._b[i]))) continue;
                        n9 &= ~(1 << i);
                    }
                    if (n9 > 0) {
                        ozlu2.func_72832_d(n, n2 + 1, n3, this.field_71990_ca, n9, 2);
                    }
                }
            } else if (n5 >= 2 && n5 <= 5 && (n6 & 1 << n4) == 0) {
                if (bl) {
                    return;
                }
                int n10 = ozlu2.func_72798_a(n + ugqx._a[n4], n2, n3 + ugqx._b[n4]);
                if (n10 != 0 && twgu.field_71973_m[n10] != null) {
                    if (twgu.field_71973_m[n10].field_72018_cp._k() && twgu.field_71973_m[n10].func_71886_c()) {
                        ozlu2.func_72921_c(n, n2, n3, n6 | 1 << n4, 2);
                    }
                } else {
                    int n11 = n4 + 1 & 3;
                    int n12 = n4 + 3 & 3;
                    if ((n6 & 1 << n11) != 0 && this._a(ozlu2.func_72798_a(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11]))) {
                        ozlu2.func_72832_d(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.field_71990_ca, 1 << n11, 2);
                    } else if ((n6 & 1 << n12) != 0 && this._a(ozlu2.func_72798_a(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12]))) {
                        ozlu2.func_72832_d(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.field_71990_ca, 1 << n12, 2);
                    } else if ((n6 & 1 << n11) != 0 && ozlu2.func_72799_c(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11]) && this._a(ozlu2.func_72798_a(n + ugqx._a[n11], n2, n3 + ugqx._b[n11]))) {
                        ozlu2.func_72832_d(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11], this.field_71990_ca, 1 << (n4 + 2 & 3), 2);
                    } else if ((n6 & 1 << n12) != 0 && ozlu2.func_72799_c(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12]) && this._a(ozlu2.func_72798_a(n + ugqx._a[n12], n2, n3 + ugqx._b[n12]))) {
                        ozlu2.func_72832_d(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12], this.field_71990_ca, 1 << (n4 + 2 & 3), 2);
                    } else if (this._a(ozlu2.func_72798_a(n + ugqx._a[n4], n2 + 1, n3 + ugqx._b[n4]))) {
                        ozlu2.func_72832_d(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.field_71990_ca, 0, 2);
                    }
                }
            } else if (n2 > 1) {
                int n13 = ozlu2.func_72798_a(n, n2 - 1, n3);
                if (n13 == 0) {
                    int n14 = ozlu2.field_73012_v.nextInt(16) & n6;
                    if (n14 > 0) {
                        ozlu2.func_72832_d(n, n2 - 1, n3, this.field_71990_ca, n14, 2);
                    }
                } else if (n13 == this.field_71990_ca) {
                    int n15 = ozlu2.field_73012_v.nextInt(16) & n6;
                    int n16 = ozlu2.func_72805_g(n, n2 - 1, n3);
                    if (n16 != (n16 | n15)) {
                        ozlu2.func_72921_c(n, n2 - 1, n3, n16 | n15, 2);
                    }
                }
            }
        }
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        switch (n4) {
            case 2: {
                n6 = 1;
                break;
            }
            case 3: {
                n6 = 4;
                break;
            }
            case 4: {
                n6 = 8;
                break;
            }
            case 5: {
                n6 = 2;
            }
        }
        return n6 != 0 ? n6 : n5;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.func_71893_a(ozlu2, entityPlayer, n, n2, n3, n4);
    }

    @Override
    public boolean isShearable(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<cvzo> onSheared(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        arrayList.add(new cvzo(this, 1, 0));
        return arrayList;
    }

    @Override
    public boolean isLadder(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return true;
    }
}

