/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xbaf
extends RenderLiving {
    public static final Map _a = Maps.newHashMap();
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/horse/horse_white.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/horse/mule.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/horse/donkey.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/entity/horse/horse_zombie.png");
    public static final ResourceLocation _f = new ResourceLocation("textures/entity/horse/horse_skeleton.png");

    public xbaf(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntityHorse entityHorse, float f) {
        float f2 = 1.0f;
        int n = entityHorse.getHorseType();
        if (n == 1) {
            f2 *= 0.87f;
        } else if (n == 2) {
            f2 *= 0.92f;
        }
        GL11.glScalef(f2, f2, f2);
        super.preRenderCallback(entityHorse, f);
    }

    public void _a(EntityHorse entityHorse, float f, float f2, float f3, float f4, float f5, float f6) {
        if (entityHorse.isInvisible()) {
            this.mainModel.setRotationAngles(f, f2, f3, f4, f5, f6, entityHorse);
        } else {
            this.bindEntityTexture(entityHorse);
            this.mainModel.render(entityHorse, f, f2, f3, f4, f5, f6);
        }
    }

    public ResourceLocation _a(EntityHorse entityHorse) {
        if (!entityHorse.func_110239_cn()) {
            switch (entityHorse.getHorseType()) {
                default: {
                    return _b;
                }
                case 2: {
                    return _c;
                }
                case 1: {
                    return _d;
                }
                case 3: {
                    return _e;
                }
                case 4: 
            }
            return _f;
        }
        return this._b(entityHorse);
    }

    public ResourceLocation _b(EntityHorse entityHorse) {
        String string = entityHorse.getHorseTexture();
        ResourceLocation resourceLocation = (ResourceLocation)_a.get(string);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string);
            Minecraft._E()._R()._a(resourceLocation, new gqtb(entityHorse.getVariantTexturePaths()));
            _a.put(string, resourceLocation);
        }
        return resourceLocation;
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityHorse)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void renderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this._a((EntityHorse)entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityHorse)entity);
    }
}

