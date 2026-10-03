/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class HelperOblique
extends RenderHelper {
    public void renderSlopeYNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        double d4 = this.uMax - (this.uMax - this.uMin) / 2.0;
        double d5 = this.vMin;
        switch (n) {
            case 33: 
            case 35: 
            case 37: 
            case 39: {
                this.vMin = this.vMax;
                this.vMax = d5;
            }
        }
        switch (n) {
            case 29: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMax, this.vMax, 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMax, this.vMax, 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, d4, this.vMin, 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMin, this.vMax, 3);
            }
            default: {
                break;
            }
            case 31: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, d4, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMin, this.vMax, 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMin, this.vMax, 2);
                break;
            }
            case 33: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, d4, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMin, 3);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMin, 3);
                break;
            }
            case 35: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMin, 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMin, 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMin, 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, d4, this.vMax, 3);
                break;
            }
            case 37: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMax, 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMax, 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, d4, this.vMin, 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMax, 3);
                break;
            }
            case 39: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, d4, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMax, 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMax, 2);
                break;
            }
            case 41: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, d4, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMin, this.vMin, 3);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMin, this.vMin, 3);
                break;
            }
            case 43: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMax, this.vMin, 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMax, this.vMin, 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, d4, this.vMax, 3);
            }
        }
    }

    public void renderSlopeYPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        double d4 = this.uMax - (this.uMax - this.uMin) / 2.0;
        double d5 = this.vMin;
        switch (n) {
            default: 
        }
        switch (n) {
            case 28: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMax, 2);
            }
            default: {
                break;
            }
            case 30: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMax, 3);
                break;
            }
            case 32: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
                break;
            }
            case 34: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMax, 3);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMax, 3);
                break;
            }
            case 36: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMin, 2);
                break;
            }
            case 38: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
                break;
            }
            case 40: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.uMin, this.vMin, 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.uMin, this.vMax, 3);
                break;
            }
            case 42: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.uMax, this.vMax, 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.uMax, this.vMin, 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.uMin, this.vMax, 3);
            }
        }
    }
}

