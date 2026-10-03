/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class HelperPyramid
extends RenderHelper {
    public void renderFaceYNegZNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMax, this.vMin, 1);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMin, this.vMin, 2);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
    }

    public void renderFaceYNegZPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMin, 0);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMin, 3);
    }

    public void renderFaceYNegXNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMax, this.vMin, 0);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMin, 1);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
    }

    public void renderFaceYNegXPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 2);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMin, this.vMin, 3);
    }

    public void renderFaceYPosZNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMin, this.vMax, 1);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMax, this.vMax, 2);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
    }

    public void renderFaceYPosZPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 1);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
    }

    public void renderFaceYPosXNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 0);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMax, 2);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMax, this.vMax, 3);
    }

    public void renderFaceYPosXPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        double d4 = this.vMax - (this.vMax - this.vMin) / 2.0;
        double d5 = this.uMax - (this.uMax - this.uMin) / 2.0;
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMin, this.vMax, 0);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMax, 1);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
        this.setupVertex(htvc2, d + 0.5, d2 + 0.5, d3 + 0.5, d5, d4, 2);
    }
}

