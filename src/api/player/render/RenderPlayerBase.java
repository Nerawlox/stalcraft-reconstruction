/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.client.renderer.texture.IconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 */
package api.player.render;

import api.player.render.IRenderPlayer;
import api.player.render.RenderPlayerAPI;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public abstract class RenderPlayerBase {
    protected final RenderPlayer renderPlayer;
    protected final IRenderPlayer renderPlayerAPI;
    private final RenderPlayerAPI internalRenderPlayerAPI;

    public RenderPlayerBase(RenderPlayerAPI var1) {
        this.internalRenderPlayerAPI = var1;
        this.renderPlayerAPI = var1.renderPlayer;
        this.renderPlayer = var1.renderPlayer.getRenderPlayer();
    }

    public void beforeBaseAttach(boolean var1) {
    }

    public void afterBaseAttach(boolean var1) {
    }

    public void beforeLocalConstructing() {
    }

    public void afterLocalConstructing() {
    }

    public void beforeBaseDetach(boolean var1) {
    }

    public void afterBaseDetach(boolean var1) {
    }

    public Object dynamic(String var1, Object[] var2) {
        return this.internalRenderPlayerAPI.dynamicOverwritten(var1, var2, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeDoRenderLabel(EntityLivingBase var1) {
    }

    public boolean doRenderLabel(EntityLivingBase var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenDoRenderLabel(this);
        boolean var3 = var2 == null ? this.renderPlayerAPI.localDoRenderLabel(var1) : (var2 != this ? var2.doRenderLabel(var1) : false);
        return var3;
    }

    public void afterDoRenderLabel(EntityLivingBase var1) {
    }

    public void beforeDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void doRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        RenderPlayerBase var10 = this.internalRenderPlayerAPI.GetOverwrittenDoRenderShadowAndFire(this);
        if (var10 == null) {
            this.renderPlayerAPI.localDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        } else if (var10 != this) {
            var10.doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        }
    }

    public void afterDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void beforeGetColorMultiplier(EntityLivingBase var1, float var2, float var3) {
    }

    public int getColorMultiplier(EntityLivingBase var1, float var2, float var3) {
        RenderPlayerBase var4 = this.internalRenderPlayerAPI.GetOverwrittenGetColorMultiplier(this);
        int var5 = var4 == null ? this.renderPlayerAPI.localGetColorMultiplier(var1, var2, var3) : (var4 != this ? var4.getColorMultiplier(var1, var2, var3) : 0);
        return var5;
    }

    public void afterGetColorMultiplier(EntityLivingBase var1, float var2, float var3) {
    }

    public void beforeGetDeathMaxRotation(EntityLivingBase var1) {
    }

    public float getDeathMaxRotation(EntityLivingBase var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenGetDeathMaxRotation(this);
        float var3 = var2 == null ? this.renderPlayerAPI.localGetDeathMaxRotation(var1) : (var2 != this ? var2.getDeathMaxRotation(var1) : 0.0f);
        return var3;
    }

    public void afterGetDeathMaxRotation(EntityLivingBase var1) {
    }

    public void beforeGetFontRendererFromRenderManager() {
    }

    public FontRenderer getFontRendererFromRenderManager() {
        RenderPlayerBase var1 = this.internalRenderPlayerAPI.GetOverwrittenGetFontRendererFromRenderManager(this);
        Object var2 = var1 == null ? this.renderPlayerAPI.localGetFontRendererFromRenderManager() : (var1 != this ? var1.getFontRendererFromRenderManager() : null);
        return var2;
    }

    public void afterGetFontRendererFromRenderManager() {
    }

    public void beforeGetResourceLocationFromPlayer(AbstractClientPlayer var1) {
    }

    public ResourceLocation getResourceLocationFromPlayer(AbstractClientPlayer var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenGetResourceLocationFromPlayer(this);
        Object var3 = var2 == null ? this.renderPlayerAPI.localGetResourceLocationFromPlayer(var1) : (var2 != this ? var2.getResourceLocationFromPlayer(var1) : null);
        return var3;
    }

    public void afterGetResourceLocationFromPlayer(AbstractClientPlayer var1) {
    }

    public void beforeHandleRotationFloat(EntityLivingBase var1, float var2) {
    }

    public float handleRotationFloat(EntityLivingBase var1, float var2) {
        RenderPlayerBase var3 = this.internalRenderPlayerAPI.GetOverwrittenHandleRotationFloat(this);
        float var4 = var3 == null ? this.renderPlayerAPI.localHandleRotationFloat(var1, var2) : (var3 != this ? var3.handleRotationFloat(var1, var2) : 0.0f);
        return var4;
    }

    public void afterHandleRotationFloat(EntityLivingBase var1, float var2) {
    }

    public void beforeInheritRenderPass(EntityLivingBase var1, int var2, float var3) {
    }

    public int inheritRenderPass(EntityLivingBase var1, int var2, float var3) {
        RenderPlayerBase var4 = this.internalRenderPlayerAPI.GetOverwrittenInheritRenderPass(this);
        int var5 = var4 == null ? this.renderPlayerAPI.localInheritRenderPass(var1, var2, var3) : (var4 != this ? var4.inheritRenderPass(var1, var2, var3) : 0);
        return var5;
    }

    public void afterInheritRenderPass(EntityLivingBase var1, int var2, float var3) {
    }

    public void beforeLoadTexture(ResourceLocation var1) {
    }

    public void loadTexture(ResourceLocation var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenLoadTexture(this);
        if (var2 == null) {
            this.renderPlayerAPI.localLoadTexture(var1);
        } else if (var2 != this) {
            var2.loadTexture(var1);
        }
    }

    public void afterLoadTexture(ResourceLocation var1) {
    }

    public void beforeLoadTextureOfEntity(Entity var1) {
    }

    public void loadTextureOfEntity(Entity var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenLoadTextureOfEntity(this);
        if (var2 == null) {
            this.renderPlayerAPI.localLoadTextureOfEntity(var1);
        } else if (var2 != this) {
            var2.loadTextureOfEntity(var1);
        }
    }

    public void afterLoadTextureOfEntity(Entity var1) {
    }

    public void beforePassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
    }

    public void passSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
        RenderPlayerBase var8 = this.internalRenderPlayerAPI.GetOverwrittenPassSpecialRender(this);
        if (var8 == null) {
            this.renderPlayerAPI.localPassSpecialRender(var1, var2, var4, var6);
        } else if (var8 != this) {
            var8.passSpecialRender(var1, var2, var4, var6);
        }
    }

    public void afterPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
    }

    public void beforeRenderArrowsStuckInEntity(EntityLivingBase var1, float var2) {
    }

    public void renderArrowsStuckInEntity(EntityLivingBase var1, float var2) {
        RenderPlayerBase var3 = this.internalRenderPlayerAPI.GetOverwrittenRenderArrowsStuckInEntity(this);
        if (var3 == null) {
            this.renderPlayerAPI.localRenderArrowsStuckInEntity(var1, var2);
        } else if (var3 != this) {
            var3.renderArrowsStuckInEntity(var1, var2);
        }
    }

    public void afterRenderArrowsStuckInEntity(EntityLivingBase var1, float var2) {
    }

    public void beforeRenderFirstPersonArm(EntityPlayer var1) {
    }

    public void renderFirstPersonArm(EntityPlayer var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenRenderFirstPersonArm(this);
        if (var2 == null) {
            this.renderPlayerAPI.localRenderFirstPersonArm(var1);
        } else if (var2 != this) {
            var2.renderFirstPersonArm(var1);
        }
    }

    public void afterRenderFirstPersonArm(EntityPlayer var1) {
    }

    public void beforeRenderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9) {
    }

    public void renderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9) {
        RenderPlayerBase var10 = this.internalRenderPlayerAPI.GetOverwrittenRenderLivingLabel(this);
        if (var10 == null) {
            this.renderPlayerAPI.localRenderLivingLabel(var1, var2, var3, var5, var7, var9);
        } else if (var10 != this) {
            var10.renderLivingLabel(var1, var2, var3, var5, var7, var9);
        }
    }

    public void afterRenderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9) {
    }

    public void beforeRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
    }

    public void renderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        RenderPlayerBase var8 = this.internalRenderPlayerAPI.GetOverwrittenRenderModel(this);
        if (var8 == null) {
            this.renderPlayerAPI.localRenderModel(var1, var2, var3, var4, var5, var6, var7);
        } else if (var8 != this) {
            var8.renderModel(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    public void afterRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
    }

    public void beforeRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void renderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
        RenderPlayerBase var10 = this.internalRenderPlayerAPI.GetOverwrittenRenderPlayer(this);
        if (var10 == null) {
            this.renderPlayerAPI.localRenderPlayer(var1, var2, var4, var6, var8, var9);
        } else if (var10 != this) {
            var10.renderPlayer(var1, var2, var4, var6, var8, var9);
        }
    }

    public void afterRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void beforeRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
    }

    public void renderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
        RenderPlayerBase var12 = this.internalRenderPlayerAPI.GetOverwrittenRenderPlayerNameAndScoreLabel(this);
        if (var12 == null) {
            this.renderPlayerAPI.localRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        } else if (var12 != this) {
            var12.renderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        }
    }

    public void afterRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
    }

    public void beforeRenderPlayerScale(AbstractClientPlayer var1, float var2) {
    }

    public void renderPlayerScale(AbstractClientPlayer var1, float var2) {
        RenderPlayerBase var3 = this.internalRenderPlayerAPI.GetOverwrittenRenderPlayerScale(this);
        if (var3 == null) {
            this.renderPlayerAPI.localRenderPlayerScale(var1, var2);
        } else if (var3 != this) {
            var3.renderPlayerScale(var1, var2);
        }
    }

    public void afterRenderPlayerScale(AbstractClientPlayer var1, float var2) {
    }

    public void beforeRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {
    }

    public void renderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {
        RenderPlayerBase var8 = this.internalRenderPlayerAPI.GetOverwrittenRenderPlayerSleep(this);
        if (var8 == null) {
            this.renderPlayerAPI.localRenderPlayerSleep(var1, var2, var4, var6);
        } else if (var8 != this) {
            var8.renderPlayerSleep(var1, var2, var4, var6);
        }
    }

    public void afterRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {
    }

    public void beforeRenderSpecials(AbstractClientPlayer var1, float var2) {
    }

    public void renderSpecials(AbstractClientPlayer var1, float var2) {
        RenderPlayerBase var3 = this.internalRenderPlayerAPI.GetOverwrittenRenderSpecials(this);
        if (var3 == null) {
            this.renderPlayerAPI.localRenderSpecials(var1, var2);
        } else if (var3 != this) {
            var3.renderSpecials(var1, var2);
        }
    }

    public void afterRenderSpecials(AbstractClientPlayer var1, float var2) {
    }

    public void beforeRenderSwingProgress(EntityLivingBase var1, float var2) {
    }

    public float renderSwingProgress(EntityLivingBase var1, float var2) {
        RenderPlayerBase var3 = this.internalRenderPlayerAPI.GetOverwrittenRenderSwingProgress(this);
        float var4 = var3 == null ? this.renderPlayerAPI.localRenderSwingProgress(var1, var2) : (var3 != this ? var3.renderSwingProgress(var1, var2) : 0.0f);
        return var4;
    }

    public void afterRenderSwingProgress(EntityLivingBase var1, float var2) {
    }

    public void beforeRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {
    }

    public void rotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {
        RenderPlayerBase var5 = this.internalRenderPlayerAPI.GetOverwrittenRotatePlayer(this);
        if (var5 == null) {
            this.renderPlayerAPI.localRotatePlayer(var1, var2, var3, var4);
        } else if (var5 != this) {
            var5.rotatePlayer(var1, var2, var3, var4);
        }
    }

    public void afterRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {
    }

    public void beforeSetArmorModel(AbstractClientPlayer var1, int var2, float var3) {
    }

    public int setArmorModel(AbstractClientPlayer var1, int var2, float var3) {
        RenderPlayerBase var4 = this.internalRenderPlayerAPI.GetOverwrittenSetArmorModel(this);
        int var5 = var4 == null ? this.renderPlayerAPI.localSetArmorModel(var1, var2, var3) : (var4 != this ? var4.setArmorModel(var1, var2, var3) : 0);
        return var5;
    }

    public void afterSetArmorModel(AbstractClientPlayer var1, int var2, float var3) {
    }

    public void beforeSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3) {
    }

    public void setPassArmorModel(AbstractClientPlayer var1, int var2, float var3) {
        RenderPlayerBase var4 = this.internalRenderPlayerAPI.GetOverwrittenSetPassArmorModel(this);
        if (var4 == null) {
            this.renderPlayerAPI.localSetPassArmorModel(var1, var2, var3);
        } else if (var4 != this) {
            var4.setPassArmorModel(var1, var2, var3);
        }
    }

    public void afterSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3) {
    }

    public void beforeSetRenderManager(RenderManager var1) {
    }

    public void setRenderManager(RenderManager var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenSetRenderManager(this);
        if (var2 == null) {
            this.renderPlayerAPI.localSetRenderManager(var1);
        } else if (var2 != this) {
            var2.setRenderManager(var1);
        }
    }

    public void afterSetRenderManager(RenderManager var1) {
    }

    public void beforeSetRenderPassModel(ModelBase var1) {
    }

    public void setRenderPassModel(ModelBase var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenSetRenderPassModel(this);
        if (var2 == null) {
            this.renderPlayerAPI.localSetRenderPassModel(var1);
        } else if (var2 != this) {
            var2.setRenderPassModel(var1);
        }
    }

    public void afterSetRenderPassModel(ModelBase var1) {
    }

    public void beforeUpdateIcons(IconRegister var1) {
    }

    public void updateIcons(IconRegister var1) {
        RenderPlayerBase var2 = this.internalRenderPlayerAPI.GetOverwrittenUpdateIcons(this);
        if (var2 == null) {
            this.renderPlayerAPI.localUpdateIcons(var1);
        } else if (var2 != this) {
            var2.updateIcons(var1);
        }
    }

    public void afterUpdateIcons(IconRegister var1) {
    }
}

