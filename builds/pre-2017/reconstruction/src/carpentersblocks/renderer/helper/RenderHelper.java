/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

import carpentersblocks.renderer.helper.VertexHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
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

    protected void setUV(RenderBlocks renderBlocks, ForgeDirection forgeDirection, int n, Icon icon) {
        switch (1 + forgeDirection.ordinal()) {
            case 1: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._m * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._l * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._m * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._l * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._i * 16.0);
                    }
                }
                this.set(this.UV_DOWN, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax);
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._m * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._l * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._m * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._l * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._i * 16.0);
                    }
                }
                this.set(this.UV_UP, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMin, this.vMax, this.uMin, this.vMax, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin, this.uMin, this.vMax, this.uMin, this.vMax, this.uMax, this.vMax, this.uMax, this.vMin, this.uMin, this.vMin);
                break;
            }
            case 3: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._i * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._h * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 - (renderBlocks._k - renderBlocks._j) : renderBlocks._j) * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 : renderBlocks._k) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._i * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._h * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._i * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._h * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._j * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._i * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._h * 16.0);
                    }
                }
                this.set(this.UV_NORTH, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax);
                break;
            }
            case 4: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 - (renderBlocks._k - renderBlocks._j) : renderBlocks._j) * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 : renderBlocks._k) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._i * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._h * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._i * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._j * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._h * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._i * 16.0);
                    }
                }
                this.set(this.UV_SOUTH, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax);
                break;
            }
            case 5: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._l * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._m * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 : renderBlocks._k) * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 - (renderBlocks._k - renderBlocks._j) : renderBlocks._j) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._m * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._l * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._m * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._j * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._m * 16.0);
                    }
                }
                this.set(this.UV_WEST, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMin, this.vMax, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax);
                break;
            }
            case 6: {
                switch (n) {
                    case 0: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._l * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 : renderBlocks._k) * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - (this.iconHasFloatingHeight(icon) ? 1.0 - (renderBlocks._k - renderBlocks._j) : renderBlocks._j) * 16.0);
                        break;
                    }
                    case 1: {
                        this.uMin = icon.getInterpolatedU(16.0 - renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(16.0 - renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._m * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._l * 16.0);
                        break;
                    }
                    case 2: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._m * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._l * 16.0);
                        this.vMin = icon.getInterpolatedV(renderBlocks._j * 16.0);
                        this.vMax = icon.getInterpolatedV(renderBlocks._k * 16.0);
                        break;
                    }
                    case 3: {
                        this.uMin = icon.getInterpolatedU(renderBlocks._k * 16.0);
                        this.uMax = icon.getInterpolatedU(renderBlocks._j * 16.0);
                        this.vMin = icon.getInterpolatedV(16.0 - renderBlocks._m * 16.0);
                        this.vMax = icon.getInterpolatedV(16.0 - renderBlocks._l * 16.0);
                    }
                }
                this.set(this.UV_EAST, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin, this.uMin, this.vMin, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMax, this.vMin, this.uMax, this.vMax, this.uMin, this.vMax, this.uMin, this.vMin);
            }
        }
    }

    protected void setBounds(RenderBlocks renderBlocks, ForgeDirection forgeDirection, double d, double d2, double d3) {
        this.yMin = d2 + renderBlocks._j - (forgeDirection.equals((Object)ForgeDirection.DOWN) ? this.offset : 0.0);
        this.yMax = d2 + renderBlocks._k + (forgeDirection.equals((Object)ForgeDirection.UP) ? this.offset : 0.0);
        this.zMin = d3 + renderBlocks._l - (forgeDirection.equals((Object)ForgeDirection.NORTH) ? this.offset : 0.0);
        this.zMax = d3 + renderBlocks._m + (forgeDirection.equals((Object)ForgeDirection.SOUTH) ? this.offset : 0.0);
        this.xMin = d + renderBlocks._h - (forgeDirection.equals((Object)ForgeDirection.WEST) ? this.offset : 0.0);
        this.xMax = d + renderBlocks._i + (forgeDirection.equals((Object)ForgeDirection.EAST) ? this.offset : 0.0);
    }

    public void renderFaceYNeg(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.DOWN, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.DOWN, renderBlocks._v, icon);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_DOWN[renderBlocks._v][0][0], this.UV_DOWN[renderBlocks._v][0][1], 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_DOWN[renderBlocks._v][1][0], this.UV_DOWN[renderBlocks._v][1][1], 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_DOWN[renderBlocks._v][2][0], this.UV_DOWN[renderBlocks._v][2][1], 2);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_DOWN[renderBlocks._v][3][0], this.UV_DOWN[renderBlocks._v][3][1], 3);
    }

    public void renderFaceYPos(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.UP, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.UP, renderBlocks._u, icon);
        int n = renderBlocks._u;
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_UP[renderBlocks._u][0][0], this.UV_UP[renderBlocks._u][0][1], 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_UP[renderBlocks._u][1][0], this.UV_UP[renderBlocks._u][1][1], 1);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_UP[renderBlocks._u][2][0], this.UV_UP[renderBlocks._u][2][1], 2);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_UP[renderBlocks._u][3][0], this.UV_UP[renderBlocks._u][3][1], 3);
    }

    public void renderFaceZNeg(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.NORTH, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.NORTH, renderBlocks._q, icon);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][0][0], this.UV_NORTH[renderBlocks._q][0][1], 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_NORTH[renderBlocks._q][1][0], this.UV_NORTH[renderBlocks._q][1][1], 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][2][0], this.UV_NORTH[renderBlocks._q][2][1], 2);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_NORTH[renderBlocks._q][3][0], this.UV_NORTH[renderBlocks._q][3][1], 3);
    }

    public void renderFaceZPos(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.SOUTH, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.SOUTH, renderBlocks._r, icon);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][0][0], this.UV_SOUTH[renderBlocks._r][0][1], 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][1][0], this.UV_SOUTH[renderBlocks._r][1][1], 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_SOUTH[renderBlocks._r][2][0], this.UV_SOUTH[renderBlocks._r][2][1], 2);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_SOUTH[renderBlocks._r][3][0], this.UV_SOUTH[renderBlocks._r][3][1], 3);
    }

    public void renderFaceXNeg(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.WEST, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.WEST, renderBlocks._t, icon);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMax, this.UV_WEST[renderBlocks._t][0][0], this.UV_WEST[renderBlocks._t][0][1], 0);
        this.setupVertex(renderBlocks, this.xMin, this.yMax, this.zMin, this.UV_WEST[renderBlocks._t][1][0], this.UV_WEST[renderBlocks._t][1][1], 1);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMin, this.UV_WEST[renderBlocks._t][2][0], this.UV_WEST[renderBlocks._t][2][1], 2);
        this.setupVertex(renderBlocks, this.xMin, this.yMin, this.zMax, this.UV_WEST[renderBlocks._t][3][0], this.UV_WEST[renderBlocks._t][3][1], 3);
    }

    public void renderFaceXPos(RenderBlocks renderBlocks, double d, double d2, double d3, Icon icon) {
        this.setBounds(renderBlocks, ForgeDirection.EAST, d, d2, d3);
        this.setUV(renderBlocks, ForgeDirection.EAST, renderBlocks._s, icon);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMax, this.UV_EAST[renderBlocks._s][0][0], this.UV_EAST[renderBlocks._s][0][1], 0);
        this.setupVertex(renderBlocks, this.xMax, this.yMin, this.zMin, this.UV_EAST[renderBlocks._s][1][0], this.UV_EAST[renderBlocks._s][1][1], 1);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMin, this.UV_EAST[renderBlocks._s][2][0], this.UV_EAST[renderBlocks._s][2][1], 2);
        this.setupVertex(renderBlocks, this.xMax, this.yMax, this.zMax, this.UV_EAST[renderBlocks._s][3][0], this.UV_EAST[renderBlocks._s][3][1], 3);
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

