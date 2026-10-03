/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class yvek
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/lead_knot.png");
    public ModelLeashKnot _b = new ModelLeashKnot();

    public void _a(EntityLeashKnot entityLeashKnot, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        float f3 = 0.0625f;
        GL11.glEnable(32826);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glEnable(3008);
        this.bindEntityTexture(entityLeashKnot);
        this._b.render(entityLeashKnot, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f3);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityLeashKnot entityLeashKnot) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityLeashKnot)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityLeashKnot)entity, d, d2, d3, f, f2);
    }
}

