/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class twzo
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/slime/slime.png");
    public ModelBase _b;

    public twzo(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this._b = modelBase2;
    }

    public int _a(EntitySlime entitySlime, int n, float f) {
        if (entitySlime.func_82150_aj()) {
            return 0;
        }
        if (n == 0) {
            this.func_77042_a(this._b);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (n == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return -1;
    }

    public void _a(EntitySlime entitySlime, float f) {
        float f2 = entitySlime.func_70809_q();
        float f3 = (entitySlime.field_70812_c + (entitySlime.field_70811_b - entitySlime.field_70812_c) * f) / (f2 * 0.5f + 1.0f);
        float f4 = 1.0f / (f3 + 1.0f);
        GL11.glScalef(f4 * f2, 1.0f / f4 * f2, f4 * f2);
    }

    public ResourceLocation _a(EntitySlime entitySlime) {
        return _a;
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntitySlime)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntitySlime)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntitySlime)entity);
    }
}

