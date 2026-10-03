/*
 * Decompiled with CFR 0.152.
 */
package api.player.model;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelPlayer
extends ModelBiped {
    public final ModelPlayerAPI modelPlayerAPI = ModelPlayerAPI.create(this);

    public ModelPlayer(float f) {
        super(f);
        ModelPlayerAPI.beforeLocalConstructing(this, f);
        ModelPlayerAPI.afterLocalConstructing(this, f);
    }

    public final ModelPlayerBase getModelPlayerBase(String string) {
        if (this.modelPlayerAPI != null) {
            return this.modelPlayerAPI.getModelPlayerBase(string);
        }
        return null;
    }

    public final Set<String> getModelPlayerBaseIds(String string) {
        Set<String> set = null;
        set = this.modelPlayerAPI != null ? this.modelPlayerAPI.getModelPlayerBaseIds() : Collections.emptySet();
        return set;
    }

    public Object dynamic(String string, Object[] objectArray) {
        if (this.modelPlayerAPI != null) {
            return this.modelPlayerAPI.dynamic(string, objectArray);
        }
        return null;
    }

    @Override
    public ModelRenderer getRandomModelBox(Random random) {
        ModelRenderer modelRenderer = this.modelPlayerAPI != null && this.modelPlayerAPI.isGetRandomModelBoxModded ? ModelPlayerAPI.getRandomModelBox(this, random) : super.getRandomModelBox(random);
        return modelRenderer;
    }

    public final ModelRenderer superGetRandomModelBox(Random random) {
        return super.getRandomModelBox(random);
    }

    public final ModelRenderer localGetRandomModelBox(Random random) {
        return super.getRandomModelBox(random);
    }

    @Override
    public TextureOffset getTextureOffset(String string) {
        TextureOffset textureOffset = this.modelPlayerAPI != null && this.modelPlayerAPI.isGetTextureOffsetModded ? ModelPlayerAPI.getTextureOffset(this, string) : super.getTextureOffset(string);
        return textureOffset;
    }

    public final TextureOffset superGetTextureOffset(String string) {
        return super.getTextureOffset(string);
    }

    public final TextureOffset localGetTextureOffset(String string) {
        return super.getTextureOffset(string);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isRenderModded) {
            ModelPlayerAPI.render(this, entity, f, f2, f3, f4, f5, f6);
        } else {
            super.render(entity, f, f2, f3, f4, f5, f6);
        }
    }

    public final void superRender(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
    }

    public final void localRender(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
    }

    @Override
    public void renderCloak(float f) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isRenderCloakModded) {
            ModelPlayerAPI.renderCloak(this, f);
        } else {
            super.renderCloak(f);
        }
    }

    public final void superRenderCloak(float f) {
        super.renderCloak(f);
    }

    public final void localRenderCloak(float f) {
        super.renderCloak(f);
    }

    @Override
    public void renderEars(float f) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isRenderEarsModded) {
            ModelPlayerAPI.renderEars(this, f);
        } else {
            super.renderEars(f);
        }
    }

    public final void superRenderEars(float f) {
        super.renderEars(f);
    }

    public final void localRenderEars(float f) {
        super.renderEars(f);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isSetLivingAnimationsModded) {
            ModelPlayerAPI.setLivingAnimations(this, entityLivingBase, f, f2, f3);
        } else {
            super.setLivingAnimations(entityLivingBase, f, f2, f3);
        }
    }

    public final void superSetLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.setLivingAnimations(entityLivingBase, f, f2, f3);
    }

    public final void localSetLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.setLivingAnimations(entityLivingBase, f, f2, f3);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isSetRotationAnglesModded) {
            ModelPlayerAPI.setRotationAngles(this, f, f2, f3, f4, f5, f6, entity);
        } else {
            super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
    }

    public final void superSetRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }

    public final void localSetRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }

    @Override
    public void setTextureOffset(String string, int n, int n2) {
        if (this.modelPlayerAPI != null && this.modelPlayerAPI.isSetTextureOffsetModded) {
            ModelPlayerAPI.setTextureOffset(this, string, n, n2);
        } else {
            super.setTextureOffset(string, n, n2);
        }
    }

    public final void realSetTextureOffset(String string, int n, int n2) {
        this.setTextureOffset(string, n, n2);
    }

    public final void superSetTextureOffset(String string, int n, int n2) {
        super.setTextureOffset(string, n, n2);
    }

    public final void localSetTextureOffset(String string, int n, int n2) {
        super.setTextureOffset(string, n, n2);
    }

    public static ModelPlayer[] getAllInstances() {
        return ModelPlayerAPI.getAllInstances();
    }
}

