/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;

public class EntityPotion
extends EntityThrowable {
    public cvzo field_70197_d;

    public EntityPotion(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityPotion(ozlu ozlu2, EntityLivingBase entityLivingBase, int n) {
        this(ozlu2, entityLivingBase, new cvzo(tgdv.field_77726_bs, 1, n));
    }

    public EntityPotion(ozlu ozlu2, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super(ozlu2, entityLivingBase);
        this.field_70197_d = cvzo2;
    }

    public EntityPotion(ozlu ozlu2, double d, double d2, double d3, int n) {
        this(ozlu2, d, d2, d3, new cvzo(tgdv.field_77726_bs, 1, n));
    }

    public EntityPotion(ozlu ozlu2, double d, double d2, double d3, cvzo cvzo2) {
        super(ozlu2, d, d2, d3);
        this.field_70197_d = cvzo2;
    }

    @Override
    public float func_70185_h() {
        return 0.05f;
    }

    @Override
    public float func_70182_d() {
        return 0.5f;
    }

    @Override
    public float func_70183_g() {
        return -20.0f;
    }

    public void func_82340_a(int n) {
        if (this.field_70197_d == null) {
            this.field_70197_d = new cvzo(tgdv.field_77726_bs, 1, 0);
        }
        this.field_70197_d._b(n);
    }

    public int func_70196_i() {
        if (this.field_70197_d == null) {
            this.field_70197_d = new cvzo(tgdv.field_77726_bs, 1, 0);
        }
        return this.field_70197_d._j();
    }

    @Override
    public void func_70184_a(hank hank2) {
        if (!this.field_70170_p.field_72995_K) {
            eidj eidj2;
            List list2;
            List list3 = tgdv.field_77726_bs._a(this.field_70197_d);
            if (list3 != null && !list3.isEmpty() && (list2 = this.field_70170_p.func_72872_a(EntityLivingBase.class, eidj2 = this.field_70121_D._b(4.0, 2.0, 4.0))) != null && !list2.isEmpty()) {
                for (EntityLivingBase entityLivingBase : list2) {
                    double d = this.func_70068_e(entityLivingBase);
                    if (!(d < 16.0)) continue;
                    double d2 = 1.0 - Math.sqrt(d) / 4.0;
                    if (entityLivingBase == hank2._i) {
                        d2 = 1.0;
                    }
                    for (supr supr2 : list3) {
                        int n = supr2._a();
                        if (hdpq._a[n]._b()) {
                            hdpq._a[n]._a(this.func_85052_h(), entityLivingBase, supr2._c(), d2);
                            continue;
                        }
                        int n2 = (int)(d2 * (double)supr2._b() + 0.5);
                        if (n2 <= 20) continue;
                        entityLivingBase.func_70690_d(new supr(n, n2, supr2._c()));
                    }
                }
            }
            this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), this.func_70196_i());
            this.func_70106_y();
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("Potion")) {
            this.field_70197_d = cvzo._a(qoac2._m("Potion"));
        } else {
            this.func_82340_a(qoac2._f("potionValue"));
        }
        if (this.field_70197_d == null) {
            this.func_70106_y();
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        if (this.field_70197_d != null) {
            qoac2._a("Potion", this.field_70197_d._b(new qoac()));
        }
    }
}

