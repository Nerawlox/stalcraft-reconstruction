/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class EntityLeashKnot
extends EntityHanging {
    public EntityLeashKnot(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityLeashKnot(ozlu ozlu2, int n, int n2, int n3) {
        super(ozlu2, n, n2, n3, 0);
        this.func_70107_b((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
    }

    @Override
    public void func_82328_a(int n) {
    }

    @Override
    public int func_82329_d() {
        return 9;
    }

    @Override
    public int func_82330_g() {
        return 9;
    }

    @Override
    public boolean func_70112_a(double d) {
        return d < 1024.0;
    }

    @Override
    public void func_110128_b(Entity entity) {
    }

    @Override
    public boolean func_70039_c(qoac qoac2) {
        return false;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    public void func_70037_a(qoac qoac2) {
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        List list2;
        double d;
        cvzo cvzo2 = entityPlayer.func_70694_bm();
        boolean bl = false;
        if (cvzo2 != null && cvzo2._d == tgdv.field_111214_ch.field_77779_bT && !this.field_70170_p.field_72995_K) {
            d = 7.0;
            list2 = this.field_70170_p.func_72872_a(EntityLiving.class, eidj._a()._a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + d, this.field_70161_v + d));
            if (list2 != null) {
                for (EntityLiving entityLiving : list2) {
                    if (!entityLiving.func_110167_bD() || entityLiving.func_110166_bE() != entityPlayer) continue;
                    entityLiving.func_110162_b(this, true);
                    bl = true;
                }
            }
        }
        if (!this.field_70170_p.field_72995_K && !bl) {
            this.func_70106_y();
            if (entityPlayer.field_71075_bZ._d) {
                d = 7.0;
                list2 = this.field_70170_p.func_72872_a(EntityLiving.class, eidj._a()._a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + d, this.field_70161_v + d));
                if (list2 != null) {
                    for (EntityLiving entityLiving : list2) {
                        if (!entityLiving.func_110167_bD() || entityLiving.func_110166_bE() != this) continue;
                        entityLiving.func_110160_i(true, false);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean func_70518_d() {
        int n = this.field_70170_p.func_72798_a(this.field_70523_b, this.field_70524_c, this.field_70521_d);
        return twgu.field_71973_m[n] != null && twgu.field_71973_m[n].func_71857_b() == 11;
    }

    public static EntityLeashKnot func_110129_a(ozlu ozlu2, int n, int n2, int n3) {
        EntityLeashKnot entityLeashKnot = new EntityLeashKnot(ozlu2, n, n2, n3);
        entityLeashKnot.field_98038_p = true;
        ozlu2.func_72838_d(entityLeashKnot);
        return entityLeashKnot;
    }

    public static EntityLeashKnot func_110130_b(ozlu ozlu2, int n, int n2, int n3) {
        List list2 = ozlu2.func_72872_a(EntityLeashKnot.class, eidj._a()._a((double)n - 1.0, (double)n2 - 1.0, (double)n3 - 1.0, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 1.0));
        Object var5_5 = null;
        if (list2 != null) {
            for (EntityLeashKnot entityLeashKnot : list2) {
                if (entityLeashKnot.field_70523_b != n || entityLeashKnot.field_70524_c != n2 || entityLeashKnot.field_70521_d != n3) continue;
                return entityLeashKnot;
            }
        }
        return null;
    }
}

