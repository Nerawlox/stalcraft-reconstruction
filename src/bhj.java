/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ate
 *  atg
 *  atj
 *  beu
 *  bex
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.MinecraftForgeClient
 *  net.minecraftforge.client.event.RenderPlayerEvent$Post
 *  net.minecraftforge.client.event.RenderPlayerEvent$Pre
 *  net.minecraftforge.client.event.RenderPlayerEvent$SetArmorModel
 *  net.minecraftforge.client.event.RenderPlayerEvent$Specials$Post
 *  net.minecraftforge.client.event.RenderPlayerEvent$Specials$Pre
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  org.lwjgl.opengl.GL11
 *  wh
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhj
extends bhb {
    private static final bjo a = new bjo("textures/entity/steve.png");
    private bbj f;
    private bbj g;
    private bbj h;

    public bhj() {
        super(new bbj(0.0f), 0.5f);
        this.f = (bbj)this.i;
        this.g = new bbj(1.0f);
        this.h = new bbj(0.5f);
    }

    protected int a(beu par1AbstractClientPlayer, int par2, float par3) {
        yc item;
        ye itemstack = par1AbstractClientPlayer.bn.f(3 - par2);
        RenderPlayerEvent.SetArmorModel event = new RenderPlayerEvent.SetArmorModel((uf)par1AbstractClientPlayer, this, 3 - par2, par3, itemstack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.result != -1) {
            return event.result;
        }
        if (itemstack != null && (item = itemstack.b()) instanceof wh) {
            wh itemarmor = (wh)item;
            this.a(bgu.getArmorResource((nn)par1AbstractClientPlayer, itemstack, par2, null));
            bbj modelbiped = par2 == 2 ? this.h : this.g;
            modelbiped.c.j = par2 == 0;
            modelbiped.d.j = par2 == 0;
            modelbiped.e.j = par2 == 1 || par2 == 2;
            modelbiped.f.j = par2 == 1;
            modelbiped.g.j = par2 == 1;
            modelbiped.h.j = par2 == 2 || par2 == 3;
            modelbiped.i.j = par2 == 2 || par2 == 3;
            modelbiped = ForgeHooksClient.getArmorModel((of)par1AbstractClientPlayer, (ye)itemstack, (int)par2, (bbj)modelbiped);
            this.a(modelbiped);
            modelbiped.p = this.i.p;
            modelbiped.q = this.i.q;
            modelbiped.s = this.i.s;
            float f1 = 1.0f;
            int j2 = itemarmor.b(itemstack);
            if (j2 != -1) {
                float f2 = (float)(j2 >> 16 & 0xFF) / 255.0f;
                float f3 = (float)(j2 >> 8 & 0xFF) / 255.0f;
                float f4 = (float)(j2 & 0xFF) / 255.0f;
                GL11.glColor3f((float)(f1 * f2), (float)(f1 * f3), (float)(f1 * f4));
                if (itemstack.y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f((float)f1, (float)f1, (float)f1);
            if (itemstack.y()) {
                return 15;
            }
            return 1;
        }
        return -1;
    }

    protected void b(beu par1AbstractClientPlayer, int par2, float par3) {
        yc item;
        ye itemstack = par1AbstractClientPlayer.bn.f(3 - par2);
        if (itemstack != null && (item = itemstack.b()) instanceof wh) {
            this.a(bgu.getArmorResource((nn)par1AbstractClientPlayer, itemstack, par2, "overlay"));
            float f1 = 1.0f;
            GL11.glColor3f((float)f1, (float)f1, (float)f1);
        }
    }

    public void a(beu par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {
        if (MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Pre((uf)par1AbstractClientPlayer, this, par9))) {
            return;
        }
        float f2 = 1.0f;
        GL11.glColor3f((float)f2, (float)f2, (float)f2);
        ye itemstack = par1AbstractClientPlayer.bn.h();
        this.f.m = itemstack != null ? 1 : 0;
        this.h.m = this.f.m;
        this.g.m = this.f.m;
        if (itemstack != null && par1AbstractClientPlayer.bq() > 0) {
            zj enumaction = itemstack.o();
            if (enumaction == zj.d) {
                this.f.m = 3;
                this.h.m = 3;
                this.g.m = 3;
            } else if (enumaction == zj.e) {
                this.f.o = true;
                this.h.o = true;
                this.g.o = true;
            }
        }
        this.h.n = this.f.n = par1AbstractClientPlayer.ah();
        this.g.n = this.f.n;
        double d3 = par4 - (double)par1AbstractClientPlayer.N;
        if (par1AbstractClientPlayer.ah() && !(par1AbstractClientPlayer instanceof bex)) {
            d3 -= 0.125;
        }
        super.a((of)par1AbstractClientPlayer, par2, d3, par6, par8, par9);
        this.f.o = false;
        this.h.o = false;
        this.g.o = false;
        this.f.n = false;
        this.h.n = false;
        this.g.n = false;
        this.f.m = 0;
        this.h.m = 0;
        this.g.m = 0;
        MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Post((uf)par1AbstractClientPlayer, this, par9));
    }

    protected bjo a(beu par1AbstractClientPlayer) {
        return par1AbstractClientPlayer.r();
    }

    protected void a(beu par1AbstractClientPlayer, float par2) {
        ye itemstack1;
        float f6;
        RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre((uf)par1AbstractClientPlayer, this, par2);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        float f1 = 1.0f;
        GL11.glColor3f((float)f1, (float)f1, (float)f1);
        super.c((of)par1AbstractClientPlayer, par2);
        super.e((of)par1AbstractClientPlayer, par2);
        ye itemstack = par1AbstractClientPlayer.bn.f(3);
        if (itemstack != null && event.renderHelmet) {
            float f2;
            GL11.glPushMatrix();
            this.f.c.c(0.0625f);
            if (itemstack != null && itemstack.b() instanceof zh) {
                boolean is3D;
                IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer((ye)itemstack, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.EQUIPPED);
                boolean bl2 = is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (is3D || bfr.a(aqz.s[itemstack.d].d())) {
                    f2 = 0.625f;
                    GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)0.0f);
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)(-f2));
                }
                this.b.f.a((of)par1AbstractClientPlayer, itemstack, 0);
            } else if (itemstack.b().cv == yc.bS.cv) {
                f2 = 1.0625f;
                GL11.glScalef((float)f2, (float)(-f2), (float)(-f2));
                String s2 = "";
                if (itemstack.p() && itemstack.q().b("SkullOwner")) {
                    s2 = itemstack.q().i("SkullOwner");
                }
                bjb.a.a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemstack.k(), s2);
            }
            GL11.glPopMatrix();
        }
        if (par1AbstractClientPlayer.c_().equals("deadmau5") && par1AbstractClientPlayer.p().a()) {
            this.a(par1AbstractClientPlayer.r());
            for (int i2 = 0; i2 < 2; ++i2) {
                float f3 = par1AbstractClientPlayer.C + (par1AbstractClientPlayer.A - par1AbstractClientPlayer.C) * par2 - (par1AbstractClientPlayer.aO + (par1AbstractClientPlayer.aN - par1AbstractClientPlayer.aO) * par2);
                float f4 = par1AbstractClientPlayer.D + (par1AbstractClientPlayer.B - par1AbstractClientPlayer.D) * par2;
                GL11.glPushMatrix();
                GL11.glRotatef((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)f4, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glTranslatef((float)(0.375f * (float)(i2 * 2 - 1)), (float)0.0f, (float)0.0f);
                GL11.glTranslatef((float)0.0f, (float)-0.375f, (float)0.0f);
                GL11.glRotatef((float)(-f4), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
                float f5 = 1.3333334f;
                GL11.glScalef((float)f5, (float)f5, (float)f5);
                this.f.b(0.0625f);
                GL11.glPopMatrix();
            }
        }
        boolean flag = par1AbstractClientPlayer.q().a();
        boolean flag1 = !par1AbstractClientPlayer.aj();
        boolean flag2 = !par1AbstractClientPlayer.bL();
        boolean bl3 = flag = event.renderCape && flag;
        if (flag && flag1 && flag2) {
            this.a(par1AbstractClientPlayer.s());
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)0.125f);
            double d0 = par1AbstractClientPlayer.bw + (par1AbstractClientPlayer.bz - par1AbstractClientPlayer.bw) * (double)par2 - (par1AbstractClientPlayer.r + (par1AbstractClientPlayer.u - par1AbstractClientPlayer.r) * (double)par2);
            double d1 = par1AbstractClientPlayer.bx + (par1AbstractClientPlayer.bA - par1AbstractClientPlayer.bx) * (double)par2 - (par1AbstractClientPlayer.s + (par1AbstractClientPlayer.v - par1AbstractClientPlayer.s) * (double)par2);
            double d2 = par1AbstractClientPlayer.by + (par1AbstractClientPlayer.bB - par1AbstractClientPlayer.by) * (double)par2 - (par1AbstractClientPlayer.t + (par1AbstractClientPlayer.w - par1AbstractClientPlayer.t) * (double)par2);
            f6 = par1AbstractClientPlayer.aO + (par1AbstractClientPlayer.aN - par1AbstractClientPlayer.aO) * par2;
            double d3 = ls.a(f6 * (float)Math.PI / 180.0f);
            double d4 = -ls.b(f6 * (float)Math.PI / 180.0f);
            float f7 = (float)d1 * 10.0f;
            if (f7 < -6.0f) {
                f7 = -6.0f;
            }
            if (f7 > 32.0f) {
                f7 = 32.0f;
            }
            float f8 = (float)(d0 * d3 + d2 * d4) * 100.0f;
            float f9 = (float)(d0 * d4 - d2 * d3) * 100.0f;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            float f10 = par1AbstractClientPlayer.bs + (par1AbstractClientPlayer.bt - par1AbstractClientPlayer.bs) * par2;
            f7 += ls.a((par1AbstractClientPlayer.Q + (par1AbstractClientPlayer.R - par1AbstractClientPlayer.Q) * par2) * 6.0f) * 32.0f * f10;
            if (par1AbstractClientPlayer.ah()) {
                f7 += 25.0f;
            }
            GL11.glRotatef((float)(6.0f + f8 / 2.0f + f7), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)(f9 / 2.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)(-f9 / 2.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.f.c(0.0625f);
            GL11.glPopMatrix();
        }
        if ((itemstack1 = par1AbstractClientPlayer.bn.h()) != null && event.renderItem) {
            float f11;
            boolean isBlock;
            IItemRenderer customRenderer;
            GL11.glPushMatrix();
            this.f.f.c(0.0625f);
            GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
            if (par1AbstractClientPlayer.bM != null) {
                itemstack1 = new ye(yc.F);
            }
            zj enumaction = null;
            if (par1AbstractClientPlayer.bq() > 0) {
                enumaction = itemstack1.o();
            }
            boolean is3D = (customRenderer = MinecraftForgeClient.getItemRenderer((ye)itemstack1, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.EQUIPPED)) != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            boolean bl4 = isBlock = itemstack1.d < aqz.s.length && itemstack1.d() == 0;
            if (is3D || isBlock && bfr.a(aqz.s[itemstack1.d].d())) {
                f11 = 0.5f;
                GL11.glTranslatef((float)0.0f, (float)0.1875f, (float)-0.3125f);
                GL11.glRotatef((float)20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)(-(f11 *= 0.75f)), (float)(-f11), (float)f11);
            } else if (itemstack1.d == yc.m.cv) {
                f11 = 0.625f;
                GL11.glTranslatef((float)0.0f, (float)0.125f, (float)0.3125f);
                GL11.glRotatef((float)-20.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)f11, (float)(-f11), (float)f11);
                GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            } else if (yc.g[itemstack1.d].n_()) {
                f11 = 0.625f;
                if (yc.g[itemstack1.d].o_()) {
                    GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)0.0f, (float)-0.125f, (float)0.0f);
                }
                if (par1AbstractClientPlayer.bq() > 0 && enumaction == zj.d) {
                    GL11.glTranslatef((float)0.05f, (float)0.0f, (float)-0.1f);
                    GL11.glRotatef((float)-50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)-10.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)-60.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
                GL11.glTranslatef((float)0.0f, (float)0.1875f, (float)0.0f);
                GL11.glScalef((float)f11, (float)(-f11), (float)f11);
                GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            } else {
                f11 = 0.375f;
                GL11.glTranslatef((float)0.25f, (float)0.1875f, (float)-0.1875f);
                GL11.glScalef((float)f11, (float)f11, (float)f11);
                GL11.glRotatef((float)60.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            }
            if (itemstack1.b().b()) {
                for (int j2 = 0; j2 < itemstack1.b().getRenderPasses(itemstack1.k()); ++j2) {
                    int k = itemstack1.b().a(itemstack1, j2);
                    float f13 = (float)(k >> 16 & 0xFF) / 255.0f;
                    float f12 = (float)(k >> 8 & 0xFF) / 255.0f;
                    f6 = (float)(k & 0xFF) / 255.0f;
                    GL11.glColor4f((float)f13, (float)f12, (float)f6, (float)1.0f);
                    this.b.f.a((of)par1AbstractClientPlayer, itemstack1, j2);
                }
            } else {
                int j3 = itemstack1.b().a(itemstack1, 0);
                float f14 = (float)(j3 >> 16 & 0xFF) / 255.0f;
                float f13 = (float)(j3 >> 8 & 0xFF) / 255.0f;
                float f12 = (float)(j3 & 0xFF) / 255.0f;
                GL11.glColor4f((float)f14, (float)f13, (float)f12, (float)1.0f);
                this.b.f.a((of)par1AbstractClientPlayer, itemstack1, 0);
            }
            GL11.glPopMatrix();
        }
        MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Specials.Post((uf)par1AbstractClientPlayer, this, par2));
    }

    protected void b(beu par1AbstractClientPlayer, float par2) {
        float f1 = 0.9375f;
        GL11.glScalef((float)f1, (float)f1, (float)f1);
    }

    protected void a(beu par1AbstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {
        atj scoreboard;
        ate scoreobjective;
        if (par10 < 100.0 && (scoreobjective = (scoreboard = par1AbstractClientPlayer.bM()).a(2)) != null) {
            atg score = scoreboard.a(par1AbstractClientPlayer.an(), scoreobjective);
            if (par1AbstractClientPlayer.bh()) {
                this.a((of)par1AbstractClientPlayer, score.c() + " " + scoreobjective.d(), par2, par4 - 1.5, par6, 64);
            } else {
                this.a((of)par1AbstractClientPlayer, score.c() + " " + scoreobjective.d(), par2, par4, par6, 64);
            }
            par4 += (double)((float)this.a().a * 1.15f * par9);
        }
        super.a((of)par1AbstractClientPlayer, par2, par4, par6, par8Str, par9, par10);
    }

    public void a(uf par1EntityPlayer) {
        float f2 = 1.0f;
        GL11.glColor3f((float)f2, (float)f2, (float)f2);
        this.f.p = 0.0f;
        this.f.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, par1EntityPlayer);
        this.f.f.a(0.0625f);
    }

    protected void a(beu par1AbstractClientPlayer, double par2, double par4, double par6) {
        if (par1AbstractClientPlayer.T() && par1AbstractClientPlayer.bh()) {
            super.a((of)par1AbstractClientPlayer, par2 + (double)par1AbstractClientPlayer.bE, par4 + (double)par1AbstractClientPlayer.cc, par6 + (double)par1AbstractClientPlayer.bF);
        } else {
            super.a((of)par1AbstractClientPlayer, par2, par4, par6);
        }
    }

    protected void a(beu par1AbstractClientPlayer, float par2, float par3, float par4) {
        if (par1AbstractClientPlayer.T() && par1AbstractClientPlayer.bh()) {
            GL11.glRotatef((float)par1AbstractClientPlayer.bC(), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)this.a((of)par1AbstractClientPlayer), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        } else {
            super.a((of)par1AbstractClientPlayer, par2, par3, par4);
        }
    }

    @Override
    protected void a(of par1EntityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
        this.a((beu)par1EntityLivingBase, par2, par4, par6, par8Str, par9, par10);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2) {
        this.b((beu)par1EntityLivingBase, par2);
    }

    @Override
    protected void c(of par1EntityLivingBase, int par2, float par3) {
        this.b((beu)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((beu)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((beu)par1EntityLivingBase, par2);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        this.a((beu)par1EntityLivingBase, par2, par3, par4);
    }

    @Override
    protected void a(of par1EntityLivingBase, double par2, double par4, double par6) {
        this.a((beu)par1EntityLivingBase, par2, par4, par6);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((beu)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((beu)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((beu)par1Entity, par2, par4, par6, par8, par9);
    }
}

