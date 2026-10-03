/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;

public class VertexHelper {
    protected double offset = 0.0;

    public void setOffset(double d) {
        this.offset = d;
    }

    public void clearOffset() {
        this.offset = 0.0;
    }

    public boolean iconHasFloatingHeight(Icon icon) {
        return icon == BlockGrass._a() || icon.getIconName().contains("overlay/overlay_") && icon.getIconName().endsWith("_side");
    }

    public void setupVertex(RenderBlocks renderBlocks, double d, double d2, double d3, double d4, double d5, int n) {
        Tessellator tessellator = renderBlocks.__aF;
        if (renderBlocks._w) {
            switch (n) {
                case 0: {
                    tessellator.setColorOpaque_F(renderBlocks.__ap, renderBlocks.__at, renderBlocks.__ax);
                    tessellator.setBrightness(renderBlocks.__al);
                    break;
                }
                case 1: {
                    tessellator.setColorOpaque_F(renderBlocks.__aq, renderBlocks.__au, renderBlocks.__ay);
                    tessellator.setBrightness(renderBlocks.__am);
                    break;
                }
                case 2: {
                    tessellator.setColorOpaque_F(renderBlocks.__ar, renderBlocks.__av, renderBlocks.__az);
                    tessellator.setBrightness(renderBlocks.__an);
                    break;
                }
                case 3: {
                    tessellator.setColorOpaque_F(renderBlocks.__as, renderBlocks.__aw, renderBlocks.__aA);
                    tessellator.setBrightness(renderBlocks.__ao);
                }
            }
        }
        tessellator.addVertexWithUV(d, d2, d3, d4, d5);
    }
}

