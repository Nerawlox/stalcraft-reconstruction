/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class ohcb {
    public final Minecraft _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public final int _e;
    public final int _f;
    public int _g;
    public int _h;
    public float _i = -2.0f;
    public float _j;
    public float _k;
    public int _l = -1;
    public long _m;

    public ohcb(Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        this._a = minecraft;
        this._c = n2;
        this._e = n2 + n4;
        this._f = n5;
        this._b = n;
        this._d = n + n3;
    }

    public abstract int _a();

    public abstract void _a(int var1, boolean var2);

    public abstract boolean _a(int var1);

    public int _b() {
        return this._a() * this._f;
    }

    public abstract void _c();

    public abstract void _a(int var1, int var2, int var3, int var4, Tessellator var5);

    public void _d() {
        int n = this._e();
        if (n < 0) {
            n = 0;
        }
        if (this._k < 0.0f) {
            this._k = 0.0f;
        }
        if (this._k > (float)n) {
            this._k = n;
        }
    }

    public int _e() {
        return this._b() - (this._e - this._c - 4);
    }

    public void _a(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        this._g = n;
        this._h = n2;
        this._c();
        int n10 = this._a();
        int n11 = this._f();
        int n12 = n11 + 6;
        if (Mouse.isButtonDown(0)) {
            if (this._i == -1.0f) {
                n9 = 1;
                if (n2 >= this._c && n2 <= this._e) {
                    int n13 = this._b + 2;
                    n8 = this._d - 2;
                    n7 = n2 - this._c + (int)this._k - 4;
                    n6 = n7 / this._f;
                    if (n >= n13 && n <= n8 && n6 >= 0 && n7 >= 0 && n6 < n10) {
                        n5 = n6 == this._l && Minecraft._M() - this._m < 250L ? 1 : 0;
                        this._a(n6, n5 != 0);
                        this._l = n6;
                        this._m = Minecraft._M();
                    } else if (n >= n13 && n <= n8 && n7 < 0) {
                        n9 = 0;
                    }
                    if (n >= n11 && n <= n12) {
                        this._j = -1.0f;
                        n5 = this._e();
                        if (n5 < 1) {
                            n5 = 1;
                        }
                        if ((n4 = (int)((float)((this._e - this._c) * (this._e - this._c)) / (float)this._b())) < 32) {
                            n4 = 32;
                        }
                        if (n4 > this._e - this._c - 8) {
                            n4 = this._e - this._c - 8;
                        }
                        this._j /= (float)(this._e - this._c - n4) / (float)n5;
                    } else {
                        this._j = 1.0f;
                    }
                    this._i = n9 != 0 ? (float)n2 : -2.0f;
                } else {
                    this._i = -2.0f;
                }
            } else if (this._i >= 0.0f) {
                this._k -= ((float)n2 - this._i) * this._j;
                this._i = n2;
            }
        } else {
            while (!this._a._M.touchscreen && Mouse.next()) {
                n9 = Mouse.getEventDWheel();
                if (n9 == 0) continue;
                if (n9 > 0) {
                    n9 = -1;
                } else if (n9 < 0) {
                    n9 = 1;
                }
                this._k += (float)(n9 * this._f / 2);
            }
            this._i = -1.0f;
        }
        this._d();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.instance;
        this._a._R()._a(Gui.optionsBackground);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f2 = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x202020);
        tessellator.addVertexWithUV(this._b, this._e, 0.0, (float)this._b / f2, (float)(this._e + (int)this._k) / f2);
        tessellator.addVertexWithUV(this._d, this._e, 0.0, (float)this._d / f2, (float)(this._e + (int)this._k) / f2);
        tessellator.addVertexWithUV(this._d, this._c, 0.0, (float)this._d / f2, (float)(this._c + (int)this._k) / f2);
        tessellator.addVertexWithUV(this._b, this._c, 0.0, (float)this._b / f2, (float)(this._c + (int)this._k) / f2);
        tessellator.draw();
        n8 = this._b + 2;
        n7 = this._c + 4 - (int)this._k;
        for (n6 = 0; n6 < n10; ++n6) {
            n5 = n7 + n6 * this._f;
            n4 = this._f - 4;
            if (n5 + this._f > this._e || n5 - 4 < this._c) continue;
            if (this._a(n6)) {
                n3 = this._b + 2;
                int n14 = this._d - 2;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(0x808080);
                tessellator.addVertexWithUV(n3, n5 + n4 + 2, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n14, n5 + n4 + 2, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n14, n5 - 2, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n3, n5 - 2, 0.0, 0.0, 0.0);
                tessellator.setColorOpaque_I(0);
                tessellator.addVertexWithUV(n3 + 1, n5 + n4 + 1, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n14 - 1, n5 + n4 + 1, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n14 - 1, n5 - 1, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n3 + 1, n5 - 1, 0.0, 0.0, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            this._a(n6, n8, n5, n4, tessellator);
        }
        GL11.glDisable(2929);
        n6 = 4;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this._b, this._c + n6, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this._d, this._c + n6, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this._d, this._c, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this._b, this._c, 0.0, 0.0, 0.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this._b, this._e, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this._d, this._e, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this._d, this._e - n6, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this._b, this._e - n6, 0.0, 0.0, 0.0);
        tessellator.draw();
        n5 = this._e();
        if (n5 > 0) {
            n4 = (this._e - this._c) * (this._e - this._c) / this._b();
            if (n4 < 32) {
                n4 = 32;
            }
            if (n4 > this._e - this._c - 8) {
                n4 = this._e - this._c - 8;
            }
            if ((n3 = (int)this._k * (this._e - this._c - n4) / n5 + this._c) < this._c) {
                n3 = this._c;
            }
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0, 255);
            tessellator.addVertexWithUV(n11, this._e, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n12, this._e, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n12, this._c, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n11, this._c, 0.0, 0.0, 0.0);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0x808080, 255);
            tessellator.addVertexWithUV(n11, n3 + n4, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n12, n3 + n4, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n12, n3, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n11, n3, 0.0, 0.0, 0.0);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0xC0C0C0, 255);
            tessellator.addVertexWithUV(n11, n3 + n4 - 1, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n12 - 1, n3 + n4 - 1, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n12 - 1, n3, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n11, n3, 0.0, 0.0, 0.0);
            tessellator.draw();
        }
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    public int _f() {
        return this._d - 8;
    }
}

