/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class dyjm
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/zombie/zombie.png");
    public float _b;

    public dyjm(ModelBase modelBase, float f, float f2) {
        super(modelBase, f * f2);
        this._b = f2;
    }

    public void _a(EntityGiantZombie entityGiantZombie, float f) {
        GL11.glScalef(this._b, this._b, this._b);
    }

    public ResourceLocation _a(EntityGiantZombie entityGiantZombie) {
        return _a;
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityGiantZombie)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityGiantZombie)entity);
    }
}

