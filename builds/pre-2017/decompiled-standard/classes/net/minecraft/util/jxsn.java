/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.tdpx;
import net.minecraft.util.vjta;
import net.minecraft.util.zwat;

public class jxsn
extends vjta {
    public Entity field_76387_p;

    public jxsn(String string, Entity entity, Entity entity2) {
        super(string, entity);
        this.field_76387_p = entity2;
    }

    @Override
    public Entity func_76364_f() {
        return this.field_76386_o;
    }

    @Override
    public Entity func_76346_g() {
        return this.field_76387_p;
    }

    @Override
    public zwat func_76360_b(EntityLivingBase entityLivingBase) {
        String string = this.field_76387_p == null ? this.field_76386_o.func_96090_ax() : this.field_76387_p.func_96090_ax();
        cvzo cvzo2 = this.field_76387_p instanceof EntityLivingBase ? ((EntityLivingBase)this.field_76387_p).func_70694_bm() : null;
        String string2 = "death.attack." + this.field_76373_n;
        String string3 = string2 + ".item";
        if (cvzo2 != null && cvzo2._u() && tdpx._b(string3)) {
            return zwat._b(string3, entityLivingBase.func_96090_ax(), string, cvzo2._s());
        }
        return zwat._b(string2, entityLivingBase.func_96090_ax(), string);
    }
}

