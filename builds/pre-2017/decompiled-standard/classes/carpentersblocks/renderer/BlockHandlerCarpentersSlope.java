/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.data.Slope;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import net.minecraft.util.dwan;
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
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
        this.renderHelperWedge.renderFaceYNeg(htvc2, 10, 0.0, 0.0, 0.0, twgu2.func_71851_a(0));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        this.helperWedge.renderSlopeXNeg(htvc2, 10, 0.0, 0.0, 0.0, twgu2.func_71851_a(1));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
        this.renderHelperWedge.renderFaceZNeg(htvc2, 10, 0.0, 0.0, 0.0, twgu2.func_71851_a(2));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
        this.renderHelperWedge.renderFaceZPos(htvc2, 10, 0.0, 0.0, 0.0, twgu2.func_71851_a(2));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
        this.renderHelperWedge.renderFaceXPos(htvc2, 10, 0.0, 0.0, 0.0, twgu2.func_71851_a(2));
        htvf2.func_78381_a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    private void prepareSlopeRender(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4, int n5, float f) {
        this.slopeRenderID = n2;
        this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, n, n3, n4, n5, f);
    }

    @Override
    protected void renderSide(TECarpentersBlock tECarpentersBlock, htvc htvc2, int n, double d, int n2, int n3, int n4, dwan dwan2) {
        if (this.isSideCover) {
            super.renderSide(tECarpentersBlock, htvc2, n, d, n2, n3, n4, dwan2);
        } else {
            int n5 = BlockProperties.getData(tECarpentersBlock);
            switch (this.slopeRenderID) {
                case 0: {
                    this.renderHelperWedge.renderFaceYNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 1: {
                    this.renderHelperWedge.renderFaceYPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 2: {
                    this.helperWedge.renderSlopeZNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 3: {
                    this.renderHelperWedge.renderFaceZNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 4: {
                    this.helperWedge.renderSlopeZPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 5: {
                    this.renderHelperWedge.renderFaceZPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 6: {
                    this.helperWedge.renderSlopeXNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 7: {
                    this.renderHelperWedge.renderFaceXNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 8: {
                    this.helperWedge.renderSlopeXPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 9: {
                    this.renderHelperWedge.renderFaceXPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 10: {
                    this.helperWedgeCorner.renderSlopeZNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 11: {
                    this.helperWedgeCorner.renderSlopeZPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 12: {
                    this.helperWedgeCorner.renderSlopeXNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 13: {
                    this.helperWedgeCorner.renderSlopeXPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 14: {
                    this.helperOblique.renderSlopeYNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 15: {
                    this.helperOblique.renderSlopeYPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 16: {
                    this.helperPyramid.renderFaceYNegZNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 17: {
                    this.helperPyramid.renderFaceYNegZPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 18: {
                    this.helperPyramid.renderFaceYNegXNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 19: {
                    this.helperPyramid.renderFaceYNegXPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 20: {
                    this.helperPyramid.renderFaceYPosZNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 21: {
                    this.helperPyramid.renderFaceYPosZPos(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 22: {
                    this.helperPyramid.renderFaceYPosXNeg(htvc2, n5, n2, n3, n4, dwan2);
                    break;
                }
                case 23: {
                    this.helperPyramid.renderFaceYPosXPos(htvc2, n5, n2, n3, n4, dwan2);
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
    public boolean renderStandardSlopeWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        htvc2._w = true;
        twgu2.func_71874_e(htvc2._a, n, n2, n3);
        htvf htvf2 = htvc2.__aF;
        htvf2.func_78380_c(983055);
        this.setLightnessYNeg(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[0], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[0], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessYPos(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[1], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[1], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessZNeg(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[2], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[2], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessZPos(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[3], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[3], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessXNeg(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[4], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[4], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessXPos(htvc2, twgu2, n, n2, n3);
        this.setAoArr(this.ao[5], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.brightness[5], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessYNeg(htvc2, twgu2, n, n2 + 1, n3);
        this.setAoArr(this.offset_ao[0], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[0], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessYPos(htvc2, twgu2, n, n2 - 1, n3);
        this.setAoArr(this.offset_ao[1], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[1], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessZNeg(htvc2, twgu2, n, n2, n3 + 1);
        this.setAoArr(this.offset_ao[2], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[2], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessZPos(htvc2, twgu2, n, n2, n3 - 1);
        this.setAoArr(this.offset_ao[3], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[3], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessXNeg(htvc2, twgu2, n + 1, n2, n3);
        this.setAoArr(this.offset_ao[4], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[4], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.setLightnessXPos(htvc2, twgu2, n - 1, n2, n3);
        this.setAoArr(this.offset_ao[5], this.base_ao[0], this.base_ao[1], this.base_ao[2], this.base_ao[3]);
        this.setBrightnessArr(this.offset_brightness[5], htvc2.__al, htvc2.__ao, htvc2.__an, htvc2.__am);
        this.isSideSloped = true;
        switch (slope.slopeType.ordinal() + 1) {
            case 1: {
                this.prepareHorizontalWedge(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 2: {
                this.prepareVerticalWedge(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 3: {
                this.prepareWedgeIntCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 4: {
                this.prepareWedgeExtCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 5: {
                this.prepareObliqueIntCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 6: {
                this.prepareObliqueExtCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 7: {
                this.preparePyramid(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
            }
        }
        this.isSideSloped = false;
        if (slope.hasSide(ForgeDirection.DOWN) && twgu3.func_71877_c(htvc2._a, n, n2 - 1, n3, 0)) {
            this.prepareFaceYNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.UP) && twgu3.func_71877_c(htvc2._a, n, n2 + 1, n3, 1)) {
            this.prepareFaceYPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.NORTH) && twgu3.func_71877_c(htvc2._a, n, n2, n3 - 1, 2)) {
            this.prepareFaceZNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.SOUTH) && twgu3.func_71877_c(htvc2._a, n, n2, n3 + 1, 3)) {
            this.prepareFaceZPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.WEST) && twgu3.func_71877_c(htvc2._a, n - 1, n2, n3, 4)) {
            this.prepareFaceXNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.EAST) && twgu3.func_71877_c(htvc2._a, n + 1, n2, n3, 5)) {
            this.prepareFaceXPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        htvc2._w = false;
        return true;
    }

    private void setWedgeSlopeLighting(htvc htvc2, Slope slope) {
        switch (slope.slopeID) {
            case 0: {
                this.base_ao[0] = this.offset_ao[5][1];
                htvc2.__al = this.offset_brightness[5][1];
                this.base_ao[3] = this.offset_ao[5][0];
                htvc2.__am = this.offset_brightness[5][0];
                this.base_ao[2] = this.offset_ao[3][2];
                htvc2.__an = this.offset_brightness[3][2];
                this.base_ao[1] = this.offset_ao[3][1];
                htvc2.__ao = this.offset_brightness[3][1];
                break;
            }
            case 1: {
                this.base_ao[3] = this.offset_ao[4][3];
                htvc2.__am = this.offset_brightness[4][3];
                this.base_ao[2] = this.offset_ao[4][2];
                htvc2.__an = this.offset_brightness[4][2];
                this.base_ao[1] = this.offset_ao[2][1];
                htvc2.__ao = this.offset_brightness[2][1];
                this.base_ao[0] = this.offset_ao[2][0];
                htvc2.__al = this.offset_brightness[2][0];
                break;
            }
            case 2: {
                this.base_ao[3] = this.offset_ao[2][3];
                htvc2.__am = this.offset_brightness[2][3];
                this.base_ao[2] = this.offset_ao[2][2];
                htvc2.__an = this.offset_brightness[2][2];
                this.base_ao[1] = this.offset_ao[5][3];
                htvc2.__ao = this.offset_brightness[5][3];
                this.base_ao[0] = this.offset_ao[5][2];
                htvc2.__al = this.offset_brightness[5][2];
                break;
            }
            case 3: {
                this.base_ao[0] = this.offset_ao[3][0];
                htvc2.__al = this.offset_brightness[3][0];
                this.base_ao[3] = this.offset_ao[3][3];
                htvc2.__am = this.offset_brightness[3][3];
                this.base_ao[2] = this.offset_ao[4][1];
                htvc2.__an = this.offset_brightness[4][1];
                this.base_ao[1] = this.offset_ao[4][0];
                htvc2.__ao = this.offset_brightness[4][0];
                break;
            }
            case 4: {
                this.base_ao[3] = this.offset_ao[0][3];
                htvc2.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[2][1];
                htvc2.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[2][1];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[2][2];
                htvc2.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[2][2];
                this.base_ao[2] = this.offset_ao[0][2];
                htvc2.__an = this.offset_brightness[0][2];
                break;
            }
            case 5: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[3][3];
                htvc2.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[3][3];
                this.base_ao[0] = this.offset_ao[0][0];
                htvc2.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.offset_ao[0][1];
                htvc2.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[3][2];
                htvc2.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[3][2];
                break;
            }
            case 6: {
                this.base_ao[3] = this.offset_ao[0][3];
                htvc2.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.offset_ao[0][0];
                htvc2.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[4][1];
                htvc2.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[4][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[4][2];
                htvc2.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[4][2];
                break;
            }
            case 7: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[5][3];
                htvc2.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[5][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[5][0];
                htvc2.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[5][0];
                this.base_ao[1] = this.offset_ao[0][1];
                htvc2.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.offset_ao[0][2];
                htvc2.__an = this.offset_brightness[0][2];
                break;
            }
            case 8: {
                this.base_ao[2] = this.offset_ao[1][2];
                htvc2.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[2][0];
                htvc2.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[2][0];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[2][3];
                htvc2.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[2][3];
                this.base_ao[3] = this.offset_ao[1][3];
                htvc2.__an = this.offset_brightness[1][3];
                break;
            }
            case 9: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[3][0];
                htvc2.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[3][0];
                this.base_ao[1] = this.offset_ao[1][1];
                htvc2.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.offset_ao[1][0];
                htvc2.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[3][1];
                htvc2.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[3][1];
                break;
            }
            case 10: {
                this.base_ao[2] = this.offset_ao[1][2];
                htvc2.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.offset_ao[1][1];
                htvc2.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[4][0];
                htvc2.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[4][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[4][3];
                htvc2.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[4][3];
                break;
            }
            case 11: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[5][2];
                htvc2.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[5][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[5][1];
                htvc2.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[5][1];
                this.base_ao[0] = this.offset_ao[1][0];
                htvc2.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.offset_ao[1][3];
                htvc2.__an = this.offset_brightness[1][3];
            }
        }
    }

    private void prepareHorizontalWedge(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        this.setWedgeSlopeLighting(htvc2, slope);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, 2, n, n2, n3, 0.7f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, 4, n, n2, n3, 0.7f);
        }
    }

    private void prepareVerticalWedge(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        this.setWedgeSlopeLighting(htvc2, slope);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, 2, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else if (slope.facings.contains((Object)ForgeDirection.SOUTH)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, 4, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else if (slope.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, 6, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, 8, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void prepareWedgeIntCorner(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        Slope slope2 = slope.facings.contains((Object)ForgeDirection.WEST) ? (slope.isPositive ? Slope.WEDGE_POS_W : Slope.WEDGE_NEG_W) : (slope.isPositive ? Slope.WEDGE_POS_E : Slope.WEDGE_NEG_E);
        this.setWedgeSlopeLighting(htvc2, slope2);
        if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, 12, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, 13, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
        Slope slope3 = slope.facings.contains((Object)ForgeDirection.NORTH) ? (slope.isPositive ? Slope.WEDGE_POS_N : Slope.WEDGE_NEG_N) : (slope.isPositive ? Slope.WEDGE_POS_S : Slope.WEDGE_NEG_S);
        this.setWedgeSlopeLighting(htvc2, slope3);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, 10, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, 11, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void prepareWedgeExtCorner(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        Slope slope2 = slope.facings.contains((Object)ForgeDirection.WEST) ? (slope.isPositive ? Slope.WEDGE_POS_W : Slope.WEDGE_NEG_W) : (slope.isPositive ? Slope.WEDGE_POS_E : Slope.WEDGE_NEG_E);
        this.setWedgeSlopeLighting(htvc2, slope2);
        if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, 12, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, 13, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
        Slope slope3 = slope.facings.contains((Object)ForgeDirection.NORTH) ? (slope.isPositive ? Slope.WEDGE_POS_N : Slope.WEDGE_NEG_N) : (slope.isPositive ? Slope.WEDGE_POS_S : Slope.WEDGE_NEG_S);
        this.setWedgeSlopeLighting(htvc2, slope3);
        if (slope.facings.contains((Object)ForgeDirection.NORTH)) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, 10, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, 11, n, n2, n3, slope.isPositive ? 0.9f : 0.9f);
        }
    }

    private void setObliqueIntSlopeLighting(htvc htvc2, Slope slope) {
        switch (slope.slopeID) {
            case 28: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[5][2];
                htvc2.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[5][2];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[2][3];
                htvc2.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[2][3];
                this.base_ao[3] = this.offset_ao[1][3];
                htvc2.__an = this.offset_brightness[1][3];
                break;
            }
            case 29: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[5][3];
                htvc2.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[5][3];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[2][2];
                htvc2.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[2][2];
                this.base_ao[2] = this.offset_ao[0][2];
                htvc2.__an = this.offset_brightness[0][2];
                break;
            }
            case 30: {
                this.base_ao[2] = this.offset_ao[1][2];
                htvc2.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[2][0];
                htvc2.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[2][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[4][3];
                htvc2.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[4][3];
                break;
            }
            case 31: {
                this.base_ao[3] = this.offset_ao[0][3];
                htvc2.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[2][1];
                htvc2.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[2][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[4][2];
                htvc2.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[4][2];
                break;
            }
            case 32: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : this.offset_ao[3][0];
                htvc2.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : this.offset_brightness[3][0];
                this.base_ao[1] = this.offset_ao[1][1];
                htvc2.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : this.offset_ao[4][0];
                htvc2.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : this.offset_brightness[4][0];
                break;
            }
            case 33: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : this.offset_ao[3][3];
                htvc2.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : this.offset_brightness[3][3];
                this.base_ao[0] = this.offset_ao[0][0];
                htvc2.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : this.offset_ao[4][1];
                htvc2.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : this.offset_brightness[4][1];
                break;
            }
            case 34: {
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : this.offset_ao[5][1];
                htvc2.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : this.offset_brightness[5][1];
                this.base_ao[0] = this.offset_ao[1][0];
                htvc2.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : this.offset_ao[3][1];
                htvc2.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : this.offset_brightness[3][1];
                break;
            }
            case 35: {
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : this.offset_ao[5][0];
                htvc2.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : this.offset_brightness[5][0];
                this.base_ao[1] = this.offset_ao[0][1];
                htvc2.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : this.offset_ao[3][2];
                htvc2.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : this.offset_brightness[3][2];
            }
        }
    }

    private void prepareObliqueIntCorner(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.setObliqueIntSlopeLighting(htvc2, slope);
        }
        if (slope.isPositive) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 15, n, n2, n3, 0.85f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 14, n, n2, n3, 0.6f);
        }
    }

    private void setObliqueExtSlopeLighting(htvc htvc2, Slope slope) {
        switch (slope.slopeID) {
            case 36: {
                this.base_ao[2] = this.offset_ao[1][2];
                htvc2.__am = this.offset_brightness[1][2];
                this.base_ao[0] = this.offset_ao[1][0];
                htvc2.__ao = this.offset_brightness[1][0];
                this.base_ao[3] = this.ao[1][3] == 1.0f ? 1.0f : (this.offset_ao[3][1] + this.offset_ao[4][3]) / 2.0f;
                htvc2.__an = this.ao[1][3] == 1.0f ? this.brightness[1][3] : (this.offset_brightness[3][1] + this.offset_brightness[4][3]) / 2;
                break;
            }
            case 37: {
                this.base_ao[3] = this.offset_ao[0][3];
                htvc2.__am = this.offset_brightness[0][3];
                this.base_ao[1] = this.offset_ao[0][1];
                htvc2.__ao = this.offset_brightness[0][1];
                this.base_ao[2] = this.ao[0][2] == 1.0f ? 1.0f : (this.offset_ao[3][2] + this.offset_ao[4][2]) / 2.0f;
                htvc2.__an = this.ao[0][2] == 1.0f ? this.brightness[0][2] : (this.offset_brightness[3][2] + this.offset_brightness[4][2]) / 2;
                break;
            }
            case 38: {
                this.base_ao[2] = this.ao[1][2] == 1.0f ? 1.0f : (this.offset_ao[5][2] + this.offset_ao[3][0]) / 2.0f;
                htvc2.__am = this.ao[1][2] == 1.0f ? this.brightness[1][2] : (this.offset_brightness[5][2] + this.offset_brightness[3][0]) / 2;
                this.base_ao[1] = this.offset_ao[1][1];
                htvc2.__al = this.offset_brightness[1][1];
                this.base_ao[3] = this.offset_ao[1][3];
                htvc2.__an = this.offset_brightness[1][3];
                break;
            }
            case 39: {
                this.base_ao[3] = this.ao[0][3] == 1.0f ? 1.0f : (this.offset_ao[3][3] + this.offset_ao[5][3]) / 2.0f;
                htvc2.__am = this.ao[0][3] == 1.0f ? this.brightness[0][3] : (this.offset_brightness[3][3] + this.offset_brightness[5][3]) / 2;
                this.base_ao[0] = this.offset_ao[0][0];
                htvc2.__al = this.offset_brightness[0][0];
                this.base_ao[2] = this.offset_ao[0][2];
                htvc2.__an = this.offset_brightness[0][2];
                break;
            }
            case 40: {
                this.base_ao[2] = this.offset_ao[1][2];
                htvc2.__am = this.offset_brightness[1][2];
                this.base_ao[1] = this.ao[1][1] == 1.0f ? 1.0f : (this.offset_ao[2][0] + this.offset_ao[5][1]) / 2.0f;
                htvc2.__al = this.ao[1][1] == 1.0f ? this.brightness[1][1] : (this.offset_brightness[2][0] + this.offset_brightness[5][1]) / 2;
                this.base_ao[0] = this.offset_ao[1][0];
                htvc2.__ao = this.offset_brightness[1][0];
                break;
            }
            case 41: {
                this.base_ao[3] = this.offset_ao[0][3];
                htvc2.__am = this.offset_brightness[0][3];
                this.base_ao[0] = this.ao[0][0] == 1.0f ? 1.0f : (this.offset_ao[2][1] + this.offset_ao[5][0]) / 2.0f;
                htvc2.__al = this.ao[0][0] == 1.0f ? this.brightness[0][0] : (this.offset_brightness[2][1] + this.offset_brightness[5][0]) / 2;
                this.base_ao[1] = this.offset_ao[0][1];
                htvc2.__ao = this.offset_brightness[0][1];
                break;
            }
            case 42: {
                this.base_ao[1] = this.offset_ao[1][1];
                htvc2.__al = this.offset_brightness[1][1];
                this.base_ao[0] = this.ao[1][0] == 1.0f ? 1.0f : (this.offset_ao[4][0] + this.offset_ao[2][3]) / 2.0f;
                htvc2.__ao = this.ao[1][0] == 1.0f ? this.brightness[1][0] : (this.offset_brightness[4][0] + this.offset_brightness[2][3]) / 2;
                this.base_ao[3] = this.offset_ao[1][3];
                htvc2.__an = this.offset_brightness[1][3];
                break;
            }
            case 43: {
                this.base_ao[0] = this.offset_ao[0][0];
                htvc2.__al = this.offset_brightness[0][0];
                this.base_ao[1] = this.ao[0][1] == 1.0f ? 1.0f : (this.offset_ao[2][2] + this.offset_ao[4][1]) / 2.0f;
                htvc2.__ao = this.ao[0][1] == 1.0f ? this.brightness[0][1] : (this.offset_brightness[2][2] + this.offset_brightness[4][1]) / 2;
                this.base_ao[2] = this.offset_ao[0][2];
                htvc2.__an = this.offset_brightness[0][2];
            }
        }
    }

    private void prepareObliqueExtCorner(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.setObliqueExtSlopeLighting(htvc2, slope);
        }
        if (slope.isPositive) {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 15, n, n2, n3, 0.85f);
        } else {
            this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 14, n, n2, n3, 0.6f);
        }
    }

    private void preparePyramid(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        float f = twgu2.func_71888_h(htvc2._a, n, n2, n3);
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        switch (slope.slopeID) {
            case 44: {
                if (htvc2._w) {
                    this.base_ao[2] = this.offset_ao[1][2];
                    htvc2.__am = this.offset_brightness[1][2];
                    this.base_ao[1] = this.offset_ao[1][1];
                    htvc2.__al = this.offset_brightness[1][1];
                    this.base_ao[0] = f;
                    htvc2.__ao = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 22, n, n2, n3, 0.8f);
                if (htvc2._w) {
                    this.base_ao[2] = f;
                    htvc2.__am = n4;
                    this.base_ao[0] = this.offset_ao[1][0];
                    htvc2.__ao = this.offset_brightness[1][0];
                    this.base_ao[3] = this.offset_ao[1][3];
                    htvc2.__an = this.offset_brightness[1][3];
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 23, n, n2, n3, 0.8f);
                if (htvc2._w) {
                    this.base_ao[2] = this.offset_ao[1][2];
                    htvc2.__am = this.offset_brightness[1][2];
                    this.base_ao[0] = f;
                    htvc2.__ao = n4;
                    this.base_ao[3] = this.offset_ao[1][3];
                    htvc2.__an = this.offset_brightness[1][3];
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 20, n, n2, n3, 0.9f);
                if (htvc2._w) {
                    this.base_ao[1] = this.offset_ao[1][1];
                    htvc2.__al = this.offset_brightness[1][1];
                    this.base_ao[0] = this.offset_ao[1][0];
                    htvc2.__ao = this.offset_brightness[1][0];
                    this.base_ao[3] = f;
                    htvc2.__an = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 21, n, n2, n3, 0.9f);
                break;
            }
            case 45: {
                if (htvc2._w) {
                    this.base_ao[3] = this.offset_ao[0][3];
                    htvc2.__am = this.offset_brightness[0][3];
                    this.base_ao[0] = this.offset_ao[0][0];
                    htvc2.__al = this.offset_brightness[0][0];
                    this.base_ao[2] = f;
                    htvc2.__an = n4;
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 18, n, n2, n3, 0.55f);
                if (htvc2._w) {
                    this.base_ao[0] = f;
                    htvc2.__al = n4;
                    this.base_ao[1] = this.offset_ao[0][1];
                    htvc2.__ao = this.offset_brightness[0][1];
                    this.base_ao[2] = this.offset_ao[0][2];
                    htvc2.__an = this.offset_brightness[0][2];
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 19, n, n2, n3, 0.55f);
                if (htvc2._w) {
                    this.base_ao[3] = this.offset_ao[0][3];
                    htvc2.__am = this.offset_brightness[0][3];
                    this.base_ao[0] = f;
                    htvc2.__al = n4;
                    this.base_ao[2] = this.offset_ao[0][2];
                    htvc2.__an = this.offset_brightness[0][2];
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 16, n, n2, n3, 0.65f);
                if (htvc2._w) {
                    this.base_ao[3] = f;
                    htvc2.__am = n4;
                    this.base_ao[0] = this.offset_ao[0][0];
                    htvc2.__al = this.offset_brightness[0][0];
                    this.base_ao[1] = this.offset_ao[0][1];
                    htvc2.__ao = this.offset_brightness[0][1];
                }
                this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 17, n, n2, n3, 0.65f);
            }
        }
    }

    private void prepareFaceYNeg(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[3] = this.ao[0][3];
            htvc2.__am = this.brightness[0][3];
            this.base_ao[0] = this.ao[0][0];
            htvc2.__al = this.brightness[0][0];
            this.base_ao[1] = this.ao[0][1];
            htvc2.__ao = this.brightness[0][1];
            this.base_ao[2] = this.ao[0][2];
            htvc2.__an = this.brightness[0][2];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, 0, n, n2, n3, 0.5f);
    }

    private void prepareFaceYPos(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[2] = this.ao[1][2];
            htvc2.__am = this.brightness[1][2];
            this.base_ao[1] = this.ao[1][1];
            htvc2.__al = this.brightness[1][1];
            this.base_ao[0] = this.ao[1][0];
            htvc2.__ao = this.brightness[1][0];
            this.base_ao[3] = this.ao[1][3];
            htvc2.__an = this.brightness[1][3];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, 1, n, n2, n3, 1.0f);
    }

    private void prepareFaceZNeg(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[3] = this.ao[2][3];
            htvc2.__am = this.brightness[2][3];
            this.base_ao[2] = this.ao[2][2];
            htvc2.__an = this.brightness[2][2];
            this.base_ao[1] = this.ao[2][1];
            htvc2.__ao = this.brightness[2][1];
            this.base_ao[0] = this.ao[2][0];
            htvc2.__al = this.brightness[2][0];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, 3, n, n2, n3, 0.8f);
    }

    private void prepareFaceZPos(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[0] = this.ao[3][0];
            htvc2.__al = this.brightness[3][0];
            this.base_ao[3] = this.ao[3][3];
            htvc2.__am = this.brightness[3][3];
            this.base_ao[2] = this.ao[3][2];
            htvc2.__an = this.brightness[3][2];
            this.base_ao[1] = this.ao[3][1];
            htvc2.__ao = this.brightness[3][1];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, 5, n, n2, n3, 0.8f);
    }

    private void prepareFaceXNeg(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[3] = this.ao[4][3];
            htvc2.__am = this.brightness[4][3];
            this.base_ao[2] = this.ao[4][2];
            htvc2.__an = this.brightness[4][2];
            this.base_ao[1] = this.ao[4][1];
            htvc2.__ao = this.brightness[4][1];
            this.base_ao[0] = this.ao[4][0];
            htvc2.__al = this.brightness[4][0];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, 7, n, n2, n3, 0.6f);
    }

    private void prepareFaceXPos(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, Slope slope, int n, int n2, int n3) {
        if (htvc2._w) {
            this.base_ao[1] = this.ao[5][1];
            htvc2.__am = this.brightness[5][1];
            this.base_ao[0] = this.ao[5][0];
            htvc2.__al = this.brightness[5][0];
            this.base_ao[3] = this.ao[5][3];
            htvc2.__ao = this.brightness[5][3];
            this.base_ao[2] = this.ao[5][2];
            htvc2.__an = this.brightness[5][2];
        }
        this.prepareSlopeRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, 9, n, n2, n3, 0.6f);
    }

    @Override
    public boolean renderStandardSlopeWithColorMultiplier(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        htvc2._w = false;
        htvf htvf2 = htvc2.__aF;
        htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2, n3));
        this.isSideSloped = true;
        switch (NamelessClass493599135.$SwitchMap$carpentersblocks$data$Slope$SlopeType[slope.slopeType.ordinal()]) {
            case 1: {
                this.prepareHorizontalWedge(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 2: {
                this.prepareVerticalWedge(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 3: {
                this.prepareWedgeIntCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 4: {
                this.prepareWedgeExtCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 5: {
                this.prepareObliqueIntCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 6: {
                this.prepareObliqueExtCorner(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
                break;
            }
            case 7: {
                this.preparePyramid(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
            }
        }
        this.isSideSloped = false;
        if (slope.hasSide(ForgeDirection.DOWN) && twgu3.func_71877_c(htvc2._a, n, n2 - 1, n3, 0)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3));
            this.prepareFaceYNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.UP) && twgu3.func_71877_c(htvc2._a, n, n2 + 1, n3, 1)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3));
            this.prepareFaceYPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.NORTH) && twgu3.func_71877_c(htvc2._a, n, n2, n3 - 1, 2)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1));
            this.prepareFaceZNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.SOUTH) && twgu3.func_71877_c(htvc2._a, n, n2, n3 + 1, 3)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1));
            this.prepareFaceZPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.WEST) && twgu3.func_71877_c(htvc2._a, n - 1, n2, n3, 4)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n - 1, n2, n3));
            this.prepareFaceXNeg(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
        }
        if (slope.hasSide(ForgeDirection.EAST) && twgu3.func_71877_c(htvc2._a, n + 1, n2, n3, 5)) {
            htvf2.func_78380_c(twgu2.func_71874_e(htvc2._a, n + 1, n2, n3));
            this.prepareFaceXPos(tECarpentersBlock, htvc2, twgu2, twgu3, slope, n, n2, n3);
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

