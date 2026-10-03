/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezey;
import net.minecraft.util.ezfc;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class htmc
extends gqjz {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/book.png");
    public final EntityPlayer _b;
    public final cvzo _c;
    public final boolean _d;
    public boolean _e;
    public boolean _f;
    public int _g;
    public int _h = 192;
    public int _i = 192;
    public int _j = 1;
    public int _k;
    public bsyv _l;
    public String _m = "";
    public rqga _n;
    public rqga _o;
    public jiok _p;
    public jiok _q;
    public jiok _r;
    public jiok _s;

    public htmc(EntityPlayer entityPlayer, cvzo cvzo2, boolean bl) {
        this._b = entityPlayer;
        this._c = cvzo2;
        this._d = bl;
        if (cvzo2._p()) {
            qoac qoac2 = cvzo2._q();
            this._l = qoac2._n("pages");
            if (this._l != null) {
                this._l = (bsyv)this._l._c();
                this._j = this._l._d();
                if (this._j < 1) {
                    this._j = 1;
                }
            }
        }
        if (this._l == null && bl) {
            this._l = new bsyv("pages");
            this._l._a(new xsxy("1", ""));
            this._j = 1;
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._g;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        if (this._d) {
            this._q = new jiok(3, this.field_73880_f / 2 - 100, 4 + this._i, 98, 20, wpcz._a("book.signButton"));
            this.field_73887_h.add(this._q);
            this._p = new jiok(0, this.field_73880_f / 2 + 2, 4 + this._i, 98, 20, wpcz._a("gui.done"));
            this.field_73887_h.add(this._p);
            this._r = new jiok(5, this.field_73880_f / 2 - 100, 4 + this._i, 98, 20, wpcz._a("book.finalizeButton"));
            this.field_73887_h.add(this._r);
            this._s = new jiok(4, this.field_73880_f / 2 + 2, 4 + this._i, 98, 20, wpcz._a("gui.cancel"));
            this.field_73887_h.add(this._s);
        } else {
            this._p = new jiok(0, this.field_73880_f / 2 - 100, 4 + this._i, 200, 20, wpcz._a("gui.done"));
            this.field_73887_h.add(this._p);
        }
        int n = (this.field_73880_f - this._h) / 2;
        int n2 = 2;
        this._n = new rqga(1, n + 120, n2 + 154, true);
        this.field_73887_h.add(this._n);
        this._o = new rqga(2, n + 38, n2 + 154, false);
        this.field_73887_h.add(this._o);
        this._a();
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    public void _a() {
        this._n.field_73748_h = !this._f && (this._k < this._j - 1 || this._d);
        this._o.field_73748_h = !this._f && this._k > 0;
        boolean bl = this._p.field_73748_h = !this._d || !this._f;
        if (this._d) {
            this._q.field_73748_h = !this._f;
            this._s.field_73748_h = this._f;
            this._r.field_73748_h = this._f;
            this._r.field_73742_g = this._m.trim().length() > 0;
        }
    }

    public void _a(boolean bl) {
        if (!this._d || !this._e) {
            return;
        }
        if (this._l != null) {
            Object object;
            while (this._l._d() > 1) {
                object = (xsxy)this._l._b(this._l._d() - 1);
                if (((xsxy)object)._c != null && ((xsxy)object)._c.length() != 0) break;
                this._l._a(this._l._d() - 1);
            }
            if (this._c._p()) {
                object = this._c._q();
                ((qoac)object)._a("pages", this._l);
            } else {
                this._c._a("pages", this._l);
            }
            object = "MC|BEdit";
            if (bl) {
                object = "MC|BSign";
                this._c._a("author", new xsxy("author", this._b.func_70005_c_()));
                this._c._a("title", new xsxy("title", this._m.trim()));
                this._c._d = tgdv.field_77823_bG.field_77779_bT;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                cezg.func_73270_a(this._c, dataOutputStream);
                this.field_73882_e._z()._b(new jjqf((String)object, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a((gqjz)null);
            this._a(false);
        } else if (jiok2.field_73741_f == 3 && this._d) {
            this._f = true;
        } else if (jiok2.field_73741_f == 1) {
            if (this._k < this._j - 1) {
                ++this._k;
            } else if (this._d) {
                this._b();
                if (this._k < this._j - 1) {
                    ++this._k;
                }
            }
        } else if (jiok2.field_73741_f == 2) {
            if (this._k > 0) {
                --this._k;
            }
        } else if (jiok2.field_73741_f == 5 && this._f) {
            this._a(true);
            this.field_73882_e._a((gqjz)null);
        } else if (jiok2.field_73741_f == 4 && this._f) {
            this._f = false;
        }
        this._a();
    }

    public void _b() {
        if (this._l == null || this._l._d() >= 50) {
            return;
        }
        this._l._a(new xsxy("" + (this._j + 1), ""));
        ++this._j;
        this._e = true;
    }

    @Override
    public void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (!this._d) {
            return;
        }
        if (this._f) {
            this._b(c, n);
        } else {
            this._a(c, n);
        }
    }

    public void _a(char c, int n) {
        switch (c) {
            case '\u0016': {
                this._b(gqjz.func_73870_l());
                return;
            }
        }
        switch (n) {
            case 14: {
                String string = this._c();
                if (string.length() > 0) {
                    this._a(string.substring(0, string.length() - 1));
                }
                return;
            }
            case 28: 
            case 156: {
                this._b("\n");
                return;
            }
        }
        if (ezey._a(c)) {
            this._b(Character.toString(c));
            return;
        }
    }

    public void _b(char c, int n) {
        switch (n) {
            case 14: {
                if (!this._m.isEmpty()) {
                    this._m = this._m.substring(0, this._m.length() - 1);
                    this._a();
                }
                return;
            }
            case 28: 
            case 156: {
                if (!this._m.isEmpty()) {
                    this._a(true);
                    this.field_73882_e._a((gqjz)null);
                }
                return;
            }
        }
        if (this._m.length() < 16 && ezey._a(c)) {
            this._m = this._m + Character.toString(c);
            this._a();
            this._e = true;
        }
    }

    public String _c() {
        if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
            xsxy xsxy2 = (xsxy)this._l._b(this._k);
            return xsxy2.toString();
        }
        return "";
    }

    public void _a(String string) {
        if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
            xsxy xsxy2 = (xsxy)this._l._b(this._k);
            xsxy2._c = string;
            this._e = true;
        }
    }

    public void _b(String string) {
        String string2 = this._c();
        String string3 = string2 + string;
        int n = this.field_73886_k._b(string3 + "" + (Object)((Object)ezfc._a) + "_", 118);
        if (n <= 118 && string3.length() < 256) {
            this._a(string3);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this._h) / 2;
        int n4 = 2;
        this.func_73729_b(n3, n4, 0, 0, this._h, this._i);
        if (this._f) {
            String string = this._m;
            if (this._d) {
                string = this._g / 6 % 2 == 0 ? string + "" + (Object)((Object)ezfc._a) + "_" : string + "" + (Object)((Object)ezfc._h) + "_";
            }
            String string2 = wpcz._a("book.editTitle");
            int n5 = this.field_73886_k._b(string2);
            this.field_73886_k._b(string2, n3 + 36 + (116 - n5) / 2, n4 + 16 + 16, 0);
            int n6 = this.field_73886_k._b(string);
            this.field_73886_k._b(string, n3 + 36 + (116 - n6) / 2, n4 + 48, 0);
            String string3 = String.format(wpcz._a("book.byAuthor"), this._b.func_70005_c_());
            int n7 = this.field_73886_k._b(string3);
            this.field_73886_k._b((Object)((Object)ezfc._i) + string3, n3 + 36 + (116 - n7) / 2, n4 + 48 + 10, 0);
            String string4 = wpcz._a("book.finalizeWarning");
            this.field_73886_k._a(string4, n3 + 36, n4 + 80, 116, 0);
        } else {
            String string = String.format(wpcz._a("book.pageIndicator"), this._k + 1, this._j);
            String string5 = "";
            if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
                xsxy xsxy2 = (xsxy)this._l._b(this._k);
                string5 = xsxy2.toString();
            }
            if (this._d) {
                string5 = this.field_73886_k._e() ? string5 + "_" : (this._g / 6 % 2 == 0 ? string5 + "" + (Object)((Object)ezfc._a) + "_" : string5 + "" + (Object)((Object)ezfc._h) + "_");
            }
            int n8 = this.field_73886_k._b(string);
            this.field_73886_k._b(string, n3 - n8 + this._h - 44, n4 + 16, 0);
            this.field_73886_k._a(string5, n3 + 36, n4 + 16 + 16, 116, 0);
        }
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ ResourceLocation _d() {
        return _a;
    }
}

