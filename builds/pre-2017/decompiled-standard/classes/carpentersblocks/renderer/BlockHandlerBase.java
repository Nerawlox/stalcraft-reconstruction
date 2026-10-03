/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Slope;
import carpentersblocks.renderer.helper.RenderHelper;
import carpentersblocks.renderer.helper.RenderHelperWedge;
import carpentersblocks.renderer.helper.slope.HelperOblique;
import carpentersblocks.renderer.helper.slope.HelperPyramid;
import carpentersblocks.renderer.helper.slope.HelperWedge;
import carpentersblocks.renderer.helper.slope.HelperWedgeCorner;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.DyeColorHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.IconHandler;
import carpentersblocks.util.handler.OptifineHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mcoptifine.ConnectedTextures;
import mcoptifine.TextureUtils;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockHandlerBase
implements ISimpleBlockRenderingHandler {
    protected boolean isSideCover = false;
    protected boolean renderAlphaOverride;
    protected boolean hasMetadataOverride = false;
    protected boolean hasLightnessOffset = false;
    protected boolean hasDyeColorOverride = false;
    protected boolean suppressDyeColor = false;
    protected boolean suppressOverlay = false;
    protected boolean suppressPattern = false;
    protected boolean disableAO = false;
    protected boolean[] hasIconOverride;
    protected int coverRendering = 6;
    protected int metadataOverride = 0;
    protected int dyeColorOverride = 0;
    protected dwan[] iconOverride;
    protected float lightnessOffset = 0.0f;
    protected int slopeRenderID = 0;
    protected boolean isSideSloped = false;
    protected float[] base_ao;
    protected float[] base_RGB;
    protected RenderHelper renderHelper = new RenderHelper();
    protected RenderHelperWedge renderHelperWedge = new RenderHelperWedge();
    protected HelperWedgeCorner helperWedgeCorner = new HelperWedgeCorner();
    protected HelperWedge helperWedge = new HelperWedge();
    protected HelperOblique helperOblique = new HelperOblique();
    protected HelperPyramid helperPyramid = new HelperPyramid();
    private static float[] tempRGB = new float[3];
    protected static int[] tempRenderOffset = new int[3];

    public BlockHandlerBase() {
        this.renderAlphaOverride = FeatureHandler.enableZFightingFix;
        this.hasIconOverride = new boolean[6];
        this.iconOverride = new dwan[6];
        this.base_ao = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.base_RGB = new float[]{0.0f, 0.0f, 0.0f};
    }

    protected void setDirectionalRotation(TECarpentersBlock tECarpentersBlock, htvc htvc2, int n) {
        int n2 = BlockProperties.getCoverMetadata(tECarpentersBlock, this.coverRendering);
        int n3 = n2 & 0xC;
        switch (n) {
            case 0: {
                if (n2 != 3 && n3 != 4) break;
                htvc2._v = 1;
                break;
            }
            case 1: {
                if (n2 != 3 && n3 != 4) break;
                htvc2._u = 1;
                break;
            }
            case 2: {
                if (n2 != 3 && n3 != 4) break;
                htvc2._q = 1;
                break;
            }
            case 3: {
                if (n2 != 3 && n3 != 4) break;
                htvc2._r = 1;
                break;
            }
            case 4: {
                if (n2 != 4 && n3 != 8) break;
                htvc2._t = 1;
                break;
            }
            case 5: {
                if (n2 != 4 && n3 != 8) break;
                htvc2._s = 1;
            }
        }
    }

    protected void clearRotation(htvc htvc2, int n) {
        switch (n) {
            case 0: {
                htvc2._v = 0;
                break;
            }
            case 1: {
                htvc2._u = 0;
                break;
            }
            case 2: {
                htvc2._q = 0;
                break;
            }
            case 3: {
                htvc2._r = 0;
                break;
            }
            case 4: {
                htvc2._t = 0;
                break;
            }
            case 5: {
                htvc2._s = 0;
            }
        }
    }

    protected void setMetadataOverride(int n) {
        this.hasMetadataOverride = true;
        this.metadataOverride = n;
    }

    protected void clearMetadataOverride() {
        this.hasMetadataOverride = false;
    }

    protected void setIconOverride(int n, dwan dwan2) {
        if (n == 6) {
            for (int i = 0; i < 6; ++i) {
                this.hasIconOverride[i] = true;
                this.iconOverride[i] = dwan2;
            }
        } else {
            this.hasIconOverride[n] = true;
            this.iconOverride[n] = dwan2;
        }
    }

    protected void clearIconOverride(int n) {
        if (n == 6) {
            for (int i = 0; i < 6; ++i) {
                this.hasIconOverride[i] = false;
            }
        } else {
            this.hasIconOverride[n] = false;
        }
    }

    protected void setDyeColorOverride(int n) {
        this.hasDyeColorOverride = true;
        this.dyeColorOverride = n;
    }

    protected void clearDyeColorOverride() {
        this.hasDyeColorOverride = false;
    }

    protected void setLightnessOffset(float f) {
        this.hasLightnessOffset = true;
        this.lightnessOffset = f;
    }

    protected void clearLightnessOffset() {
        this.hasLightnessOffset = false;
    }

    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = MinecraftForgeClient.getRenderPass();
        boolean bl = false;
        bl |= this.renderCarpentersBlock(tECarpentersBlock, htvc2, twgu2, n5, n, n2, n3);
        bl |= this.renderSideCovers(tECarpentersBlock, htvc2, twgu2, n5, n, n2, n3);
        if (n5 >= 0 && FeatureHandler.enableFancyFluids && xpzm._B() && BlockProperties.hasCover(tECarpentersBlock, 6)) {
            bl |= this.renderFancyFluids(tECarpentersBlock, htvc2, n, n2, n3, n5);
        }
        return bl;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return 0;
    }

    protected boolean shouldRenderBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n) {
        return this.renderAlphaOverride ? n == 1 : htvc2._b() || twgu2.canRenderInPass(n) || twgu2 instanceof BlockBase && n == 0 || this.hasAccessories(twgu3);
    }

    private boolean hasAccessories(twgu twgu2) {
        return twgu2 == BlockHandler.blockCarpentersDoor || twgu2 == BlockHandler.blockCarpentersHatch;
    }

    protected boolean shouldRenderOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        if (!this.suppressOverlay) {
            twgu twgu2 = BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering);
            if (BlockProperties.hasOverlay(tECarpentersBlock, this.coverRendering) || twgu2 == twgu.field_71980_u) {
                int n2 = twgu2.func_71856_s_();
                if (this.renderAlphaOverride) {
                    return n == 1;
                }
                if (twgu2 instanceof BlockBase) {
                    return true;
                }
                if (n2 == 1) {
                    return true;
                }
                if (this.shouldRenderPattern(tECarpentersBlock, n)) {
                    return n == 1;
                }
                return n2 == n;
            }
        }
        return false;
    }

    protected boolean shouldRenderPattern(TECarpentersBlock tECarpentersBlock, int n) {
        return !this.suppressPattern && n == 1 && BlockProperties.hasPattern(tECarpentersBlock, this.coverRendering);
    }

    private boolean renderFancyFluids(TECarpentersBlock tECarpentersBlock, htvc htvc2, int n, int n2, int n3, int n4) {
        if (FeatureHandler.enableFancyFluids) {
            int n5;
            boolean bl;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            twgu twgu2;
            twgu twgu3 = !htvc2._a.func_72799_c(n - 1, n2, n3) ? twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3)] : null;
            twgu twgu4 = !htvc2._a.func_72799_c(n + 1, n2, n3) ? twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3)] : null;
            twgu twgu5 = !htvc2._a.func_72799_c(n, n2, n3 - 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n, n2, n3 - 1)] : null;
            twgu twgu6 = !htvc2._a.func_72799_c(n, n2, n3 + 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n, n2, n3 + 1)] : null;
            twgu twgu7 = !htvc2._a.func_72799_c(n - 1, n2, n3 + 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3 + 1)] : null;
            twgu twgu8 = !htvc2._a.func_72799_c(n + 1, n2, n3 + 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3 + 1)] : null;
            twgu twgu9 = !htvc2._a.func_72799_c(n - 1, n2, n3 - 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3 - 1)] : null;
            twgu twgu10 = twgu2 = !htvc2._a.func_72799_c(n + 1, n2, n3 - 1) ? twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3 - 1)] : null;
            boolean bl8 = twgu3 != null ? twgu3 instanceof IFluidBlock || twgu3 instanceof ogyy : (bl7 = false);
            boolean bl9 = twgu4 != null ? twgu4 instanceof IFluidBlock || twgu4 instanceof ogyy : (bl6 = false);
            boolean bl10 = twgu5 != null ? twgu5 instanceof IFluidBlock || twgu5 instanceof ogyy : (bl5 = false);
            boolean bl11 = twgu6 != null ? twgu6 instanceof IFluidBlock || twgu6 instanceof ogyy : (bl4 = false);
            boolean bl12 = twgu7 != null ? twgu7 instanceof IFluidBlock || twgu7 instanceof ogyy : (bl3 = false);
            boolean bl13 = twgu8 != null ? twgu8 instanceof IFluidBlock || twgu8 instanceof ogyy : (bl2 = false);
            boolean bl14 = twgu9 != null ? twgu9 instanceof IFluidBlock || twgu9 instanceof ogyy : (bl = false);
            boolean bl15 = twgu2 != null ? twgu2 instanceof IFluidBlock || twgu2 instanceof ogyy : false;
            boolean bl16 = htvc2._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.WEST, true);
            boolean bl17 = htvc2._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.EAST, true);
            boolean bl18 = htvc2._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.NORTH, true);
            boolean bl19 = htvc2._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.SOUTH, true);
            int n6 = 0;
            int n7 = 0;
            twgu twgu11 = null;
            twgu twgu12 = null;
            block16: for (n5 = 2; n5 < 10 && twgu11 == null; ++n5) {
                switch (n5) {
                    case 2: {
                        if (!bl5 || bl18) continue block16;
                        twgu11 = twgu.field_71973_m[htvc2._a.func_72798_a(n, n2, n3 - 1)];
                        if (n6 >= htvc2._a.func_72805_g(n, n2, n3 - 1)) continue block16;
                        n6 = htvc2._a.func_72805_g(n, n2, n3 - 1);
                        continue block16;
                    }
                    case 3: {
                        if (!bl4 || bl19) continue block16;
                        twgu11 = twgu.field_71973_m[htvc2._a.func_72798_a(n, n2, n3 + 1)];
                        if (n6 >= htvc2._a.func_72805_g(n, n2, n3 + 1)) continue block16;
                        n6 = htvc2._a.func_72805_g(n, n2, n3 + 1);
                        continue block16;
                    }
                    case 4: {
                        if (!bl7 || bl16) continue block16;
                        twgu11 = twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3)];
                        if (n6 >= htvc2._a.func_72805_g(n - 1, n2, n3)) continue block16;
                        n6 = htvc2._a.func_72805_g(n - 1, n2, n3);
                        continue block16;
                    }
                    case 5: {
                        if (!bl6 || bl17) continue block16;
                        twgu11 = twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3)];
                        if (n6 >= htvc2._a.func_72805_g(n + 1, n2, n3)) continue block16;
                        n6 = htvc2._a.func_72805_g(n + 1, n2, n3);
                        continue block16;
                    }
                    case 6: {
                        if (!bl15) continue block16;
                        twgu12 = twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3 - 1)];
                        if (n7 >= htvc2._a.func_72805_g(n + 1, n2, n3 - 1)) continue block16;
                        n7 = htvc2._a.func_72805_g(n + 1, n2, n3 - 1);
                        continue block16;
                    }
                    case 7: {
                        if (!bl2) continue block16;
                        twgu12 = twgu.field_71973_m[htvc2._a.func_72798_a(n + 1, n2, n3 + 1)];
                        if (n7 >= htvc2._a.func_72805_g(n + 1, n2, n3 + 1)) continue block16;
                        n7 = htvc2._a.func_72805_g(n + 1, n2, n3 + 1);
                        continue block16;
                    }
                    case 8: {
                        if (!bl) continue block16;
                        twgu12 = twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3 - 1)];
                        if (n7 >= htvc2._a.func_72805_g(n - 1, n2, n3 - 1)) continue block16;
                        n7 = htvc2._a.func_72805_g(n - 1, n2, n3 - 1);
                        continue block16;
                    }
                    case 9: {
                        if (!bl3) continue block16;
                        twgu12 = twgu.field_71973_m[htvc2._a.func_72798_a(n - 1, n2, n3 + 1)];
                        if (n7 >= htvc2._a.func_72805_g(n - 1, n2, n3 + 1)) continue block16;
                        n7 = htvc2._a.func_72805_g(n - 1, n2, n3 + 1);
                    }
                }
            }
            if (twgu11 != null && n4 == twgu11.func_71856_s_() || twgu12 != null && n4 == twgu12.func_71856_s_()) {
                n5 = 0;
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 1.0f;
                float f4 = 1.0f;
                float f5 = 0.01f;
                block17: for (int i = 2; i < 6; ++i) {
                    switch (i) {
                        case 2: {
                            if (bl19 || !bl4 && (htvc2._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) || (!bl3 || htvc2._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.WEST, true)) && (!bl2 || htvc2._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.EAST, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 3: {
                            if (bl18 || !bl5 && (htvc2._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) || (!bl || htvc2._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.WEST, true)) && (!bl15 || htvc2._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.EAST, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 4: {
                            if (bl17 || !bl6 && (htvc2._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) || (!bl2 || htvc2._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.SOUTH, true)) && (!bl15 || htvc2._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.NORTH, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 5: {
                            if (bl16 || !bl7 && (htvc2._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) || (!bl3 || htvc2._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.SOUTH, true)) && (!bl || htvc2._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.NORTH, true)))) continue block17;
                            n5 = 1;
                        }
                    }
                }
                if (n5 != 0) {
                    if (bl16) {
                        f += f5;
                    }
                    if (bl17) {
                        f3 -= f5;
                    }
                    if (bl19) {
                        f4 -= f5;
                    }
                    if (bl18) {
                        f2 += f5;
                    }
                    if (twgu11 == null) {
                        twgu11 = twgu12;
                        n6 = n7;
                    }
                    if (!twgu11.hasTileEntity(n6) && n6 == 0) {
                        double d = (twgu11 instanceof ogyy ? 0.8888888880610466 : 0.875) - (double)0.001f;
                        htvc2._a(f, f5, (double)f2, (double)f3, d, (double)f4);
                        float[] fArray = this.writeRGB(tempRGB, htvc2._a, twgu11, n, n2, n3);
                        return htvc2._c(twgu11, n, n2, n3, fArray[0], fArray[1], fArray[2]);
                    }
                }
            }
        }
        return false;
    }

    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering);
        if (twgu3 != null) {
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
        }
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    protected int[] setSideCoverRenderBounds(int[] nArray, TECarpentersBlock tECarpentersBlock, htvc htvc2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5;
        double d = 0.0625;
        if (n4 == 1 && ((n5 = BlockProperties.getCoverID(tECarpentersBlock, n4)) == twgu.field_72039_aU.field_71990_ca || n5 == twgu.field_72037_aS.field_71990_ca)) {
            d = 0.125;
        }
        switch (n4) {
            case 0: {
                if (htvc2._j > 0.0) {
                    htvc2._k = htvc2._j;
                    htvc2._j -= d;
                    break;
                }
                htvc2._k = 1.0;
                htvc2._j = htvc2._k - d;
                --n2;
                break;
            }
            case 1: {
                if (htvc2._k < 1.0) {
                    htvc2._j = htvc2._k;
                    htvc2._k += d;
                    break;
                }
                htvc2._k = d;
                htvc2._j = 0.0;
                ++n2;
                break;
            }
            case 2: {
                if (htvc2._l > 0.0) {
                    htvc2._m = htvc2._l;
                    htvc2._l -= d;
                    break;
                }
                htvc2._m = 1.0;
                htvc2._l = htvc2._m - d;
                --n3;
                break;
            }
            case 3: {
                if (htvc2._m < 1.0) {
                    htvc2._l = htvc2._m;
                    htvc2._m += d;
                    break;
                }
                htvc2._m = d;
                htvc2._l = 0.0;
                ++n3;
                break;
            }
            case 4: {
                if (htvc2._h > 0.0) {
                    htvc2._i = htvc2._h;
                    htvc2._h -= d;
                    break;
                }
                htvc2._i = 1.0;
                htvc2._h = htvc2._i - d;
                --n;
                break;
            }
            case 5: {
                if (htvc2._i < 1.0) {
                    htvc2._h = htvc2._i;
                    htvc2._i += d;
                    break;
                }
                htvc2._i = d;
                htvc2._h = 0.0;
                ++n;
            }
        }
        float f = 0.001f;
        boolean bl2 = bl = n4 == 0 || n4 == 1;
        if (!bl) {
            htvc2._j -= (double)f;
            htvc2._k += (double)f;
        }
        if (n4 == 4 || n4 == 5 || bl) {
            htvc2._l -= (double)f;
            htvc2._m += (double)f;
        }
        if (n4 == 2 || n4 == 3 || bl) {
            htvc2._h -= (double)f;
            htvc2._i += (double)f;
        }
        nArray[0] = n;
        nArray[1] = n2;
        nArray[2] = n3;
        return nArray;
    }

    protected boolean renderSideCovers(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        boolean bl = false;
        this.isSideCover = true;
        htvc2._d = true;
        twgu2.func_71902_a(htvc2._a, n2, n3, n4);
        for (int i = 0; i < 6; ++i) {
            if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
            twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, i);
            this.coverRendering = i;
            if (!this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n) && !this.shouldRenderPattern(tECarpentersBlock, n)) continue;
            int[] nArray = this.setSideCoverRenderBounds(tempRenderOffset, tECarpentersBlock, htvc2, n2, n3, n4, i);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, nArray[0], nArray[1], nArray[2]);
            htvc2._a(twgu2);
            bl = true;
        }
        htvc2._d = false;
        this.coverRendering = 6;
        this.isSideCover = false;
        return bl;
    }

    protected void aoMultiplyByColor(htvc htvc2, float f, float f2, float f3) {
        htvc2.__ap *= f;
        htvc2.__at *= f2;
        htvc2.__ax *= f3;
        htvc2.__as *= f;
        htvc2.__aw *= f2;
        htvc2.__aA *= f3;
        htvc2.__ar *= f;
        htvc2.__av *= f2;
        htvc2.__az *= f3;
        htvc2.__aq *= f;
        htvc2.__au *= f2;
        htvc2.__ay *= f3;
    }

    protected void aoSetColor(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, float f, float f2, float f3, float f4) {
        htvc2.__ar = htvc2.__as = f * f4;
        htvc2.__aq = htvc2.__as;
        htvc2.__ap = htvc2.__as;
        htvc2.__av = htvc2.__aw = f2 * f4;
        htvc2.__au = htvc2.__aw;
        htvc2.__at = htvc2.__aw;
        htvc2.__az = htvc2.__aA = f3 * f4;
        htvc2.__ay = htvc2.__aA;
        htvc2.__ax = htvc2.__aA;
        htvc2.__ap *= this.base_ao[0];
        htvc2.__at *= this.base_ao[0];
        htvc2.__ax *= this.base_ao[0];
        htvc2.__as *= this.base_ao[1];
        htvc2.__aw *= this.base_ao[1];
        htvc2.__aA *= this.base_ao[1];
        htvc2.__ar *= this.base_ao[2];
        htvc2.__av *= this.base_ao[2];
        htvc2.__az *= this.base_ao[2];
        htvc2.__aq *= this.base_ao[3];
        htvc2.__au *= this.base_ao[3];
        htvc2.__ay *= this.base_ao[3];
    }

    protected void aoResetColor(htvc htvc2) {
        htvc2.__ap = this.base_ao[0];
        htvc2.__at = this.base_ao[0];
        htvc2.__ax = this.base_ao[0];
        htvc2.__as = this.base_ao[1];
        htvc2.__aw = this.base_ao[1];
        htvc2.__aA = this.base_ao[1];
        htvc2.__ar = this.base_ao[2];
        htvc2.__av = this.base_ao[2];
        htvc2.__az = this.base_ao[2];
        htvc2.__aq = this.base_ao[3];
        htvc2.__au = this.base_ao[3];
        htvc2.__ay = this.base_ao[3];
    }

    protected dwan getIcon(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = this.hasMetadataOverride ? this.metadataOverride : BlockProperties.getCoverMetadata(tECarpentersBlock, this.coverRendering);
        dwan dwan2 = twgu2.func_71858_a(n, n6);
        if (twgu3 == BlockHandler.blockCarpentersDaylightSensor) {
            dwan2 = twgu3.func_71895_b(htvc2._a, n2, n3, n4, n);
        }
        if (twgu2 == BlockHandler.blockCarpentersLever) {
            dwan2 = IconHandler.icon_generic;
        }
        if (this.isSideSloped) {
            Slope slope = Slope.slopesList[n5];
            if (!BlockProperties.hasCover(tECarpentersBlock, 6)) {
                if (slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_INT)) {
                    dwan2 = slope.isPositive ? IconHandler.icon_slope_oblique_pt_low : IconHandler.icon_slope_oblique_pt_high;
                } else if (slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) {
                    dwan dwan3 = dwan2 = slope.isPositive ? IconHandler.icon_slope_oblique_pt_high : IconHandler.icon_slope_oblique_pt_low;
                }
            }
            if (BlockProperties.blockRotates(tECarpentersBlock.field_70331_k, twgu2, n2, n3, n4)) {
                dwan2 = n6 % 8 == 0 ? twgu2.func_71858_a(slope.isPositive ? 1 : 0, n6) : twgu2.func_71858_a(2, n6);
            } else if (twgu2 instanceof gqau && !slope.slopeType.equals((Object)Slope.SlopeType.WEDGE_Y)) {
                dwan2 = twgu2.func_71851_a(1);
            }
        }
        if (this.hasIconOverride[n] && this.iconOverride[n] != null) {
            dwan2 = this.iconOverride[n];
        }
        return dwan2;
    }

    protected void renderMultiTexturedSide(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4, float f, dwan dwan2) {
        int n5;
        int n6;
        dwan dwan3 = dwan2;
        if (twgu2 == twgu.field_71980_u && n != 0) {
            dwan2 = this.getGrassOverlayIcon(tECarpentersBlock, 1);
        }
        if (twgu2 == twgu.field_71994_by && n != 0) {
            dwan2 = TextureUtils.iconMyceliumTop;
        }
        if ((n6 = tECarpentersBlock.field_70331_k.func_72805_g(n2, n3, n4) >> 2) == 3) {
            n6 = 1;
        } else if (n6 == 1) {
            n6 = 3;
        }
        int n7 = n6;
        switch (n6) {
            case 0: {
                n7 = ForgeDirection.SOUTH.ordinal();
                break;
            }
            case 1: {
                n7 = ForgeDirection.EAST.ordinal();
                break;
            }
            case 2: {
                n7 = ForgeDirection.NORTH.ordinal();
                break;
            }
            case 3: {
                n7 = ForgeDirection.WEST.ordinal();
            }
        }
        int n8 = n;
        if (n == n7 || n == 1) {
            n8 = 1;
        }
        switch (n6) {
            case 0: {
                htvc2._r = n6;
                break;
            }
            case 1: {
                htvc2._s = n6;
                break;
            }
            case 2: {
                htvc2._q = n6;
                break;
            }
            case 3: {
                htvc2._t = n6;
            }
        }
        dwan2 = ConnectedTextures.getConnectedTexture(tECarpentersBlock.field_70331_k, twgu2, n2, n3, n4, n8, dwan2);
        if (dwan2 == null) {
            dwan2 = dwan3;
        }
        if (this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n5 = MinecraftForgeClient.getRenderPass())) {
            if (BlockProperties.blockRotates(tECarpentersBlock.field_70331_k, twgu2, n2, n3, n4)) {
                this.setDirectionalRotation(tECarpentersBlock, htvc2, n);
            }
            this.colorSide(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, n4, dwan2, f);
            this.renderSide(tECarpentersBlock, htvc2, n, 0.0, n2, n3, n4, dwan2);
            this.clearRotation(htvc2, n);
        }
        htvc2._r = 0;
        htvc2._s = 0;
        htvc2._q = 0;
        htvc2._t = 0;
        htvc2._u = 0;
        htvc2._v = 0;
        if (twgu3 != BlockHandler.blockCarpentersDaylightSensor || n != 1) {
            this.suppressDyeColor = true;
            if (this.shouldRenderPattern(tECarpentersBlock, n5)) {
                this.renderPattern(tECarpentersBlock, htvc2, twgu3, n, n2, n3, n4, f);
            }
            if (this.shouldRenderOverlay(tECarpentersBlock, n5) && twgu2 != twgu.field_71980_u && twgu2 != twgu.field_71994_by) {
                this.renderOverlay(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, n4, f, dwan2);
            }
            this.suppressDyeColor = false;
        }
    }

    protected void prepareRender(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4, float f) {
        dwan dwan2 = this.getIcon(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, n4);
        if (!htvc2._w) {
            this.base_RGB = new float[]{f, f, f};
        }
        if (htvc2._b()) {
            this.renderSide(tECarpentersBlock, htvc2, n, 0.0, n2, n3, n4, htvc2._b);
        } else {
            this.renderMultiTexturedSide(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, n4, f, dwan2);
        }
    }

    protected void colorSide(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4, dwan dwan2, float f) {
        htvf htvf2 = htvc2.__aF;
        float[] fArray = this.writeRGB(tempRGB, htvc2._a, twgu2, n2, n3, n4);
        float[] fArray2 = this.hasDyeColorOverride ? DyeColorHandler.getDyeColorRGB(this.suppressDyeColor ? 0 : this.dyeColorOverride) : DyeColorHandler.getDyeColorRGB(this.suppressDyeColor ? 0 : BlockProperties.getDyeColor(tECarpentersBlock, this.coverRendering));
        if (this.hasLightnessOffset) {
            if (htvc2._w) {
                f += this.lightnessOffset;
            } else {
                this.base_RGB[0] = this.base_RGB[0] + this.lightnessOffset;
                this.base_RGB[1] = this.base_RGB[1] + this.lightnessOffset;
                this.base_RGB[2] = this.base_RGB[2] + this.lightnessOffset;
            }
        }
        if (htvc2._w) {
            this.aoResetColor(htvc2);
            if (this.useColorComponent(tECarpentersBlock, twgu2, twgu3, n, dwan2)) {
                this.aoSetColor(tECarpentersBlock, htvc2, twgu2, n, fArray[0] * fArray2[0], fArray[1] * fArray2[1], fArray[2] * fArray2[2], f);
            } else {
                this.aoSetColor(tECarpentersBlock, htvc2, twgu2, n, fArray2[0], fArray2[1], fArray2[2], f);
            }
        } else if (this.useColorComponent(tECarpentersBlock, twgu2, twgu3, n, dwan2)) {
            htvf2.func_78386_a(this.base_RGB[0] * fArray[0] * fArray2[0], this.base_RGB[1] * fArray[1] * fArray2[1], this.base_RGB[2] * fArray[2] * fArray2[2]);
        } else {
            htvf2.func_78386_a(this.base_RGB[0] * fArray2[0], this.base_RGB[1] * fArray2[1], this.base_RGB[2] * fArray2[2]);
        }
    }

    protected boolean useColorComponent(TECarpentersBlock tECarpentersBlock, twgu twgu2, twgu twgu3, int n, dwan dwan2) {
        boolean bl;
        if (twgu2 == twgu.field_71980_u && n != 0) {
            return true;
        }
        if (twgu2 != twgu.field_71980_u && BlockProperties.getOverlay(tECarpentersBlock, n) != 1) {
            return true;
        }
        boolean bl2 = bl = this.isSideSloped ? Slope.slopesList[BlockProperties.getData((TECarpentersBlock)tECarpentersBlock)].isPositive : false;
        return n != 1 && dwan2 != jzmk._a() && !bl ? false : (twgu3 == BlockHandler.blockCarpentersDaylightSensor ? n != 1 : true);
    }

    protected void renderOverlay(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4, float f, dwan dwan2) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = BlockProperties.getOverlay(tECarpentersBlock, this.coverRendering);
        if (this.isSideSloped) {
            Slope slope = Slope.slopesList[BlockProperties.getData(tECarpentersBlock)];
            if (slope.isPositive) {
                n = 1;
            } else if (slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_INT) || slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT) || slope.slopeType.equals((Object)Slope.SlopeType.PYRAMID)) {
                n = 2;
            }
        }
        if (twgu2 == twgu.field_71980_u) {
            dwan2 = this.getGrassOverlayIcon(tECarpentersBlock, n);
            if (n == ForgeDirection.UP.ordinal()) {
                dwan2 = ConnectedTextures.getConnectedTexture(tECarpentersBlock.field_70331_k, twgu2, n2, n3, n4, n, dwan2);
            }
            if (dwan2 == null) {
                return;
            }
            this.colorSide(tECarpentersBlock, htvc2, twgu.field_71980_u, twgu3, n, n2, n3, n4, dwan2, f);
            if (n6 != 0) {
                this.renderSide(tECarpentersBlock, htvc2, n, 0.0, n2, n3, n4, dwan2);
            }
        }
        switch (n6) {
            case 1: {
                if (twgu2 == twgu.field_71980_u) break;
                dwan2 = this.getGrassOverlayIcon(tECarpentersBlock, n);
                if (dwan2 == null) {
                    return;
                }
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_71980_u, twgu3, n, n2, n3, n4, dwan2, f);
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        dwan2 = twgu.field_72037_aS.func_71851_a(1);
                        break;
                    }
                    default: {
                        dwan2 = IconHandler.icon_overlay_snow_side;
                    }
                }
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_72039_aU, twgu3, n, n2, n3, n4, dwan2, f);
                break;
            }
            case 3: {
                dwan2 = twgu.field_71955_W.func_71851_a(n);
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_71955_W, twgu3, n, n2, n3, n4, dwan2, f);
                break;
            }
            case 4: {
                dwan2 = twgu.field_71998_bu.func_71851_a(n);
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_71998_bu, twgu3, n, n2, n3, n4, dwan2, f);
                break;
            }
            case 5: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        dwan2 = twgu.field_111038_cB.func_71851_a(1);
                        break;
                    }
                    default: {
                        dwan2 = IconHandler.icon_overlay_hay_side;
                    }
                }
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_111038_cB, twgu3, n, n2, n3, n4, dwan2, f);
                break;
            }
            case 6: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        dwan2 = twgu.field_71994_by.func_71851_a(1);
                        break;
                    }
                    default: {
                        dwan2 = IconHandler.icon_overlay_mycelium_side;
                    }
                }
                this.colorSide(tECarpentersBlock, htvc2, twgu.field_71994_by, twgu3, n, n2, n3, n4, dwan2, f);
            }
        }
        this.renderSide(tECarpentersBlock, htvc2, n, 0.0, n2, n3, n4, dwan2);
    }

    protected dwan getGrassOverlayIcon(TECarpentersBlock tECarpentersBlock, int n) {
        boolean bl;
        boolean bl2 = bl = this.isSideSloped ? Slope.slopesList[BlockProperties.getData((TECarpentersBlock)tECarpentersBlock)].isPositive : false;
        return n != 1 && !bl ? (n > 1 ? (htvc._e ? jzmk._a() : IconHandler.icon_overlay_fast_grass_side) : null) : twgu.field_71980_u.func_71851_a(1);
    }

    protected void renderPattern(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4, float f) {
        int n5 = BlockProperties.getPattern(tECarpentersBlock, this.coverRendering);
        dwan dwan2 = IconHandler.icon_pattern[n5];
        if (dwan2 == null) {
            return;
        }
        this.colorSide(tECarpentersBlock, htvc2, twgu.field_71946_M, twgu2, n, n2, n3, n4, dwan2, f);
        this.renderSide(tECarpentersBlock, htvc2, n, 0.0, n2, n3, n4, dwan2);
    }

    protected void renderSide(TECarpentersBlock tECarpentersBlock, htvc htvc2, int n, double d, int n2, int n3, int n4, dwan dwan2) {
        if (d != 0.0) {
            htvc2.__aE.setOffset(d);
        }
        switch (n) {
            case 0: {
                this.renderHelper.renderFaceYNeg(htvc2, n2, n3, n4, dwan2);
                break;
            }
            case 1: {
                this.renderHelper.renderFaceYPos(htvc2, n2, n3, n4, dwan2);
                break;
            }
            case 2: {
                this.renderHelper.renderFaceZNeg(htvc2, n2, n3, n4, dwan2);
                break;
            }
            case 3: {
                this.renderHelper.renderFaceZPos(htvc2, n2, n3, n4, dwan2);
                break;
            }
            case 4: {
                this.renderHelper.renderFaceXNeg(htvc2, n2, n3, n4, dwan2);
                break;
            }
            case 5: {
                this.renderHelper.renderFaceXPos(htvc2, n2, n3, n4, dwan2);
            }
        }
        htvc2.__aE.clearOffset();
    }

    protected float[] writeRGB(float[] fArray, sdrg sdrg2, twgu twgu2, int n, int n2, int n3) {
        int n4 = FeatureHandler.enableOptifineIntegration ? OptifineHandler.getColorMultiplier(twgu2, sdrg2, n, n2, n3) : twgu2.func_71920_b(sdrg2, n, n2, n3);
        fArray[0] = (float)(n4 >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n4 >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            fArray[0] = (fArray[0] * 30.0f + fArray[1] * 59.0f + fArray[2] * 11.0f) / 100.0f;
            fArray[1] = (fArray[0] * 30.0f + fArray[1] * 70.0f) / 100.0f;
            fArray[2] = (fArray[0] * 30.0f + fArray[2] * 70.0f) / 100.0f;
        }
        return fArray;
    }

    protected boolean renderStandardBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        if (twgu2 == null) {
            return true;
        }
        float[] fArray = this.writeRGB(tempRGB, htvc2._a, twgu2, n, n2, n3);
        if (twgu3 == BlockHandler.blockCarpentersSlope && !this.isSideCover) {
            if (xpzm._C() && twgu.field_71984_q[twgu2.field_71990_ca] == 0) {
                this.renderStandardSlopeWithAmbientOcclusion(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, fArray[0], fArray[1], fArray[2]);
            } else {
                this.renderStandardSlopeWithColorMultiplier(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, fArray[0], fArray[1], fArray[2]);
            }
        } else if (xpzm._C() && !this.disableAO && twgu.field_71984_q[twgu2.field_71990_ca] == 0) {
            this.renderStandardBlockWithAmbientOcclusion(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, fArray[0], fArray[1], fArray[2]);
        } else {
            this.renderStandardBlockWithColorMultiplier(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3, fArray[0], fArray[1], fArray[2]);
        }
        return true;
    }

    protected boolean renderStandardSlopeWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        return false;
    }

    protected boolean renderStandardSlopeWithColorMultiplier(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        return false;
    }

    protected boolean renderStandardBlockWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        htvc2._w = true;
        boolean bl = false;
        htvc2.__aF.func_78380_c(983055);
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2 - 1, n3, 0) || htvc2._j > 0.0) {
            this.setLightnessYNeg(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, n, n2, n3, 0.5f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2 + 1, n3, 1) || htvc2._k < 1.0) {
            this.setLightnessYPos(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, n, n2, n3, 1.0f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2, n3 - 1, 2) || htvc2._l > 0.0) {
            this.setLightnessZNeg(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, n, n2, n3, 0.8f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2, n3 + 1, 3) || htvc2._m < 1.0) {
            this.setLightnessZPos(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, n, n2, n3, 0.8f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n - 1, n2, n3, 4) || htvc2._h > 0.0) {
            this.setLightnessXNeg(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, n, n2, n3, 0.6f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n + 1, n2, n3, 5) || htvc2._i < 1.0) {
            this.setLightnessXPos(htvc2, twgu2, n, n2, n3);
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, n, n2, n3, 0.6f);
            bl = true;
        }
        if (this.base_ao[0] > 0.0f) {
            htvc2._w = false;
        }
        return bl;
    }

    protected void setLightnessYNeg(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._j >= 0.0 && htvc2._j <= 0.5;
        boolean bl2 = htvc2._o;
        htvc2._S = twgu2.func_71874_e(htvc2._a, n - 1, n2 -= bl ? 1 : 0, n3);
        htvc2._U = twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1);
        htvc2._V = twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1);
        htvc2._X = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3);
        htvc2._y = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3);
        htvc2._A = twgu2.func_71888_h(htvc2._a, n, n2, n3 - 1);
        htvc2._B = twgu2.func_71888_h(htvc2._a, n, n2, n3 + 1);
        htvc2._D = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2 - 1, n3)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2 - 1, n3)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 - 1, n3 + 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 - 1, n3 - 1)];
        if (!bl6 && !bl4) {
            htvc2._x = htvc2._y;
            htvc2._R = htvc2._S;
        } else {
            htvc2._x = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 - 1);
            htvc2._R = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3 - 1);
        }
        if (!bl5 && !bl4) {
            htvc2._z = htvc2._y;
            htvc2._T = htvc2._S;
        } else {
            htvc2._z = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 + 1);
            htvc2._T = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3 + 1);
        }
        if (!bl6 && !bl3) {
            htvc2._C = htvc2._D;
            htvc2._W = htvc2._X;
        } else {
            htvc2._C = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3 - 1);
            htvc2._W = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3 - 1);
        }
        if (!bl5 && !bl3) {
            htvc2._E = htvc2._D;
            htvc2._Y = htvc2._X;
        } else {
            htvc2._E = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3 + 1);
            htvc2._Y = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3 + 1);
        }
        int n5 = n4;
        if (htvc2._j <= 0.0 || !htvc2._a.func_72804_r(n, (n2 += bl ? 1 : 0) - 1, n3)) {
            n5 = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3);
        }
        float f = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3);
        if (bl2) {
            float f2 = (htvc2._z + htvc2._y + htvc2._B + f) / 4.0f;
            float f3 = (htvc2._B + f + htvc2._E + htvc2._D) / 4.0f;
            float f4 = (f + htvc2._A + htvc2._D + htvc2._C) / 4.0f;
            float f5 = (htvc2._y + htvc2._x + f + htvc2._A) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * htvc2._m * (1.0 - htvc2._h) + (double)f3 * htvc2._m * htvc2._h + (double)f4 * (1.0 - htvc2._m) * htvc2._h + (double)f5 * (1.0 - htvc2._m) * (1.0 - htvc2._h));
            this.base_ao[1] = (float)((double)f2 * htvc2._m * (1.0 - htvc2._i) + (double)f3 * htvc2._m * htvc2._i + (double)f4 * (1.0 - htvc2._m) * htvc2._i + (double)f5 * (1.0 - htvc2._m) * (1.0 - htvc2._i));
            this.base_ao[2] = (float)((double)f2 * htvc2._l * (1.0 - htvc2._i) + (double)f3 * htvc2._l * htvc2._i + (double)f4 * (1.0 - htvc2._l) * htvc2._i + (double)f5 * (1.0 - htvc2._l) * (1.0 - htvc2._i));
            this.base_ao[3] = (float)((double)f2 * htvc2._l * (1.0 - htvc2._h) + (double)f3 * htvc2._l * htvc2._h + (double)f4 * (1.0 - htvc2._l) * htvc2._h + (double)f5 * (1.0 - htvc2._l) * (1.0 - htvc2._h));
            int n6 = htvc2._a(htvc2._T, htvc2._S, htvc2._V, n5);
            int n7 = htvc2._a(htvc2._V, htvc2._Y, htvc2._X, n5);
            int n8 = htvc2._a(htvc2._U, htvc2._X, htvc2._W, n5);
            int n9 = htvc2._a(htvc2._S, htvc2._R, htvc2._U, n5);
            htvc2.__al = htvc2._a(n6, n9, n8, n7, htvc2._m * (1.0 - htvc2._h), htvc2._m * htvc2._h, (1.0 - htvc2._m) * htvc2._h, (1.0 - htvc2._m) * (1.0 - htvc2._h));
            htvc2.__am = htvc2._a(n6, n9, n8, n7, htvc2._m * (1.0 - htvc2._i), htvc2._m * htvc2._i, (1.0 - htvc2._m) * htvc2._i, (1.0 - htvc2._m) * (1.0 - htvc2._i));
            htvc2.__an = htvc2._a(n6, n9, n8, n7, htvc2._l * (1.0 - htvc2._i), htvc2._l * htvc2._i, (1.0 - htvc2._l) * htvc2._i, (1.0 - htvc2._l) * (1.0 - htvc2._i));
            htvc2.__ao = htvc2._a(n6, n9, n8, n7, htvc2._l * (1.0 - htvc2._h), htvc2._l * htvc2._h, (1.0 - htvc2._l) * htvc2._h, (1.0 - htvc2._l) * (1.0 - htvc2._h));
        } else {
            this.base_ao[0] = (htvc2._z + htvc2._y + htvc2._B + f) / 4.0f;
            this.base_ao[1] = (htvc2._B + f + htvc2._E + htvc2._D) / 4.0f;
            this.base_ao[2] = (f + htvc2._A + htvc2._D + htvc2._C) / 4.0f;
            this.base_ao[3] = (htvc2._y + htvc2._x + f + htvc2._A) / 4.0f;
            htvc2.__al = htvc2._a(htvc2._T, htvc2._S, htvc2._V, n5);
            htvc2.__ao = htvc2._a(htvc2._V, htvc2._Y, htvc2._X, n5);
            htvc2.__an = htvc2._a(htvc2._U, htvc2._X, htvc2._W, n5);
            htvc2.__am = htvc2._a(htvc2._S, htvc2._R, htvc2._U, n5);
        }
    }

    protected void setLightnessYPos(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._k <= 1.0 && htvc2._k > 0.5;
        boolean bl2 = htvc2._o;
        htvc2.__aa = twgu2.func_71874_e(htvc2._a, n - 1, n2 += bl ? 1 : 0, n3);
        htvc2.__ae = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3);
        htvc2.__ac = twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1);
        htvc2.__af = twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1);
        htvc2._G = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3);
        htvc2._K = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3);
        htvc2._I = twgu2.func_71888_h(htvc2._a, n, n2, n3 - 1);
        htvc2._L = twgu2.func_71888_h(htvc2._a, n, n2, n3 + 1);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2 + 1, n3)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2 + 1, n3)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 + 1, n3 + 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 + 1, n3 - 1)];
        if (!bl6 && !bl4) {
            htvc2._F = htvc2._G;
            htvc2._Z = htvc2.__aa;
        } else {
            htvc2._F = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 - 1);
            htvc2._Z = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3 - 1);
        }
        if (!bl6 && !bl3) {
            htvc2._J = htvc2._K;
            htvc2.__ad = htvc2.__ae;
        } else {
            htvc2._J = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3 - 1);
            htvc2.__ad = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3 - 1);
        }
        if (!bl5 && !bl4) {
            htvc2._H = htvc2._G;
            htvc2.__ab = htvc2.__aa;
        } else {
            htvc2._H = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 + 1);
            htvc2.__ab = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3 + 1);
        }
        if (!bl5 && !bl3) {
            htvc2._M = htvc2._K;
            htvc2.__ag = htvc2.__ae;
        } else {
            htvc2._M = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3 + 1);
            htvc2.__ag = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3 + 1);
        }
        int n5 = n4;
        if (htvc2._k >= 1.0 || !htvc2._a.func_72804_r(n, (n2 -= bl ? 1 : 0) + 1, n3)) {
            n5 = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3);
        }
        float f = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3);
        if (bl2) {
            float f2 = (htvc2._H + htvc2._G + htvc2._L + f) / 4.0f;
            float f3 = (htvc2._L + f + htvc2._M + htvc2._K) / 4.0f;
            float f4 = (f + htvc2._I + htvc2._K + htvc2._J) / 4.0f;
            float f5 = (htvc2._G + htvc2._F + f + htvc2._I) / 4.0f;
            this.base_ao[1] = (float)((double)f2 * htvc2._m * (1.0 - htvc2._h) + (double)f3 * htvc2._m * htvc2._h + (double)f4 * (1.0 - htvc2._m) * htvc2._h + (double)f5 * (1.0 - htvc2._m) * (1.0 - htvc2._h));
            this.base_ao[0] = (float)((double)f2 * htvc2._m * (1.0 - htvc2._i) + (double)f3 * htvc2._m * htvc2._i + (double)f4 * (1.0 - htvc2._m) * htvc2._i + (double)f5 * (1.0 - htvc2._m) * (1.0 - htvc2._i));
            this.base_ao[3] = (float)((double)f2 * htvc2._l * (1.0 - htvc2._i) + (double)f3 * htvc2._l * htvc2._i + (double)f4 * (1.0 - htvc2._l) * htvc2._i + (double)f5 * (1.0 - htvc2._l) * (1.0 - htvc2._i));
            this.base_ao[2] = (float)((double)f2 * htvc2._l * (1.0 - htvc2._h) + (double)f3 * htvc2._l * htvc2._h + (double)f4 * (1.0 - htvc2._l) * htvc2._h + (double)f5 * (1.0 - htvc2._l) * (1.0 - htvc2._h));
            int n6 = htvc2._a(htvc2.__ab, htvc2.__aa, htvc2.__af, n5);
            int n7 = htvc2._a(htvc2.__af, htvc2.__ag, htvc2.__ae, n5);
            int n8 = htvc2._a(htvc2.__ac, htvc2.__ae, htvc2.__ad, n5);
            int n9 = htvc2._a(htvc2.__aa, htvc2._Z, htvc2.__ac, n5);
            htvc2.__al = htvc2._a(n7, n8, n9, n6, htvc2._m * (1.0 - htvc2._h), htvc2._m * htvc2._h, (1.0 - htvc2._m) * htvc2._h, (1.0 - htvc2._m) * (1.0 - htvc2._h));
            htvc2.__am = htvc2._a(n7, n8, n9, n6, htvc2._m * (1.0 - htvc2._i), htvc2._m * htvc2._i, (1.0 - htvc2._m) * htvc2._i, (1.0 - htvc2._m) * (1.0 - htvc2._i));
            htvc2.__an = htvc2._a(n7, n8, n9, n6, htvc2._l * (1.0 - htvc2._i), htvc2._l * htvc2._i, (1.0 - htvc2._l) * htvc2._i, (1.0 - htvc2._l) * (1.0 - htvc2._i));
            htvc2.__ao = htvc2._a(n7, n8, n9, n6, htvc2._l * (1.0 - htvc2._h), htvc2._l * htvc2._h, (1.0 - htvc2._l) * htvc2._h, (1.0 - htvc2._l) * (1.0 - htvc2._h));
        } else {
            this.base_ao[1] = (htvc2._H + htvc2._G + htvc2._L + f) / 4.0f;
            this.base_ao[0] = (htvc2._L + f + htvc2._M + htvc2._K) / 4.0f;
            this.base_ao[3] = (f + htvc2._I + htvc2._K + htvc2._J) / 4.0f;
            this.base_ao[2] = (htvc2._G + htvc2._F + f + htvc2._I) / 4.0f;
            htvc2.__ao = htvc2._a(htvc2.__ab, htvc2.__aa, htvc2.__af, n5);
            htvc2.__al = htvc2._a(htvc2.__af, htvc2.__ag, htvc2.__ae, n5);
            htvc2.__am = htvc2._a(htvc2.__ac, htvc2.__ae, htvc2.__ad, n5);
            htvc2.__an = htvc2._a(htvc2.__aa, htvc2._Z, htvc2.__ac, n5);
        }
    }

    protected void setLightnessZNeg(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._l >= 0.0 && htvc2._l <= 0.5;
        boolean bl2 = htvc2._o;
        htvc2._N = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 -= bl ? 1 : 0);
        htvc2._A = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3);
        htvc2._I = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3);
        htvc2._O = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3);
        htvc2.__ah = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3);
        htvc2._U = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3);
        htvc2.__ac = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3);
        htvc2.__ai = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2, n3 - 1)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2, n3 - 1)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 + 1, n3 - 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 - 1, n3 - 1)];
        if (!bl4 && !bl6) {
            htvc2._x = htvc2._N;
            htvc2._R = htvc2.__ah;
        } else {
            htvc2._x = twgu2.func_71888_h(htvc2._a, n - 1, n2 - 1, n3);
            htvc2._R = twgu2.func_71874_e(htvc2._a, n - 1, n2 - 1, n3);
        }
        if (!bl4 && !bl5) {
            htvc2._F = htvc2._N;
            htvc2._Z = htvc2.__ah;
        } else {
            htvc2._F = twgu2.func_71888_h(htvc2._a, n - 1, n2 + 1, n3);
            htvc2._Z = twgu2.func_71874_e(htvc2._a, n - 1, n2 + 1, n3);
        }
        if (!bl3 && !bl6) {
            htvc2._C = htvc2._O;
            htvc2._W = htvc2.__ai;
        } else {
            htvc2._C = twgu2.func_71888_h(htvc2._a, n + 1, n2 - 1, n3);
            htvc2._W = twgu2.func_71874_e(htvc2._a, n + 1, n2 - 1, n3);
        }
        if (!bl3 && !bl5) {
            htvc2._J = htvc2._O;
            htvc2.__ad = htvc2.__ai;
        } else {
            htvc2._J = twgu2.func_71888_h(htvc2._a, n + 1, n2 + 1, n3);
            htvc2.__ad = twgu2.func_71874_e(htvc2._a, n + 1, n2 + 1, n3);
        }
        int n5 = n4;
        if (htvc2._l <= 0.0 || !htvc2._a.func_72804_r(n, n2, (n3 += bl ? 1 : 0) - 1)) {
            n5 = twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1);
        }
        float f = twgu2.func_71888_h(htvc2._a, n, n2, n3 - 1);
        if (bl2) {
            float f2 = (htvc2._N + htvc2._F + f + htvc2._I) / 4.0f;
            float f3 = (f + htvc2._I + htvc2._O + htvc2._J) / 4.0f;
            float f4 = (htvc2._A + f + htvc2._C + htvc2._O) / 4.0f;
            float f5 = (htvc2._x + htvc2._N + htvc2._A + f) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * htvc2._k * (1.0 - htvc2._h) + (double)f3 * htvc2._k * htvc2._h + (double)f4 * (1.0 - htvc2._k) * htvc2._h + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._h));
            this.base_ao[3] = (float)((double)f2 * htvc2._k * (1.0 - htvc2._i) + (double)f3 * htvc2._k * htvc2._i + (double)f4 * (1.0 - htvc2._k) * htvc2._i + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._i));
            this.base_ao[2] = (float)((double)f2 * htvc2._j * (1.0 - htvc2._i) + (double)f3 * htvc2._j * htvc2._i + (double)f4 * (1.0 - htvc2._j) * htvc2._i + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._i));
            this.base_ao[1] = (float)((double)f2 * htvc2._j * (1.0 - htvc2._h) + (double)f3 * htvc2._j * htvc2._h + (double)f4 * (1.0 - htvc2._j) * htvc2._h + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._h));
            int n6 = htvc2._a(htvc2.__ah, htvc2._Z, htvc2.__ac, n5);
            int n7 = htvc2._a(htvc2.__ac, htvc2.__ai, htvc2.__ad, n5);
            int n8 = htvc2._a(htvc2._U, htvc2._W, htvc2.__ai, n5);
            int n9 = htvc2._a(htvc2._R, htvc2.__ah, htvc2._U, n5);
            htvc2.__al = htvc2._a(n6, n7, n8, n9, htvc2._k * (1.0 - htvc2._h), htvc2._k * htvc2._h, (1.0 - htvc2._k) * htvc2._h, (1.0 - htvc2._k) * (1.0 - htvc2._h));
            htvc2.__am = htvc2._a(n6, n7, n8, n9, htvc2._k * (1.0 - htvc2._i), htvc2._k * htvc2._i, (1.0 - htvc2._k) * htvc2._i, (1.0 - htvc2._k) * (1.0 - htvc2._i));
            htvc2.__an = htvc2._a(n6, n7, n8, n9, htvc2._j * (1.0 - htvc2._i), htvc2._j * htvc2._i, (1.0 - htvc2._j) * htvc2._i, (1.0 - htvc2._j) * (1.0 - htvc2._i));
            htvc2.__ao = htvc2._a(n6, n7, n8, n9, htvc2._j * (1.0 - htvc2._h), htvc2._j * htvc2._h, (1.0 - htvc2._j) * htvc2._h, (1.0 - htvc2._j) * (1.0 - htvc2._h));
        } else {
            this.base_ao[0] = (htvc2._N + htvc2._F + f + htvc2._I) / 4.0f;
            this.base_ao[3] = (f + htvc2._I + htvc2._O + htvc2._J) / 4.0f;
            this.base_ao[2] = (htvc2._A + f + htvc2._C + htvc2._O) / 4.0f;
            this.base_ao[1] = (htvc2._x + htvc2._N + htvc2._A + f) / 4.0f;
            htvc2.__al = htvc2._a(htvc2.__ah, htvc2._Z, htvc2.__ac, n5);
            htvc2.__am = htvc2._a(htvc2.__ac, htvc2.__ai, htvc2.__ad, n5);
            htvc2.__an = htvc2._a(htvc2._U, htvc2._W, htvc2.__ai, n5);
            htvc2.__ao = htvc2._a(htvc2._R, htvc2.__ah, htvc2._U, n5);
        }
    }

    protected void setLightnessZPos(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._m <= 1.0 && htvc2._m > 0.5;
        boolean bl2 = htvc2._o;
        htvc2._P = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3 += bl ? 1 : 0);
        htvc2._Q = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3);
        htvc2._B = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3);
        htvc2._L = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3);
        htvc2.__aj = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3);
        htvc2.__ak = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3);
        htvc2._V = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3);
        htvc2.__af = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2, n3 + 1)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2, n3 + 1)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 + 1, n3 + 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n, n2 - 1, n3 + 1)];
        if (!bl4 && !bl6) {
            htvc2._z = htvc2._P;
            htvc2._T = htvc2.__aj;
        } else {
            htvc2._z = twgu2.func_71888_h(htvc2._a, n - 1, n2 - 1, n3);
            htvc2._T = twgu2.func_71874_e(htvc2._a, n - 1, n2 - 1, n3);
        }
        if (!bl4 && !bl5) {
            htvc2._H = htvc2._P;
            htvc2.__ab = htvc2.__aj;
        } else {
            htvc2._H = twgu2.func_71888_h(htvc2._a, n - 1, n2 + 1, n3);
            htvc2.__ab = twgu2.func_71874_e(htvc2._a, n - 1, n2 + 1, n3);
        }
        if (!bl3 && !bl6) {
            htvc2._E = htvc2._Q;
            htvc2._Y = htvc2.__ak;
        } else {
            htvc2._E = twgu2.func_71888_h(htvc2._a, n + 1, n2 - 1, n3);
            htvc2._Y = twgu2.func_71874_e(htvc2._a, n + 1, n2 - 1, n3);
        }
        if (!bl3 && !bl5) {
            htvc2._M = htvc2._Q;
            htvc2.__ag = htvc2.__ak;
        } else {
            htvc2._M = twgu2.func_71888_h(htvc2._a, n + 1, n2 + 1, n3);
            htvc2.__ag = twgu2.func_71874_e(htvc2._a, n + 1, n2 + 1, n3);
        }
        int n5 = n4;
        if (htvc2._m >= 1.0 || !htvc2._a.func_72804_r(n, n2, (n3 -= bl ? 1 : 0) + 1)) {
            n5 = twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1);
        }
        float f = twgu2.func_71888_h(htvc2._a, n, n2, n3 + 1);
        if (bl2) {
            float f2 = (htvc2._P + htvc2._H + f + htvc2._L) / 4.0f;
            float f3 = (f + htvc2._L + htvc2._Q + htvc2._M) / 4.0f;
            float f4 = (htvc2._B + f + htvc2._E + htvc2._Q) / 4.0f;
            float f5 = (htvc2._z + htvc2._P + htvc2._B + f) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * htvc2._k * (1.0 - htvc2._h) + (double)f3 * htvc2._k * htvc2._h + (double)f4 * (1.0 - htvc2._k) * htvc2._h + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._h));
            this.base_ao[3] = (float)((double)f2 * htvc2._j * (1.0 - htvc2._h) + (double)f3 * htvc2._j * htvc2._h + (double)f4 * (1.0 - htvc2._j) * htvc2._h + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._h));
            this.base_ao[2] = (float)((double)f2 * htvc2._j * (1.0 - htvc2._i) + (double)f3 * htvc2._j * htvc2._i + (double)f4 * (1.0 - htvc2._j) * htvc2._i + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._i));
            this.base_ao[1] = (float)((double)f2 * htvc2._k * (1.0 - htvc2._i) + (double)f3 * htvc2._k * htvc2._i + (double)f4 * (1.0 - htvc2._k) * htvc2._i + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._i));
            int n6 = htvc2._a(htvc2.__aj, htvc2.__ab, htvc2.__af, n5);
            int n7 = htvc2._a(htvc2.__af, htvc2.__ak, htvc2.__ag, n5);
            int n8 = htvc2._a(htvc2._V, htvc2._Y, htvc2.__ak, n5);
            int n9 = htvc2._a(htvc2._T, htvc2.__aj, htvc2._V, n5);
            htvc2.__al = htvc2._a(n6, n9, n8, n7, htvc2._k * (1.0 - htvc2._h), (1.0 - htvc2._k) * (1.0 - htvc2._h), (1.0 - htvc2._k) * htvc2._h, htvc2._k * htvc2._h);
            htvc2.__am = htvc2._a(n6, n9, n8, n7, htvc2._j * (1.0 - htvc2._h), (1.0 - htvc2._j) * (1.0 - htvc2._h), (1.0 - htvc2._j) * htvc2._h, htvc2._j * htvc2._h);
            htvc2.__an = htvc2._a(n6, n9, n8, n7, htvc2._j * (1.0 - htvc2._i), (1.0 - htvc2._j) * (1.0 - htvc2._i), (1.0 - htvc2._j) * htvc2._i, htvc2._j * htvc2._i);
            htvc2.__ao = htvc2._a(n6, n9, n8, n7, htvc2._k * (1.0 - htvc2._i), (1.0 - htvc2._k) * (1.0 - htvc2._i), (1.0 - htvc2._k) * htvc2._i, htvc2._k * htvc2._i);
        } else {
            this.base_ao[0] = (htvc2._P + htvc2._H + f + htvc2._L) / 4.0f;
            this.base_ao[1] = (f + htvc2._L + htvc2._Q + htvc2._M) / 4.0f;
            this.base_ao[2] = (htvc2._B + f + htvc2._E + htvc2._Q) / 4.0f;
            this.base_ao[3] = (htvc2._z + htvc2._P + htvc2._B + f) / 4.0f;
            htvc2.__al = htvc2._a(htvc2.__aj, htvc2.__ab, htvc2.__af, n5);
            htvc2.__ao = htvc2._a(htvc2.__af, htvc2.__ak, htvc2.__ag, n5);
            htvc2.__an = htvc2._a(htvc2._V, htvc2._Y, htvc2.__ak, n5);
            htvc2.__am = htvc2._a(htvc2._T, htvc2.__aj, htvc2._V, n5);
        }
    }

    protected void setLightnessXNeg(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._h >= 0.0 && htvc2._h <= 0.5;
        boolean bl2 = htvc2._o;
        htvc2._y = twgu2.func_71888_h(htvc2._a, n -= bl ? 1 : 0, n2 - 1, n3);
        htvc2._N = twgu2.func_71888_h(htvc2._a, n, n2, n3 - 1);
        htvc2._P = twgu2.func_71888_h(htvc2._a, n, n2, n3 + 1);
        htvc2._G = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3);
        htvc2._S = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3);
        htvc2.__ah = twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1);
        htvc2.__aj = twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1);
        htvc2.__aa = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2 + 1, n3)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2 - 1, n3)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2, n3 - 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n - 1, n2, n3 + 1)];
        if (!bl5 && !bl4) {
            htvc2._x = htvc2._N;
            htvc2._R = htvc2.__ah;
        } else {
            htvc2._x = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3 - 1);
            htvc2._R = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3 - 1);
        }
        if (!bl6 && !bl4) {
            htvc2._z = htvc2._P;
            htvc2._T = htvc2.__aj;
        } else {
            htvc2._z = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3 + 1);
            htvc2._T = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3 + 1);
        }
        if (!bl5 && !bl3) {
            htvc2._F = htvc2._N;
            htvc2._Z = htvc2.__ah;
        } else {
            htvc2._F = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3 - 1);
            htvc2._Z = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3 - 1);
        }
        if (!bl6 && !bl3) {
            htvc2._H = htvc2._P;
            htvc2.__ab = htvc2.__aj;
        } else {
            htvc2._H = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3 + 1);
            htvc2.__ab = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3 + 1);
        }
        int n5 = n4;
        if (htvc2._h <= 0.0 || !htvc2._a.func_72804_r((n += bl ? 1 : 0) - 1, n2, n3)) {
            n5 = twgu2.func_71874_e(htvc2._a, n - 1, n2, n3);
        }
        float f = twgu2.func_71888_h(htvc2._a, n - 1, n2, n3);
        if (bl2) {
            float f2 = (htvc2._y + htvc2._z + f + htvc2._P) / 4.0f;
            float f3 = (f + htvc2._P + htvc2._G + htvc2._H) / 4.0f;
            float f4 = (htvc2._N + f + htvc2._F + htvc2._G) / 4.0f;
            float f5 = (htvc2._x + htvc2._y + htvc2._N + f) / 4.0f;
            this.base_ao[0] = (float)((double)f3 * htvc2._k * htvc2._m + (double)f4 * htvc2._k * (1.0 - htvc2._m) + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._m) + (double)f2 * (1.0 - htvc2._k) * htvc2._m);
            this.base_ao[3] = (float)((double)f3 * htvc2._k * htvc2._l + (double)f4 * htvc2._k * (1.0 - htvc2._l) + (double)f5 * (1.0 - htvc2._k) * (1.0 - htvc2._l) + (double)f2 * (1.0 - htvc2._k) * htvc2._l);
            this.base_ao[2] = (float)((double)f3 * htvc2._j * htvc2._l + (double)f4 * htvc2._j * (1.0 - htvc2._l) + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._l) + (double)f2 * (1.0 - htvc2._j) * htvc2._l);
            this.base_ao[1] = (float)((double)f3 * htvc2._j * htvc2._m + (double)f4 * htvc2._j * (1.0 - htvc2._m) + (double)f5 * (1.0 - htvc2._j) * (1.0 - htvc2._m) + (double)f2 * (1.0 - htvc2._j) * htvc2._m);
            int n6 = htvc2._a(htvc2._S, htvc2._T, htvc2.__aj, n5);
            int n7 = htvc2._a(htvc2.__aj, htvc2.__aa, htvc2.__ab, n5);
            int n8 = htvc2._a(htvc2.__ah, htvc2._Z, htvc2.__aa, n5);
            int n9 = htvc2._a(htvc2._R, htvc2._S, htvc2.__ah, n5);
            htvc2.__al = htvc2._a(n7, n8, n9, n6, htvc2._k * htvc2._m, htvc2._k * (1.0 - htvc2._m), (1.0 - htvc2._k) * (1.0 - htvc2._m), (1.0 - htvc2._k) * htvc2._m);
            htvc2.__am = htvc2._a(n7, n8, n9, n6, htvc2._k * htvc2._l, htvc2._k * (1.0 - htvc2._l), (1.0 - htvc2._k) * (1.0 - htvc2._l), (1.0 - htvc2._k) * htvc2._l);
            htvc2.__an = htvc2._a(n7, n8, n9, n6, htvc2._j * htvc2._l, htvc2._j * (1.0 - htvc2._l), (1.0 - htvc2._j) * (1.0 - htvc2._l), (1.0 - htvc2._j) * htvc2._l);
            htvc2.__ao = htvc2._a(n7, n8, n9, n6, htvc2._j * htvc2._m, htvc2._j * (1.0 - htvc2._m), (1.0 - htvc2._j) * (1.0 - htvc2._m), (1.0 - htvc2._j) * htvc2._m);
        } else {
            this.base_ao[1] = (htvc2._y + htvc2._z + f + htvc2._P) / 4.0f;
            this.base_ao[0] = (f + htvc2._P + htvc2._G + htvc2._H) / 4.0f;
            this.base_ao[3] = (htvc2._N + f + htvc2._F + htvc2._G) / 4.0f;
            this.base_ao[2] = (htvc2._x + htvc2._y + htvc2._N + f) / 4.0f;
            htvc2.__ao = htvc2._a(htvc2._S, htvc2._T, htvc2.__aj, n5);
            htvc2.__al = htvc2._a(htvc2.__aj, htvc2.__aa, htvc2.__ab, n5);
            htvc2.__am = htvc2._a(htvc2.__ah, htvc2._Z, htvc2.__aa, n5);
            htvc2.__an = htvc2._a(htvc2._R, htvc2._S, htvc2.__ah, n5);
        }
    }

    protected void setLightnessXPos(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        boolean bl = htvc2._i <= 1.0 && htvc2._i > 0.5;
        boolean bl2 = htvc2._o;
        htvc2._D = twgu2.func_71888_h(htvc2._a, n += bl ? 1 : 0, n2 - 1, n3);
        htvc2._O = twgu2.func_71888_h(htvc2._a, n, n2, n3 - 1);
        htvc2._Q = twgu2.func_71888_h(htvc2._a, n, n2, n3 + 1);
        htvc2._K = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3);
        htvc2._X = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3);
        htvc2.__ai = twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1);
        htvc2.__ak = twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1);
        htvc2.__ae = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3);
        boolean bl3 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2 + 1, n3)];
        boolean bl4 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2 - 1, n3)];
        boolean bl5 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2, n3 + 1)];
        boolean bl6 = twgu.field_71985_p[htvc2._a.func_72798_a(n + 1, n2, n3 - 1)];
        if (!bl4 && !bl6) {
            htvc2._C = htvc2._O;
            htvc2._W = htvc2.__ai;
        } else {
            htvc2._C = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3 - 1);
            htvc2._W = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3 - 1);
        }
        if (!bl4 && !bl5) {
            htvc2._E = htvc2._Q;
            htvc2._Y = htvc2.__ak;
        } else {
            htvc2._E = twgu2.func_71888_h(htvc2._a, n, n2 - 1, n3 + 1);
            htvc2._Y = twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3 + 1);
        }
        if (!bl3 && !bl6) {
            htvc2._J = htvc2._O;
            htvc2.__ad = htvc2.__ai;
        } else {
            htvc2._J = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3 - 1);
            htvc2.__ad = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3 - 1);
        }
        if (!bl3 && !bl5) {
            htvc2._M = htvc2._Q;
            htvc2.__ag = htvc2.__ak;
        } else {
            htvc2._M = twgu2.func_71888_h(htvc2._a, n, n2 + 1, n3 + 1);
            htvc2.__ag = twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3 + 1);
        }
        int n5 = n4;
        if (htvc2._i >= 1.0 || !htvc2._a.func_72804_r((n -= bl ? 1 : 0) + 1, n2, n3)) {
            n5 = twgu2.func_71874_e(htvc2._a, n + 1, n2, n3);
        }
        float f = twgu2.func_71888_h(htvc2._a, n + 1, n2, n3);
        if (bl2) {
            float f2 = (htvc2._D + htvc2._E + f + htvc2._Q) / 4.0f;
            float f3 = (htvc2._C + htvc2._D + htvc2._O + f) / 4.0f;
            float f4 = (htvc2._O + f + htvc2._J + htvc2._K) / 4.0f;
            float f5 = (f + htvc2._Q + htvc2._K + htvc2._M) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * (1.0 - htvc2._j) * htvc2._m + (double)f3 * (1.0 - htvc2._j) * (1.0 - htvc2._m) + (double)f4 * htvc2._j * (1.0 - htvc2._m) + (double)f5 * htvc2._j * htvc2._m);
            this.base_ao[3] = (float)((double)f2 * (1.0 - htvc2._j) * htvc2._l + (double)f3 * (1.0 - htvc2._j) * (1.0 - htvc2._l) + (double)f4 * htvc2._j * (1.0 - htvc2._l) + (double)f5 * htvc2._j * htvc2._l);
            this.base_ao[2] = (float)((double)f2 * (1.0 - htvc2._k) * htvc2._l + (double)f3 * (1.0 - htvc2._k) * (1.0 - htvc2._l) + (double)f4 * htvc2._k * (1.0 - htvc2._l) + (double)f5 * htvc2._k * htvc2._l);
            this.base_ao[1] = (float)((double)f2 * (1.0 - htvc2._k) * htvc2._m + (double)f3 * (1.0 - htvc2._k) * (1.0 - htvc2._m) + (double)f4 * htvc2._k * (1.0 - htvc2._m) + (double)f5 * htvc2._k * htvc2._m);
            int n6 = htvc2._a(htvc2._X, htvc2._Y, htvc2.__ak, n5);
            int n7 = htvc2._a(htvc2.__ak, htvc2.__ae, htvc2.__ag, n5);
            int n8 = htvc2._a(htvc2.__ai, htvc2.__ad, htvc2.__ae, n5);
            int n9 = htvc2._a(htvc2._W, htvc2._X, htvc2.__ai, n5);
            htvc2.__al = htvc2._a(n6, n9, n8, n7, (1.0 - htvc2._j) * htvc2._m, (1.0 - htvc2._j) * (1.0 - htvc2._m), htvc2._j * (1.0 - htvc2._m), htvc2._j * htvc2._m);
            htvc2.__am = htvc2._a(n6, n9, n8, n7, (1.0 - htvc2._j) * htvc2._l, (1.0 - htvc2._j) * (1.0 - htvc2._l), htvc2._j * (1.0 - htvc2._l), htvc2._j * htvc2._l);
            htvc2.__an = htvc2._a(n6, n9, n8, n7, (1.0 - htvc2._k) * htvc2._l, (1.0 - htvc2._k) * (1.0 - htvc2._l), htvc2._k * (1.0 - htvc2._l), htvc2._k * htvc2._l);
            htvc2.__ao = htvc2._a(n6, n9, n8, n7, (1.0 - htvc2._k) * htvc2._m, (1.0 - htvc2._k) * (1.0 - htvc2._m), htvc2._k * (1.0 - htvc2._m), htvc2._k * htvc2._m);
        } else {
            this.base_ao[0] = (htvc2._D + htvc2._E + f + htvc2._Q) / 4.0f;
            this.base_ao[3] = (htvc2._C + htvc2._D + htvc2._O + f) / 4.0f;
            this.base_ao[2] = (htvc2._O + f + htvc2._J + htvc2._K) / 4.0f;
            this.base_ao[1] = (f + htvc2._Q + htvc2._K + htvc2._M) / 4.0f;
            htvc2.__al = htvc2._a(htvc2._X, htvc2._Y, htvc2.__ak, n5);
            htvc2.__ao = htvc2._a(htvc2.__ak, htvc2.__ae, htvc2.__ag, n5);
            htvc2.__an = htvc2._a(htvc2.__ai, htvc2.__ad, htvc2.__ae, n5);
            htvc2.__am = htvc2._a(htvc2._W, htvc2._X, htvc2.__ai, n5);
        }
    }

    protected boolean renderStandardBlockWithColorMultiplier(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, float f, float f2, float f3) {
        htvc2._w = false;
        htvf htvf2 = htvc2.__aF;
        boolean bl = false;
        int n4 = twgu2.func_71874_e(htvc2._a, n, n2, n3);
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2 - 1, n3, 0) || htvc2._j > 0.0) {
            htvf2.func_78380_c(htvc2._j > 0.0 ? n4 : twgu2.func_71874_e(htvc2._a, n, n2 - 1, n3));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 0, n, n2, n3, 0.5f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2 + 1, n3, 1) || htvc2._k < 1.0) {
            htvf2.func_78380_c(htvc2._k < 1.0 ? n4 : twgu2.func_71874_e(htvc2._a, n, n2 + 1, n3));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 1, n, n2, n3, 1.0f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2, n3 - 1, 2) || htvc2._l > 0.0) {
            htvf2.func_78380_c(htvc2._l > 0.0 ? n4 : twgu2.func_71874_e(htvc2._a, n, n2, n3 - 1));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 2, n, n2, n3, 0.8f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n, n2, n3 + 1, 3) || htvc2._m < 1.0) {
            htvf2.func_78380_c(htvc2._m < 1.0 ? n4 : twgu2.func_71874_e(htvc2._a, n, n2, n3 + 1));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 3, n, n2, n3, 0.8f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n - 1, n2, n3, 4) || htvc2._h > 0.0) {
            htvf2.func_78380_c(htvc2._h > 0.0 ? n4 : twgu2.func_71874_e(htvc2._a, n - 1, n2, n3));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 4, n, n2, n3, 0.6f);
            bl = true;
        }
        if (htvc2._d || twgu3.func_71877_c(htvc2._a, n + 1, n2, n3, 5) || htvc2._i < 1.0) {
            htvf2.func_78380_c(htvc2._i < 1.0 ? n4 : twgu2.func_71874_e(htvc2._a, n + 1, n2, n3));
            this.prepareRender(tECarpentersBlock, htvc2, twgu2, twgu3, 5, n, n2, n3, 0.6f);
            bl = true;
        }
        return bl;
    }
}

