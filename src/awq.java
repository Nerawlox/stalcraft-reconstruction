/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  awl
 *  bjo
 *  bkb
 *  blv
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ko
 *  kp
 *  ms
 *  net.minecraftforge.common.AchievementPage
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.LinkedList;
import java.util.Random;
import net.minecraftforge.common.AchievementPage;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class awq
extends awe {
    private static final int u = kp.a * 24 - 112;
    private static final int v = kp.b * 24 - 112;
    private static final int w = kp.c * 24 - 77;
    private static final int x = kp.d * 24 - 77;
    private static final bjo y = new bjo("textures/gui/achievement/achievement_background.png");
    protected int a = 256;
    protected int b = 202;
    protected int c;
    protected int d;
    protected double e;
    protected double p;
    protected double q;
    protected double r;
    protected double s;
    protected double t;
    private int z;
    private blv A;
    private int currentPage = -1;
    private awl button;
    private LinkedList<ko> minecraftAchievements = new LinkedList();

    public awq(blv par1StatFileWriter) {
        this.A = par1StatFileWriter;
        int short1 = 141;
        int short2 = 141;
        this.q = this.s = (double)(kp.f.a * 24 - short1 / 2 - 12);
        this.e = this.s;
        this.r = this.t = (double)(kp.f.b * 24 - short2 / 2);
        this.p = this.t;
        this.minecraftAchievements.clear();
        for (Object achievement : kp.e) {
            if (AchievementPage.isAchievementInPages((ko)((ko)achievement))) continue;
            this.minecraftAchievements.add((ko)achievement);
        }
    }

    @Override
    public void A_() {
        this.i.clear();
        this.i.add(new awl(1, this.g / 2 + 24, this.h / 2 + 74, 80, 20, bkb.a((String)"gui.done")));
        this.button = new awl(2, (this.g - this.a) / 2 + 24, this.h / 2 + 74, 125, 20, AchievementPage.getTitle((int)this.currentPage));
        this.i.add(this.button);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.g == 1) {
            this.f.a((awe)null);
            this.f.g();
        }
        if (par1GuiButton.g == 2) {
            ++this.currentPage;
            if (this.currentPage >= AchievementPage.getAchievementPages().size()) {
                this.currentPage = -1;
            }
            this.button.f = AchievementPage.getTitle((int)this.currentPage);
        }
        super.a(par1GuiButton);
    }

    @Override
    protected void a(char par1, int par2) {
        if (par2 == this.f.u.N.d) {
            this.f.a((awe)null);
            this.f.g();
        } else {
            super.a(par1, par2);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        if (Mouse.isButtonDown((int)0)) {
            int k = (this.g - this.a) / 2;
            int l = (this.h - this.b) / 2;
            int i1 = k + 8;
            int j1 = l + 17;
            if ((this.z == 0 || this.z == 1) && par1 >= i1 && par1 < i1 + 224 && par2 >= j1 && par2 < j1 + 155) {
                if (this.z == 0) {
                    this.z = 1;
                } else {
                    this.q -= (double)(par1 - this.c);
                    this.r -= (double)(par2 - this.d);
                    this.s = this.e = this.q;
                    this.t = this.p = this.r;
                }
                this.c = par1;
                this.d = par2;
            }
            if (this.s < (double)u) {
                this.s = u;
            }
            if (this.t < (double)v) {
                this.t = v;
            }
            if (this.s >= (double)w) {
                this.s = w - 1;
            }
            if (this.t >= (double)x) {
                this.t = x - 1;
            }
        } else {
            this.z = 0;
        }
        this.e();
        this.b(par1, par2, par3);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        this.g();
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
    }

    @Override
    public void c() {
        this.e = this.q;
        this.p = this.r;
        double d0 = this.s - this.q;
        double d1 = this.t - this.r;
        if (d0 * d0 + d1 * d1 < 4.0) {
            this.q += d0;
            this.r += d1;
        } else {
            this.q += d0 * 0.85;
            this.r += d1 * 0.85;
        }
    }

    protected void g() {
        int i = (this.g - this.a) / 2;
        int j2 = (this.h - this.b) / 2;
        this.o.b("Achievements", i + 15, j2 + 5, 0x404040);
    }

    protected void b(int par1, int par2, float par3) {
        int l4;
        int i5;
        int j4;
        int j3;
        int k3;
        int k = ls.c(this.e + (this.q - this.e) * (double)par3);
        int l = ls.c(this.p + (this.r - this.p) * (double)par3);
        if (k < u) {
            k = u;
        }
        if (l < v) {
            l = v;
        }
        if (k >= w) {
            k = w - 1;
        }
        if (l >= x) {
            l = x - 1;
        }
        int i1 = (this.g - this.a) / 2;
        int j1 = (this.h - this.b) / 2;
        int k1 = i1 + 16;
        int l1 = j1 + 17;
        this.n = 0.0f;
        GL11.glDepthFunc((int)518);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-200.0f);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)32826);
        GL11.glEnable((int)2903);
        int i2 = k + 288 >> 4;
        int j2 = l + 288 >> 4;
        int k2 = (k + 288) % 16;
        int l2 = (l + 288) % 16;
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        Random random = new Random();
        int i3 = 0;
        while (i3 * 16 - l2 < 155) {
            float f1 = 0.6f - (float)(j2 + i3) / 25.0f * 0.3f;
            GL11.glColor4f((float)f1, (float)f1, (float)f1, (float)1.0f);
            k3 = 0;
            while (k3 * 16 - k2 < 224) {
                random.setSeed(1234 + i2 + k3);
                random.nextInt();
                j3 = random.nextInt(1 + j2 + i3) + (j2 + i3) / 2;
                ms icon = aqz.J.a(0, 0);
                if (j3 <= 37 && j2 + i3 != 35) {
                    if (j3 == 22) {
                        icon = random.nextInt(2) == 0 ? aqz.aB.a(0, 0) : aqz.aS.a(0, 0);
                    } else if (j3 == 10) {
                        icon = aqz.M.a(0, 0);
                    } else if (j3 == 8) {
                        icon = aqz.N.a(0, 0);
                    } else if (j3 > 4) {
                        icon = aqz.y.a(0, 0);
                    } else if (j3 > 0) {
                        icon = aqz.A.a(0, 0);
                    }
                } else {
                    icon = aqz.E.a(0, 0);
                }
                this.f.J().a(bik.b);
                this.a(k1 + k3 * 16 - k2, l1 + i3 * 16 - l2, icon, 16, 16);
                ++k3;
            }
            ++i3;
        }
        GL11.glEnable((int)2929);
        GL11.glDepthFunc((int)515);
        GL11.glDisable((int)3553);
        LinkedList<ko> achievementList = this.currentPage == -1 ? this.minecraftAchievements : AchievementPage.getAchievementPage((int)this.currentPage).getAchievements();
        for (i3 = 0; i3 < achievementList.size(); ++i3) {
            ko achievement = (ko)achievementList.get(i3);
            if (achievement.c == null || !achievementList.contains(achievement.c)) continue;
            k3 = achievement.a * 24 - k + 11 + k1;
            j3 = achievement.b * 24 - l + 11 + l1;
            j4 = achievement.c.a * 24 - k + 11 + k1;
            int l3 = achievement.c.b * 24 - l + 11 + l1;
            boolean flag5 = this.A.a(achievement);
            boolean flag6 = this.A.b(achievement);
            int i4 = Math.sin((double)(atv.F() % 600L) / 600.0 * Math.PI * 2.0) > 0.6 ? 255 : 130;
            int k4 = -16777216;
            if (flag5) {
                k4 = -9408400;
            } else if (flag6) {
                k4 = 65280 + (i4 << 24);
            }
            this.a(k3, j4, j3, k4);
            this.b(j4, j3, l3, k4);
        }
        ko achievement1 = null;
        bgw renderitem = new bgw();
        att.c();
        GL11.glDisable((int)2896);
        GL11.glEnable((int)32826);
        GL11.glEnable((int)2903);
        for (k3 = 0; k3 < achievementList.size(); ++k3) {
            float f2;
            ko achievement2 = (ko)achievementList.get(k3);
            j4 = achievement2.a * 24 - k;
            int l3 = achievement2.b * 24 - l;
            if (j4 < -24 || l3 < -24 || j4 > 224 || l3 > 155) continue;
            if (this.A.a(achievement2)) {
                f2 = 1.0f;
                GL11.glColor4f((float)f2, (float)f2, (float)f2, (float)1.0f);
            } else if (this.A.b(achievement2)) {
                f2 = Math.sin((double)(atv.F() % 600L) / 600.0 * Math.PI * 2.0) < 0.6 ? 0.6f : 0.8f;
                GL11.glColor4f((float)f2, (float)f2, (float)f2, (float)1.0f);
            } else {
                f2 = 0.3f;
                GL11.glColor4f((float)f2, (float)f2, (float)f2, (float)1.0f);
            }
            this.f.J().a(y);
            i5 = k1 + j4;
            l4 = l1 + l3;
            if (achievement2.f()) {
                this.b(i5 - 2, l4 - 2, 26, 202, 26, 26);
            } else {
                this.b(i5 - 2, l4 - 2, 0, 202, 26, 26);
            }
            if (!this.A.b(achievement2)) {
                float f3 = 0.1f;
                GL11.glColor4f((float)f3, (float)f3, (float)f3, (float)1.0f);
                renderitem.a = false;
            }
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2884);
            renderitem.b(this.f.l, this.f.J(), achievement2.d, i5 + 3, l4 + 3);
            GL11.glDisable((int)2896);
            if (!this.A.b(achievement2)) {
                renderitem.a = true;
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if (par1 < k1 || par2 < l1 || par1 >= k1 + 224 || par2 >= l1 + 155 || par1 < i5 || par1 > i5 + 22 || par2 < l4 || par2 > l4 + 22) continue;
            achievement1 = achievement2;
        }
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(y);
        this.b(i1, j1, 0, 0, this.a, this.b);
        GL11.glPopMatrix();
        this.n = 0.0f;
        GL11.glDepthFunc((int)515);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3553);
        super.a(par1, par2, par3);
        if (achievement1 != null) {
            String s2 = bkb.a((String)achievement1.i());
            String s1 = achievement1.e();
            j4 = par1 + 12;
            int l3 = par2 - 4;
            if (this.A.b(achievement1)) {
                i5 = Math.max(this.o.a(s2), 120);
                l4 = this.o.b(s1, i5);
                if (this.A.a(achievement1)) {
                    l4 += 12;
                }
                this.a(j4 - 3, l3 - 3, j4 + i5 + 3, l3 + l4 + 3 + 12, -1073741824, -1073741824);
                this.o.a(s1, j4, l3 + 12, i5, -6250336);
                if (this.A.a(achievement1)) {
                    this.o.a(bkb.a((String)"achievement.taken"), j4, l3 + l4 + 4, -7302913);
                }
            } else {
                i5 = Math.max(this.o.a(s2), 120);
                String s22 = bkb.a((String)"achievement.requires", (Object[])new Object[]{bkb.a((String)achievement1.c.i())});
                int i4 = this.o.b(s22, i5);
                this.a(j4 - 3, l3 - 3, j4 + i5 + 3, l3 + i4 + 12 + 3, -1073741824, -1073741824);
                this.o.a(s22, j4, l3 + 12, i5, -9416624);
            }
            this.o.a(s2, j4, l3, this.A.b(achievement1) ? (achievement1.f() ? -128 : -1) : (achievement1.f() ? -8355776 : -8355712));
        }
        GL11.glEnable((int)2929);
        GL11.glEnable((int)2896);
        att.a();
    }

    @Override
    public boolean f() {
        return true;
    }
}

