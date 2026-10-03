/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

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
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderPlayer
extends RendererLivingEntity {
    public static final ResourceLocation steveTextures = new ResourceLocation("textures/entity/steve.png");
    public ModelBiped modelBipedMain;
    public ModelBiped modelArmorChestplate;
    public ModelBiped modelArmor;
    private static Field entityRenderMap;
    private static boolean initializedByForgeManager;
    private static RenderPlayerEvent.Specials.Pre currentRenderSpecialsPre;
    public final RenderPlayerAPI renderPlayerAPI = RenderPlayerAPI.create(this);

    public RenderPlayer() {
        super(new ModelPlayer(0.0f), 0.5f);
        RenderPlayerAPI.beforeLocalConstructing(this);
        this.modelBipedMain = (ModelBiped)this.mainModel;
        this.modelArmorChestplate = new ModelPlayer(1.0f);
        this.modelArmor = new ModelPlayer(0.5f);
        if (Thread.currentThread().getStackTrace()[2].getClassName().equals(RenderManager.class.getName())) {
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
    public void doRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isDoRenderShadowAndFireModded) {
            RenderPlayerAPI.doRenderShadowAndFire(this, entity, d, d2, d3, f, f2);
        } else {
            super.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
        }
    }

    public final void superDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        super.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
    }

    public final void localDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        super.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
    }

    @Override
    public int getColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        int n = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetColorMultiplierModded ? RenderPlayerAPI.getColorMultiplier(this, entityLivingBase, f, f2) : super.getColorMultiplier(entityLivingBase, f, f2);
        return n;
    }

    public final int realGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return this.getColorMultiplier(entityLivingBase, f, f2);
    }

    public final int superGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return super.getColorMultiplier(entityLivingBase, f, f2);
    }

    public final int localGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return super.getColorMultiplier(entityLivingBase, f, f2);
    }

    @Override
    public float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        float f = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetDeathMaxRotationModded ? RenderPlayerAPI.getDeathMaxRotation(this, entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
        return f;
    }

    public final float realGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return this.getDeathMaxRotation(entityLivingBase);
    }

    public final float superGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return super.getDeathMaxRotation(entityLivingBase);
    }

    public final float localGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return super.getDeathMaxRotation(entityLivingBase);
    }

    @Override
    public FontRenderer getFontRendererFromRenderManager() {
        FontRenderer fontRenderer = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetFontRendererFromRenderManagerModded ? RenderPlayerAPI.getFontRendererFromRenderManager(this) : super.getFontRendererFromRenderManager();
        return fontRenderer;
    }

    public final FontRenderer superGetFontRendererFromRenderManager() {
        return super.getFontRendererFromRenderManager();
    }

    public final FontRenderer localGetFontRendererFromRenderManager() {
        return super.getFontRendererFromRenderManager();
    }

    public ResourceLocation func_110817_a(AbstractClientPlayer abstractClientPlayer) {
        ResourceLocation resourceLocation = this.renderPlayerAPI != null && this.renderPlayerAPI.isGetResourceLocationFromPlayerModded ? RenderPlayerAPI.getResourceLocationFromPlayer(this, abstractClientPlayer) : this.localGetResourceLocationFromPlayer(abstractClientPlayer);
        return resourceLocation;
    }

    public final ResourceLocation realGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        return this.func_110817_a(abstractClientPlayer);
    }

    public final ResourceLocation localGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.getLocationSkin();
    }

    @Override
    public float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        float f2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isHandleRotationFloatModded ? RenderPlayerAPI.handleRotationFloat(this, entityLivingBase, f) : super.handleRotationFloat(entityLivingBase, f);
        return f2;
    }

    public final float realHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return this.handleRotationFloat(entityLivingBase, f);
    }

    public final float superHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return super.handleRotationFloat(entityLivingBase, f);
    }

    public final float localHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return super.handleRotationFloat(entityLivingBase, f);
    }

    @Override
    public int inheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        int n2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isInheritRenderPassModded ? RenderPlayerAPI.inheritRenderPass(this, entityLivingBase, n, f) : super.inheritRenderPass(entityLivingBase, n, f);
        return n2;
    }

    public final int realInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.inheritRenderPass(entityLivingBase, n, f);
    }

    public final int superInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.inheritRenderPass(entityLivingBase, n, f);
    }

    public final int localInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.inheritRenderPass(entityLivingBase, n, f);
    }

    @Override
    public void bindTexture(ResourceLocation resourceLocation) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isLoadTextureModded) {
            RenderPlayerAPI.loadTexture(this, resourceLocation);
        } else {
            super.bindTexture(resourceLocation);
        }
    }

    public final void realLoadTexture(ResourceLocation resourceLocation) {
        this.bindTexture(resourceLocation);
    }

    public final void superLoadTexture(ResourceLocation resourceLocation) {
        super.bindTexture(resourceLocation);
    }

    public final void localLoadTexture(ResourceLocation resourceLocation) {
        super.bindTexture(resourceLocation);
    }

    @Override
    public void bindEntityTexture(Entity entity) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isLoadTextureOfEntityModded) {
            RenderPlayerAPI.loadTextureOfEntity(this, entity);
        } else {
            super.bindEntityTexture(entity);
        }
    }

    public final void realLoadTextureOfEntity(Entity entity) {
        this.bindEntityTexture(entity);
    }

    public final void superLoadTextureOfEntity(Entity entity) {
        super.bindEntityTexture(entity);
    }

    public final void localLoadTextureOfEntity(Entity entity) {
        super.bindEntityTexture(entity);
    }

    @Override
    public void passSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isPassSpecialRenderModded) {
            RenderPlayerAPI.passSpecialRender(this, entityLivingBase, d, d2, d3);
        } else {
            super.passSpecialRender(entityLivingBase, d, d2, d3);
        }
    }

    public final void realPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.passSpecialRender(entityLivingBase, d, d2, d3);
    }

    public final void superPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.passSpecialRender(entityLivingBase, d, d2, d3);
    }

    public final void localPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.passSpecialRender(entityLivingBase, d, d2, d3);
    }

    @Override
    public void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderArrowsStuckInEntityModded) {
            RenderPlayerAPI.renderArrowsStuckInEntity(this, entityLivingBase, f);
        } else {
            super.renderArrowsStuckInEntity(entityLivingBase, f);
        }
    }

    public final void realRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        this.renderArrowsStuckInEntity(entityLivingBase, f);
    }

    public final void superRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        super.renderArrowsStuckInEntity(entityLivingBase, f);
    }

    public final void localRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        super.renderArrowsStuckInEntity(entityLivingBase, f);
    }

    public void renderFirstPersonArm(EntityPlayer entityPlayer) {
        ugqx._a(this, entityPlayer);
    }

    public final void localRenderFirstPersonArm(EntityPlayer entityPlayer) {
        float f = 1.0f;
        GL11.glColor3f(f, f, f);
        this.modelBipedMain.onGround = 0.0f;
        this.modelBipedMain.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, entityPlayer);
        this.modelBipedMain.bipedRightArm.render(0.0625f);
    }

    @Override
    public void renderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderLivingLabelModded) {
            RenderPlayerAPI.renderLivingLabel(this, entityLivingBase, string, d, d2, d3, n);
        } else {
            super.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        }
    }

    public final void realRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        this.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
    }

    public final void superRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        super.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
    }

    public final void localRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        super.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
    }

    @Override
    public void renderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderModelModded) {
            RenderPlayerAPI.renderModel(this, entityLivingBase, f, f2, f3, f4, f5, f6);
        } else {
            super.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        }
    }

    public final void realRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    public final void superRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        super.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    public final void localRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        super.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
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
        ItemStack itemStack = abstractClientPlayer.inventory._a();
        this.modelBipedMain.heldItemRight = itemStack != null ? 1 : 0;
        this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelBipedMain.heldItemRight;
        if (itemStack != null && abstractClientPlayer.getItemInUseCount() > 0) {
            EnumAction enumAction = itemStack._o();
            if (enumAction == EnumAction._d) {
                this.modelBipedMain.heldItemRight = 3;
                this.modelArmor.heldItemRight = 3;
                this.modelArmorChestplate.heldItemRight = 3;
            } else if (enumAction == EnumAction._e) {
                this.modelBipedMain.aimedBow = true;
                this.modelArmor.aimedBow = true;
                this.modelArmorChestplate.aimedBow = true;
            }
        }
        this.modelArmor.isSneak = this.modelBipedMain.isSneak = abstractClientPlayer.isSneaking();
        this.modelArmorChestplate.isSneak = this.modelBipedMain.isSneak;
        double d4 = d2 - (double)abstractClientPlayer.yOffset;
        if (abstractClientPlayer.isSneaking() && !(abstractClientPlayer instanceof EntityPlayerSP)) {
            d4 -= 0.125;
        }
        super.doRenderLiving(abstractClientPlayer, d, d4, d3, f, f2);
        this.modelBipedMain.aimedBow = false;
        this.modelArmor.aimedBow = false;
        this.modelArmorChestplate.aimedBow = false;
        this.modelBipedMain.isSneak = false;
        this.modelArmor.isSneak = false;
        this.modelArmorChestplate.isSneak = false;
        this.modelBipedMain.heldItemRight = 0;
        this.modelArmor.heldItemRight = 0;
        this.modelArmorChestplate.heldItemRight = 0;
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
        Scoreboard scoreboard;
        ScoreObjective scoreObjective;
        if (d4 < 100.0 && (scoreObjective = (scoreboard = abstractClientPlayer.getWorldScoreboard())._a(2)) != null) {
            Score score = scoreboard._a(abstractClientPlayer.getEntityName(), scoreObjective);
            if (abstractClientPlayer.isPlayerSleeping()) {
                this.renderLivingLabel(abstractClientPlayer, score._b() + " " + scoreObjective._d(), d, d2 - 1.5, d3, 64);
            } else {
                this.renderLivingLabel(abstractClientPlayer, score._b() + " " + scoreObjective._d(), d, d2, d3, 64);
            }
            d2 += (double)((float)this.getFontRendererFromRenderManager()._c * 1.15f * f);
        }
        super.func_96449_a(abstractClientPlayer, d, d2, d3, string, f, d4);
    }

    public void renderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerScaleModded) {
            RenderPlayerAPI.renderPlayerScale(this, abstractClientPlayer, f);
        } else {
            this.localRenderPlayerScale(abstractClientPlayer, f);
        }
    }

    public final void realRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderPlayerScale(abstractClientPlayer, f);
    }

    public final void localRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        float f2 = 0.9375f;
        GL11.glScalef(f2, f2, f2);
    }

    public void renderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderPlayerSleepModded) {
            RenderPlayerAPI.renderPlayerSleep(this, abstractClientPlayer, d, d2, d3);
        } else {
            this.localRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
        }
    }

    public final void realRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        this.renderPlayerSleep(abstractClientPlayer, d, d2, d3);
    }

    public final void localRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (abstractClientPlayer.isEntityAlive() && abstractClientPlayer.isPlayerSleeping()) {
            super.renderLivingAt(abstractClientPlayer, d + (double)abstractClientPlayer.field_71079_bU, d2 + (double)abstractClientPlayer.field_71082_cx, d3 + (double)abstractClientPlayer.field_71089_bV);
        } else {
            super.renderLivingAt(abstractClientPlayer, d, d2, d3);
        }
    }

    public void renderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSpecialsModded) {
            RenderPlayerAPI.renderSpecials(this, abstractClientPlayer, f);
        } else {
            this.localRenderSpecials(abstractClientPlayer, f);
        }
    }

    public final void realRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        this.renderSpecials(abstractClientPlayer, f);
    }

    public final void localRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        currentRenderSpecialsPre = new RenderPlayerEvent.Specials.Pre(abstractClientPlayer, this, f);
        if (MinecraftForge.EVENT_BUS.post(currentRenderSpecialsPre)) {
            return;
        }
        float f2 = 1.0f;
        GL11.glColor3f(f2, f2, f2);
        super.renderEquippedItems(abstractClientPlayer, f);
        this.renderArrowsStuckInEntity(abstractClientPlayer, f);
        this.renderSpecialHeadArmor(abstractClientPlayer, f);
        this.renderSpecialHeadEars(abstractClientPlayer, f);
        this.renderSpecialCloak(abstractClientPlayer, f);
        this.renderSpecialItemInHand(abstractClientPlayer, f);
        MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(abstractClientPlayer, this, f));
        currentRenderSpecialsPre = null;
    }

    @Override
    public float renderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        float f2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isRenderSwingProgressModded ? RenderPlayerAPI.renderSwingProgress(this, entityLivingBase, f) : super.renderSwingProgress(entityLivingBase, f);
        return f2;
    }

    public final float realRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return this.renderSwingProgress(entityLivingBase, f);
    }

    public final float superRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return super.renderSwingProgress(entityLivingBase, f);
    }

    public final float localRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return super.renderSwingProgress(entityLivingBase, f);
    }

    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isRotatePlayerModded) {
            RenderPlayerAPI.rotatePlayer(this, abstractClientPlayer, f, f2, f3);
        } else {
            this.localRotatePlayer(abstractClientPlayer, f, f2, f3);
        }
    }

    public final void realRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    public final void localRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (abstractClientPlayer.isEntityAlive() && abstractClientPlayer.isPlayerSleeping()) {
            GL11.glRotatef(abstractClientPlayer.getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.getDeathMaxRotation(abstractClientPlayer), 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
        } else {
            super.rotateCorpse(abstractClientPlayer, f, f2, f3);
        }
    }

    public int setArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        int n2 = this.renderPlayerAPI != null && this.renderPlayerAPI.isSetArmorModelModded ? RenderPlayerAPI.setArmorModel(this, abstractClientPlayer, n, f) : this.localSetArmorModel(abstractClientPlayer, n, f);
        return n2;
    }

    public final int realSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        return this.setArmorModel(abstractClientPlayer, n, f);
    }

    public final int localSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        Item item;
        ItemStack itemStack = abstractClientPlayer.inventory._e(3 - n);
        RenderPlayerEvent.SetArmorModel setArmorModel = new RenderPlayerEvent.SetArmorModel(abstractClientPlayer, this, 3 - n, f, itemStack);
        MinecraftForge.EVENT_BUS.post(setArmorModel);
        if (setArmorModel.result != -1) {
            return setArmorModel.result;
        }
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor)item;
            this.bindTexture(ifvk._a(abstractClientPlayer, itemStack, n, null));
            ModelBiped modelBiped = n == 2 ? this.modelArmor : this.modelArmorChestplate;
            modelBiped.bipedHead.showModel = n == 0;
            modelBiped.bipedHeadwear.showModel = n == 0;
            modelBiped.bipedBody.showModel = n == 1 || n == 2;
            modelBiped.bipedRightArm.showModel = n == 1;
            modelBiped.bipedLeftArm.showModel = n == 1;
            modelBiped.bipedRightLeg.showModel = n == 2 || n == 3;
            modelBiped.bipedLeftLeg.showModel = n == 2 || n == 3;
            modelBiped = ForgeHooksClient.getArmorModel(abstractClientPlayer, itemStack, n, modelBiped);
            this.setRenderPassModel(modelBiped);
            modelBiped.onGround = this.mainModel.onGround;
            modelBiped.isRiding = this.mainModel.isRiding;
            modelBiped.isChild = this.mainModel.isChild;
            float f2 = 1.0f;
            int n2 = itemArmor.getColor(itemStack);
            if (n2 != -1) {
                float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n2 & 0xFF) / 255.0f;
                GL11.glColor3f(f2 * f3, f2 * f4, f2 * f5);
                if (itemStack._y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f(f2, f2, f2);
            if (itemStack._y()) {
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
        Item item;
        ItemStack itemStack = abstractClientPlayer.inventory._e(3 - n);
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            this.bindTexture(ifvk._a(abstractClientPlayer, itemStack, n, "overlay"));
            float f2 = 1.0f;
            GL11.glColor3f(f2, f2, f2);
        }
    }

    @Override
    public void setRenderManager(RenderManager renderManager) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isSetRenderManagerModded) {
            RenderPlayerAPI.setRenderManager(this, renderManager);
        } else {
            super.setRenderManager(renderManager);
        }
    }

    public final void superSetRenderManager(RenderManager renderManager) {
        super.setRenderManager(renderManager);
    }

    public final void localSetRenderManager(RenderManager renderManager) {
        super.setRenderManager(renderManager);
    }

    @Override
    public void setRenderPassModel(ModelBase modelBase) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isSetRenderPassModelModded) {
            RenderPlayerAPI.setRenderPassModel(this, modelBase);
        } else {
            super.setRenderPassModel(modelBase);
        }
    }

    public final void superSetRenderPassModel(ModelBase modelBase) {
        super.setRenderPassModel(modelBase);
    }

    public final void localSetRenderPassModel(ModelBase modelBase) {
        super.setRenderPassModel(modelBase);
    }

    @Override
    public void updateIcons(IconRegister iconRegister) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isUpdateIconsModded) {
            RenderPlayerAPI.updateIcons(this, iconRegister);
        } else {
            super.updateIcons(iconRegister);
        }
    }

    public final void superUpdateIcons(IconRegister iconRegister) {
        super.updateIcons(iconRegister);
    }

    public final void localUpdateIcons(IconRegister iconRegister) {
        super.updateIcons(iconRegister);
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
        ItemStack itemStack = abstractClientPlayer.inventory._e(3);
        if (itemStack != null && (currentRenderSpecialsPre == null || RenderPlayer.currentRenderSpecialsPre.renderHelmet)) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625f);
            if (itemStack != null && itemStack._a() instanceof ItemBlock) {
                boolean bl;
                IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
                boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (bl || RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                    float f2 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f2, -f2, -f2);
                }
                this.renderManager._h.renderItem(abstractClientPlayer, itemStack, 0);
            } else if (itemStack._a().itemID == Item.skull.itemID) {
                float f3 = 1.0625f;
                GL11.glScalef(f3, -f3, -f3);
                String string = "";
                if (itemStack._p() && itemStack._q()._c("SkullOwner")) {
                    string = itemStack._q()._j("SkullOwner");
                }
                bsiw._e._a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemStack._j(), string);
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
        if (abstractClientPlayer.getCommandSenderName().equals("deadmau5") && abstractClientPlayer.getTextureSkin()._a()) {
            this.bindTexture(abstractClientPlayer.getLocationSkin());
            for (int i = 0; i < 1; ++i) {
                float f2 = abstractClientPlayer.prevRotationYaw + (abstractClientPlayer.rotationYaw - abstractClientPlayer.prevRotationYaw) * f - (abstractClientPlayer.prevRenderYawOffset + (abstractClientPlayer.renderYawOffset - abstractClientPlayer.prevRenderYawOffset) * f);
                float f3 = abstractClientPlayer.prevRotationPitch + (abstractClientPlayer.rotationPitch - abstractClientPlayer.prevRotationPitch) * f;
                GL11.glPushMatrix();
                GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f3, 1.0f, 0.0f, 0.0f);
                GL11.glTranslatef(0.375f * (float)(i - 1), 0.0f, 0.0f);
                GL11.glTranslatef(0.0f, -0.375f, 0.0f);
                GL11.glRotatef(-f3, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
                float f4 = 1.333333f;
                GL11.glScalef(f4, f4, f4);
                this.modelBipedMain.renderEars(0.0625f);
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
        boolean bl = abstractClientPlayer.getTextureCape()._a();
        boolean bl2 = !abstractClientPlayer.isInvisible();
        boolean bl3 = !abstractClientPlayer.getHideCape();
        boolean bl4 = bl = (currentRenderSpecialsPre == null || RenderPlayer.currentRenderSpecialsPre.renderCape) && bl;
        if (bl && bl2 && bl3) {
            this.bindTexture(abstractClientPlayer.getLocationCape());
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            double d = abstractClientPlayer.field_71091_bM + (abstractClientPlayer.field_71094_bP - abstractClientPlayer.field_71091_bM) * (double)f - (abstractClientPlayer.prevPosX + (abstractClientPlayer.posX - abstractClientPlayer.prevPosX) * (double)f);
            double d2 = abstractClientPlayer.field_71096_bN + (abstractClientPlayer.field_71095_bQ - abstractClientPlayer.field_71096_bN) * (double)f - (abstractClientPlayer.prevPosY + (abstractClientPlayer.posY - abstractClientPlayer.prevPosY) * (double)f);
            double d3 = abstractClientPlayer.field_71097_bO + (abstractClientPlayer.field_71085_bR - abstractClientPlayer.field_71097_bO) * (double)f - (abstractClientPlayer.prevPosZ + (abstractClientPlayer.posZ - abstractClientPlayer.prevPosZ) * (double)f);
            float f2 = abstractClientPlayer.prevRenderYawOffset + (abstractClientPlayer.renderYawOffset - abstractClientPlayer.prevRenderYawOffset) * f;
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
            float f6 = abstractClientPlayer.prevCameraYaw + (abstractClientPlayer.cameraYaw - abstractClientPlayer.prevCameraYaw) * f;
            f3 += sajh._a((abstractClientPlayer.prevDistanceWalkedModified + (abstractClientPlayer.distanceWalkedModified - abstractClientPlayer.prevDistanceWalkedModified) * f) * 6.0f) * 32.0f * f6;
            if (abstractClientPlayer.isSneaking()) {
                f3 += 25.0f;
            }
            GL11.glRotatef(6.0f + f4 / 2.0f + f3, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f5 / 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f5 / 2.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            this.modelBipedMain.renderCloak(0.0625f);
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
        ItemStack itemStack = abstractClientPlayer.inventory._a();
        if (itemStack != null && (currentRenderSpecialsPre == null || RenderPlayer.currentRenderSpecialsPre.renderItem)) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedRightArm.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (abstractClientPlayer.fishEntity != null) {
                itemStack = new ItemStack(Item.stick);
            }
            EnumAction enumAction = null;
            if (abstractClientPlayer.getItemInUseCount() > 0) {
                enumAction = itemStack._o();
            }
            this.positionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
            if (itemStack._a().requiresMultipleRenderPasses()) {
                for (int i = 0; i < itemStack._a().getRenderPasses(itemStack._j()); ++i) {
                    int n = itemStack._a().getColorFromItemStack(itemStack, i);
                    float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                    this.renderManager._h.renderItem(abstractClientPlayer, itemStack, i);
                }
            } else {
                int n = itemStack._a().getColorFromItemStack(itemStack, 0);
                float f5 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f6 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f7 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f5, f6, f7, 1.0f);
                this.renderManager._h.renderItem(abstractClientPlayer, itemStack, 0);
            }
            GL11.glPopMatrix();
        }
    }

    protected void positionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        if (this.renderPlayerAPI != null && this.renderPlayerAPI.isPositionSpecialItemInHandModded) {
            RenderPlayerAPI.positionSpecialItemInHand(this, abstractClientPlayer, f, enumAction, itemStack);
        } else {
            this.localPositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        }
    }

    public final void realPositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        this.positionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
    }

    public final void localPositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        boolean bl;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
        boolean bl2 = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        boolean bl3 = bl = itemStack._d < Block.blocksList.length && itemStack._c() == 0;
        if (bl2 || bl && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
            float f2 = 0.5f;
            GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
        } else if (itemStack._d == Item.bow.itemID) {
            float f3 = 0.625f;
            GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(f3, -f3, f3);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        } else if (Item.itemsList[itemStack._d].isFull3D()) {
            float f4 = 0.625f;
            if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, -0.125f, 0.0f);
            }
            if (abstractClientPlayer.getItemInUseCount() > 0 && enumAction == EnumAction._d) {
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
    public void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this.renderSpecials((AbstractClientPlayer)entityLivingBase, f);
    }

    public final void realRenderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this.renderEquippedItems(entityLivingBase, f);
    }

    public final void superRenderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        super.renderEquippedItems(entityLivingBase, f);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_130009_a((AbstractClientPlayer)entity, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this.func_110817_a((AbstractClientPlayer)entity);
    }

    public final ResourceLocation realGetEntityTexture(Entity entity) {
        return this.getEntityTexture(entity);
    }

    @Override
    public void doRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this.func_130009_a((AbstractClientPlayer)entityLivingBase, d, d2, d3, f, f2);
    }

    public final void superDoRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public void renderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.renderPlayerSleep((AbstractClientPlayer)entityLivingBase, d, d2, d3);
    }

    public final void realRenderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.renderLivingAt(entityLivingBase, d, d2, d3);
    }

    public final void superRenderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.renderLivingAt(entityLivingBase, d, d2, d3);
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
    public void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this.renderPlayerScale((AbstractClientPlayer)entityLivingBase, f);
    }

    public final void realPreRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this.preRenderCallback(entityLivingBase, f);
    }

    public final void superPreRenderCallback(EntityLivingBase entityLivingBase, float f) {
        super.preRenderCallback(entityLivingBase, f);
    }

    @Override
    public int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.setArmorModel((AbstractClientPlayer)entityLivingBase, n, f);
    }

    public final int realShouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.shouldRenderPass(entityLivingBase, n, f);
    }

    public final int superShouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return super.shouldRenderPass(entityLivingBase, n, f);
    }

    @Override
    public void rotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.rotatePlayer((AbstractClientPlayer)entityLivingBase, f, f2, f3);
    }

    public final void realRotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.rotateCorpse(entityLivingBase, f, f2, f3);
    }

    public final void superRotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.rotateCorpse(entityLivingBase, f, f2, f3);
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

    public static RenderPlayer[] getAllInstances() {
        Object object2;
        Map map;
        if (!initializedByForgeManager) {
            return new RenderPlayer[0];
        }
        RenderManager renderManager = RenderManager._b;
        if (renderManager == null) {
            return new RenderPlayer[0];
        }
        if (entityRenderMap == null) {
            entityRenderMap = RenderPlayer.TryLoadField(RenderManager.class, "q");
            if (entityRenderMap == null) {
                entityRenderMap = RenderPlayer.TryLoadField(RenderManager.class, "_a");
            }
            if (entityRenderMap == null) {
                entityRenderMap = RenderPlayer.TryLoadField(RenderManager.class, "entityRenderMap");
            }
            if (entityRenderMap != null) {
                entityRenderMap.setAccessible(true);
            }
        }
        if (entityRenderMap == null) {
            throw new RuntimeException("Can not find field \"entityRenderMap\" (ofuscated \"q\") in class \"" + RenderManager.class.getName() + "\"");
        }
        try {
            map = (Map)entityRenderMap.get(renderManager);
        }
        catch (Exception exception) {
            throw new RuntimeException("Unable to get value of field \"entityRenderMap\" (ofuscated \"q\") in class \"" + RenderManager.class.getName() + "\"", exception);
        }
        if (map == null) {
            return new RenderPlayer[0];
        }
        int n = 0;
        Collection collection = map.values();
        for (Object object2 : collection) {
            if (!(object2 instanceof RenderPlayer)) continue;
            ++n;
        }
        object2 = new RenderPlayer[n];
        for (Object t : collection) {
            if (!(t instanceof RenderPlayer)) continue;
            object2[--n] = (RenderPlayer)t;
        }
        return object2;
    }

    public final ModelBase getMainModelField() {
        return this.mainModel;
    }

    public final void setMainModelField(ModelBase modelBase) {
        this.mainModel = modelBase;
    }

    public final ModelBiped getModelArmorField() {
        return this.modelArmor;
    }

    public final void setModelArmorField(ModelBiped modelBiped) {
        this.modelArmor = modelBiped;
    }

    public final ModelBiped getModelArmorChestplateField() {
        return this.modelArmorChestplate;
    }

    public final void setModelArmorChestplateField(ModelBiped modelBiped) {
        this.modelArmorChestplate = modelBiped;
    }

    public final ModelBiped getModelBipedMainField() {
        return this.modelBipedMain;
    }

    public final void setModelBipedMainField(ModelBiped modelBiped) {
        this.modelBipedMain = modelBiped;
    }

    public final RenderBlocks getRenderBlocksField() {
        return this.renderBlocks;
    }

    public final void setRenderBlocksField(RenderBlocks renderBlocks) {
        this.renderBlocks = renderBlocks;
    }

    public final RenderManager getRenderManagerField() {
        return this.renderManager;
    }

    public final void setRenderManagerField(RenderManager renderManager) {
        this.renderManager = renderManager;
    }

    public final ModelBase getRenderPassModelField() {
        return this.renderPassModel;
    }

    public final void setRenderPassModelField(ModelBase modelBase) {
        this.renderPassModel = modelBase;
    }

    public final ResourceLocation getResourceLocationField() {
        return steveTextures;
    }

    public final float getShadowOpaqueField() {
        return this.shadowOpaque;
    }

    public final void setShadowOpaqueField(float f) {
        this.shadowOpaque = f;
    }

    public final float getShadowSizeField() {
        return this.shadowSize;
    }

    public final void setShadowSizeField(float f) {
        this.shadowSize = f;
    }
}

