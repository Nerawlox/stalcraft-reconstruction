/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atu
 *  bbo
 *  bcp
 *  bcv
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class bcu {
    public float a = 64.0f;
    public float b = 32.0f;
    private int r;
    private int s;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    private boolean t;
    private int u;
    public boolean i;
    public boolean j = true;
    public boolean k;
    public List l = new ArrayList();
    public List m;
    public final String n;
    private bbo v;
    public float o;
    public float p;
    public float q;

    public bcu(bbo par1ModelBase, String par2Str) {
        this.v = par1ModelBase;
        par1ModelBase.r.add(this);
        this.n = par2Str;
        this.b(par1ModelBase.t, par1ModelBase.u);
    }

    public bcu(bbo par1ModelBase) {
        this(par1ModelBase, null);
    }

    public bcu(bbo par1ModelBase, int par2, int par3) {
        this(par1ModelBase);
        this.a(par2, par3);
    }

    public void a(bcu par1ModelRenderer) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(par1ModelRenderer);
    }

    public bcu a(int par1, int par2) {
        this.r = par1;
        this.s = par2;
        return this;
    }

    public bcu a(String par1Str, float par2, float par3, float par4, int par5, int par6, int par7) {
        par1Str = this.n + "." + par1Str;
        bcv textureoffset = this.v.a(par1Str);
        this.a(textureoffset.a, textureoffset.b);
        this.l.add(new bcp(this, this.r, this.s, par2, par3, par4, par5, par6, par7, 0.0f).a(par1Str));
        return this;
    }

    public bcu a(float par1, float par2, float par3, int par4, int par5, int par6) {
        this.l.add(new bcp(this, this.r, this.s, par1, par2, par3, par4, par5, par6, 0.0f));
        return this;
    }

    public void a(float par1, float par2, float par3, int par4, int par5, int par6, float par7) {
        this.l.add(new bcp(this, this.r, this.s, par1, par2, par3, par4, par5, par6, par7));
    }

    public void a(float par1, float par2, float par3) {
        this.c = par1;
        this.d = par2;
        this.e = par3;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(float par1) {
        if (!this.k && this.j) {
            if (!this.t) {
                this.d(par1);
            }
            GL11.glTranslatef((float)this.o, (float)this.p, (float)this.q);
            if (this.f == 0.0f && this.g == 0.0f && this.h == 0.0f) {
                if (this.c == 0.0f && this.d == 0.0f && this.e == 0.0f) {
                    GL11.glCallList((int)this.u);
                    if (this.m != null) {
                        for (int i2 = 0; i2 < this.m.size(); ++i2) {
                            ((bcu)this.m.get(i2)).a(par1);
                        }
                    }
                } else {
                    GL11.glTranslatef((float)(this.c * par1), (float)(this.d * par1), (float)(this.e * par1));
                    GL11.glCallList((int)this.u);
                    if (this.m != null) {
                        for (int i3 = 0; i3 < this.m.size(); ++i3) {
                            ((bcu)this.m.get(i3)).a(par1);
                        }
                    }
                    GL11.glTranslatef((float)(-this.c * par1), (float)(-this.d * par1), (float)(-this.e * par1));
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(this.c * par1), (float)(this.d * par1), (float)(this.e * par1));
                if (this.h != 0.0f) {
                    GL11.glRotatef((float)(this.h * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.g != 0.0f) {
                    GL11.glRotatef((float)(this.g * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.f != 0.0f) {
                    GL11.glRotatef((float)(this.f * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
                GL11.glCallList((int)this.u);
                if (this.m != null) {
                    for (int i4 = 0; i4 < this.m.size(); ++i4) {
                        ((bcu)this.m.get(i4)).a(par1);
                    }
                }
                GL11.glPopMatrix();
            }
            GL11.glTranslatef((float)(-this.o), (float)(-this.p), (float)(-this.q));
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void b(float par1) {
        if (!this.k && this.j) {
            if (!this.t) {
                this.d(par1);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(this.c * par1), (float)(this.d * par1), (float)(this.e * par1));
            if (this.g != 0.0f) {
                GL11.glRotatef((float)(this.g * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (this.f != 0.0f) {
                GL11.glRotatef((float)(this.f * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (this.h != 0.0f) {
                GL11.glRotatef((float)(this.h * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            GL11.glCallList((int)this.u);
            GL11.glPopMatrix();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void c(float par1) {
        if (!this.k && this.j) {
            if (!this.t) {
                this.d(par1);
            }
            if (this.f == 0.0f && this.g == 0.0f && this.h == 0.0f) {
                if (this.c != 0.0f || this.d != 0.0f || this.e != 0.0f) {
                    GL11.glTranslatef((float)(this.c * par1), (float)(this.d * par1), (float)(this.e * par1));
                }
            } else {
                GL11.glTranslatef((float)(this.c * par1), (float)(this.d * par1), (float)(this.e * par1));
                if (this.h != 0.0f) {
                    GL11.glRotatef((float)(this.h * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.g != 0.0f) {
                    GL11.glRotatef((float)(this.g * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.f != 0.0f) {
                    GL11.glRotatef((float)(this.f * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void d(float par1) {
        this.u = atu.a((int)1);
        GL11.glNewList((int)this.u, (int)4864);
        bfq tessellator = bfq.a;
        for (int i2 = 0; i2 < this.l.size(); ++i2) {
            ((bcp)this.l.get(i2)).a(tessellator, par1);
        }
        GL11.glEndList();
        this.t = true;
    }

    public bcu b(int par1, int par2) {
        this.a = par1;
        this.b = par2;
        return this;
    }
}

