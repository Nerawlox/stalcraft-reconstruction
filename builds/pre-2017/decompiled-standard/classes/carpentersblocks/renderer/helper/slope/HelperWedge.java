/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelperWedge;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class HelperWedge
extends RenderHelperWedge {
    public void renderSlopeZNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.NORTH, htvc2._q, dwan2);
        switch (n) {
            case 1: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
                break;
            }
            case 2: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
            }
            default: {
                break;
            }
            case 4: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 3);
                break;
            }
            case 8: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 3);
            }
        }
    }

    public void renderSlopeZPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.SOUTH, htvc2._r, dwan2);
        switch (n) {
            case 0: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
            }
            default: {
                break;
            }
            case 3: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 5: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 9: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 3);
            }
        }
    }

    public void renderSlopeXNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.WEST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.WEST, htvc2._t, dwan2);
        switch (n) {
            case 6: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 10: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
            }
        }
    }

    public void renderSlopeXPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.EAST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.EAST, htvc2._s, dwan2);
        switch (n) {
            case 7: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 11: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
            }
        }
    }
}

