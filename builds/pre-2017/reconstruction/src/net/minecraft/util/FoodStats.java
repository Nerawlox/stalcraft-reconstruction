/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class FoodStats {
    public int _a = 20;
    public float _b = 5.0f;
    public float _c;
    public int _d;
    public int _e = 20;

    public void _a(int n, float f) {
        this._a = Math.min(n + this._a, 20);
        this._b = Math.min(this._b + (float)n * f * 2.0f, (float)this._a);
    }

    public void _a(ItemFood itemFood) {
        this._a(itemFood.getHealAmount(), itemFood.getSaturationModifier());
    }

    public void _a(EntityPlayer entityPlayer) {
        int n = entityPlayer.worldObj.difficultySetting;
        this._e = this._a;
        if (this._c > 4.0f) {
            this._c -= 4.0f;
            if (this._b > 0.0f) {
                this._b = Math.max(this._b - 1.0f, 0.0f);
            } else if (n > 0) {
                this._a = Math.max(this._a - 1, 0);
            }
        }
        if (entityPlayer.worldObj.getGameRules()._b("naturalRegeneration") && this._a >= 18 && entityPlayer.shouldHeal()) {
            ++this._d;
            if (this._d >= 80) {
                entityPlayer.heal(1.0f);
                this._a(3.0f);
                this._d = 0;
            }
        } else if (this._a <= 0) {
            ++this._d;
            if (this._d >= 80) {
                if (entityPlayer.getHealth() > 10.0f || n >= 3 || entityPlayer.getHealth() > 1.0f && n >= 2) {
                    entityPlayer.attackEntityFrom(DamageSource.starve, 1.0f);
                }
                this._d = 0;
            }
        } else {
            this._d = 0;
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("foodLevel")) {
            this._a = nBTTagCompound._f("foodLevel");
            this._d = nBTTagCompound._f("foodTickTimer");
            this._b = nBTTagCompound._h("foodSaturationLevel");
            this._c = nBTTagCompound._h("foodExhaustionLevel");
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("foodLevel", this._a);
        nBTTagCompound._a("foodTickTimer", this._d);
        nBTTagCompound._a("foodSaturationLevel", this._b);
        nBTTagCompound._a("foodExhaustionLevel", this._c);
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._e;
    }

    public boolean _c() {
        return this._a < 20;
    }

    public void _a(float f) {
        this._c = Math.min(this._c + f, 40.0f);
    }

    public float _d() {
        return this._b;
    }

    public void _a(int n) {
        this._a = n;
    }

    public void _b(float f) {
        this._b = f;
    }
}

