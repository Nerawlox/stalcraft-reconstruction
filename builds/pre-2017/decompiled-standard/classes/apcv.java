/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class apcv
extends tfvm {
    public tgdv _a;
    public int _b;

    public apcv(tgdv tgdv2, int n) {
        this._a = tgdv2;
        this._b = n;
    }

    public apcv(tgdv tgdv2) {
        this(tgdv2, 0);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        dwan dwan2 = this._a.func_77617_a(this._b);
        if (dwan2 == null) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_110777_b(entity);
        htvf htvf2 = htvf.field_78398_a;
        if (dwan2 == zyyc._a("bottle_splash")) {
            int n = hdoy._a(((EntityPotion)entity).func_70196_i(), false);
            float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
            float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f5 = (float)(n & 0xFF) / 255.0f;
            GL11.glColor3f(f3, f4, f5);
            GL11.glPushMatrix();
            this._a(htvf2, zyyc._a("overlay"));
            GL11.glPopMatrix();
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
        }
        this._a(htvf2, dwan2);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return sctd._e;
    }

    public void _a(htvf htvf2, dwan dwan2) {
        float f = dwan2.func_94209_e();
        float f2 = dwan2.func_94212_f();
        float f3 = dwan2.func_94206_g();
        float f4 = dwan2.func_94210_h();
        float f5 = 1.0f;
        float f6 = 0.5f;
        float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78374_a(0.0f - f6, 0.0f - f7, 0.0, f, f4);
        htvf2.func_78374_a(f5 - f6, 0.0f - f7, 0.0, f2, f4);
        htvf2.func_78374_a(f5 - f6, f5 - f7, 0.0, f2, f3);
        htvf2.func_78374_a(0.0f - f6, f5 - f7, 0.0, f, f3);
        htvf2.func_78381_a();
    }
}

