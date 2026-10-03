/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public interface ISimpleBlockRenderingHandler {
    public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4);

    public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7);

    public boolean shouldRender3DInInventory();

    public int getRenderId();
}

