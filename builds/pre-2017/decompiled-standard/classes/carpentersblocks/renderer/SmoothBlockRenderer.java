/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.renderer.BlockHandlerCarpentersSlope;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.MinecraftForgeClient;

public class SmoothBlockRenderer
implements ISimpleBlockRenderingHandler {
    private static TECarpentersBlock[] FAKE_TILES = new TECarpentersBlock[16];
    private BlockHandlerCarpentersSlope slopeRender = new BlockHandlerCarpentersSlope();

    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        BlockStalkerSlope blockStalkerSlope = (BlockStalkerSlope)twgu2;
        int n5 = MinecraftForgeClient.getRenderPass();
        int n6 = sdrg2.func_72805_g(n, n2, n3);
        TECarpentersBlock tECarpentersBlock = FAKE_TILES[n6];
        tECarpentersBlock.func_70308_a(xpzm._E()._r);
        twgu twgu3 = blockStalkerSlope.getCoverBlock();
        tECarpentersBlock.cover[6] = (short)twgu3.field_71990_ca;
        if (blockStalkerSlope.shouldRenderBase()) {
            if (twgu3.canRenderInPass(n5)) {
                htvc2._b(twgu3, n, n2, n3);
            }
            ++n2;
        }
        this.slopeRender.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, BlockHandler.blockCarpentersSlope, n, n2, n3);
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

