/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import noppes.npcs.DataStats;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.constants.EnumPotionType;

public class EntityProjectile
extends Entity
implements owak {
    public int throwableShake = 0;
    public int arrowShake = 0;
    public boolean canBePickedUp = false;
    public boolean destroyedOnEntityHit = true;
    public EntityItem entityitem;
    public int ticksInAir = 0;
    public float damage = 5.0f;
    public int punch = 0;
    public boolean accelerate = false;
    public boolean explosive = false;
    public int explosiveRadius = 0;
    public EnumPotionType effect = EnumPotionType.None;
    public int duration = 5;
    public int amplify = 0;
    protected boolean inGround = false;
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private int inData = 0;
    private EntityLivingBase thrower;
    private EntityNPCInterface npc;
    private String throwerName = null;
    private int ticksInGround;
    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;

    public EntityProjectile(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
    }

    public EntityProjectile(ozlu ozlu2, EntityLivingBase entityLivingBase, cvzo cvzo2, boolean bl) {
        super(ozlu2);
        this.thrower = entityLivingBase;
        this.setThrownItem(cvzo2);
        this.field_70180_af._b(27, (byte)(this.getItemId() == tgdv.field_77704_l.field_77779_bT ? 1 : 0));
        this.func_70105_a(this.field_70180_af._c(23) / 10, this.field_70180_af._c(23) / 10);
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v, entityLivingBase.field_70177_z, entityLivingBase.field_70125_A);
        this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.field_70163_u -= 0.3;
        this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        if (bl) {
            this.npc = (EntityNPCInterface)this.thrower;
            this.getStatProperties(this.npc.stats);
        }
    }

    @Override
    protected void func_70088_a() {
        this.field_70180_af._a(21, 5);
        this.field_70180_af._a(22, String.valueOf(""));
        this.field_70180_af._a(23, (Object)5);
        this.field_70180_af._a(24, (Object)0);
        this.field_70180_af._a(25, (Object)10);
        this.field_70180_af._a(26, (Object)0);
        this.field_70180_af._a(27, (Object)0);
        this.field_70180_af._a(28, (Object)0);
        this.field_70180_af._a(29, (Object)0);
        this.field_70180_af._a(30, (Object)0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public void setThrownItem(cvzo cvzo2) {
        this.field_70180_af._b(21, cvzo2);
    }

    @Override
    public void func_70186_c(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        float f4 = sajh._a(d * d + d3 * d3);
        float f5 = (float)(Math.atan2(d, d3) * 180.0 / Math.PI);
        float f6 = this.hasGravity() ? f : (float)(Math.atan2(d2, f4) * 180.0 / Math.PI);
        this.field_70126_B = this.field_70177_z = f5;
        this.field_70127_C = this.field_70125_A = f6;
        this.field_70159_w = sajh._a(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI);
        this.field_70179_y = sajh._b(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI);
        this.field_70181_x = sajh._a((f6 + 1.0f) / 180.0f * (float)Math.PI);
        this.field_70159_w += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        this.field_70179_y += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        this.field_70181_x += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        this.field_70159_w *= (double)this.getSpeed();
        this.field_70179_y *= (double)this.getSpeed();
        this.field_70181_x *= (double)this.getSpeed();
        this.accelerationX = d / (double)f3 * 0.1;
        this.accelerationY = d2 / (double)f3 * 0.1;
        this.accelerationZ = d3 / (double)f3 * 0.1;
        this.ticksInGround = 0;
    }

    public float getAngleForXYZ(double d, double d2, double d3, double d4, boolean bl) {
        float f = this.getGravityVelocity();
        float f2 = this.getSpeed() * this.getSpeed();
        double d5 = (double)f * d4;
        double d6 = (double)f * d4 * d4 + 2.0 * d2 * (double)f2;
        double d7 = (double)(f2 * f2) - (double)f * d6;
        if (d7 < 0.0) {
            return 30.0f;
        }
        float f3 = bl ? f2 + sajh._a(d7) : f2 - sajh._a(d7);
        float f4 = (float)(Math.atan2(f3, d5) * 180.0 / Math.PI);
        return f4;
    }

    public void shoot(float f) {
        double d = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        double d2 = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        double d3 = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI);
        this.func_70186_c(d, d3, d2, -this.field_70125_A, f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / Math.PI);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f) * 180.0 / Math.PI);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        if (!this.field_70170_p.field_72995_K || !this.inGround) {
            this.func_70107_b(d, d2, d3);
            this.func_70101_b(f, f2);
        }
    }

    protected float getGravityVelocity() {
        return 0.03f;
    }

    @Override
    public void func_70071_h_() {
        Object object;
        super.func_70071_h_();
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / Math.PI);
            if (this.isRotating()) {
                this.field_70125_A -= 20.0f;
            }
        }
        if (this.effect == EnumPotionType.Fire && !this.inGround) {
            this.func_70015_d(1);
        }
        int n = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
        int n2 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
        if ((this.isArrow() || this.sticksToWalls()) && n > 0) {
            twgu.field_71973_m[n].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            object = twgu.field_71973_m[n].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            if (object != null && ((eidj)object)._a(this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            if (n == this.inTile && n2 == this.inData) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.func_70106_y();
                }
            } else {
                this.inGround = false;
                this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            if (this.ticksInAir == 1200) {
                this.func_70106_y();
            }
            object = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            hank hank2 = this.field_70170_p.func_72831_a((ofbx)object, ofbx2, false, true);
            object = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (hank2 != null) {
                ofbx2 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
            }
            if (!this.field_70170_p.field_72995_K) {
                Entity entity = null;
                List list = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
                double d = 0.0;
                EntityLivingBase entityLivingBase = this.getThrower();
                for (int i = 0; i < list.size(); ++i) {
                    double d2;
                    float f;
                    eidj eidj2;
                    hank hank3;
                    Entity entity2 = (Entity)list.get(i);
                    if (!entity2.func_70067_L() || entity2 == this.thrower && this.ticksInAir < 5 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a((ofbx)object, ofbx2)) == null || !((d2 = ((ofbx)object)._d(hank3._h)) < d) && d != 0.0) continue;
                    entity = entity2;
                    d = d2;
                }
                if (entity != null) {
                    hank2 = new hank(entity);
                }
                if (hank2 != null && hank2._i != null && hank2._i instanceof EntityPlayer) {
                    EntityPlayer entityPlayer = (EntityPlayer)hank2._i;
                    if (this.thrower instanceof EntityNPCInterface && this.npc.getFaction().isFriendlyToPlayer(entityPlayer)) {
                        hank2 = null;
                    }
                }
            }
            if (hank2 != null) {
                if (hank2._c == amww._a && this.field_70170_p.func_72798_a(hank2._d, hank2._e, hank2._f) == twgu.field_72015_be.field_71990_ca) {
                    this.func_70063_aa();
                } else {
                    this.field_70180_af._b(29, (byte)0);
                    this.onImpact(hank2);
                }
            }
            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
            this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / Math.PI);
            while (this.field_70125_A - this.field_70127_C < -180.0f) {
                this.field_70127_C -= 360.0f;
            }
            while (this.field_70125_A - this.field_70127_C >= 180.0f) {
                this.field_70127_C += 360.0f;
            }
            while (this.field_70177_z - this.field_70126_B < -180.0f) {
                this.field_70126_B -= 360.0f;
            }
            while (this.field_70177_z - this.field_70126_B >= 180.0f) {
                this.field_70126_B += 360.0f;
            }
            float f2 = this.isArrow() ? 0.0f : 225.0f;
            this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) + f2 * 0.2f;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
            if (this.isRotating()) {
                int n3 = this.isBlock() ? 10 : 20;
                this.field_70125_A -= (float)(this.ticksInAir * n3) * this.getSpeed();
            }
            float f3 = this.getMotionFactor();
            float f4 = this.getGravityVelocity();
            if (this.func_70090_H()) {
                for (int i = 0; i < 4; ++i) {
                    float f5 = 0.25f;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f5, this.field_70163_u - this.field_70181_x * (double)f5, this.field_70161_v - this.field_70179_y * (double)f5, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
                f3 = 0.8f;
            }
            this.field_70159_w *= (double)f3;
            this.field_70181_x *= (double)f3;
            this.field_70179_y *= (double)f3;
            if (this.hasGravity()) {
                this.field_70181_x -= (double)f4;
            }
            if (this.accelerate) {
                this.field_70159_w += this.accelerationX;
                this.field_70181_x += this.accelerationY;
                this.field_70179_y += this.accelerationZ;
            }
            if (!this.field_70180_af._e(22).equals("")) {
                this.field_70170_p.func_72869_a(this.field_70180_af._e(22), this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
            }
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_70017_D();
        }
    }

    public boolean isBlock() {
        cvzo cvzo2 = this.getItemDisplay();
        return cvzo2 == null ? false : cvzo2._a() instanceof mbpd;
    }

    private int getItemId() {
        cvzo cvzo2 = this.getItemDisplay();
        return cvzo2 == null ? 0 : cvzo2._d;
    }

    protected float getMotionFactor() {
        return this.accelerate ? 0.95f : 1.0f;
    }

    protected void onImpact(hank hank2) {
        int n;
        int n2;
        Object object;
        float f;
        if (hank2._i != null) {
            f = this.damage;
            if (f == 0.0f) {
                f = 0.001f;
            }
            if (hank2._i.func_70097_a(jxtc.func_76356_a(this, this.getThrower()), f)) {
                float f2;
                if (hank2._i instanceof EntityLivingBase && (this.isArrow() || this.sticksToWalls())) {
                    object = (EntityLivingBase)hank2._i;
                    if (!this.field_70170_p.field_72995_K) {
                        ((EntityLivingBase)object).func_85034_r(((EntityLivingBase)object).func_85035_bI() + 1);
                    }
                    if (this.destroyedOnEntityHit && !(hank2._i instanceof EntityEnderman)) {
                        this.func_70106_y();
                    }
                }
                if (this.isBlock()) {
                    this.field_70170_p.func_72926_e(2001, (int)hank2._i.field_70165_t, (int)hank2._i.field_70163_u, (int)hank2._i.field_70161_v, this.getItemId());
                } else if (!this.isArrow() && !this.sticksToWalls()) {
                    for (n2 = 0; n2 < 8; ++n2) {
                        this.field_70170_p.func_72869_a("iconcrack_" + this.getItemId(), this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.15, this.field_70146_Z.nextGaussian() * 0.2, this.field_70146_Z.nextGaussian() * 0.15);
                    }
                }
                if (this.punch > 0 && (f2 = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y)) > 0.0f) {
                    hank2._i.func_70024_g(this.field_70159_w * (double)this.punch * (double)0.6f / (double)f2, 0.1, this.field_70179_y * (double)this.punch * (double)0.6f / (double)f2);
                }
                if (this.effect != EnumPotionType.None && hank2._i instanceof EntityLivingBase) {
                    if (this.effect != EnumPotionType.Fire) {
                        n2 = this.getPotionEffect(this.effect);
                        ((EntityLivingBase)hank2._i).func_70690_d(new supr(n2, this.duration * 20, this.amplify));
                    } else {
                        hank2._i.func_70015_d(this.duration);
                    }
                }
            } else if (this.hasGravity() && (this.isArrow() || this.sticksToWalls())) {
                this.field_70159_w *= (double)-0.1f;
                this.field_70181_x *= (double)-0.1f;
                this.field_70179_y *= (double)-0.1f;
                this.field_70177_z += 180.0f;
                this.field_70126_B += 180.0f;
                this.ticksInAir = 0;
            }
        } else if (!this.isArrow() && !this.sticksToWalls()) {
            if (this.isBlock()) {
                this.field_70170_p.func_72926_e(2001, hank2._d, hank2._e, hank2._f, this.getItemId());
            } else {
                for (n = 0; n < 8; ++n) {
                    this.field_70170_p.func_72869_a("iconcrack_" + this.getItemId(), this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.15, this.field_70146_Z.nextGaussian() * 0.2, this.field_70146_Z.nextGaussian() * 0.15);
                }
            }
        } else {
            this.xTile = hank2._d;
            this.yTile = hank2._e;
            this.zTile = hank2._f;
            this.inTile = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
            this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
            this.field_70159_w = (float)(hank2._h._c - this.field_70165_t);
            this.field_70181_x = (float)(hank2._h._d - this.field_70163_u);
            this.field_70179_y = (float)(hank2._h._e - this.field_70161_v);
            f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
            this.field_70165_t -= this.field_70159_w / (double)f * (double)0.05f;
            this.field_70163_u -= this.field_70181_x / (double)f * (double)0.05f;
            this.field_70161_v -= this.field_70179_y / (double)f * (double)0.05f;
            this.inGround = true;
            if (this.isArrow()) {
                this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
            } else {
                this.func_85030_a("random.break", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
            }
            this.arrowShake = 7;
            if (!this.hasGravity()) {
                this.field_70180_af._b(26, (byte)1);
            }
            if (this.inTile != 0) {
                twgu.field_71973_m[this.inTile].func_71869_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
            }
        }
        if (this.explosive) {
            if (this.explosiveRadius == 0 && this.effect != EnumPotionType.None) {
                if (this.effect == EnumPotionType.Fire) {
                    n = hank2._d;
                    n2 = hank2._e;
                    int n3 = hank2._f;
                    switch (hank2._g) {
                        case 0: {
                            --n2;
                            break;
                        }
                        case 1: {
                            ++n2;
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
                        case 4: {
                            --n;
                            break;
                        }
                        case 5: {
                            ++n;
                        }
                    }
                    if (this.field_70170_p.func_72799_c(n, n2, n3)) {
                        this.field_70170_p.func_94575_c(n, n2, n3, twgu.field_72067_ar.field_71990_ca);
                    }
                } else {
                    object = this.field_70121_D._b(4.0, 2.0, 4.0);
                    List list = this.field_70170_p.func_72872_a(EntityLivingBase.class, (eidj)object);
                    if (list != null && !list.isEmpty()) {
                        for (EntityLivingBase entityLivingBase : list) {
                            int n4;
                            double d = this.func_70068_e(entityLivingBase);
                            if (!(d < 16.0)) continue;
                            double d2 = 1.0 - Math.sqrt(d) / 4.0;
                            if (entityLivingBase == hank2._i) {
                                d2 = 1.0;
                            }
                            if (hdpq._a[n4 = this.getPotionEffect(this.effect)]._b()) {
                                hdpq._a[n4]._a(this.getThrower(), entityLivingBase, this.amplify, d2);
                                continue;
                            }
                            int n5 = (int)(d2 * (double)this.duration + 0.5);
                            if (n5 <= 20) continue;
                            entityLivingBase.func_70690_d(new supr(n4, n5, this.amplify));
                        }
                    }
                    this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), this.getPotionColor(this.effect));
                }
            } else {
                this.field_70170_p.func_72885_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explosiveRadius, this.effect == EnumPotionType.Fire, this.field_70170_p.func_82736_K()._b("mobGriefing"));
                if (this.explosiveRadius != 0 && (this.isArrow() || this.sticksToWalls())) {
                    this.func_70106_y();
                }
            }
        }
        if (!(this.field_70170_p.field_72995_K || this.isArrow() || this.sticksToWalls())) {
            this.func_70106_y();
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("xTile", (short)this.xTile);
        qoac2._a("yTile", (short)this.yTile);
        qoac2._a("zTile", (short)this.zTile);
        qoac2._a("inTile", (byte)this.inTile);
        qoac2._a("inData", (byte)this.inData);
        qoac2._a("shake", (byte)this.throwableShake);
        qoac2._a("inGround", (byte)(this.inGround ? 1 : 0));
        qoac2._a("isArrow", (byte)(this.isArrow() ? 1 : 0));
        qoac2._a("direction", this.func_70087_a(this.field_70159_w, this.field_70181_x, this.field_70179_y));
        qoac2._a("canBePickedUp", this.canBePickedUp);
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer) {
            this.throwerName = this.thrower.func_70023_ak();
        }
        qoac2._a("ownerName", this.throwerName == null ? "" : this.throwerName);
        if (this.getItemDisplay() != null) {
            qoac2._a("Item", this.getItemDisplay()._b(new qoac()));
        }
        qoac2._a("damagev2", this.damage);
        qoac2._a("punch", this.punch);
        qoac2._a("size", this.field_70180_af._c(23));
        qoac2._a("velocity", this.field_70180_af._c(25));
        qoac2._a("explosiveRadius", this.explosiveRadius);
        qoac2._a("effectDuration", this.duration);
        qoac2._a("gravity", this.hasGravity());
        qoac2._a("accelerate", this.accelerate);
        qoac2._a("glows", this.field_70180_af._a(24));
        qoac2._a("explosive", this.explosive);
        qoac2._a("PotionEffect", this.effect.ordinal());
        qoac2._a("trail", this.field_70180_af._e(22));
        qoac2._a("Render3D", this.field_70180_af._a(28));
        qoac2._a("Spins", this.field_70180_af._a(29));
        qoac2._a("Sticks", this.field_70180_af._a(30));
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        cvzo cvzo2;
        huhy huhy2;
        this.xTile = qoac2._e("xTile");
        this.yTile = qoac2._e("yTile");
        this.zTile = qoac2._e("zTile");
        this.inTile = qoac2._d("inTile") & 0xFF;
        this.inData = qoac2._d("inData") & 0xFF;
        this.throwableShake = qoac2._d("shake") & 0xFF;
        this.inGround = qoac2._d("inGround") == 1;
        this.field_70180_af._b(27, qoac2._d("isArrow"));
        this.throwerName = qoac2._j("ownerName");
        this.canBePickedUp = qoac2._o("canBePickedUp");
        this.damage = qoac2._h("damagev2");
        this.punch = qoac2._f("punch");
        this.explosiveRadius = qoac2._f("explosiveRadius");
        this.duration = qoac2._f("effectDuration");
        this.accelerate = qoac2._o("accelerate");
        this.explosive = qoac2._o("explosive");
        this.effect = EnumPotionType.values()[qoac2._f("PotionEffect") % EnumPotionType.values().length];
        this.field_70180_af._b(22, qoac2._j("trail"));
        this.field_70180_af._b(23, qoac2._f("size"));
        this.field_70180_af._b(24, (byte)(qoac2._o("glows") ? 1 : 0));
        this.field_70180_af._b(25, qoac2._f("velocity"));
        this.field_70180_af._b(26, (byte)(qoac2._o("gravity") ? 1 : 0));
        this.field_70180_af._b(28, (byte)(qoac2._o("Render3D") ? 1 : 0));
        this.field_70180_af._b(29, (byte)(qoac2._o("Spins") ? 1 : 0));
        this.field_70180_af._b(30, (byte)(qoac2._o("Sticks") ? 1 : 0));
        if (this.throwerName != null && this.throwerName.length() == 0) {
            this.throwerName = null;
        }
        if (qoac2._c("direction")) {
            huhy2 = qoac2._n("direction");
            this.field_70159_w = ((qoae)((bsyv)huhy2)._b((int)0))._c;
            this.field_70181_x = ((qoae)((bsyv)huhy2)._b((int)1))._c;
            this.field_70179_y = ((qoae)((bsyv)huhy2)._b((int)2))._c;
        }
        if ((cvzo2 = cvzo._a((qoac)(huhy2 = qoac2._m("Item")))) == null) {
            this.func_70106_y();
        } else {
            this.field_70180_af._b(21, cvzo2);
        }
    }

    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0) {
            this.thrower = this.field_70170_p.func_72924_a(this.throwerName);
        }
        return this.thrower;
    }

    private int getPotionEffect(EnumPotionType enumPotionType) {
        switch (NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[enumPotionType.ordinal()]) {
            case 1: {
                return hdpq._u._H;
            }
            case 2: {
                return hdpq._s._H;
            }
            case 3: {
                return hdpq._t._H;
            }
            case 4: {
                return hdpq._d._H;
            }
            case 5: {
                return hdpq._k._H;
            }
            case 6: {
                return hdpq._q._H;
            }
            case 7: {
                return hdpq._v._H;
            }
        }
        return 0;
    }

    private int getPotionColor(EnumPotionType enumPotionType) {
        switch (NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[enumPotionType.ordinal()]) {
            case 1: {
                return 32660;
            }
            case 2: {
                return 32660;
            }
            case 3: {
                return 32696;
            }
            case 4: {
                return 32698;
            }
            case 5: {
                return 32732;
            }
            case 6: {
                return hdpq._q._H;
            }
            case 7: {
                return 32732;
            }
        }
        return 0;
    }

    public void getStatProperties(DataStats dataStats) {
        this.damage = dataStats.pDamage;
        this.punch = dataStats.pImpact;
        this.accelerate = dataStats.pXlr8;
        this.explosive = dataStats.pExplode;
        this.explosiveRadius = dataStats.pArea;
        this.effect = dataStats.pEffect;
        this.duration = dataStats.pDur;
        this.amplify = dataStats.pEffAmp;
        this.setParticleEffect(dataStats.pTrail);
        this.field_70180_af._b(23, dataStats.pSize);
        this.field_70180_af._b(24, (byte)(dataStats.pGlows ? 1 : 0));
        this.setSpeed(dataStats.pSpeed);
        this.setHasGravity(dataStats.pPhysics);
        this.setIs3D(dataStats.pRender3D);
        this.setRotating(dataStats.pSpin);
        this.setStickInWall(dataStats.pStick);
    }

    public void setParticleEffect(EnumParticleType enumParticleType) {
        this.field_70180_af._b(22, enumParticleType.particleName);
    }

    public void setHasGravity(boolean bl) {
        this.field_70180_af._b(26, (byte)(bl ? 1 : 0));
    }

    public void setIs3D(boolean bl) {
        this.field_70180_af._b(28, (byte)(bl ? 1 : 0));
    }

    public void setStickInWall(boolean bl) {
        this.field_70180_af._b(30, (byte)(bl ? 1 : 0));
    }

    public cvzo getItemDisplay() {
        return this.field_70180_af._f(21);
    }

    @Override
    public float func_70013_c(float f) {
        return this.field_70180_af._a(24) == 1 ? 1.0f : super.func_70013_c(f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_70070_b(float f) {
        return this.field_70180_af._a(24) == 1 ? 0xF000F0 : super.func_70070_b(f);
    }

    public boolean hasGravity() {
        return this.field_70180_af._a(26) == 1;
    }

    public float getSpeed() {
        return (float)this.field_70180_af._c(25) / 10.0f;
    }

    public void setSpeed(int n) {
        this.field_70180_af._b(25, n);
    }

    public boolean isArrow() {
        return this.field_70180_af._a(27) == 1;
    }

    public boolean isRotating() {
        return this.field_70180_af._a(29) == 1;
    }

    public void setRotating(boolean bl) {
        this.field_70180_af._b(29, (byte)(bl ? 1 : 0));
    }

    public boolean glows() {
        return this.field_70180_af._a(24) == 1;
    }

    public boolean is3D() {
        return this.field_70180_af._a(28) == 1 || this.isBlock();
    }

    public boolean sticksToWalls() {
        return this.is3D() && this.field_70180_af._a(30) == 1;
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
        if (!this.field_70170_p.field_72995_K && this.canBePickedUp && this.inGround && this.arrowShake <= 0 && entityPlayer.field_71071_by._c(this.getItemDisplay())) {
            this.inGround = false;
            this.func_85030_a("random.pop", 0.2f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.func_71001_a(this, 1);
            this.func_70106_y();
        }
    }

    @Override
    protected boolean func_70041_e_() {
        return false;
    }

    static class NamelessClass1971811639 {
        static final int[] $SwitchMap$noppes$npcs$constants$EnumPotionType = new int[EnumPotionType.values().length];

        NamelessClass1971811639() {
        }

        static {
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Poison.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Hunger.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Weakness.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Slowness.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Nausea.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Blindness.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Wither.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

