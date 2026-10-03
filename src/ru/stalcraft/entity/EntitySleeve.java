/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;

public class EntitySleeve
extends uq {
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
    public final bjo texture;
    private static final int LIFETIME = 250;

    public EntitySleeve(abw par1World, of shooter, boolean isShooterPlayer, ItemWeapon weapon) {
        super(par1World);
        boolean canAim = shooter == atv.w().h && ((ClientWeaponInfo)PlayerUtils.getInfo((uf)atv.w().h).weaponInfo).isAiming();
        this.b(shooter.u, shooter.v + (double)shooter.f() - (isShooterPlayer ? 0.3 : 0.1), shooter.w, shooter.aP, shooter.B);
        if (!canAim) {
            this.u -= (double)(ls.b(this.A / 180.0f * (float)Math.PI) * 0.35f);
            this.w -= (double)(ls.a(this.A / 180.0f * (float)Math.PI) * 0.35f);
        }
        double lookX = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        double lookY = -ls.a(this.B / 180.0f * (float)Math.PI);
        double lookZ = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        double ySpeed = ls.a((this.B + 90.0f) / 180.0f * (float)Math.PI);
        atc look = atc.a((double)lookX, (double)lookY, (double)lookZ).a();
        this.u += look.c * 0.4;
        this.v += look.d * 0.4;
        this.w += look.e * 0.4;
        if (canAim) {
            this.u += (double)((weapon.aimPosZ + 1.0f) / 2.0f) * look.c;
            this.v += (double)((weapon.aimPosZ + 1.0f) / 2.0f) * look.d;
            this.w += (double)((weapon.aimPosZ + 1.0f) / 2.0f) * look.e;
        } else if (shooter == atv.w().h) {
            this.u += look.c * 0.5;
            this.v += look.d * 0.5;
            this.w += look.e * 0.5;
        }
        look.b((float)Math.toRadians(-90.0));
        this.y = ySpeed * 0.25;
        this.x = look.c * 0.15;
        this.z = look.e * 0.15;
        this.y *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.x *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.z *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.u += this.x / 2.0;
        this.w += this.z / 2.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.a(0.05f, 0.05f);
        this.P = 0.05f;
        this.model = weapon.sleeveModel;
        this.texture = weapon.sleeveTexture;
    }

    public EntitySleeve(abw par1World, double posX, double posY, double posZ, float yaw, float pitch, float distanceFactor, String sleeve) {
        super(par1World);
        this.b(posX, posY - 0.3, posZ, yaw, pitch);
        double ySpeed = ls.a((this.B + 90.0f) / 180.0f * (float)Math.PI);
        this.y = ySpeed * 0.25;
        this.x = (double)(-ls.a((yaw += 90.0f) / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI)) * 0.15;
        this.z = (double)(ls.b(yaw / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI)) * 0.15;
        this.u += (double)(-ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI)) * (double)distanceFactor;
        this.w += (double)(ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI)) * (double)distanceFactor;
        this.v += (double)(-ls.a(this.B / 180.0f * (float)Math.PI)) * (double)distanceFactor + 0.1;
        this.u += this.x / 2.0;
        this.v += this.y / 2.0;
        this.w += this.z / 2.0;
        this.y *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.x *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.z *= 1.0 + (Math.random() - 0.5) / 2.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.a(0.05f, 0.05f);
        this.P = 0.05f;
        this.model = sleeve;
        this.texture = new bjo("stalker", "models/sleeves/" + sleeve + ".png");
    }

    @Override
    protected float e() {
        return 0.07f;
    }

    @Override
    public void l_() {
        super.l_();
        float rotationFactor = this.v == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= rotationFactor;
        this.yRotationSpeed *= rotationFactor;
        this.zRotationSpeed *= rotationFactor;
        this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
        this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
        this.prevY = this.v;
        if (this.ac > 250) {
            this.x();
        }
    }

    @Override
    protected void a(ata mop) {
        if (mop.g != null || aqz.s[this.q.a(mop.b, mop.c, mop.d)].b(this.q, mop.b, mop.c, mop.d) != null) {
            if (mop.a.ordinal() == 0) {
                this.pushOff(mop.b, mop.c, mop.d, mop.e);
            } else {
                this.hitEntity(mop.g);
            }
        }
    }

    protected void hitEntity(nn entity) {
        this.x *= -0.5;
        this.y *= -0.5;
        this.z *= -0.5;
        this.xRotationSpeed *= 0.5f;
        this.yRotationSpeed *= 0.5f;
        this.zRotationSpeed *= 0.5f;
        this.calculateNewImpact();
    }

    protected void pushOff(int blockX, int blockY, int blockZ, int side) {
        boolean setY;
        boolean bl2 = setY = Math.abs(this.y) > (double)0.2f || side == 0;
        if (side != 0 && side != 1) {
            if (side != 2 && side != 3) {
                this.x *= -0.5;
                this.y *= (double)0.8f;
                this.z *= 0.5;
            } else {
                this.x *= 0.5;
                this.y *= (double)0.8f;
                this.z *= -0.5;
            }
        } else if (setY) {
            this.x *= (double)0.8f;
            this.y *= -0.5;
            this.z *= (double)0.8f;
            this.renderOnGround = false;
        } else {
            this.x *= (double)0.8f;
            this.y = 0.0;
            this.z *= (double)0.8f;
            this.xRotationSpeed = 0.0f;
            this.zRotationSpeed = 0.0f;
            this.xRotation = 0.0f;
            this.zRotation = 0.0f;
            this.renderOnGround = true;
        }
        if (!setY) {
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
        atc vec3 = this.q.V().a(this.u, this.v, this.w);
        atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        ata movingobjectposition = this.q.a(vec3, vec31);
        vec3 = this.q.V().a(this.u, this.v, this.w);
        vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        if (movingobjectposition != null) {
            vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
        }
        if (!this.q.I) {
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            of entityliving = this.h();
            for (int j2 = 0; j2 < list.size(); ++j2) {
                double d1;
                float f2;
                asx axisalignedbb;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1 == entityliving && this.ac < 5 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)(f2 = 0.3f), (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.a == atb.a && this.q.a(movingobjectposition.b, movingobjectposition.c, movingobjectposition.d) == aqz.bj.cF) {
                this.ab();
            } else {
                this.a(movingobjectposition);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
    }
}

