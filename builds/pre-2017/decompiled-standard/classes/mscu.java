/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;

public class mscu
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/chicken.png");

    public mscu(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntityChicken entityChicken, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityChicken, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityChicken entityChicken) {
        return _a;
    }

    public float _a(EntityChicken entityChicken, float f) {
        float f2 = entityChicken.field_70888_h + (entityChicken.field_70886_e - entityChicken.field_70888_h) * f;
        float f3 = entityChicken.field_70884_g + (entityChicken.field_70883_f - entityChicken.field_70884_g) * f;
        return (sajh._a(f2) + 1.0f) * f3;
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityChicken)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        return this._a((EntityChicken)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityChicken)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityChicken)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityChicken)entity, d, d2, d3, f, f2);
    }
}

