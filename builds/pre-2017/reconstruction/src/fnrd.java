/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class fnrd
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/sheep/sheep.png");

    public fnrd(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this.setRenderPassModel(modelBase2);
    }

    public int _a(EntitySheep entitySheep, int n, float f) {
        if (n == 0 && !entitySheep.getSheared()) {
            this.bindTexture(_a);
            float f2 = 1.0f;
            int n2 = entitySheep.getFleeceColor();
            GL11.glColor3f(f2 * EntitySheep.fleeceColorTable[n2][0], f2 * EntitySheep.fleeceColorTable[n2][1], f2 * EntitySheep.fleeceColorTable[n2][2]);
            return 1;
        }
        return -1;
    }

    public ResourceLocation _a(EntitySheep entitySheep) {
        return _b;
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntitySheep)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntitySheep)entity);
    }
}

