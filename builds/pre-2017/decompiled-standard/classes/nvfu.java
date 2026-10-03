/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;

public class nvfu
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/blaze.png");
    public int _b;

    public nvfu() {
        super(new ModelBlaze(), 0.5f);
        this._b = ((ModelBlaze)this.field_77045_g).func_78104_a();
    }

    public void _a(EntityBlaze entityBlaze, double d, double d2, double d3, float f, float f2) {
        int n = ((ModelBlaze)this.field_77045_g).func_78104_a();
        if (n != this._b) {
            this._b = n;
            this.field_77045_g = new ModelBlaze();
        }
        super.func_77031_a(entityBlaze, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityBlaze entityBlaze) {
        return _a;
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityBlaze)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entity, d, d2, d3, f, f2);
    }
}

