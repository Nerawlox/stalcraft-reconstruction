/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ata
 *  beg
 *  bes
 *  bim
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class beh {
    private static final bjo b = new bjo("textures/particle/particles.png");
    protected abw a;
    private List[] c = new List[4];
    private bim d;
    private Random e = new Random();

    public beh(abw par1World, bim par2TextureManager) {
        if (par1World != null) {
            this.a = par1World;
        }
        this.d = par2TextureManager;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.c[i2] = new ArrayList();
        }
    }

    public void a(beg par1EntityFX) {
        int i2 = par1EntityFX.b();
        if (this.c[i2].size() >= 4000) {
            this.c[i2].remove(0);
        }
        this.c[i2].add(par1EntityFX);
    }

    public void a() {
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int j2 = 0; j2 < this.c[i2].size(); ++j2) {
                beg entityfx = (beg)this.c[i2].get(j2);
                if (entityfx != null) {
                    entityfx.l_();
                }
                if (entityfx != null && !entityfx.M) continue;
                this.c[i2].remove(j2--);
            }
        }
    }

    public void a(nn par1Entity, float par2) {
        float f1 = atp.d;
        float f2 = atp.f;
        float f3 = atp.g;
        float f4 = atp.h;
        float f5 = atp.e;
        beg.ay = par1Entity.U + (par1Entity.u - par1Entity.U) * (double)par2;
        beg.az = par1Entity.V + (par1Entity.v - par1Entity.V) * (double)par2;
        beg.aA = par1Entity.W + (par1Entity.w - par1Entity.W) * (double)par2;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.c[i2].isEmpty()) continue;
            switch (i2) {
                default: {
                    this.d.a(b);
                    break;
                }
                case 1: {
                    this.d.a(bik.b);
                    break;
                }
                case 2: {
                    this.d.a(bik.c);
                }
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glAlphaFunc((int)516, (float)0.003921569f);
            bfq tessellator = bfq.a;
            tessellator.b();
            for (int j2 = 0; j2 < this.c[i2].size(); ++j2) {
                beg entityfx = (beg)this.c[i2].get(j2);
                if (entityfx == null) continue;
                tessellator.c(entityfx.c(par2));
                entityfx.a(tessellator, par2, f1, f5, f2, f3, f4);
            }
            tessellator.a();
            GL11.glDisable((int)3042);
            GL11.glDepthMask((boolean)true);
            GL11.glAlphaFunc((int)516, (float)0.1f);
        }
    }

    public void b(nn par1Entity, float par2) {
        float f1 = (float)Math.PI / 180;
        float f2 = ls.b(par1Entity.A * ((float)Math.PI / 180));
        float f3 = ls.a(par1Entity.A * ((float)Math.PI / 180));
        float f4 = -f3 * ls.a(par1Entity.B * ((float)Math.PI / 180));
        float f5 = f2 * ls.a(par1Entity.B * ((float)Math.PI / 180));
        float f6 = ls.b(par1Entity.B * ((float)Math.PI / 180));
        int b0 = 3;
        List list = this.c[b0];
        if (!list.isEmpty()) {
            bfq tessellator = bfq.a;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                beg entityfx = (beg)list.get(i2);
                if (entityfx == null) continue;
                tessellator.c(entityfx.c(par2));
                entityfx.a(tessellator, par2, f2, f6, f3, f4, f5);
            }
        }
    }

    public void a(abw par1World) {
        this.a = par1World;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.c[i2].clear();
        }
    }

    public void a(int par1, int par2, int par3, int par4, int par5) {
        aqz block = aqz.s[par4];
        if (block != null && !block.addBlockDestroyEffects(this.a, par1, par2, par3, par5, this)) {
            int b0 = 4;
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < b0; ++k1) {
                    for (int l1 = 0; l1 < b0; ++l1) {
                        double d0 = (double)par1 + ((double)j1 + 0.5) / (double)b0;
                        double d1 = (double)par2 + ((double)k1 + 0.5) / (double)b0;
                        double d2 = (double)par3 + ((double)l1 + 0.5) / (double)b0;
                        this.a((beg)new bes(this.a, d0, d1, d2, d0 - (double)par1 - 0.5, d1 - (double)par2 - 0.5, d2 - (double)par3 - 0.5, block, par5).a(par1, par2, par3));
                    }
                }
            }
        }
    }

    public void a(int par1, int par2, int par3, int par4) {
        int i1 = this.a.a(par1, par2, par3);
        if (i1 != 0) {
            aqz block = aqz.s[i1];
            float f2 = 0.1f;
            double d0 = (double)par1 + this.e.nextDouble() * (block.v() - block.u() - (double)(f2 * 2.0f)) + (double)f2 + block.u();
            double d1 = (double)par2 + this.e.nextDouble() * (block.x() - block.w() - (double)(f2 * 2.0f)) + (double)f2 + block.w();
            double d2 = (double)par3 + this.e.nextDouble() * (block.z() - block.y() - (double)(f2 * 2.0f)) + (double)f2 + block.y();
            if (par4 == 0) {
                d1 = (double)par2 + block.w() - (double)f2;
            }
            if (par4 == 1) {
                d1 = (double)par2 + block.x() + (double)f2;
            }
            if (par4 == 2) {
                d2 = (double)par3 + block.y() - (double)f2;
            }
            if (par4 == 3) {
                d2 = (double)par3 + block.z() + (double)f2;
            }
            if (par4 == 4) {
                d0 = (double)par1 + block.u() - (double)f2;
            }
            if (par4 == 5) {
                d0 = (double)par1 + block.v() + (double)f2;
            }
            this.a(new bes(this.a, d0, d1, d2, 0.0, 0.0, 0.0, block, this.a.h(par1, par2, par3)).a(par1, par2, par3).a(0.2f).f(0.6f));
        }
    }

    public String b() {
        return "" + (this.c[0].size() + this.c[1].size() + this.c[2].size());
    }

    public void addBlockHitEffects(int x2, int y2, int z2, ata target) {
        aqz block = aqz.s[this.a.a(x2, y2, z2)];
        if (block != null && !block.addBlockHitEffects(this.a, target, this)) {
            this.a(x2, y2, z2, target.e);
        }
    }
}

