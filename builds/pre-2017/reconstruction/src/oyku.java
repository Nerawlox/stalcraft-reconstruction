/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class oyku
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/wolf/wolf.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

    public oyku(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this.setRenderPassModel(modelBase2);
    }

    public float _a(EntityWolf entityWolf, float f) {
        return entityWolf.getTailRotation();
    }

    public int _a(EntityWolf entityWolf, int n, float f) {
        if (n == 0 && entityWolf.getWolfShaking()) {
            float f2 = entityWolf.getBrightness(f) * entityWolf.getShadingWhileShaking(f);
            this.bindTexture(_a);
            GL11.glColor3f(f2, f2, f2);
            return 1;
        }
        if (n == 1 && entityWolf.isTamed()) {
            this.bindTexture(_d);
            float f3 = 1.0f;
            int n2 = entityWolf.getCollarColor();
            GL11.glColor3f(f3 * EntitySheep.fleeceColorTable[n2][0], f3 * EntitySheep.fleeceColorTable[n2][1], f3 * EntitySheep.fleeceColorTable[n2][2]);
            return 1;
        }
        return -1;
    }

    public ResourceLocation _a(EntityWolf entityWolf) {
        if (entityWolf.isTamed()) {
            return _b;
        }
        if (entityWolf.isAngry()) {
            return _c;
        }
        return _a;
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityWolf)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return this._a((EntityWolf)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityWolf)entity);
    }
}

