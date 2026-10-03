/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;

public class pknr
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/silverfish.png");

    public pknr() {
        super(new ModelSilverfish(), 0.3f);
    }

    public float _a(EntitySilverfish entitySilverfish) {
        return 180.0f;
    }

    public void _a(EntitySilverfish entitySilverfish, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entitySilverfish, d, d2, d3, f, f2);
    }

    public ResourceLocation _b(EntitySilverfish entitySilverfish) {
        return _a;
    }

    public int _a(EntitySilverfish entitySilverfish, int n, float f) {
        return -1;
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return this._a((EntitySilverfish)entityLivingBase);
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntitySilverfish)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._b((EntitySilverfish)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySilverfish)entity, d, d2, d3, f, f2);
    }
}

