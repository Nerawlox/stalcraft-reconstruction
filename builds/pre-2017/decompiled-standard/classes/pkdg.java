/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class pkdg
extends zybc
implements sdcd {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/anvil.png");
    public sdci _b;
    public ifms _c;
    public eidj _d;

    public pkdg(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        super(new sdci(eidj2, ozlu2, n, n2, n3, xpzm._E()._t));
        this._d = eidj2;
        this._b = (sdci)this.field_74193_d;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Keyboard.enableRepeatEvents(true);
        int n = (this.field_73880_f - this.field_74194_b) / 2;
        int n2 = (this.field_73881_g - this.field_74195_c) / 2;
        this._c = new ifms(this.field_73886_k, n + 62, n2 + 24, 103, 12);
        this._c.func_73794_g(-1);
        this._c.func_82266_h(-1);
        this._c.func_73786_a(false);
        this._c.func_73804_f(40);
        this.field_74193_d.func_82847_b(this);
        this.field_74193_d.func_75132_a(this);
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        Keyboard.enableRepeatEvents(false);
        this.field_74193_d.func_82847_b(this);
    }

    @Override
    public void func_74189_g(int n, int n2) {
        GL11.glDisable(2896);
        this.field_73886_k._b(wpcz._a("container.repair"), 60, 6, 0x404040);
        if (this._b._g > 0) {
            int n3 = 8453920;
            boolean bl = true;
            String string = wpcz._a("container.repair.cost", this._b._g);
            if (this._b._g >= 40 && !this.field_73882_e._t.field_71075_bZ._d) {
                string = wpcz._a("container.repair.expensive");
                n3 = 0xFF6060;
            } else if (!this._b.func_75139_a(2).func_75216_d()) {
                bl = false;
            } else if (!this._b.func_75139_a(2).func_82869_a(this._d._e)) {
                n3 = 0xFF6060;
            }
            if (bl) {
                int n4 = 0xFF000000 | (n3 & 0xFCFCFC) >> 2 | n3 & 0xFF000000;
                int n5 = this.field_74194_b - 8 - this.field_73886_k._b(string);
                int n6 = 67;
                if (this.field_73886_k._d()) {
                    pkdg.func_73734_a(n5 - 3, n6 - 2, this.field_74194_b - 7, n6 + 10, -16777216);
                    pkdg.func_73734_a(n5 - 2, n6 - 1, this.field_74194_b - 8, n6 + 9, -12895429);
                } else {
                    this.field_73886_k._b(string, n5, n6 + 1, n4);
                    this.field_73886_k._b(string, n5 + 1, n6, n4);
                    this.field_73886_k._b(string, n5 + 1, n6 + 1, n4);
                }
                this.field_73886_k._b(string, n5, n6, n3);
            }
        }
        GL11.glEnable(2896);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (this._c.func_73802_a(c, n)) {
            this._a();
        } else {
            super.func_73869_a(c, n);
        }
    }

    public void _a() {
        String string = this._c.func_73781_b();
        yeso yeso2 = this._b.func_75139_a(0);
        if (yeso2 != null && yeso2.func_75216_d() && !yeso2.func_75211_c()._u() && string.equals(yeso2.func_75211_c()._s())) {
            string = "";
        }
        this._b._a(string);
        this.field_73882_e._t.field_71174_a._b(new jjqf("MC|ItemName", string.getBytes()));
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._c.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        GL11.glDisable(2896);
        this._c.func_73795_f();
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        this.func_73729_b(n3 + 59, n4 + 20, 0, this.field_74195_c + (this._b.func_75139_a(0).func_75216_d() ? 0 : 16), 110, 16);
        if ((this._b.func_75139_a(0).func_75216_d() || this._b.func_75139_a(1).func_75216_d()) && !this._b.func_75139_a(2).func_75216_d()) {
            this.func_73729_b(n3 + 99, n4 + 45, this.field_74194_b, 0, 28, 21);
        }
    }

    @Override
    public void func_71110_a(jjgc jjgc2, List list) {
        this.func_71111_a(jjgc2, 0, jjgc2.func_75139_a(0).func_75211_c());
    }

    @Override
    public void func_71111_a(jjgc jjgc2, int n, cvzo cvzo2) {
        if (n == 0) {
            this._c.func_73782_a(cvzo2 == null ? "" : cvzo2._s());
            this._c.func_82265_c(cvzo2 != null);
            if (cvzo2 != null) {
                this._a();
            }
        }
    }

    @Override
    public void func_71112_a(jjgc jjgc2, int n, int n2) {
    }
}

