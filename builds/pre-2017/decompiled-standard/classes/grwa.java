/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;

public class grwa
extends mbsl {
    public boolean _q;
    public boolean _r;
    public int _s;
    public int _t;

    public grwa(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public void _c() {
        super._c();
        ++this._t;
        long l = this._b.func_82737_E();
        long l2 = l / 24000L + 1L;
        if (!this._q && this._t > 20) {
            this._q = true;
            this._c.field_71135_a.func_72567_b(new tgph(5, 0));
        }
        boolean bl = this._r = l > 120500L;
        if (this._r) {
            ++this._s;
        }
        if (l % 24000L == 500L) {
            if (l2 <= 6L) {
                this._c.func_70006_a(zwat._e("demo.day." + l2));
            }
        } else if (l2 == 1L) {
            if (l == 100L) {
                this._c.field_71135_a.func_72567_b(new tgph(5, 101));
            } else if (l == 175L) {
                this._c.field_71135_a.func_72567_b(new tgph(5, 102));
            } else if (l == 250L) {
                this._c.field_71135_a.func_72567_b(new tgph(5, 103));
            }
        } else if (l2 == 5L && l % 24000L == 22000L) {
            this._c.func_70006_a(zwat._e("demo.day.warning"));
        }
    }

    public void _e() {
        if (this._s > 100) {
            this._c.func_70006_a(zwat._e("demo.reminder"));
            this._s = 0;
        }
    }

    @Override
    public void _a(int n, int n2, int n3, int n4) {
        if (this._r) {
            this._e();
            return;
        }
        super._a(n, n2, n3, n4);
    }

    @Override
    public void _a(int n, int n2, int n3) {
        if (this._r) {
            return;
        }
        super._a(n, n2, n3);
    }

    @Override
    public boolean _d(int n, int n2, int n3) {
        if (this._r) {
            return false;
        }
        return super._d(n, n2, n3);
    }

    @Override
    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2) {
        if (this._r) {
            this._e();
            return false;
        }
        return super._a(entityPlayer, ozlu2, cvzo2);
    }

    @Override
    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (this._r) {
            this._e();
            return false;
        }
        return super._a(entityPlayer, ozlu2, cvzo2, n, n2, n3, n4, f, f2, f3);
    }
}

