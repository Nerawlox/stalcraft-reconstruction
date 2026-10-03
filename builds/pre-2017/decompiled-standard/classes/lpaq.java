/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Collection;
import org.lwjgl.opengl.GL11;

public abstract class lpaq
extends zybc {
    public boolean field_74222_o;

    public lpaq(jjgc jjgc2) {
        super(jjgc2);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (!this.field_73882_e._t.func_70651_bq().isEmpty()) {
            this.field_74198_m = 160 + (this.field_73880_f - this.field_74194_b - 200) / 2;
            this.field_74222_o = true;
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this.field_74222_o) {
            this.func_74221_h();
        }
    }

    public void func_74221_h() {
        if (GloomyHooks.getTrue()) {
            return;
        }
        int n = this.field_74198_m - 124;
        int n2 = this.field_74197_n;
        int n3 = 166;
        Collection collection = this.field_73882_e._t.func_70651_bq();
        if (collection.isEmpty()) {
            return;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        int n4 = 33;
        if (collection.size() > 5) {
            n4 = 132 / (collection.size() - 1);
        }
        for (supr supr2 : this.field_73882_e._t.func_70651_bq()) {
            hdpq hdpq2 = hdpq._a[supr2._a()];
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73882_e._R()._a(field_110408_a);
            this.func_73729_b(n, n2, 0, 166, 140, 32);
            if (hdpq2._d()) {
                int n5 = hdpq2._e();
                this.func_73729_b(n + 6, n2 + 7, 0 + n5 % 8 * 18, 198 + n5 / 8 * 18, 18, 18);
            }
            String string = wpcz._a(hdpq2._c());
            if (supr2._c() == 1) {
                string = string + " II";
            } else if (supr2._c() == 2) {
                string = string + " III";
            } else if (supr2._c() == 3) {
                string = string + " IV";
            }
            this.field_73886_k._a(string, n + 10 + 18, n2 + 6, 0xFFFFFF);
            String string2 = hdpq._a(supr2);
            this.field_73886_k._a(string2, n + 10 + 18, n2 + 6 + 10, 0x7F7F7F);
            n2 += n4;
        }
    }
}

