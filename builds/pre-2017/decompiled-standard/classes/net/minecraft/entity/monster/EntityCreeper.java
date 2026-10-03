/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.eidj;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.qlgf;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;

public class EntityCreeper
extends EntityMob {
    public int field_70834_e;
    public int field_70833_d;
    public int field_82225_f = 30;
    public int field_82226_g = 3;

    public EntityCreeper(ozlu ozlu2) {
        super(ozlu2);
        this.field_70714_bg._a(1, new tdpx(this));
        this.field_70714_bg._a(2, new qlgf(this));
        this.field_70714_bg._a(3, new eidj(this, EntityOcelot.class, 6.0f, 1.0, 1.2));
        this.field_70714_bg._a(4, new pidb(this, 1.0, false));
        this.field_70714_bg._a(5, new iurn(this, 0.8));
        this.field_70714_bg._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(6, new tdmn(this));
        this.field_70715_bh._a(1, new pibk(this, EntityPlayer.class, 0, true));
        this.field_70715_bh._a(2, new ezfa(this, false));
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public int func_82143_as() {
        if (this.func_70638_az() == null) {
            return 3;
        }
        return 3 + (int)(this.func_110143_aJ() - 1.0f);
    }

    @Override
    public void func_70069_a(float f) {
        super.func_70069_a(f);
        this.field_70833_d = (int)((float)this.field_70833_d + f * 1.5f);
        if (this.field_70833_d > this.field_82225_f - 5) {
            this.field_70833_d = this.field_82225_f - 5;
        }
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)-1);
        this.field_70180_af._a(17, (Object)0);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        if (this.field_70180_af._a(17) == 1) {
            qoac2._a("powered", true);
        }
        qoac2._a("Fuse", (short)this.field_82225_f);
        qoac2._a("ExplosionRadius", (byte)this.field_82226_g);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_70180_af._b(17, (byte)(qoac2._o("powered") ? 1 : 0));
        if (qoac2._c("Fuse")) {
            this.field_82225_f = qoac2._e("Fuse");
        }
        if (qoac2._c("ExplosionRadius")) {
            this.field_82226_g = qoac2._d("ExplosionRadius");
        }
    }

    @Override
    public void func_70071_h_() {
        if (this.func_70089_S()) {
            this.field_70834_e = this.field_70833_d;
            int n = this.func_70832_p();
            if (n > 0 && this.field_70833_d == 0) {
                this.func_85030_a("random.fuse", 1.0f, 0.5f);
            }
            this.field_70833_d += n;
            if (this.field_70833_d < 0) {
                this.field_70833_d = 0;
            }
            if (this.field_70833_d >= this.field_82225_f) {
                this.field_70833_d = this.field_82225_f;
                if (!this.field_70170_p.field_72995_K) {
                    boolean bl = this.field_70170_p.func_82736_K()._b("mobGriefing");
                    if (this.func_70830_n()) {
                        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_82226_g * 2, bl);
                    } else {
                        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_82226_g, bl);
                    }
                    this.func_70106_y();
                }
            }
        }
        super.func_70071_h_();
    }

    @Override
    public String func_70621_aR() {
        return "mob.creeper.say";
    }

    @Override
    public String func_70673_aS() {
        return "mob.creeper.death";
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        super.func_70645_a(jxtc2);
        if (jxtc2.func_76346_g() instanceof EntitySkeleton) {
            int n = tgdv.field_77819_bI.field_77779_bT + this.field_70146_Z.nextInt(tgdv.field_85180_cf.field_77779_bT - tgdv.field_77819_bI.field_77779_bT + 1);
            this.func_70025_b(n, 1);
        }
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        return true;
    }

    public boolean func_70830_n() {
        return this.field_70180_af._a(17) == 1;
    }

    public float func_70831_j(float f) {
        return ((float)this.field_70834_e + (float)(this.field_70833_d - this.field_70834_e) * f) / (float)(this.field_82225_f - 2);
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77677_M.field_77779_bT;
    }

    public int func_70832_p() {
        return this.field_70180_af._a(16);
    }

    public void func_70829_a(int n) {
        this.field_70180_af._b(16, (byte)n);
    }

    @Override
    public void func_70077_a(EntityLightningBolt entityLightningBolt) {
        super.func_70077_a(entityLightningBolt);
        this.field_70180_af._b(17, (byte)1);
    }
}

