/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atr
 *  avl
 *  awf
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ma
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class auu
extends avk {
    private final atv a;
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private int e;
    private boolean f;

    public auu(atv par1Minecraft) {
        this.a = par1Minecraft;
    }

    public void a(int par1) {
        if (this.a.u.n != 2) {
            int j2 = this.i();
            boolean flag = false;
            int k = 0;
            int l = this.d.size();
            float f = this.a.u.r * 0.9f + 0.1f;
            if (l > 0) {
                int l1;
                int k1;
                int j1;
                if (this.e()) {
                    flag = true;
                }
                float f1 = this.h();
                int i1 = ls.f((float)this.f() / f1);
                GL11.glPushMatrix();
                GL11.glTranslatef((float)2.0f, (float)20.0f, (float)0.0f);
                GL11.glScalef((float)f1, (float)f1, (float)1.0f);
                for (j1 = 0; j1 + this.e < this.d.size() && j1 < j2; ++j1) {
                    atr chatline = (atr)this.d.get(j1 + this.e);
                    if (chatline == null || (k1 = par1 - chatline.b()) >= 200 && !flag) continue;
                    double d0 = (double)k1 / 200.0;
                    d0 = 1.0 - d0;
                    if ((d0 *= 10.0) < 0.0) {
                        d0 = 0.0;
                    }
                    if (d0 > 1.0) {
                        d0 = 1.0;
                    }
                    d0 *= d0;
                    l1 = (int)(255.0 * d0);
                    if (flag) {
                        l1 = 255;
                    }
                    l1 = (int)((float)l1 * f);
                    ++k;
                    if (l1 <= 3) continue;
                    int b0 = 0;
                    int i2 = -j1 * 9;
                    auu.a(b0, i2 - 9, b0 + i1 + 4, i2, l1 / 2 << 24);
                    GL11.glEnable((int)3042);
                    String s2 = chatline.a();
                    if (!this.a.u.o) {
                        s2 = ma.a((String)s2);
                    }
                    this.a.l.a(s2, b0, i2 - 8, 0xFFFFFF + (l1 << 24));
                }
                if (flag) {
                    j1 = this.a.l.a;
                    GL11.glTranslatef((float)-3.0f, (float)0.0f, (float)0.0f);
                    int j22 = l * j1 + l;
                    k1 = k * j1 + k;
                    int k2 = this.e * k1 / l;
                    int l2 = k1 * k1 / j22;
                    if (j22 != k1) {
                        l1 = k2 > 0 ? 170 : 96;
                        int i3 = this.f ? 0xCC3333 : 0x3333AA;
                        auu.a(0, -k2, 2, -k2 - l2, i3 + (l1 << 24));
                        auu.a(2, -k2, 1, -k2 - l2, 0xCCCCCC + (l1 << 24));
                    }
                }
                GL11.glPopMatrix();
            }
        }
    }

    public void a() {
        this.d.clear();
        this.c.clear();
        this.b.clear();
    }

    public void a(String par1Str) {
        this.a(par1Str, 0);
    }

    public void a(String par1Str, int par2) {
        this.a(par1Str, par2, this.a.r.c(), false);
        this.a.an().a("[CHAT] " + a.a(par1Str));
    }

    private void a(String par1Str, int par2, int par3, boolean par4) {
        boolean flag1 = this.e();
        boolean flag2 = true;
        if (par2 != 0) {
            this.c(par2);
        }
        for (String s1 : this.a.l.c(par1Str, ls.d((float)this.f() / this.h()))) {
            if (flag1 && this.e > 0) {
                this.f = true;
                this.b(1);
            }
            if (!flag2) {
                s1 = " " + s1;
            }
            flag2 = false;
            this.d.add(0, new atr(par3, s1, par2));
        }
        while (this.d.size() > 100) {
            this.d.remove(this.d.size() - 1);
        }
        if (!par4) {
            this.c.add(0, new atr(par3, par1Str.trim(), par2));
            while (this.c.size() > 100) {
                this.c.remove(this.c.size() - 1);
            }
        }
    }

    public void b() {
        this.d.clear();
        this.d();
        for (int i = this.c.size() - 1; i >= 0; --i) {
            atr chatline = (atr)this.c.get(i);
            this.a(chatline.a(), chatline.c(), chatline.b(), true);
        }
    }

    public List c() {
        return this.b;
    }

    public void b(String par1Str) {
        if (this.b.isEmpty() || !((String)this.b.get(this.b.size() - 1)).equals(par1Str)) {
            this.b.add(par1Str);
        }
    }

    public void d() {
        this.e = 0;
        this.f = false;
    }

    public void b(int par1) {
        this.e += par1;
        int j2 = this.d.size();
        if (this.e > j2 - this.i()) {
            this.e = j2 - this.i();
        }
        if (this.e <= 0) {
            this.e = 0;
            this.f = false;
        }
    }

    public avl a(int par1, int par2) {
        if (!this.e()) {
            return null;
        }
        awf scaledresolution = new awf(this.a.u, this.a.d, this.a.e);
        int k = scaledresolution.e();
        float f = this.h();
        int l = par1 / k - 3;
        int i1 = par2 / k - 25;
        l = ls.d((float)l / f);
        i1 = ls.d((float)i1 / f);
        if (l >= 0 && i1 >= 0) {
            int j1 = Math.min(this.i(), this.d.size());
            if (l <= ls.d((float)this.f() / this.h()) && i1 < this.a.l.a * j1 + j1) {
                int k1 = i1 / (this.a.l.a + 1) + this.e;
                return new avl(this.a.l, (atr)this.d.get(k1), l, i1 - (k1 - this.e) * this.a.l.a + k1);
            }
            return null;
        }
        return null;
    }

    public void a(String par1Str, Object ... par2ArrayOfObj) {
        this.a(bkb.a((String)par1Str, (Object[])par2ArrayOfObj));
    }

    public boolean e() {
        return this.a.n instanceof auw;
    }

    public void c(int par1) {
        atr chatline;
        Iterator iterator = this.d.iterator();
        do {
            if (iterator.hasNext()) continue;
            iterator = this.c.iterator();
            do {
                if (iterator.hasNext()) continue;
                return;
            } while ((chatline = (atr)iterator.next()).c() != par1);
            iterator.remove();
            return;
        } while ((chatline = (atr)iterator.next()).c() != par1);
        iterator.remove();
    }

    public int f() {
        return auu.a(this.a.u.F);
    }

    public int g() {
        return auu.b(this.e() ? this.a.u.H : this.a.u.G);
    }

    public float h() {
        return this.a.u.E;
    }

    public static final int a(float par0) {
        int short1 = 320;
        int b0 = 40;
        return ls.d(par0 * (float)(short1 - b0) + (float)b0);
    }

    public static final int b(float par0) {
        int short1 = 180;
        int b0 = 20;
        return ls.d(par0 * (float)(short1 - b0) + (float)b0);
    }

    public int i() {
        return this.g() / 9;
    }
}

