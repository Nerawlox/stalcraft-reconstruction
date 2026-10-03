/*
 * Decompiled with CFR 0.152.
 */
package api.player.render;

import api.player.render.RenderPlayerAPI;
import java.lang.reflect.Method;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class RenderPlayerBase {
    protected final RenderPlayer renderPlayer;
    private final RenderPlayerAPI renderPlayerAPI;
    private Method[] methods;

    public RenderPlayerBase(RenderPlayerAPI renderPlayerAPI) {
        this.renderPlayerAPI = renderPlayerAPI;
        this.renderPlayer = renderPlayerAPI.renderPlayer;
    }

    public void beforeBaseAttach(boolean bl) {
    }

    public void afterBaseAttach(boolean bl) {
    }

    public void beforeLocalConstructing() {
    }

    public void afterLocalConstructing() {
    }

    public void beforeBaseDetach(boolean bl) {
    }

    public void afterBaseDetach(boolean bl) {
    }

    public Object dynamic(String string, Object[] objectArray) {
        return this.renderPlayerAPI.dynamicOverwritten(string, objectArray, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeDoRenderLabel(EntityLivingBase entityLivingBase) {
    }

    public boolean doRenderLabel(EntityLivingBase entityLivingBase) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenDoRenderLabel(this);
        boolean bl = renderPlayerBase == null ? this.renderPlayer.localDoRenderLabel(entityLivingBase) : (renderPlayerBase != this ? renderPlayerBase.doRenderLabel(entityLivingBase) : false);
        return bl;
    }

    public void afterDoRenderLabel(EntityLivingBase entityLivingBase) {
    }

    public void beforeDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
    }

    public void doRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenDoRenderShadowAndFire(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localDoRenderShadowAndFire(entity, d, d2, d3, f, f2);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
        }
    }

    public void afterDoRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
    }

    public void beforeGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
    }

    public int getColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenGetColorMultiplier(this);
        int n = renderPlayerBase == null ? this.renderPlayer.localGetColorMultiplier(entityLivingBase, f, f2) : (renderPlayerBase != this ? renderPlayerBase.getColorMultiplier(entityLivingBase, f, f2) : 0);
        return n;
    }

    public void afterGetColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
    }

    public void beforeGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
    }

    public float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenGetDeathMaxRotation(this);
        float f = renderPlayerBase == null ? this.renderPlayer.localGetDeathMaxRotation(entityLivingBase) : (renderPlayerBase != this ? renderPlayerBase.getDeathMaxRotation(entityLivingBase) : 0.0f);
        return f;
    }

    public void afterGetDeathMaxRotation(EntityLivingBase entityLivingBase) {
    }

    public void beforeGetFontRendererFromRenderManager() {
    }

    public FontRenderer getFontRendererFromRenderManager() {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenGetFontRendererFromRenderManager(this);
        FontRenderer fontRenderer = renderPlayerBase == null ? this.renderPlayer.localGetFontRendererFromRenderManager() : (renderPlayerBase != this ? renderPlayerBase.getFontRendererFromRenderManager() : null);
        return fontRenderer;
    }

    public void afterGetFontRendererFromRenderManager() {
    }

    public void beforeGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
    }

    public ResourceLocation getResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenGetResourceLocationFromPlayer(this);
        ResourceLocation resourceLocation = renderPlayerBase == null ? this.renderPlayer.localGetResourceLocationFromPlayer(abstractClientPlayer) : (renderPlayerBase != this ? renderPlayerBase.getResourceLocationFromPlayer(abstractClientPlayer) : null);
        return resourceLocation;
    }

    public void afterGetResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
    }

    public void beforeHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
    }

    public float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenHandleRotationFloat(this);
        float f2 = renderPlayerBase == null ? this.renderPlayer.localHandleRotationFloat(entityLivingBase, f) : (renderPlayerBase != this ? renderPlayerBase.handleRotationFloat(entityLivingBase, f) : 0.0f);
        return f2;
    }

    public void afterHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
    }

    public void beforeInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
    }

    public int inheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenInheritRenderPass(this);
        int n2 = renderPlayerBase == null ? this.renderPlayer.localInheritRenderPass(entityLivingBase, n, f) : (renderPlayerBase != this ? renderPlayerBase.inheritRenderPass(entityLivingBase, n, f) : 0);
        return n2;
    }

    public void afterInheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
    }

    public void beforeLoadTexture(ResourceLocation resourceLocation) {
    }

    public void loadTexture(ResourceLocation resourceLocation) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenLoadTexture(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localLoadTexture(resourceLocation);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.loadTexture(resourceLocation);
        }
    }

    public void afterLoadTexture(ResourceLocation resourceLocation) {
    }

    public void beforeLoadTextureOfEntity(Entity entity) {
    }

    public void loadTextureOfEntity(Entity entity) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenLoadTextureOfEntity(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localLoadTextureOfEntity(entity);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.loadTextureOfEntity(entity);
        }
    }

    public void afterLoadTextureOfEntity(Entity entity) {
    }

    public void beforePassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
    }

    public void passSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenPassSpecialRender(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localPassSpecialRender(entityLivingBase, d, d2, d3);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.passSpecialRender(entityLivingBase, d, d2, d3);
        }
    }

    public void afterPassSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
    }

    public void beforeRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
    }

    public void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderArrowsStuckInEntity(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderArrowsStuckInEntity(entityLivingBase, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderArrowsStuckInEntity(entityLivingBase, f);
        }
    }

    public void afterRenderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
    }

    public void beforeRenderFirstPersonArm(EntityPlayer entityPlayer) {
    }

    public void renderFirstPersonArm(EntityPlayer entityPlayer) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderFirstPersonArm(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderFirstPersonArm(entityPlayer);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderFirstPersonArm(entityPlayer);
        }
    }

    public void afterRenderFirstPersonArm(EntityPlayer entityPlayer) {
    }

    public void beforeRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
    }

    public void renderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderLivingLabel(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        }
    }

    public void afterRenderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
    }

    public void beforeRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void renderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderModel(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        }
    }

    public void afterRenderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void beforeRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
    }

    public void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderPlayer(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        }
    }

    public void afterRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
    }

    public void beforeRenderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
    }

    public void renderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderPlayerNameAndScoreLabel(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        }
    }

    public void afterRenderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
    }

    public void beforeRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderPlayerScale(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderPlayerScale(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderPlayerScale(abstractClientPlayer, f);
        }
    }

    public void afterRenderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforeRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
    }

    public void renderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderPlayerSleep(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderPlayerSleep(abstractClientPlayer, d, d2, d3);
        }
    }

    public void afterRenderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
    }

    public void beforeRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSpecials(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderSpecials(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderSpecials(abstractClientPlayer, f);
        }
    }

    public void afterRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforeRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
    }

    public float renderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSwingProgress(this);
        float f2 = renderPlayerBase == null ? this.renderPlayer.localRenderSwingProgress(entityLivingBase, f) : (renderPlayerBase != this ? renderPlayerBase.renderSwingProgress(entityLivingBase, f) : 0.0f);
        return f2;
    }

    public void afterRenderSwingProgress(EntityLivingBase entityLivingBase, float f) {
    }

    public void beforeRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
    }

    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRotatePlayer(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRotatePlayer(abstractClientPlayer, f, f2, f3);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.rotatePlayer(abstractClientPlayer, f, f2, f3);
        }
    }

    public void afterRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
    }

    public void beforeSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
    }

    public int setArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenSetArmorModel(this);
        int n2 = renderPlayerBase == null ? this.renderPlayer.localSetArmorModel(abstractClientPlayer, n, f) : (renderPlayerBase != this ? renderPlayerBase.setArmorModel(abstractClientPlayer, n, f) : 0);
        return n2;
    }

    public void afterSetArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
    }

    public void beforeSetPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
    }

    public void setPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenSetPassArmorModel(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localSetPassArmorModel(abstractClientPlayer, n, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.setPassArmorModel(abstractClientPlayer, n, f);
        }
    }

    public void afterSetPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
    }

    public void beforeSetRenderManager(RenderManager renderManager) {
    }

    public void setRenderManager(RenderManager renderManager) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenSetRenderManager(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localSetRenderManager(renderManager);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.setRenderManager(renderManager);
        }
    }

    public void afterSetRenderManager(RenderManager renderManager) {
    }

    public void beforeSetRenderPassModel(ModelBase modelBase) {
    }

    public void setRenderPassModel(ModelBase modelBase) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenSetRenderPassModel(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localSetRenderPassModel(modelBase);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.setRenderPassModel(modelBase);
        }
    }

    public void afterSetRenderPassModel(ModelBase modelBase) {
    }

    public void beforeUpdateIcons(IconRegister iconRegister) {
    }

    public void updateIcons(IconRegister iconRegister) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenUpdateIcons(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localUpdateIcons(iconRegister);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.updateIcons(iconRegister);
        }
    }

    public void afterUpdateIcons(IconRegister iconRegister) {
    }

    public void beforeRenderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSpecialHeadArmor(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderSpecialHeadArmor(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderSpecialHeadArmor(abstractClientPlayer, f);
        }
    }

    public void afterRenderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforeRenderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSpecialHeadEars(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderSpecialHeadEars(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderSpecialHeadEars(abstractClientPlayer, f);
        }
    }

    public void afterRenderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforeRenderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSpecialCloak(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderSpecialCloak(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderSpecialCloak(abstractClientPlayer, f);
        }
    }

    public void afterRenderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforeRenderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void renderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenRenderSpecialItemInHand(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localRenderSpecialItemInHand(abstractClientPlayer, f);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.renderSpecialItemInHand(abstractClientPlayer, f);
        }
    }

    public void afterRenderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
    }

    public void beforePositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
    }

    public void positionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        RenderPlayerBase renderPlayerBase = this.renderPlayerAPI.GetOverwrittenPositionSpecialItemInHand(this);
        if (renderPlayerBase == null) {
            this.renderPlayer.localPositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        } else if (renderPlayerBase != this) {
            renderPlayerBase.positionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        }
    }

    public void afterPositionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
    }
}

