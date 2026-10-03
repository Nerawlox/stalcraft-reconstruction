/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  ali
 *  bdi
 *  bim
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.MinecraftForgeClient
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bfj {
    private static final bjo b = new bjo("textures/misc/enchanted_item_glint.png");
    private static final bjo c = new bjo("textures/map/map_background.png");
    private static final bjo d = new bjo("textures/misc/underwater.png");
    private atv e;
    private ye f;
    private float g;
    private float h;
    private bfr i = new bfr();
    public final avv a;
    private int j = -1;

    public bfj(atv par1Minecraft) {
        this.e = par1Minecraft;
        this.a = new avv(par1Minecraft.u, par1Minecraft.J());
    }

    public void a(of par1EntityLivingBase, ye par2ItemStack, int par3) {
        this.renderItem(par1EntityLivingBase, par2ItemStack, par3, IItemRenderer.ItemRenderType.EQUIPPED);
    }

    public void renderItem(of par1EntityLivingBase, ye par2ItemStack, int par3, IItemRenderer.ItemRenderType type) {
        IItemRenderer customRenderer;
        GL11.glPushMatrix();
        bim texturemanager = this.e.J();
        aqz block = null;
        if (par2ItemStack.b() instanceof zh && par2ItemStack.d < aqz.s.length) {
            block = aqz.s[par2ItemStack.d];
        }
        if ((customRenderer = MinecraftForgeClient.getItemRenderer((ye)par2ItemStack, (IItemRenderer.ItemRenderType)type)) != null) {
            texturemanager.a(texturemanager.a(par2ItemStack.d()));
            ForgeHooksClient.renderEquippedItem((IItemRenderer.ItemRenderType)type, (IItemRenderer)customRenderer, (bfr)this.i, (of)par1EntityLivingBase, (ye)par2ItemStack);
        } else if (block != null && par2ItemStack.d() == 0 && bfr.a(aqz.s[par2ItemStack.d].d())) {
            texturemanager.a(texturemanager.a(0));
            this.i.a(aqz.s[par2ItemStack.d], par2ItemStack.k(), 1.0f);
        } else {
            ms icon = par1EntityLivingBase.b(par2ItemStack, par3);
            if (icon == null) {
                GL11.glPopMatrix();
                return;
            }
            texturemanager.a(texturemanager.a(par2ItemStack.d()));
            bfq tessellator = bfq.a;
            float f2 = icon.c();
            float f1 = icon.d();
            float f22 = icon.e();
            float f3 = icon.f();
            float f4 = 0.0f;
            float f5 = 0.3f;
            GL11.glEnable((int)32826);
            GL11.glTranslatef((float)(-f4), (float)(-f5), (float)0.0f);
            float f6 = 1.5f;
            GL11.glScalef((float)f6, (float)f6, (float)f6);
            GL11.glRotatef((float)50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)-0.9375f, (float)-0.0625f, (float)0.0f);
            bfj.a(tessellator, f1, f22, f2, f3, icon.a(), icon.b(), 0.0625f);
            if (par2ItemStack.hasEffect(par3)) {
                GL11.glDepthFunc((int)514);
                GL11.glDisable((int)2896);
                texturemanager.a(b);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)768, (int)1);
                float f7 = 0.76f;
                GL11.glColor4f((float)(0.5f * f7), (float)(0.25f * f7), (float)(0.8f * f7), (float)1.0f);
                GL11.glMatrixMode((int)5890);
                GL11.glPushMatrix();
                float f8 = 0.125f;
                GL11.glScalef((float)f8, (float)f8, (float)f8);
                float f9 = (float)(atv.F() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef((float)f9, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-50.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                bfj.a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef((float)f8, (float)f8, (float)f8);
                f9 = (float)(atv.F() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef((float)(-f9), (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)10.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                bfj.a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode((int)5888);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)2896);
                GL11.glDepthFunc((int)515);
            }
            GL11.glDisable((int)32826);
        }
        GL11.glPopMatrix();
    }

    public static void a(bfq par0Tessellator, float par1, float par2, float par3, float par4, int par5, int par6, float par7) {
        float f9;
        float f8;
        float f7;
        int k;
        par0Tessellator.b();
        par0Tessellator.b(0.0f, 0.0f, 1.0f);
        par0Tessellator.a(0.0, 0.0, 0.0, par1, par4);
        par0Tessellator.a(1.0, 0.0, 0.0, par3, par4);
        par0Tessellator.a(1.0, 1.0, 0.0, par3, par2);
        par0Tessellator.a(0.0, 1.0, 0.0, par1, par2);
        par0Tessellator.a();
        par0Tessellator.b();
        par0Tessellator.b(0.0f, 0.0f, -1.0f);
        par0Tessellator.a(0.0, 1.0, 0.0f - par7, par1, par2);
        par0Tessellator.a(1.0, 1.0, 0.0f - par7, par3, par2);
        par0Tessellator.a(1.0, 0.0, 0.0f - par7, par3, par4);
        par0Tessellator.a(0.0, 0.0, 0.0f - par7, par1, par4);
        par0Tessellator.a();
        float f5 = 0.5f * (par1 - par3) / (float)par5;
        float f6 = 0.5f * (par4 - par2) / (float)par6;
        par0Tessellator.b();
        par0Tessellator.b(-1.0f, 0.0f, 0.0f);
        for (k = 0; k < par5; ++k) {
            f7 = (float)k / (float)par5;
            f8 = par1 + (par3 - par1) * f7 - f5;
            par0Tessellator.a(f7, 0.0, 0.0f - par7, f8, par4);
            par0Tessellator.a(f7, 0.0, 0.0, f8, par4);
            par0Tessellator.a(f7, 1.0, 0.0, f8, par2);
            par0Tessellator.a(f7, 1.0, 0.0f - par7, f8, par2);
        }
        par0Tessellator.a();
        par0Tessellator.b();
        par0Tessellator.b(1.0f, 0.0f, 0.0f);
        for (k = 0; k < par5; ++k) {
            f7 = (float)k / (float)par5;
            f8 = par1 + (par3 - par1) * f7 - f5;
            f9 = f7 + 1.0f / (float)par5;
            par0Tessellator.a(f9, 1.0, 0.0f - par7, f8, par2);
            par0Tessellator.a(f9, 1.0, 0.0, f8, par2);
            par0Tessellator.a(f9, 0.0, 0.0, f8, par4);
            par0Tessellator.a(f9, 0.0, 0.0f - par7, f8, par4);
        }
        par0Tessellator.a();
        par0Tessellator.b();
        par0Tessellator.b(0.0f, 1.0f, 0.0f);
        for (k = 0; k < par6; ++k) {
            f7 = (float)k / (float)par6;
            f8 = par4 + (par2 - par4) * f7 - f6;
            f9 = f7 + 1.0f / (float)par6;
            par0Tessellator.a(0.0, f9, 0.0, par1, f8);
            par0Tessellator.a(1.0, f9, 0.0, par3, f8);
            par0Tessellator.a(1.0, f9, 0.0f - par7, par3, f8);
            par0Tessellator.a(0.0, f9, 0.0f - par7, par1, f8);
        }
        par0Tessellator.a();
        par0Tessellator.b();
        par0Tessellator.b(0.0f, -1.0f, 0.0f);
        for (k = 0; k < par6; ++k) {
            f7 = (float)k / (float)par6;
            f8 = par4 + (par2 - par4) * f7 - f6;
            par0Tessellator.a(1.0, f7, 0.0, par3, f8);
            par0Tessellator.a(0.0, f7, 0.0, par1, f8);
            par0Tessellator.a(0.0, f7, 0.0f - par7, par1, f8);
            par0Tessellator.a(1.0, f7, 0.0f - par7, par3, f8);
        }
        par0Tessellator.a();
    }

    public void a(float par1) {
        float f6;
        float f8;
        float f7;
        float f1 = this.h + (this.g - this.h) * par1;
        bdi entityclientplayermp = this.e.h;
        float f2 = entityclientplayermp.D + (entityclientplayermp.B - entityclientplayermp.D) * par1;
        GL11.glPushMatrix();
        GL11.glRotatef((float)f2, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)(entityclientplayermp.C + (entityclientplayermp.A - entityclientplayermp.C) * par1), (float)0.0f, (float)1.0f, (float)0.0f);
        att.b();
        GL11.glPopMatrix();
        bdi entityplayersp = entityclientplayermp;
        float f3 = entityplayersp.j + (entityplayersp.h - entityplayersp.j) * par1;
        float f4 = entityplayersp.i + (entityplayersp.g - entityplayersp.i) * par1;
        GL11.glRotatef((float)((entityclientplayermp.B - f3) * 0.1f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)((entityclientplayermp.A - f4) * 0.1f), (float)0.0f, (float)1.0f, (float)0.0f);
        ye itemstack = this.f;
        float f5 = this.e.f.q(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w));
        f5 = 1.0f;
        int i2 = this.e.f.h(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w), 0);
        int j2 = i2 % 65536;
        int k = i2 / 65536;
        bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (itemstack != null) {
            i2 = yc.g[itemstack.d].a(itemstack, 0);
            f7 = (float)(i2 >> 16 & 0xFF) / 255.0f;
            f8 = (float)(i2 >> 8 & 0xFF) / 255.0f;
            f6 = (float)(i2 & 0xFF) / 255.0f;
            GL11.glColor4f((float)(f5 * f7), (float)(f5 * f8), (float)(f5 * f6), (float)1.0f);
        } else {
            GL11.glColor4f((float)f5, (float)f5, (float)f5, (float)1.0f);
        }
        if (itemstack != null && itemstack.b() instanceof yh) {
            float f11;
            GL11.glPushMatrix();
            float f12 = 0.8f;
            f7 = entityclientplayermp.k(par1);
            f8 = ls.a(f7 * (float)Math.PI);
            f6 = ls.a(ls.c(f7) * (float)Math.PI);
            GL11.glTranslatef((float)(-f6 * 0.4f), (float)(ls.a(ls.c(f7) * (float)Math.PI * 2.0f) * 0.2f), (float)(-f8 * 0.2f));
            f7 = 1.0f - f2 / 45.0f + 0.1f;
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            f7 = -ls.b(f7 * (float)Math.PI) * 0.5f + 0.5f;
            GL11.glTranslatef((float)0.0f, (float)(0.0f * f12 - (1.0f - f1) * 1.2f - f7 * 0.5f + 0.04f), (float)(-0.9f * f12));
            GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(f7 * -85.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glEnable((int)32826);
            this.e.J().a(entityclientplayermp.r());
            for (k = 0; k < 2; ++k) {
                int l2 = k * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef((float)-0.0f, (float)-0.6f, (float)(1.1f * (float)l2));
                GL11.glRotatef((float)(-45 * l2), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)59.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)(-65 * l2), (float)0.0f, (float)1.0f, (float)0.0f);
                bgm render = bgl.a.a((nn)this.e.h);
                bhj renderplayer = (bhj)render;
                f11 = 1.0f;
                GL11.glScalef((float)f11, (float)f11, (float)f11);
                renderplayer.a((uf)this.e.h);
                GL11.glPopMatrix();
            }
            f8 = entityclientplayermp.k(par1);
            f6 = ls.a(f8 * f8 * (float)Math.PI);
            float f9 = ls.a(ls.c(f8) * (float)Math.PI);
            GL11.glRotatef((float)(-f6 * 20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-f9 * 20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)(-f9 * 80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            float f10 = 0.38f;
            GL11.glScalef((float)f10, (float)f10, (float)f10);
            GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)-1.0f, (float)-1.0f, (float)0.0f);
            f11 = 0.015625f;
            GL11.glScalef((float)f11, (float)f11, (float)f11);
            this.e.J().a(c);
            bfq tessellator = bfq.a;
            GL11.glNormal3f((float)0.0f, (float)0.0f, (float)-1.0f);
            tessellator.b();
            int b0 = 7;
            tessellator.a(0 - b0, 128 + b0, 0.0, 0.0, 1.0);
            tessellator.a(128 + b0, 128 + b0, 0.0, 1.0, 1.0);
            tessellator.a(128 + b0, 0 - b0, 0.0, 1.0, 0.0);
            tessellator.a(0 - b0, 0 - b0, 0.0, 0.0, 0.0);
            tessellator.a();
            IItemRenderer custom = MinecraftForgeClient.getItemRenderer((ye)itemstack, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.FIRST_PERSON_MAP);
            ali mapdata = ((yh)((Object)itemstack.b())).a(itemstack, (abw)this.e.f);
            if (custom == null) {
                if (mapdata != null) {
                    this.a.a((uf)this.e.h, this.e.J(), mapdata);
                }
            } else {
                custom.renderItem(IItemRenderer.ItemRenderType.FIRST_PERSON_MAP, itemstack, new Object[]{this.e.h, this.e.J(), mapdata});
            }
            GL11.glPopMatrix();
        } else if (itemstack != null) {
            float f14;
            float f11;
            float f9;
            GL11.glPushMatrix();
            float f12 = 0.8f;
            if (entityclientplayermp.bq() > 0) {
                zj enumaction = itemstack.o();
                if (enumaction == zj.b || enumaction == zj.c) {
                    f8 = (float)entityclientplayermp.bq() - par1 + 1.0f;
                    f6 = 1.0f - f8 / (float)itemstack.n();
                    f9 = 1.0f - f6;
                    f9 = f9 * f9 * f9;
                    f9 = f9 * f9 * f9;
                    f9 = f9 * f9 * f9;
                    float f10 = 1.0f - f9;
                    GL11.glTranslatef((float)0.0f, (float)(ls.e(ls.b(f8 / 4.0f * (float)Math.PI) * 0.1f) * (float)((double)f6 > 0.2 ? 1 : 0)), (float)0.0f);
                    GL11.glTranslatef((float)(f10 * 0.6f), (float)(-f10 * 0.5f), (float)0.0f);
                    GL11.glRotatef((float)(f10 * 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(f10 * 10.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)(f10 * 30.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
            } else {
                f7 = entityclientplayermp.k(par1);
                f8 = ls.a(f7 * (float)Math.PI);
                f6 = ls.a(ls.c(f7) * (float)Math.PI);
                GL11.glTranslatef((float)(-f6 * 0.4f), (float)(ls.a(ls.c(f7) * (float)Math.PI * 2.0f) * 0.2f), (float)(-f8 * 0.2f));
            }
            GL11.glTranslatef((float)(0.7f * f12), (float)(-0.65f * f12 - (1.0f - f1) * 0.6f), (float)(-0.9f * f12));
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glEnable((int)32826);
            f7 = entityclientplayermp.k(par1);
            f8 = ls.a(f7 * f7 * (float)Math.PI);
            f6 = ls.a(ls.c(f7) * (float)Math.PI);
            GL11.glRotatef((float)(-f8 * 20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-f6 * 20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)(-f6 * 80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            f9 = 0.4f;
            GL11.glScalef((float)f9, (float)f9, (float)f9);
            if (entityclientplayermp.bq() > 0) {
                zj enumaction1 = itemstack.o();
                if (enumaction1 == zj.d) {
                    GL11.glTranslatef((float)-0.5f, (float)0.2f, (float)0.0f);
                    GL11.glRotatef((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                } else if (enumaction1 == zj.e) {
                    GL11.glRotatef((float)-18.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glRotatef((float)-12.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)-8.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glTranslatef((float)-0.9f, (float)0.2f, (float)0.0f);
                    f11 = (float)itemstack.n() - ((float)entityclientplayermp.bq() - par1 + 1.0f);
                    float f13 = f11 / 20.0f;
                    f13 = (f13 * f13 + f13 * 2.0f) / 3.0f;
                    if (f13 > 1.0f) {
                        f13 = 1.0f;
                    }
                    if (f13 > 0.1f) {
                        GL11.glTranslatef((float)0.0f, (float)(ls.a((f11 - 0.1f) * 1.3f) * 0.01f * (f13 - 0.1f)), (float)0.0f);
                    }
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(f13 * 0.1f));
                    GL11.glRotatef((float)-335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glRotatef((float)-50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glTranslatef((float)0.0f, (float)0.5f, (float)0.0f);
                    f14 = 1.0f + f13 * 0.2f;
                    GL11.glScalef((float)1.0f, (float)1.0f, (float)f14);
                    GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
                    GL11.glRotatef((float)50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
            }
            if (itemstack.b().o_()) {
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (itemstack.b().b()) {
                this.renderItem((of)entityclientplayermp, itemstack, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                for (int x2 = 1; x2 < itemstack.b().getRenderPasses(itemstack.k()); ++x2) {
                    int i1 = yc.g[itemstack.d].a(itemstack, x2);
                    f11 = (float)(i1 >> 16 & 0xFF) / 255.0f;
                    float f13 = (float)(i1 >> 8 & 0xFF) / 255.0f;
                    f14 = (float)(i1 & 0xFF) / 255.0f;
                    GL11.glColor4f((float)(f5 * f11), (float)(f5 * f13), (float)(f5 * f14), (float)1.0f);
                    this.renderItem((of)entityclientplayermp, itemstack, x2, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                }
            } else {
                this.renderItem((of)entityclientplayermp, itemstack, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
            }
            GL11.glPopMatrix();
        } else if (!entityclientplayermp.aj()) {
            GL11.glPushMatrix();
            float f12 = 0.8f;
            f7 = entityclientplayermp.k(par1);
            f8 = ls.a(f7 * (float)Math.PI);
            f6 = ls.a(ls.c(f7) * (float)Math.PI);
            GL11.glTranslatef((float)(-f6 * 0.3f), (float)(ls.a(ls.c(f7) * (float)Math.PI * 2.0f) * 0.4f), (float)(-f8 * 0.4f));
            GL11.glTranslatef((float)(0.8f * f12), (float)(-0.75f * f12 - (1.0f - f1) * 0.6f), (float)(-0.9f * f12));
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glEnable((int)32826);
            f7 = entityclientplayermp.k(par1);
            f8 = ls.a(f7 * f7 * (float)Math.PI);
            f6 = ls.a(ls.c(f7) * (float)Math.PI);
            GL11.glRotatef((float)(f6 * 70.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-f8 * 20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            this.e.J().a(entityclientplayermp.r());
            GL11.glTranslatef((float)-1.0f, (float)3.6f, (float)3.5f);
            GL11.glRotatef((float)120.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)200.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glScalef((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glTranslatef((float)5.6f, (float)0.0f, (float)0.0f);
            bgm render = bgl.a.a((nn)this.e.h);
            bhj renderplayer = (bhj)render;
            float f11 = 1.0f;
            GL11.glScalef((float)f11, (float)f11, (float)f11);
            renderplayer.a((uf)this.e.h);
            GL11.glPopMatrix();
        }
        GL11.glDisable((int)32826);
        att.a();
    }

    public void b(float par1) {
        GL11.glDisable((int)3008);
        if (this.e.h.af()) {
            this.d(par1);
        }
        if (this.e.h.U()) {
            int i2 = ls.c(this.e.h.u);
            int j2 = ls.c(this.e.h.v);
            int k = ls.c(this.e.h.w);
            int l2 = this.e.f.a(i2, j2, k);
            if (this.e.f.u(i2, j2, k)) {
                this.a(par1, aqz.s[l2].m(2));
            } else {
                for (int i1 = 0; i1 < 8; ++i1) {
                    int l1;
                    int k1;
                    float f1 = ((float)((i1 >> 0) % 2) - 0.5f) * this.e.h.O * 0.9f;
                    float f2 = ((float)((i1 >> 1) % 2) - 0.5f) * this.e.h.P * 0.2f;
                    float f3 = ((float)((i1 >> 2) % 2) - 0.5f) * this.e.h.O * 0.9f;
                    int j1 = ls.d((float)i2 + f1);
                    if (!this.e.f.u(j1, k1 = ls.d((float)j2 + f2), l1 = ls.d((float)k + f3))) continue;
                    l2 = this.e.f.a(j1, k1, l1);
                }
            }
            if (aqz.s[l2] != null) {
                this.a(par1, aqz.s[l2].m(2));
            }
        }
        if (this.e.h.a(akc.h)) {
            this.c(par1);
        }
        GL11.glEnable((int)3008);
    }

    private void a(float par1, ms par2Icon) {
        this.e.J().a(bik.b);
        bfq tessellator = bfq.a;
        float f1 = 0.1f;
        GL11.glColor4f((float)f1, (float)f1, (float)f1, (float)0.5f);
        GL11.glPushMatrix();
        float f2 = -1.0f;
        float f3 = 1.0f;
        float f4 = -1.0f;
        float f5 = 1.0f;
        float f6 = -0.5f;
        float f7 = par2Icon.c();
        float f8 = par2Icon.d();
        float f9 = par2Icon.e();
        float f10 = par2Icon.f();
        tessellator.b();
        tessellator.a(f2, f4, f6, f8, f10);
        tessellator.a(f3, f4, f6, f7, f10);
        tessellator.a(f3, f5, f6, f7, f9);
        tessellator.a(f2, f5, f6, f8, f9);
        tessellator.a();
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private void c(float par1) {
        this.e.J().a(d);
        bfq tessellator = bfq.a;
        float f1 = this.e.h.d(par1);
        GL11.glColor4f((float)f1, (float)f1, (float)f1, (float)0.5f);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glPushMatrix();
        float f2 = 4.0f;
        float f3 = -1.0f;
        float f4 = 1.0f;
        float f5 = -1.0f;
        float f6 = 1.0f;
        float f7 = -0.5f;
        float f8 = -this.e.h.A / 64.0f;
        float f9 = this.e.h.B / 64.0f;
        tessellator.b();
        tessellator.a(f3, f5, f7, f2 + f8, f2 + f9);
        tessellator.a(f4, f5, f7, 0.0f + f8, f2 + f9);
        tessellator.a(f4, f6, f7, 0.0f + f8, 0.0f + f9);
        tessellator.a(f3, f6, f7, f2 + f8, 0.0f + f9);
        tessellator.a();
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    private void d(float par1) {
        bfq tessellator = bfq.a;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        float f1 = 1.0f;
        for (int i2 = 0; i2 < 2; ++i2) {
            GL11.glPushMatrix();
            ms icon = aqz.aw.c(1);
            this.e.J().a(bik.b);
            float f2 = icon.c();
            float f3 = icon.d();
            float f4 = icon.e();
            float f5 = icon.f();
            float f6 = (0.0f - f1) / 2.0f;
            float f7 = f6 + f1;
            float f8 = 0.0f - f1 / 2.0f;
            float f9 = f8 + f1;
            float f10 = -0.5f;
            GL11.glTranslatef((float)((float)(-(i2 * 2 - 1)) * 0.24f), (float)-0.3f, (float)0.0f);
            GL11.glRotatef((float)((float)(i2 * 2 - 1) * 10.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            tessellator.b();
            tessellator.a(f6, f8, f10, f3, f5);
            tessellator.a(f7, f8, f10, f2, f5);
            tessellator.a(f7, f9, f10, f2, f4);
            tessellator.a(f6, f9, f10, f3, f4);
            tessellator.a();
            GL11.glPopMatrix();
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    public void a() {
        float f2;
        float f1;
        float f22;
        boolean flag;
        this.h = this.g;
        bdi entityclientplayermp = this.e.h;
        ye itemstack = entityclientplayermp.bn.h();
        boolean bl2 = flag = this.j == entityclientplayermp.bn.c && itemstack == this.f;
        if (this.f == null && itemstack == null) {
            flag = true;
        }
        if (itemstack != null && this.f != null && itemstack != this.f && itemstack.d == this.f.d && itemstack.k() == this.f.k()) {
            this.f = itemstack;
            flag = true;
        }
        if ((f22 = (f1 = flag ? 1.0f : 0.0f) - this.g) < -(f2 = 0.4f)) {
            f22 = -f2;
        }
        if (f22 > f2) {
            f22 = f2;
        }
        this.g += f22;
        if (this.g < 0.1f) {
            this.f = itemstack;
            this.j = entityclientplayermp.bn.c;
        }
    }

    public void b() {
        this.g = 0.0f;
    }

    public void c() {
        this.g = 0.0f;
    }
}

