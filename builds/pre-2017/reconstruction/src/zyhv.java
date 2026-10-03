/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class zyhv
extends Render {
    public final RenderBlocks _a = new RenderBlocks();

    public zyhv() {
        this.shadowSize = 0.5f;
    }

    public void _a(EntityFallingSand entityFallingSand, double d, double d2, double d3, float f, float f2) {
        World world = entityFallingSand.getWorld();
        Block block = Block.blocksList[entityFallingSand.blockID];
        if (world.getBlockId(sajh._c(entityFallingSand.posX), sajh._c(entityFallingSand.posY), sajh._c(entityFallingSand.posZ)) != entityFallingSand.blockID) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d, (float)d2, (float)d3);
            this.bindEntityTexture(entityFallingSand);
            GL11.glDisable(2896);
            if (block instanceof BlockAnvil && block.getRenderType() == 35) {
                this._a._a = world;
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setTranslation((float)(-sajh._c(entityFallingSand.posX)) - 0.5f, (float)(-sajh._c(entityFallingSand.posY)) - 0.5f, (float)(-sajh._c(entityFallingSand.posZ)) - 0.5f);
                this._a._a((BlockAnvil)block, sajh._c(entityFallingSand.posX), sajh._c(entityFallingSand.posY), sajh._c(entityFallingSand.posZ), entityFallingSand.metadata);
                tessellator.setTranslation(0.0, 0.0, 0.0);
                tessellator.draw();
            } else if (block.getRenderType() == 27) {
                this._a._a = world;
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setTranslation((float)(-sajh._c(entityFallingSand.posX)) - 0.5f, (float)(-sajh._c(entityFallingSand.posY)) - 0.5f, (float)(-sajh._c(entityFallingSand.posZ)) - 0.5f);
                this._a._a((BlockDragonEgg)block, sajh._c(entityFallingSand.posX), sajh._c(entityFallingSand.posY), sajh._c(entityFallingSand.posZ));
                tessellator.setTranslation(0.0, 0.0, 0.0);
                tessellator.draw();
            } else if (block != null) {
                this._a._a(block);
                this._a._a(block, world, sajh._c(entityFallingSand.posX), sajh._c(entityFallingSand.posY), sajh._c(entityFallingSand.posZ), entityFallingSand.metadata);
            }
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation _a(EntityFallingSand entityFallingSand) {
        return sctd._c;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityFallingSand)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFallingSand)entity, d, d2, d3, f, f2);
    }
}

