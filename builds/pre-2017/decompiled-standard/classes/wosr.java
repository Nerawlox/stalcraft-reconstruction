/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class wosr
extends gqau {
    public boolean _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;
    @SideOnly(value=Side.CLIENT)
    public dwan _c;

    public wosr(int n, boolean bl) {
        super(n, tflj._B);
        this.func_71907_b(true);
        this._a = bl;
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n == 1 ? this._b : (n == 0 ? this._b : (n2 == 2 && n == 2 ? this._c : (n2 == 3 && n == 5 ? this._c : (n2 == 0 && n == 3 ? this._c : (n2 == 1 && n == 4 ? this._c : this.field_94336_cN)))));
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        if (ozlu2.func_72798_a(n, n2 - 1, n3) == twgu.field_72039_aU.field_71990_ca && ozlu2.func_72798_a(n, n2 - 2, n3) == twgu.field_72039_aU.field_71990_ca) {
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72832_d(n, n2, n3, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 1, n3, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 2, n3, 0, 0, 2);
                EntitySnowman entitySnowman = new EntitySnowman(ozlu2);
                entitySnowman.func_70012_b((double)n + 0.5, (double)n2 - 1.95, (double)n3 + 0.5, 0.0f, 0.0f);
                ozlu2.func_72838_d(entitySnowman);
                ozlu2.func_72851_f(n, n2, n3, 0);
                ozlu2.func_72851_f(n, n2 - 1, n3, 0);
                ozlu2.func_72851_f(n, n2 - 2, n3, 0);
            }
            for (int i = 0; i < 120; ++i) {
                ozlu2.func_72869_a("snowshovel", (double)n + ozlu2.field_73012_v.nextDouble(), (double)(n2 - 2) + ozlu2.field_73012_v.nextDouble() * 2.5, (double)n3 + ozlu2.field_73012_v.nextDouble(), 0.0, 0.0, 0.0);
            }
        } else if (ozlu2.func_72798_a(n, n2 - 1, n3) == twgu.field_72083_ai.field_71990_ca && ozlu2.func_72798_a(n, n2 - 2, n3) == twgu.field_72083_ai.field_71990_ca) {
            boolean bl;
            boolean bl2 = ozlu2.func_72798_a(n - 1, n2 - 1, n3) == twgu.field_72083_ai.field_71990_ca && ozlu2.func_72798_a(n + 1, n2 - 1, n3) == twgu.field_72083_ai.field_71990_ca;
            boolean bl3 = bl = ozlu2.func_72798_a(n, n2 - 1, n3 - 1) == twgu.field_72083_ai.field_71990_ca && ozlu2.func_72798_a(n, n2 - 1, n3 + 1) == twgu.field_72083_ai.field_71990_ca;
            if (bl2 || bl) {
                ozlu2.func_72832_d(n, n2, n3, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 1, n3, 0, 0, 2);
                ozlu2.func_72832_d(n, n2 - 2, n3, 0, 0, 2);
                if (bl2) {
                    ozlu2.func_72832_d(n - 1, n2 - 1, n3, 0, 0, 2);
                    ozlu2.func_72832_d(n + 1, n2 - 1, n3, 0, 0, 2);
                } else {
                    ozlu2.func_72832_d(n, n2 - 1, n3 - 1, 0, 0, 2);
                    ozlu2.func_72832_d(n, n2 - 1, n3 + 1, 0, 0, 2);
                }
                EntityIronGolem entityIronGolem = new EntityIronGolem(ozlu2);
                entityIronGolem.func_70849_f(true);
                entityIronGolem.func_70012_b((double)n + 0.5, (double)n2 - 1.95, (double)n3 + 0.5, 0.0f, 0.0f);
                ozlu2.func_72838_d(entityIronGolem);
                for (int i = 0; i < 120; ++i) {
                    ozlu2.func_72869_a("snowballpoof", (double)n + ozlu2.field_73012_v.nextDouble(), (double)(n2 - 2) + ozlu2.field_73012_v.nextDouble() * 3.9, (double)n3 + ozlu2.field_73012_v.nextDouble(), 0.0, 0.0, 0.0);
                }
                ozlu2.func_72851_f(n, n2, n3, 0);
                ozlu2.func_72851_f(n, n2 - 1, n3, 0);
                ozlu2.func_72851_f(n, n2 - 2, n3, 0);
                if (bl2) {
                    ozlu2.func_72851_f(n - 1, n2 - 1, n3, 0);
                    ozlu2.func_72851_f(n + 1, n2 - 1, n3, 0);
                } else {
                    ozlu2.func_72851_f(n, n2 - 1, n3 - 1, 0);
                    ozlu2.func_72851_f(n, n2 - 1, n3 + 1, 0);
                }
            }
        }
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        twgu twgu2 = twgu.field_71973_m[n4];
        return (twgu2 == null || twgu2.isBlockReplaceable(ozlu2, n, n2, n3)) && ozlu2.func_72797_t(n, n2 - 1, n3);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._c = nege2._b(this.func_111023_E() + "_face_" + (this._a ? "on" : "off"));
        this._b = nege2._b(this.func_111023_E() + "_top");
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
    }
}

