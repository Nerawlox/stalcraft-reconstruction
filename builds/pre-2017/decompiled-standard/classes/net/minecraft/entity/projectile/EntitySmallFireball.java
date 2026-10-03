/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;

public class EntitySmallFireball
extends EntityFireball {
    public EntitySmallFireball(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    public EntitySmallFireball(ozlu ozlu2, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(ozlu2, entityLivingBase, d, d2, d3);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    public EntitySmallFireball(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    @Override
    public void func_70227_a(hank hank2) {
        if (!this.field_70170_p.field_72995_K) {
            if (hank2._i != null) {
                if (!hank2._i.func_70045_F() && hank2._i.func_70097_a(jxtc.func_76362_a(this, this.field_70235_a), 5.0f)) {
                    hank2._i.func_70015_d(5);
                }
            } else {
                int n = hank2._d;
                int n2 = hank2._e;
                int n3 = hank2._f;
                switch (hank2._g) {
                    case 1: {
                        ++n2;
                        break;
                    }
                    case 0: {
                        --n2;
                        break;
                    }
                    case 2: {
                        --n3;
                        break;
                    }
                    case 3: {
                        ++n3;
                        break;
                    }
                    case 5: {
                        ++n;
                        break;
                    }
                    case 4: {
                        --n;
                    }
                }
                if (this.field_70170_p.func_72799_c(n, n2, n3)) {
                    this.field_70170_p.func_94575_c(n, n2, n3, twgu.field_72067_ar.field_71990_ca);
                }
            }
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70067_L() {
        return false;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return false;
    }
}

