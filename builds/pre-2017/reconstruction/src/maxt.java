/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class maxt {
    public final Minecraft _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public final int _h;
    public int _i;
    public int _j;
    public int _k;
    public int _l;
    public float _m = -2.0f;
    public float _n;
    public float _o;
    public int _p = -1;
    public long _q;
    public boolean _r = true;
    public boolean _s;
    public int _t;

    public maxt(Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        this._a = minecraft;
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._e = n4;
        this._h = n5;
        this._g = 0;
        this._f = n;
    }

    public void _a(int n, int n2, int n3, int n4) {
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._e = n4;
        this._g = 0;
        this._f = n;
    }

    public abstract int _a();

    public abstract void _a(int var1, boolean var2);

    public abstract boolean _a(int var1);

    public abstract boolean _b(int var1);

    public int _b() {
        return this._a() * this._h + this._t;
    }

    public abstract void _c();

    public abstract void _a(int var1, int var2, int var3, int var4, Tessellator var5);

    public void _a(int n, int n2, Tessellator tessellator) {
    }

    public void _a(int n, int n2) {
    }

    public void _b(int n, int n2) {
    }

    public void _d() {
        int n = this._e();
        if (n < 0) {
            n /= 2;
        }
        if (this._o < 0.0f) {
            this._o = 0.0f;
        }
        if (this._o > (float)n) {
            this._o = n;
        }
    }

    public int _e() {
        return this._b() - (this._e - this._d - 4);
    }

    public void _a(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == this._i) {
            this._o -= (float)(this._h * 2 / 3);
            this._m = -2.0f;
            this._d();
        } else if (guiButton.id == this._j) {
            this._o += (float)(this._h * 2 / 3);
            this._m = -2.0f;
            this._d();
        }
    }

    public void _a(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        this._k = n;
        this._l = n2;
        this._c();
        int n10 = this._a();
        int n11 = this._f();
        int n12 = n11 + 6;
        if (Mouse.isButtonDown(0)) {
            if (this._m == -1.0f) {
                n9 = 1;
                if (n2 >= this._d && n2 <= this._e) {
                    int n13 = this._b / 2 - 110;
                    n8 = this._b / 2 + 110;
                    n7 = n2 - this._d - this._t + (int)this._o - 4;
                    n6 = n7 / this._h;
                    if (n >= n13 && n <= n8 && n6 >= 0 && n7 >= 0 && n6 < n10) {
                        n5 = n6 == this._p && Minecraft._M() - this._q < 250L ? 1 : 0;
                        this._a(n6, n5 != 0);
                        this._p = n6;
                        this._q = Minecraft._M();
                    } else if (n >= n13 && n <= n8 && n7 < 0) {
                        this._a(n - n13, n2 - this._d + (int)this._o - 4);
                        n9 = 0;
                    }
                    if (n >= n11 && n <= n12) {
                        this._n = -1.0f;
                        n5 = this._e();
                        if (n5 < 1) {
                            n5 = 1;
                        }
                        if ((n4 = (int)((float)((this._e - this._d) * (this._e - this._d)) / (float)this._b())) < 32) {
                            n4 = 32;
                        }
                        if (n4 > this._e - this._d - 8) {
                            n4 = this._e - this._d - 8;
                        }
                        this._n /= (float)(this._e - this._d - n4) / (float)n5;
                    } else {
                        this._n = 1.0f;
                    }
                    this._m = n9 != 0 ? (float)n2 : -2.0f;
                } else {
                    this._m = -2.0f;
                }
            } else if (this._m >= 0.0f) {
                this._o -= ((float)n2 - this._m) * this._n;
                this._m = n2;
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
                this._o += (float)(n9 * this._h / 2);
            }
            this._m = -1.0f;
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
        tessellator.addVertexWithUV(this._g, this._e, 0.0, (float)this._g / f2, (float)(this._e + (int)this._o) / f2);
        tessellator.addVertexWithUV(this._f, this._e, 0.0, (float)this._f / f2, (float)(this._e + (int)this._o) / f2);
        tessellator.addVertexWithUV(this._f, this._d, 0.0, (float)this._f / f2, (float)(this._d + (int)this._o) / f2);
        tessellator.addVertexWithUV(this._g, this._d, 0.0, (float)this._g / f2, (float)(this._d + (int)this._o) / f2);
        tessellator.draw();
        n8 = this._b / 2 - 92 - 16;
        n7 = this._d + 4 - (int)this._o;
        if (this._s) {
            this._a(n8, n7, tessellator);
        }
        for (n6 = 0; n6 < n10; ++n6) {
            int n14;
            n5 = n7 + n6 * this._h + this._t;
            n4 = this._h - 4;
            if (n5 > this._e || n5 + n4 < this._d) continue;
            if (this._r && this._b(n6)) {
                n3 = this._b / 2 - 110;
                n14 = this._b / 2 + 110;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(0);
                tessellator.addVertexWithUV(n3, n5 + n4 + 2, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n14, n5 + n4 + 2, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n14, n5 - 2, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n3, n5 - 2, 0.0, 0.0, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            if (this._r && this._a(n6)) {
                n3 = this._b / 2 - 110;
                n14 = this._b / 2 + 110;
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
        this._b(0, this._d, 255, 255);
        this._b(this._e, this._c, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this._g, this._d + n6, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this._f, this._d + n6, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this._f, this._d, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this._g, this._d, 0.0, 0.0, 0.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this._g, this._e, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this._f, this._e, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this._f, this._e - n6, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this._g, this._e - n6, 0.0, 0.0, 0.0);
        tessellator.draw();
        n5 = this._e();
        if (n5 > 0) {
            n4 = (this._e - this._d) * (this._e - this._d) / this._b();
            if (n4 < 32) {
                n4 = 32;
            }
            if (n4 > this._e - this._d - 8) {
                n4 = this._e - this._d - 8;
            }
            if ((n3 = (int)this._o * (this._e - this._d - n4) / n5 + this._d) < this._d) {
                n3 = this._d;
            }
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0, 255);
            tessellator.addVertexWithUV(n11, this._e, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n12, this._e, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n12, this._d, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n11, this._d, 0.0, 0.0, 0.0);
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
        this._b(n, n2);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    public int _f() {
        return this._b / 2 + 124;
    }

    public void _b(int n, int n2, int n3, int n4) {
        Tessellator tessellator = Tessellator.instance;
        this._a._R()._a(Gui.optionsBackground);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0x404040, n4);
        tessellator.addVertexWithUV(0.0, n2, 0.0, 0.0, (float)n2 / f);
        tessellator.addVertexWithUV(this._b, n2, 0.0, (float)this._b / f, (float)n2 / f);
        tessellator.setColorRGBA_I(0x404040, n3);
        tessellator.addVertexWithUV(this._b, n, 0.0, (float)this._b / f, (float)n / f);
        tessellator.addVertexWithUV(0.0, n, 0.0, 0.0, (float)n / f);
        tessellator.draw();
    }
}

