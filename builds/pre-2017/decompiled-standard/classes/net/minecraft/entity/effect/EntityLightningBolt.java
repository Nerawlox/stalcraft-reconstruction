/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.effect;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;

public class EntityLightningBolt
extends EntityWeatherEffect {
    public int field_70262_b;
    public long field_70264_a;
    public int field_70263_c;

    public EntityLightningBolt(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.func_70012_b(d, d2, d3, 0.0f, 0.0f);
        this.field_70262_b = 2;
        this.field_70264_a = this.field_70146_Z.nextLong();
        this.field_70263_c = this.field_70146_Z.nextInt(3) + 1;
        if (!ozlu2.field_72995_K && ozlu2.func_82736_K()._b("doFireTick") && ozlu2.field_73013_u >= 2 && ozlu2.func_72873_a(sajh._c(d), sajh._c(d2), sajh._c(d3), 10)) {
            int n;
            int n2;
            int n3 = sajh._c(d);
            if (ozlu2.func_72798_a(n3, n2 = sajh._c(d2), n = sajh._c(d3)) == 0 && twgu.field_72067_ar.func_71930_b(ozlu2, n3, n2, n)) {
                ozlu2.func_94575_c(n3, n2, n, twgu.field_72067_ar.field_71990_ca);
            }
            for (n3 = 0; n3 < 4; ++n3) {
                int n4;
                n2 = sajh._c(d) + this.field_70146_Z.nextInt(3) - 1;
                if (ozlu2.func_72798_a(n2, n = sajh._c(d2) + this.field_70146_Z.nextInt(3) - 1, n4 = sajh._c(d3) + this.field_70146_Z.nextInt(3) - 1) != 0 || !twgu.field_72067_ar.func_71930_b(ozlu2, n2, n, n4)) continue;
                ozlu2.func_94575_c(n2, n, n4, twgu.field_72067_ar.field_71990_ca);
            }
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70262_b == 2) {
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0f, 0.5f + this.field_70146_Z.nextFloat() * 0.2f);
        }
        --this.field_70262_b;
        if (this.field_70262_b < 0) {
            if (this.field_70263_c == 0) {
                this.func_70106_y();
            } else if (this.field_70262_b < -this.field_70146_Z.nextInt(10)) {
                int n;
                int n2;
                int n3;
                --this.field_70263_c;
                this.field_70262_b = 1;
                this.field_70264_a = this.field_70146_Z.nextLong();
                if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K()._b("doFireTick") && this.field_70170_p.func_72873_a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v), 10) && this.field_70170_p.func_72798_a(n3 = sajh._c(this.field_70165_t), n2 = sajh._c(this.field_70163_u), n = sajh._c(this.field_70161_v)) == 0 && twgu.field_72067_ar.func_71930_b(this.field_70170_p, n3, n2, n)) {
                    this.field_70170_p.func_94575_c(n3, n2, n, twgu.field_72067_ar.field_71990_ca);
                }
            }
        }
        if (this.field_70262_b >= 0) {
            if (this.field_70170_p.field_72995_K) {
                this.field_70170_p.field_73016_r = 2;
            } else {
                double d = 3.0;
                List list2 = this.field_70170_p.func_72839_b(this, eidj._a()._a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + 6.0 + d, this.field_70161_v + d));
                for (int i = 0; i < list2.size(); ++i) {
                    Entity entity = (Entity)list2.get(i);
                    if (MinecraftForge.EVENT_BUS.post(new EntityStruckByLightningEvent(entity, this))) continue;
                    entity.func_70077_a(this);
                }
            }
        }
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public void func_70037_a(qoac qoac2) {
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_70102_a(ofbx ofbx2) {
        return this.field_70262_b >= 0;
    }
}

