/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjui;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntitySnowman
extends EntityGolem
implements tdmn {
    public EntitySnowman(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.4f, 1.8f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(1, new kjui(this, 1.25, 20, 10.0f));
        this.field_70714_bg._a(2, new iurn(this, 1.0));
        this.field_70714_bg._a(3, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(4, new net.minecraft.entity.ai.tdmn(this));
        this.field_70715_bh._a(1, new pibk(this, EntityLiving.class, 0, true, false, ezey._a));
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(4.0);
        this.func_110148_a(sajz._d)._a(0.2f);
    }

    @Override
    public void func_70636_d() {
        int n;
        int n2;
        super.func_70636_d();
        if (this.func_70026_G()) {
            this.func_70097_a(jxtc.field_76369_e, 1.0f);
        }
        if (this.field_70170_p.func_72807_a(n2 = sajh._c(this.field_70165_t), n = sajh._c(this.field_70161_v))._k() > 1.0f) {
            this.func_70097_a(jxtc.field_76370_b, 1.0f);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            int n3;
            int n4;
            n = sajh._c(this.field_70165_t + (double)((float)(n2 % 2 * 2 - 1) * 0.25f));
            if (this.field_70170_p.func_72798_a(n, n4 = sajh._c(this.field_70163_u), n3 = sajh._c(this.field_70161_v + (double)((float)(n2 / 2 % 2 * 2 - 1) * 0.25f))) != 0 || !(this.field_70170_p.func_72807_a(n, n3)._k() < 0.8f) || !twgu.field_72037_aS.func_71930_b(this.field_70170_p, n, n4, n3)) continue;
            this.field_70170_p.func_94575_c(n, n4, n3, twgu.field_72037_aS.field_71990_ca);
        }
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77768_aD.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.field_70146_Z.nextInt(16);
        for (int i = 0; i < n2; ++i) {
            this.func_70025_b(tgdv.field_77768_aD.field_77779_bT, 1);
        }
    }

    @Override
    public void func_82196_d(EntityLivingBase entityLivingBase, float f) {
        EntitySnowball entitySnowball = new EntitySnowball(this.field_70170_p, this);
        double d = entityLivingBase.field_70165_t - this.field_70165_t;
        double d2 = entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (double)1.1f - entitySnowball.field_70163_u;
        double d3 = entityLivingBase.field_70161_v - this.field_70161_v;
        float f2 = sajh._a(d * d + d3 * d3) * 0.2f;
        entitySnowball.func_70186_c(d, d2 + (double)f2, d3, 1.6f, 12.0f);
        this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d(entitySnowball);
    }
}

