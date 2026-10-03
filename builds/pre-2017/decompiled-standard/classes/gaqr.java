/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class gaqr
extends hurg {
    public float _a;
    public float _b;
    public int _c;
    public int _d;

    @Override
    public void func_70316_g() {
        double d;
        super.func_70316_g();
        if (++this._d % 20 * 4 == 0) {
            this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, twgu.field_72066_bS.field_71990_ca, 1, this._c);
        }
        this._b = this._a;
        float f = 0.1f;
        if (this._c > 0 && this._a == 0.0f) {
            double d2 = (double)this.field_70329_l + 0.5;
            d = (double)this.field_70327_n + 0.5;
            this.field_70331_k.func_72908_a(d2, (double)this.field_70330_m + 0.5, d, "random.chestopen", 0.5f, this.field_70331_k.field_73012_v.nextFloat() * 0.1f + 0.9f);
        }
        if (this._c == 0 && this._a > 0.0f || this._c > 0 && this._a < 1.0f) {
            float f2;
            float f3 = this._a;
            this._a = this._c > 0 ? (this._a += f) : (this._a -= f);
            if (this._a > 1.0f) {
                this._a = 1.0f;
            }
            if (this._a < (f2 = 0.5f) && f3 >= f2) {
                d = (double)this.field_70329_l + 0.5;
                double d3 = (double)this.field_70327_n + 0.5;
                this.field_70331_k.func_72908_a(d, (double)this.field_70330_m + 0.5, d3, "random.chestclosed", 0.5f, this.field_70331_k.field_73012_v.nextFloat() * 0.1f + 0.9f);
            }
            if (this._a < 0.0f) {
                this._a = 0.0f;
            }
        }
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 1) {
            this._c = n2;
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @Override
    public void func_70313_j() {
        this.func_70321_h();
        super.func_70313_j();
    }

    public void _a() {
        ++this._c;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, twgu.field_72066_bS.field_71990_ca, 1, this._c);
    }

    public void _b() {
        --this._c;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, twgu.field_72066_bS.field_71990_ca, 1, this._c);
    }

    public boolean _a(EntityPlayer entityPlayer) {
        if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
            return false;
        }
        return !(entityPlayer.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) > 64.0);
    }
}

