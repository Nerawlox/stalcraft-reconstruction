/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class tfow
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/beacon.png");
    public vmyb _b;
    public tfod _c;
    public boolean _d;

    public tfow(eidj eidj2, vmyb vmyb2) {
        super(new ixdv(eidj2, vmyb2));
        this._b = vmyb2;
        this.field_74194_b = 230;
        this.field_74195_c = 219;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._c = new tfod(this, -1, this.field_74198_m + 164, this.field_74197_n + 107);
        this.field_73887_h.add(this._c);
        this.field_73887_h.add(new htob(this, -2, this.field_74198_m + 190, this.field_74197_n + 107));
        this._d = true;
        this._c.field_73742_g = false;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this._d && this._b._f() >= 0) {
            hclx hclx2;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            this._d = false;
            for (n5 = 0; n5 <= 2; ++n5) {
                n4 = vmyb._a[n5].length;
                n3 = n4 * 22 + (n4 - 1) * 2;
                for (n2 = 0; n2 < n4; ++n2) {
                    n = vmyb._a[n5][n2]._H;
                    hclx2 = new hclx(this, n5 << 8 | n, this.field_74198_m + 76 + n2 * 24 - n3 / 2, this.field_74197_n + 22 + n5 * 25, n, n5);
                    this.field_73887_h.add(hclx2);
                    if (n5 >= this._b._f()) {
                        hclx2.field_73742_g = false;
                        continue;
                    }
                    if (n != this._b._d()) continue;
                    hclx2._a(true);
                }
            }
            n5 = 3;
            n4 = vmyb._a[n5].length + 1;
            n3 = n4 * 22 + (n4 - 1) * 2;
            for (n2 = 0; n2 < n4 - 1; ++n2) {
                n = vmyb._a[n5][n2]._H;
                hclx2 = new hclx(this, n5 << 8 | n, this.field_74198_m + 167 + n2 * 24 - n3 / 2, this.field_74197_n + 47, n, n5);
                this.field_73887_h.add(hclx2);
                if (n5 >= this._b._f()) {
                    hclx2.field_73742_g = false;
                    continue;
                }
                if (n != this._b._e()) continue;
                hclx2._a(true);
            }
            if (this._b._d() > 0) {
                hclx hclx3 = new hclx(this, n5 << 8 | this._b._d(), this.field_74198_m + 167 + (n4 - 1) * 24 - n3 / 2, this.field_74197_n + 47, this._b._d(), n5);
                this.field_73887_h.add(hclx3);
                if (n5 >= this._b._f()) {
                    hclx3.field_73742_g = false;
                } else if (this._b._d() == this._b._e()) {
                    hclx3._a(true);
                }
            }
        }
        this._c.field_73742_g = this._b.func_70301_a(0) != null && this._b._d() > 0;
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == -2) {
            this.field_73882_e._a((gqjz)null);
        } else if (jiok2.field_73741_f == -1) {
            String string = "MC|Beacon";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._b._d());
                dataOutputStream.writeInt(this._b._e());
                this.field_73882_e._z()._b(new jjqf(string, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.field_73882_e._a((gqjz)null);
        } else if (jiok2 instanceof hclx) {
            if (((hclx)jiok2)._a()) {
                return;
            }
            int n = jiok2.field_73741_f;
            int n2 = n & 0xFF;
            int n3 = n >> 8;
            if (n3 < 3) {
                this._b._b(n2);
            } else {
                this._b._c(n2);
            }
            this.field_73887_h.clear();
            this.func_73866_w_();
            this.func_73876_c();
        }
    }

    @Override
    public void func_74189_g(int n, int n2) {
        qnon._a();
        this.func_73732_a(this.field_73886_k, wpcz._a("tile.beacon.primary"), 62, 10, 0xE0E0E0);
        this.func_73732_a(this.field_73886_k, wpcz._a("tile.beacon.secondary"), 169, 10, 0xE0E0E0);
        for (jiok jiok2 : this.field_73887_h) {
            if (!jiok2.func_82252_a()) continue;
            jiok2.func_82251_b(n - this.field_74198_m, n2 - this.field_74197_n);
            break;
        }
        qnon._c();
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        tfow.field_74196_a.field_77023_b = 100.0f;
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), new cvzo(tgdv.field_77817_bH), n3 + 42, n4 + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), new cvzo(tgdv.field_77702_n), n3 + 42 + 22, n4 + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), new cvzo(tgdv.field_77717_p), n3 + 42 + 44, n4 + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), new cvzo(tgdv.field_77703_o), n3 + 42 + 66, n4 + 109);
        tfow.field_74196_a.field_77023_b = 0.0f;
    }

    public static /* synthetic */ ResourceLocation _a() {
        return _a;
    }
}

