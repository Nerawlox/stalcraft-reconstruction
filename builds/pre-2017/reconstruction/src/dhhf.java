/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class dhhf
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/cow/cow.png");

    public dhhf(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public ResourceLocation _a(EntityCow entityCow) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityCow)entity);
    }
}

