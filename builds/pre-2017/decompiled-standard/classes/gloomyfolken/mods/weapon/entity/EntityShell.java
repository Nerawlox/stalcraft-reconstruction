/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.ugqx;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

@ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public class EntityShell
extends EntityThrowable {
    private static final float MOTION_FACTOR = 0.999f;
    private static final float ROTATION_FACTOR = 0.999f;
    private static final float ENTITY_SIZE = 0.05f;
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float xRotationSpeed = 0.0f;
    public float yRotationSpeed = 0.0f;
    public float zRotationSpeed = 0.0f;
    protected boolean collided = false;
    protected double prevY;
    public boolean renderOnGround;
    public final String model;
    public final ResourceLocation texture;
    public boolean hideUntilLeaveFrustum;
    public long lastRenderedFrame;
    private static final int LIFETIME = 250;

    public EntityShell(ozlu ozlu2, EntityLivingBase entityLivingBase, wolf wolf2) {
        super(ozlu2);
        boolean bl = entityLivingBase == xpzm._E()._t;
        boolean bl2 = bl && ugqx._a((EntityPlayer)entityLivingBase)._l();
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (entityLivingBase instanceof EntityPlayer ? 0.4 : 0.1), entityLivingBase.field_70161_v, entityLivingBase.field_70759_as, entityLivingBase.field_70125_A);
        if (!bl2) {
            this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.35f);
            this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.35f);
        }
        double d = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        double d2 = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI);
        double d3 = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        double d4 = sajh._a((this.field_70125_A + 90.0f) / 180.0f * (float)Math.PI);
        ofbx ofbx2 = ofbx._a(d, d2, d3)._a();
        this.field_70165_t += ofbx2._c * 0.15;
        this.field_70163_u += ofbx2._d * 0.15;
        this.field_70161_v += ofbx2._e * 0.15;
        if (bl2) {
            this.field_70165_t += (double)((wolf2.__af._c + 1.0f) / 2.0f) * ofbx2._c;
            this.field_70163_u += (double)((wolf2.__af._c + 1.0f) / 2.0f) * ofbx2._d;
            this.field_70161_v += (double)((wolf2.__af._c + 1.0f) / 2.0f) * ofbx2._e;
        } else if (bl) {
            this.field_70165_t += ofbx2._c * 0.5;
            this.field_70163_u += ofbx2._d * 0.5;
            this.field_70161_v += ofbx2._e * 0.5;
        }
        ofbx2._b((float)Math.toRadians(-90.0));
        this.field_70181_x = d4 * wolf2.__aa._d;
        double d5 = wolf2.__aa._c;
        this.field_70159_w = ofbx2._c * d5;
        this.field_70179_y = ofbx2._e * d5;
        this.field_70181_x *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.field_70159_w *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.field_70179_y *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.field_70165_t += this.field_70159_w / 2.0;
        this.field_70161_v += this.field_70179_y / 2.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.func_70105_a(0.05f, 0.05f);
        this.field_70131_O = 0.05f;
        this.model = wolf2._V;
        this.texture = wolf2._W;
        this.yRotation = 180.0f - entityLivingBase.field_70759_as;
        this.hideUntilLeaveFrustum = bl && xpzm._E()._M.field_74320_O == 0;
    }

    public EntityShell(ozlu ozlu2, double d, double d2, double d3, float f, float f2, float f3, String string, String string2) {
        super(ozlu2);
        this.func_70012_b(d, d2 - 0.3, d3, f, f2);
        double d4 = sajh._a((this.field_70125_A + 90.0f) / 180.0f * (float)Math.PI);
        this.field_70181_x = d4 * 0.25;
        this.field_70159_w = (double)(-sajh._a((f += 90.0f) / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI)) * 0.15;
        this.field_70179_y = (double)(sajh._b(f / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI)) * 0.15;
        this.field_70165_t += (double)(-sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f3;
        this.field_70161_v += (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f3;
        this.field_70163_u += (double)(-sajh._a(this.field_70125_A / 180.0f * (float)Math.PI)) * (double)f3;
        this.field_70165_t += this.field_70159_w / 2.0;
        this.field_70163_u += this.field_70181_x / 2.0;
        this.field_70161_v += this.field_70179_y / 2.0;
        this.field_70181_x *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.field_70159_w *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.field_70179_y *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.func_70105_a(0.05f, 0.05f);
        this.field_70131_O = 0.05f;
        this.model = string;
        this.texture = new ResourceLocation("weapons", "models/sleeves/" + string2);
        this.yRotation = 180.0f - f;
        this.hideUntilLeaveFrustum = false;
    }

    @Override
    protected float func_70185_h() {
        return 0.07f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        float f = this.field_70163_u == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= f;
        this.yRotationSpeed *= f;
        this.zRotationSpeed *= f;
        this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
        this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
        this.prevY = this.field_70163_u;
        if (this.field_70173_aa > 250) {
            this.func_70106_y();
        }
    }

    @Override
    protected void func_70184_a(hank hank2) {
        if (hank2._i == null && twgu.field_71973_m[this.field_70170_p.func_72798_a(hank2._d, hank2._e, hank2._f)].func_71872_e(this.field_70170_p, hank2._d, hank2._e, hank2._f) == null) {
            return;
        }
        if (hank2._c.ordinal() == 0) {
            this.pushOff(hank2._h, hank2._g);
        } else {
            this.hitEntity(hank2._i);
        }
    }

    protected void hitEntity(Entity entity) {
        this.field_70159_w *= -0.5;
        this.field_70181_x *= -0.5;
        this.field_70179_y *= -0.5;
        this.xRotationSpeed *= 0.5f;
        this.yRotationSpeed *= 0.5f;
        this.zRotationSpeed *= 0.5f;
        this.calculateNewImpact();
    }

    protected void pushOff(ofbx ofbx2, int n) {
        boolean bl;
        boolean bl2 = bl = Math.abs(this.field_70181_x) > (double)0.2f || n == 0;
        if (n == 0 || n == 1) {
            if (bl) {
                this.field_70159_w *= (double)0.8f;
                this.field_70181_x *= -0.5;
                this.field_70179_y *= (double)0.8f;
                this.renderOnGround = false;
            } else {
                this.field_70159_w *= (double)0.8f;
                this.field_70181_x = 0.0;
                this.field_70163_u = ofbx2._d + 0.01;
                this.field_70179_y *= (double)0.8f;
                this.xRotationSpeed = 0.0f;
                this.zRotationSpeed = 0.0f;
                this.xRotation = 0.0f;
                this.zRotation = 0.0f;
                this.renderOnGround = true;
            }
        } else if (n == 2 || n == 3) {
            this.field_70159_w *= 0.5;
            this.field_70181_x *= (double)0.8f;
            this.field_70179_y *= -0.5;
        } else {
            this.field_70159_w *= -0.5;
            this.field_70181_x *= (double)0.8f;
            this.field_70179_y *= 0.5;
        }
        if (!bl) {
            this.xRotationSpeed *= 0.5f;
            this.yRotationSpeed *= 0.5f;
            this.zRotationSpeed *= 0.5f;
        } else {
            this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
            this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
            this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        }
        this.calculateNewImpact();
    }

    protected void calculateNewImpact() {
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72933_a(ofbx2, ofbx3);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        if (!this.field_70170_p.field_72995_K) {
            Entity entity = null;
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
            double d = 0.0;
            EntityLivingBase entityLivingBase = this.func_85052_h();
            for (int i = 0; i < list.size(); ++i) {
                double d2;
                float f;
                eidj eidj2;
                hank hank3;
                Entity entity2 = (Entity)list.get(i);
                if (!entity2.func_70067_L() || entity2 == entityLivingBase && this.field_70173_aa < 5 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d2 = ofbx2._d(hank3._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                hank2 = new hank(entity);
            }
        }
        if (hank2 != null) {
            if (hank2._c == amww._a && this.field_70170_p.func_72798_a(hank2._d, hank2._e, hank2._f) == twgu.field_72015_be.field_71990_ca) {
                this.func_70063_aa();
            } else {
                this.func_70184_a(hank2);
            }
        }
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }
}

