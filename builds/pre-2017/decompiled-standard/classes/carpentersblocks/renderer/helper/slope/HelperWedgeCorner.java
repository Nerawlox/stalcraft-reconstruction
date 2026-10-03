/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class HelperWedgeCorner
extends RenderHelper {
    public void renderSlopeZNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.NORTH, htvc2._q, dwan2);
        switch (n) {
            case 12: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 3);
                break;
            }
            case 13: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 3);
                break;
            }
            case 14: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 3);
                break;
            }
            case 15: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 3);
            }
            default: {
                break;
            }
            case 24: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 3);
                break;
            }
            case 25: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 0);
                break;
            }
            case 26: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 0);
                break;
            }
            case 27: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 3);
            }
        }
    }

    public void renderSlopeZPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.SOUTH, htvc2._r, dwan2);
        switch (n) {
            case 16: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 3);
                break;
            }
            case 17: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                break;
            }
            case 18: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 0);
                break;
            }
            case 19: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 20: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 3);
                break;
            }
            case 21: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 22: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 3);
                break;
            }
            case 23: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
            }
        }
    }

    public void renderSlopeXNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.WEST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.WEST, htvc2._t, dwan2);
        switch (n) {
            case 14: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                break;
            }
            case 15: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 16: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 17: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
            }
            default: {
                break;
            }
            case 20: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 21: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                break;
            }
            case 26: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 27: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
            }
        }
    }

    public void renderSlopeXPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.EAST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.EAST, htvc2._s, dwan2);
        switch (n) {
            case 12: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 13: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
            }
            default: {
                break;
            }
            case 18: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 19: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 22: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                break;
            }
            case 23: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 24: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 25: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
            }
        }
    }
}

