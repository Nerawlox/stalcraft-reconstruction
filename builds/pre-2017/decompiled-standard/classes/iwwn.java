/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class iwwn
extends tfvm {
    public float _a;

    public iwwn(float f) {
        this._a = f;
    }

    public void _a(EntityFireball entityFireball, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        this.func_110777_b(entityFireball);
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        float f3 = this._a;
        GL11.glScalef(f3 / 1.0f, f3 / 1.0f, f3 / 1.0f);
        dwan dwan2 = tgdv.field_77811_bE.func_77617_a(0);
        htvf htvf2 = htvf.field_78398_a;
        float f4 = dwan2.func_94209_e();
        float f5 = dwan2.func_94212_f();
        float f6 = dwan2.func_94206_g();
        float f7 = dwan2.func_94210_h();
        float f8 = 1.0f;
        float f9 = 0.5f;
        float f10 = 0.25f;
        GL11.glRotatef(180.0f - this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78374_a(0.0f - f9, 0.0f - f10, 0.0, f4, f7);
        htvf2.func_78374_a(f8 - f9, 0.0f - f10, 0.0, f5, f7);
        htvf2.func_78374_a(f8 - f9, 1.0f - f10, 0.0, f5, f6);
        htvf2.func_78374_a(0.0f - f9, 1.0f - f10, 0.0, f4, f6);
        htvf2.func_78381_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityFireball entityFireball) {
        return sctd._e;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityFireball)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFireball)entity, d, d2, d3, f, f2);
    }
}

