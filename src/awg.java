/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class awg {
    private final atv a;
    private int b;
    private int h;
    protected int c;
    protected int d;
    private int i;
    private int j;
    protected final int e;
    private int k;
    private int l;
    protected int f;
    protected int g;
    private float m = -2.0f;
    private float n;
    private float o;
    private int p = -1;
    private long q;
    private boolean r = true;
    private boolean s;
    private int t;

    public awg(atv par1Minecraft, int par2, int par3, int par4, int par5, int par6) {
        this.a = par1Minecraft;
        this.b = par2;
        this.h = par3;
        this.c = par4;
        this.d = par5;
        this.e = par6;
        this.j = 0;
        this.i = par2;
    }

    public void a(int par1, int par2, int par3, int par4) {
        this.b = par1;
        this.h = par2;
        this.c = par3;
        this.d = par4;
        this.j = 0;
        this.i = par1;
    }

    public void a(boolean par1) {
        this.r = par1;
    }

    protected void a(boolean par1, int par2) {
        this.s = par1;
        this.t = par2;
        if (!par1) {
            this.t = 0;
        }
    }

    protected abstract int a();

    protected abstract void a(int var1, boolean var2);

    protected abstract boolean a(int var1);

    protected int d() {
        return this.a() * this.e + this.t;
    }

    protected abstract void b();

    protected abstract void a(int var1, int var2, int var3, int var4, bfq var5);

    protected void a(int par1, int par2, bfq par3Tessellator) {
    }

    protected void a(int par1, int par2) {
    }

    protected void b(int par1, int par2) {
    }

    public int c(int par1, int par2) {
        int k = this.b / 2 - 110;
        int l = this.b / 2 + 110;
        int i1 = par2 - this.c - this.t + (int)this.o - 4;
        int j1 = i1 / this.e;
        return par1 >= k && par1 <= l && j1 >= 0 && i1 >= 0 && j1 < this.a() ? j1 : -1;
    }

    public void d(int par1, int par2) {
        this.k = par1;
        this.l = par2;
    }

    private void h() {
        int i = this.e();
        if (i < 0) {
            i /= 2;
        }
        if (this.o < 0.0f) {
            this.o = 0.0f;
        }
        if (this.o > (float)i) {
            this.o = i;
        }
    }

    public int e() {
        return this.d() - (this.d - this.c - 4);
    }

    public void b(int par1) {
        this.o += (float)par1;
        this.h();
        this.m = -2.0f;
    }

    public void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == this.k) {
                this.o -= (float)(this.e * 2 / 3);
                this.m = -2.0f;
                this.h();
            } else if (par1GuiButton.g == this.l) {
                this.o += (float)(this.e * 2 / 3);
                this.m = -2.0f;
                this.h();
            }
        }
    }

    public void a(int par1, int par2, float par3) {
        int i3;
        int i2;
        int j2;
        int l1;
        int k1;
        int j1;
        this.f = par1;
        this.g = par2;
        this.b();
        int k = this.a();
        int l = this.c();
        int i1 = l + 6;
        if (Mouse.isButtonDown((int)0)) {
            if (this.m == -1.0f) {
                boolean flag = true;
                if (par2 >= this.c && par2 <= this.d) {
                    int k2 = this.b / 2 - 110;
                    j1 = this.b / 2 + 110;
                    k1 = par2 - this.c - this.t + (int)this.o - 4;
                    l1 = k1 / this.e;
                    if (par1 >= k2 && par1 <= j1 && l1 >= 0 && k1 >= 0 && l1 < k) {
                        boolean flag1 = l1 == this.p && atv.F() - this.q < 250L;
                        this.a(l1, flag1);
                        this.p = l1;
                        this.q = atv.F();
                    } else if (par1 >= k2 && par1 <= j1 && k1 < 0) {
                        this.a(par1 - k2, par2 - this.c + (int)this.o - 4);
                        flag = false;
                    }
                    if (par1 >= l && par1 <= i1) {
                        this.n = -1.0f;
                        j2 = this.e();
                        if (j2 < 1) {
                            j2 = 1;
                        }
                        if ((i2 = (int)((float)((this.d - this.c) * (this.d - this.c)) / (float)this.d())) < 32) {
                            i2 = 32;
                        }
                        if (i2 > this.d - this.c - 8) {
                            i2 = this.d - this.c - 8;
                        }
                        this.n /= (float)(this.d - this.c - i2) / (float)j2;
                    } else {
                        this.n = 1.0f;
                    }
                    this.m = flag ? (float)par2 : -2.0f;
                } else {
                    this.m = -2.0f;
                }
            } else if (this.m >= 0.0f) {
                this.o -= ((float)par2 - this.m) * this.n;
                this.m = par2;
            }
        } else {
            while (!this.a.u.A && Mouse.next()) {
                int l2 = Mouse.getEventDWheel();
                if (l2 == 0) continue;
                if (l2 > 0) {
                    l2 = -1;
                } else if (l2 < 0) {
                    l2 = 1;
                }
                this.o += (float)(l2 * this.e / 2);
            }
            this.m = -1.0f;
        }
        this.h();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2912);
        bfq tessellator = bfq.a;
        this.drawContainerBackground(tessellator);
        j1 = this.b / 2 - 92 - 16;
        k1 = this.c + 4 - (int)this.o;
        if (this.s) {
            this.a(j1, k1, tessellator);
        }
        for (l1 = 0; l1 < k; ++l1) {
            j2 = k1 + l1 * this.e + this.t;
            i2 = this.e - 4;
            if (j2 > this.d || j2 + i2 < this.c) continue;
            if (this.r && this.a(l1)) {
                i3 = this.b / 2 - 110;
                int j3 = this.b / 2 + 110;
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3553);
                tessellator.b();
                tessellator.d(0x808080);
                tessellator.a(i3, j2 + i2 + 2, 0.0, 0.0, 1.0);
                tessellator.a(j3, j2 + i2 + 2, 0.0, 1.0, 1.0);
                tessellator.a(j3, j2 - 2, 0.0, 1.0, 0.0);
                tessellator.a(i3, j2 - 2, 0.0, 0.0, 0.0);
                tessellator.d(0);
                tessellator.a(i3 + 1, j2 + i2 + 1, 0.0, 0.0, 1.0);
                tessellator.a(j3 - 1, j2 + i2 + 1, 0.0, 1.0, 1.0);
                tessellator.a(j3 - 1, j2 - 1, 0.0, 1.0, 0.0);
                tessellator.a(i3 + 1, j2 - 1, 0.0, 0.0, 0.0);
                tessellator.a();
                GL11.glEnable((int)3553);
            }
            this.a(l1, j1, j2, i2, tessellator);
        }
        GL11.glDisable((int)2929);
        int b0 = 4;
        this.b(0, this.c, 255, 255);
        this.b(this.d, this.h, 255, 255);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3008);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)3553);
        tessellator.b();
        tessellator.a(0, 0);
        tessellator.a(this.j, this.c + b0, 0.0, 0.0, 1.0);
        tessellator.a(this.i, this.c + b0, 0.0, 1.0, 1.0);
        tessellator.a(0, 255);
        tessellator.a(this.i, this.c, 0.0, 1.0, 0.0);
        tessellator.a(this.j, this.c, 0.0, 0.0, 0.0);
        tessellator.a();
        tessellator.b();
        tessellator.a(0, 255);
        tessellator.a(this.j, this.d, 0.0, 0.0, 1.0);
        tessellator.a(this.i, this.d, 0.0, 1.0, 1.0);
        tessellator.a(0, 0);
        tessellator.a(this.i, this.d - b0, 0.0, 1.0, 0.0);
        tessellator.a(this.j, this.d - b0, 0.0, 0.0, 0.0);
        tessellator.a();
        j2 = this.e();
        if (j2 > 0) {
            i2 = (this.d - this.c) * (this.d - this.c) / this.d();
            if (i2 < 32) {
                i2 = 32;
            }
            if (i2 > this.d - this.c - 8) {
                i2 = this.d - this.c - 8;
            }
            if ((i3 = (int)this.o * (this.d - this.c - i2) / j2 + this.c) < this.c) {
                i3 = this.c;
            }
            tessellator.b();
            tessellator.a(0, 255);
            tessellator.a(l, this.d, 0.0, 0.0, 1.0);
            tessellator.a(i1, this.d, 0.0, 1.0, 1.0);
            tessellator.a(i1, this.c, 0.0, 1.0, 0.0);
            tessellator.a(l, this.c, 0.0, 0.0, 0.0);
            tessellator.a();
            tessellator.b();
            tessellator.a(0x808080, 255);
            tessellator.a(l, i3 + i2, 0.0, 0.0, 1.0);
            tessellator.a(i1, i3 + i2, 0.0, 1.0, 1.0);
            tessellator.a(i1, i3, 0.0, 1.0, 0.0);
            tessellator.a(l, i3, 0.0, 0.0, 0.0);
            tessellator.a();
            tessellator.b();
            tessellator.a(0xC0C0C0, 255);
            tessellator.a(l, i3 + i2 - 1, 0.0, 0.0, 1.0);
            tessellator.a(i1 - 1, i3 + i2 - 1, 0.0, 1.0, 1.0);
            tessellator.a(i1 - 1, i3, 0.0, 1.0, 0.0);
            tessellator.a(l, i3, 0.0, 0.0, 0.0);
            tessellator.a();
        }
        this.b(par1, par2);
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)3008);
        GL11.glDisable((int)3042);
    }

    protected int c() {
        return this.b / 2 + 124;
    }

    protected void b(int par1, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        this.a.J().a(avk.k);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f = 32.0f;
        tessellator.b();
        tessellator.a(0x404040, par4);
        tessellator.a(0.0, par2, 0.0, 0.0, (float)par2 / f);
        tessellator.a(this.b, par2, 0.0, (float)this.b / f, (float)par2 / f);
        tessellator.a(0x404040, par3);
        tessellator.a(this.b, par1, 0.0, (float)this.b / f, (float)par1 / f);
        tessellator.a(0.0, par1, 0.0, 0.0, (float)par1 / f);
        tessellator.a();
    }

    protected void drawContainerBackground(bfq tess) {
        this.a.J().a(avk.k);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float height = 32.0f;
        tess.b();
        tess.d(0x202020);
        tess.a(this.j, this.d, 0.0, (float)this.j / height, (float)(this.d + (int)this.o) / height);
        tess.a(this.i, this.d, 0.0, (float)this.i / height, (float)(this.d + (int)this.o) / height);
        tess.a(this.i, this.c, 0.0, (float)this.i / height, (float)(this.c + (int)this.o) / height);
        tess.a(this.j, this.c, 0.0, (float)this.j / height, (float)(this.c + (int)this.o) / height);
        tess.a();
    }
}

