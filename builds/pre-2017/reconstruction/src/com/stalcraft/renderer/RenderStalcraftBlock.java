/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.util.vector.Matrix3f;

public class RenderStalcraftBlock
extends hsdi {
    private Matrix3f scaleMatrix;
    private Matrix3f rotation0;
    private Matrix3f rotation90;
    private Matrix3f rotation180;
    private Matrix3f rotation270;

    public RenderStalcraftBlock(String string, float f, float f2, float f3) {
        super(string);
        this.uFactor = 2.0f;
        this.rotation0 = this.scaleMatrix = jywc._b(f, f2, f3);
        this.rotation90 = Matrix3f.mul(jywc._a(90.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
        this.rotation180 = Matrix3f.mul(jywc._a(180.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
        this.rotation270 = Matrix3f.mul(jywc._a(270.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        Tessellator tessellator = renderBlocks.__aF;
        tessellator.addTranslation((float)n + 0.5f, n2, (float)n3 + 0.5f);
        tessellator.setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
        this.performRender(block, n5, tessellator);
        tessellator.addTranslation((float)(-n) - 0.5f, -n2, (float)(-n3) - 0.5f);
        return true;
    }

    protected void performRender(Block block, int n, Tessellator tessellator) {
        if (n == 2) {
            this.renderWithTessellator(block.getIcon(0, n), this.rotation0, tessellator);
        } else if (n == 3) {
            this.renderWithTessellator(block.getIcon(0, n), this.rotation270, tessellator);
        } else if (n == 0) {
            this.renderWithTessellator(block.getIcon(0, n), this.rotation180, tessellator);
        } else if (n == 1) {
            this.renderWithTessellator(block.getIcon(0, n), this.rotation90, tessellator);
        }
    }
}

