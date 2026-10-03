/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityBullet
extends Entity {
    private ofbx fromVec;
    private ofbx toVec;
    private double distanceSq;
    private static final float SPEED = 30.0f;

    public EntityBullet(ozlu ozlu2) {
        super(ozlu2);
        this.field_70129_M = 0.1f;
        this.func_70105_a(0.6f, 0.6f);
        this.field_70155_l = 4.0;
    }

    public EntityBullet(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3) {
        this(ozlu2);
        this.fromVec = ofbx2;
        this.toVec = ofbx3;
        ofbx ofbx4 = ofbx2._a(ofbx3);
        this.distanceSq = ofbx4._c * ofbx4._c + ofbx4._d * ofbx4._d + ofbx4._e * ofbx4._e;
        double d = Math.sqrt(this.distanceSq);
        this.field_70159_w = ofbx4._c / d * 30.0;
        this.field_70181_x = ofbx4._d / d * 30.0;
        this.field_70179_y = ofbx4._e / d * 30.0;
        this.field_70173_aa = 1;
        this.field_70142_S = ofbx2._c + this.field_70159_w;
        this.field_70137_T = ofbx2._d + this.field_70181_x;
        this.field_70136_U = ofbx2._e + this.field_70179_y;
        this.func_70107_b(ofbx2._c + this.field_70159_w, ofbx2._d + this.field_70181_x, ofbx2._e + this.field_70179_y);
    }

    @Override
    protected void func_70088_a() {
    }

    public EntityBullet(Entity entity, float f, boolean bl, float f2, float f3, String string, double d, float f4, float f5, boolean bl2) {
        this(entity.field_70170_p);
        this.func_70012_b(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e() - (entity.func_70093_af() ? 0.09 : 0.0), entity.field_70161_v, f4, f5);
        if (bl) {
            this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.245f);
            this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.245f);
        }
        float f6 = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f3;
        float f7 = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f3;
        float f8 = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI) * f3;
        float f9 = (entity.field_70170_p.field_73012_v.nextFloat() - 0.5f) * f2 * (float)Math.PI / 90.0f;
        ofbx ofbx2 = ofbx._a(entity.field_70170_p.field_73012_v.nextFloat() - 0.5f, entity.field_70170_p.field_73012_v.nextFloat() - 0.5f, entity.field_70170_p.field_73012_v.nextFloat() - 0.5f);
        ofbx2._a();
        float f10 = sajh._a(f9);
        float f11 = sajh._b(f9);
        float f12 = 1.0f - f11;
        double[] dArray = new double[]{(double)f12 * ofbx2._c * ofbx2._c + (double)f11, (double)f12 * ofbx2._c * ofbx2._d - ofbx2._e * (double)f10, (double)f12 * ofbx2._e * ofbx2._c + ofbx2._d * (double)f10, (double)f12 * ofbx2._c * ofbx2._d + ofbx2._e * (double)f10, (double)f12 * ofbx2._d * ofbx2._d + (double)f11, (double)f12 * ofbx2._d * ofbx2._e - ofbx2._c * (double)f10, (double)f12 * ofbx2._e * ofbx2._c - ofbx2._d * (double)f10, (double)f12 * ofbx2._d * ofbx2._e + ofbx2._c * (double)f10, (double)f12 * ofbx2._e * ofbx2._e + (double)f11};
        this.field_70159_w = dArray[0] * (double)f6 + dArray[1] * (double)f8 + dArray[2] * (double)f7;
        this.field_70181_x = dArray[3] * (double)f6 + dArray[4] * (double)f8 + dArray[5] * (double)f7;
        this.field_70179_y = dArray[6] * (double)f6 + dArray[7] * (double)f8 + dArray[8] * (double)f7;
        this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
    }

    public EntityBullet(Entity entity, double d, double d2, double d3, float f, float f2, float f3, float f4, String string, double d4, boolean bl) {
        this(entity.field_70170_p);
        this.func_70012_b(d, d2, d3, f, f2);
        this.field_70159_w = (double)(-sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f4;
        this.field_70179_y = (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f4;
        this.field_70181_x = (double)(-sajh._a(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f4;
        this.func_70012_b(d, d2, d3, this.field_70177_z, this.field_70125_A);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.func_70106_y();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70165_t += this.field_70159_w;
        this.field_70163_u += this.field_70181_x;
        this.field_70161_v += this.field_70179_y;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (!this.isInRange(0.0f)) {
            this.func_70106_y();
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }

    public boolean isInRange(float f) {
        double d = this.field_70142_S + (this.field_70165_t - this.field_70142_S) * (double)f;
        double d2 = this.field_70137_T + (this.field_70163_u - this.field_70137_T) * (double)f;
        double d3 = this.field_70136_U + (this.field_70161_v - this.field_70136_U) * (double)f;
        double d4 = this.fromVec._d(d, d2, d3);
        return d4 < this.distanceSq;
    }
}

