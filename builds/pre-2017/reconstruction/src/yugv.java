/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.srok;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class yugv
extends hsdi {
    public yugv(String string) {
        super(string);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        long l = srok._a(n, n2, n3);
        float f = (srok._a(l) - 0.5f) * 0.5f + 0.5f;
        float f2 = (srok._b(l) - 0.5f) * 0.5f + 0.5f;
        Tessellator tessellator = renderBlocks.__aF;
        tessellator.addTranslation((float)n + f, n2, (float)n3 + f2);
        tessellator.setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
        this._a(block, n5, tessellator);
        tessellator.addTranslation((float)(-n) - f, -n2, (float)(-n3) - f2);
        return true;
    }

    protected void _a(Block block, int n, Tessellator tessellator) {
        if (n == 2) {
            this.renderWithTessellator(block.getIcon(0, n), hsdi.rotation0, tessellator);
        } else if (n == 3) {
            this.renderWithTessellator(block.getIcon(0, n), hsdi.rotation270, tessellator);
        } else if (n == 0) {
            this.renderWithTessellator(block.getIcon(0, n), hsdi.rotation180, tessellator);
        } else if (n == 1) {
            this.renderWithTessellator(block.getIcon(0, n), hsdi.rotation90, tessellator);
        }
    }
}

