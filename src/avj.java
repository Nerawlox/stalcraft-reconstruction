/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acv
 *  akc
 *  ate
 *  atf
 *  atg
 *  atj
 *  atl
 *  awf
 *  bdj
 *  bez
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ma
 *  ms
 *  net.minecraftforge.common.ForgeHooks
 *  ni
 *  org.lwjgl.opengl.GL11
 *  os
 *  r
 *  ud
 *  ux
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ForgeHooks;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avj
extends avk {
    protected static final bjo b = new bjo("textures/misc/vignette.png");
    protected static final bjo c = new bjo("textures/gui/widgets.png");
    protected static final bjo d = new bjo("textures/misc/pumpkinblur.png");
    protected static final bgw e = new bgw();
    protected final Random f = new Random();
    protected final atv g;
    protected final auu h;
    protected int i;
    protected String j = "";
    protected int o;
    protected boolean p;
    public float a = 1.0f;
    protected int q;
    protected ye r;

    public avj(atv par1Minecraft) {
        this.g = par1Minecraft;
        this.h = new auu(par1Minecraft);
    }

    public void a(float par1, boolean par2, int par3, int par4) {
        ate scoreobjective;
        int j3;
        int k3;
        int k2;
        int l2;
        int j2;
        int short1;
        float f3;
        int k1;
        int j1;
        float f1;
        awf scaledresolution = new awf(this.g.u, this.g.d, this.g.e);
        int k = scaledresolution.a();
        int l = scaledresolution.b();
        avi fontrenderer = this.g.l;
        this.g.p.c();
        GL11.glEnable((int)3042);
        if (atv.s()) {
            this.a(this.g.h.d(par1), k, l);
        } else {
            GL11.glBlendFunc((int)770, (int)771);
        }
        ye itemstack = this.g.h.bn.f(3);
        if (this.g.u.aa == 0 && itemstack != null && itemstack.b() != null) {
            if (itemstack.d == aqz.bf.cF) {
                this.b(k, l);
            } else {
                itemstack.b().renderHelmetOverlay(itemstack, (uf)this.g.h, scaledresolution, par1, par2, par3, par4);
            }
        }
        if (!this.g.h.a(ni.k) && (f1 = this.g.h.bO + (this.g.h.bN - this.g.h.bO) * par1) > 0.0f) {
            this.b(f1, k, l);
        }
        if (!this.g.c.a()) {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.g.J().a(c);
            ud inventoryplayer = this.g.h.bn;
            this.n = -90.0f;
            this.b(k / 2 - 91, l - 22, 0, 0, 182, 22);
            this.b(k / 2 - 91 - 1 + inventoryplayer.c * 20, l - 22 - 1, 0, 22, 24, 22);
            this.g.J().a(m);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)775, (int)769);
            this.b(k / 2 - 7, l / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable((int)3042);
            this.g.C.a("bossHealth");
            this.d();
            this.g.C.b();
            if (this.g.c.b()) {
                this.a(k, l);
            }
            GL11.glDisable((int)3042);
            this.g.C.a("actionBar");
            GL11.glEnable((int)32826);
            att.c();
            for (int i1 = 0; i1 < 9; ++i1) {
                j1 = k / 2 - 90 + i1 * 20 + 2;
                k1 = l - 16 - 3;
                this.a(i1, j1, k1, par1);
            }
            att.a();
            GL11.glDisable((int)32826);
            this.g.C.b();
        }
        if (this.g.h.bE() > 0) {
            this.g.C.a("sleep");
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3008);
            int l1 = this.g.h.bE();
            float f2 = (float)l1 / 100.0f;
            if (f2 > 1.0f) {
                f2 = 1.0f - (float)(l1 - 100) / 10.0f;
            }
            j1 = (int)(220.0f * f2) << 24 | 0x101020;
            avj.a(0, 0, k, l, j1);
            GL11.glEnable((int)3008);
            GL11.glEnable((int)2929);
            this.g.C.b();
        }
        int l1 = 0xFFFFFF;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int i1 = k / 2 - 91;
        if (this.g.h.u()) {
            this.g.C.a("jumpBar");
            this.g.J().a(avk.m);
            f3 = this.g.h.bN();
            short1 = 182;
            int i2 = (int)(f3 * (float)(short1 + 1));
            j2 = l - 32 + 3;
            this.b(i1, j2, 0, 84, short1, 5);
            if (i2 > 0) {
                this.b(i1, j2, 0, 89, i2, 5);
            }
            this.g.C.b();
        } else if (this.g.c.f()) {
            this.g.C.a("expBar");
            this.g.J().a(avk.m);
            j1 = this.g.h.bH();
            if (j1 > 0) {
                short1 = 182;
                int i2 = (int)(this.g.h.bJ * (float)(short1 + 1));
                j2 = l - 32 + 3;
                this.b(i1, j2, 0, 64, short1, 5);
                if (i2 > 0) {
                    this.b(i1, j2, 0, 69, i2, 5);
                }
            }
            this.g.C.b();
            if (this.g.h.bH > 0) {
                this.g.C.a("expLevel");
                boolean flag1 = false;
                int i2 = flag1 ? 0xFFFFFF : 8453920;
                String s2 = "" + this.g.h.bH;
                l2 = (k - fontrenderer.a(s2)) / 2;
                k2 = l - 31 - 4;
                boolean flag2 = false;
                fontrenderer.b(s2, l2 + 1, k2, 0);
                fontrenderer.b(s2, l2 - 1, k2, 0);
                fontrenderer.b(s2, l2, k2 + 1, 0);
                fontrenderer.b(s2, l2, k2 - 1, 0);
                fontrenderer.b(s2, l2, k2, i2);
                this.g.C.b();
            }
        }
        if (this.g.u.D) {
            this.g.C.a("toolHighlight");
            if (this.q > 0 && this.r != null) {
                String s1 = this.r.s();
                k1 = (k - fontrenderer.a(s1)) / 2;
                int i2 = l - 59;
                if (!this.g.c.b()) {
                    i2 += 14;
                }
                if ((j2 = (int)((float)this.q * 256.0f / 10.0f)) > 255) {
                    j2 = 255;
                }
                if (j2 > 0) {
                    GL11.glPushMatrix();
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    fontrenderer.a(s1, k1, i2, 0xFFFFFF + (j2 << 24));
                    avi font = this.r.b().getFontRenderer(this.r);
                    if (font != null) {
                        k1 = (k - font.a(s1)) / 2;
                        font.a(s1, k1, i2, 0xFFFFFF + (j2 << 24));
                    } else {
                        fontrenderer.a(s1, k1, i2, 0xFFFFFF + (j2 << 24));
                    }
                    GL11.glDisable((int)3042);
                    GL11.glPopMatrix();
                }
            }
            this.g.C.b();
        }
        if (this.g.p()) {
            this.g.C.a("demo");
            String s1 = "";
            s1 = this.g.f.I() >= 120500L ? bkb.a((String)"demo.demoExpired") : bkb.a((String)"demo.remainingTime", (Object[])new Object[]{ma.a((int)((int)(120500L - this.g.f.I())))});
            k1 = fontrenderer.a(s1);
            fontrenderer.a(s1, k - k1 - 10, 5, 0xFFFFFF);
            this.g.C.b();
        }
        if (this.g.u.ab) {
            this.g.C.a("debug");
            GL11.glPushMatrix();
            fontrenderer.a("Minecraft 1.6.4 (" + this.g.E + ")", 2, 2, 0xFFFFFF);
            fontrenderer.a(this.g.l(), 2, 12, 0xFFFFFF);
            fontrenderer.a(this.g.m(), 2, 22, 0xFFFFFF);
            fontrenderer.a(this.g.o(), 2, 32, 0xFFFFFF);
            fontrenderer.a(this.g.n(), 2, 42, 0xFFFFFF);
            long l3 = Runtime.getRuntime().maxMemory();
            long i4 = Runtime.getRuntime().totalMemory();
            long j4 = Runtime.getRuntime().freeMemory();
            long k4 = i4 - j4;
            String s2 = "Used memory: " + k4 * 100L / l3 + "% (" + k4 / 1024L / 1024L + "MB) of " + l3 / 1024L / 1024L + "MB";
            int i3 = 0xE0E0E0;
            this.b(fontrenderer, s2, k - fontrenderer.a(s2) - 2, 2, 0xE0E0E0);
            s2 = "Allocated memory: " + i4 * 100L / l3 + "% (" + i4 / 1024L / 1024L + "MB)";
            this.b(fontrenderer, s2, k - fontrenderer.a(s2) - 2, 12, 0xE0E0E0);
            k3 = ls.c(this.g.h.u);
            j3 = ls.c(this.g.h.v);
            int l4 = ls.c(this.g.h.w);
            this.b(fontrenderer, String.format("x: %.5f (%d) // c: %d (%d)", this.g.h.u, k3, k3 >> 4, k3 & 0xF), 2, 64, 0xE0E0E0);
            this.b(fontrenderer, String.format("y: %.3f (feet pos, %.3f eyes pos)", this.g.h.E.b, this.g.h.v), 2, 72, 0xE0E0E0);
            this.b(fontrenderer, String.format("z: %.5f (%d) // c: %d (%d)", this.g.h.w, l4, l4 >> 4, l4 & 0xF), 2, 80, 0xE0E0E0);
            int i5 = ls.c((double)(this.g.h.A * 4.0f / 360.0f) + 0.5) & 3;
            this.b(fontrenderer, "f: " + i5 + " (" + r.c[i5] + ") / " + ls.g(this.g.h.A), 2, 88, 0xE0E0E0);
            if (this.g.f != null && this.g.f.f(k3, j3, l4)) {
                adr chunk = this.g.f.d(k3, l4);
                this.b(fontrenderer, "lc: " + (chunk.h() + 15) + " b: " + chunk.a((int)(k3 & 0xF), (int)(l4 & 0xF), (acv)this.g.f.u()).y + " bl: " + chunk.a(ach.b, k3 & 0xF, j3, l4 & 0xF) + " sl: " + chunk.a(ach.a, k3 & 0xF, j3, l4 & 0xF) + " rl: " + chunk.c(k3 & 0xF, j3, l4 & 0xF, 0), 2, 96, 0xE0E0E0);
            }
            this.b(fontrenderer, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.g.h.bG.b()), Float.valueOf(this.g.h.bG.a()), this.g.h.F, this.g.f.f(k3, l4)), 2, 104, 0xE0E0E0);
            GL11.glPopMatrix();
            this.g.C.b();
        }
        if (this.o > 0) {
            this.g.C.a("overlayMessage");
            f3 = (float)this.o - par1;
            k1 = (int)(f3 * 255.0f / 20.0f);
            if (k1 > 255) {
                k1 = 255;
            }
            if (k1 > 8) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(k / 2), (float)(l - 68), (float)0.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                int i2 = 0xFFFFFF;
                if (this.p) {
                    i2 = Color.HSBtoRGB(f3 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                }
                fontrenderer.b(this.j, -fontrenderer.a(this.j) / 2, -4, i2 + (k1 << 24 & 0xFF000000));
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
            }
            this.g.C.b();
        }
        if ((scoreobjective = this.g.f.X().a(1)) != null) {
            this.a(scoreobjective, l, k, fontrenderer);
        }
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3008);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)(l - 48), (float)0.0f);
        this.g.C.a("chat");
        this.h.a(this.i);
        this.g.C.b();
        GL11.glPopMatrix();
        scoreobjective = this.g.f.X().a(0);
        if (this.g.u.T.e && (!this.g.A() || this.g.h.a.c.size() > 1 || scoreobjective != null)) {
            this.g.C.a("playerList");
            bcw netclienthandler = this.g.h.a;
            List list = netclienthandler.c;
            l2 = j2 = netclienthandler.d;
            k2 = 1;
            while (l2 > 20) {
                l2 = (j2 + ++k2 - 1) / k2;
            }
            int j5 = 300 / k2;
            if (j5 > 150) {
                j5 = 150;
            }
            int k5 = (k - k2 * j5) / 2;
            int b0 = 10;
            avj.a(k5 - 1, b0 - 1, k5 + j5 * k2, b0 + 9 * l2, Integer.MIN_VALUE);
            for (int i3 = 0; i3 < j2; ++i3) {
                int l5;
                int i6;
                k3 = k5 + i3 % k2 * j5;
                j3 = b0 + i3 / k2 * 9;
                avj.a(k3, j3, k3 + j5 - 1, j3 + 8, 0x20FFFFFF);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3008);
                if (i3 >= list.size()) continue;
                bdj guiplayerinfo = (bdj)list.get(i3);
                atf scoreplayerteam = this.g.f.X().i(guiplayerinfo.a);
                String s3 = atf.a((atl)scoreplayerteam, (String)guiplayerinfo.a);
                fontrenderer.a(s3, k3, j3, 0xFFFFFF);
                if (scoreobjective != null && (i6 = k3 + j5 - 12 - 5) - (l5 = k3 + fontrenderer.a(s3) + 5) > 5) {
                    atg score = scoreobjective.a().a(guiplayerinfo.a, scoreobjective);
                    String s4 = (Object)((Object)a.o) + "" + score.c();
                    fontrenderer.a(s4, i6 - fontrenderer.a(s4), j3, 0xFFFFFF);
                }
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.g.J().a(m);
                int b1 = 0;
                boolean flag3 = false;
                int b2 = guiplayerinfo.b < 0 ? 5 : (guiplayerinfo.b < 150 ? 0 : (guiplayerinfo.b < 300 ? 1 : (guiplayerinfo.b < 600 ? 2 : (guiplayerinfo.b < 1000 ? 3 : 4))));
                this.n += 100.0f;
                this.b(k3 + j5 - 12, j3, 0 + b1 * 10, 176 + b2 * 8, 10, 8);
                this.n -= 100.0f;
            }
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3008);
    }

    protected void a(ate par1ScoreObjective, int par2, int par3, avi par4FontRenderer) {
        atj scoreboard = par1ScoreObjective.a();
        Collection collection = scoreboard.i(par1ScoreObjective);
        if (collection.size() <= 15) {
            int k = par4FontRenderer.a(par1ScoreObjective.d());
            for (atg score : collection) {
                atf scoreplayerteam = scoreboard.i(score.e());
                String s2 = atf.a((atl)scoreplayerteam, (String)score.e()) + ": " + (Object)((Object)a.m) + score.c();
                k = Math.max(k, par4FontRenderer.a(s2));
            }
            int l = collection.size() * par4FontRenderer.a;
            int i1 = par2 / 2 + l / 3;
            int b0 = 3;
            int j1 = par3 - k - b0;
            int k1 = 0;
            for (atg score1 : collection) {
                atf scoreplayerteam1 = scoreboard.i(score1.e());
                String s1 = atf.a((atl)scoreplayerteam1, (String)score1.e());
                String s2 = (Object)((Object)a.m) + "" + score1.c();
                int l1 = i1 - ++k1 * par4FontRenderer.a;
                int i2 = par3 - b0 + 2;
                avj.a(j1 - 2, l1, i2, l1 + par4FontRenderer.a, 0x50000000);
                par4FontRenderer.b(s1, j1, l1, 0x20FFFFFF);
                par4FontRenderer.b(s2, i2 - par4FontRenderer.a(s2), l1, 0x20FFFFFF);
                if (k1 != collection.size()) continue;
                String s3 = par1ScoreObjective.d();
                avj.a(j1 - 2, l1 - par4FontRenderer.a - 1, i2, l1 - 1, 0x60000000);
                avj.a(j1 - 2, l1 - 1, i2, l1, 0x50000000);
                par4FontRenderer.b(s3, j1 + k / 2 - par4FontRenderer.a(s3) / 2, l1 - par4FontRenderer.a, 0x20FFFFFF);
            }
        }
    }

    protected void a(int par1, int par2) {
        int l4;
        int j4;
        int k4;
        int i4;
        int k3;
        int l3;
        boolean flag;
        boolean bl2 = flag = this.g.h.af / 3 % 2 == 1;
        if (this.g.h.af < 10) {
            flag = false;
        }
        int k = ls.f(this.g.h.aN());
        int l = ls.f(this.g.h.ax);
        this.f.setSeed(this.i * 312871);
        boolean flag1 = false;
        ux foodstats = this.g.h.bI();
        int i1 = foodstats.a();
        int j1 = foodstats.b();
        os attributeinstance = this.g.h.a(tp.a);
        int k1 = par1 / 2 - 91;
        int l1 = par1 / 2 + 91;
        int i2 = par2 - 39;
        float f = (float)attributeinstance.e();
        float f1 = this.g.h.bn();
        int j2 = ls.f((f + f1) / 2.0f / 10.0f);
        int k2 = Math.max(10 - (j2 - 2), 3);
        int l2 = i2 - (j2 - 1) * k2 - 10;
        float f2 = f1;
        int i3 = ForgeHooks.getTotalArmorValue((uf)this.g.h);
        int j3 = -1;
        if (this.g.h.a(ni.l)) {
            j3 = this.i % ls.f(f + 5.0f);
        }
        this.g.C.a("armor");
        for (l3 = 0; l3 < 10; ++l3) {
            if (i3 <= 0) continue;
            k3 = k1 + l3 * 8;
            if (l3 * 2 + 1 < i3) {
                this.b(k3, l2, 34, 9, 9, 9);
            }
            if (l3 * 2 + 1 == i3) {
                this.b(k3, l2, 25, 9, 9, 9);
            }
            if (l3 * 2 + 1 <= i3) continue;
            this.b(k3, l2, 16, 9, 9, 9);
        }
        this.g.C.c("health");
        for (l3 = ls.f((f + f1) / 2.0f) - 1; l3 >= 0; --l3) {
            k3 = 16;
            if (this.g.h.a(ni.u)) {
                k3 += 36;
            } else if (this.g.h.a(ni.v)) {
                k3 += 72;
            }
            int b0 = 0;
            if (flag) {
                b0 = 1;
            }
            i4 = ls.f((float)(l3 + 1) / 10.0f) - 1;
            k4 = k1 + l3 % 10 * 8;
            j4 = i2 - i4 * k2;
            if (k <= 4) {
                j4 += this.f.nextInt(2);
            }
            if (l3 == j3) {
                j4 -= 2;
            }
            int b1 = 0;
            if (this.g.f.N().t()) {
                b1 = 5;
            }
            this.b(k4, j4, 16 + b0 * 9, 9 * b1, 9, 9);
            if (flag) {
                if (l3 * 2 + 1 < l) {
                    this.b(k4, j4, k3 + 54, 9 * b1, 9, 9);
                }
                if (l3 * 2 + 1 == l) {
                    this.b(k4, j4, k3 + 63, 9 * b1, 9, 9);
                }
            }
            if (f2 > 0.0f) {
                if (f2 == f1 && f1 % 2.0f == 1.0f) {
                    this.b(k4, j4, k3 + 153, 9 * b1, 9, 9);
                } else {
                    this.b(k4, j4, k3 + 144, 9 * b1, 9, 9);
                }
                f2 -= 2.0f;
                continue;
            }
            if (l3 * 2 + 1 < k) {
                this.b(k4, j4, k3 + 36, 9 * b1, 9, 9);
            }
            if (l3 * 2 + 1 != k) continue;
            this.b(k4, j4, k3 + 45, 9 * b1, 9, 9);
        }
        nn entity = this.g.h.o;
        if (entity == null) {
            this.g.C.c("food");
            for (k3 = 0; k3 < 10; ++k3) {
                l4 = i2;
                i4 = 16;
                int b2 = 0;
                if (this.g.h.a(ni.s)) {
                    i4 += 36;
                    b2 = 13;
                }
                if (this.g.h.bI().e() <= 0.0f && this.i % (i1 * 3 + 1) == 0) {
                    l4 = i2 + (this.f.nextInt(3) - 1);
                }
                if (flag1) {
                    b2 = 1;
                }
                j4 = l1 - k3 * 8 - 9;
                this.b(j4, l4, 16 + b2 * 9, 27, 9, 9);
                if (flag1) {
                    if (k3 * 2 + 1 < j1) {
                        this.b(j4, l4, i4 + 54, 27, 9, 9);
                    }
                    if (k3 * 2 + 1 == j1) {
                        this.b(j4, l4, i4 + 63, 27, 9, 9);
                    }
                }
                if (k3 * 2 + 1 < i1) {
                    this.b(j4, l4, i4 + 36, 27, 9, 9);
                }
                if (k3 * 2 + 1 != i1) continue;
                this.b(j4, l4, i4 + 45, 27, 9, 9);
            }
        } else if (entity instanceof of) {
            this.g.C.c("mountHealth");
            of entitylivingbase = (of)entity;
            l4 = (int)Math.ceil(entitylivingbase.aN());
            float f3 = entitylivingbase.aT();
            k4 = (int)(f3 + 0.5f) / 2;
            if (k4 > 30) {
                k4 = 30;
            }
            j4 = i2;
            int i5 = 0;
            while (k4 > 0) {
                int j5 = Math.min(k4, 10);
                k4 -= j5;
                for (int k5 = 0; k5 < j5; ++k5) {
                    int b3 = 52;
                    int b4 = 0;
                    if (flag1) {
                        b4 = 1;
                    }
                    int l5 = l1 - k5 * 8 - 9;
                    this.b(l5, j4, b3 + b4 * 9, 9, 9, 9);
                    if (k5 * 2 + 1 + i5 < l4) {
                        this.b(l5, j4, b3 + 36, 9, 9, 9);
                    }
                    if (k5 * 2 + 1 + i5 != l4) continue;
                    this.b(l5, j4, b3 + 45, 9, 9, 9);
                }
                j4 -= 10;
                i5 += 20;
            }
        }
        this.g.C.c("air");
        if (this.g.h.a(akc.h)) {
            k3 = this.g.h.al();
            l4 = ls.f((double)(k3 - 2) * 10.0 / 300.0);
            i4 = ls.f((double)k3 * 10.0 / 300.0) - l4;
            for (k4 = 0; k4 < l4 + i4; ++k4) {
                if (k4 < l4) {
                    this.b(l1 - k4 * 8 - 9, l2, 16, 18, 9, 9);
                    continue;
                }
                this.b(l1 - k4 * 8 - 9, l2, 25, 18, 9, 9);
            }
        }
        this.g.C.b();
    }

    protected void d() {
        if (bez.c != null && bez.b > 0) {
            --bez.b;
            avi fontrenderer = this.g.l;
            awf scaledresolution = new awf(this.g.u, this.g.d, this.g.e);
            int i = scaledresolution.a();
            int short1 = 182;
            int j2 = i / 2 - short1 / 2;
            int k = (int)(bez.a * (float)(short1 + 1));
            int b0 = 12;
            this.b(j2, b0, 0, 74, short1, 5);
            this.b(j2, b0, 0, 74, short1, 5);
            if (k > 0) {
                this.b(j2, b0, 0, 79, k, 5);
            }
            String s2 = bez.c;
            fontrenderer.a(s2, i / 2 - fontrenderer.a(s2) / 2, b0 - 10, 0xFFFFFF);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.g.J().a(m);
        }
    }

    protected void b(int par1, int par2) {
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3008);
        this.g.J().a(d);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(0.0, par2, -90.0, 0.0, 1.0);
        tessellator.a(par1, par2, -90.0, 1.0, 1.0);
        tessellator.a(par1, 0.0, -90.0, 1.0, 0.0);
        tessellator.a(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    protected void a(float par1, int par2, int par3) {
        if ((par1 = 1.0f - par1) < 0.0f) {
            par1 = 0.0f;
        }
        if (par1 > 1.0f) {
            par1 = 1.0f;
        }
        this.a = (float)((double)this.a + (double)(par1 - this.a) * 0.01);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)0, (int)769);
        GL11.glColor4f((float)this.a, (float)this.a, (float)this.a, (float)1.0f);
        this.g.J().a(b);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(0.0, par3, -90.0, 0.0, 1.0);
        tessellator.a(par2, par3, -90.0, 1.0, 1.0);
        tessellator.a(par2, 0.0, -90.0, 1.0, 0.0);
        tessellator.a(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glBlendFunc((int)770, (int)771);
    }

    protected void b(float par1, int par2, int par3) {
        if (par1 < 1.0f) {
            par1 *= par1;
            par1 *= par1;
            par1 = par1 * 0.8f + 0.2f;
        }
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)par1);
        ms icon = aqz.bj.m(1);
        this.g.J().a(bik.b);
        float f1 = icon.c();
        float f2 = icon.e();
        float f3 = icon.d();
        float f4 = icon.f();
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(0.0, par3, -90.0, f1, f4);
        tessellator.a(par2, par3, -90.0, f3, f4);
        tessellator.a(par2, 0.0, -90.0, f3, f2);
        tessellator.a(0.0, 0.0, -90.0, f1, f2);
        tessellator.a();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    protected void a(int par1, int par2, int par3, float par4) {
        ye itemstack = this.g.h.bn.a[par1];
        if (itemstack != null) {
            float f1 = (float)itemstack.c - par4;
            if (f1 > 0.0f) {
                GL11.glPushMatrix();
                float f2 = 1.0f + f1 / 5.0f;
                GL11.glTranslatef((float)(par2 + 8), (float)(par3 + 12), (float)0.0f);
                GL11.glScalef((float)(1.0f / f2), (float)((f2 + 1.0f) / 2.0f), (float)1.0f);
                GL11.glTranslatef((float)(-(par2 + 8)), (float)(-(par3 + 12)), (float)0.0f);
            }
            e.b(this.g.l, this.g.J(), itemstack, par2, par3);
            if (f1 > 0.0f) {
                GL11.glPopMatrix();
            }
            e.c(this.g.l, this.g.J(), itemstack, par2, par3);
        }
    }

    public void a() {
        if (this.o > 0) {
            --this.o;
        }
        ++this.i;
        if (this.g.h != null) {
            ye itemstack = this.g.h.bn.h();
            if (itemstack == null) {
                this.q = 0;
            } else if (this.r != null && itemstack.d == this.r.d && ye.a(itemstack, this.r) && (itemstack.g() || itemstack.k() == this.r.k())) {
                if (this.q > 0) {
                    --this.q;
                }
            } else {
                this.q = 40;
            }
            this.r = itemstack;
        }
    }

    public void a(String par1Str) {
        this.a("Now playing: " + par1Str, true);
    }

    public void a(String par1Str, boolean par2) {
        this.j = par1Str;
        this.o = 60;
        this.p = par2;
    }

    public auu b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }
}

