/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class HelperPyramid
extends RenderHelper {
    public void renderFaceYNegZNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.DOWN, renderBlocks._v, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.uMax, this.vMin, 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.uMin, this.vMin, 2);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
    }

    public void renderFaceYNegZPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.DOWN, renderBlocks._v, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.uMin, this.vMin, 0);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.uMax, this.vMin, 3);
    }

    public void renderFaceYNegXNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.DOWN, renderBlocks._v, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.uMax, this.vMin, 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.uMin, this.vMin, 1);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
    }

    public void renderFaceYNegXPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.DOWN, renderBlocks._v, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 2);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.uMin, this.vMin, 3);
    }

    public void renderFaceYPosZNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.UP, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.UP, renderBlocks._u, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.uMin, this.vMax, 1);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.uMax, this.vMax, 2);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
    }

    public void renderFaceYPosZPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.UP, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.UP, renderBlocks._u, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
    }

    public void renderFaceYPosXNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.UP, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.UP, renderBlocks._u, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.uMin, this.vMax, 2);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.uMax, this.vMax, 3);
    }

    public void renderFaceYPosXPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.UP, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.UP, renderBlocks._u, icon);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.uMin, this.vMax, 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.uMax, this.vMax, 1);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
        this.setupVertex(renderBlocks, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
    }
}

