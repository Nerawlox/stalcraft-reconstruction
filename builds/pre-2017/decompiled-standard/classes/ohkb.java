/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class ohkb
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/pig/pig.png");

    public ohkb(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this.func_77042_a(modelBase2);
    }

    public int _a(EntityPig entityPig, int n, float f) {
        if (n == 0 && entityPig.func_70901_n()) {
            this.func_110776_a(_a);
            return 1;
        }
        return -1;
    }

    public ResourceLocation _a(EntityPig entityPig) {
        return _b;
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityPig)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityPig)entity);
    }
}

