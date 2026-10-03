/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awf
 *  axq
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Project
 *  ud
 *  vm
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(value=Side.CLIENT)
public class axr
extends awy {
    private static final bjo B = new bjo("textures/gui/container/enchanting_table.png");
    private static final bjo C = new bjo("textures/entity/enchanting_table_book.png");
    private static final bbc D = new bbc();
    private Random E = new Random();
    private vm F = (vm)this.e;
    public int t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;
    ye A;
    private String G;

    public axr(ud par1InventoryPlayer, abw par2World, int par3, int par4, int par5, String par6Str) {
        super((uy)new vm(par1InventoryPlayer, par2World, par3, par4, par5));
        this.G = par6Str;
    }

    @Override
    protected void b(int par1, int par2) {
        this.o.b(this.G == null ? bkb.a((String)"container.enchant") : this.G, 12, 5, 0x404040);
        this.o.b(bkb.a((String)"container.inventory"), 8, this.d - 96 + 2, 0x404040);
    }

    @Override
    public void c() {
        super.c();
        this.g();
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        int l = (this.g - this.c) / 2;
        int i1 = (this.h - this.d) / 2;
        for (int j1 = 0; j1 < 3; ++j1) {
            int k1 = par1 - (l + 60);
            int l1 = par2 - (i1 + 14 + 19 * j1);
            if (k1 < 0 || l1 < 0 || k1 >= 108 || l1 >= 19 || !this.F.a((uf)this.f.h, j1)) continue;
            this.f.c.a(this.F.d, j1);
        }
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(B);
        int k = (this.g - this.c) / 2;
        int l = (this.h - this.d) / 2;
        this.b(k, l, 0, 0, this.c, this.d);
        GL11.glPushMatrix();
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        awf scaledresolution = new awf(this.f.u, this.f.d, this.f.e);
        GL11.glViewport((int)((scaledresolution.a() - 320) / 2 * scaledresolution.e()), (int)((scaledresolution.b() - 240) / 2 * scaledresolution.e()), (int)(320 * scaledresolution.e()), (int)(240 * scaledresolution.e()));
        GL11.glTranslatef((float)-0.34f, (float)0.23f, (float)0.0f);
        Project.gluPerspective((float)90.0f, (float)1.3333334f, (float)9.0f, (float)80.0f);
        float f1 = 1.0f;
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        att.b();
        GL11.glTranslatef((float)0.0f, (float)3.3f, (float)-16.0f);
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        float f2 = 5.0f;
        GL11.glScalef((float)f2, (float)f2, (float)f2);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.f.J().a(C);
        GL11.glRotatef((float)20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        float f3 = this.z + (this.y - this.z) * par1;
        GL11.glTranslatef((float)((1.0f - f3) * 0.2f), (float)((1.0f - f3) * 0.1f), (float)((1.0f - f3) * 0.25f));
        GL11.glRotatef((float)(-(1.0f - f3) * 90.0f - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        float f4 = this.v + (this.u - this.v) * par1 + 0.25f;
        float f5 = this.v + (this.u - this.v) * par1 + 0.75f;
        f4 = (f4 - (float)ls.b((double)f4)) * 1.6f - 0.3f;
        f5 = (f5 - (float)ls.b((double)f5)) * 1.6f - 0.3f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        GL11.glEnable((int)32826);
        D.a(null, 0.0f, f4, f5, f3, 0.0f, 0.0625f);
        GL11.glDisable((int)32826);
        att.a();
        GL11.glMatrixMode((int)5889);
        GL11.glViewport((int)0, (int)0, (int)this.f.d, (int)this.f.e);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        att.a();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        axq.a.a(this.F.f);
        for (int i1 = 0; i1 < 3; ++i1) {
            String s2 = axq.a.a();
            this.n = 0.0f;
            this.f.J().a(B);
            int j1 = this.F.g[i1];
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if (j1 == 0) {
                this.b(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
                continue;
            }
            String s1 = "" + j1;
            avi fontrenderer = this.f.m;
            int k1 = 6839882;
            if (this.f.h.bH < j1 && !this.f.h.bG.d) {
                this.b(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
                fontrenderer.a(s2, k + 62, l + 16 + 19 * i1, 104, (k1 & 0xFEFEFE) >> 1);
                fontrenderer = this.f.l;
                k1 = 4226832;
                fontrenderer.a(s1, k + 62 + 104 - fontrenderer.a(s1), l + 16 + 19 * i1 + 7, k1);
                continue;
            }
            int l1 = par2 - (k + 60);
            int i2 = par3 - (l + 14 + 19 * i1);
            if (l1 >= 0 && i2 >= 0 && l1 < 108 && i2 < 19) {
                this.b(k + 60, l + 14 + 19 * i1, 0, 204, 108, 19);
                k1 = 0xFFFF80;
            } else {
                this.b(k + 60, l + 14 + 19 * i1, 0, 166, 108, 19);
            }
            fontrenderer.a(s2, k + 62, l + 16 + 19 * i1, 104, k1);
            fontrenderer = this.f.l;
            k1 = 8453920;
            fontrenderer.a(s1, k + 62 + 104 - fontrenderer.a(s1), l + 16 + 19 * i1 + 7, k1);
        }
    }

    public void g() {
        float f1;
        float f;
        ye itemstack = this.e.a(0).d();
        if (!ye.b(itemstack, this.A)) {
            this.A = itemstack;
            do {
                this.w += (float)(this.E.nextInt(4) - this.E.nextInt(4));
            } while (this.u <= this.w + 1.0f && this.u >= this.w - 1.0f);
        }
        ++this.t;
        this.v = this.u;
        this.z = this.y;
        boolean flag = false;
        for (int i = 0; i < 3; ++i) {
            if (this.F.g[i] == 0) continue;
            flag = true;
        }
        this.y = flag ? (this.y += 0.2f) : (this.y -= 0.2f);
        if (this.y < 0.0f) {
            this.y = 0.0f;
        }
        if (this.y > 1.0f) {
            this.y = 1.0f;
        }
        if ((f = (this.w - this.u) * 0.4f) < -(f1 = 0.2f)) {
            f = -f1;
        }
        if (f > f1) {
            f = f1;
        }
        this.x += (f - this.x) * 0.9f;
        this.u += this.x;
    }
}

