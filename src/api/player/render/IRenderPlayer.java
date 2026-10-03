/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.RenderBlocks
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.texture.IconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 */
package api.player.render;

import api.player.render.RenderPlayerBase;
import java.util.Set;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IRenderPlayer {
    public RenderPlayerBase getRenderPlayerBase(String var1);

    public Set<String> getRenderPlayerBaseIds();

    public Object dynamic(String var1, Object[] var2);

    public boolean realDoRenderLabel(EntityLivingBase var1);

    public boolean superDoRenderLabel(EntityLivingBase var1);

    public boolean localDoRenderLabel(EntityLivingBase var1);

    public void realDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

    public void superDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

    public void localDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

    public int realGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

    public int superGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

    public int localGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

    public float realGetDeathMaxRotation(EntityLivingBase var1);

    public float superGetDeathMaxRotation(EntityLivingBase var1);

    public float localGetDeathMaxRotation(EntityLivingBase var1);

    public FontRenderer realGetFontRendererFromRenderManager();

    public FontRenderer superGetFontRendererFromRenderManager();

    public FontRenderer localGetFontRendererFromRenderManager();

    public ResourceLocation realGetResourceLocationFromPlayer(AbstractClientPlayer var1);

    public ResourceLocation localGetResourceLocationFromPlayer(AbstractClientPlayer var1);

    public float realHandleRotationFloat(EntityLivingBase var1, float var2);

    public float superHandleRotationFloat(EntityLivingBase var1, float var2);

    public float localHandleRotationFloat(EntityLivingBase var1, float var2);

    public int realInheritRenderPass(EntityLivingBase var1, int var2, float var3);

    public int superInheritRenderPass(EntityLivingBase var1, int var2, float var3);

    public int localInheritRenderPass(EntityLivingBase var1, int var2, float var3);

    public void realLoadTexture(ResourceLocation var1);

    public void superLoadTexture(ResourceLocation var1);

    public void localLoadTexture(ResourceLocation var1);

    public void realLoadTextureOfEntity(Entity var1);

    public void superLoadTextureOfEntity(Entity var1);

    public void localLoadTextureOfEntity(Entity var1);

    public void realPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

    public void superPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

    public void localPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

    public void realRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

    public void superRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

    public void localRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

    public void realRenderFirstPersonArm(EntityPlayer var1);

    public void localRenderFirstPersonArm(EntityPlayer var1);

    public void realRenderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9);

    public void superRenderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9);

    public void localRenderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9);

    public void realRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void superRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void localRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void realRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

    public void localRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

    public void realRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10);

    public void localRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10);

    public void realRenderPlayerScale(AbstractClientPlayer var1, float var2);

    public void localRenderPlayerScale(AbstractClientPlayer var1, float var2);

    public void realRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6);

    public void localRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6);

    public void realRenderSpecials(AbstractClientPlayer var1, float var2);

    public void localRenderSpecials(AbstractClientPlayer var1, float var2);

    public float realRenderSwingProgress(EntityLivingBase var1, float var2);

    public float superRenderSwingProgress(EntityLivingBase var1, float var2);

    public float localRenderSwingProgress(EntityLivingBase var1, float var2);

    public void realRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

    public void localRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

    public int realSetArmorModel(AbstractClientPlayer var1, int var2, float var3);

    public int localSetArmorModel(AbstractClientPlayer var1, int var2, float var3);

    public void realSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3);

    public void localSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3);

    public void realSetRenderManager(RenderManager var1);

    public void superSetRenderManager(RenderManager var1);

    public void localSetRenderManager(RenderManager var1);

    public void realSetRenderPassModel(ModelBase var1);

    public void superSetRenderPassModel(ModelBase var1);

    public void localSetRenderPassModel(ModelBase var1);

    public void realUpdateIcons(IconRegister var1);

    public void superUpdateIcons(IconRegister var1);

    public void localUpdateIcons(IconRegister var1);

    public ModelBase getMainModelField();

    public void setMainModelField(ModelBase var1);

    public ModelBiped getModelArmorField();

    public void setModelArmorField(ModelBiped var1);

    public ModelBiped getModelArmorChestplateField();

    public void setModelArmorChestplateField(ModelBiped var1);

    public ModelBiped getModelBipedMainField();

    public void setModelBipedMainField(ModelBiped var1);

    public RenderBlocks getRenderBlocksField();

    public void setRenderBlocksField(RenderBlocks var1);

    public RenderManager getRenderManagerField();

    public void setRenderManagerField(RenderManager var1);

    public ModelBase getRenderPassModelField();

    public void setRenderPassModelField(ModelBase var1);

    public float getShadowOpaqueField();

    public void setShadowOpaqueField(float var1);

    public float getShadowSizeField();

    public void setShadowSizeField(float var1);
}

