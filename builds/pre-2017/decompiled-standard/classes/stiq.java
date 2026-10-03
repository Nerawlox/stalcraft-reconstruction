/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.kjui;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.sajz;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.eifc;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraft.util.tdmn;
import net.minecraft.util.ugqx;
import net.minecraftforge.common.ForgeHooks;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class stiq
extends bawa {
    public static final ResourceLocation field_110329_b = new ResourceLocation("textures/misc/vignette.png");
    public static final ResourceLocation field_110330_c = new ResourceLocation("textures/gui/widgets.png");
    public static final ResourceLocation field_110328_d = new ResourceLocation("textures/misc/pumpkinblur.png");
    public static final xsbj field_73841_b = new xsbj();
    public final Random field_73842_c = new Random();
    public final xpzm field_73839_d;
    public final wowp field_73840_e;
    public int field_73837_f;
    public String field_73838_g = "";
    public int field_73845_h;
    public boolean field_73844_j;
    public float field_73843_a = 1.0f;
    public int field_92017_k;
    public cvzo field_92016_l;

    public stiq(xpzm xpzm2) {
        this.field_73839_d = xpzm2;
        this.field_73840_e = new wowp(xpzm2);
    }

    public void func_73830_a(float f, boolean bl, int n, int n2) {
        igri igri2;
        Object object;
        int n3;
        int n4;
        int n5;
        String string;
        int n6;
        int n7;
        int n8;
        Object object2;
        int n9;
        int n10;
        float f2;
        int n11;
        int n12;
        float f3;
        htou htou2 = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        int n13 = htou2._a();
        int n14 = htou2._b();
        qncw qncw2 = this.field_73839_d._z;
        this.field_73839_d._D.func_78478_c();
        GL11.glEnable(3042);
        if (xpzm._B()) {
            this.func_73829_a(this.field_73839_d._t.func_70013_c(f), n13, n14);
        } else {
            GL11.glBlendFunc(770, 771);
        }
        cvzo cvzo2 = this.field_73839_d._t.field_71071_by._e(3);
        if (this.field_73839_d._M.field_74320_O == 0 && cvzo2 != null && cvzo2._a() != null) {
            if (cvzo2._d == twgu.field_72061_ba.field_71990_ca) {
                this.func_73836_a(n13, n14);
            } else {
                cvzo2._a().renderHelmetOverlay(cvzo2, this.field_73839_d._t, htou2, f, bl, n, n2);
            }
        }
        if (!this.field_73839_d._t.func_70644_a(hdpq._k) && (f3 = this.field_73839_d._t.field_71080_cy + (this.field_73839_d._t.field_71086_bY - this.field_73839_d._t.field_71080_cy) * f) > 0.0f) {
            this.func_130015_b(f3, n13, n14);
        }
        if (!this.field_73839_d._j._a()) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73839_d._R()._a(field_110330_c);
            eidj eidj2 = this.field_73839_d._t.field_71071_by;
            this.field_73735_i = -90.0f;
            this.func_73729_b(n13 / 2 - 91, n14 - 22, 0, 0, 182, 22);
            this.func_73729_b(n13 / 2 - 91 - 1 + eidj2._c * 20, n14 - 22 - 1, 0, 22, 24, 22);
            this.field_73839_d._R()._a(field_110324_m);
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            this.func_73729_b(n13 / 2 - 7, n14 / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            this.field_73839_d.__ah._a("bossHealth");
            this.func_73828_d();
            this.field_73839_d.__ah._b();
            if (this.field_73839_d._j._b()) {
                this.func_110327_a(n13, n14);
            }
            GL11.glDisable(3042);
            this.field_73839_d.__ah._a("actionBar");
            GL11.glEnable(32826);
            qnon._c();
            for (int i = 0; i < 9; ++i) {
                n12 = n13 / 2 - 90 + i * 20 + 2;
                n11 = n14 - 16 - 3;
                this.func_73832_a(i, n12, n11, f);
            }
            qnon._a();
            GL11.glDisable(32826);
            this.field_73839_d.__ah._b();
        }
        if (this.field_73839_d._t.func_71060_bI() > 0) {
            this.field_73839_d.__ah._a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int n15 = this.field_73839_d._t.func_71060_bI();
            float f4 = (float)n15 / 100.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f - (float)(n15 - 100) / 10.0f;
            }
            n12 = (int)(220.0f * f4) << 24 | 0x101020;
            stiq.func_73734_a(0, 0, n13, n14, n12);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            this.field_73839_d.__ah._b();
        }
        int n16 = 0xFFFFFF;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n17 = n13 / 2 - 91;
        if (this.field_73839_d._t.func_110317_t()) {
            this.field_73839_d.__ah._a("jumpBar");
            this.field_73839_d._R()._a(bawa.field_110324_m);
            f2 = this.field_73839_d._t.func_110319_bJ();
            n10 = 182;
            int n18 = (int)(f2 * (float)(n10 + 1));
            n9 = n14 - 32 + 3;
            this.func_73729_b(n17, n9, 0, 84, n10, 5);
            if (n18 > 0) {
                this.func_73729_b(n17, n9, 0, 89, n18, 5);
            }
            this.field_73839_d.__ah._b();
        } else if (this.field_73839_d._j._g()) {
            this.field_73839_d.__ah._a("expBar");
            this.field_73839_d._R()._a(bawa.field_110324_m);
            n12 = this.field_73839_d._t.func_71050_bK();
            if (n12 > 0) {
                n10 = 182;
                int n19 = (int)(this.field_73839_d._t.field_71106_cc * (float)(n10 + 1));
                n9 = n14 - 32 + 3;
                this.func_73729_b(n17, n9, 0, 64, n10, 5);
                if (n19 > 0) {
                    this.func_73729_b(n17, n9, 0, 69, n19, 5);
                }
            }
            this.field_73839_d.__ah._b();
            if (this.field_73839_d._t.field_71068_ca > 0) {
                this.field_73839_d.__ah._a("expLevel");
                boolean bl2 = false;
                int n20 = bl2 ? 0xFFFFFF : 8453920;
                object2 = "" + this.field_73839_d._t.field_71068_ca;
                n8 = (n13 - qncw2._b((String)object2)) / 2;
                n7 = n14 - 31 - 4;
                n6 = 0;
                qncw2._b((String)object2, n8 + 1, n7, 0);
                qncw2._b((String)object2, n8 - 1, n7, 0);
                qncw2._b((String)object2, n8, n7 + 1, 0);
                qncw2._b((String)object2, n8, n7 - 1, 0);
                qncw2._b((String)object2, n8, n7, n20);
                this.field_73839_d.__ah._b();
            }
        }
        if (this.field_73839_d._M.field_92117_D) {
            this.field_73839_d.__ah._a("toolHighlight");
            if (this.field_92017_k > 0 && this.field_92016_l != null) {
                String string2 = this.field_92016_l._s();
                n11 = (n13 - qncw2._b(string2)) / 2;
                int n21 = n14 - 59;
                if (!this.field_73839_d._j._b()) {
                    n21 += 14;
                }
                if ((n9 = (int)((float)this.field_92017_k * 256.0f / 10.0f)) > 255) {
                    n9 = 255;
                }
                if (n9 > 0) {
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    qncw2._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    object2 = this.field_92016_l._a().getFontRenderer(this.field_92016_l);
                    if (object2 != null) {
                        n11 = (n13 - ((qncw)object2)._b(string2)) / 2;
                        ((qncw)object2)._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    } else {
                        qncw2._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    }
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            this.field_73839_d.__ah._b();
        }
        if (this.field_73839_d._y()) {
            this.field_73839_d.__ah._a("demo");
            String string3 = "";
            string3 = this.field_73839_d._r.func_82737_E() >= 120500L ? wpcz._a("demo.demoExpired") : wpcz._a("demo.remainingTime", eifc._a((int)(120500L - this.field_73839_d._r.func_82737_E())));
            n11 = qncw2._b(string3);
            qncw2._a(string3, n13 - n11 - 10, 5, 0xFFFFFF);
            this.field_73839_d.__ah._b();
        }
        if (this.field_73839_d._M.field_74330_P) {
            this.field_73839_d.__ah._a("debug");
            GL11.glPushMatrix();
            qncw2._a("Minecraft 1.6.4 (" + this.field_73839_d.__aq + ")", 2, 2, 0xFFFFFF);
            qncw2._a(this.field_73839_d._u(), 2, 12, 0xFFFFFF);
            qncw2._a(this.field_73839_d._v(), 2, 22, 0xFFFFFF);
            qncw2._a(this.field_73839_d._x(), 2, 32, 0xFFFFFF);
            qncw2._a(this.field_73839_d._w(), 2, 42, 0xFFFFFF);
            long l = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l3 = Runtime.getRuntime().freeMemory();
            long l4 = l2 - l3;
            string = "Used memory: " + l4 * 100L / l + "% (" + l4 / 1024L / 1024L + "MB) of " + l / 1024L / 1024L + "MB";
            int n22 = 0xE0E0E0;
            this.func_73731_b(qncw2, string, n13 - qncw2._b(string) - 2, 2, 0xE0E0E0);
            string = "Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)";
            this.func_73731_b(qncw2, string, n13 - qncw2._b(string) - 2, 12, 0xE0E0E0);
            n6 = sajh._c(this.field_73839_d._t.field_70165_t);
            n5 = sajh._c(this.field_73839_d._t.field_70163_u);
            n4 = sajh._c(this.field_73839_d._t.field_70161_v);
            this.func_73731_b(qncw2, String.format("x: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70165_t, n6, n6 >> 4, n6 & 0xF), 2, 64, 0xE0E0E0);
            this.func_73731_b(qncw2, String.format("y: %.3f (feet pos, %.3f eyes pos)", this.field_73839_d._t.field_70121_D._c, this.field_73839_d._t.field_70163_u), 2, 72, 0xE0E0E0);
            this.func_73731_b(qncw2, String.format("z: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70161_v, n4, n4 >> 4, n4 & 0xF), 2, 80, 0xE0E0E0);
            n3 = sajh._c((double)(this.field_73839_d._t.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
            this.func_73731_b(qncw2, "f: " + n3 + " (" + ugqx._c[n3] + ") / " + sajh._g(this.field_73839_d._t.field_70177_z), 2, 88, 0xE0E0E0);
            if (this.field_73839_d._r != null && this.field_73839_d._r.func_72899_e(n6, n5, n4)) {
                object = this.field_73839_d._r.func_72938_d(n6, n4);
                this.func_73731_b(qncw2, "lc: " + (((ixzi)object)._a() + 15) + " b: " + ((ixzi)object)._a((int)(n6 & 0xF), (int)(n4 & 0xF), (foqg)this.field_73839_d._r.func_72959_q())._y + " bl: " + ((ixzi)object)._a(rrqi._b, n6 & 0xF, n5, n4 & 0xF) + " sl: " + ((ixzi)object)._a(rrqi._a, n6 & 0xF, n5, n4 & 0xF) + " rl: " + ((ixzi)object)._c(n6 & 0xF, n5, n4 & 0xF, 0), 2, 96, 0xE0E0E0);
            }
            this.func_73731_b(qncw2, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.field_73839_d._t.field_71075_bZ._b()), Float.valueOf(this.field_73839_d._t.field_71075_bZ._a()), this.field_73839_d._t.field_70122_E, this.field_73839_d._r.func_72976_f(n6, n4)), 2, 104, 0xE0E0E0);
            GL11.glPopMatrix();
            this.field_73839_d.__ah._b();
        }
        if (this.field_73845_h > 0) {
            this.field_73839_d.__ah._a("overlayMessage");
            f2 = (float)this.field_73845_h - f;
            n11 = (int)(f2 * 255.0f / 20.0f);
            if (n11 > 255) {
                n11 = 255;
            }
            if (n11 > 8) {
                GL11.glPushMatrix();
                GL11.glTranslatef(n13 / 2, n14 - 68, 0.0f);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int n23 = 0xFFFFFF;
                if (this.field_73844_j) {
                    n23 = Color.HSBtoRGB(f2 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                }
                qncw2._b(this.field_73838_g, -qncw2._b(this.field_73838_g) / 2, -4, n23 + (n11 << 24 & 0xFF000000));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            this.field_73839_d.__ah._b();
        }
        if ((igri2 = this.field_73839_d._r.func_96441_U()._a(1)) != null) {
            this.func_96136_a(igri2, n14, n13, qncw2);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, n14 - 48, 0.0f);
        this.field_73839_d.__ah._a("chat");
        this.field_73840_e._a(this.field_73837_f);
        this.field_73839_d.__ah._b();
        GL11.glPopMatrix();
        igri2 = this.field_73839_d._r.func_96441_U()._a(0);
        if (this.field_73839_d._M.field_74321_H._e && (!this.field_73839_d._H() || this.field_73839_d._t.field_71174_a._i.size() > 1 || igri2 != null)) {
            this.field_73839_d.__ah._a("playerList");
            bscn bscn2 = this.field_73839_d._t.field_71174_a;
            List list2 = bscn2._i;
            n8 = n9 = bscn2._j;
            n7 = 1;
            while (n8 > 20) {
                n8 = (n9 + ++n7 - 1) / n7;
            }
            int n24 = 300 / n7;
            if (n24 > 150) {
                n24 = 150;
            }
            int n25 = (n13 - n7 * n24) / 2;
            int n26 = 10;
            stiq.func_73734_a(n25 - 1, n26 - 1, n25 + n24 * n7, n26 + 9 * n8, Integer.MIN_VALUE);
            for (int i = 0; i < n9; ++i) {
                n6 = n25 + i % n7 * n24;
                n5 = n26 + i / n7 * 9;
                stiq.func_73734_a(n6, n5, n6 + n24 - 1, n5 + 8, 0x20FFFFFF);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3008);
                if (i >= list2.size()) continue;
                maza maza2 = (maza)list2.get(i);
                dzew dzew2 = this.field_73839_d._r.func_96441_U()._g(maza2._a);
                string = dzew._a(dzew2, maza2._a);
                qncw2._a(string, n6, n5, 0xFFFFFF);
                if (igri2 != null && (n3 = n6 + n24 - 12 - 5) - (n4 = n6 + qncw2._b(string) + 5) > 5) {
                    object = igri2._a()._a(maza2._a, igri2);
                    String string4 = (Object)((Object)ezfc._o) + "" + ((cwdc)object)._b();
                    qncw2._a(string4, n3 - qncw2._b(string4), n5, 0xFFFFFF);
                }
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_73839_d._R()._a(field_110324_m);
                n4 = 0;
                n3 = 0;
                int n27 = maza2._c < 0 ? 5 : (maza2._c < 150 ? 0 : (maza2._c < 300 ? 1 : (maza2._c < 600 ? 2 : (maza2._c < 1000 ? 3 : 4))));
                this.field_73735_i += 100.0f;
                this.func_73729_b(n6 + n24 - 12, n5, 0 + n4 * 10, 176 + n27 * 8, 10, 8);
                this.field_73735_i -= 100.0f;
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    public void func_96136_a(igri igri2, int n, int n2, qncw qncw2) {
        fojy fojy2 = igri2._a();
        Collection collection = fojy2._a(igri2);
        if (collection.size() <= 15) {
            int n3 = qncw2._b(igri2._d());
            for (cwdc cwdc2 : collection) {
                dzew dzew2 = fojy2._g(cwdc2._d());
                String string = dzew._a(dzew2, cwdc2._d()) + ": " + (Object)((Object)ezfc._m) + cwdc2._b();
                n3 = Math.max(n3, qncw2._b(string));
            }
            int n4 = collection.size() * qncw2._c;
            int n5 = n / 2 + n4 / 3;
            int n6 = 3;
            int n7 = n2 - n3 - n6;
            int n8 = 0;
            for (cwdc cwdc3 : collection) {
                dzew dzew3 = fojy2._g(cwdc3._d());
                String string = dzew._a(dzew3, cwdc3._d());
                String string2 = (Object)((Object)ezfc._m) + "" + cwdc3._b();
                int n9 = n5 - ++n8 * qncw2._c;
                int n10 = n2 - n6 + 2;
                stiq.func_73734_a(n7 - 2, n9, n10, n9 + qncw2._c, 0x50000000);
                qncw2._b(string, n7, n9, 0x20FFFFFF);
                qncw2._b(string2, n10 - qncw2._b(string2), n9, 0x20FFFFFF);
                if (n8 != collection.size()) continue;
                String string3 = igri2._d();
                stiq.func_73734_a(n7 - 2, n9 - qncw2._c - 1, n10, n9 - 1, 0x60000000);
                stiq.func_73734_a(n7 - 2, n9 - 1, n10, n9, 0x50000000);
                qncw2._b(string3, n7 + n3 / 2 - qncw2._b(string3) / 2, n9 - qncw2._c, 0x20FFFFFF);
            }
        }
    }

    public void func_110327_a(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        boolean bl;
        boolean bl2 = bl = this.field_73839_d._t.field_70172_ad / 3 % 2 == 1;
        if (this.field_73839_d._t.field_70172_ad < 10) {
            bl = false;
        }
        int n9 = sajh._f(this.field_73839_d._t.func_110143_aJ());
        int n10 = sajh._f(this.field_73839_d._t.field_70735_aL);
        this.field_73842_c.setSeed(this.field_73837_f * 312871);
        boolean bl3 = false;
        tdmn tdmn2 = this.field_73839_d._t.func_71024_bL();
        int n11 = tdmn2._a();
        int n12 = tdmn2._b();
        hubf hubf2 = this.field_73839_d._t.func_110148_a(sajz._a);
        int n13 = n / 2 - 91;
        int n14 = n / 2 + 91;
        int n15 = n2 - 39;
        float f = (float)hubf2._e();
        float f2 = this.field_73839_d._t.func_110139_bj();
        int n16 = sajh._f((f + f2) / 2.0f / 10.0f);
        int n17 = Math.max(10 - (n16 - 2), 3);
        int n18 = n15 - (n16 - 1) * n17 - 10;
        float f3 = f2;
        int n19 = ForgeHooks.getTotalArmorValue(this.field_73839_d._t);
        int n20 = -1;
        if (this.field_73839_d._t.func_70644_a(hdpq._l)) {
            n20 = this.field_73837_f % sajh._f(f + 5.0f);
        }
        this.field_73839_d.__ah._a("armor");
        for (n8 = 0; n8 < 10; ++n8) {
            if (n19 <= 0) continue;
            n7 = n13 + n8 * 8;
            if (n8 * 2 + 1 < n19) {
                this.func_73729_b(n7, n18, 34, 9, 9, 9);
            }
            if (n8 * 2 + 1 == n19) {
                this.func_73729_b(n7, n18, 25, 9, 9, 9);
            }
            if (n8 * 2 + 1 <= n19) continue;
            this.func_73729_b(n7, n18, 16, 9, 9, 9);
        }
        this.field_73839_d.__ah._c("health");
        for (n8 = sajh._f((f + f2) / 2.0f) - 1; n8 >= 0; --n8) {
            n7 = 16;
            if (this.field_73839_d._t.func_70644_a(hdpq._u)) {
                n7 += 36;
            } else if (this.field_73839_d._t.func_70644_a(hdpq._v)) {
                n7 += 72;
            }
            int n21 = 0;
            if (bl) {
                n21 = 1;
            }
            n6 = sajh._f((float)(n8 + 1) / 10.0f) - 1;
            n5 = n13 + n8 % 10 * 8;
            n4 = n15 - n6 * n17;
            if (n9 <= 4) {
                n4 += this.field_73842_c.nextInt(2);
            }
            if (n8 == n20) {
                n4 -= 2;
            }
            n3 = 0;
            if (this.field_73839_d._r.func_72912_H()._t()) {
                n3 = 5;
            }
            this.func_73729_b(n5, n4, 16 + n21 * 9, 9 * n3, 9, 9);
            if (bl) {
                if (n8 * 2 + 1 < n10) {
                    this.func_73729_b(n5, n4, n7 + 54, 9 * n3, 9, 9);
                }
                if (n8 * 2 + 1 == n10) {
                    this.func_73729_b(n5, n4, n7 + 63, 9 * n3, 9, 9);
                }
            }
            if (f3 > 0.0f) {
                if (f3 == f2 && f2 % 2.0f == 1.0f) {
                    this.func_73729_b(n5, n4, n7 + 153, 9 * n3, 9, 9);
                } else {
                    this.func_73729_b(n5, n4, n7 + 144, 9 * n3, 9, 9);
                }
                f3 -= 2.0f;
                continue;
            }
            if (n8 * 2 + 1 < n9) {
                this.func_73729_b(n5, n4, n7 + 36, 9 * n3, 9, 9);
            }
            if (n8 * 2 + 1 != n9) continue;
            this.func_73729_b(n5, n4, n7 + 45, 9 * n3, 9, 9);
        }
        Entity entity = this.field_73839_d._t.field_70154_o;
        if (entity == null) {
            this.field_73839_d.__ah._c("food");
            for (n7 = 0; n7 < 10; ++n7) {
                n3 = n15;
                n6 = 16;
                int n22 = 0;
                if (this.field_73839_d._t.func_70644_a(hdpq._s)) {
                    n6 += 36;
                    n22 = 13;
                }
                if (this.field_73839_d._t.func_71024_bL()._d() <= 0.0f && this.field_73837_f % (n11 * 3 + 1) == 0) {
                    n3 = n15 + (this.field_73842_c.nextInt(3) - 1);
                }
                if (bl3) {
                    n22 = 1;
                }
                n4 = n14 - n7 * 8 - 9;
                this.func_73729_b(n4, n3, 16 + n22 * 9, 27, 9, 9);
                if (bl3) {
                    if (n7 * 2 + 1 < n12) {
                        this.func_73729_b(n4, n3, n6 + 54, 27, 9, 9);
                    }
                    if (n7 * 2 + 1 == n12) {
                        this.func_73729_b(n4, n3, n6 + 63, 27, 9, 9);
                    }
                }
                if (n7 * 2 + 1 < n11) {
                    this.func_73729_b(n4, n3, n6 + 36, 27, 9, 9);
                }
                if (n7 * 2 + 1 != n11) continue;
                this.func_73729_b(n4, n3, n6 + 45, 27, 9, 9);
            }
        } else if (entity instanceof EntityLivingBase) {
            this.field_73839_d.__ah._c("mountHealth");
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            n3 = (int)Math.ceil(entityLivingBase.func_110143_aJ());
            float f4 = entityLivingBase.func_110138_aP();
            n5 = (int)(f4 + 0.5f) / 2;
            if (n5 > 30) {
                n5 = 30;
            }
            n4 = n15;
            int n23 = 0;
            while (n5 > 0) {
                int n24 = Math.min(n5, 10);
                n5 -= n24;
                for (int i = 0; i < n24; ++i) {
                    int n25 = 52;
                    int n26 = 0;
                    if (bl3) {
                        n26 = 1;
                    }
                    int n27 = n14 - i * 8 - 9;
                    this.func_73729_b(n27, n4, n25 + n26 * 9, 9, 9, 9);
                    if (i * 2 + 1 + n23 < n3) {
                        this.func_73729_b(n27, n4, n25 + 36, 9, 9, 9);
                    }
                    if (i * 2 + 1 + n23 != n3) continue;
                    this.func_73729_b(n27, n4, n25 + 45, 9, 9, 9);
                }
                n4 -= 10;
                n23 += 20;
            }
        }
        this.field_73839_d.__ah._c("air");
        if (this.field_73839_d._t.func_70055_a(tflj._h)) {
            n7 = this.field_73839_d._t.func_70086_ai();
            n3 = sajh._e((double)(n7 - 2) * 10.0 / 300.0);
            n6 = sajh._e((double)n7 * 10.0 / 300.0) - n3;
            for (n5 = 0; n5 < n3 + n6; ++n5) {
                if (n5 < n3) {
                    this.func_73729_b(n14 - n5 * 8 - 9, n18, 16, 18, 9, 9);
                    continue;
                }
                this.func_73729_b(n14 - n5 * 8 - 9, n18, 25, 18, 9, 9);
            }
        }
        this.field_73839_d.__ah._b();
    }

    public void func_73828_d() {
        if (kjui._c != null && kjui._b > 0) {
            --kjui._b;
            qncw qncw2 = this.field_73839_d._z;
            htou htou2 = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
            int n = htou2._a();
            int n2 = 182;
            int n3 = n / 2 - n2 / 2;
            int n4 = (int)(kjui._a * (float)(n2 + 1));
            int n5 = 12;
            this.func_73729_b(n3, n5, 0, 74, n2, 5);
            this.func_73729_b(n3, n5, 0, 74, n2, 5);
            if (n4 > 0) {
                this.func_73729_b(n3, n5, 0, 79, n4, 5);
            }
            String string = kjui._c;
            qncw2._a(string, n / 2 - qncw2._b(string) / 2, n5 - 10, 0xFFFFFF);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73839_d._R()._a(field_110324_m);
        }
    }

    public void func_73836_a(int n, int n2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        this.field_73839_d._R()._a(field_110328_d);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(0.0, n2, -90.0, 0.0, 1.0);
        htvf2.func_78374_a(n, n2, -90.0, 1.0, 1.0);
        htvf2.func_78374_a(n, 0.0, -90.0, 1.0, 0.0);
        htvf2.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void func_73829_a(float f, int n, int n2) {
        if ((f = 1.0f - f) < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.field_73843_a = (float)((double)this.field_73843_a + (double)(f - this.field_73843_a) * 0.01);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(this.field_73843_a, this.field_73843_a, this.field_73843_a, 1.0f);
        this.field_73839_d._R()._a(field_110329_b);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(0.0, n2, -90.0, 0.0, 1.0);
        htvf2.func_78374_a(n, n2, -90.0, 1.0, 1.0);
        htvf2.func_78374_a(n, 0.0, -90.0, 1.0, 0.0);
        htvf2.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBlendFunc(770, 771);
    }

    public void func_130015_b(float f, int n, int n2) {
        if (f < 1.0f) {
            f *= f;
            f *= f;
            f = f * 0.8f + 0.2f;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        dwan dwan2 = twgu.field_72015_be.func_71851_a(1);
        this.field_73839_d._R()._a(sctd._c);
        float f2 = dwan2.func_94209_e();
        float f3 = dwan2.func_94206_g();
        float f4 = dwan2.func_94212_f();
        float f5 = dwan2.func_94210_h();
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(0.0, n2, -90.0, f2, f5);
        htvf2.func_78374_a(n, n2, -90.0, f4, f5);
        htvf2.func_78374_a(n, 0.0, -90.0, f4, f3);
        htvf2.func_78374_a(0.0, 0.0, -90.0, f2, f3);
        htvf2.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void func_73832_a(int n, int n2, int n3, float f) {
        cvzo cvzo2 = this.field_73839_d._t.field_71071_by._a[n];
        if (cvzo2 != null) {
            float f2 = (float)cvzo2._c - f;
            if (f2 > 0.0f) {
                GL11.glPushMatrix();
                float f3 = 1.0f + f2 / 5.0f;
                GL11.glTranslatef(n2 + 8, n3 + 12, 0.0f);
                GL11.glScalef(1.0f / f3, (f3 + 1.0f) / 2.0f, 1.0f);
                GL11.glTranslatef(-(n2 + 8), -(n3 + 12), 0.0f);
            }
            field_73841_b.func_82406_b(this.field_73839_d._z, this.field_73839_d._R(), cvzo2, n2, n3);
            if (f2 > 0.0f) {
                GL11.glPopMatrix();
            }
            field_73841_b.func_77021_b(this.field_73839_d._z, this.field_73839_d._R(), cvzo2, n2, n3);
        }
    }

    public void func_73831_a() {
        if (this.field_73845_h > 0) {
            --this.field_73845_h;
        }
        ++this.field_73837_f;
        if (this.field_73839_d._t != null) {
            cvzo cvzo2 = this.field_73839_d._t.field_71071_by._a();
            if (cvzo2 == null) {
                this.field_92017_k = 0;
            } else if (this.field_92016_l != null && cvzo2._d == this.field_92016_l._d && cvzo._a(cvzo2, this.field_92016_l) && (cvzo2._f() || cvzo2._j() == this.field_92016_l._j())) {
                if (this.field_92017_k > 0) {
                    --this.field_92017_k;
                }
            } else {
                this.field_92017_k = 40;
            }
            this.field_92016_l = cvzo2;
        }
    }

    public void func_73833_a(String string) {
        this.func_110326_a("Now playing: " + string, true);
    }

    public void func_110326_a(String string, boolean bl) {
        this.field_73838_g = string;
        this.field_73845_h = 60;
        this.field_73844_j = bl;
    }

    public wowp func_73827_b() {
        return this.field_73840_e;
    }

    public int func_73834_c() {
        return this.field_73837_f;
    }
}

