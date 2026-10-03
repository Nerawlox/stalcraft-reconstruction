/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class zhlw
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/wither/wither.png");
    public final ModelSkeletonHead _c = new ModelSkeletonHead();

    public float _a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public void _a(EntityWitherSkull entityWitherSkull, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        float f3 = this._a(entityWitherSkull.prevRotationYaw, entityWitherSkull.rotationYaw, f2);
        float f4 = entityWitherSkull.prevRotationPitch + (entityWitherSkull.rotationPitch - entityWitherSkull.prevRotationPitch) * f2;
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        float f5 = 0.0625f;
        GL11.glEnable(32826);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glEnable(3008);
        this.bindEntityTexture(entityWitherSkull);
        this._c.render(entityWitherSkull, 0.0f, 0.0f, 0.0f, f3, f4, f5);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityWitherSkull entityWitherSkull) {
        return entityWitherSkull.isInvulnerable() ? _a : _b;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityWitherSkull)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitherSkull)entity, d, d2, d3, f, f2);
    }
}

