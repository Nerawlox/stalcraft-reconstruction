/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class zyhv
extends tfvm {
    public final htvc _a = new htvc();

    public zyhv() {
        this.field_76989_e = 0.5f;
    }

    public void _a(EntityFallingSand entityFallingSand, double d, double d2, double d3, float f, float f2) {
        ozlu ozlu2 = entityFallingSand.func_70283_d();
        twgu twgu2 = twgu.field_71973_m[entityFallingSand.field_70287_a];
        if (ozlu2.func_72798_a(sajh._c(entityFallingSand.field_70165_t), sajh._c(entityFallingSand.field_70163_u), sajh._c(entityFallingSand.field_70161_v)) != entityFallingSand.field_70287_a) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d, (float)d2, (float)d3);
            this.func_110777_b(entityFallingSand);
            GL11.glDisable(2896);
            if (twgu2 instanceof scce && twgu2.func_71857_b() == 35) {
                this._a._a = ozlu2;
                htvf htvf2 = htvf.field_78398_a;
                htvf2.func_78382_b();
                htvf2.func_78373_b((float)(-sajh._c(entityFallingSand.field_70165_t)) - 0.5f, (float)(-sajh._c(entityFallingSand.field_70163_u)) - 0.5f, (float)(-sajh._c(entityFallingSand.field_70161_v)) - 0.5f);
                this._a._a((scce)twgu2, sajh._c(entityFallingSand.field_70165_t), sajh._c(entityFallingSand.field_70163_u), sajh._c(entityFallingSand.field_70161_v), entityFallingSand.field_70285_b);
                htvf2.func_78373_b(0.0, 0.0, 0.0);
                htvf2.func_78381_a();
            } else if (twgu2.func_71857_b() == 27) {
                this._a._a = ozlu2;
                htvf htvf3 = htvf.field_78398_a;
                htvf3.func_78382_b();
                htvf3.func_78373_b((float)(-sajh._c(entityFallingSand.field_70165_t)) - 0.5f, (float)(-sajh._c(entityFallingSand.field_70163_u)) - 0.5f, (float)(-sajh._c(entityFallingSand.field_70161_v)) - 0.5f);
                this._a._a((yutb)twgu2, sajh._c(entityFallingSand.field_70165_t), sajh._c(entityFallingSand.field_70163_u), sajh._c(entityFallingSand.field_70161_v));
                htvf3.func_78373_b(0.0, 0.0, 0.0);
                htvf3.func_78381_a();
            } else if (twgu2 != null) {
                this._a._a(twgu2);
                this._a._a(twgu2, ozlu2, sajh._c(entityFallingSand.field_70165_t), sajh._c(entityFallingSand.field_70163_u), sajh._c(entityFallingSand.field_70161_v), entityFallingSand.field_70285_b);
            }
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation _a(EntityFallingSand entityFallingSand) {
        return sctd._c;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityFallingSand)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFallingSand)entity, d, d2, d3, f, f2);
    }
}

