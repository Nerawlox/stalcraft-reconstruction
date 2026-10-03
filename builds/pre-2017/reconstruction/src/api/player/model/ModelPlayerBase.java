/*
 * Decompiled with CFR 0.152.
 */
package api.player.model;

import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerAPI;
import java.lang.reflect.Method;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public abstract class ModelPlayerBase {
    protected final ModelPlayer modelPlayer;
    private final ModelPlayerAPI modelPlayerAPI;
    private Method[] methods;

    public ModelPlayerBase(ModelPlayerAPI modelPlayerAPI) {
        this.modelPlayerAPI = modelPlayerAPI;
        this.modelPlayer = modelPlayerAPI.modelPlayer;
    }

    public void beforeBaseAttach(boolean bl) {
    }

    public void afterBaseAttach(boolean bl) {
    }

    public void beforeLocalConstructing(float f) {
    }

    public void afterLocalConstructing(float f) {
    }

    public void beforeBaseDetach(boolean bl) {
    }

    public void afterBaseDetach(boolean bl) {
    }

    public Object dynamic(String string, Object[] objectArray) {
        return this.modelPlayerAPI.dynamicOverwritten(string, objectArray, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeGetRandomModelBox(Random random) {
    }

    public ModelRenderer getRandomModelBox(Random random) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenGetRandomModelBox(this);
        ModelRenderer modelRenderer = modelPlayerBase == null ? this.modelPlayer.localGetRandomModelBox(random) : (modelPlayerBase != this ? modelPlayerBase.getRandomModelBox(random) : null);
        return modelRenderer;
    }

    public void afterGetRandomModelBox(Random random) {
    }

    public void beforeGetTextureOffset(String string) {
    }

    public TextureOffset getTextureOffset(String string) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenGetTextureOffset(this);
        TextureOffset textureOffset = modelPlayerBase == null ? this.modelPlayer.localGetTextureOffset(string) : (modelPlayerBase != this ? modelPlayerBase.getTextureOffset(string) : null);
        return textureOffset;
    }

    public void afterGetTextureOffset(String string) {
    }

    public void beforeRender(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenRender(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localRender(entity, f, f2, f3, f4, f5, f6);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.render(entity, f, f2, f3, f4, f5, f6);
        }
    }

    public void afterRender(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void beforeRenderCloak(float f) {
    }

    public void renderCloak(float f) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenRenderCloak(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localRenderCloak(f);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.renderCloak(f);
        }
    }

    public void afterRenderCloak(float f) {
    }

    public void beforeRenderEars(float f) {
    }

    public void renderEars(float f) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenRenderEars(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localRenderEars(f);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.renderEars(f);
        }
    }

    public void afterRenderEars(float f) {
    }

    public void beforeSetLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenSetLivingAnimations(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localSetLivingAnimations(entityLivingBase, f, f2, f3);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.setLivingAnimations(entityLivingBase, f, f2, f3);
        }
    }

    public void afterSetLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public void beforeSetRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenSetRotationAngles(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
    }

    public void afterSetRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    public void beforeSetTextureOffset(String string, int n, int n2) {
    }

    public void setTextureOffset(String string, int n, int n2) {
        ModelPlayerBase modelPlayerBase = this.modelPlayerAPI.GetOverwrittenSetTextureOffset(this);
        if (modelPlayerBase == null) {
            this.modelPlayer.localSetTextureOffset(string, n, n2);
        } else if (modelPlayerBase != this) {
            modelPlayerBase.setTextureOffset(string, n, n2);
        }
    }

    public void afterSetTextureOffset(String string, int n, int n2) {
    }
}

