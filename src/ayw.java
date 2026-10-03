/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
public abstract class ayw {
    private final atv a;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    protected final int b;
    protected int c;
    protected int d;
    private float i = -2.0f;
    private float j;
    private float k;
    private int l = -1;
    private long m;

    public ayw(atv par1Minecraft, int par2, int par3, int par4, int par5, int par6) {
        this.a = par1Minecraft;
        this.f = par3;
        this.h = par3 + par5;
        this.b = par6;
        this.e = par2;
        this.g = par2 + par4;
    }

    protected abstract int a();

    protected abstract void a(int var1, boolean var2);

    protected abstract boolean a(int var1);

    protected int b() {
        return this.a() * this.b;
    }

    protected abstract void c();

    protected abstract void a(int var1, int var2, int var3, int var4, bfq var5);

    private void f() {
        int i = this.d();
        if (i < 0) {
            i = 0;
        }
        if (this.k < 0.0f) {
            this.k = 0.0f;
        }
        if (this.k > (float)i) {
            this.k = i;
        }
    }

    public int d() {
        return this.b() - (this.h - this.f - 4);
    }

    public void a(int par1, int par2, float par3) {
        int i3;
        int i2;
        int j2;
        int l1;
        int k1;
        int j1;
        this.c = par1;
        this.d = par2;
        this.c();
        int k = this.a();
        int l = this.e();
        int i1 = l + 6;
        if (Mouse.isButtonDown((int)0)) {
            if (this.i == -1.0f) {
                boolean flag = true;
                if (par2 >= this.f && par2 <= this.h) {
                    int k2 = this.e + 2;
                    j1 = this.g - 2;
                    k1 = par2 - this.f + (int)this.k - 4;
                    l1 = k1 / this.b;
                    if (par1 >= k2 && par1 <= j1 && l1 >= 0 && k1 >= 0 && l1 < k) {
                        boolean flag1 = l1 == this.l && atv.F() - this.m < 250L;
                        this.a(l1, flag1);
                        this.l = l1;
                        this.m = atv.F();
                    } else if (par1 >= k2 && par1 <= j1 && k1 < 0) {
                        flag = false;
                    }
                    if (par1 >= l && par1 <= i1) {
                        this.j = -1.0f;
                        j2 = this.d();
                        if (j2 < 1) {
                            j2 = 1;
                        }
                        if ((i2 = (int)((float)((this.h - this.f) * (this.h - this.f)) / (float)this.b())) < 32) {
                            i2 = 32;
                        }
                        if (i2 > this.h - this.f - 8) {
                            i2 = this.h - this.f - 8;
                        }
                        this.j /= (float)(this.h - this.f - i2) / (float)j2;
                    } else {
                        this.j = 1.0f;
                    }
                    this.i = flag ? (float)par2 : -2.0f;
                } else {
                    this.i = -2.0f;
                }
            } else if (this.i >= 0.0f) {
                this.k -= ((float)par2 - this.i) * this.j;
                this.i = par2;
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
                this.k += (float)(l2 * this.b / 2);
            }
            this.i = -1.0f;
        }
        this.f();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2912);
        bfq tessellator = bfq.a;
        this.a.J().a(avk.k);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f1 = 32.0f;
        tessellator.b();
        tessellator.d(0x202020);
        tessellator.a(this.e, this.h, 0.0, (float)this.e / f1, (float)(this.h + (int)this.k) / f1);
        tessellator.a(this.g, this.h, 0.0, (float)this.g / f1, (float)(this.h + (int)this.k) / f1);
        tessellator.a(this.g, this.f, 0.0, (float)this.g / f1, (float)(this.f + (int)this.k) / f1);
        tessellator.a(this.e, this.f, 0.0, (float)this.e / f1, (float)(this.f + (int)this.k) / f1);
        tessellator.a();
        j1 = this.e + 2;
        k1 = this.f + 4 - (int)this.k;
        for (l1 = 0; l1 < k; ++l1) {
            j2 = k1 + l1 * this.b;
            i2 = this.b - 4;
            if (j2 + this.b > this.h || j2 - 4 < this.f) continue;
            if (this.a(l1)) {
                i3 = this.e + 2;
                int j3 = this.g - 2;
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
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3008);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)3553);
        tessellator.b();
        tessellator.a(0, 0);
        tessellator.a(this.e, this.f + b0, 0.0, 0.0, 1.0);
        tessellator.a(this.g, this.f + b0, 0.0, 1.0, 1.0);
        tessellator.a(0, 255);
        tessellator.a(this.g, this.f, 0.0, 1.0, 0.0);
        tessellator.a(this.e, this.f, 0.0, 0.0, 0.0);
        tessellator.a();
        tessellator.b();
        tessellator.a(0, 255);
        tessellator.a(this.e, this.h, 0.0, 0.0, 1.0);
        tessellator.a(this.g, this.h, 0.0, 1.0, 1.0);
        tessellator.a(0, 0);
        tessellator.a(this.g, this.h - b0, 0.0, 1.0, 0.0);
        tessellator.a(this.e, this.h - b0, 0.0, 0.0, 0.0);
        tessellator.a();
        j2 = this.d();
        if (j2 > 0) {
            i2 = (this.h - this.f) * (this.h - this.f) / this.b();
            if (i2 < 32) {
                i2 = 32;
            }
            if (i2 > this.h - this.f - 8) {
                i2 = this.h - this.f - 8;
            }
            if ((i3 = (int)this.k * (this.h - this.f - i2) / j2 + this.f) < this.f) {
                i3 = this.f;
            }
            tessellator.b();
            tessellator.a(0, 255);
            tessellator.a(l, this.h, 0.0, 0.0, 1.0);
            tessellator.a(i1, this.h, 0.0, 1.0, 1.0);
            tessellator.a(i1, this.f, 0.0, 1.0, 0.0);
            tessellator.a(l, this.f, 0.0, 0.0, 0.0);
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
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)3008);
        GL11.glDisable((int)3042);
    }

    protected int e() {
        return this.g - 8;
    }
}

