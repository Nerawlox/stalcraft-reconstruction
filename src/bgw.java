/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bim
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  net.minecraftforge.client.ForgeHooksClient
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgw
extends bgm {
    private static final bjo h = new bjo("textures/misc/enchanted_item_glint.png");
    private bfr i = new bfr();
    private Random j = new Random();
    public boolean a = true;
    public float f;
    public static boolean g;

    public bgw() {
        this.d = 0.15f;
        this.e = 0.75f;
    }

    public void a(ss par1EntityItem, double par2, double par4, double par6, float par8, float par9) {
        this.b(par1EntityItem);
        this.j.setSeed(187L);
        ye itemstack = par1EntityItem.d();
        if (itemstack.b() != null) {
            GL11.glPushMatrix();
            float f2 = this.shouldBob() ? ls.a(((float)par1EntityItem.a + par9) / 10.0f + par1EntityItem.c) * 0.1f + 0.1f : 0.0f;
            float f3 = (((float)par1EntityItem.a + par9) / 20.0f + par1EntityItem.c) * 57.295776f;
            int b0 = this.getMiniBlockCount(itemstack);
            GL11.glTranslatef((float)((float)par2), (float)((float)par4 + f2), (float)((float)par6));
            GL11.glEnable((int)32826);
            aqz block = null;
            if (itemstack.d < aqz.s.length) {
                block = aqz.s[itemstack.d];
            }
            if (!ForgeHooksClient.renderEntityItem((ss)par1EntityItem, (ye)itemstack, (float)f2, (float)f3, (Random)this.j, (bim)this.b.e, (bfr)this.c)) {
                if (itemstack.d() == 0 && block != null && bfr.a(aqz.s[itemstack.d].d())) {
                    GL11.glRotatef((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
                    if (g) {
                        GL11.glScalef((float)1.25f, (float)1.25f, (float)1.25f);
                        GL11.glTranslatef((float)0.0f, (float)0.05f, (float)0.0f);
                        GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                    float f7 = 0.25f;
                    int j2 = block.d();
                    if (j2 == 1 || j2 == 19 || j2 == 12 || j2 == 2) {
                        f7 = 0.5f;
                    }
                    GL11.glScalef((float)f7, (float)f7, (float)f7);
                    for (int i2 = 0; i2 < b0; ++i2) {
                        float f5;
                        GL11.glPushMatrix();
                        if (i2 > 0) {
                            f5 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.2f / f7;
                            float f4 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.2f / f7;
                            float f6 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.2f / f7;
                            GL11.glTranslatef((float)f5, (float)f4, (float)f6);
                        }
                        f5 = 1.0f;
                        this.i.a(block, itemstack.k(), f5);
                        GL11.glPopMatrix();
                    }
                } else if (itemstack.b().b()) {
                    if (g) {
                        GL11.glScalef((float)0.5128205f, (float)0.5128205f, (float)0.5128205f);
                        GL11.glTranslatef((float)0.0f, (float)-0.05f, (float)0.0f);
                    } else {
                        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
                    }
                    for (int k = 0; k < itemstack.b().getRenderPasses(itemstack.k()); ++k) {
                        this.j.setSeed(187L);
                        ms icon = itemstack.b().getIcon(itemstack, k);
                        float f8 = 1.0f;
                        if (this.a) {
                            int i3 = yc.g[itemstack.d].a(itemstack, k);
                            float f5 = (float)(i3 >> 16 & 0xFF) / 255.0f;
                            float f4 = (float)(i3 >> 8 & 0xFF) / 255.0f;
                            float f6 = (float)(i3 & 0xFF) / 255.0f;
                            GL11.glColor4f((float)(f5 * f8), (float)(f4 * f8), (float)(f6 * f8), (float)1.0f);
                            this.renderDroppedItem(par1EntityItem, icon, b0, par9, f5 * f8, f4 * f8, f6 * f8, k);
                            continue;
                        }
                        this.renderDroppedItem(par1EntityItem, icon, b0, par9, 1.0f, 1.0f, 1.0f, k);
                    }
                } else {
                    if (g) {
                        GL11.glScalef((float)0.5128205f, (float)0.5128205f, (float)0.5128205f);
                        GL11.glTranslatef((float)0.0f, (float)-0.05f, (float)0.0f);
                    } else {
                        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
                    }
                    ms icon1 = itemstack.c();
                    if (this.a) {
                        int l2 = yc.g[itemstack.d].a(itemstack, 0);
                        float f8 = (float)(l2 >> 16 & 0xFF) / 255.0f;
                        float f9 = (float)(l2 >> 8 & 0xFF) / 255.0f;
                        float f5 = (float)(l2 & 0xFF) / 255.0f;
                        float f4 = 1.0f;
                        this.a(par1EntityItem, icon1, b0, par9, f8 * f4, f9 * f4, f5 * f4);
                    } else {
                        this.a(par1EntityItem, icon1, b0, par9, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
        }
    }

    protected bjo a(ss par1EntityItem) {
        return this.b.e.a(par1EntityItem.d().d());
    }

    private void a(ss par1EntityItem, ms par2Icon, int par3, float par4, float par5, float par6, float par7) {
        this.renderDroppedItem(par1EntityItem, par2Icon, par3, par4, par5, par6, par7, 0);
    }

    private void renderDroppedItem(ss par1EntityItem, ms par2Icon, int par3, float par4, float par5, float par6, float par7, int pass) {
        bfq tessellator = bfq.a;
        if (par2Icon == null) {
            bim texturemanager = atv.w().J();
            bjo resourcelocation = texturemanager.a(par1EntityItem.d().d());
            par2Icon = ((bik)texturemanager.b(resourcelocation)).b("missingno");
        }
        float f4 = par2Icon.c();
        float f5 = par2Icon.d();
        float f6 = par2Icon.e();
        float f7 = par2Icon.f();
        float f8 = 1.0f;
        float f9 = 0.5f;
        float f10 = 0.25f;
        if (this.b.l.j) {
            GL11.glPushMatrix();
            if (g) {
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            } else {
                GL11.glRotatef((float)((((float)par1EntityItem.a + par4) / 20.0f + par1EntityItem.c) * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            float f12 = 0.0625f;
            float f11 = 0.021875f;
            ye itemstack = par1EntityItem.d();
            int j2 = itemstack.b;
            int b0 = this.getMiniItemCount(itemstack);
            GL11.glTranslatef((float)(-f9), (float)(-f10), (float)(-((f12 + f11) * (float)b0 / 2.0f)));
            for (int k = 0; k < b0; ++k) {
                if (k > 0 && this.shouldSpreadItems()) {
                    float x2 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    float y2 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    float z2 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    GL11.glTranslatef((float)x2, (float)y2, (float)(f12 + f11));
                } else {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(f12 + f11));
                }
                if (itemstack.d() == 0) {
                    this.a(bik.b);
                } else {
                    this.a(bik.c);
                }
                GL11.glColor4f((float)par5, (float)par6, (float)par7, (float)1.0f);
                bfj.a(tessellator, f5, f6, f4, f7, par2Icon.a(), par2Icon.b(), f12);
                if (!itemstack.hasEffect(pass)) continue;
                GL11.glDepthFunc((int)514);
                GL11.glDisable((int)2896);
                this.b.e.a(h);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)768, (int)1);
                float f13 = 0.76f;
                GL11.glColor4f((float)(0.5f * f13), (float)(0.25f * f13), (float)(0.8f * f13), (float)1.0f);
                GL11.glMatrixMode((int)5890);
                GL11.glPushMatrix();
                float f14 = 0.125f;
                GL11.glScalef((float)f14, (float)f14, (float)f14);
                float f15 = (float)(atv.F() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef((float)f15, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-50.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                bfj.a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef((float)f14, (float)f14, (float)f14);
                f15 = (float)(atv.F() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef((float)(-f15), (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)10.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                bfj.a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glMatrixMode((int)5888);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)2896);
                GL11.glDepthFunc((int)515);
            }
            GL11.glPopMatrix();
        } else {
            for (int l2 = 0; l2 < par3; ++l2) {
                GL11.glPushMatrix();
                if (l2 > 0) {
                    float f11 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f16 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f17 = (this.j.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    GL11.glTranslatef((float)f11, (float)f16, (float)f17);
                }
                if (!g) {
                    GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                GL11.glColor4f((float)par5, (float)par6, (float)par7, (float)1.0f);
                tessellator.b();
                tessellator.b(0.0f, 1.0f, 0.0f);
                tessellator.a(0.0f - f9, 0.0f - f10, 0.0, f4, f7);
                tessellator.a(f8 - f9, 0.0f - f10, 0.0, f5, f7);
                tessellator.a(f8 - f9, 1.0f - f10, 0.0, f5, f6);
                tessellator.a(0.0f - f9, 1.0f - f10, 0.0, f4, f6);
                tessellator.a();
                GL11.glPopMatrix();
            }
        }
    }

    public void a(avi par1FontRenderer, bim par2TextureManager, ye par3ItemStack, int par4, int par5) {
        this.renderItemIntoGUI(par1FontRenderer, par2TextureManager, par3ItemStack, par4, par5, false);
    }

    public void renderItemIntoGUI(avi par1FontRenderer, bim par2TextureManager, ye par3ItemStack, int par4, int par5, boolean renderEffect) {
        aqz block;
        int k = par3ItemStack.d;
        int l2 = par3ItemStack.k();
        ms object = par3ItemStack.c();
        aqz aqz2 = block = k < aqz.s.length ? aqz.s[k] : null;
        if (par3ItemStack.d() == 0 && block != null && bfr.a(aqz.s[k].d())) {
            par2TextureManager.a(bik.b);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(par4 - 2), (float)(par5 + 3), (float)(-3.0f + this.f));
            GL11.glScalef((float)10.0f, (float)10.0f, (float)10.0f);
            GL11.glTranslatef((float)1.0f, (float)0.5f, (float)1.0f);
            GL11.glScalef((float)1.0f, (float)1.0f, (float)-1.0f);
            GL11.glRotatef((float)210.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            int i1 = yc.g[k].a(par3ItemStack, 0);
            float f2 = (float)(i1 >> 16 & 0xFF) / 255.0f;
            float f1 = (float)(i1 >> 8 & 0xFF) / 255.0f;
            float f22 = (float)(i1 & 0xFF) / 255.0f;
            if (this.a) {
                GL11.glColor4f((float)f2, (float)f1, (float)f22, (float)1.0f);
            }
            GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.i.c = this.a;
            this.i.a(block, l2, 1.0f);
            this.i.c = true;
            GL11.glPopMatrix();
        } else if (yc.g[k].b()) {
            GL11.glDisable((int)2896);
            for (int j1 = 0; j1 < yc.g[k].getRenderPasses(l2); ++j1) {
                par2TextureManager.a(par3ItemStack.d() == 0 ? bik.b : bik.c);
                ms icon = yc.g[k].getIcon(par3ItemStack, j1);
                int k1 = yc.g[k].a(par3ItemStack, j1);
                float f1 = (float)(k1 >> 16 & 0xFF) / 255.0f;
                float f2 = (float)(k1 >> 8 & 0xFF) / 255.0f;
                float f3 = (float)(k1 & 0xFF) / 255.0f;
                if (this.a) {
                    GL11.glColor4f((float)f1, (float)f2, (float)f3, (float)1.0f);
                }
                this.a(par4, par5, icon, 16, 16);
                if (!par3ItemStack.hasEffect(j1)) continue;
                this.renderEffect(par2TextureManager, par4, par5);
            }
            GL11.glEnable((int)2896);
        } else {
            GL11.glDisable((int)2896);
            bjo resourcelocation = par2TextureManager.a(par3ItemStack.d());
            par2TextureManager.a(resourcelocation);
            if (object == null) {
                object = ((bik)atv.w().J().b(resourcelocation)).b("missingno");
            }
            int i1 = yc.g[k].a(par3ItemStack, 0);
            float f3 = (float)(i1 >> 16 & 0xFF) / 255.0f;
            float f1 = (float)(i1 >> 8 & 0xFF) / 255.0f;
            float f2 = (float)(i1 & 0xFF) / 255.0f;
            if (this.a) {
                GL11.glColor4f((float)f3, (float)f1, (float)f2, (float)1.0f);
            }
            this.a(par4, par5, object, 16, 16);
            GL11.glEnable((int)2896);
            if (par3ItemStack.hasEffect(0)) {
                this.renderEffect(par2TextureManager, par4, par5);
            }
        }
        GL11.glEnable((int)2884);
    }

    private void renderEffect(bim manager, int x2, int y2) {
        GL11.glDepthFunc((int)516);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        manager.a(h);
        this.f -= 50.0f;
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)774, (int)774);
        GL11.glColor4f((float)0.5f, (float)0.25f, (float)0.8f, (float)1.0f);
        this.a(x2 * 431278612 + y2 * 32178161, x2 - 2, y2 - 2, 20, 20);
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
        this.f += 50.0f;
        GL11.glEnable((int)2896);
        GL11.glDepthFunc((int)515);
    }

    public void b(avi par1FontRenderer, bim par2TextureManager, ye par3ItemStack, int par4, int par5) {
        if (par3ItemStack != null && !ForgeHooksClient.renderInventoryItem((bfr)this.c, (bim)par2TextureManager, (ye)par3ItemStack, (boolean)this.a, (float)this.f, (float)par4, (float)par5)) {
            this.renderItemIntoGUI(par1FontRenderer, par2TextureManager, par3ItemStack, par4, par5, true);
        }
    }

    private void a(int par1, int par2, int par3, int par4, int par5) {
        for (int j1 = 0; j1 < 2; ++j1) {
            if (j1 == 0) {
                GL11.glBlendFunc((int)768, (int)1);
            }
            if (j1 == 1) {
                GL11.glBlendFunc((int)768, (int)1);
            }
            float f2 = 0.00390625f;
            float f1 = 0.00390625f;
            float f22 = (float)(atv.F() % (long)(3000 + j1 * 1873)) / (3000.0f + (float)(j1 * 1873)) * 256.0f;
            float f3 = 0.0f;
            bfq tessellator = bfq.a;
            float f4 = 4.0f;
            if (j1 == 1) {
                f4 = -1.0f;
            }
            tessellator.b();
            tessellator.a(par2 + 0, par3 + par5, this.f, (f22 + (float)par5 * f4) * f2, (f3 + (float)par5) * f1);
            tessellator.a(par2 + par4, par3 + par5, this.f, (f22 + (float)par4 + (float)par5 * f4) * f2, (f3 + (float)par5) * f1);
            tessellator.a(par2 + par4, par3 + 0, this.f, (f22 + (float)par4) * f2, (f3 + 0.0f) * f1);
            tessellator.a(par2 + 0, par3 + 0, this.f, (f22 + 0.0f) * f2, (f3 + 0.0f) * f1);
            tessellator.a();
        }
    }

    public void c(avi par1FontRenderer, bim par2TextureManager, ye par3ItemStack, int par4, int par5) {
        this.a(par1FontRenderer, par2TextureManager, par3ItemStack, par4, par5, null);
    }

    public void a(avi par1FontRenderer, bim par2TextureManager, ye par3ItemStack, int par4, int par5, String par6Str) {
        if (par3ItemStack != null) {
            if (par3ItemStack.b > 1 || par6Str != null) {
                String s1 = par6Str == null ? String.valueOf(par3ItemStack.b) : par6Str;
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                par1FontRenderer.a(s1, par4 + 19 - 2 - par1FontRenderer.a(s1), par5 + 6 + 3, 0xFFFFFF);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
            }
            if (par3ItemStack.i()) {
                int k = (int)Math.round(13.0 - (double)par3ItemStack.j() * 13.0 / (double)par3ItemStack.l());
                int l2 = (int)Math.round(255.0 - (double)par3ItemStack.j() * 255.0 / (double)par3ItemStack.l());
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                bfq tessellator = bfq.a;
                int i1 = 255 - l2 << 16 | l2 << 8;
                int j1 = (255 - l2) / 4 << 16 | 0x3F00;
                this.a(tessellator, par4 + 2, par5 + 13, 13, 2, 0);
                this.a(tessellator, par4 + 2, par5 + 13, 12, 1, j1);
                this.a(tessellator, par4 + 2, par5 + 13, k, 1, i1);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            }
        }
    }

    private void a(bfq par1Tessellator, int par2, int par3, int par4, int par5, int par6) {
        par1Tessellator.b();
        par1Tessellator.d(par6);
        par1Tessellator.a((double)(par2 + 0), (double)(par3 + 0), 0.0);
        par1Tessellator.a((double)(par2 + 0), (double)(par3 + par5), 0.0);
        par1Tessellator.a((double)(par2 + par4), (double)(par3 + par5), 0.0);
        par1Tessellator.a((double)(par2 + par4), (double)(par3 + 0), 0.0);
        par1Tessellator.a();
    }

    public void a(int par1, int par2, ms par3Icon, int par4, int par5) {
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + par5, this.f, par3Icon.c(), par3Icon.f());
        tessellator.a(par1 + par4, par2 + par5, this.f, par3Icon.d(), par3Icon.f());
        tessellator.a(par1 + par4, par2 + 0, this.f, par3Icon.d(), par3Icon.e());
        tessellator.a(par1 + 0, par2 + 0, this.f, par3Icon.c(), par3Icon.e());
        tessellator.a();
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((ss)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((ss)par1Entity, par2, par4, par6, par8, par9);
    }

    public boolean shouldSpreadItems() {
        return true;
    }

    public boolean shouldBob() {
        return true;
    }

    public byte getMiniBlockCount(ye stack) {
        byte ret = 1;
        if (stack.b > 1) {
            ret = 2;
        }
        if (stack.b > 5) {
            ret = 3;
        }
        if (stack.b > 20) {
            ret = 4;
        }
        if (stack.b > 40) {
            ret = 5;
        }
        return ret;
    }

    public byte getMiniItemCount(ye stack) {
        byte ret = 1;
        if (stack.b > 1) {
            ret = 2;
        }
        if (stack.b > 15) {
            ret = 3;
        }
        if (stack.b > 31) {
            ret = 4;
        }
        return ret;
    }
}

