/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockBase;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;

public class HingedBase
extends BlockHandlerBase {
    protected boolean shouldRenderFrame(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n) {
        return this.renderAlphaOverride ? n == 1 : htvc2._b() || twgu2.func_71856_s_() == n || twgu2 instanceof BlockBase && n == 0 || this.shouldRenderPattern(tECarpentersBlock, n);
    }

    protected boolean shouldRenderPieces(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n) {
        return n == 0;
    }
}

