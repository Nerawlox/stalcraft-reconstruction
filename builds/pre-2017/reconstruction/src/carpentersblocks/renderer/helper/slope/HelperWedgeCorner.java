/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper.slope;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class HelperWedgeCorner
extends RenderHelper {
    public void renderSlopeZNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.NORTH, renderBlocks._q, icon);
        switch (n) {
            case 12: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 3);
                break;
            }
            case 13: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 3);
                break;
            }
            case 14: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 3);
                break;
            }
            case 15: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 3);
            }
            default: {
                break;
            }
            case 24: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 3);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 3);
                break;
            }
            case 25: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 0);
                break;
            }
            case 26: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 0);
                break;
            }
            case 27: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 3);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 3);
            }
        }
    }

    public void renderSlopeZPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.SOUTH, renderBlocks._r, icon);
        switch (n) {
            case 16: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 3);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 3);
                break;
            }
            case 17: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 0);
                break;
            }
            case 18: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 0);
                break;
            }
            case 19: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 3);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 3);
                break;
            }
            case 20: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 3);
                break;
            }
            case 21: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 3);
                break;
            }
            case 22: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 3);
                break;
            }
            case 23: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 3);
            }
        }
    }

    public void renderSlopeXNeg(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.WEST, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.WEST, renderBlocks._t, icon);
        switch (n) {
            case 14: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                break;
            }
            case 15: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                break;
            }
            case 16: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                break;
            }
            case 17: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
            }
            default: {
                break;
            }
            case 20: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                break;
            }
            case 21: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                break;
            }
            case 26: {
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                break;
            }
            case 27: {
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
            }
        }
    }

    public void renderSlopeXPos(RenderBlocks renderBlocks, int n, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.EAST, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.EAST, renderBlocks._s, icon);
        switch (n) {
            case 12: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                break;
            }
            case 13: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
            }
            default: {
                break;
            }
            case 18: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                break;
            }
            case 19: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                break;
            }
            case 22: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                break;
            }
            case 23: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                break;
            }
            case 24: {
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
                break;
            }
            case 25: {
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
                this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
            }
        }
    }
}

