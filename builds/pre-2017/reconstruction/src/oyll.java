/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class oyll
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/witch.png");
    public final ModelWitch _b;

    public oyll() {
        super(new ModelWitch(0.0f), 0.5f);
        this._b = (ModelWitch)this.mainModel;
    }

    public void _a(EntityWitch entityWitch, double d, double d2, double d3, float f, float f2) {
        ItemStack itemStack = entityWitch.getHeldItem();
        this._b.field_82900_g = itemStack != null;
        super.doRenderLiving(entityWitch, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityWitch entityWitch) {
        return _a;
    }

    public void _a(EntityWitch entityWitch, float f) {
        float f2 = 1.0f;
        GL11.glColor3f(f2, f2, f2);
        super.renderEquippedItems(entityWitch, f);
        ItemStack itemStack = entityWitch.getHeldItem();
        if (itemStack != null) {
            float f3;
            GL11.glPushMatrix();
            if (this.mainModel.isChild) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
            }
            this._b.villagerNose.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.53125f, 0.21875f);
            if (itemStack._d < 256 && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3 *= 0.75f, -f3, f3);
            } else if (itemStack._d == Item.bow.itemID) {
                f3 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[itemStack._d].isFull3D()) {
                f3 = 0.625f;
                if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this._a();
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f3 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
            this.renderManager._h.renderItem(entityWitch, itemStack, 0);
            if (itemStack._a().requiresMultipleRenderPasses()) {
                this.renderManager._h.renderItem(entityWitch, itemStack, 1);
            }
            GL11.glPopMatrix();
        }
    }

    public void _a() {
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
    }

    public void _b(EntityWitch entityWitch, float f) {
        float f2 = 0.9375f;
        GL11.glScalef(f2, f2, f2);
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._b((EntityWitch)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityWitch)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityWitch)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entity, d, d2, d3, f, f2);
    }
}

