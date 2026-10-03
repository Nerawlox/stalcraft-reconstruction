/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class tfun
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/slime/magmacube.png");

    public tfun() {
        super(new ModelMagmaCube(), 0.25f);
    }

    public ResourceLocation _a(EntityMagmaCube entityMagmaCube) {
        return _a;
    }

    public void _a(EntityMagmaCube entityMagmaCube, float f) {
        int n = entityMagmaCube.getSlimeSize();
        float f2 = (entityMagmaCube.prevSquishFactor + (entityMagmaCube.squishFactor - entityMagmaCube.prevSquishFactor) * f) / ((float)n * 0.5f + 1.0f);
        float f3 = 1.0f / (f2 + 1.0f);
        float f4 = n;
        GL11.glScalef(f3 * f4, 1.0f / f3 * f4, f3 * f4);
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityMagmaCube)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityMagmaCube)entity);
    }
}

