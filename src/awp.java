/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awf
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ko
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class awp
extends avk {
    private static final bjo a = new bjo("textures/gui/achievement/achievement_background.png");
    private atv b;
    private int c;
    private int d;
    private String e;
    private String f;
    private ko g;
    private long h;
    private bgw i;
    private boolean j;

    public awp(atv par1Minecraft) {
        this.b = par1Minecraft;
        this.i = new bgw();
    }

    public void a(ko par1Achievement) {
        this.e = bkb.a((String)"achievement.get");
        this.f = bkb.a((String)par1Achievement.i());
        this.h = atv.F();
        this.g = par1Achievement;
        this.j = false;
    }

    public void b(ko par1Achievement) {
        this.e = bkb.a((String)par1Achievement.i());
        this.f = par1Achievement.e();
        this.h = atv.F() - 2500L;
        this.g = par1Achievement;
        this.j = true;
    }

    private void b() {
        GL11.glViewport((int)0, (int)0, (int)this.b.d, (int)this.b.e);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        this.c = this.b.d;
        this.d = this.b.e;
        awf scaledresolution = new awf(this.b.u, this.b.d, this.b.e);
        this.c = scaledresolution.a();
        this.d = scaledresolution.b();
        GL11.glClear((int)256);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)this.c, (double)this.d, (double)0.0, (double)1000.0, (double)3000.0);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-2000.0f);
    }

    public void a() {
        if (this.g != null && this.h != 0L) {
            double d0 = (double)(atv.F() - this.h) / 3000.0;
            if (!this.j && (d0 < 0.0 || d0 > 1.0)) {
                this.h = 0L;
            } else {
                this.b();
                GL11.glDisable((int)2929);
                GL11.glDepthMask((boolean)false);
                double d1 = d0 * 2.0;
                if (d1 > 1.0) {
                    d1 = 2.0 - d1;
                }
                d1 *= 4.0;
                if ((d1 = 1.0 - d1) < 0.0) {
                    d1 = 0.0;
                }
                d1 *= d1;
                d1 *= d1;
                int i = this.c - 160;
                int j2 = 0 - (int)(d1 * 36.0);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3553);
                this.b.J().a(a);
                GL11.glDisable((int)2896);
                this.b(i, j2, 96, 202, 160, 32);
                if (this.j) {
                    this.b.l.a(this.f, i + 30, j2 + 7, 120, -1);
                } else {
                    this.b.l.b(this.e, i + 30, j2 + 7, -256);
                    this.b.l.b(this.f, i + 30, j2 + 18, -1);
                }
                att.c();
                GL11.glDisable((int)2896);
                GL11.glEnable((int)32826);
                GL11.glEnable((int)2903);
                GL11.glEnable((int)2896);
                this.i.b(this.b.l, this.b.J(), this.g.d, i + 8, j2 + 8);
                GL11.glDisable((int)2896);
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)2929);
            }
        }
    }
}

