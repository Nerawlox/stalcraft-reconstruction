/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class zhjn
extends ifvk {
    public static final ResourceLocation _g = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation _h = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");

    public zhjn() {
        super(new ModelSkeleton(), 0.5f);
    }

    public void _a(EntitySkeleton entitySkeleton, float f) {
        if (entitySkeleton.getSkeletonType() == 1) {
            GL11.glScalef(1.2f, 1.2f, 1.2f);
        }
    }

    @Override
    public void _b() {
        GL11.glTranslatef(0.09375f, 0.1875f, 0.0f);
    }

    public ResourceLocation _a(EntitySkeleton entitySkeleton) {
        if (entitySkeleton.getSkeletonType() == 1) {
            return _h;
        }
        return _g;
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntitySkeleton)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntitySkeleton)entity);
    }
}

