/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  acl
 *  asx
 *  bft
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bfa {
    public abw a;
    private int y = -1;
    public static int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean[] m = new boolean[2];
    public int n;
    public int o;
    public int p;
    public boolean q;
    public asx r;
    public int s;
    public boolean t = true;
    public boolean u;
    public int v;
    public boolean w;
    private boolean A;
    public List x = new ArrayList();
    private List B;
    private int C;

    public bfa(abw par1World, List par2List, int par3, int par4, int par5, int par6) {
        this.a = par1World;
        this.B = par2List;
        this.y = par6;
        this.c = -999;
        this.a(par3, par4, par5);
        this.q = false;
    }

    public void a(int par1, int par2, int par3) {
        if (par1 != this.c || par2 != this.d || par3 != this.e) {
            this.b();
            this.c = par1;
            this.d = par2;
            this.e = par3;
            this.n = par1 + 8;
            this.o = par2 + 8;
            this.p = par3 + 8;
            this.i = par1 & 0x3FF;
            this.j = par2;
            this.k = par3 & 0x3FF;
            this.f = par1 - this.i;
            this.g = par2 - this.j;
            this.h = par3 - this.k;
            float f2 = 6.0f;
            this.r = asx.a((double)((float)par1 - f2), (double)((float)par2 - f2), (double)((float)par3 - f2), (double)((float)(par1 + 16) + f2), (double)((float)(par2 + 16) + f2), (double)((float)(par3 + 16) + f2));
            GL11.glNewList((int)(this.y + 2), (int)4864);
            bgw.a(asx.a().a((double)((float)this.i - f2), (double)((float)this.j - f2), (double)((float)this.k - f2), (double)((float)(this.i + 16) + f2), (double)((float)(this.j + 16) + f2), (double)((float)(this.k + 16) + f2)));
            GL11.glEndList();
            this.f();
        }
    }

    private void g() {
        GL11.glTranslatef((float)this.i, (float)this.j, (float)this.k);
    }

    public void a() {
        if (this.q) {
            this.q = false;
            int i2 = this.c;
            int j2 = this.d;
            int k = this.e;
            int l2 = this.c + 16;
            int i1 = this.d + 16;
            int j1 = this.e + 16;
            for (int k1 = 0; k1 < 2; ++k1) {
                this.m[k1] = true;
            }
            adr.a = false;
            HashSet hashset = new HashSet();
            hashset.addAll(this.x);
            this.x.clear();
            int b0 = 1;
            acl chunkcache = new acl(this.a, i2 - b0, j2 - b0, k - b0, l2 + b0, i1 + b0, j1 + b0, b0);
            if (!chunkcache.T()) {
                ++b;
                bfr renderblocks = new bfr((acf)chunkcache);
                this.C = 0;
                for (int l1 = 0; l1 < 2; ++l1) {
                    boolean flag = false;
                    boolean flag1 = false;
                    boolean flag2 = false;
                    for (int i22 = j2; i22 < i1; ++i22) {
                        for (int j22 = k; j22 < j1; ++j22) {
                            for (int k2 = i2; k2 < l2; ++k2) {
                                int i3;
                                asp tileentity;
                                aqz block;
                                int l22 = chunkcache.a(k2, i22, j22);
                                if (l22 <= 0) continue;
                                if (!flag2) {
                                    flag2 = true;
                                    GL11.glNewList((int)(this.y + l1), (int)4864);
                                    GL11.glPushMatrix();
                                    this.g();
                                    float f2 = 1.000001f;
                                    GL11.glTranslatef((float)-8.0f, (float)-8.0f, (float)-8.0f);
                                    GL11.glScalef((float)f2, (float)f2, (float)f2);
                                    GL11.glTranslatef((float)8.0f, (float)8.0f, (float)8.0f);
                                    bfq.a.b();
                                    bfq.a.b((double)(-this.c), (double)(-this.d), (double)(-this.e));
                                }
                                if ((block = aqz.s[l22]) == null) continue;
                                if (l1 == 0 && block.hasTileEntity(chunkcache.h(k2, i22, j22)) && bjd.a.a(tileentity = chunkcache.r(k2, i22, j22))) {
                                    this.x.add(tileentity);
                                }
                                if ((i3 = block.n()) > l1) {
                                    flag = true;
                                }
                                if (!block.canRenderInPass(l1)) continue;
                                flag1 |= renderblocks.b(block, k2, i22, j22);
                            }
                        }
                    }
                    if (flag2) {
                        this.C += bfq.a.a();
                        GL11.glPopMatrix();
                        GL11.glEndList();
                        bfq.a.b(0.0, 0.0, 0.0);
                    } else {
                        flag1 = false;
                    }
                    if (flag1) {
                        this.m[l1] = false;
                    }
                    if (!flag) break;
                }
            }
            HashSet hashset1 = new HashSet();
            hashset1.addAll(this.x);
            hashset1.removeAll(hashset);
            this.B.addAll(hashset1);
            hashset.removeAll(this.x);
            this.B.removeAll(hashset);
            this.w = adr.a;
            this.A = true;
        }
    }

    public float a(nn par1Entity) {
        float f2 = (float)(par1Entity.u - (double)this.n);
        float f1 = (float)(par1Entity.v - (double)this.o);
        float f22 = (float)(par1Entity.w - (double)this.p);
        return f2 * f2 + f1 * f1 + f22 * f22;
    }

    public void b() {
        for (int i2 = 0; i2 < 2; ++i2) {
            this.m[i2] = true;
        }
        this.l = false;
        this.A = false;
    }

    public void c() {
        this.b();
        this.a = null;
    }

    public int a(int par1) {
        return !this.l ? -1 : (!this.m[par1] ? this.y + par1 : -1);
    }

    public void a(bft par1ICamera) {
        this.l = par1ICamera.a(this.r);
    }

    public void d() {
        GL11.glCallList((int)(this.y + 2));
    }

    public boolean e() {
        return !this.A ? false : this.m[0] && this.m[1];
    }

    public void f() {
        this.q = true;
    }
}

