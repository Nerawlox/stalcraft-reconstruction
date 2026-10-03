/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class dyja
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/bat.png");
    public int _b;

    public dyja() {
        super(new ModelBat(), 0.25f);
        this._b = ((ModelBat)this.mainModel).getBatSize();
    }

    public void _a(EntityBat entityBat, double d, double d2, double d3, float f, float f2) {
        int n = ((ModelBat)this.mainModel).getBatSize();
        if (n != this._b) {
            this._b = n;
            this.mainModel = new ModelBat();
        }
        super.doRenderLiving(entityBat, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityBat entityBat) {
        return _a;
    }

    public void _a(EntityBat entityBat, float f) {
        GL11.glScalef(0.35f, 0.35f, 0.35f);
    }

    public void _a(EntityBat entityBat, double d, double d2, double d3) {
        super.renderLivingAt(entityBat, d, d2, d3);
    }

    public void _a(EntityBat entityBat, float f, float f2, float f3) {
        if (!entityBat.getIsBatHanging()) {
            GL11.glTranslatef(0.0f, sajh._b(f * 0.3f) * 0.1f, 0.0f);
        } else {
            GL11.glTranslatef(0.0f, -0.1f, 0.0f);
        }
        super.rotateCorpse(entityBat, f, f2, f3);
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityBat)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void rotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntityBat)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void renderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this._a((EntityBat)entityLivingBase, d, d2, d3);
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityBat)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entity, d, d2, d3, f, f2);
    }
}

