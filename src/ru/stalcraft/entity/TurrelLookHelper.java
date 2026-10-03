/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import ru.stalcraft.entity.EntityTurrel;

public class TurrelLookHelper {
    private EntityTurrel entity;
    private float deltaLookYaw;
    private float deltaLookPitch;
    private boolean isLooking;
    private double posX;
    private double posY;
    private double posZ;

    public TurrelLookHelper(EntityTurrel entity) {
        this.entity = entity;
    }

    public void setLookPositionWithEntity(nn par1Entity, float par2, float par3) {
        this.posX = par1Entity.u;
        this.posY = par1Entity instanceof of ? par1Entity.v + (double)par1Entity.f() : (par1Entity.E.b + par1Entity.E.e) / 2.0;
        this.posZ = par1Entity.w;
        this.deltaLookYaw = par2;
        this.deltaLookPitch = par3;
        this.isLooking = true;
    }

    public void setLookPosition(double par1, double par3, double par5, float par7, float par8) {
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        this.deltaLookYaw = par7;
        this.deltaLookPitch = par8;
        this.isLooking = true;
    }

    public void onUpdateLook() {
        this.entity.B = 0.0f;
        if (this.isLooking) {
            this.isLooking = false;
            double d0 = this.posX - this.entity.u;
            double d1 = this.posY - (this.entity.v + (double)this.entity.f());
            double d2 = this.posZ - this.entity.w;
            double d3 = ls.a(d0 * d0 + d2 * d2);
            float f2 = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0f;
            float f1 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
            this.entity.B = this.updateRotation(this.entity.B, f1, this.deltaLookPitch);
            this.entity.A = this.updateRotation(this.entity.A, f2, this.deltaLookYaw);
        }
    }

    private float updateRotation(float par1, float par2, float par3) {
        float f3 = ls.g(par2 - par1);
        if (f3 > par3) {
            f3 = par3;
        }
        if (f3 < -par3) {
            f3 = -par3;
        }
        return par1 + f3;
    }
}

