/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.modloader;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.src.BaseMod;
import net.minecraft.world.IBlockAccess;

public class ModLoaderBlockRendererHandler
implements ISimpleBlockRenderingHandler {
    private int renderId;
    private boolean render3dInInventory;
    private BaseMod mod;

    public ModLoaderBlockRendererHandler(int n, boolean bl, BaseMod baseMod) {
        this.renderId = n;
        this.render3dInInventory = bl;
        this.mod = baseMod;
    }

    @Override
    public int getRenderId() {
        return this.renderId;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return this.render3dInInventory;
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        return this.mod.renderWorldBlock(renderBlocks, iBlockAccess, n, n2, n3, block, n4);
    }

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        this.mod.renderInvBlock(renderBlocks, block, n, n2);
    }
}

