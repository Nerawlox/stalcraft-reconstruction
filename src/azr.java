/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  do
 *  org.apache.commons.io.Charsets
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class azr
extends awe {
    private static final bjo a = new bjo("textures/gui/title/minecraft.png");
    private static final bjo b = new bjo("textures/misc/vignette.png");
    private int c;
    private List d;
    private int e;
    private float p = 0.5f;

    @Override
    public void c() {
        ++this.c;
        float f = (float)(this.e + this.h + this.h + 24) / this.p;
        if ((float)this.c > f) {
            this.g();
        }
    }

    @Override
    protected void a(char par1, int par2) {
        if (par2 == 1) {
            this.g();
        }
    }

    private void g() {
        this.f.h.a.c((ey)new do(1));
        this.f.a((awe)null);
    }

    @Override
    public boolean f() {
        return true;
    }

    @Override
    public void A_() {
        if (this.d == null) {
            this.d = new ArrayList();
            try {
                int i;
                String s2 = "";
                String s1 = "" + (Object)((Object)a.p) + (Object)((Object)a.q) + (Object)((Object)a.k) + (Object)((Object)a.l);
                int short1 = 274;
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(this.f.K().a(new bjo("texts/end.txt")).b(), Charsets.UTF_8));
                Random random = new Random(8124371L);
                while ((s2 = bufferedreader.readLine()) != null) {
                    s2 = s2.replaceAll("PLAYERNAME", this.f.H().a());
                    while (s2.contains(s1)) {
                        i = s2.indexOf(s1);
                        String s22 = s2.substring(0, i);
                        String s3 = s2.substring(i + s1.length());
                        s2 = s22 + (Object)((Object)a.p) + (Object)((Object)a.q) + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + s3;
                    }
                    this.d.addAll(this.f.l.c(s2, short1));
                    this.d.add("");
                }
                for (i = 0; i < 8; ++i) {
                    this.d.add("");
                }
                bufferedreader = new BufferedReader(new InputStreamReader(this.f.K().a(new bjo("texts/credits.txt")).b(), Charsets.UTF_8));
                while ((s2 = bufferedreader.readLine()) != null) {
                    s2 = s2.replaceAll("PLAYERNAME", this.f.H().a());
                    s2 = s2.replaceAll("\t", "    ");
                    this.d.addAll(this.f.l.c(s2, short1));
                    this.d.add("");
                }
                this.e = this.d.size() * 12;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void b(int par1, int par2, float par3) {
        bfq tessellator = bfq.a;
        this.f.J().a(avk.k);
        tessellator.b();
        tessellator.a(1.0f, 1.0f, 1.0f, 1.0f);
        int k = this.g;
        float f1 = 0.0f - ((float)this.c + par3) * 0.5f * this.p;
        float f2 = (float)this.h - ((float)this.c + par3) * 0.5f * this.p;
        float f3 = 0.015625f;
        float f4 = ((float)this.c + par3 - 0.0f) * 0.02f;
        float f5 = (float)(this.e + this.h + this.h + 24) / this.p;
        float f6 = (f5 - 20.0f - ((float)this.c + par3)) * 0.005f;
        if (f6 < f4) {
            f4 = f6;
        }
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        f4 *= f4;
        f4 = f4 * 96.0f / 255.0f;
        tessellator.a(f4, f4, f4);
        tessellator.a(0.0, this.h, this.n, 0.0, f1 * f3);
        tessellator.a(k, this.h, this.n, (float)k * f3, f1 * f3);
        tessellator.a(k, 0.0, this.n, (float)k * f3, f2 * f3);
        tessellator.a(0.0, 0.0, this.n, 0.0, f2 * f3);
        tessellator.a();
    }

    @Override
    public void a(int par1, int par2, float par3) {
        int j1;
        this.b(par1, par2, par3);
        bfq tessellator = bfq.a;
        int short1 = 274;
        int k = this.g / 2 - short1 / 2;
        int l = this.h + 50;
        float f1 = -((float)this.c + par3) * this.p;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)f1, (float)0.0f);
        this.f.J().a(a);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b(k, l, 0, 0, 155, 44);
        this.b(k + 155, l, 0, 45, 155, 44);
        tessellator.d(0xFFFFFF);
        int i1 = l + 200;
        for (j1 = 0; j1 < this.d.size(); ++j1) {
            float f2;
            if (j1 == this.d.size() - 1 && (f2 = (float)i1 + f1 - (float)(this.h / 2 - 6)) < 0.0f) {
                GL11.glTranslatef((float)0.0f, (float)(-f2), (float)0.0f);
            }
            if ((float)i1 + f1 + 12.0f + 8.0f > 0.0f && (float)i1 + f1 < (float)this.h) {
                String s2 = (String)this.d.get(j1);
                if (s2.startsWith("[C]")) {
                    this.o.a(s2.substring(3), k + (short1 - this.o.a(s2.substring(3))) / 2, i1, 0xFFFFFF);
                } else {
                    this.o.b.setSeed((long)j1 * 4238972211L + (long)(this.c / 4));
                    this.o.a(s2, k, i1, 0xFFFFFF);
                }
            }
            i1 += 12;
        }
        GL11.glPopMatrix();
        this.f.J().a(b);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)0, (int)769);
        tessellator.b();
        tessellator.a(1.0f, 1.0f, 1.0f, 1.0f);
        j1 = this.g;
        int k1 = this.h;
        tessellator.a(0.0, k1, this.n, 0.0, 1.0);
        tessellator.a(j1, k1, this.n, 1.0, 1.0);
        tessellator.a(j1, 0.0, this.n, 1.0, 0.0);
        tessellator.a(0.0, 0.0, this.n, 0.0, 0.0);
        tessellator.a();
        GL11.glDisable((int)3042);
        super.a(par1, par2, par3);
    }
}

