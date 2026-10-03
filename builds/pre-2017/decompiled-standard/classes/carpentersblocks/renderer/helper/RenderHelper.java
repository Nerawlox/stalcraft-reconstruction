/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

import carpentersblocks.renderer.helper.VertexHelper;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class RenderHelper
extends VertexHelper {
    protected double uMin;
    protected double uMax;
    protected double vMin;
    protected double vMax;
    protected double xMin;
    protected double xMax;
    protected double yMin;
    protected double yMax;
    protected double zMin;
    protected double zMax;
    protected final double[][][] UV_DOWN = new double[4][4][2];
    protected final double[][][] UV_UP = new double[4][4][2];
    protected final double[][][] UV_NORTH = new double[4][4][2];
    protected final double[][][] UV_SOUTH = new double[4][4][2];
    protected final double[][][] UV_WEST = new double[4][4][2];
    protected final double[][][] UV_EAST = new double[4][4][2];

    private void set(double[][][] dArray, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, double d24, double d25, double d26, double d27, double d28, double d29, double d30, double d31, double d32) {
        dArray[0][0][0] = d;
        dArray[0][0][1] = d2;
        dArray[0][1][0] = d3;
        dArray[0][1][1] = d4;
        dArray[0][2][0] = d5;
        dArray[0][2][1] = d6;
        dArray[0][3][0] = d7;
        dArray[0][3][1] = d8;
        dArray[1][0][0] = d9;
        dArray[1][0][1] = d10;
        dArray[1][1][0] = d11;
        dArray[1][1][1] = d12;
        dArray[1][2][0] = d13;
        dArray[1][2][1] = d14;
        dArray[1][3][0] = d15;
        dArray[1][3][1] = d16;
        dArray[2][0][0] = d17;
        dArray[2][0][1] = d18;
        dArray[2][1][0] = d19;
        dArray[2][1][1] = d20;
        dArray[2][2][0] = d21;
        dArray[2][2][1] = d22;
        dArray[2][3][0] = d23;
        dArray[2][3][1] = d24;
        dArray[3][0][0] = d25;
        dArray[3][0][1] = d26;
        dArray[3][1][0] = d27;
        dArray[3][1][1] = d28;
        dArray[3][2][0] = d29;
        dArray[3][2][1] = d30;
        dArray[3][3][0] = d31;
        dArray[3][3][1] = d32;
    }

    protected void setUV(htvc htvc2, ForgeDirection forgeDirection, int n, dwan dwan2) {
        switch (1 + forgeDirection.ordinal()) {
            case 1: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._m * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._l * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._m * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._l * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._i * 16.0);
                    }
                }
                this.set(this.UV_DOWN, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax);
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._m * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._l * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._m * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._l * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._i * 16.0);
                    }
                }
                this.set(this.UV_UP, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMin, this.vMax, this.uMin, this.vMax, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMin, this.vMax, this.uMin, this.vMax, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin);
                break;
            }
            case 3: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._i * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._h * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 - (htvc2._k - htvc2._j) : htvc2._j) * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 : htvc2._k) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._i * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._h * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(htvc2._i * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._h * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._j * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._i * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._h * 16.0);
                    }
                }
                this.set(this.UV_NORTH, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax);
                break;
            }
            case 4: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 - (htvc2._k - htvc2._j) : htvc2._j) * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 : htvc2._k) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._h * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._i * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._j * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._h * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._i * 16.0);
                    }
                }
                this.set(this.UV_SOUTH, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax);
                break;
            }
            case 5: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(htvc2._l * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._m * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 : htvc2._k) * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 - (htvc2._k - htvc2._j) : htvc2._j) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._m * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._l * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._m * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._j * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._m * 16.0);
                    }
                }
                this.set(this.UV_WEST, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax);
                break;
            }
            case 6: {
                switch (n) {
                    case 0: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._l * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 : htvc2._k) * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - (this.iconHasFloatingHeight(dwan2) ? 1.0 - (htvc2._k - htvc2._j) : htvc2._j) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = dwan2.func_94214_a(16.0 - htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(16.0 - htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._m * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._l * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = dwan2.func_94214_a(htvc2._m * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._l * 16.0);
                        this.vMin = dwan2.func_94207_b(htvc2._j * 16.0);
                        this.vMax = dwan2.func_94207_b(htvc2._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = dwan2.func_94214_a(htvc2._k * 16.0);
                        this.uMax = dwan2.func_94214_a(htvc2._j * 16.0);
                        this.vMin = dwan2.func_94207_b(16.0 - htvc2._m * 16.0);
                        this.vMax = dwan2.func_94207_b(16.0 - htvc2._l * 16.0);
                    }
                }
                this.set(this.UV_EAST, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin);
            }
        }
    }

    protected void setBounds(htvc htvc2, ForgeDirection forgeDirection, double d, double d2, double d3) {
        this.yMin = d2 + htvc2._j - (forgeDirection.equals((Object)ForgeDirection.DOWN) ? this.offset : 0.0);
        this.yMax = d2 + htvc2._k + (forgeDirection.equals((Object)ForgeDirection.UP) ? this.offset : 0.0);
        this.zMin = d3 + htvc2._l - (forgeDirection.equals((Object)ForgeDirection.NORTH) ? this.offset : 0.0);
        this.zMax = d3 + htvc2._m + (forgeDirection.equals((Object)ForgeDirection.SOUTH) ? this.offset : 0.0);
        this.xMin = d + htvc2._h - (forgeDirection.equals((Object)ForgeDirection.WEST) ? this.offset : 0.0);
        this.xMax = d + htvc2._i + (forgeDirection.equals((Object)ForgeDirection.EAST) ? this.offset : 0.0);
    }

    public void renderFaceYNeg(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.DOWN, htvc2._v, dwan2);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][0][0], this.UV_DOWN[htvc2._v][0][1], 0);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][1][0], this.UV_DOWN[htvc2._v][1][1], 1);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_DOWN[htvc2._v][2][0], this.UV_DOWN[htvc2._v][2][1], 2);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_DOWN[htvc2._v][3][0], this.UV_DOWN[htvc2._v][3][1], 3);
    }

    public void renderFaceYPos(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.UP, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.UP, htvc2._u, dwan2);
        int n = htvc2._u;
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_UP[htvc2._u][0][0], this.UV_UP[htvc2._u][0][1], 0);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_UP[htvc2._u][1][0], this.UV_UP[htvc2._u][1][1], 1);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_UP[htvc2._u][2][0], this.UV_UP[htvc2._u][2][1], 2);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_UP[htvc2._u][3][0], this.UV_UP[htvc2._u][3][1], 3);
    }

    public void renderFaceZNeg(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.NORTH, htvc2._q, dwan2);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][0][0], this.UV_NORTH[htvc2._q][0][1], 0);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_NORTH[htvc2._q][1][0], this.UV_NORTH[htvc2._q][1][1], 1);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][2][0], this.UV_NORTH[htvc2._q][2][1], 2);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_NORTH[htvc2._q][3][0], this.UV_NORTH[htvc2._q][3][1], 3);
    }

    public void renderFaceZPos(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.SOUTH, htvc2._r, dwan2);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][0][0], this.UV_SOUTH[htvc2._r][0][1], 0);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][1][0], this.UV_SOUTH[htvc2._r][1][1], 1);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[htvc2._r][2][0], this.UV_SOUTH[htvc2._r][2][1], 2);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[htvc2._r][3][0], this.UV_SOUTH[htvc2._r][3][1], 3);
    }

    public void renderFaceXNeg(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.WEST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.WEST, htvc2._t, dwan2);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMax, this.UV_WEST[htvc2._t][0][0], this.UV_WEST[htvc2._t][0][1], 0);
        this.setupVertex(htvc2, this.xMin, this.yMax, this.zMin, this.UV_WEST[htvc2._t][1][0], this.UV_WEST[htvc2._t][1][1], 1);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMin, this.UV_WEST[htvc2._t][2][0], this.UV_WEST[htvc2._t][2][1], 2);
        this.setupVertex(htvc2, this.xMin, this.yMin, this.zMax, this.UV_WEST[htvc2._t][3][0], this.UV_WEST[htvc2._t][3][1], 3);
    }

    public void renderFaceXPos(htvc htvc2, double d, double d2, double d3, dwan dwan2) {
        this.setBounds(htvc2, ForgeDirection.EAST, d, d2, d3);
        this.setUV(htvc2, ForgeDirection.EAST, htvc2._s, dwan2);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMax, this.UV_EAST[htvc2._s][0][0], this.UV_EAST[htvc2._s][0][1], 0);
        this.setupVertex(htvc2, this.xMax, this.yMin, this.zMin, this.UV_EAST[htvc2._s][1][0], this.UV_EAST[htvc2._s][1][1], 1);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMin, this.UV_EAST[htvc2._s][2][0], this.UV_EAST[htvc2._s][2][1], 2);
        this.setupVertex(htvc2, this.xMax, this.yMax, this.zMax, this.UV_EAST[htvc2._s][3][0], this.UV_EAST[htvc2._s][3][1], 3);
    }

    class NamelessClass1843022183 {
        final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass1843022183() {
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                this.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

