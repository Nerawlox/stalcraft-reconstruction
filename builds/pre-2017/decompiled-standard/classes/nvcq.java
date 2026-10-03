/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ezey;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class nvcq
extends gqjz {
    public static final String _a = ezey._a;
    public String _b = "Edit sign message:";
    public jjza _c;
    public int _d;
    public int _e;
    public jiok _f;

    public nvcq(jjza jjza2) {
        this._c = jjza2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        this._f = new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120, "Done");
        this.field_73887_h.add(this._f);
        this._c._a(false);
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
        bscn bscn2 = this.field_73882_e._z();
        if (bscn2 != null) {
            bscn2._b(new gaet(this._c.field_70329_l, this._c.field_70330_m, this._c.field_70327_n, this._c._a));
        }
        this._c._a(true);
    }

    @Override
    public void func_73876_c() {
        ++this._d;
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 0) {
            this._c.func_70296_d();
            this.field_73882_e._a((gqjz)null);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 200) {
            this._e = this._e - 1 & 3;
        }
        if (n == 208 || n == 28 || n == 156) {
            this._e = this._e + 1 & 3;
        }
        if (n == 14 && this._c._a[this._e].length() > 0) {
            this._c._a[this._e] = this._c._a[this._e].substring(0, this._c._a[this._e].length() - 1);
        }
        if (_a.indexOf(c) >= 0 && this._c._a[this._e].length() < 15) {
            int n2 = this._e;
            this._c._a[n2] = this._c._a[n2] + c;
        }
        if (n == 1) {
            this.func_73875_a(this._f);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._b, this.field_73880_f / 2, 40, 0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.field_73880_f / 2, 0.0f, 50.0f);
        float f2 = 93.75f;
        GL11.glScalef(-f2, -f2, -f2);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        twgu twgu2 = this._c.func_70311_o();
        if (twgu2 == twgu.field_72053_aD) {
            float f3 = (float)(this._c.func_70322_n() * 360) / 16.0f;
            GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -1.0625f, 0.0f);
        } else {
            int n3 = this._c.func_70322_n();
            float f4 = 0.0f;
            if (n3 == 2) {
                f4 = 180.0f;
            }
            if (n3 == 4) {
                f4 = 90.0f;
            }
            if (n3 == 5) {
                f4 = -90.0f;
            }
            GL11.glRotatef(f4, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -1.0625f, 0.0f);
        }
        if (this._d / 6 % 2 == 0) {
            this._c._b = this._e;
        }
        cekh._b._a(this._c, -0.5, -0.75, -0.5, 0.0f);
        this._c._b = -1;
        GL11.glPopMatrix();
        super.func_73863_a(n, n2, f);
    }
}

