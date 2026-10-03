/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.amww;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xayk
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/villager.png");
    public amww _b;
    public pkae _c;
    public pkae _d;
    public int _e;
    public String _f;

    public xayk(eidj eidj2, amww amww2, ozlu ozlu2, String string) {
        super(new igct(eidj2, amww2, ozlu2));
        this._b = amww2;
        this._f = string == null || string.length() < 1 ? wpcz._a("entity.Villager.name") : string;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        int n = (this.field_73880_f - this.field_74194_b) / 2;
        int n2 = (this.field_73881_g - this.field_74195_c) / 2;
        this._c = new pkae(1, n + 120 + 27, n2 + 24 - 1, true);
        this.field_73887_h.add(this._c);
        this._d = new pkae(2, n + 36 - 19, n2 + 24 - 1, false);
        this.field_73887_h.add(this._d);
        this._c.field_73742_g = false;
        this._d.field_73742_g = false;
    }

    @Override
    public void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this._f, this.field_74194_b / 2 - this.field_73886_k._b(this._f) / 2, 6, 0x404040);
        this.field_73886_k._b(wpcz._a("container.inventory"), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ywfi ywfi2 = this._b.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null) {
            this._c.field_73742_g = this._e < ywfi2.size() - 1;
            this._d.field_73742_g = this._e > 0;
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        boolean bl = false;
        if (jiok2 == this._c) {
            ++this._e;
            bl = true;
        } else if (jiok2 == this._d) {
            --this._e;
            bl = true;
        }
        if (bl) {
            ((igct)this.field_74193_d)._a(this._e);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._e);
                this.field_73882_e._z()._b(new jjqf("MC|TrSel", byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        int n3;
        ozjk ozjk2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n4 = (this.field_73880_f - this.field_74194_b) / 2;
        int n5 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n4, n5, 0, 0, this.field_74194_b, this.field_74195_c);
        ywfi ywfi2 = this._b.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null && !ywfi2.isEmpty() && (ozjk2 = (ozjk)ywfi2.get(n3 = this._e))._f()) {
            this.field_73882_e._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(2896);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 21, 212, 0, 28, 21);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 51, 212, 0, 28, 21);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        ywfi ywfi2 = this._b.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null && !ywfi2.isEmpty()) {
            int n3 = (this.field_73880_f - this.field_74194_b) / 2;
            int n4 = (this.field_73881_g - this.field_74195_c) / 2;
            int n5 = this._e;
            ozjk ozjk2 = (ozjk)ywfi2.get(n5);
            GL11.glPushMatrix();
            cvzo cvzo2 = ozjk2._a();
            cvzo cvzo3 = ozjk2._b();
            cvzo cvzo4 = ozjk2._d();
            qnon._c();
            GL11.glDisable(2896);
            GL11.glEnable(32826);
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            xayk.field_74196_a.field_77023_b = 100.0f;
            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n3 + 36, n4 + 24);
            field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n3 + 36, n4 + 24);
            if (cvzo3 != null) {
                field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo3, n3 + 62, n4 + 24);
                field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo3, n3 + 62, n4 + 24);
            }
            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo4, n3 + 120, n4 + 24);
            field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo4, n3 + 120, n4 + 24);
            xayk.field_74196_a.field_77023_b = 0.0f;
            GL11.glDisable(2896);
            if (this.func_74188_c(36, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo2, n, n2);
            } else if (cvzo3 != null && this.func_74188_c(62, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo3, n, n2);
            } else if (this.func_74188_c(120, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo4, n, n2);
            }
            GL11.glPopMatrix();
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
        }
    }

    public amww _a() {
        return this._b;
    }

    public static /* synthetic */ ResourceLocation _b() {
        return _a;
    }
}

