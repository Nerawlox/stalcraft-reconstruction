/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.eifc;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class wowp
extends bawa {
    public final xpzm _a;
    public final List _b = new ArrayList();
    public final List _c = new ArrayList();
    public final List _d = new ArrayList();
    public int _e;
    public boolean _f;

    public wowp(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public void _a(int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        if (this._a._M.field_74343_n == 2) {
            return;
        }
        int n6 = this._i();
        boolean bl = false;
        int n7 = 0;
        int n8 = this._d.size();
        float f = this._a._M.field_74357_r * 0.9f + 0.1f;
        if (n8 <= 0) {
            return;
        }
        if (this._e()) {
            bl = true;
        }
        float f2 = this._h();
        int n9 = sajh._f((float)this._f() / f2);
        GL11.glPushMatrix();
        GL11.glTranslatef(2.0f, 20.0f, 0.0f);
        GL11.glScalef(f2, f2, 1.0f);
        for (n5 = 0; n5 + this._e < this._d.size() && n5 < n6; ++n5) {
            uzpa uzpa2 = (uzpa)this._d.get(n5 + this._e);
            if (uzpa2 == null || (n4 = n - uzpa2._b()) >= 200 && !bl) continue;
            double d = (double)n4 / 200.0;
            d = 1.0 - d;
            if ((d *= 10.0) < 0.0) {
                d = 0.0;
            }
            if (d > 1.0) {
                d = 1.0;
            }
            d *= d;
            n3 = (int)(255.0 * d);
            if (bl) {
                n3 = 255;
            }
            n3 = (int)((float)n3 * f);
            ++n7;
            if (n3 <= 3) continue;
            n2 = 0;
            int n10 = -n5 * 9;
            wowp.func_73734_a(n2, n10 - 9, n2 + n9 + 4, n10, n3 / 2 << 24);
            GL11.glEnable(3042);
            String string = uzpa2._a();
            if (!this._a._M.field_74344_o) {
                string = eifc._a(string);
            }
            this._a._z._a(string, n2, n10 - 8, 0xFFFFFF + (n3 << 24));
        }
        if (bl) {
            n5 = this._a._z._c;
            GL11.glTranslatef(-3.0f, 0.0f, 0.0f);
            int n11 = n8 * n5 + n8;
            n4 = n7 * n5 + n7;
            int n12 = this._e * n4 / n8;
            int n13 = n4 * n4 / n11;
            if (n11 != n4) {
                n3 = n12 > 0 ? 170 : 96;
                n2 = this._f ? 0xCC3333 : 0x3333AA;
                wowp.func_73734_a(0, -n12, 2, -n12 - n13, n2 + (n3 << 24));
                wowp.func_73734_a(2, -n12, 1, -n12 - n13, 0xCCCCCC + (n3 << 24));
            }
        }
        GL11.glPopMatrix();
    }

    public void _a() {
        this._d.clear();
        this._c.clear();
        this._b.clear();
    }

    public void _a(String string) {
        this._a(string, 0);
    }

    public void _a(String string, int n) {
        this._a(string, n, this._a._J.func_73834_c(), false);
        this._a._O()._a("[CHAT] " + ezfc._a(string));
    }

    public void _a(String string, int n, int n2, boolean bl) {
        boolean bl2 = this._e();
        boolean bl3 = true;
        if (n != 0) {
            this._c(n);
        }
        for (String string2 : this._a._z._c(string, sajh._d((float)this._f() / this._h()))) {
            if (bl2 && this._e > 0) {
                this._f = true;
                this._b(1);
            }
            if (!bl3) {
                string2 = " " + string2;
            }
            bl3 = false;
            this._d.add(0, new uzpa(n2, string2, n));
        }
        while (this._d.size() > 100) {
            this._d.remove(this._d.size() - 1);
        }
        if (!bl) {
            this._c.add(0, new uzpa(n2, string.trim(), n));
            while (this._c.size() > 100) {
                this._c.remove(this._c.size() - 1);
            }
        }
    }

    public void _b() {
        this._d.clear();
        this._d();
        for (int i = this._c.size() - 1; i >= 0; --i) {
            uzpa uzpa2 = (uzpa)this._c.get(i);
            this._a(uzpa2._a(), uzpa2._c(), uzpa2._b(), true);
        }
    }

    public List _c() {
        return this._b;
    }

    public void _b(String string) {
        if (this._b.isEmpty() || !((String)this._b.get(this._b.size() - 1)).equals(string)) {
            this._b.add(string);
        }
    }

    public void _d() {
        this._e = 0;
        this._f = false;
    }

    public void _b(int n) {
        this._e += n;
        int n2 = this._d.size();
        if (this._e > n2 - this._i()) {
            this._e = n2 - this._i();
        }
        if (this._e <= 0) {
            this._e = 0;
            this._f = false;
        }
    }

    public wots _a(int n, int n2) {
        if (!this._e()) {
            return null;
        }
        htou htou2 = new htou(this._a._M, this._a._n, this._a._o);
        int n3 = htou2._e();
        float f = this._h();
        int n4 = n / n3 - 3;
        int n5 = n2 / n3 - 25;
        n4 = sajh._d((float)n4 / f);
        n5 = sajh._d((float)n5 / f);
        if (n4 < 0 || n5 < 0) {
            return null;
        }
        int n6 = Math.min(this._i(), this._d.size());
        if (n4 <= sajh._d((float)this._f() / this._h()) && n5 < this._a._z._c * n6 + n6) {
            int n7 = n5 / (this._a._z._c + 1) + this._e;
            return new wots(this._a._z, (uzpa)this._d.get(n7), n4, n5 - (n7 - this._e) * this._a._z._c + n7);
        }
        return null;
    }

    public void _a(String string, Object ... objectArray) {
        this._a(wpcz._a(string, objectArray));
    }

    public boolean _e() {
        return this._a._B instanceof fndz;
    }

    public void _c(int n) {
        uzpa uzpa2;
        Iterator iterator2 = this._d.iterator();
        while (iterator2.hasNext()) {
            uzpa2 = (uzpa)iterator2.next();
            if (uzpa2._c() != n) continue;
            iterator2.remove();
            return;
        }
        iterator2 = this._c.iterator();
        while (iterator2.hasNext()) {
            uzpa2 = (uzpa)iterator2.next();
            if (uzpa2._c() != n) continue;
            iterator2.remove();
            return;
        }
    }

    public int _f() {
        return wowp._a(this._a._M.field_96692_F);
    }

    public int _g() {
        return wowp._b(this._e() ? this._a._M.field_96694_H : this._a._M.field_96693_G);
    }

    public float _h() {
        return this._a._M.field_96691_E;
    }

    public static final int _a(float f) {
        int n = 320;
        int n2 = 40;
        return sajh._d(f * (float)(n - n2) + (float)n2);
    }

    public static final int _b(float f) {
        int n = 180;
        int n2 = 20;
        return sajh._d(f * (float)(n - n2) + (float)n2);
    }

    public int _i() {
        return this._g() / 9;
    }
}

