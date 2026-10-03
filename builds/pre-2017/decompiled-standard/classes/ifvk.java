/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ifvk
extends ceev {
    public ModelBiped _a;
    public float _b;
    public ModelBiped _c;
    public ModelBiped _d;
    public static final Map _e = Maps.newHashMap();
    public static String[] _f = new String[]{"leather", "chainmail", "iron", "diamond", "gold"};

    public ifvk(ModelBiped modelBiped, float f) {
        this(modelBiped, f, 1.0f);
    }

    public ifvk(ModelBiped modelBiped, float f, float f2) {
        super(modelBiped, f);
        this._a = modelBiped;
        this._b = f2;
        this._a();
    }

    public void _a() {
        this._c = new ModelBiped(1.0f);
        this._d = new ModelBiped(0.5f);
    }

    @Deprecated
    public static ResourceLocation _a(lpno lpno2, int n) {
        return ifvk._a(lpno2, n, null);
    }

    @Deprecated
    public static ResourceLocation _a(lpno lpno2, int n, String string) {
        String string2 = String.format("textures/models/armor/%s_layer_%d%s.png", _f[lpno2.field_77880_c], n == 2 ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocation resourceLocation = (ResourceLocation)_e.get(string2);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string2);
            _e.put(string2, resourceLocation);
        }
        return resourceLocation;
    }

    public static ResourceLocation _a(Entity entity, cvzo cvzo2, int n, String string) {
        lpno lpno2 = (lpno)cvzo2._a();
        String string2 = String.format("textures/models/armor/%s_layer_%d%s.png", _f[lpno2.field_77880_c], n == 2 ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocation resourceLocation = (ResourceLocation)_e.get(string2 = ForgeHooksClient.getArmorTexture(entity, cvzo2, string2, n, string));
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string2);
            _e.put(string2, resourceLocation);
        }
        return resourceLocation;
    }

    public int _a(EntityLiving entityLiving, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = entityLiving.func_130225_q(3 - n);
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            lpno lpno2 = (lpno)tgdv2;
            this.func_110776_a(ifvk._a(entityLiving, cvzo2, n, null));
            ModelBiped modelBiped = n == 2 ? this._d : this._c;
            modelBiped.field_78116_c.field_78806_j = n == 0;
            modelBiped.field_78114_d.field_78806_j = n == 0;
            modelBiped.field_78115_e.field_78806_j = n == 1 || n == 2;
            modelBiped.field_78112_f.field_78806_j = n == 1;
            modelBiped.field_78113_g.field_78806_j = n == 1;
            modelBiped.field_78123_h.field_78806_j = n == 2 || n == 3;
            modelBiped.field_78124_i.field_78806_j = n == 2 || n == 3;
            modelBiped = ForgeHooksClient.getArmorModel(entityLiving, cvzo2, n, modelBiped);
            this.func_77042_a(modelBiped);
            modelBiped.field_78095_p = this.field_77045_g.field_78095_p;
            modelBiped.field_78093_q = this.field_77045_g.field_78093_q;
            modelBiped.field_78091_s = this.field_77045_g.field_78091_s;
            float f2 = 1.0f;
            int n2 = lpno2.func_82814_b(cvzo2);
            if (n2 != -1) {
                float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n2 & 0xFF) / 255.0f;
                GL11.glColor3f(f2 * f3, f2 * f4, f2 * f5);
                if (cvzo2._y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f(f2, f2, f2);
            if (cvzo2._y()) {
                return 15;
            }
            return 1;
        }
        return -1;
    }

    public void _b(EntityLiving entityLiving, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = entityLiving.func_130225_q(3 - n);
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            this.func_110776_a(ifvk._a(entityLiving, cvzo2, n, "overlay"));
            float f2 = 1.0f;
            GL11.glColor3f(f2, f2, f2);
        }
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        float f3 = 1.0f;
        GL11.glColor3f(f3, f3, f3);
        cvzo cvzo2 = entityLiving.func_70694_bm();
        this._a(entityLiving, cvzo2);
        double d4 = d2 - (double)entityLiving.field_70129_M;
        if (entityLiving.func_70093_af()) {
            d4 -= 0.125;
        }
        super.func_77031_a(entityLiving, d, d4, d3, f, f2);
        this._a.field_78118_o = false;
        this._d.field_78118_o = false;
        this._c.field_78118_o = false;
        this._a.field_78117_n = false;
        this._d.field_78117_n = false;
        this._c.field_78117_n = false;
        this._a.field_78120_m = 0;
        this._d.field_78120_m = 0;
        this._c.field_78120_m = 0;
    }

    public ResourceLocation _a(EntityLiving entityLiving) {
        return null;
    }

    public void _a(EntityLiving entityLiving, cvzo cvzo2) {
        this._a.field_78120_m = cvzo2 != null ? 1 : 0;
        this._d.field_78120_m = this._a.field_78120_m;
        this._c.field_78120_m = this._a.field_78120_m;
        this._d.field_78117_n = this._a.field_78117_n = entityLiving.func_70093_af();
        this._c.field_78117_n = this._a.field_78117_n;
    }

    public void _a(EntityLiving entityLiving, float f) {
        float f2;
        boolean bl;
        IItemRenderer iItemRenderer;
        float f3 = 1.0f;
        GL11.glColor3f(f3, f3, f3);
        super.func_77029_c(entityLiving, f);
        cvzo cvzo2 = entityLiving.func_70694_bm();
        cvzo cvzo3 = entityLiving.func_130225_q(3);
        if (cvzo3 != null) {
            GL11.glPushMatrix();
            this._a.field_78116_c.func_78794_c(0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo3, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo3, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (cvzo3._a() instanceof mbpd) {
                if (bl || htvc._a(twgu.field_71973_m[cvzo3._d].func_71857_b())) {
                    f2 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f2, -f2, -f2);
                }
                this.field_76990_c._h.func_78443_a(entityLiving, cvzo3, 0);
            } else if (cvzo3._a().field_77779_bT == tgdv.field_82799_bQ.field_77779_bT) {
                f2 = 1.0625f;
                GL11.glScalef(f2, -f2, -f2);
                String string = "";
                if (cvzo3._p() && cvzo3._q()._c("SkullOwner")) {
                    string = cvzo3._q()._j("SkullOwner");
                }
                bsiw._e._a(-0.5f, 0.0f, -0.5f, 1, 180.0f, cvzo3._j(), string);
            }
            GL11.glPopMatrix();
        }
        if (cvzo2 != null) {
            GL11.glPushMatrix();
            if (this.field_77045_g.field_78091_s) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f2, f2, f2);
            }
            this._a.field_78112_f.func_78794_c(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl3 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (cvzo2._a() instanceof mbpd && (bl || htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b()))) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
            } else if (cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
                f2 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[cvzo2._d].func_77662_d()) {
                f2 = 0.625f;
                if (tgdv.field_77698_e[cvzo2._d].func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this._b();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f2 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.field_76990_c._h.func_78443_a(entityLiving, cvzo2, 0);
            if (cvzo2._a().func_77623_v()) {
                for (int i = 1; i < cvzo2._a().getRenderPasses(cvzo2._j()); ++i) {
                    this.field_76990_c._h.func_78443_a(entityLiving, cvzo2, i);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void _b() {
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
    }

    public void _a(EntityLivingBase entityLivingBase, int n, float f) {
        this._b((EntityLiving)entityLivingBase, n, f);
    }

    @Override
    public int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityLiving)entityLivingBase, n, f);
    }

    @Override
    public void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityLiving)entityLivingBase, f);
    }

    @Override
    public void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this.func_77031_a((EntityLiving)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityLiving)entity);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_77031_a((EntityLiving)entity, d, d2, d3, f, f2);
    }
}

