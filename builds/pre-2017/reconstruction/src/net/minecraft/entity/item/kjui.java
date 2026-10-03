/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.sajh;

public class kjui
implements IUpdatePlayerListBox {
    public final jzqf _a;
    public final EntityMinecart _b;
    public final EntityPlayerSP _c;
    public boolean _d;
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public float _h;
    public float _i;
    public float _j;
    public double _k;

    public kjui(jzqf jzqf2, EntityMinecart entityMinecart, EntityPlayerSP entityPlayerSP) {
        this._a = jzqf2;
        this._b = entityMinecart;
        this._c = entityPlayerSP;
    }

    @Override
    public void _a() {
        boolean bl = false;
        boolean bl2 = this._d;
        boolean bl3 = this._e;
        boolean bl4 = this._f;
        float f = this._i;
        float f2 = this._h;
        float f3 = this._j;
        double d = this._k;
        this._d = this._c != null && this._b.riddenByEntity == this._c;
        this._e = this._b.isDead;
        this._k = sajh._a(this._b.motionX * this._b.motionX + this._b.motionZ * this._b.motionZ);
        boolean bl5 = this._f = this._k >= 0.01;
        if (bl2 && !this._d) {
            this._a._c(this._c);
        }
        if (this._e || !this._g && this._i == 0.0f && this._j == 0.0f) {
            if (!bl3) {
                this._a._c(this._b);
                if (bl2 || this._d) {
                    this._a._c(this._c);
                }
            }
            this._g = true;
            if (this._e) {
                return;
            }
        }
        if (!this._a._b(this._b) && this._i > 0.0f) {
            this._a._a("minecart.base", this._b, this._i, this._h, false);
            this._g = false;
            bl = true;
        }
        if (this._d && !this._a._b(this._c) && this._j > 0.0f) {
            this._a._a("minecart.inside", this._c, this._j, 1.0f, true);
            this._g = false;
            bl = true;
        }
        if (this._f) {
            if (this._h < 1.0f) {
                this._h += 0.0025f;
            }
            if (this._h > 1.0f) {
                this._h = 1.0f;
            }
            float f4 = sajh._a((float)this._k, 0.0f, 4.0f) / 4.0f;
            this._j = 0.0f + f4 * 0.75f;
            f4 = sajh._a(f4 * 2.0f, 0.0f, 1.0f);
            this._i = 0.0f + f4 * 0.7f;
        } else if (bl4) {
            this._i = 0.0f;
            this._h = 0.0f;
            this._j = 0.0f;
        }
        if (!this._g) {
            if (this._h != f2) {
                this._a._b(this._b, this._h);
            }
            if (this._i != f) {
                this._a._a((Entity)this._b, this._i);
            }
            if (this._j != f3) {
                this._a._a((Entity)this._c, this._j);
            }
        }
        if (!bl && (this._i > 0.0f || this._j > 0.0f)) {
            this._a._a(this._b);
            if (this._d) {
                this._a._a((Entity)this._c, this._b);
            }
        } else {
            if (this._a._b(this._b)) {
                this._a._c(this._b);
            }
            if (this._d && this._a._b(this._c)) {
                this._a._c(this._c);
            }
        }
    }
}

