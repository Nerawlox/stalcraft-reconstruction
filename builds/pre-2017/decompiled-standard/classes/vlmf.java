/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;

public class vlmf
extends dgwv {
    public vlmf(int n) {
        super(n, "portal", tflj._D, false);
        this.func_71907_b(true);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        super.func_71847_b(ozlu2, n, n2, n3, random);
        if (ozlu2.field_73011_w._d() && random.nextInt(2000) < ozlu2.field_73013_u) {
            Entity entity;
            int n4;
            for (n4 = n2; !ozlu2.func_72797_t(n, n4, n3) && n4 > 0; --n4) {
            }
            if (n4 > 0 && !ozlu2.func_72809_s(n, n4 + 1, n3) && (entity = mbrx._a(ozlu2, 57, (double)n + 0.5, (double)n4 + 1.1, (double)n3 + 0.5)) != null) {
                entity.field_71088_bW = entity.func_82147_ab();
            }
        }
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72798_a(n - 1, n2, n3) != this.field_71990_ca && sdrg2.func_72798_a(n + 1, n2, n3) != this.field_71990_ca) {
            float f = 0.125f;
            float f2 = 0.5f;
            this.func_71905_a(0.5f - f, 0.0f, 0.5f - f2, 0.5f + f, 1.0f, 0.5f + f2);
        } else {
            float f = 0.5f;
            float f3 = 0.125f;
            this.func_71905_a(0.5f - f, 0.0f, 0.5f - f3, 0.5f + f, 1.0f, 0.5f + f3);
        }
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = 0;
        int n7 = 0;
        if (ozlu2.func_72798_a(n - 1, n2, n3) == twgu.field_72089_ap.field_71990_ca || ozlu2.func_72798_a(n + 1, n2, n3) == twgu.field_72089_ap.field_71990_ca) {
            n6 = 1;
        }
        if (ozlu2.func_72798_a(n, n2, n3 - 1) == twgu.field_72089_ap.field_71990_ca || ozlu2.func_72798_a(n, n2, n3 + 1) == twgu.field_72089_ap.field_71990_ca) {
            n7 = 1;
        }
        if (n6 == n7) {
            return false;
        }
        if (ozlu2.func_72799_c(n - n6, n2, n3 - n7)) {
            n -= n6;
            n3 -= n7;
        }
        for (n5 = -1; n5 <= 2; ++n5) {
            for (n4 = -1; n4 <= 3; ++n4) {
                boolean bl;
                boolean bl2 = bl = n5 == -1 || n5 == 2 || n4 == -1 || n4 == 3;
                if ((n5 == -1 || n5 == 2) && (n4 == -1 || n4 == 3)) continue;
                int n8 = ozlu2.func_72798_a(n + n6 * n5, n2 + n4, n3 + n7 * n5);
                boolean bl3 = ozlu2.func_72799_c(n + n6 * n5, n2 + n4, n3 + n7 * n5);
                if (!(bl ? n8 != twgu.field_72089_ap.field_71990_ca : !bl3 && n8 != twgu.field_72067_ar.field_71990_ca)) continue;
                return false;
            }
        }
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                ozlu2.func_72832_d(n + n6 * n5, n2 + n4, n3 + n7 * n5, twgu.field_72015_be.field_71990_ca, 0, 2);
            }
        }
        return true;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 1;
        if (ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca || ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca) {
            n5 = 1;
            n6 = 0;
        }
        int n7 = n2;
        while (ozlu2.func_72798_a(n, n7 - 1, n3) == this.field_71990_ca) {
            --n7;
        }
        if (ozlu2.func_72798_a(n, n7 - 1, n3) != twgu.field_72089_ap.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
        } else {
            int n8;
            for (n8 = 1; n8 < 4 && ozlu2.func_72798_a(n, n7 + n8, n3) == this.field_71990_ca; ++n8) {
            }
            if (n8 == 3 && ozlu2.func_72798_a(n, n7 + n8, n3) == twgu.field_72089_ap.field_71990_ca) {
                boolean bl;
                boolean bl2 = ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca || ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca;
                boolean bl3 = bl = ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca || ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca;
                if (bl2 && bl) {
                    ozlu2.func_94571_i(n, n2, n3);
                } else if (!(ozlu2.func_72798_a(n + n5, n2, n3 + n6) == twgu.field_72089_ap.field_71990_ca && ozlu2.func_72798_a(n - n5, n2, n3 - n6) == this.field_71990_ca || ozlu2.func_72798_a(n - n5, n2, n3 - n6) == twgu.field_72089_ap.field_71990_ca && ozlu2.func_72798_a(n + n5, n2, n3 + n6) == this.field_71990_ca)) {
                    ozlu2.func_94571_i(n, n2, n3);
                }
            } else {
                ozlu2.func_94571_i(n, n2, n3);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        boolean bl;
        if (sdrg2.func_72798_a(n, n2, n3) == this.field_71990_ca) {
            return false;
        }
        boolean bl2 = sdrg2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca && sdrg2.func_72798_a(n - 2, n2, n3) != this.field_71990_ca;
        boolean bl3 = sdrg2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca && sdrg2.func_72798_a(n + 2, n2, n3) != this.field_71990_ca;
        boolean bl4 = sdrg2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca && sdrg2.func_72798_a(n, n2, n3 - 2) != this.field_71990_ca;
        boolean bl5 = sdrg2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca && sdrg2.func_72798_a(n, n2, n3 + 2) != this.field_71990_ca;
        boolean bl6 = bl2 || bl3;
        boolean bl7 = bl = bl4 || bl5;
        return bl6 && n4 == 4 ? true : (bl6 && n4 == 5 ? true : (bl && n4 == 2 ? true : bl && n4 == 3));
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (entity.field_70154_o == null && entity.field_70153_n == null) {
            entity.func_70063_aa();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (random.nextInt(100) == 0) {
            ozlu2.func_72980_b((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "portal.portal", 0.5f, random.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int i = 0; i < 4; ++i) {
            double d = (float)n + random.nextFloat();
            double d2 = (float)n2 + random.nextFloat();
            double d3 = (float)n3 + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            int n4 = random.nextInt(2) * 2 - 1;
            d4 = ((double)random.nextFloat() - 0.5) * 0.5;
            d5 = ((double)random.nextFloat() - 0.5) * 0.5;
            d6 = ((double)random.nextFloat() - 0.5) * 0.5;
            if (ozlu2.func_72798_a(n - 1, n2, n3) != this.field_71990_ca && ozlu2.func_72798_a(n + 1, n2, n3) != this.field_71990_ca) {
                d = (double)n + 0.5 + 0.25 * (double)n4;
                d4 = random.nextFloat() * 2.0f * (float)n4;
            } else {
                d3 = (double)n3 + 0.5 + 0.25 * (double)n4;
                d6 = random.nextFloat() * 2.0f * (float)n4;
            }
            ozlu2.func_72869_a("portal", d, d2, d3, d4, d5, d6);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }
}

