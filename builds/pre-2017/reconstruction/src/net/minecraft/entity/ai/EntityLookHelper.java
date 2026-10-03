/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;

public class EntityLookHelper {
    public EntityLiving _a;
    public float _b;
    public float _c;
    public boolean _d;
    public double _e;
    public double _f;
    public double _g;

    public EntityLookHelper(EntityLiving entityLiving) {
        this._a = entityLiving;
    }

    public void _a(Entity entity, float f, float f2) {
        this._e = entity.posX;
        this._f = entity instanceof EntityLivingBase ? entity.posY + (double)entity.getEyeHeight() : (entity.boundingBox._c + entity.boundingBox._f) / 2.0;
        this._g = entity.posZ;
        this._b = f;
        this._c = f2;
        this._d = true;
    }

    public void _a(double d, double d2, double d3, float f, float f2) {
        this._e = d;
        this._f = d2;
        this._g = d3;
        this._b = f;
        this._c = f2;
        this._d = true;
    }

    public void _a() {
        this._a.rotationPitch = 0.0f;
        if (this._d) {
            this._d = false;
            double d = this._e - this._a.posX;
            double d2 = this._f - (this._a.posY + (double)this._a.getEyeHeight());
            double d3 = this._g - this._a.posZ;
            double d4 = sajh._a(d * d + d3 * d3);
            float f = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
            float f2 = (float)(-(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732));
            this._a.rotationPitch = this._a(this._a.rotationPitch, f2, this._c);
            this._a.rotationYawHead = this._a(this._a.rotationYawHead, f, this._b);
        } else {
            this._a.rotationYawHead = this._a(this._a.rotationYawHead, this._a.renderYawOffset, 10.0f);
        }
        float f = sajh._g(this._a.rotationYawHead - this._a.renderYawOffset);
        if (!this._a.getNavigator()._g()) {
            if (f < -75.0f) {
                this._a.rotationYawHead = this._a.renderYawOffset - 75.0f;
            }
            if (f > 75.0f) {
                this._a.rotationYawHead = this._a.renderYawOffset + 75.0f;
            }
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

