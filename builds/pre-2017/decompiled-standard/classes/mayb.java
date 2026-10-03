/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;

public class mayb
extends wovy {
    public final /* synthetic */ gqju _a;

    public mayb(gqju gqju2) {
        this._a = gqju2;
        super(gqju2.field_73882_e, gqju2.field_73880_f, gqju2.field_73881_g, 32, gqju2.field_73881_g - 64, 36);
    }

    @Override
    public int func_77217_a() {
        return gqju._a(this._a)._c() + gqju._b(this._a).size() + 1;
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        if (n >= gqju._a(this._a)._c() + gqju._b(this._a).size()) {
            return;
        }
        int n2 = gqju._c(this._a);
        gqju._a(this._a, n);
        htsm htsm2 = gqju._a(this._a)._c() > n ? gqju._a(this._a)._a(n) : null;
        boolean bl2 = gqju._c(this._a) >= 0 && gqju._c(this._a) < this.func_77217_a() && (htsm2 == null || htsm2._f == 78);
        boolean bl3 = gqju._c(this._a) < gqju._a(this._a)._c();
        gqju._d((gqju)this._a).field_73742_g = bl2;
        gqju._e((gqju)this._a).field_73742_g = bl3;
        gqju._f((gqju)this._a).field_73742_g = bl3;
        if (bl && bl2) {
            gqju._b(this._a, n);
        } else if (bl3 && gqjz.func_73877_p() && n2 >= 0 && n2 < gqju._a(this._a)._c()) {
            gqju._a(this._a)._a(n2, gqju._c(this._a));
        }
    }

    @Override
    public boolean func_77218_a(int n) {
        return n == gqju._c(this._a);
    }

    @Override
    public int func_77212_b() {
        return this.func_77217_a() * 36;
    }

    @Override
    public void func_77221_c() {
        this._a.func_73873_v_();
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        if (n < gqju._a(this._a)._c()) {
            this._c(n, n2, n3, n4, htvf2);
        } else if (n < gqju._a(this._a)._c() + gqju._b(this._a).size()) {
            this._a(n, n2, n3, n4, htvf2);
        } else {
            this._b(n, n2, n3, n4, htvf2);
        }
    }

    public void _a(int n, int n2, int n3, int n4, htvf htvf2) {
        ohgi ohgi2 = (ohgi)gqju._b(this._a).get(n - gqju._a(this._a)._c());
        this._a.func_73731_b(this._a.field_73886_k, wpcz._a("lanServer.title"), n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.func_73731_b(this._a.field_73886_k, ohgi2._a(), n2 + 2, n3 + 12, 0x808080);
        if (this._a.field_73882_e._M.field_80005_w) {
            this._a.func_73731_b(this._a.field_73886_k, wpcz._a("selectServer.hiddenAddress"), n2 + 2, n3 + 12 + 11, 0x303030);
        } else {
            this._a.func_73731_b(this._a.field_73886_k, ohgi2._b(), n2 + 2, n3 + 12 + 11, 0x303030);
        }
    }

    public void _b(int n, int n2, int n3, int n4, htvf htvf2) {
        String string;
        this._a.func_73732_a(this._a.field_73886_k, wpcz._a("lanServer.scanning"), this._a.field_73880_f / 2, n3 + 1, 0xFFFFFF);
        switch (gqju._g(this._a) / 3 % 4) {
            default: {
                string = "O o o";
                break;
            }
            case 1: 
            case 3: {
                string = "o O o";
                break;
            }
            case 2: {
                string = "o o O";
            }
        }
        this._a.func_73732_a(this._a.field_73886_k, string, this._a.field_73880_f / 2, n3 + 12, 0x808080);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _c(int n, int n2, int n3, int n4, htvf htvf2) {
        htsm htsm2 = gqju._a(this._a)._a(n);
        Object object = gqju._b();
        synchronized (object) {
            if (gqju._c() < 5 && !htsm2._h) {
                htsm2._h = true;
                htsm2._e = -2L;
                htsm2._d = "";
                htsm2._c = "";
                gqju._d();
                new woyo(this, htsm2).start();
            }
        }
        boolean bl = htsm2._f > 78;
        boolean bl2 = htsm2._f < 78;
        boolean bl3 = bl || bl2;
        this._a.func_73731_b(this._a.field_73886_k, htsm2._a, n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.func_73731_b(this._a.field_73886_k, htsm2._d, n2 + 2, n3 + 12, 0x808080);
        this._a.func_73731_b(this._a.field_73886_k, htsm2._c, n2 + 215 - this._a.field_73886_k._b(htsm2._c), n3 + 12, 0x808080);
        if (bl3) {
            String string = (Object)((Object)ezfc._e) + htsm2._g;
            this._a.func_73731_b(this._a.field_73886_k, string, n2 + 200 - this._a.field_73886_k._b(string), n3 + 1, 0x808080);
        }
        if (this._a.field_73882_e._M.field_80005_w || htsm2._b()) {
            this._a.func_73731_b(this._a.field_73886_k, wpcz._a("selectServer.hiddenAddress"), n2 + 2, n3 + 12 + 11, 0x303030);
        } else {
            this._a.func_73731_b(this._a.field_73886_k, htsm2._b, n2 + 2, n3 + 12 + 11, 0x303030);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._a.field_73882_e._R()._a(bawa.field_110324_m);
        int n5 = 0;
        int n6 = 0;
        String string = "";
        if (bl3) {
            string = bl ? "Client out of date!" : "Server out of date!";
            n6 = 5;
        } else if (htsm2._h && htsm2._e != -2L) {
            n6 = htsm2._e < 0L ? 5 : (htsm2._e < 150L ? 0 : (htsm2._e < 300L ? 1 : (htsm2._e < 600L ? 2 : (htsm2._e < 1000L ? 3 : 4))));
            string = htsm2._e < 0L ? "(no connection)" : htsm2._e + "ms";
        } else {
            n5 = 1;
            n6 = (int)(xpzm._M() / 100L + (long)(n * 2) & 7L);
            if (n6 > 4) {
                n6 = 8 - n6;
            }
            string = "Polling..";
        }
        this._a.func_73729_b(n2 + 205, n3, 0 + n5 * 10, 176 + n6 * 8, 10, 8);
        int n7 = 4;
        if (this.field_77230_e >= n2 + 205 - n7 && this.field_77227_f >= n3 - n7 && this.field_77230_e <= n2 + 205 + 10 + n7 && this.field_77227_f <= n3 + 8 + n7) {
            gqju._a(this._a, string);
        }
    }
}

