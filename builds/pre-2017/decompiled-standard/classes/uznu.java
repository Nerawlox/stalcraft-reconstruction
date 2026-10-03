/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class uznu
extends iwgt {
    public uznu(int n) {
        super(n, tflj._q);
        this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }

    @Override
    public int func_71857_b() {
        return -1;
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
        int n4 = sdrg2.func_72805_g(n, n2, n3) & 7;
        switch (n4) {
            default: {
                this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                break;
            }
            case 2: {
                this.func_71905_a(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                break;
            }
            case 3: {
                this.func_71905_a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                break;
            }
            case 4: {
                this.func_71905_a(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                break;
            }
            case 5: {
                this.func_71905_a(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
        }
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new fool();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_82799_bQ.field_77779_bT;
    }

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        return hurg2 != null && hurg2 instanceof fool ? ((fool)hurg2)._a() : super.func_71873_h(ozlu2, n, n2, n3);
    }

    @Override
    public int func_71899_b(int n) {
        return n;
    }

    @Override
    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (entityPlayer.field_71075_bZ._d) {
            ozlu2.func_72921_c(n, n2, n3, n4 |= 8, 4);
        }
        this.func_71897_c(ozlu2, n, n2, n3, n4, 0);
        super.func_71846_a(ozlu2, n, n2, n3, n4, entityPlayer);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        if ((n4 & 8) == 0) {
            cvzo cvzo2 = new cvzo(tgdv.field_82799_bQ.field_77779_bT, 1, this.func_71873_h(ozlu2, n, n2, n3));
            fool fool2 = (fool)ozlu2.func_72796_p(n, n2, n3);
            if (fool2 == null) {
                return arrayList;
            }
            if (fool2._a() == 3 && fool2._c() != null && fool2._c().length() > 0) {
                cvzo2._d(new qoac());
                cvzo2._q()._a("SkullOwner", fool2._c());
            }
            arrayList.add(cvzo2);
        }
        return arrayList;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_82799_bQ.field_77779_bT;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, fool fool2) {
        if (fool2._a() == 1 && n2 >= 2 && ozlu2.field_73013_u > 0 && !ozlu2.field_72995_K) {
            int n4;
            int n5 = twgu.field_72013_bc.field_71990_ca;
            for (n4 = -2; n4 <= 0; ++n4) {
                if (ozlu2.func_72798_a(n, n2 - 1, n3 + n4) != n5 || ozlu2.func_72798_a(n, n2 - 1, n3 + n4 + 1) != n5 || ozlu2.func_72798_a(n, n2 - 2, n3 + n4 + 1) != n5 || ozlu2.func_72798_a(n, n2 - 1, n3 + n4 + 2) != n5 || !this._a(ozlu2, n, n2, n3 + n4, 1) || !this._a(ozlu2, n, n2, n3 + n4 + 1, 1) || !this._a(ozlu2, n, n2, n3 + n4 + 2, 1)) continue;
                ozlu2.func_72921_c(n, n2, n3 + n4, 8, 2);
                ozlu2.func_72921_c(n, n2, n3 + n4 + 1, 8, 2);
                ozlu2.func_72921_c(n, n2, n3 + n4 + 2, 8, 2);
                ozlu2.func_72832_d(n, n2, n3 + n4, 0, 0, 2);
                ozlu2.func_72832_d(n, n2, n3 + n4 + 1, 0, 0, 2);
                ozlu2.func_72832_d(n, n2, n3 + n4 + 2, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 1, n3 + n4, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 1, n3 + n4 + 1, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 1, n3 + n4 + 2, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 2, n3 + n4 + 1, 0, 0, 2);
                if (!ozlu2.field_72995_K) {
                    EntityWither entityWither = new EntityWither(ozlu2);
                    entityWither.func_70012_b((double)n + 0.5, (double)n2 - 1.45, (double)(n3 + n4) + 1.5, 90.0f, 0.0f);
                    entityWither.field_70761_aq = 90.0f;
                    entityWither.func_82206_m();
                    ozlu2.func_72838_d(entityWither);
                }
                for (int i = 0; i < 120; ++i) {
                    ozlu2.func_72869_a("snowballpoof", (double)n + ozlu2.field_73012_v.nextDouble(), (double)(n2 - 2) + ozlu2.field_73012_v.nextDouble() * 3.9, (double)(n3 + n4 + 1) + ozlu2.field_73012_v.nextDouble(), 0.0, 0.0, 0.0);
                }
                ozlu2.func_72851_f(n, n2, n3 + n4, 0);
                ozlu2.func_72851_f(n, n2, n3 + n4 + 1, 0);
                ozlu2.func_72851_f(n, n2, n3 + n4 + 2, 0);
                ozlu2.func_72851_f(n, n2 - 1, n3 + n4, 0);
                ozlu2.func_72851_f(n, n2 - 1, n3 + n4 + 1, 0);
                ozlu2.func_72851_f(n, n2 - 1, n3 + n4 + 2, 0);
                ozlu2.func_72851_f(n, n2 - 2, n3 + n4 + 1, 0);
                return;
            }
            for (n4 = -2; n4 <= 0; ++n4) {
                if (ozlu2.func_72798_a(n + n4, n2 - 1, n3) != n5 || ozlu2.func_72798_a(n + n4 + 1, n2 - 1, n3) != n5 || ozlu2.func_72798_a(n + n4 + 1, n2 - 2, n3) != n5 || ozlu2.func_72798_a(n + n4 + 2, n2 - 1, n3) != n5 || !this._a(ozlu2, n + n4, n2, n3, 1) || !this._a(ozlu2, n + n4 + 1, n2, n3, 1) || !this._a(ozlu2, n + n4 + 2, n2, n3, 1)) continue;
                ozlu2.func_72921_c(n + n4, n2, n3, 8, 2);
                ozlu2.func_72921_c(n + n4 + 1, n2, n3, 8, 2);
                ozlu2.func_72921_c(n + n4 + 2, n2, n3, 8, 2);
                ozlu2.func_72832_d(n + n4, n2, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4 + 1, n2, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4 + 2, n2, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4, n2 - 1, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4 + 1, n2 - 1, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4 + 2, n2 - 1, n3, 0, 0, 2);
                ozlu2.func_72832_d(n + n4 + 1, n2 - 2, n3, 0, 0, 2);
                if (!ozlu2.field_72995_K) {
                    EntityWither entityWither = new EntityWither(ozlu2);
                    entityWither.func_70012_b((double)(n + n4) + 1.5, (double)n2 - 1.45, (double)n3 + 0.5, 0.0f, 0.0f);
                    entityWither.func_82206_m();
                    ozlu2.func_72838_d(entityWither);
                }
                for (int i = 0; i < 120; ++i) {
                    ozlu2.func_72869_a("snowballpoof", (double)(n + n4 + 1) + ozlu2.field_73012_v.nextDouble(), (double)(n2 - 2) + ozlu2.field_73012_v.nextDouble() * 3.9, (double)n3 + ozlu2.field_73012_v.nextDouble(), 0.0, 0.0, 0.0);
                }
                ozlu2.func_72851_f(n + n4, n2, n3, 0);
                ozlu2.func_72851_f(n + n4 + 1, n2, n3, 0);
                ozlu2.func_72851_f(n + n4 + 2, n2, n3, 0);
                ozlu2.func_72851_f(n + n4, n2 - 1, n3, 0);
                ozlu2.func_72851_f(n + n4 + 1, n2 - 1, n3, 0);
                ozlu2.func_72851_f(n + n4 + 2, n2 - 1, n3, 0);
                ozlu2.func_72851_f(n + n4 + 1, n2 - 2, n3, 0);
                return;
            }
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (ozlu2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return false;
        }
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        return hurg2 != null && hurg2 instanceof fool ? ((fool)hurg2)._a() == n4 : false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_72013_bc.func_71851_a(n);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public String func_94327_t_() {
        return this.func_111023_E() + "_" + kmmw._b[0];
    }
}

