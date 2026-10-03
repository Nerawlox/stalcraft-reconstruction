/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.sajz;

public class EntityMagmaCube
extends EntitySlime {
    public EntityMagmaCube(ozlu ozlu2) {
        super(ozlu2);
        this.field_70178_ae = true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._d)._a(0.2f);
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.field_73013_u > 0 && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
    }

    @Override
    public int func_70658_aO() {
        return this.func_70809_q() * 3;
    }

    @Override
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }

    @Override
    public String func_70801_i() {
        return "flame";
    }

    @Override
    public EntitySlime func_70802_j() {
        return new EntityMagmaCube(this.field_70170_p);
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77725_bx.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.func_70633_aT();
        if (n2 > 0 && this.func_70809_q() > 1) {
            int n3 = this.field_70146_Z.nextInt(4) - 2;
            if (n > 0) {
                n3 += this.field_70146_Z.nextInt(n + 1);
            }
            for (int i = 0; i < n3; ++i) {
                this.func_70025_b(n2, 1);
            }
        }
    }

    @Override
    public boolean func_70027_ad() {
        return false;
    }

    @Override
    public int func_70806_k() {
        return super.func_70806_k() * 4;
    }

    @Override
    public void func_70808_l() {
        this.field_70813_a *= 0.9f;
    }

    @Override
    public void func_70664_aZ() {
        this.field_70181_x = 0.42f + (float)this.func_70809_q() * 0.1f;
        this.field_70160_al = true;
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public boolean func_70800_m() {
        return true;
    }

    @Override
    public int func_70805_n() {
        return super.func_70805_n() + 2;
    }

    @Override
    public String func_70621_aR() {
        return "mob.slime." + (this.func_70809_q() > 1 ? "big" : "small");
    }

    @Override
    public String func_70673_aS() {
        return "mob.slime." + (this.func_70809_q() > 1 ? "big" : "small");
    }

    @Override
    public String func_70803_o() {
        if (this.func_70809_q() > 1) {
            return "mob.magmacube.big";
        }
        return "mob.magmacube.small";
    }

    @Override
    public boolean func_70058_J() {
        return false;
    }

    @Override
    public boolean func_70804_p() {
        return true;
    }
}

