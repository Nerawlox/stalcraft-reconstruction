/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class tfun
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/slime/magmacube.png");

    public tfun() {
        super(new ModelMagmaCube(), 0.25f);
    }

    public ResourceLocation _a(EntityMagmaCube entityMagmaCube) {
        return _a;
    }

    public void _a(EntityMagmaCube entityMagmaCube, float f) {
        int n = entityMagmaCube.func_70809_q();
        float f2 = (entityMagmaCube.field_70812_c + (entityMagmaCube.field_70811_b - entityMagmaCube.field_70812_c) * f) / ((float)n * 0.5f + 1.0f);
        float f3 = 1.0f / (f2 + 1.0f);
        float f4 = n;
        GL11.glScalef(f3 * f4, 1.0f / f3 * f4, f3 * f4);
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityMagmaCube)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityMagmaCube)entity);
    }
}

