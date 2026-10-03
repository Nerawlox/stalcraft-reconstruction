/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class bsfh
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/endercrystal/endercrystal.png");
    public ModelBase _b;

    public bsfh() {
        this.shadowSize = 0.5f;
        this._b = new ModelEnderCrystal(0.0f, true);
    }

    public void _a(EntityEnderCrystal entityEnderCrystal, double d, double d2, double d3, float f, float f2) {
        float f3 = (float)entityEnderCrystal.innerRotation + f2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        this.bindTexture(_a);
        float f4 = sajh._a(f3 * 0.2f) / 2.0f + 0.5f;
        f4 = f4 * f4 + f4;
        this._b.render(entityEnderCrystal, 0.0f, f3 * 3.0f, f4 * 0.2f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityEnderCrystal entityEnderCrystal) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityEnderCrystal)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityEnderCrystal)entity, d, d2, d3, f, f2);
    }
}

