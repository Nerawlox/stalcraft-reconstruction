/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  auq
 *  awf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  lx
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class auo
implements lx {
    private String a = "";
    private atv b;
    private String c = "";
    private long d = atv.F();
    private boolean e;

    public auo(atv par1Minecraft) {
        this.b = par1Minecraft;
    }

    public void b(String par1Str) {
        this.e = false;
        this.d(par1Str);
    }

    public void a(String par1Str) {
        this.e = true;
        this.d(par1Str);
    }

    public void d(String par1Str) {
        this.c = par1Str;
        if (!this.b.D) {
            if (!this.e) {
                throw new auq();
            }
        } else {
            awf scaledresolution = new awf(this.b.u, this.b.d, this.b.e);
            GL11.glClear((int)256);
            GL11.glMatrixMode((int)5889);
            GL11.glLoadIdentity();
            GL11.glOrtho((double)0.0, (double)scaledresolution.c(), (double)scaledresolution.d(), (double)0.0, (double)100.0, (double)300.0);
            GL11.glMatrixMode((int)5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-200.0f);
        }
    }

    public void c(String par1Str) {
        if (!this.b.D) {
            if (!this.e) {
                throw new auq();
            }
        } else {
            this.d = 0L;
            this.a = par1Str;
            this.a(-1);
            this.d = 0L;
        }
    }

    public void a(int par1) {
        if (!this.b.D) {
            if (!this.e) {
                throw new auq();
            }
        } else {
            long j2 = atv.F();
            if (j2 - this.d >= 100L) {
                this.d = j2;
                awf scaledresolution = new awf(this.b.u, this.b.d, this.b.e);
                int k = scaledresolution.a();
                int l = scaledresolution.b();
                GL11.glClear((int)256);
                GL11.glMatrixMode((int)5889);
                GL11.glLoadIdentity();
                GL11.glOrtho((double)0.0, (double)scaledresolution.c(), (double)scaledresolution.d(), (double)0.0, (double)100.0, (double)300.0);
                GL11.glMatrixMode((int)5888);
                GL11.glLoadIdentity();
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-200.0f);
                GL11.glClear((int)16640);
                bfq tessellator = bfq.a;
                this.b.J().a(avk.k);
                float f = 32.0f;
                tessellator.b();
                tessellator.d(0x404040);
                tessellator.a(0.0, l, 0.0, 0.0, (float)l / f);
                tessellator.a(k, l, 0.0, (float)k / f, (float)l / f);
                tessellator.a(k, 0.0, 0.0, (float)k / f, 0.0);
                tessellator.a(0.0, 0.0, 0.0, 0.0, 0.0);
                tessellator.a();
                if (par1 >= 0) {
                    int b0 = 100;
                    int b1 = 2;
                    int i1 = k / 2 - b0 / 2;
                    int j1 = l / 2 + 16;
                    GL11.glDisable((int)3553);
                    tessellator.b();
                    tessellator.d(0x808080);
                    tessellator.a((double)i1, (double)j1, 0.0);
                    tessellator.a((double)i1, (double)(j1 + b1), 0.0);
                    tessellator.a((double)(i1 + b0), (double)(j1 + b1), 0.0);
                    tessellator.a((double)(i1 + b0), (double)j1, 0.0);
                    tessellator.d(0x80FF80);
                    tessellator.a((double)i1, (double)j1, 0.0);
                    tessellator.a((double)i1, (double)(j1 + b1), 0.0);
                    tessellator.a((double)(i1 + par1), (double)(j1 + b1), 0.0);
                    tessellator.a((double)(i1 + par1), (double)j1, 0.0);
                    tessellator.a();
                    GL11.glEnable((int)3553);
                }
                this.b.l.a(this.c, (k - this.b.l.a(this.c)) / 2, l / 2 - 4 - 16, 0xFFFFFF);
                this.b.l.a(this.a, (k - this.b.l.a(this.a)) / 2, l / 2 - 4 + 8, 0xFFFFFF);
                Display.update();
                try {
                    Thread.yield();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}

