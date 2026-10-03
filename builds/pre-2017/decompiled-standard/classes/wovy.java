/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class wovy {
    public final xpzm field_77233_a;
    public int field_77228_g;
    public int field_77240_h;
    public int field_77231_b;
    public int field_77232_c;
    public int field_77241_i;
    public int field_77238_j;
    public final int field_77229_d;
    public int field_77239_k;
    public int field_77236_l;
    public int field_77230_e;
    public int field_77227_f;
    public float field_77237_m = -2.0f;
    public float field_77234_n;
    public float field_77235_o;
    public int field_77246_p = -1;
    public long field_77245_q;
    public boolean field_77244_r = true;
    public boolean field_77243_s;
    public int field_77242_t;

    public wovy(xpzm xpzm2, int n, int n2, int n3, int n4, int n5) {
        this.field_77233_a = xpzm2;
        this.field_77228_g = n;
        this.field_77240_h = n2;
        this.field_77231_b = n3;
        this.field_77232_c = n4;
        this.field_77229_d = n5;
        this.field_77238_j = 0;
        this.field_77241_i = n;
    }

    public void func_77207_a(int n, int n2, int n3, int n4) {
        this.field_77228_g = n;
        this.field_77240_h = n2;
        this.field_77231_b = n3;
        this.field_77232_c = n4;
        this.field_77238_j = 0;
        this.field_77241_i = n;
    }

    public void func_77216_a(boolean bl) {
        this.field_77244_r = bl;
    }

    public void func_77223_a(boolean bl, int n) {
        this.field_77243_s = bl;
        this.field_77242_t = n;
        if (!bl) {
            this.field_77242_t = 0;
        }
    }

    public abstract int func_77217_a();

    public abstract void func_77213_a(int var1, boolean var2);

    public abstract boolean func_77218_a(int var1);

    public int func_77212_b() {
        return this.func_77217_a() * this.field_77229_d + this.field_77242_t;
    }

    public abstract void func_77221_c();

    public abstract void func_77214_a(int var1, int var2, int var3, int var4, htvf var5);

    public void func_77222_a(int n, int n2, htvf htvf2) {
    }

    public void func_77224_a(int n, int n2) {
    }

    public void func_77215_b(int n, int n2) {
    }

    public int func_77210_c(int n, int n2) {
        int n3 = this.field_77228_g / 2 - 110;
        int n4 = this.field_77228_g / 2 + 110;
        int n5 = n2 - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
        int n6 = n5 / this.field_77229_d;
        return n >= n3 && n <= n4 && n6 >= 0 && n5 >= 0 && n6 < this.func_77217_a() ? n6 : -1;
    }

    public void func_77220_a(int n, int n2) {
        this.field_77239_k = n;
        this.field_77236_l = n2;
    }

    public void func_77226_h() {
        int n = this.func_77209_d();
        if (n < 0) {
            n /= 2;
        }
        if (this.field_77235_o < 0.0f) {
            this.field_77235_o = 0.0f;
        }
        if (this.field_77235_o > (float)n) {
            this.field_77235_o = n;
        }
    }

    public int func_77209_d() {
        return this.func_77212_b() - (this.field_77232_c - this.field_77231_b - 4);
    }

    public void func_77208_b(int n) {
        this.field_77235_o += (float)n;
        this.func_77226_h();
        this.field_77237_m = -2.0f;
    }

    public void func_77219_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f == this.field_77239_k) {
                this.field_77235_o -= (float)(this.field_77229_d * 2 / 3);
                this.field_77237_m = -2.0f;
                this.func_77226_h();
            } else if (jiok2.field_73741_f == this.field_77236_l) {
                this.field_77235_o += (float)(this.field_77229_d * 2 / 3);
                this.field_77237_m = -2.0f;
                this.func_77226_h();
            }
        }
    }

    public void func_77211_a(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        this.field_77230_e = n;
        this.field_77227_f = n2;
        this.func_77221_c();
        int n11 = this.func_77217_a();
        int n12 = this.func_77225_g();
        int n13 = n12 + 6;
        if (Mouse.isButtonDown(0)) {
            if (this.field_77237_m == -1.0f) {
                n10 = 1;
                if (n2 >= this.field_77231_b && n2 <= this.field_77232_c) {
                    n9 = this.field_77228_g / 2 - 110;
                    n8 = this.field_77228_g / 2 + 110;
                    n7 = n2 - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
                    n6 = n7 / this.field_77229_d;
                    if (n >= n9 && n <= n8 && n6 >= 0 && n7 >= 0 && n6 < n11) {
                        n5 = n6 == this.field_77246_p && xpzm._M() - this.field_77245_q < 250L ? 1 : 0;
                        this.func_77213_a(n6, n5 != 0);
                        this.field_77246_p = n6;
                        this.field_77245_q = xpzm._M();
                    } else if (n >= n9 && n <= n8 && n7 < 0) {
                        this.func_77224_a(n - n9, n2 - this.field_77231_b + (int)this.field_77235_o - 4);
                        n10 = 0;
                    }
                    if (n >= n12 && n <= n13) {
                        this.field_77234_n = -1.0f;
                        n4 = this.func_77209_d();
                        if (n4 < 1) {
                            n4 = 1;
                        }
                        if ((n3 = (int)((float)((this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b)) / (float)this.func_77212_b())) < 32) {
                            n3 = 32;
                        }
                        if (n3 > this.field_77232_c - this.field_77231_b - 8) {
                            n3 = this.field_77232_c - this.field_77231_b - 8;
                        }
                        this.field_77234_n /= (float)(this.field_77232_c - this.field_77231_b - n3) / (float)n4;
                    } else {
                        this.field_77234_n = 1.0f;
                    }
                    this.field_77237_m = n10 != 0 ? (float)n2 : -2.0f;
                } else {
                    this.field_77237_m = -2.0f;
                }
            } else if (this.field_77237_m >= 0.0f) {
                this.field_77235_o -= ((float)n2 - this.field_77237_m) * this.field_77234_n;
                this.field_77237_m = n2;
            }
        } else {
            while (!this.field_77233_a._M.field_85185_A && Mouse.next()) {
                n10 = Mouse.getEventDWheel();
                if (n10 == 0) continue;
                if (n10 > 0) {
                    n10 = -1;
                } else if (n10 < 0) {
                    n10 = 1;
                }
                this.field_77235_o += (float)(n10 * this.field_77229_d / 2);
            }
            this.field_77237_m = -1.0f;
        }
        this.func_77226_h();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        htvf htvf2 = htvf.field_78398_a;
        this.drawContainerBackground(htvf2);
        n8 = this.field_77228_g / 2 - 92 - 16;
        n7 = this.field_77231_b + 4 - (int)this.field_77235_o;
        if (this.field_77243_s) {
            this.func_77222_a(n8, n7, htvf2);
        }
        for (n6 = 0; n6 < n11; ++n6) {
            n4 = n7 + n6 * this.field_77229_d + this.field_77242_t;
            n3 = this.field_77229_d - 4;
            if (n4 > this.field_77232_c || n4 + n3 < this.field_77231_b) continue;
            if (this.field_77244_r && this.func_77218_a(n6)) {
                n9 = this.field_77228_g / 2 - 110;
                n5 = this.field_77228_g / 2 + 110;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                htvf2.func_78382_b();
                htvf2.func_78378_d(0x808080);
                htvf2.func_78374_a(n9, n4 + n3 + 2, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(n5, n4 + n3 + 2, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(n5, n4 - 2, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(n9, n4 - 2, 0.0, 0.0, 0.0);
                htvf2.func_78378_d(0);
                htvf2.func_78374_a(n9 + 1, n4 + n3 + 1, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(n5 - 1, n4 + n3 + 1, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(n5 - 1, n4 - 1, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(n9 + 1, n4 - 1, 0.0, 0.0, 0.0);
                htvf2.func_78381_a();
                GL11.glEnable(3553);
            }
            this.func_77214_a(n6, n8, n4, n3, htvf2);
        }
        GL11.glDisable(2929);
        n5 = 4;
        this.func_77206_b(0, this.field_77231_b, 255, 255);
        this.func_77206_b(this.field_77232_c, this.field_77240_h, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        htvf2.func_78382_b();
        htvf2.func_78384_a(0, 0);
        htvf2.func_78374_a(this.field_77238_j, this.field_77231_b + n5, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(this.field_77241_i, this.field_77231_b + n5, 0.0, 1.0, 1.0);
        htvf2.func_78384_a(0, 255);
        htvf2.func_78374_a(this.field_77241_i, this.field_77231_b, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(this.field_77238_j, this.field_77231_b, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78384_a(0, 255);
        htvf2.func_78374_a(this.field_77238_j, this.field_77232_c, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(this.field_77241_i, this.field_77232_c, 0.0, 1.0, 1.0);
        htvf2.func_78384_a(0, 0);
        htvf2.func_78374_a(this.field_77241_i, this.field_77232_c - n5, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(this.field_77238_j, this.field_77232_c - n5, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        n4 = this.func_77209_d();
        if (n4 > 0) {
            n3 = (this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b) / this.func_77212_b();
            if (n3 < 32) {
                n3 = 32;
            }
            if (n3 > this.field_77232_c - this.field_77231_b - 8) {
                n3 = this.field_77232_c - this.field_77231_b - 8;
            }
            if ((n9 = (int)this.field_77235_o * (this.field_77232_c - this.field_77231_b - n3) / n4 + this.field_77231_b) < this.field_77231_b) {
                n9 = this.field_77231_b;
            }
            htvf2.func_78382_b();
            htvf2.func_78384_a(0, 255);
            htvf2.func_78374_a(n12, this.field_77232_c, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n13, this.field_77232_c, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n13, this.field_77231_b, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n12, this.field_77231_b, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78384_a(0x808080, 255);
            htvf2.func_78374_a(n12, n9 + n3, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n13, n9 + n3, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n13, n9, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n12, n9, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78384_a(0xC0C0C0, 255);
            htvf2.func_78374_a(n12, n9 + n3 - 1, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n13 - 1, n9 + n3 - 1, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n13 - 1, n9, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n12, n9, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
        }
        this.func_77215_b(n, n2);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    public int func_77225_g() {
        return this.field_77228_g / 2 + 124;
    }

    public void func_77206_b(int n, int n2, int n3, int n4) {
        htvf htvf2 = htvf.field_78398_a;
        this.field_77233_a._R()._a(bawa.field_110325_k);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78384_a(0x404040, n4);
        htvf2.func_78374_a(0.0, n2, 0.0, 0.0, (float)n2 / f);
        htvf2.func_78374_a(this.field_77228_g, n2, 0.0, (float)this.field_77228_g / f, (float)n2 / f);
        htvf2.func_78384_a(0x404040, n3);
        htvf2.func_78374_a(this.field_77228_g, n, 0.0, (float)this.field_77228_g / f, (float)n / f);
        htvf2.func_78374_a(0.0, n, 0.0, 0.0, (float)n / f);
        htvf2.func_78381_a();
    }

    public void drawContainerBackground(htvf htvf2) {
        this.field_77233_a._R()._a(bawa.field_110325_k);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78378_d(0x202020);
        htvf2.func_78374_a(this.field_77238_j, this.field_77232_c, 0.0, (float)this.field_77238_j / f, (float)(this.field_77232_c + (int)this.field_77235_o) / f);
        htvf2.func_78374_a(this.field_77241_i, this.field_77232_c, 0.0, (float)this.field_77241_i / f, (float)(this.field_77232_c + (int)this.field_77235_o) / f);
        htvf2.func_78374_a(this.field_77241_i, this.field_77231_b, 0.0, (float)this.field_77241_i / f, (float)(this.field_77231_b + (int)this.field_77235_o) / f);
        htvf2.func_78374_a(this.field_77238_j, this.field_77231_b, 0.0, (float)this.field_77238_j / f, (float)(this.field_77231_b + (int)this.field_77235_o) / f);
        htvf2.func_78381_a();
    }
}

