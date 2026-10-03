/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.List;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.util.jxtc;

public class EntityPigZombie
extends EntityZombie {
    public static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    public static final xson field_110190_br = new xson(field_110189_bq, "Attacking speed boost", 0.45, 0)._a(false);
    public int field_70837_d;
    public int field_70838_e;
    public Entity field_110191_bu;

    public EntityPigZombie(ozlu ozlu2) {
        super(ozlu2);
        this.field_70178_ae = true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(field_110186_bp)._a(0.0);
        this.func_110148_a(sajz._d)._a(0.5);
        this.func_110148_a(sajz._e)._a(5.0);
    }

    @Override
    public boolean func_70650_aV() {
        return false;
    }

    @Override
    public void func_70071_h_() {
        if (this.field_110191_bu != this.field_70789_a && !this.field_70170_p.field_72995_K) {
            hubf hubf2 = this.func_110148_a(sajz._d);
            hubf2._b(field_110190_br);
            if (this.field_70789_a != null) {
                hubf2._a(field_110190_br);
            }
        }
        this.field_110191_bu = this.field_70789_a;
        if (this.field_70838_e > 0 && --this.field_70838_e == 0) {
            this.func_85030_a("mob.zombiepig.zpigangry", this.func_70599_aP() * 2.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        super.func_70071_h_();
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.field_73013_u > 0 && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Anger", (short)this.field_70837_d);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_70837_d = qoac2._e("Anger");
    }

    @Override
    public Entity func_70782_k() {
        if (this.field_70837_d == 0) {
            return null;
        }
        return super.func_70782_k();
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        Entity entity = jxtc2.func_76346_g();
        if (entity instanceof EntityPlayer) {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D._b(32.0, 32.0, 32.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity2 = (Entity)list.get(i);
                if (!(entity2 instanceof EntityPigZombie)) continue;
                EntityPigZombie entityPigZombie = (EntityPigZombie)entity2;
                entityPigZombie.func_70835_c(entity);
            }
            this.func_70835_c(entity);
        }
        return super.func_70097_a(jxtc2, f);
    }

    public void func_70835_c(Entity entity) {
        this.field_70789_a = entity;
        this.field_70837_d = 400 + this.field_70146_Z.nextInt(400);
        this.field_70838_e = this.field_70146_Z.nextInt(40);
    }

    @Override
    public String func_70639_aQ() {
        return "mob.zombiepig.zpig";
    }

    @Override
    public String func_70621_aR() {
        return "mob.zombiepig.zpighurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.zombiepig.zpigdeath";
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2;
        int n3 = this.field_70146_Z.nextInt(2 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77737_bm.field_77779_bT, 1);
        }
        n3 = this.field_70146_Z.nextInt(2 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77733_bq.field_77779_bT, 1);
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void func_70600_l(int n) {
        this.func_70025_b(tgdv.field_77717_p.field_77779_bT, 1);
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77737_bm.field_77779_bT;
    }

    @Override
    public void func_82164_bB() {
        this.func_70062_b(0, new cvzo(tgdv.field_77672_G));
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        super.func_110161_a(tupg2);
        this.func_82229_g(false);
        return tupg2;
    }
}

