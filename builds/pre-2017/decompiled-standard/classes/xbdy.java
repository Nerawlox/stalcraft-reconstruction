/*
 * Decompiled with CFR 0.152.
 */
import api.player.model.ModelPlayer;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.stalker.player.ugqx;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class xbdy
extends msev {
    public static final ResourceLocation field_110826_a = new ResourceLocation("textures/entity/steve.png");
    public ModelBiped field_77109_a;
    public ModelBiped field_77108_b;
    public ModelBiped field_77111_i;
    private static Field entityRenderMap;
    private static boolean initializedByForgeManager;
    private static RenderPlayerEvent.Specials.Pre currentRenderSpecialsPre;
    public final RenderPlayerAPI renderPlayerAPI = RenderPlayerAPI.create(this);

    public xbdy() {
        super(new ModelPlayer(0.0f), 0.5f);
        RenderPlayerAPI.beforeLocalConstructing(this);
        this.field_77109_a = (ModelBiped)this.field_77045_g;
        this.field_77108_b = new ModelPlayer(1.0f);
        this.field_77111_i = new ModelPlayer(0.5f);
        if (Thread.currentThread().getStackTrace()[2].getClassName().equals(gqqu.class.getName())) {
            initializedByForgeManager = true;
        }
        RenderPlayerAPI.afterLocalConstructing(this);
    }

    public final RenderPlayerBase getRenderPlayerBase(String string) {
        if (this.renderPlayerAPI != null) {
            return this.renderPlayerAPI.getRenderPlayerBase(string);
        }
        return null;
    }

    public final Set<String> getRenderPlayerBaseIds(String string) {
        Set<String> set = null;
        set = this.renderPlayerAPI != null ? this.renderPlayerAPI.getRenderPlayerBaseIds() : Collections.emptySet();
        return set;
    }

    public Object dynamic(String string, Object[] objectArray) {
        if (this.renderPlayerAPI != null) {
            return this.renderPlayerAPI.dynamic(string, objectArray);
        }
        return null;
    }

    @Override
    public boolean func_110813_b(EntityLivingBase entityLivingBase) {
        boolean bl = this.renderPlayerAPI != null && this.renderPlayerAPI.isDoRenderLabelModded ? RenderPlayerAPI.doRenderLabel(this, entityLivingBase) : super.func_110813_b(entityLivingBase);
        return bl;
    }

    public final boolean realDoRenderLabel(EntityLivingBase entityLivingBase) {
        return this.func_110813_b(entityLivingBase);
    }

    public final boolean superDoRenderLabel(EntityLivingBase entityLivingBase) {
        return super.func_110813_b(entityLivingBase);
    }

    public final boolean localDoRenderLabel(EntityLivingBase entityLivingBase) {
        return super.func_110813_b(entityLivingBase);
    }

    @Override
    public void func_76979_b(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isDoRenderShadowAndFireModded) {
            RenderPlayerAPI.doRenderShadowAndFire(this, entity, d, d2, d3, f, f2);
        } else {
            super.func_76979_b(entity, d, d2, d3, f, f2);
        }
    }

    public final void superDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        super.func_76979_b(entity, d, d2, d3, f, f2);
    }

    public final void localDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        super.func_76979_b(entity, d, d2, d3, f, f2);
    }

    @Override
    public int func_77030_a(EntityLivingBase entityLivingBase, float f, float f2) {
        int n = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetColorMultiplierModded ? RenderPlayerAPI.getColorMultiplier(this, entityLivingBase, f, f2) : super.func_77030_a(entityLivingBase, f, f2);
        return n;
    }

    public final int realGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return this.func_77030_a(entityLivingBase, f, f2);
    }

    public final int superGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return super.func_77030_a(entityLivingBase, f, f2);
    }

    public final int localGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return super.func_77030_a(entityLivingBase, f, f2);
    }

    @Override
    public float func_77037_a(EntityLivingBase entityLivingBase) {
        float f = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetDeathMaxRotationModded ? RenderPlayerAPI.getDeathMaxRotation(this, entityLivingBase) : super.func_77037_a(entityLivingBase);
        return f;
    }

    public final float realGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return this.func_77037_a(entityLivingBase);
    }

    public final float superGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return super.func_77037_a(entityLivingBase);
    }

    public final float localGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return super.func_77037_a(entityLivingBase);
    }

    @Override
    public qncw func_76983_a() {
        qncw qncw2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetFontRendererFromRenderManagerModded ? RenderPlayerAPI.getFontRendererFromRenderManager(this) : super.func_76983_a();
        return qncw2;
    }

    public final qncw superGetFontRendererFromRenderManager() {
        return super.func_76983_a();
    }

    public final qncw localGetFontRendererFromRenderManager() {
        return super.func_76983_a();
    }

    public ResourceLocation func_110817_a(AbstractClientPlayer abstractClientPlayer) {
        ResourceLocation resourceLocation = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetResourceLocationFromPlayerModded ? RenderPlayerAPI.getResourceLocationFromPlayer(this, abstractClientPlayer) : this.localGetResourceLocationFromPlayer(abstractClientPlayer);
        return resourceLocation;
    }

    public final ResourceLocation realGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        return this.func_110817_a(abstractClientPlayer);
    }

    public final ResourceLocation localGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.func_110306_p();
    }

    @Override
    public float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        float f2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isHandleRotationFloatModded ? RenderPlayerAPI.handleRotationFloat(this, entityLivingBase, f) : super.func_77044_a(entityLivingBase, f);
        return f2;
    }

    public final float realHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return this.func_77044_a(entityLivingBase, f);
    }

    public final float superHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return super.func_77044_a(entityLivingBase, f);
    }

    public final float localHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return super.func_77044_a(entityLivingBase, f);
    }

    @Override
    public int func_77035_b(EntityLivingBase entityLivingBase, int n, float f) {
        int n2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isInheritRenderPassModded ? RenderPlayerAPI.inheritRenderPass(this, entityLivingBase, n, f) : super.func_77035_b(entityLivingBase, n, f);
        return n2;
    }

    public final int realInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_77035_b(entityLivingBase, n, f);
    }

    public final int superInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.func_77035_b(entityLivingBase, n, f);
    }

    public final int localInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.func_77035_b(entityLivingBase, n, f);
    }

    @Override
    public void func_110776_a(ResourceLocation resourceLocation) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isLoadTextureModded) {
            RenderPlayerAPI.loadTexture(this, resourceLocation);
        } else {
            super.func_110776_a(resourceLocation);
        }
    }

    public final void realLoadTexture(ResourceLocation resourceLocation) {
        this.func_110776_a(resourceLocation);
    }

    public final void superLoadTexture(ResourceLocation resourceLocation) {
        super.func_110776_a(resourceLocation);
    }

    public final void localLoadTexture(ResourceLocation resourceLocation) {
        super.func_110776_a(resourceLocation);
    }

    @Override
    public void func_110777_b(Entity entity) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isLoadTextureOfEntityModded) {
            RenderPlayerAPI.loadTextureOfEntity(this, entity);
        } else {
            super.func_110777_b(entity);
        }
    }

    public final void realLoadTextureOfEntity(Entity entity) {
        this.func_110777_b(entity);
    }

    public final void superLoadTextureOfEntity(Entity entity) {
        super.func_110777_b(entity);
    }

    public final void localLoadTextureOfEntity(Entity entity) {
        super.func_110777_b(entity);
    }

    @Override
    public void func_77033_b(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isPassSpecialRenderModded) {
            RenderPlayerAPI.passSpecialRender(this, entityLivingBase, d, d2, d3);
        } else {
            super.func_77033_b(entityLivingBase, d, d2, d3);
        }
    }

    public final void realPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.func_77033_b(entityLivingBase, d, d2, d3);
    }

    public final void superPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.func_77033_b(entityLivingBase, d, d2, d3);
    }

    public final void localPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.func_77033_b(entityLivingBase, d, d2, d3);
    }

    @Override
    public void func_85093_e(EntityLivingBase entityLivingBase, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderArrowsStuckInEntityModded) {
            RenderPlayerAPI.renderArrowsStuckInEntity(this, entityLivingBase, f);
        } else {
            super.func_85093_e(entityLivingBase, f);
        }
    }

    public final void realRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        this.func_85093_e(entityLivingBase, f);
    }

    public final void superRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        super.func_85093_e(entityLivingBase, f);
    }

    public final void localRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        super.func_85093_e(entityLivingBase, f);
    }

    public void func_82441_a(EntityPlayer entityPlayer) {
        ugqx._a(this, entityPlayer);
    }

    public final void localRenderFirstPersonArm(EntityPlayer entityPlayer) {
        float f = 1.0f;
        GL11.glColor3f(f, f, f);
        this.field_77109_a.field_78095_p = 0.0f;
        this.field_77109_a.func_78087_a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, entityPlayer);
        this.field_77109_a.field_78112_f.func_78785_a(0.0625f);
    }

    @Override
    public void func_77038_a(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderLivingLabelModded) {
            RenderPlayerAPI.renderLivingLabel(this, entityLivingBase, string, d, d2, d3, n);
        } else {
            super.func_77038_a(entityLivingBase, string, d, d2, d3, n);
        }
    }

    public final void realRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        this.func_77038_a(entityLivingBase, string, d, d2, d3, n);
    }

    public final void superRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        super.func_77038_a(entityLivingBase, string, d, d2, d3, n);
    }

    public final void localRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        super.func_77038_a(entityLivingBase, string, d, d2, d3, n);
    }

    @Override
    public void func_77036_a(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderModelModded) {
            RenderPlayerAPI.renderModel(this, entityLivingBase, f, f2, f3, f4, f5, f6);
        } else {
            super.func_77036_a(entityLivingBase, f, f2, f3, f4, f5, f6);
        }
    }

    public final void realRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_77036_a(entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    public final void superRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_77036_a(entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    public final void localRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_77036_a(entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    public void func_130009_a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerModded) {
            RenderPlayerAPI.renderPlayer(this, abstractClientPlayer, d, d2, d3, f, f2);
        } else {
            this.localRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        }
    }

    public final void localRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        if (MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Pre(abstractClientPlayer, this, f2))) {
            return;
        }
        float f3 = 1.0f;
        GL11.glColor3f(f3, f3, f3);
        cvzo cvzo2 = abstractClientPlayer.field_71071_by._a();
        this.field_77109_a.field_78120_m = cvzo2 != null ? 1 : 0;
        this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m;
        this.field_77108_b.field_78120_m = this.field_77109_a.field_78120_m;
        if (cvzo2 != null && abstractClientPlayer.func_71052_bv() > 0) {
            bsre bsre2 = cvzo2._o();
            if (bsre2 == bsre._d) {
                this.field_77109_a.field_78120_m = 3;
                this.field_77111_i.field_78120_m = 3;
                this.field_77108_b.field_78120_m = 3;
            } else if (bsre2 == bsre._e) {
                this.field_77109_a.field_78118_o = true;
                this.field_77111_i.field_78118_o = true;
                this.field_77108_b.field_78118_o = true;
            }
        }
        this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = abstractClientPlayer.func_70093_af();
        this.field_77108_b.field_78117_n = this.field_77109_a.field_78117_n;
        double d4 = d2 - (double)abstractClientPlayer.field_70129_M;
        if (abstractClientPlayer.func_70093_af() && !(abstractClientPlayer instanceof EntityPlayerSP)) {
            d4 -= 0.125;
        }
        super.func_130000_a(abstractClientPlayer, d, d4, d3, f, f2);
        this.field_77109_a.field_78118_o = false;
        this.field_77111_i.field_78118_o = false;
        this.field_77108_b.field_78118_o = false;
        this.field_77109_a.field_78117_n = false;
        this.field_77111_i.field_78117_n = false;
        this.field_77108_b.field_78117_n = false;
        this.field_77109_a.field_78120_m = 0;
        this.field_77111_i.field_78120_m = 0;
        this.field_77108_b.field_78120_m = 0;
        MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Post(abstractClientPlayer, this, f2));
    }

    public void func_96450_a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerNameAndScoreLabelModded) {
            RenderPlayerAPI.renderPlayerNameAndScoreLabel(this, abstractClientPlayer, d, d2, d3, string, f, d4);
        } else {
            this.localRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        }
    }

    public final void realRenderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        this.func_96450_a(abstractClientPlayer, d, d2, d3, string, f, d4);
    }

    public final void localRenderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        fojy fojy2;
        igri igri2;
        if (d4 < 100.0 && (igri2 = (fojy2 = abstractClientPlayer.func_96123_co())._a(2)) != null) {
            cwdc cwdc2 = fojy2._a(abstractClientPlayer.func_70023_ak(), igri2);
            if (abstractClientPlayer.func_70608_bn()) {
                this.func_77038_a(abstractClientPlayer, cwdc2._b() + " " + igri2._d(), d, d2 - 1.5, d3, 64);
            } else {
                this.func_77038_a(abstractClientPlayer, cwdc2._b() + " " + igri2._d(), d, d2, d3, 64);
            }
            d2 += (double)((float)this.func_76983_a()._c * 1.15f * f);
        }
        super.func_96449_a(abstractClientPlayer, d, d2, d3, string, f, d4);
    }

    public void func_77104_b(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerScaleModded) {
            RenderPlayerAPI.renderPlayerScale(this, abstractClientPlayer, f);
        } else {
            this.localRenderPlayerScale(abstractClientPlayer, f);
        }
    }

    public final void realRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        this.func_77104_b(abstractClientPlayer, f);
    }

    public final void localRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        float f2 = 0.9375f;
        GL11.glScalef(f2, f2, f2);
    }

    public void func_77105_b(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerSleepModded) {
            RenderPlayerAPI.renderPlayerSleep(this, abstractClientPlayer, d, d2, d3);
        } else {
            this.localRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
        }
    }

    public final void realRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        this.func_77105_b(abstractClientPlayer, d, d2, d3);
    }

    public final void localRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (abstractClientPlayer.func_70089_S() && abstractClientPlayer.func_70608_bn()) {
            super.func_77039_a(abstractClientPlayer, d + (double)abstractClientPlayer.field_71079_bU, d2 + (double)abstractClientPlayer.field_71082_cx, d3 + (double)abstractClientPlayer.field_71089_bV);
        } else {
            super.func_77039_a(abstractClientPlayer, d, d2, d3);
        }
    }

    public void func_77100_a(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialsModded) {
            RenderPlayerAPI.renderSpecials(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecials(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        this.func_77100_a(abstractClientPlayer, f);
    }

    public final void localRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        currentRenderSpecialsPre = new RenderPlayerEvent.Specials.Pre(abstractClientPlayer, this, f);
        if (MinecraftForge.EVENT_BUS.post(currentRenderSpecialsPre)) {
            return;
        }
        float f2 = 1.0f;
        GL11.glColor3f(f2, f2, f2);
        super.func_77029_c(abstractClientPlayer, f);
        this.func_85093_e(abstractClientPlayer, f);
        this.renderSpecialHeadArmor(abstractClientPlayer, f);
        this.renderSpecialHeadEars(abstractClientPlayer, f);
        this.renderSpecialCloak(abstractClientPlayer, f);
        this.renderSpecialItemInHand(abstractClientPlayer, f);
        MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(abstractClientPlayer, this, f));
        currentRenderSpecialsPre = null;
    }

    @Override
    public float func_77040_d(EntityLivingBase entityLivingBase, float f) {
        float f2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSwingProgressModded ? RenderPlayerAPI.renderSwingProgress(this, entityLivingBase, f) : super.func_77040_d(entityLivingBase, f);
        return f2;
    }

    public final float realRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return this.func_77040_d(entityLivingBase, f);
    }

    public final float superRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return super.func_77040_d(entityLivingBase, f);
    }

    public final float localRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return super.func_77040_d(entityLivingBase, f);
    }

    public void func_77102_a(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRotatePlayerModded) {
            RenderPlayerAPI.rotatePlayer(this, abstractClientPlayer, f, f2, f3);
        } else {
            this.localRotatePlayer(abstractClientPlayer, f, f2, f3);
        }
    }

    public final void realRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.func_77102_a(abstractClientPlayer, f, f2, f3);
    }

    public final void localRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (abstractClientPlayer.func_70089_S() && abstractClientPlayer.func_70608_bn()) {
            GL11.glRotatef(abstractClientPlayer.func_71051_bG(), 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.func_77037_a(abstractClientPlayer), 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
        } else {
            super.func_77043_a(abstractClientPlayer, f, f2, f3);
        }
    }

    public int func_77107_a(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        int n2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isSetArmorModelModded ? RenderPlayerAPI.setArmorModel(this, abstractClientPlayer, n, f) : this.localSetArmorModel(abstractClientPlayer, n, f);
        return n2;
    }

    public final int realSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        return this.func_77107_a(abstractClientPlayer, n, f);
    }

    public final int localSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = abstractClientPlayer.field_71071_by._e(3 - n);
        RenderPlayerEvent.SetArmorModel setArmorModel = new RenderPlayerEvent.SetArmorModel(abstractClientPlayer, this, 3 - n, f, cvzo2);
        MinecraftForge.EVENT_BUS.post(setArmorModel);
        if (setArmorModel.result != -1) {
            return setArmorModel.result;
        }
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            lpno lpno2 = (lpno)tgdv2;
            this.func_110776_a(ifvk._a(abstractClientPlayer, cvzo2, n, null));
            ModelBiped modelBiped = n == 2 ? this.field_77111_i : this.field_77108_b;
            modelBiped.field_78116_c.field_78806_j = n == 0;
            modelBiped.field_78114_d.field_78806_j = n == 0;
            modelBiped.field_78115_e.field_78806_j = n == 1 || n == 2;
            modelBiped.field_78112_f.field_78806_j = n == 1;
            modelBiped.field_78113_g.field_78806_j = n == 1;
            modelBiped.field_78123_h.field_78806_j = n == 2 || n == 3;
            modelBiped.field_78124_i.field_78806_j = n == 2 || n == 3;
            modelBiped = ForgeHooksClient.getArmorModel(abstractClientPlayer, cvzo2, n, modelBiped);
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

    public void func_130220_b(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isSetPassArmorModelModded) {
            RenderPlayerAPI.setPassArmorModel(this, abstractClientPlayer, n, f);
        } else {
            this.localSetPassArmorModel(abstractClientPlayer, n, f);
        }
    }

    public final void realSetPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        this.func_130220_b(abstractClientPlayer, n, f);
    }

    public final void localSetPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = abstractClientPlayer.field_71071_by._e(3 - n);
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            this.func_110776_a(ifvk._a(abstractClientPlayer, cvzo2, n, "overlay"));
            float f2 = 1.0f;
            GL11.glColor3f(f2, f2, f2);
        }
    }

    @Override
    public void func_76976_a(gqqu gqqu2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isSetRenderManagerModded) {
            RenderPlayerAPI.setRenderManager(this, gqqu2);
        } else {
            super.func_76976_a(gqqu2);
        }
    }

    public final void superSetRenderManager(gqqu gqqu2) {
        super.func_76976_a(gqqu2);
    }

    public final void localSetRenderManager(gqqu gqqu2) {
        super.func_76976_a(gqqu2);
    }

    @Override
    public void func_77042_a(ModelBase modelBase) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isSetRenderPassModelModded) {
            RenderPlayerAPI.setRenderPassModel(this, modelBase);
        } else {
            super.func_77042_a(modelBase);
        }
    }

    public final void superSetRenderPassModel(ModelBase modelBase) {
        super.func_77042_a(modelBase);
    }

    public final void localSetRenderPassModel(ModelBase modelBase) {
        super.func_77042_a(modelBase);
    }

    @Override
    public void func_94143_a(nege nege2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isUpdateIconsModded) {
            RenderPlayerAPI.updateIcons(this, nege2);
        } else {
            super.func_94143_a(nege2);
        }
    }

    public final void superUpdateIcons(nege nege2) {
        super.func_94143_a(nege2);
    }

    public final void localUpdateIcons(nege nege2) {
        super.func_94143_a(nege2);
    }

    protected void renderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialHeadArmorModded) {
            RenderPlayerAPI.renderSpecialHeadArmor(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecialHeadArmor(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderSpecialHeadArmor(abstractClientPlayer, f);
    }

    public final void localRenderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
        cvzo cvzo2 = abstractClientPlayer.field_71071_by._e(3);
        if (cvzo2 != null && (currentRenderSpecialsPre == null || xbdy.currentRenderSpecialsPre.renderHelmet)) {
            GL11.glPushMatrix();
            this.field_77109_a.field_78116_c.func_78794_c(0.0625f);
            if (cvzo2 != null && cvzo2._a() instanceof mbpd) {
                boolean bl;
                IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
                boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (bl || htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                    float f2 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f2, -f2, -f2);
                }
                this.field_76990_c._h.func_78443_a(abstractClientPlayer, cvzo2, 0);
            } else if (cvzo2._a().field_77779_bT == tgdv.field_82799_bQ.field_77779_bT) {
                float f3 = 1.0625f;
                GL11.glScalef(f3, -f3, -f3);
                String string = "";
                if (cvzo2._p() && cvzo2._q()._c("SkullOwner")) {
                    string = cvzo2._q()._j("SkullOwner");
                }
                bsiw._e._a(-0.5f, 0.0f, -0.5f, 1, 180.0f, cvzo2._j(), string);
            }
            GL11.glPopMatrix();
        }
    }

    protected void renderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialHeadEarsModded) {
            RenderPlayerAPI.renderSpecialHeadEars(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecialHeadEars(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderSpecialHeadEars(abstractClientPlayer, f);
    }

    public final void localRenderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
        if (abstractClientPlayer.func_70005_c_().equals("deadmau5") && abstractClientPlayer.func_110309_l()._a()) {
            this.func_110776_a(abstractClientPlayer.func_110306_p());
            for (int i = 0; i < 1; ++i) {
                float f2 = abstractClientPlayer.field_70126_B + (abstractClientPlayer.field_70177_z - abstractClientPlayer.field_70126_B) * f - (abstractClientPlayer.field_70760_ar + (abstractClientPlayer.field_70761_aq - abstractClientPlayer.field_70760_ar) * f);
                float f3 = abstractClientPlayer.field_70127_C + (abstractClientPlayer.field_70125_A - abstractClientPlayer.field_70127_C) * f;
                GL11.glPushMatrix();
                GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f3, 1.0f, 0.0f, 0.0f);
                GL11.glTranslatef(0.375f * (float)(i - 1), 0.0f, 0.0f);
                GL11.glTranslatef(0.0f, -0.375f, 0.0f);
                GL11.glRotatef(-f3, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
                float f4 = 1.333333f;
                GL11.glScalef(f4, f4, f4);
                this.field_77109_a.func_78110_b(0.0625f);
                GL11.glPopMatrix();
            }
        }
    }

    protected void renderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialCloakModded) {
            RenderPlayerAPI.renderSpecialCloak(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecialCloak(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderSpecialCloak(abstractClientPlayer, f);
    }

    public final void localRenderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
        boolean bl = abstractClientPlayer.func_110310_o()._a();
        boolean bl2 = !abstractClientPlayer.func_82150_aj();
        boolean bl3 = !abstractClientPlayer.func_82238_cc();
        boolean bl4 = bl = (currentRenderSpecialsPre == null || xbdy.currentRenderSpecialsPre.renderCape) && bl;
        if (bl && bl2 && bl3) {
            this.func_110776_a(abstractClientPlayer.func_110303_q());
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            double d = abstractClientPlayer.field_71091_bM + (abstractClientPlayer.field_71094_bP - abstractClientPlayer.field_71091_bM) * (double)f - (abstractClientPlayer.field_70169_q + (abstractClientPlayer.field_70165_t - abstractClientPlayer.field_70169_q) * (double)f);
            double d2 = abstractClientPlayer.field_71096_bN + (abstractClientPlayer.field_71095_bQ - abstractClientPlayer.field_71096_bN) * (double)f - (abstractClientPlayer.field_70167_r + (abstractClientPlayer.field_70163_u - abstractClientPlayer.field_70167_r) * (double)f);
            double d3 = abstractClientPlayer.field_71097_bO + (abstractClientPlayer.field_71085_bR - abstractClientPlayer.field_71097_bO) * (double)f - (abstractClientPlayer.field_70166_s + (abstractClientPlayer.field_70161_v - abstractClientPlayer.field_70166_s) * (double)f);
            float f2 = abstractClientPlayer.field_70760_ar + (abstractClientPlayer.field_70761_aq - abstractClientPlayer.field_70760_ar) * f;
            double d4 = sajh._a(f2 * 3.141593f / 180.0f);
            double d5 = -sajh._b(f2 * 3.141593f / 180.0f);
            float f3 = (float)d2 * 10.0f;
            if (f3 < -6.0f) {
                f3 = -6.0f;
            }
            if (f3 > 32.0f) {
                f3 = 32.0f;
            }
            float f4 = (float)(d * d4 + d3 * d5) * 100.0f;
            float f5 = (float)(d * d5 - d3 * d4) * 100.0f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            float f6 = abstractClientPlayer.field_71107_bF + (abstractClientPlayer.field_71109_bG - abstractClientPlayer.field_71107_bF) * f;
            f3 += sajh._a((abstractClientPlayer.field_70141_P + (abstractClientPlayer.field_70140_Q - abstractClientPlayer.field_70141_P) * f) * 6.0f) * 32.0f * f6;
            if (abstractClientPlayer.func_70093_af()) {
                f3 += 25.0f;
            }
            GL11.glRotatef(6.0f + f4 / 2.0f + f3, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f5 / 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f5 / 2.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            this.field_77109_a.func_78111_c(0.0625f);
            GL11.glPopMatrix();
        }
    }

    protected void renderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialItemInHandModded) {
            RenderPlayerAPI.renderSpecialItemInHand(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecialItemInHand(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderSpecialItemInHand(abstractClientPlayer, f);
    }

    public final void localRenderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
        cvzo cvzo2 = abstractClientPlayer.field_71071_by._a();
        if (cvzo2 != null && (currentRenderSpecialsPre == null || xbdy.currentRenderSpecialsPre.renderItem)) {
            GL11.glPushMatrix();
            this.field_77109_a.field_78112_f.func_78794_c(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (abstractClientPlayer.field_71104_cf != null) {
                cvzo2 = new cvzo(tgdv.field_77669_D);
            }
            bsre bsre2 = null;
            if (abstractClientPlayer.func_71052_bv() > 0) {
                bsre2 = cvzo2._o();
            }
            this.positionSpecialItemInHand(abstractClientPlayer, f, bsre2, cvzo2);
            if (cvzo2._a().func_77623_v()) {
                for (int i = 0; i < cvzo2._a().getRenderPasses(cvzo2._j()); ++i) {
                    int n = cvzo2._a().func_82790_a(cvzo2, i);
                    float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                    this.field_76990_c._h.func_78443_a(abstractClientPlayer, cvzo2, i);
                }
            } else {
                int n = cvzo2._a().func_82790_a(cvzo2, 0);
                float f5 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f6 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f7 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f5, f6, f7, 1.0f);
                this.field_76990_c._h.func_78443_a(abstractClientPlayer, cvzo2, 0);
            }
            GL11.glPopMatrix();
        }
    }

    protected void positionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, bsre bsre2, cvzo cvzo2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isPositionSpecialItemInHandModded) {
            RenderPlayerAPI.positionSpecialItemInHand(this, abstractClientPlayer, f, bsre2, cvzo2);
        } else {
            this.localPositionSpecialItemInHand(abstractClientPlayer, f, bsre2, cvzo2);
        }
    }

    public final void realPositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, bsre bsre2, cvzo cvzo2) {
        this.positionSpecialItemInHand(abstractClientPlayer, f, bsre2, cvzo2);
    }

    public final void localPositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, bsre bsre2, cvzo cvzo2) {
        boolean bl;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
        boolean bl2 = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        boolean bl3 = bl = cvzo2._d < twgu.field_71973_m.length && cvzo2._c() == 0;
        if (bl2 || bl && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
            float f2 = 0.5f;
            GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
        } else if (cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
            float f3 = 0.625f;
            GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(f3, -f3, f3);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        } else if (tgdv.field_77698_e[cvzo2._d].func_77662_d()) {
            float f4 = 0.625f;
            if (tgdv.field_77698_e[cvzo2._d].func_77629_n_()) {
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, -0.125f, 0.0f);
            }
            if (abstractClientPlayer.func_71052_bv() > 0 && bsre2 == bsre._d) {
                GL11.glTranslatef(0.05f, 0.0f, -0.1f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            }
            GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
            GL11.glScalef(f4, -f4, f4);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        } else {
            float f5 = 0.375f;
            GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
            GL11.glScalef(f5, f5, f5);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    @Override
    public void func_82408_c(EntityLivingBase entityLivingBase, int n, float f) {
        this.func_130220_b((AbstractClientPlayer)entityLivingBase, n, f);
    }

    public final void realSetPassModel(EntityLivingBase entityLivingBase, int n, float f) {
        this.func_82408_c(entityLivingBase, n, f);
    }

    public final void superSetPassModel(EntityLivingBase entityLivingBase, int n, float f) {
        super.func_82408_c(entityLivingBase, n, f);
    }

    @Override
    public void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this.func_77100_a((AbstractClientPlayer)entityLivingBase, f);
    }

    public final void realRenderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this.func_77029_c(entityLivingBase, f);
    }

    public final void superRenderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        super.func_77029_c(entityLivingBase, f);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_130009_a((AbstractClientPlayer)entity, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this.func_110817_a((AbstractClientPlayer)entity);
    }

    public final ResourceLocation realGetEntityTexture(Entity entity) {
        return this.func_110775_a(entity);
    }

    @Override
    public void func_130000_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this.func_130009_a((AbstractClientPlayer)entityLivingBase, d, d2, d3, f, f2);
    }

    public final void superDoRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        super.func_130000_a(entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public void func_77039_a(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.func_77105_b((AbstractClientPlayer)entityLivingBase, d, d2, d3);
    }

    public final void realRenderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.func_77039_a(entityLivingBase, d, d2, d3);
    }

    public final void superRenderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.func_77039_a(entityLivingBase, d, d2, d3);
    }

    @Override
    public void func_96449_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, String string, float f, double d4) {
        this.func_96450_a((AbstractClientPlayer)entityLivingBase, d, d2, d3, string, f, d4);
    }

    public final void realRenderLivingNonSneakingLabel(EntityLivingBase entityLivingBase, double d, double d2, double d3, String string, float f, double d4) {
        this.func_96449_a(entityLivingBase, d, d2, d3, string, f, d4);
    }

    public final void superRenderLivingNonSneakingLabel(EntityLivingBase entityLivingBase, double d, double d2, double d3, String string, float f, double d4) {
        super.func_96449_a(entityLivingBase, d, d2, d3, string, f, d4);
    }

    @Override
    public void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this.func_77104_b((AbstractClientPlayer)entityLivingBase, f);
    }

    public final void realPreRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this.func_77041_b(entityLivingBase, f);
    }

    public final void superPreRenderCallback(EntityLivingBase entityLivingBase, float f) {
        super.func_77041_b(entityLivingBase, f);
    }

    @Override
    public int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_77107_a((AbstractClientPlayer)entityLivingBase, n, f);
    }

    public final int realShouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_77032_a(entityLivingBase, n, f);
    }

    public final int superShouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.func_77032_a(entityLivingBase, n, f);
    }

    @Override
    public void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.func_77102_a((AbstractClientPlayer)entityLivingBase, f, f2, f3);
    }

    public final void realRotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.func_77043_a(entityLivingBase, f, f2, f3);
    }

    public final void superRotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.func_77043_a(entityLivingBase, f, f2, f3);
    }

    private static Field TryLoadField(Class<?> clazz, String string) {
        if (clazz == null) {
            return null;
        }
        try {
            return clazz.getDeclaredField(string);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    public static xbdy[] getAllInstances() {
        Object object2;
        Map map;
        if (!initializedByForgeManager) {
            return new xbdy[0];
        }
        gqqu gqqu2 = gqqu._b;
        if (gqqu2 == null) {
            return new xbdy[0];
        }
        if (entityRenderMap == null) {
            entityRenderMap = xbdy.TryLoadField(gqqu.class, "q");
            if (entityRenderMap == null) {
                entityRenderMap = xbdy.TryLoadField(gqqu.class, "_a");
            }
            if (entityRenderMap == null) {
                entityRenderMap = xbdy.TryLoadField(gqqu.class, "entityRenderMap");
            }
            if (entityRenderMap != null) {
                entityRenderMap.setAccessible(true);
            }
        }
        if (entityRenderMap == null) {
            throw new RuntimeException("Can not find field \"entityRenderMap\" (ofuscated \"q\") in class \"" + gqqu.class.getName() + "\"");
        }
        try {
            map = (Map)entityRenderMap.get(gqqu2);
        }
        catch (Exception exception) {
            throw new RuntimeException("Unable to get value of field \"entityRenderMap\" (ofuscated \"q\") in class \"" + gqqu.class.getName() + "\"", exception);
        }
        if (map == null) {
            return new xbdy[0];
        }
        int n = 0;
        Collection collection = map.values();
        for (Object object2 : collection) {
            if (!(object2 instanceof xbdy)) continue;
            ++n;
        }
        object2 = new xbdy[n];
        for (Object t : collection) {
            if (!(t instanceof xbdy)) continue;
            object2[--n] = (xbdy)t;
        }
        return object2;
    }

    public final ModelBase getMainModelField() {
        return this.field_77045_g;
    }

    public final void setMainModelField(ModelBase modelBase) {
        this.field_77045_g = modelBase;
    }

    public final ModelBiped getModelArmorField() {
        return this.field_77111_i;
    }

    public final void setModelArmorField(ModelBiped modelBiped) {
        this.field_77111_i = modelBiped;
    }

    public final ModelBiped getModelArmorChestplateField() {
        return this.field_77108_b;
    }

    public final void setModelArmorChestplateField(ModelBiped modelBiped) {
        this.field_77108_b = modelBiped;
    }

    public final ModelBiped getModelBipedMainField() {
        return this.field_77109_a;
    }

    public final void setModelBipedMainField(ModelBiped modelBiped) {
        this.field_77109_a = modelBiped;
    }

    public final htvc getRenderBlocksField() {
        return this.field_76988_d;
    }

    public final void setRenderBlocksField(htvc htvc2) {
        this.field_76988_d = htvc2;
    }

    public final gqqu getRenderManagerField() {
        return this.field_76990_c;
    }

    public final void setRenderManagerField(gqqu gqqu2) {
        this.field_76990_c = gqqu2;
    }

    public final ModelBase getRenderPassModelField() {
        return this.field_77046_h;
    }

    public final void setRenderPassModelField(ModelBase modelBase) {
        this.field_77046_h = modelBase;
    }

    public final ResourceLocation getResourceLocationField() {
        return field_110826_a;
    }

    public final float getShadowOpaqueField() {
        return this.field_76987_f;
    }

    public final void setShadowOpaqueField(float f) {
        this.field_76987_f = f;
    }

    public final float getShadowSizeField() {
        return this.field_76989_e;
    }

    public final void setShadowSizeField(float f) {
        this.field_76989_e = f;
    }
}

