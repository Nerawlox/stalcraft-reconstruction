/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.StalcraftMod;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import gloomyfolken.mods.core.misc.srok;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RenderTallGrass
implements ISimpleBlockRenderingHandler {
    public static RenderTallGrass instance = new RenderTallGrass();

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        long l = srok._a(n, n2, n3);
        float f = srok._a(l) - 0.5f;
        float f2 = srok._b(l) - 0.5f;
        Tessellator tessellator = renderBlocks.__aF;
        tessellator.addTranslation(f, 0.0f, f2);
        renderBlocks._l(block, n, n2 + 1, n3);
        renderBlocks._a(StalcraftMod.tallGrass.bottomIcon);
        renderBlocks._l(block, n, n2, n3);
        renderBlocks._a((Icon)null);
        tessellator.addTranslation(-f, 0.0f, -f2);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return 265;
    }
}

