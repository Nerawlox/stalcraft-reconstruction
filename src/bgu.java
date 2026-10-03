/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  com.google.common.collect.Maps
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.MinecraftForgeClient
 *  org.lwjgl.opengl.GL11
 *  wh
 */
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgu
extends bhe {
    protected bbj a;
    protected float f;
    protected bbj g;
    protected bbj h;
    private static final Map k = Maps.newHashMap();
    public static String[] l = new String[]{"leather", "chainmail", "iron", "diamond", "gold"};

    public bgu(bbj par1ModelBiped, float par2) {
        this(par1ModelBiped, par2, 1.0f);
    }

    public bgu(bbj par1ModelBiped, float par2, float par3) {
        super(par1ModelBiped, par2);
        this.a = par1ModelBiped;
        this.f = par3;
        this.b();
    }

    protected void b() {
        this.g = new bbj(1.0f);
        this.h = new bbj(0.5f);
    }

    @Deprecated
    public static bjo a(wh par0ItemArmor, int par1) {
        return bgu.a(par0ItemArmor, par1, null);
    }

    @Deprecated
    public static bjo a(wh par0ItemArmor, int par1, String par2Str) {
        String s1 = String.format("textures/models/armor/%s_layer_%d%s.png", l[par0ItemArmor.d], par1 == 2 ? 2 : 1, par2Str == null ? "" : String.format("_%s", par2Str));
        bjo resourcelocation = (bjo)k.get(s1);
        if (resourcelocation == null) {
            resourcelocation = new bjo(s1);
            k.put(s1, resourcelocation);
        }
        return resourcelocation;
    }

    public static bjo getArmorResource(nn entity, ye stack, int slot, String type) {
        wh item = (wh)stack.b();
        String s1 = String.format("textures/models/armor/%s_layer_%d%s.png", l[item.d], slot == 2 ? 2 : 1, type == null ? "" : String.format("_%s", type));
        bjo resourcelocation = (bjo)k.get(s1 = ForgeHooksClient.getArmorTexture((nn)entity, (ye)stack, (String)s1, (int)slot, (String)type));
        if (resourcelocation == null) {
            resourcelocation = new bjo(s1);
            k.put(s1, resourcelocation);
        }
        return resourcelocation;
    }

    protected int a(og par1EntityLiving, int par2, float par3) {
        yc item;
        ye itemstack = par1EntityLiving.o(3 - par2);
        if (itemstack != null && (item = itemstack.b()) instanceof wh) {
            wh itemarmor = (wh)item;
            this.a(bgu.getArmorResource(par1EntityLiving, itemstack, par2, null));
            bbj modelbiped = par2 == 2 ? this.h : this.g;
            modelbiped.c.j = par2 == 0;
            modelbiped.d.j = par2 == 0;
            modelbiped.e.j = par2 == 1 || par2 == 2;
            modelbiped.f.j = par2 == 1;
            modelbiped.g.j = par2 == 1;
            modelbiped.h.j = par2 == 2 || par2 == 3;
            modelbiped.i.j = par2 == 2 || par2 == 3;
            modelbiped = ForgeHooksClient.getArmorModel((of)par1EntityLiving, (ye)itemstack, (int)par2, (bbj)modelbiped);
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

    protected void b(og par1EntityLiving, int par2, float par3) {
        yc item;
        ye itemstack = par1EntityLiving.o(3 - par2);
        if (itemstack != null && (item = itemstack.b()) instanceof wh) {
            this.a(bgu.getArmorResource(par1EntityLiving, itemstack, par2, "overlay"));
            float f1 = 1.0f;
            GL11.glColor3f((float)f1, (float)f1, (float)f1);
        }
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        float f2 = 1.0f;
        GL11.glColor3f((float)f2, (float)f2, (float)f2);
        ye itemstack = par1EntityLiving.aZ();
        this.a(par1EntityLiving, itemstack);
        double d3 = par4 - (double)par1EntityLiving.N;
        if (par1EntityLiving.ah()) {
            d3 -= 0.125;
        }
        super.a(par1EntityLiving, par2, d3, par6, par8, par9);
        this.a.o = false;
        this.h.o = false;
        this.g.o = false;
        this.a.n = false;
        this.h.n = false;
        this.g.n = false;
        this.a.m = 0;
        this.h.m = 0;
        this.g.m = 0;
    }

    protected bjo a(og par1EntityLiving) {
        return null;
    }

    protected void a(og par1EntityLiving, ye par2ItemStack) {
        this.a.m = par2ItemStack != null ? 1 : 0;
        this.h.m = this.a.m;
        this.g.m = this.a.m;
        this.h.n = this.a.n = par1EntityLiving.ah();
        this.g.n = this.a.n;
    }

    protected void a(og par1EntityLiving, float par2) {
        float f2;
        boolean is3D;
        IItemRenderer customRenderer;
        float f1 = 1.0f;
        GL11.glColor3f((float)f1, (float)f1, (float)f1);
        super.c(par1EntityLiving, par2);
        ye itemstack = par1EntityLiving.aZ();
        ye itemstack1 = par1EntityLiving.o(3);
        if (itemstack1 != null) {
            GL11.glPushMatrix();
            this.a.c.c(0.0625f);
            customRenderer = MinecraftForgeClient.getItemRenderer((ye)itemstack1, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (itemstack1.b() instanceof zh) {
                if (is3D || bfr.a(aqz.s[itemstack1.d].d())) {
                    f2 = 0.625f;
                    GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)0.0f);
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glScalef((float)f2, (float)(-f2), (float)(-f2));
                }
                this.b.f.a(par1EntityLiving, itemstack1, 0);
            } else if (itemstack1.b().cv == yc.bS.cv) {
                f2 = 1.0625f;
                GL11.glScalef((float)f2, (float)(-f2), (float)(-f2));
                String s2 = "";
                if (itemstack1.p() && itemstack1.q().b("SkullOwner")) {
                    s2 = itemstack1.q().i("SkullOwner");
                }
                bjb.a.a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemstack1.k(), s2);
            }
            GL11.glPopMatrix();
        }
        if (itemstack != null) {
            GL11.glPushMatrix();
            if (this.i.s) {
                f2 = 0.5f;
                GL11.glTranslatef((float)0.0f, (float)0.625f, (float)0.0f);
                GL11.glRotatef((float)-20.0f, (float)-1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)f2, (float)f2, (float)f2);
            }
            this.a.f.c(0.0625f);
            GL11.glTranslatef((float)-0.0625f, (float)0.4375f, (float)0.0625f);
            customRenderer = MinecraftForgeClient.getItemRenderer((ye)itemstack, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl3 = is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (itemstack.b() instanceof zh && (is3D || bfr.a(aqz.s[itemstack.d].d()))) {
                f2 = 0.5f;
                GL11.glTranslatef((float)0.0f, (float)0.1875f, (float)-0.3125f);
                GL11.glRotatef((float)20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)(-(f2 *= 0.75f)), (float)(-f2), (float)f2);
            } else if (itemstack.d == yc.m.cv) {
                f2 = 0.625f;
                GL11.glTranslatef((float)0.0f, (float)0.125f, (float)0.3125f);
                GL11.glRotatef((float)-20.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            } else if (yc.g[itemstack.d].n_()) {
                f2 = 0.625f;
                if (yc.g[itemstack.d].o_()) {
                    GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)0.0f, (float)-0.125f, (float)0.0f);
                }
                this.c();
                GL11.glScalef((float)f2, (float)(-f2), (float)f2);
                GL11.glRotatef((float)-100.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            } else {
                f2 = 0.375f;
                GL11.glTranslatef((float)0.25f, (float)0.1875f, (float)-0.1875f);
                GL11.glScalef((float)f2, (float)f2, (float)f2);
                GL11.glRotatef((float)60.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            }
            this.b.f.a(par1EntityLiving, itemstack, 0);
            if (itemstack.b().b()) {
                for (int x2 = 1; x2 < itemstack.b().getRenderPasses(itemstack.k()); ++x2) {
                    this.b.f.a(par1EntityLiving, itemstack, x2);
                }
            }
            GL11.glPopMatrix();
        }
    }

    protected void c() {
        GL11.glTranslatef((float)0.0f, (float)0.1875f, (float)0.0f);
    }

    @Override
    protected void c(of par1EntityLivingBase, int par2, float par3) {
        this.b((og)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((og)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((og)par1EntityLivingBase, par2);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((og)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((og)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((og)par1Entity, par2, par4, par6, par8, par9);
    }
}

