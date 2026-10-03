/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;

public class pknr
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/silverfish.png");

    public pknr() {
        super(new ModelSilverfish(), 0.3f);
    }

    public float _a(EntitySilverfish entitySilverfish) {
        return 180.0f;
    }

    public void _a(EntitySilverfish entitySilverfish, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entitySilverfish, d, d2, d3, f, f2);
    }

    public ResourceLocation _b(EntitySilverfish entitySilverfish) {
        return _a;
    }

    public int _a(EntitySilverfish entitySilverfish, int n, float f) {
        return -1;
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ float func_77037_a(EntityLivingBase entityLivingBase) {
        return this._a((EntitySilverfish)entityLivingBase);
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntitySilverfish)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._b((EntitySilverfish)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entity, d, d2, d3, f, f2);
    }
}

