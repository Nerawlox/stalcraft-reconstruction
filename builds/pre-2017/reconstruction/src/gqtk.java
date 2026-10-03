/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class gqtk
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/squid.png");

    public gqtk(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntitySquid entitySquid, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entitySquid, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntitySquid entitySquid) {
        return _a;
    }

    public void _a(EntitySquid entitySquid, float f, float f2, float f3) {
        float f4 = entitySquid.prevSquidPitch + (entitySquid.squidPitch - entitySquid.prevSquidPitch) * f3;
        float f5 = entitySquid.prevSquidYaw + (entitySquid.squidYaw - entitySquid.prevSquidYaw) * f3;
        GL11.glTranslatef(0.0f, 0.5f, 0.0f);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(f5, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -1.2f, 0.0f);
    }

    public float _a(EntitySquid entitySquid, float f) {
        return entitySquid.field_70865_by + (entitySquid.tentacleAngle - entitySquid.field_70865_by) * f;
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return this._a((EntitySquid)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void rotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntitySquid)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntitySquid)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entity, d, d2, d3, f, f2);
    }
}

