/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.sajz;
import net.minecraft.util.sajh;

public class EntitySquid
extends EntityWaterMob {
    public float field_70861_d;
    public float field_70862_e;
    public float field_70859_f;
    public float field_70860_g;
    public float field_70867_h;
    public float field_70868_i;
    public float field_70866_j;
    public float field_70865_by;
    public float field_70863_bz;
    public float field_70864_bA;
    public float field_70871_bB;
    public float field_70872_bC;
    public float field_70869_bD;
    public float field_70870_bE;

    public EntitySquid(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.95f, 0.95f);
        this.field_70864_bA = 1.0f / (this.field_70146_Z.nextFloat() + 1.0f) * 0.2f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(10.0);
    }

    @Override
    public String func_70639_aQ() {
        return null;
    }

    @Override
    public String func_70621_aR() {
        return null;
    }

    @Override
    public String func_70673_aS() {
        return null;
    }

    @Override
    public float func_70599_aP() {
        return 0.4f;
    }

    @Override
    public int func_70633_aT() {
        return 0;
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.field_70146_Z.nextInt(3 + n) + 1;
        for (int i = 0; i < n2; ++i) {
            this.func_70099_a(new cvzo(tgdv.field_77756_aW, 1, 0), 0.0f);
        }
    }

    @Override
    public boolean func_70090_H() {
        return this.field_70170_p.func_72918_a(this.field_70121_D._b(0.0, -0.6f, 0.0), tflj._h, this);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70862_e = this.field_70861_d;
        this.field_70860_g = this.field_70859_f;
        this.field_70868_i = this.field_70867_h;
        this.field_70865_by = this.field_70866_j;
        this.field_70867_h += this.field_70864_bA;
        if (this.field_70867_h > (float)Math.PI * 2) {
            this.field_70867_h -= (float)Math.PI * 2;
            if (this.field_70146_Z.nextInt(10) == 0) {
                this.field_70864_bA = 1.0f / (this.field_70146_Z.nextFloat() + 1.0f) * 0.2f;
            }
        }
        if (this.func_70090_H()) {
            float f;
            if (this.field_70867_h < (float)Math.PI) {
                f = this.field_70867_h / (float)Math.PI;
                this.field_70866_j = sajh._a(f * f * (float)Math.PI) * (float)Math.PI * 0.25f;
                if ((double)f > 0.75) {
                    this.field_70863_bz = 1.0f;
                    this.field_70871_bB = 1.0f;
                } else {
                    this.field_70871_bB *= 0.8f;
                }
            } else {
                this.field_70866_j = 0.0f;
                this.field_70863_bz *= 0.9f;
                this.field_70871_bB *= 0.99f;
            }
            if (!this.field_70170_p.field_72995_K) {
                this.field_70159_w = this.field_70872_bC * this.field_70863_bz;
                this.field_70181_x = this.field_70869_bD * this.field_70863_bz;
                this.field_70179_y = this.field_70870_bE * this.field_70863_bz;
            }
            f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70761_aq += (-((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0f / (float)Math.PI - this.field_70761_aq) * 0.1f;
            this.field_70177_z = this.field_70761_aq;
            this.field_70859_f += (float)Math.PI * this.field_70871_bB * 1.5f;
            this.field_70861_d += (-((float)Math.atan2(f, this.field_70181_x)) * 180.0f / (float)Math.PI - this.field_70861_d) * 0.1f;
        } else {
            this.field_70866_j = sajh._e(sajh._a(this.field_70867_h)) * (float)Math.PI * 0.25f;
            if (!this.field_70170_p.field_72995_K) {
                this.field_70159_w = 0.0;
                this.field_70181_x -= 0.08;
                this.field_70181_x *= (double)0.98f;
                this.field_70179_y = 0.0;
            }
            this.field_70861_d = (float)((double)this.field_70861_d + (double)(-90.0f - this.field_70861_d) * 0.02);
        }
    }

    @Override
    public void func_70612_e(float f, float f2) {
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }

    @Override
    public void func_70626_be() {
        ++this.field_70708_bq;
        if (this.field_70708_bq > 100) {
            this.field_70870_bE = 0.0f;
            this.field_70869_bD = 0.0f;
            this.field_70872_bC = 0.0f;
        } else if (this.field_70146_Z.nextInt(50) == 0 || !this.field_70171_ac || this.field_70872_bC == 0.0f && this.field_70869_bD == 0.0f && this.field_70870_bE == 0.0f) {
            float f = this.field_70146_Z.nextFloat() * (float)Math.PI * 2.0f;
            this.field_70872_bC = sajh._b(f) * 0.2f;
            this.field_70869_bD = -0.1f + this.field_70146_Z.nextFloat() * 0.2f;
            this.field_70870_bE = sajh._a(f) * 0.2f;
        }
        this.func_70623_bb();
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70163_u > 45.0 && this.field_70163_u < 63.0 && super.func_70601_bi();
    }
}

