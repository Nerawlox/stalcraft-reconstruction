/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class wpcc
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/snowman.png");
    public ModelSnowMan _b;

    public wpcc() {
        super(new ModelSnowMan(), 0.5f);
        this._b = (ModelSnowMan)this.mainModel;
        this.setRenderPassModel(this._b);
    }

    public void _a(EntitySnowman entitySnowman, float f) {
        super.renderEquippedItems(entitySnowman, f);
        ItemStack itemStack = new ItemStack(Block.pumpkin, 1);
        if (itemStack != null && itemStack._a() instanceof ItemBlock) {
            boolean bl;
            GL11.glPushMatrix();
            this._b.head.postRender(0.0625f);
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (bl || RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                float f2 = 0.625f;
                GL11.glTranslatef(0.0f, -0.34375f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
            }
            this.renderManager._h.renderItem(entitySnowman, itemStack, 0);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation _a(EntitySnowman entitySnowman) {
        return _a;
    }

    @Override
    public void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntitySnowman)entityLivingBase, f);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntitySnowman)entity);
    }
}

