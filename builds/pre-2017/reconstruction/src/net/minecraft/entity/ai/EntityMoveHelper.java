/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.sajz;
import net.minecraft.util.sajh;

public class EntityMoveHelper {
    public EntityLiving _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public boolean _f;

    public EntityMoveHelper(EntityLiving entityLiving) {
        this._a = entityLiving;
        this._b = entityLiving.posX;
        this._c = entityLiving.posY;
        this._d = entityLiving.posZ;
    }

    public boolean _a() {
        return this._f;
    }

    public double _b() {
        return this._e;
    }

    public void _a(double d, double d2, double d3, double d4) {
        this._b = d;
        this._c = d2;
        this._d = d3;
        this._e = d4;
        this._f = true;
    }

    public void _c() {
        double d;
        this._a.setMoveForward(0.0f);
        if (!this._f) {
            return;
        }
        this._f = false;
        double d2 = this._b - this._a.posX;
        int n = sajh._c(this._a.boundingBox._c + 0.5);
        double d3 = this._c - (double)n;
        double d4 = d2 * d2 + d3 * d3 + (d = this._d - this._a.posZ) * d;
        if (d4 < 2.500000277905201E-7) {
            return;
        }
        float f = (float)(Math.atan2(d, d2) * 180.0 / 3.1415927410125732) - 90.0f;
        this._a.rotationYaw = this._a(this._a.rotationYaw, f, 30.0f);
        this._a.setAIMoveSpeed((float)(this._e * this._a.getEntityAttribute(sajz._d)._e()));
        if (d3 > 0.0 && d2 * d2 + d * d < 1.0) {
            this._a.getJumpHelper()._a();
        }
    }

    public float _a(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }
}

