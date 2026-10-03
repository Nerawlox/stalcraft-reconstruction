/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jxtc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.ezfa;

public final class pkyq
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        eidj eidj2 = eidj._a()._a(n, n2, n3, n + 1, n2 + 1, n3 + 1);
        List list2 = ekuw2._a().func_82733_a(EntityLivingBase.class, eidj2, new jxtc(cvzo2));
        if (list2.size() > 0) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)list2.get(0);
            boolean bl = entityLivingBase instanceof EntityPlayer;
            int n4 = EntityLiving.func_82159_b(cvzo2);
            cvzo cvzo3 = cvzo2._l();
            cvzo3._b = 1;
            entityLivingBase.func_70062_b(n4, cvzo3);
            if (entityLivingBase instanceof EntityLiving) {
                ((EntityLiving)entityLivingBase).func_96120_a(n4, 2.0f);
            }
            --cvzo2._b;
            return cvzo2;
        }
        return super._b(ekuw2, cvzo2);
    }
}

