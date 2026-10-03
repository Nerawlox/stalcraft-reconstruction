/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.sajh;

public class EntityElementalStaffFX
extends EntityPortalFX {
    double field_70159_w;
    double field_70181_x;
    double field_70179_y;
    EntityLivingBase player;

    public EntityElementalStaffFX(EntityLivingBase entityLivingBase, double d, double d2, double d3, double d4, double d5, double d6, int n) {
        super(entityLivingBase.field_70170_p, entityLivingBase.field_70165_t + d, entityLivingBase.field_70163_u + d2, entityLivingBase.field_70161_v + d3, d4, d5, d6);
        this.player = entityLivingBase;
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        float[] fArray = n <= 15 ? EntitySheep.field_70898_d[n] : new float[]{(float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f};
        this.field_70552_h = fArray[0];
        this.field_70553_i = fArray[1];
        this.field_70551_j = fArray[2];
        this.field_70547_e = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.field_70145_X = false;
    }

    @Override
    public void func_70071_h_() {
        if (this.player.field_70128_L) {
            this.func_70106_y();
        } else {
            float f;
            this.field_70169_q = this.field_70165_t;
            this.field_70167_r = this.field_70163_u;
            this.field_70166_s = this.field_70161_v;
            float f2 = f = (float)this.field_70546_d / (float)this.field_70547_e;
            f = -f + f * f * 2.0f;
            f = 1.0f - f;
            double d = -sajh._a((float)((double)(this.player.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(this.player.field_70125_A / 180.0f) * Math.PI));
            double d2 = sajh._b((float)((double)(this.player.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(this.player.field_70125_A / 180.0f) * Math.PI));
            this.field_70165_t = this.player.field_70165_t + this.field_70159_w + d + ((Entity)this).field_70159_w * (double)f;
            this.field_70163_u = this.player.field_70163_u + this.field_70181_x + ((Entity)this).field_70181_x * (double)f + (double)(1.0f - f2) - (double)(this.player.field_70125_A / 40.0f);
            this.field_70161_v = this.player.field_70161_v + this.field_70179_y + d2 + ((Entity)this).field_70179_y * (double)f;
            if (this.field_70546_d++ >= this.field_70547_e) {
                this.func_70106_y();
            }
        }
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
    }
}

