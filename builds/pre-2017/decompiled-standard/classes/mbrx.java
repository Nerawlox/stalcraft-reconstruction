/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.zwaw;
import net.minecraft.util.amww;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;

public class mbrx
extends tgdv {
    public dwan _a;

    public mbrx(int n) {
        super(n);
        this.func_77627_a(true);
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public String func_77628_j(cvzo cvzo2) {
        String string = ("" + tdpx._a(this.func_77658_a() + ".name")).trim();
        String string2 = jgro._b(cvzo2._j());
        if (string2 != null) {
            string = string + " " + tdpx._a("entity." + string2 + ".name");
        }
        return string;
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        zwaw zwaw2 = (zwaw)jgro._f.get(cvzo2._j());
        if (zwaw2 != null) {
            if (n == 0) {
                return zwaw2._b;
            }
            return zwaw2._c;
        }
        return 0xFFFFFF;
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    @Override
    public dwan func_77618_c(int n, int n2) {
        if (n2 > 0) {
            return this._a;
        }
        return super.func_77618_c(n, n2);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Entity entity;
        if (ozlu2.field_72995_K) {
            return true;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        n += owak._b[n4];
        n2 += owak._c[n4];
        n3 += owak._d[n4];
        double d = 0.0;
        if (n4 == 1 && twgu.field_71973_m[n5] != null && twgu.field_71973_m[n5].func_71857_b() == 11) {
            d = 0.5;
        }
        if ((entity = mbrx._a(ozlu2, cvzo2._j(), (double)n + 0.5, (double)n2 + d, (double)n3 + 0.5)) != null) {
            if (entity instanceof EntityLivingBase && cvzo2._u()) {
                ((EntityLiving)entity).func_94058_c(cvzo2._s());
            }
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
        }
        return true;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (ozlu2.field_72995_K) {
            return cvzo2;
        }
        hank hank2 = this.func_77621_a(ozlu2, entityPlayer, true);
        if (hank2 == null) {
            return cvzo2;
        }
        if (hank2._c == amww._a) {
            Entity entity;
            int n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            if (!ozlu2.func_72962_a(entityPlayer, n, n2, n3)) {
                return cvzo2;
            }
            if (!entityPlayer.func_82247_a(n, n2, n3, hank2._g, cvzo2)) {
                return cvzo2;
            }
            if (ozlu2.func_72803_f(n, n2, n3) == tflj._h && (entity = mbrx._a(ozlu2, cvzo2._j(), n, n2, n3)) != null) {
                if (entity instanceof EntityLivingBase && cvzo2._u()) {
                    ((EntityLiving)entity).func_94058_c(cvzo2._s());
                }
                if (!entityPlayer.field_71075_bZ._d) {
                    --cvzo2._b;
                }
            }
        }
        return cvzo2;
    }

    public static Entity _a(ozlu ozlu2, int n, double d, double d2, double d3) {
        if (!jgro._f.containsKey(n)) {
            return null;
        }
        Entity entity = null;
        for (int i = 0; i < 1; ++i) {
            entity = jgro._a(n, ozlu2);
            if (entity == null || !(entity instanceof EntityLivingBase)) continue;
            EntityLiving entityLiving = (EntityLiving)entity;
            entity.func_70012_b(d, d2, d3, sajh._g(ozlu2.field_73012_v.nextFloat() * 360.0f), 0.0f);
            entityLiving.field_70759_as = entityLiving.field_70177_z;
            entityLiving.field_70761_aq = entityLiving.field_70177_z;
            entityLiving.func_110161_a(null);
            ozlu2.func_72838_d(entity);
            entityLiving.func_70642_aH();
        }
        return entity;
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        for (zwaw zwaw2 : jgro._f.values()) {
            list2.add(new cvzo(n, 1, zwaw2._a));
        }
    }

    @Override
    public void func_94581_a(nege nege2) {
        super.func_94581_a(nege2);
        this._a = nege2._b(this.func_111208_A() + "_overlay");
    }
}

