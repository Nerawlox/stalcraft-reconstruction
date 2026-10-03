/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class hcsl
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/boat.png");
    public ModelBase _b;

    public hcsl() {
        this.field_76989_e = 0.5f;
        this._b = new ModelBoat();
    }

    public void _a(EntityBoat entityBoat, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(180.0f - f, 0.0f, 1.0f, 0.0f);
        float f3 = (float)entityBoat.func_70268_h() - f2;
        float f4 = entityBoat.func_70271_g() - f2;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f3 > 0.0f) {
            GL11.glRotatef(sajh._a(f3) * f3 * f4 / 10.0f * (float)entityBoat.func_70267_i(), 1.0f, 0.0f, 0.0f);
        }
        float f5 = 0.75f;
        GL11.glScalef(f5, f5, f5);
        GL11.glScalef(1.0f / f5, 1.0f / f5, 1.0f / f5);
        this.func_110777_b(entityBoat);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this._b.func_78088_a(entityBoat, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityBoat entityBoat) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityBoat)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBoat)entity, d, d2, d3, f, f2);
    }
}

