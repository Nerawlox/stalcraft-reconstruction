/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class oyku
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/wolf/wolf.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

    public oyku(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this.func_77042_a(modelBase2);
    }

    public float _a(EntityWolf entityWolf, float f) {
        return entityWolf.func_70920_v();
    }

    public int _a(EntityWolf entityWolf, int n, float f) {
        if (n == 0 && entityWolf.func_70921_u()) {
            float f2 = entityWolf.func_70013_c(f) * entityWolf.func_70915_j(f);
            this.func_110776_a(_a);
            GL11.glColor3f(f2, f2, f2);
            return 1;
        }
        if (n == 1 && entityWolf.func_70909_n()) {
            this.func_110776_a(_d);
            float f3 = 1.0f;
            int n2 = entityWolf.func_82186_bH();
            GL11.glColor3f(f3 * EntitySheep.field_70898_d[n2][0], f3 * EntitySheep.field_70898_d[n2][1], f3 * EntitySheep.field_70898_d[n2][2]);
            return 1;
        }
        return -1;
    }

    public ResourceLocation _a(EntityWolf entityWolf) {
        if (entityWolf.func_70909_n()) {
            return _b;
        }
        if (entityWolf.func_70919_bu()) {
            return _c;
        }
        return _a;
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityWolf)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        return this._a((EntityWolf)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityWolf)entity);
    }
}

