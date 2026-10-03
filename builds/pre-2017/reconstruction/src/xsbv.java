/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xsbv
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/ghast/ghast.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");

    public xsbv() {
        super(new ModelGhast(), 0.5f);
    }

    public ResourceLocation _a(EntityGhast entityGhast) {
        if (entityGhast.func_110182_bF()) {
            return _b;
        }
        return _a;
    }

    public void _a(EntityGhast entityGhast, float f) {
        EntityGhast entityGhast2 = entityGhast;
        float f2 = ((float)entityGhast2.prevAttackCounter + (float)(entityGhast2.attackCounter - entityGhast2.prevAttackCounter) * f) / 20.0f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        f2 = 1.0f / (f2 * f2 * f2 * f2 * f2 * 2.0f + 1.0f);
        float f3 = (8.0f + f2) / 2.0f;
        float f4 = (8.0f + 1.0f / f2) / 2.0f;
        GL11.glScalef(f4, f3, f4);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityGhast)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityGhast)entity);
    }
}

