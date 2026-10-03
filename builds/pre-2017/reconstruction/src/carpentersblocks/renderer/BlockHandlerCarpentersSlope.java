/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.data.Slope;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersSlope
extends BlockHandlerBase {
    private static final int DOWN = 0;
    private static final int UP = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private static final int WEST = 4;
    private static final int EAST = 5;
    private static final int WEDGE_YN = 0;
    private static final int WEDGE_YP = 1;
    private static final int WEDGE_SLOPED_ZN = 2;
    private static final int WEDGE_ZN = 3;
    private static final int WEDGE_SLOPED_ZP = 4;
    private static final int WEDGE_ZP = 5;
    private static final int WEDGE_SLOPED_XN = 6;
    private static final int WEDGE_XN = 7;
    private static final int WEDGE_SLOPED_XP = 8;
    private static final int WEDGE_XP = 9;
    private static final int WEDGE_CORNER_SLOPED_ZN = 10;
    private static final int WEDGE_CORNER_SLOPED_ZP = 11;
    private static final int WEDGE_CORNER_SLOPED_XN = 12;
    private static final int WEDGE_CORNER_SLOPED_XP = 13;
    private static final int OBL_CORNER_SLOPED_YN = 14;
    private static final int OBL_CORNER_SLOPED_YP = 15;
    private static final int PYR_YZNN = 16;
    private static final int PYR_YZNP = 17;
    private static final int PYR_YXNN = 18;
    private static final int PYR_YXNP = 19;
    private static final int PYR_YZPN = 20;
    private static final int PYR_YZPP = 21;
    private static final int PYR_YXPN = 22;
    private static final int PYR_YXPP = 23;
    private float[][] ao = new float[][]{{1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}};
    private int[][] brightness = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    private float[][] offset_ao = new float[][]{{1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f, 1.0f}};
    private int[][] offset_brightness = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, -1.0f, 0.0f);
        this.renderHelperWedge.renderFaceYNeg(renderBlocks, 10, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        this.helperWedge.renderSlopeXNeg(renderBlocks, 10, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, -1.0f);
        this.renderHelperWedge.renderFaceZNeg(renderBlocks, 10, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        this.renderHelperWedge.renderFaceZPos(renderBlocks, 10, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        this.renderHelperWedge.renderFaceXPos(renderBlocks, 10, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
        tessellator.draw();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    private void prepareSlopeRender(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4, int n5, float f) {
        this.slopeRenderID = n2;
        this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, n, n3, n4, n5, f);
    }

    @Override
    protected void renderSide(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, int n, double d, int n2, int n3, int n4, Icon icon) {
        if (this.isSideCover) {
            super.renderSide(tECarpentersBlock, renderBlocks, n, d, n2, n3, n4, icon);
        } else {
            int n5 = BlockProperties.getData(tECarpentersBlock);
            switch (this.slopeRenderID) {
                case 0: {
                    this.renderHelperWedge.renderFaceYNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 1: {
                    this.renderHelperWedge.renderFaceYPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 2: {
                    this.helperWedge.renderSlopeZNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 3: {
                    this.renderHelperWedge.renderFaceZNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 4: {
                    this.helperWedge.renderSlopeZPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 5: {
                    this.renderHelperWedge.renderFaceZPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 6: {
                    this.helperWedge.renderSlopeXNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 7: {
                    this.renderHelperWedge.renderFaceXNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 8: {
                    this.helperWedge.renderSlopeXPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 9: {
                    this.renderHelperWedge.renderFaceXPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 10: {
                    this.helperWedgeCorner.renderSlopeZNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 11: {
                    this.helperWedgeCorner.renderSlopeZPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 12: {
                    this.helperWedgeCorner.renderSlopeXNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 13: {
                    this.helperWedgeCorner.renderSlopeXPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 14: {
                    this.helperOblique.renderSlopeYNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 15: {
                    this.helperOblique.renderSlopeYPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 16: {
                    this.helperPyramid.renderFaceYNegZNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 17: {
                    this.helperPyramid.renderFaceYNegZPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 18: {
                    this.helperPyramid.renderFaceYNegXNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 19: {
                    this.helperPyramid.renderFaceYNegXPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 20: {
                    this.helperPyramid.renderFaceYPosZNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 21: {
                    this.helperPyramid.renderFaceYPosZPos(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 22: {
                    this.helperPyramid.renderFaceYPosXNeg(renderBlocks, n5, n2, n3, n4, icon);
                    break;
                }
                case 23: {
                    this.helperPyramid.renderFaceYPosXPos(renderBlocks, n5, n2, n3, n4, icon);
                }
            }
        }
    }

    private void setAoArr(float[] fArray, float f, float f2, float f3, float f4) {
        fArray[0] = f;
        fArray[1] = f2;
        fArray[2] = f3;
        fArray[3] = f4;
    }

    private void setBrightnessArr(int[] nArray, int n, int n2, int n3, int n4) {
        nArray[0] = n;
        nArray[1] = n2;
        nArray[2] = n3;
        nArray[3] = n4;
    }

    @Override
    public boolean renderStandardSlopeWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        renderBlocks._w = true;
        block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        Tessellator tessellator = renderBlocks.__aF;
        tessellator.setBrightness(983055);
        this.setLightnessYNeg(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[0], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[0], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessYPos(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[1], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[1], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessZNeg(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[2], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[2], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessZPos(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[3], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[3], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessXNeg(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[4], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[4], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessXPos(renderBlocks, block, n, n2, n3);
        this.setAoArr(this.ao[5], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[5], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessYNeg(renderBlocks, block, n, n2 + 1, n3);
        this.setAoArr(this.offset_ao[0], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[0], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessYPos(renderBlocks, block, n, n2 - 1, n3);
        this.setAoArr(this.offset_ao[1], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[1], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessZNeg(renderBlocks, block, n, n2, n3 + 1);
        this.setAoArr(this.offset_ao[2], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[2], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessZPos(renderBlocks, block, n, n2, n3 - 1);
        this.setAoArr(this.offset_ao[3], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[3], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessXNeg(renderBlocks, block, n + 1, n2, n3);
        this.setAoArr(this.offset_ao[4], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[4], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.setLightnessXPos(renderBlocks, block, n - 1, n2, n3);
        this.setAoArr(this.offset_ao[5], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[5], renderBlocks.__al, renderBlocks.__ao, renderBlocks.__an, renderBlocks.__am);
        this.isSideSloped = true;
        switch (slope.slopeType.ordinal() + 1) {
            case 1: {
                this.prepareHorizontalWedge(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 2: {
                this.prepareVerticalWedge(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 3: {
                this.prepareWedgeIntCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 4: {
                this.prepareWedgeExtCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 5: {
                this.prepareObliqueIntCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 6: {
                this.prepareObliqueExtCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 7: {
                this.preparePyramid(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
            }
        }
        this.isSideSloped = false;
        if (slope.hasSide(ForgeDirection.DOWN) && block2.shouldSideBeRendered(renderBlocks._a, n, n2 - 1, n3, 0)) {
            this.prepareFaceYNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.UP) && block2.shouldSideBeRendered(renderBlocks._a, n, n2 + 1, n3, 1)) {
            this.prepareFaceYPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.NORTH) && block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 - 1, 2)) {
            this.prepareFaceZNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.SOUTH) && block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 + 1, 3)) {
            this.prepareFaceZPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.WEST) && block2.shouldSideBeRendered(renderBlocks._a, n - 1, n2, n3, 4)) {
            this.prepareFaceXNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.EAST) && block2.shouldSideBeRendered(renderBlocks._a, n + 1, n2, n3, 5)) {
            this.prepareFaceXPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        renderBlocks._w = false;
        return true;
    }

    private void setWedgeSlopeLighting(RenderBlocks renderBlocks, Slope slope) {
        switch (slope.slopeID) {
            case 0: {
                this.base_ao[0] = this.offset_ao[5][1];
                renderBlocks.__al = this.offset_brightness[5][1];
                this.base_ao[3] = this.offset_ao[5][0];
                renderBlocks.__am = this.offset_brightness[5][0];
                this.base_ao[2] = this.offset_ao[3][2];
                renderBlocks.__an = this.offset_brightness[3][2];
                this.base_ao[1] = this.offset_ao[3][1];
                renderBlocks.__ao = this.offset_brightness[3][1];
                break;
            }
            case 1: {
                this.base_ao[3] = this.offset_ao[4][3];
                renderBlocks.__am = this.offset_brightness[4][3];
                this.base_ao[2] = this.offset_ao[4][2];
                renderBlocks.__an = this.offset_brightness[4][2];
                this.base_ao[1] = this.offset_ao[2][1];
                renderBlocks.__ao = this.offset_brightness[2][1];
                this.base_ao[0] = this.offset_ao[2][0];
                renderBlocks.__al = this.offset_brightness[2][0];
                break;
            }
            case 2: {
                this.base_ao[3] = this.offset_ao[2][3];
                renderBlocks.__am = this.offset_brightness[2][3];
                this.base_ao[2] = this.offset_ao[2][2];
                renderBlocks.__an = this.offset_brightness[2][2];
                this.base_ao[1] = this.offset_ao[5][3];
                renderBlocks.__ao = this.offset_brightness[5][3];
                this.base_ao[0] = this.offset_ao[5][2];
                renderBlocks.__al = this.offset_brightness[5][2];
                break;
            }
            case 3: {
                this.base_ao[0] = this.offset_ao[3][0];
                renderBlocks.__al = this.offset_brightness[3][0];
                this.base_ao[3] = this.offset_ao[3][3];
                renderBlocks.__am = this.offset_brightness[3][3];
                this.base_ao[2] = this.offset_ao[4][1];
                renderBlocks.__an = this.offset_brightness[4][1];
                this.base_ao[1] = this.offset_ao[4][0];
                renderBlocks.__ao = this.offset_brightness[4][0];
                break;
            }
            case 4: {
                this.base_ao[3] = this.offset_ao[0][3];
                renderBlocks.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[2][1];
                renderBlocks.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[2][1];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[2][2];
                renderBlocks.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[2][2];
                this.base_ao[2] = this.offset_ao[0][2];
                renderBlocks.__an = this.offset_brightness[0][2];
                break;
            }
            case 5: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[3][3];
                renderBlocks.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[3][3];
                this.base_ao[0] = this.offset_ao[0][0];
                renderBlocks.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.offset_ao[0][1];
                renderBlocks.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[3][2];
                renderBlocks.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[3][2];
                break;
            }
            case 6: {
                this.base_ao[3] = this.offset_ao[0][3];
                renderBlocks.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.offset_ao[0][0];
                renderBlocks.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[4][1];
                renderBlocks.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[4][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[4][2];
                renderBlocks.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[4][2];
                break;
            }
            case 7: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[5][3];
                renderBlocks.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[5][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[5][0];
                renderBlocks.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[5][0];
                this.base_ao[1] = this.offset_ao[0][1];
                renderBlocks.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.offset_ao[0][2];
                renderBlocks.__an = this.offset_brightness[0][2];
                break;
            }
            case 8: {
                this.base_ao[2] = this.offset_ao[1][2];
                renderBlocks.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[2][0];
                renderBlocks.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[2][0];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[2][3];
                renderBlocks.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[2][3];
                this.base_ao[3] = this.offset_ao[1][3];
                renderBlocks.__an = this.offset_brightness[1][3];
                break;
            }
            case 9: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[3][0];
                renderBlocks.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[3][0];
                this.base_ao[1] = this.offset_ao[1][1];
                renderBlocks.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.offset_ao[1][0];
                renderBlocks.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[3][1];
                renderBlocks.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[3][1];
                break;
            }
            case 10: {
                this.base_ao[2] = this.offset_ao[1][2];
                renderBlocks.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.offset_ao[1][1];
                renderBlocks.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[4][0];
                renderBlocks.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[4][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[4][3];
                renderBlocks.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[4][3];
                break;
            }
            case 11: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[5][2];
                renderBlocks.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[5][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[5][1];
                renderBlocks.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[5][1];
                this.base_ao[0] = this.offset_ao[1][0];
                renderBlocks.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.offset_ao[1][3];
                renderBlocks.__an = this.offset_brightness[1][3];
            }
        }
    }

    private void prepareHorizontalWedge(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        this.setWedgeSlopeLighting(renderBlocks, slope);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 5, 2, n, n2, n3, 0.7f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 4, 4, n, n2, n3, 0.7f);
        }
    }

    private void prepareVerticalWedge(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        this.setWedgeSlopeLighting(renderBlocks, slope);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 2, 2, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else if (slope.facings.contains((Object)ForgeDirection.SOUTH)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 3, 4, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else if (slope.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 4, 6, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 5, 8, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void prepareWedgeIntCorner(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        Slope slope2 = slope.facings.contains((Object)ForgeDirection.WEST) ? (slope.isPositive ? Slope.WEDGE_POS_W : Slope.WEDGE_NEG_W) : (slope.isPositive ? Slope.WEDGE_POS_E : Slope.WEDGE_NEG_E);
        this.setWedgeSlopeLighting(renderBlocks, slope2);
        if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 4, 12, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 5, 13, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
        Slope slope3 = slope.facings.contains((Object)ForgeDirection.NORTH) ? (slope.isPositive ? Slope.WEDGE_POS_N : Slope.WEDGE_NEG_N) : (slope.isPositive ? Slope.WEDGE_POS_S : Slope.WEDGE_NEG_S);
        this.setWedgeSlopeLighting(renderBlocks, slope3);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 2, 10, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 3, 11, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void prepareWedgeExtCorner(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        Slope slope2 = slope.facings.contains((Object)ForgeDirection.WEST) ? (slope.isPositive ? Slope.WEDGE_POS_W : Slope.WEDGE_NEG_W) : (slope.isPositive ? Slope.WEDGE_POS_E : Slope.WEDGE_NEG_E);
        this.setWedgeSlopeLighting(renderBlocks, slope2);
        if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 4, 12, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 5, 13, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
        Slope slope3 = slope.facings.contains((Object)ForgeDirection.NORTH) ? (slope.isPositive ? Slope.WEDGE_POS_N : Slope.WEDGE_NEG_N) : (slope.isPositive ? Slope.WEDGE_POS_S : Slope.WEDGE_NEG_S);
        this.setWedgeSlopeLighting(renderBlocks, slope3);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 2, 10, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 3, 11, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void setObliqueIntSlopeLighting(RenderBlocks renderBlocks, Slope slope) {
        switch (slope.slopeID) {
            case 28: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[5][2];
                renderBlocks.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[5][2];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[2][3];
                renderBlocks.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[2][3];
                this.base_ao[3] = this.offset_ao[1][3];
                renderBlocks.__an = this.offset_brightness[1][3];
                break;
            }
            case 29: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[5][3];
                renderBlocks.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[5][3];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[2][2];
                renderBlocks.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[2][2];
                this.base_ao[2] = this.offset_ao[0][2];
                renderBlocks.__an = this.offset_brightness[0][2];
                break;
            }
            case 30: {
                this.base_ao[2] = this.offset_ao[1][2];
                renderBlocks.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[2][0];
                renderBlocks.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[2][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[4][3];
                renderBlocks.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[4][3];
                break;
            }
            case 31: {
                this.base_ao[3] = this.offset_ao[0][3];
                renderBlocks.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[2][1];
                renderBlocks.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[2][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[4][2];
                renderBlocks.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[4][2];
                break;
            }
            case 32: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[3][0];
                renderBlocks.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[3][0];
                this.base_ao[1] = this.offset_ao[1][1];
                renderBlocks.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[4][0];
                renderBlocks.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[4][0];
                break;
            }
            case 33: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[3][3];
                renderBlocks.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[3][3];
                this.base_ao[0] = this.offset_ao[0][0];
                renderBlocks.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[4][1];
                renderBlocks.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[4][1];
                break;
            }
            case 34: {
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[5][1];
                renderBlocks.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[5][1];
                this.base_ao[0] = this.offset_ao[1][0];
                renderBlocks.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[3][1];
                renderBlocks.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[3][1];
                break;
            }
            case 35: {
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[5][0];
                renderBlocks.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[5][0];
                this.base_ao[1] = this.offset_ao[0][1];
                renderBlocks.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[3][2];
                renderBlocks.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[3][2];
            }
        }
    }

    private void prepareObliqueIntCorner(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.setObliqueIntSlopeLighting(renderBlocks, slope);
        }
        if (slope.isPositive) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 15, n, n2, n3, 0.85f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 14, n, n2, n3, 0.6f);
        }
    }

    private void setObliqueExtSlopeLighting(RenderBlocks renderBlocks, Slope slope) {
        switch (slope.slopeID) {
            case 36: {
                this.base_ao[2] = this.offset_ao[1][2];
                renderBlocks.__am = this.offset_brightness[1][2];
                this.base_ao[0] = this.offset_ao[1][0];
                renderBlocks.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : (this.offset_ao[3][1] + this.offset_ao[4][3]) / 2.0f;
                renderBlocks.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : (this.offset_brightness[3][1] + this.offset_brightness[4][3]) / 2;
                break;
            }
            case 37: {
                this.base_ao[3] = this.offset_ao[0][3];
                renderBlocks.__am = this.offset_brightness[0][3];
                this.base_ao[1] = this.offset_ao[0][1];
                renderBlocks.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : (this.offset_ao[3][2] + this.offset_ao[4][2]) / 2.0f;
                renderBlocks.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : (this.offset_brightness[3][2] + this.offset_brightness[4][2]) / 2;
                break;
            }
            case 38: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : (this.offset_ao[5][2] + this.offset_ao[3][0]) / 2.0f;
                renderBlocks.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : (this.offset_brightness[5][2] + this.offset_brightness[3][0]) / 2;
                this.base_ao[1] = this.offset_ao[1][1];
                renderBlocks.__al = this.offset_brightness[1][1];
                this.base_ao[3] = this.offset_ao[1][3];
                renderBlocks.__an = this.offset_brightness[1][3];
                break;
            }
            case 39: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : (this.offset_ao[3][3] + this.offset_ao[5][3]) / 2.0f;
                renderBlocks.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : (this.offset_brightness[3][3] + this.offset_brightness[5][3]) / 2;
                this.base_ao[0] = this.offset_ao[0][0];
                renderBlocks.__al = this.offset_brightness[0][0];
                this.base_ao[2] = this.offset_ao[0][2];
                renderBlocks.__an = this.offset_brightness[0][2];
                break;
            }
            case 40: {
                this.base_ao[2] = this.offset_ao[1][2];
                renderBlocks.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : (this.offset_ao[2][0] + this.offset_ao[5][1]) / 2.0f;
                renderBlocks.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : (this.offset_brightness[2][0] + this.offset_brightness[5][1]) / 2;
                this.base_ao[0] = this.offset_ao[1][0];
                renderBlocks.__ao = this.offset_brightness[1][0];
                break;
            }
            case 41: {
                this.base_ao[3] = this.offset_ao[0][3];
                renderBlocks.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : (this.offset_ao[2][1] + this.offset_ao[5][0]) / 2.0f;
                renderBlocks.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : (this.offset_brightness[2][1] + this.offset_brightness[5][0]) / 2;
                this.base_ao[1] = this.offset_ao[0][1];
                renderBlocks.__ao = this.offset_brightness[0][1];
                break;
            }
            case 42: {
                this.base_ao[1] = this.offset_ao[1][1];
                renderBlocks.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : (this.offset_ao[4][0] + this.offset_ao[2][3]) / 2.0f;
                renderBlocks.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : (this.offset_brightness[4][0] + this.offset_brightness[2][3]) / 2;
                this.base_ao[3] = this.offset_ao[1][3];
                renderBlocks.__an = this.offset_brightness[1][3];
                break;
            }
            case 43: {
                this.base_ao[0] = this.offset_ao[0][0];
                renderBlocks.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : (this.offset_ao[2][2] + this.offset_ao[4][1]) / 2.0f;
                renderBlocks.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : (this.offset_brightness[2][2] + this.offset_brightness[4][1]) / 2;
                this.base_ao[2] = this.offset_ao[0][2];
                renderBlocks.__an = this.offset_brightness[0][2];
            }
        }
    }

    private void prepareObliqueExtCorner(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.setObliqueExtSlopeLighting(renderBlocks, slope);
        }
        if (slope.isPositive) {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 15, n, n2, n3, 0.85f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 14, n, n2, n3, 0.6f);
        }
    }

    private void preparePyramid(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3);
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        switch (slope.slopeID) {
            case 44: {
                if (renderBlocks._w) {
                    this.base_ao[2] = this.offset_ao[1][2];
                    renderBlocks.__am = this.offset_brightness[1][2];
                    this.base_ao[1] = this.offset_ao[1][1];
                    renderBlocks.__al = this.offset_brightness[1][1];
                    this.base_ao[0] = f;
                    renderBlocks.__ao = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 22, n, n2, n3, 0.8f);
                if (renderBlocks._w) {
                    this.base_ao[2] = f;
                    renderBlocks.__am = n4;
                    this.base_ao[0] = this.offset_ao[1][0];
                    renderBlocks.__ao = this.offset_brightness[1][0];
                    this.base_ao[3] = this.offset_ao[1][3];
                    renderBlocks.__an = this.offset_brightness[1][3];
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 23, n, n2, n3, 0.8f);
                if (renderBlocks._w) {
                    this.base_ao[2] = this.offset_ao[1][2];
                    renderBlocks.__am = this.offset_brightness[1][2];
                    this.base_ao[0] = f;
                    renderBlocks.__ao = n4;
                    this.base_ao[3] = this.offset_ao[1][3];
                    renderBlocks.__an = this.offset_brightness[1][3];
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 20, n, n2, n3, 0.9f);
                if (renderBlocks._w) {
                    this.base_ao[1] = this.offset_ao[1][1];
                    renderBlocks.__al = this.offset_brightness[1][1];
                    this.base_ao[0] = this.offset_ao[1][0];
                    renderBlocks.__ao = this.offset_brightness[1][0];
                    this.base_ao[3] = f;
                    renderBlocks.__an = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 21, n, n2, n3, 0.9f);
                break;
            }
            case 45: {
                if (renderBlocks._w) {
                    this.base_ao[3] = this.offset_ao[0][3];
                    renderBlocks.__am = this.offset_brightness[0][3];
                    this.base_ao[0] = this.offset_ao[0][0];
                    renderBlocks.__al = this.offset_brightness[0][0];
                    this.base_ao[2] = f;
                    renderBlocks.__an = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 18, n, n2, n3, 0.55f);
                if (renderBlocks._w) {
                    this.base_ao[0] = f;
                    renderBlocks.__al = n4;
                    this.base_ao[1] = this.offset_ao[0][1];
                    renderBlocks.__ao = this.offset_brightness[0][1];
                    this.base_ao[2] = this.offset_ao[0][2];
                    renderBlocks.__an = this.offset_brightness[0][2];
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 19, n, n2, n3, 0.55f);
                if (renderBlocks._w) {
                    this.base_ao[3] = this.offset_ao[0][3];
                    renderBlocks.__am = this.offset_brightness[0][3];
                    this.base_ao[0] = f;
                    renderBlocks.__al = n4;
                    this.base_ao[2] = this.offset_ao[0][2];
                    renderBlocks.__an = this.offset_brightness[0][2];
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 16, n, n2, n3, 0.65f);
                if (renderBlocks._w) {
                    this.base_ao[3] = f;
                    renderBlocks.__am = n4;
                    this.base_ao[0] = this.offset_ao[0][0];
                    renderBlocks.__al = this.offset_brightness[0][0];
                    this.base_ao[1] = this.offset_ao[0][1];
                    renderBlocks.__ao = this.offset_brightness[0][1];
                }
                this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 17, n, n2, n3, 0.65f);
            }
        }
    }

    private void prepareFaceYNeg(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[3] = this.ao[0][3];
            renderBlocks.__am = this.brightness[0][3];
            this.base_ao[0] = this.ao[0][0];
            renderBlocks.__al = this.brightness[0][0];
            this.base_ao[1] = this.ao[0][1];
            renderBlocks.__ao = this.brightness[0][1];
            this.base_ao[2] = this.ao[0][2];
            renderBlocks.__an = this.brightness[0][2];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 0, 0, n, n2, n3, 0.5f);
    }

    private void prepareFaceYPos(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[2] = this.ao[1][2];
            renderBlocks.__am = this.brightness[1][2];
            this.base_ao[1] = this.ao[1][1];
            renderBlocks.__al = this.brightness[1][1];
            this.base_ao[0] = this.ao[1][0];
            renderBlocks.__ao = this.brightness[1][0];
            this.base_ao[3] = this.ao[1][3];
            renderBlocks.__an = this.brightness[1][3];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 1, 1, n, n2, n3, 1.0f);
    }

    private void prepareFaceZNeg(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[3] = this.ao[2][3];
            renderBlocks.__am = this.brightness[2][3];
            this.base_ao[2] = this.ao[2][2];
            renderBlocks.__an = this.brightness[2][2];
            this.base_ao[1] = this.ao[2][1];
            renderBlocks.__ao = this.brightness[2][1];
            this.base_ao[0] = this.ao[2][0];
            renderBlocks.__al = this.brightness[2][0];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 2, 3, n, n2, n3, 0.8f);
    }

    private void prepareFaceZPos(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[0] = this.ao[3][0];
            renderBlocks.__al = this.brightness[3][0];
            this.base_ao[3] = this.ao[3][3];
            renderBlocks.__am = this.brightness[3][3];
            this.base_ao[2] = this.ao[3][2];
            renderBlocks.__an = this.brightness[3][2];
            this.base_ao[1] = this.ao[3][1];
            renderBlocks.__ao = this.brightness[3][1];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 3, 5, n, n2, n3, 0.8f);
    }

    private void prepareFaceXNeg(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[3] = this.ao[4][3];
            renderBlocks.__am = this.brightness[4][3];
            this.base_ao[2] = this.ao[4][2];
            renderBlocks.__an = this.brightness[4][2];
            this.base_ao[1] = this.ao[4][1];
            renderBlocks.__ao = this.brightness[4][1];
            this.base_ao[0] = this.ao[4][0];
            renderBlocks.__al = this.brightness[4][0];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 4, 7, n, n2, n3, 0.6f);
    }

    private void prepareFaceXPos(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, Slope slope, int n, int n2, int n3) {
        if (renderBlocks._w) {
            this.base_ao[1] = this.ao[5][1];
            renderBlocks.__am = this.brightness[5][1];
            this.base_ao[0] = this.ao[5][0];
            renderBlocks.__al = this.brightness[5][0];
            this.base_ao[3] = this.ao[5][3];
            renderBlocks.__ao = this.brightness[5][3];
            this.base_ao[2] = this.ao[5][2];
            renderBlocks.__an = this.brightness[5][2];
        }
        this.prepareSlopeRender(tECarpentersBlock, renderBlocks, block, block2, 5, 9, n, n2, n3, 0.6f);
    }

    @Override
    public boolean renderStandardSlopeWithColorMultiplier(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        renderBlocks._w = false;
        Tessellator tessellator = renderBlocks.__aF;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3));
        this.isSideSloped = true;
        switch (NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[slope.slopeType.ordinal()]) {
            case 1: {
                this.prepareHorizontalWedge(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 2: {
                this.prepareVerticalWedge(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 3: {
                this.prepareWedgeIntCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 4: {
                this.prepareWedgeExtCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 5: {
                this.prepareObliqueIntCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 6: {
                this.prepareObliqueExtCorner(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
                break;
            }
            case 7: {
                this.preparePyramid(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
            }
        }
        this.isSideSloped = false;
        if (slope.hasSide(ForgeDirection.DOWN) && block2.shouldSideBeRendered(renderBlocks._a, n, n2 - 1, n3, 0)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3));
            this.prepareFaceYNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.UP) && block2.shouldSideBeRendered(renderBlocks._a, n, n2 + 1, n3, 1)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3));
            this.prepareFaceYPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.NORTH) && block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 - 1, 2)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1));
            this.prepareFaceZNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.SOUTH) && block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 + 1, 3)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1));
            this.prepareFaceZPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.WEST) && block2.shouldSideBeRendered(renderBlocks._a, n - 1, n2, n3, 4)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3));
            this.prepareFaceXNeg(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.EAST) && block2.shouldSideBeRendered(renderBlocks._a, n + 1, n2, n3, 5)) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3));
            this.prepareFaceXPos(tECarpentersBlock, renderBlocks, block, block2, slope, n, n2, n3);
        }
        return true;
    }

    static class NamelessClass493599135 {
        static final int[] $SwitchMap$carpentersblocks$data$Slope$SlopeType = new int[Slope.SlopeType.values().length];

        NamelessClass493599135() {
        }

        static {
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.WEDGE_XZ.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.WEDGE_Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.WEDGE_INT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.WEDGE_EXT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.OBLIQUE_INT.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.OBLIQUE_EXT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[Slope.SlopeType.PYRAMID.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

