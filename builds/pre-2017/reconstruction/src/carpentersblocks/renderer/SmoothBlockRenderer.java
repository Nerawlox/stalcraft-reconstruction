/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.renderer.BlockHandlerCarpentersSlope;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.MinecraftForgeClient;

public class SmoothBlockRenderer
implements ISimpleBlockRenderingHandler {
    private static TECarpentersBlock[] FAKE_TILES = new TECarpentersBlock[16];
    private BlockHandlerCarpentersSlope slopeRender = new BlockHandlerCarpentersSlope();

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        BlockStalkerSlope blockStalkerSlope = (BlockStalkerSlope)block;
        int n5 = MinecraftForgeClient.getRenderPass();
        int n6 = iBlockAccess.getBlockMetadata(n, n2, n3);
        TECarpentersBlock tECarpentersBlock = FAKE_TILES[n6];
        tECarpentersBlock.setWorldObj(Minecraft._E()._r);
        Block block2 = blockStalkerSlope.getCoverBlock();
        tECarpentersBlock.cover[6] = (short)block2.blockID;
        if (blockStalkerSlope.shouldRenderBase()) {
            if (block2.canRenderInPass(n5)) {
                renderBlocks._b(block2, n, n2, n3);
            }
            ++n2;
        }
        this.slopeRender.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, BlockHandler.blockCarpentersSlope, n, n2, n3);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return 0;
    }

    static {
        for (int i = 0; i < 16; ++i) {
            TECarpentersBlock tECarpentersBlock = new TECarpentersBlock();
            tECarpentersBlock.data = (short)BlockStalkerSlope.getSlopeFromMeta((int)i).slopeID;
            SmoothBlockRenderer.FAKE_TILES[i] = tECarpentersBlock;
        }
    }
}

