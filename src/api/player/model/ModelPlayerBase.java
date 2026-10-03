/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.model.TextureOffset
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 */
package api.player.model;

import api.player.model.IModelPlayer;
import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerAPI;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public abstract class ModelPlayerBase {
    protected final ModelPlayer modelPlayer;
    protected final IModelPlayer modelPlayerAPI;
    private final ModelPlayerAPI internalModelPlayerAPI;

    public ModelPlayerBase(ModelPlayerAPI var1) {
        this.internalModelPlayerAPI = var1;
        this.modelPlayerAPI = var1.modelPlayer;
        this.modelPlayer = var1.modelPlayer.getModelPlayer();
    }

    public void beforeBaseAttach(boolean var1) {
    }

    public void afterBaseAttach(boolean var1) {
    }

    public void beforeLocalConstructing(float var1) {
    }

    public void afterLocalConstructing(float var1) {
    }

    public void beforeBaseDetach(boolean var1) {
    }

    public void afterBaseDetach(boolean var1) {
    }

    public Object dynamic(String var1, Object[] var2) {
        return this.internalModelPlayerAPI.dynamicOverwritten(var1, var2, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeGetRandomModelBox(Random var1) {
    }

    public ModelRenderer getRandomModelBox(Random var1) {
        ModelPlayerBase var2 = this.internalModelPlayerAPI.GetOverwrittenGetRandomModelBox(this);
        Object var3 = var2 == null ? this.modelPlayerAPI.localGetRandomModelBox(var1) : (var2 != this ? var2.getRandomModelBox(var1) : null);
        return var3;
    }

    public void afterGetRandomModelBox(Random var1) {
    }

    public void beforeGetTextureOffset(String var1) {
    }

    public TextureOffset getTextureOffset(String var1) {
        ModelPlayerBase var2 = this.internalModelPlayerAPI.GetOverwrittenGetTextureOffset(this);
        Object var3 = var2 == null ? this.modelPlayerAPI.localGetTextureOffset(var1) : (var2 != this ? var2.getTextureOffset(var1) : null);
        return var3;
    }

    public void afterGetTextureOffset(String var1) {
    }

    public void beforeRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
    }

    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        ModelPlayerBase var8 = this.internalModelPlayerAPI.GetOverwrittenRender(this);
        if (var8 == null) {
            this.modelPlayerAPI.localRender(var1, var2, var3, var4, var5, var6, var7);
        } else if (var8 != this) {
            var8.render(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    public void afterRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
    }

    public void beforeRenderCloak(float var1) {
    }

    public void renderCloak(float var1) {
        ModelPlayerBase var2 = this.internalModelPlayerAPI.GetOverwrittenRenderCloak(this);
        if (var2 == null) {
            this.modelPlayerAPI.localRenderCloak(var1);
        } else if (var2 != this) {
            var2.renderCloak(var1);
        }
    }

    public void afterRenderCloak(float var1) {
    }

    public void beforeRenderEars(float var1) {
    }

    public void renderEars(float var1) {
        ModelPlayerBase var2 = this.internalModelPlayerAPI.GetOverwrittenRenderEars(this);
        if (var2 == null) {
            this.modelPlayerAPI.localRenderEars(var1);
        } else if (var2 != this) {
            var2.renderEars(var1);
        }
    }

    public void afterRenderEars(float var1) {
    }

    public void beforeSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
    }

    public void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
        ModelPlayerBase var5 = this.internalModelPlayerAPI.GetOverwrittenSetLivingAnimations(this);
        if (var5 == null) {
            this.modelPlayerAPI.localSetLivingAnimations(var1, var2, var3, var4);
        } else if (var5 != this) {
            var5.setLivingAnimations(var1, var2, var3, var4);
        }
    }

    public void afterSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
    }

    public void beforeSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
        ModelPlayerBase var8 = this.internalModelPlayerAPI.GetOverwrittenSetRotationAngles(this);
        if (var8 == null) {
            this.modelPlayerAPI.localSetRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        } else if (var8 != this) {
            var8.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    public void afterSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
    }

    public void beforeSetTextureOffset(String var1, int var2, int var3) {
    }

    public void setTextureOffset(String var1, int var2, int var3) {
        ModelPlayerBase var4 = this.internalModelPlayerAPI.GetOverwrittenSetTextureOffset(this);
        if (var4 == null) {
            this.modelPlayerAPI.localSetTextureOffset(var1, var2, var3);
        } else if (var4 != this) {
            var4.setTextureOffset(var1, var2, var3);
        }
    }

    public void afterSetTextureOffset(String var1, int var2, int var3) {
    }
}

