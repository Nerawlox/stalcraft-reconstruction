/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;

public class zwat {
    public EntityLivingBase _a;
    public int _b;
    public float _c;

    public zwat(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase;
    }

    public void _a() {
        double d = this._a.posX - this._a.prevPosX;
        double d2 = this._a.posZ - this._a.prevPosZ;
        if (d * d + d2 * d2 > 2.500000277905201E-7) {
            this._a.renderYawOffset = this._a.rotationYaw;
            this._c = this._a.rotationYawHead = this._a(this._a.renderYawOffset, this._a.rotationYawHead, 75.0f);
            this._b = 0;
            return;
        }
        float f = 75.0f;
        if (Math.abs(this._a.rotationYawHead - this._c) > 15.0f) {
            this._b = 0;
            this._c = this._a.rotationYawHead;
        } else {
            ++this._b;
            int n = 10;
            if (this._b > 10) {
                f = Math.max(1.0f - (float)(this._b - 10) / 10.0f, 0.0f) * 75.0f;
            }
        }
        this._a.renderYawOffset = this._a(this._a.rotationYawHead, this._a.renderYawOffset, f);
    }

    public float _a(float f, float f2, float f3) {
        float f4 = sajh._g(f - f2);
        if (f4 < -f3) {
            f4 = -f3;
        }
        if (f4 >= f3) {
            f4 = f3;
        }
        return f - f4;
    }
}

