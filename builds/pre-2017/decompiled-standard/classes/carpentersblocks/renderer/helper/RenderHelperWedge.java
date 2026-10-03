/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

import carpentersblocks.renderer.helper.RenderHelper;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class RenderHelperWedge
extends RenderHelper {
    public void renderFaceYNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        switch (n) {
            case 0: 
            case 35: 
            case 38: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
                break;
            }
            case 1: 
            case 31: 
            case 42: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
                break;
            }
            case 2: 
            case 29: 
            case 40: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
                break;
            }
            case 3: 
            case 33: 
            case 36: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
            }
        }
    }

    public void renderFaceYPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        switch (n) {
            case 0: 
            case 34: 
            case 39: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
                break;
            }
            case 1: 
            case 30: 
            case 43: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
                break;
            }
            case 2: 
            case 28: 
            case 41: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
                break;
            }
            case 3: 
            case 32: 
            case 37: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
            }
        }
    }

    public void renderFaceZNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.NORTH, htvc2._q, dwan2);
        boolean bl = this.iconHasFloatingHeight(dwan2);
        switch (n) {
            case 6: 
            case 15: 
            case 21: 
            case 31: 
            case 37: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                break;
            }
            case 7: 
            case 13: 
            case 23: 
            case 29: 
            case 39: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
                break;
            }
            case 10: 
            case 14: 
            case 20: 
            case 30: 
            case 36: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], bl ? this.vMax : this.UV_NORTH[htvc2._q][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], bl ? this.vMax : this.UV_NORTH[htvc2._q][3][1], 3);
                break;
            }
            case 11: 
            case 12: 
            case 22: 
            case 28: 
            case 38: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], bl ? this.vMax : this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], bl ? this.vMax : this.UV_NORTH[htvc2._q][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
            }
        }
    }

    public void renderFaceZPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.SOUTH, htvc2._r, dwan2);
        boolean bl = this.iconHasFloatingHeight(dwan2);
        switch (n) {
            case 6: 
            case 17: 
            case 27: 
            case 33: 
            case 43: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 7: 
            case 19: 
            case 25: 
            case 35: 
            case 41: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 10: 
            case 16: 
            case 26: 
            case 32: 
            case 42: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], bl ? this.vMax : this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], bl ? this.vMax : this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
                break;
            }
            case 11: 
            case 18: 
            case 24: 
            case 34: 
            case 40: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], bl ? this.vMax : this.UV_SOUTH[htvc2._r][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], bl ? this.vMax : this.UV_SOUTH[htvc2._r][2][1], 2);
            }
        }
    }

    public void renderFaceXNeg(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.WEST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.WEST, htvc2._t, dwan2);
        boolean bl = this.iconHasFloatingHeight(dwan2);
        switch (n) {
            case 4: 
            case 15: 
            case 25: 
            case 31: 
            case 41: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 5: 
            case 17: 
            case 23: 
            case 33: 
            case 39: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 8: 
            case 14: 
            case 24: 
            case 30: 
            case 40: {
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], bl ? this.vMax : this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], bl ? this.vMax : this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
                break;
            }
            case 9: 
            case 16: 
            case 22: 
            case 32: 
            case 38: {
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], bl ? this.vMax : this.UV_WEST[htvc2._t][3][1], 3);
                this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
                this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], bl ? this.vMax : this.UV_WEST[htvc2._t][3][1], 3);
            }
        }
    }

    public void renderFaceXPos(htvc htvc2, int n, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.EAST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.EAST, htvc2._s, dwan2);
        boolean bl = this.iconHasFloatingHeight(dwan2);
        switch (n) {
            case 4: 
            case 13: 
            case 27: 
            case 29: 
            case 43: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 5: 
            case 19: 
            case 21: 
            case 35: 
            case 37: {
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            default: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 8: 
            case 12: 
            case 26: 
            case 28: 
            case 42: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], bl ? this.vMax : this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], bl ? this.vMax : this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
                break;
            }
            case 9: 
            case 18: 
            case 20: 
            case 34: 
            case 36: {
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], bl ? this.vMax : this.UV_EAST[htvc2._s][0][1], 0);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
                this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
                this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], bl ? this.vMax : this.UV_EAST[htvc2._s][0][1], 0);
            }
        }
    }
}

