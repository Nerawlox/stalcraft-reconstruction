/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockBase;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;

public class HingedBase
extends BlockHandlerBase {
    protected boolean shouldRenderFrame(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n) {
        return this.renderAlphaOverride ? n == 1 : renderBlocks._b() || block.getRenderBlockPass() == n || block instanceof BlockBase && n == 0 || this.shouldRenderPattern(tECarpentersBlock, n);
    }

    protected boolean shouldRenderPieces(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n) {
        return n == 0;
    }
}

