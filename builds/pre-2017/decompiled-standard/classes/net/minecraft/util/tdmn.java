/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;

public class tdmn {
    public int _a = 20;
    public float _b = 5.0f;
    public float _c;
    public int _d;
    public int _e = 20;

    public void _a(int n, float f) {
        this._a = Math.min(n + this._a, 20);
        this._b = Math.min(this._b + (float)n * f * 2.0f, (float)this._a);
    }

    public void _a(tgha tgha2) {
        this._a(tgha2.func_77847_f(), tgha2.func_77846_g());
    }

    public void _a(EntityPlayer entityPlayer) {
        int n = entityPlayer.field_70170_p.field_73013_u;
        this._e = this._a;
        if (this._c > 4.0f) {
            this._c -= 4.0f;
            if (this._b > 0.0f) {
                this._b = Math.max(this._b - 1.0f, 0.0f);
            } else if (n > 0) {
                this._a = Math.max(this._a - 1, 0);
            }
        }
        if (entityPlayer.field_70170_p.func_82736_K()._b("naturalRegeneration") && this._a >= 18 && entityPlayer.func_70996_bM()) {
            ++this._d;
            if (this._d >= 80) {
                entityPlayer.func_70691_i(1.0f);
                this._a(3.0f);
                this._d = 0;
            }
        } else if (this._a <= 0) {
            ++this._d;
            if (this._d >= 80) {
                if (entityPlayer.func_110143_aJ() > 10.0f || n >= 3 || entityPlayer.func_110143_aJ() > 1.0f && n >= 2) {
                    entityPlayer.func_70097_a(jxtc.field_76366_f, 1.0f);
                }
                this._d = 0;
            }
        } else {
            this._d = 0;
        }
    }

    public void _a(qoac qoac2) {
        if (qoac2._c("foodLevel")) {
            this._a = qoac2._f("foodLevel");
            this._d = qoac2._f("foodTickTimer");
            this._b = qoac2._h("foodSaturationLevel");
            this._c = qoac2._h("foodExhaustionLevel");
        }
    }

    public void _b(qoac qoac2) {
        qoac2._a("foodLevel", this._a);
        qoac2._a("foodTickTimer", this._d);
        qoac2._a("foodSaturationLevel", this._b);
        qoac2._a("foodExhaustionLevel", this._c);
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

