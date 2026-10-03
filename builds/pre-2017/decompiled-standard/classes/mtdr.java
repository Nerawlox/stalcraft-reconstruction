/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class mtdr
extends hurg {
    public int _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public float _i;
    public float _j;
    public static Random _k = new Random();
    public String _l;

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        if (this._b()) {
            qoac2._a("CustomName", this._l);
        }
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        if (qoac2._c("CustomName")) {
            this._l = qoac2._j("CustomName");
        }
    }

    @Override
    public void func_70316_g() {
        float f;
        super.func_70316_g();
        this._g = this._f;
        this._i = this._h;
        EntityPlayer entityPlayer = this.field_70331_k.func_72977_a((float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, 3.0);
        if (entityPlayer != null) {
            double d = entityPlayer.field_70165_t - (double)((float)this.field_70329_l + 0.5f);
            double d2 = entityPlayer.field_70161_v - (double)((float)this.field_70327_n + 0.5f);
            this._j = (float)Math.atan2(d2, d);
            this._f += 0.1f;
            if (this._f < 0.5f || _k.nextInt(40) == 0) {
                float f2 = this._d;
                do {
                    this._d += (float)(_k.nextInt(4) - _k.nextInt(4));
                } while (f2 == this._d);
            }
        } else {
            this._j += 0.02f;
            this._f -= 0.1f;
        }
        while (this._h >= (float)Math.PI) {
            this._h -= (float)Math.PI * 2;
        }
        while (this._h < (float)(-Math.PI)) {
            this._h += (float)Math.PI * 2;
        }
        while (this._j >= (float)Math.PI) {
            this._j -= (float)Math.PI * 2;
        }
        while (this._j < (float)(-Math.PI)) {
            this._j += (float)Math.PI * 2;
        }
        for (f = this._j - this._h; f >= (float)Math.PI; f -= (float)Math.PI * 2) {
        }
        while (f < (float)(-Math.PI)) {
            f += (float)Math.PI * 2;
        }
        this._h += f * 0.4f;
        if (this._f < 0.0f) {
            this._f = 0.0f;
        }
        if (this._f > 1.0f) {
            this._f = 1.0f;
        }
        ++this._a;
        this._c = this._b;
        float f3 = (this._d - this._b) * 0.4f;
        float f4 = 0.2f;
        if (f3 < -f4) {
            f3 = -f4;
        }
        if (f3 > f4) {
            f3 = f4;
        }
        this._e += (f3 - this._e) * 0.9f;
        this._b += this._e;
    }

    public String _a() {
        return this._b() ? this._l : "container.enchant";
    }

    public boolean _b() {
        return this._l != null && this._l.length() > 0;
    }

    public void _a(String string) {
        this._l = string;
    }
}

