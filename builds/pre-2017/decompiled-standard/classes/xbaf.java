/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xbaf
extends ceev {
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
        int n = entityHorse.func_110265_bP();
        if (n == 1) {
            f2 *= 0.87f;
        } else if (n == 2) {
            f2 *= 0.92f;
        }
        GL11.glScalef(f2, f2, f2);
        super.func_77041_b(entityHorse, f);
    }

    public void _a(EntityHorse entityHorse, float f, float f2, float f3, float f4, float f5, float f6) {
        if (entityHorse.func_82150_aj()) {
            this.field_77045_g.func_78087_a(f, f2, f3, f4, f5, f6, entityHorse);
        } else {
            this.func_110777_b(entityHorse);
            this.field_77045_g.func_78088_a(entityHorse, f, f2, f3, f4, f5, f6);
        }
    }

    public ResourceLocation _a(EntityHorse entityHorse) {
        if (!entityHorse.func_110239_cn()) {
            switch (entityHorse.func_110265_bP()) {
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
        String string = entityHorse.func_110264_co();
        ResourceLocation resourceLocation = (ResourceLocation)_a.get(string);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string);
            xpzm._E()._R()._a(resourceLocation, new gqtb(entityHorse.func_110212_cp()));
            _a.put(string, resourceLocation);
        }
        return resourceLocation;
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityHorse)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77036_a(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this._a((EntityHorse)entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityHorse)entity);
    }
}

