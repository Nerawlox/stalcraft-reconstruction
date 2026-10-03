/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class pknh
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/cow/mooshroom.png");

    public pknh(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntityMooshroom entityMooshroom, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entityMooshroom, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityMooshroom entityMooshroom) {
        return _a;
    }

    public void _a(EntityMooshroom entityMooshroom, float f) {
        super.renderEquippedItems(entityMooshroom, f);
        if (entityMooshroom.isChild()) {
            return;
        }
        this.bindTexture(sctd._c);
        GL11.glEnable(2884);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.2f, 0.4f, 0.5f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.renderBlocks._a((Block)Block.mushroomRed, 0, 1.0f);
        GL11.glTranslatef(0.1f, 0.0f, -0.6f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.renderBlocks._a((Block)Block.mushroomRed, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        ((ModelQuadruped)this.mainModel).head.postRender(0.0625f);
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.0f, 0.75f, -0.2f);
        GL11.glRotatef(12.0f, 0.0f, 1.0f, 0.0f);
        this.renderBlocks._a((Block)Block.mushroomRed, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable(2884);
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityMooshroom)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityMooshroom)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityMooshroom)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityMooshroom)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityMooshroom)entity, d, d2, d3, f, f2);
    }
}

