/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class bbfe
extends tfvm {
    public htvc _a = new htvc();

    public bbfe() {
        this.field_76989_e = 0.5f;
    }

    public void _a(EntityTNTPrimed entityTNTPrimed, double d, double d2, double d3, float f, float f2) {
        float f3;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        if ((float)entityTNTPrimed.field_70516_a - f2 + 1.0f < 10.0f) {
            f3 = 1.0f - ((float)entityTNTPrimed.field_70516_a - f2 + 1.0f) / 10.0f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            f3 *= f3;
            f3 *= f3;
            float f4 = 1.0f + f3 * 0.3f;
            GL11.glScalef(f4, f4, f4);
        }
        f3 = (1.0f - ((float)entityTNTPrimed.field_70516_a - f2 + 1.0f) / 100.0f) * 0.8f;
        this.func_110777_b(entityTNTPrimed);
        this._a._a(twgu.field_72091_am, 0, entityTNTPrimed.func_70013_c(f2));
        if (entityTNTPrimed.field_70516_a / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f3);
            this._a._a(twgu.field_72091_am, 0, 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityTNTPrimed entityTNTPrimed) {
        return sctd._c;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityTNTPrimed)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityTNTPrimed)entity, d, d2, d3, f, f2);
    }
}

