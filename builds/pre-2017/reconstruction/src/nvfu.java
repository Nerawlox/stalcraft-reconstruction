/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;

public class nvfu
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/blaze.png");
    public int _b;

    public nvfu() {
        super(new ModelBlaze(), 0.5f);
        this._b = ((ModelBlaze)this.mainModel).func_78104_a();
    }

    public void _a(EntityBlaze entityBlaze, double d, double d2, double d3, float f, float f2) {
        int n = ((ModelBlaze)this.mainModel).func_78104_a();
        if (n != this._b) {
            this._b = n;
            this.mainModel = new ModelBlaze();
        }
        super.doRenderLiving(entityBlaze, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityBlaze entityBlaze) {
        return _a;
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityBlaze)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBlaze)entity, d, d2, d3, f, f2);
    }
}

