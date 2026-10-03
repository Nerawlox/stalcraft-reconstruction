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
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
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
    protected Icon[] iconOverride;
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
        this.iconOverride = new Icon[6];
        this.base_ao = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.base_RGB = new float[]{0.0f, 0.0f, 0.0f};
    }

    protected void setDirectionalRotation(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, int n) {
        int n2 = BlockProperties.getCoverMetadata(tECarpentersBlock, this.coverRendering);
        int n3 = n2 & 0xC;
        switch (n) {
            case 0: {
                if (n2 != 3 && n3 != 4) break;
                renderBlocks._v = 1;
                break;
            }
            case 1: {
                if (n2 != 3 && n3 != 4) break;
                renderBlocks._u = 1;
                break;
            }
            case 2: {
                if (n2 != 3 && n3 != 4) break;
                renderBlocks._q = 1;
                break;
            }
            case 3: {
                if (n2 != 3 && n3 != 4) break;
                renderBlocks._r = 1;
                break;
            }
            case 4: {
                if (n2 != 4 && n3 != 8) break;
                renderBlocks._t = 1;
                break;
            }
            case 5: {
                if (n2 != 4 && n3 != 8) break;
                renderBlocks._s = 1;
            }
        }
    }

    protected void clearRotation(RenderBlocks renderBlocks, int n) {
        switch (n) {
            case 0: {
                renderBlocks._v = 0;
                break;
            }
            case 1: {
                renderBlocks._u = 0;
                break;
            }
            case 2: {
                renderBlocks._q = 0;
                break;
            }
            case 3: {
                renderBlocks._r = 0;
                break;
            }
            case 4: {
                renderBlocks._t = 0;
                break;
            }
            case 5: {
                renderBlocks._s = 0;
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

    protected void setIconOverride(int n, Icon icon) {
        if (n == 6) {
            for (int i = 0; i < 6; ++i) {
                this.hasIconOverride[i] = true;
                this.iconOverride[i] = icon;
            }
        } else {
            this.hasIconOverride[n] = true;
            this.iconOverride[n] = icon;
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
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = MinecraftForgeClient.getRenderPass();
        boolean bl = false;
        bl |= this.renderCarpentersBlock(tECarpentersBlock, renderBlocks, block, n5, n, n2, n3);
        bl |= this.renderSideCovers(tECarpentersBlock, renderBlocks, block, n5, n, n2, n3);
        if (n5 >= 0 && FeatureHandler.enableFancyFluids && Minecraft._B() && BlockProperties.hasCover(tECarpentersBlock, 6)) {
            bl |= this.renderFancyFluids(tECarpentersBlock, renderBlocks, n, n2, n3, n5);
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

    protected boolean shouldRenderBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n) {
        return this.renderAlphaOverride ? n == 1 : renderBlocks._b() || block.canRenderInPass(n) || block instanceof BlockBase && n == 0 || this.hasAccessories(block2);
    }

    private boolean hasAccessories(Block block) {
        return block == BlockHandler.blockCarpentersDoor || block == BlockHandler.blockCarpentersHatch;
    }

    protected boolean shouldRenderOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        if (!this.suppressOverlay) {
            Block block = BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering);
            if (BlockProperties.hasOverlay(tECarpentersBlock, this.coverRendering) || block == Block.grass) {
                int n2 = block.getRenderBlockPass();
                if (this.renderAlphaOverride) {
                    return n == 1;
                }
                if (block instanceof BlockBase) {
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

    private boolean renderFancyFluids(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, int n, int n2, int n3, int n4) {
        if (FeatureHandler.enableFancyFluids) {
            int n5;
            boolean bl;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            Block block;
            Block block2 = !renderBlocks._a.isAirBlock(n - 1, n2, n3) ? Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3)] : null;
            Block block3 = !renderBlocks._a.isAirBlock(n + 1, n2, n3) ? Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3)] : null;
            Block block4 = !renderBlocks._a.isAirBlock(n, n2, n3 - 1) ? Block.blocksList[renderBlocks._a.getBlockId(n, n2, n3 - 1)] : null;
            Block block5 = !renderBlocks._a.isAirBlock(n, n2, n3 + 1) ? Block.blocksList[renderBlocks._a.getBlockId(n, n2, n3 + 1)] : null;
            Block block6 = !renderBlocks._a.isAirBlock(n - 1, n2, n3 + 1) ? Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3 + 1)] : null;
            Block block7 = !renderBlocks._a.isAirBlock(n + 1, n2, n3 + 1) ? Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3 + 1)] : null;
            Block block8 = !renderBlocks._a.isAirBlock(n - 1, n2, n3 - 1) ? Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3 - 1)] : null;
            Block block9 = block = !renderBlocks._a.isAirBlock(n + 1, n2, n3 - 1) ? Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3 - 1)] : null;
            boolean bl8 = block2 != null ? block2 instanceof IFluidBlock || block2 instanceof BlockFluid : (bl7 = false);
            boolean bl9 = block3 != null ? block3 instanceof IFluidBlock || block3 instanceof BlockFluid : (bl6 = false);
            boolean bl10 = block4 != null ? block4 instanceof IFluidBlock || block4 instanceof BlockFluid : (bl5 = false);
            boolean bl11 = block5 != null ? block5 instanceof IFluidBlock || block5 instanceof BlockFluid : (bl4 = false);
            boolean bl12 = block6 != null ? block6 instanceof IFluidBlock || block6 instanceof BlockFluid : (bl3 = false);
            boolean bl13 = block7 != null ? block7 instanceof IFluidBlock || block7 instanceof BlockFluid : (bl2 = false);
            boolean bl14 = block8 != null ? block8 instanceof IFluidBlock || block8 instanceof BlockFluid : (bl = false);
            boolean bl15 = block != null ? block instanceof IFluidBlock || block instanceof BlockFluid : false;
            boolean bl16 = renderBlocks._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.WEST, true);
            boolean bl17 = renderBlocks._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.EAST, true);
            boolean bl18 = renderBlocks._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.NORTH, true);
            boolean bl19 = renderBlocks._a.isBlockSolidOnSide(n, n2, n3, ForgeDirection.SOUTH, true);
            int n6 = 0;
            int n7 = 0;
            Block block10 = null;
            Block block11 = null;
            block16: for (n5 = 2; n5 < 10 && block10 == null; ++n5) {
                switch (n5) {
                    case 2: {
                        if (!bl5 || bl18) continue block16;
                        block10 = Block.blocksList[renderBlocks._a.getBlockId(n, n2, n3 - 1)];
                        if (n6 >= renderBlocks._a.getBlockMetadata(n, n2, n3 - 1)) continue block16;
                        n6 = renderBlocks._a.getBlockMetadata(n, n2, n3 - 1);
                        continue block16;
                    }
                    case 3: {
                        if (!bl4 || bl19) continue block16;
                        block10 = Block.blocksList[renderBlocks._a.getBlockId(n, n2, n3 + 1)];
                        if (n6 >= renderBlocks._a.getBlockMetadata(n, n2, n3 + 1)) continue block16;
                        n6 = renderBlocks._a.getBlockMetadata(n, n2, n3 + 1);
                        continue block16;
                    }
                    case 4: {
                        if (!bl7 || bl16) continue block16;
                        block10 = Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3)];
                        if (n6 >= renderBlocks._a.getBlockMetadata(n - 1, n2, n3)) continue block16;
                        n6 = renderBlocks._a.getBlockMetadata(n - 1, n2, n3);
                        continue block16;
                    }
                    case 5: {
                        if (!bl6 || bl17) continue block16;
                        block10 = Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3)];
                        if (n6 >= renderBlocks._a.getBlockMetadata(n + 1, n2, n3)) continue block16;
                        n6 = renderBlocks._a.getBlockMetadata(n + 1, n2, n3);
                        continue block16;
                    }
                    case 6: {
                        if (!bl15) continue block16;
                        block11 = Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3 - 1)];
                        if (n7 >= renderBlocks._a.getBlockMetadata(n + 1, n2, n3 - 1)) continue block16;
                        n7 = renderBlocks._a.getBlockMetadata(n + 1, n2, n3 - 1);
                        continue block16;
                    }
                    case 7: {
                        if (!bl2) continue block16;
                        block11 = Block.blocksList[renderBlocks._a.getBlockId(n + 1, n2, n3 + 1)];
                        if (n7 >= renderBlocks._a.getBlockMetadata(n + 1, n2, n3 + 1)) continue block16;
                        n7 = renderBlocks._a.getBlockMetadata(n + 1, n2, n3 + 1);
                        continue block16;
                    }
                    case 8: {
                        if (!bl) continue block16;
                        block11 = Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3 - 1)];
                        if (n7 >= renderBlocks._a.getBlockMetadata(n - 1, n2, n3 - 1)) continue block16;
                        n7 = renderBlocks._a.getBlockMetadata(n - 1, n2, n3 - 1);
                        continue block16;
                    }
                    case 9: {
                        if (!bl3) continue block16;
                        block11 = Block.blocksList[renderBlocks._a.getBlockId(n - 1, n2, n3 + 1)];
                        if (n7 >= renderBlocks._a.getBlockMetadata(n - 1, n2, n3 + 1)) continue block16;
                        n7 = renderBlocks._a.getBlockMetadata(n - 1, n2, n3 + 1);
                    }
                }
            }
            if (block10 != null && n4 == block10.getRenderBlockPass() || block11 != null && n4 == block11.getRenderBlockPass()) {
                n5 = 0;
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 1.0f;
                float f4 = 1.0f;
                float f5 = 0.01f;
                block17: for (int i = 2; i < 6; ++i) {
                    switch (i) {
                        case 2: {
                            if (bl19 || !bl4 && (renderBlocks._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) || (!bl3 || renderBlocks._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.WEST, true)) && (!bl2 || renderBlocks._a.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.EAST, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 3: {
                            if (bl18 || !bl5 && (renderBlocks._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) || (!bl || renderBlocks._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.WEST, true)) && (!bl15 || renderBlocks._a.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.EAST, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 4: {
                            if (bl17 || !bl6 && (renderBlocks._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) || (!bl2 || renderBlocks._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.SOUTH, true)) && (!bl15 || renderBlocks._a.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.NORTH, true)))) continue block17;
                            n5 = 1;
                            continue block17;
                        }
                        case 5: {
                            if (bl16 || !bl7 && (renderBlocks._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) || (!bl3 || renderBlocks._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.SOUTH, true)) && (!bl || renderBlocks._a.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.NORTH, true)))) continue block17;
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
                    if (block10 == null) {
                        block10 = block11;
                        n6 = n7;
                    }
                    if (!block10.hasTileEntity(n6) && n6 == 0) {
                        double d = (block10 instanceof BlockFluid ? 0.8888888880610466 : 0.875) - (double)0.001f;
                        renderBlocks._a(f, f5, (double)f2, (double)f3, d, (double)f4);
                        float[] fArray = this.writeRGB(tempRGB, renderBlocks._a, block10, n, n2, n3);
                        return renderBlocks._c(block10, n, n2, n3, fArray[0], fArray[1], fArray[2]);
                    }
                }
            }
        }
        return false;
    }

    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering);
        if (block2 != null) {
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
        }
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    protected int[] setSideCoverRenderBounds(int[] nArray, TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5;
        double d = 0.0625;
        if (n4 == 1 && ((n5 = BlockProperties.getCoverID(tECarpentersBlock, n4)) == Block.blockSnow.blockID || n5 == Block.snow.blockID)) {
            d = 0.125;
        }
        switch (n4) {
            case 0: {
                if (renderBlocks._j > 0.0) {
                    renderBlocks._k = renderBlocks._j;
                    renderBlocks._j -= d;
                    break;
                }
                renderBlocks._k = 1.0;
                renderBlocks._j = renderBlocks._k - d;
                --n2;
                break;
            }
            case 1: {
                if (renderBlocks._k < 1.0) {
                    renderBlocks._j = renderBlocks._k;
                    renderBlocks._k += d;
                    break;
                }
                renderBlocks._k = d;
                renderBlocks._j = 0.0;
                ++n2;
                break;
            }
            case 2: {
                if (renderBlocks._l > 0.0) {
                    renderBlocks._m = renderBlocks._l;
                    renderBlocks._l -= d;
                    break;
                }
                renderBlocks._m = 1.0;
                renderBlocks._l = renderBlocks._m - d;
                --n3;
                break;
            }
            case 3: {
                if (renderBlocks._m < 1.0) {
                    renderBlocks._l = renderBlocks._m;
                    renderBlocks._m += d;
                    break;
                }
                renderBlocks._m = d;
                renderBlocks._l = 0.0;
                ++n3;
                break;
            }
            case 4: {
                if (renderBlocks._h > 0.0) {
                    renderBlocks._i = renderBlocks._h;
                    renderBlocks._h -= d;
                    break;
                }
                renderBlocks._i = 1.0;
                renderBlocks._h = renderBlocks._i - d;
                --n;
                break;
            }
            case 5: {
                if (renderBlocks._i < 1.0) {
                    renderBlocks._h = renderBlocks._i;
                    renderBlocks._i += d;
                    break;
                }
                renderBlocks._i = d;
                renderBlocks._h = 0.0;
                ++n;
            }
        }
        float f = 0.001f;
        boolean bl2 = bl = n4 == 0 || n4 == 1;
        if (!bl) {
            renderBlocks._j -= (double)f;
            renderBlocks._k += (double)f;
        }
        if (n4 == 4 || n4 == 5 || bl) {
            renderBlocks._l -= (double)f;
            renderBlocks._m += (double)f;
        }
        if (n4 == 2 || n4 == 3 || bl) {
            renderBlocks._h -= (double)f;
            renderBlocks._i += (double)f;
        }
        nArray[0] = n;
        nArray[1] = n2;
        nArray[2] = n3;
        return nArray;
    }

    protected boolean renderSideCovers(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        boolean bl = false;
        this.isSideCover = true;
        renderBlocks._d = true;
        block.setBlockBoundsBasedOnState(renderBlocks._a, n2, n3, n4);
        for (int i = 0; i < 6; ++i) {
            if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
            Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, i);
            this.coverRendering = i;
            if (!this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n) && !this.shouldRenderPattern(tECarpentersBlock, n)) continue;
            int[] nArray = this.setSideCoverRenderBounds(tempRenderOffset, tECarpentersBlock, renderBlocks, n2, n3, n4, i);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, nArray[0], nArray[1], nArray[2]);
            renderBlocks._a(block);
            bl = true;
        }
        renderBlocks._d = false;
        this.coverRendering = 6;
        this.isSideCover = false;
        return bl;
    }

    protected void aoMultiplyByColor(RenderBlocks renderBlocks, float f, float f2, float f3) {
        renderBlocks.__ap *= f;
        renderBlocks.__at *= f2;
        renderBlocks.__ax *= f3;
        renderBlocks.__as *= f;
        renderBlocks.__aw *= f2;
        renderBlocks.__aA *= f3;
        renderBlocks.__ar *= f;
        renderBlocks.__av *= f2;
        renderBlocks.__az *= f3;
        renderBlocks.__aq *= f;
        renderBlocks.__au *= f2;
        renderBlocks.__ay *= f3;
    }

    protected void aoSetColor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, float f, float f2, float f3, float f4) {
        renderBlocks.__ar = renderBlocks.__as = f * f4;
        renderBlocks.__aq = renderBlocks.__as;
        renderBlocks.__ap = renderBlocks.__as;
        renderBlocks.__av = renderBlocks.__aw = f2 * f4;
        renderBlocks.__au = renderBlocks.__aw;
        renderBlocks.__at = renderBlocks.__aw;
        renderBlocks.__az = renderBlocks.__aA = f3 * f4;
        renderBlocks.__ay = renderBlocks.__aA;
        renderBlocks.__ax = renderBlocks.__aA;
        renderBlocks.__ap *= this.base_ao[0];
        renderBlocks.__at *= this.base_ao[0];
        renderBlocks.__ax *= this.base_ao[0];
        renderBlocks.__as *= this.base_ao[1];
        renderBlocks.__aw *= this.base_ao[1];
        renderBlocks.__aA *= this.base_ao[1];
        renderBlocks.__ar *= this.base_ao[2];
        renderBlocks.__av *= this.base_ao[2];
        renderBlocks.__az *= this.base_ao[2];
        renderBlocks.__aq *= this.base_ao[3];
        renderBlocks.__au *= this.base_ao[3];
        renderBlocks.__ay *= this.base_ao[3];
    }

    protected void aoResetColor(RenderBlocks renderBlocks) {
        renderBlocks.__ap = this.base_ao[0];
        renderBlocks.__at = this.base_ao[0];
        renderBlocks.__ax = this.base_ao[0];
        renderBlocks.__as = this.base_ao[1];
        renderBlocks.__aw = this.base_ao[1];
        renderBlocks.__aA = this.base_ao[1];
        renderBlocks.__ar = this.base_ao[2];
        renderBlocks.__av = this.base_ao[2];
        renderBlocks.__az = this.base_ao[2];
        renderBlocks.__aq = this.base_ao[3];
        renderBlocks.__au = this.base_ao[3];
        renderBlocks.__ay = this.base_ao[3];
    }

    protected Icon getIcon(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = this.hasMetadataOverride ? this.metadataOverride : BlockProperties.getCoverMetadata(tECarpentersBlock, this.coverRendering);
        Icon icon = block.getIcon(n, n6);
        if (block2 == BlockHandler.blockCarpentersDaylightSensor) {
            icon = block2.getBlockTexture(renderBlocks._a, n2, n3, n4, n);
        }
        if (block == BlockHandler.blockCarpentersLever) {
            icon = IconHandler.icon_generic;
        }
        if (this.isSideSloped) {
            Slope slope = Slope.slopesList[n5];
            if (!BlockProperties.hasCover(tECarpentersBlock, 6)) {
                if (slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_INT)) {
                    icon = slope.isPositive ? IconHandler.icon_slope_oblique_pt_low : IconHandler.icon_slope_oblique_pt_high;
                } else if (slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) {
                    Icon icon2 = icon = slope.isPositive ? IconHandler.icon_slope_oblique_pt_high : IconHandler.icon_slope_oblique_pt_low;
                }
            }
            if (BlockProperties.blockRotates(tECarpentersBlock.worldObj, block, n2, n3, n4)) {
                icon = n6 % 8 == 0 ? block.getIcon(slope.isPositive ? 1 : 0, n6) : block.getIcon(2, n6);
            } else if (block instanceof BlockDirectional && !slope.slopeType.equals((Object)Slope.SlopeType.WEDGE_Y)) {
                icon = block.getBlockTextureFromSide(1);
            }
        }
        if (this.hasIconOverride[n] && this.iconOverride[n] != null) {
            icon = this.iconOverride[n];
        }
        return icon;
    }

    protected void renderMultiTexturedSide(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4, float f, Icon icon) {
        int n5;
        int n6;
        Icon icon2 = icon;
        if (block == Block.grass && n != 0) {
            icon = this.getGrassOverlayIcon(tECarpentersBlock, 1);
        }
        if (block == Block.mycelium && n != 0) {
            icon = TextureUtils.iconMyceliumTop;
        }
        if ((n6 = tECarpentersBlock.worldObj.getBlockMetadata(n2, n3, n4) >> 2) == 3) {
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
                renderBlocks._r = n6;
                break;
            }
            case 1: {
                renderBlocks._s = n6;
                break;
            }
            case 2: {
                renderBlocks._q = n6;
                break;
            }
            case 3: {
                renderBlocks._t = n6;
            }
        }
        icon = ConnectedTextures.getConnectedTexture(tECarpentersBlock.worldObj, block, n2, n3, n4, n8, icon);
        if (icon == null) {
            icon = icon2;
        }
        if (this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block, block2, n5 = MinecraftForgeClient.getRenderPass())) {
            if (BlockProperties.blockRotates(tECarpentersBlock.worldObj, block, n2, n3, n4)) {
                this.setDirectionalRotation(tECarpentersBlock, renderBlocks, n);
            }
            this.colorSide(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, n4, icon, f);
            this.renderSide(tECarpentersBlock, renderBlocks, n, 0.0, n2, n3, n4, icon);
            this.clearRotation(renderBlocks, n);
        }
        renderBlocks._r = 0;
        renderBlocks._s = 0;
        renderBlocks._q = 0;
        renderBlocks._t = 0;
        renderBlocks._u = 0;
        renderBlocks._v = 0;
        if (block2 != BlockHandler.blockCarpentersDaylightSensor || n != 1) {
            this.suppressDyeColor = true;
            if (this.shouldRenderPattern(tECarpentersBlock, n5)) {
                this.renderPattern(tECarpentersBlock, renderBlocks, block2, n, n2, n3, n4, f);
            }
            if (this.shouldRenderOverlay(tECarpentersBlock, n5) && block != Block.grass && block != Block.mycelium) {
                this.renderOverlay(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, n4, f, icon);
            }
            this.suppressDyeColor = false;
        }
    }

    protected void prepareRender(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4, float f) {
        Icon icon = this.getIcon(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, n4);
        if (!renderBlocks._w) {
            this.base_RGB = new float[]{f, f, f};
        }
        if (renderBlocks._b()) {
            this.renderSide(tECarpentersBlock, renderBlocks, n, 0.0, n2, n3, n4, renderBlocks._b);
        } else {
            this.renderMultiTexturedSide(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, n4, f, icon);
        }
    }

    protected void colorSide(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4, Icon icon, float f) {
        Tessellator tessellator = renderBlocks.__aF;
        float[] fArray = this.writeRGB(tempRGB, renderBlocks._a, block, n2, n3, n4);
        float[] fArray2 = this.hasDyeColorOverride ? DyeColorHandler.getDyeColorRGB(this.suppressDyeColor ? 0 : this.dyeColorOverride) : DyeColorHandler.getDyeColorRGB(this.suppressDyeColor ? 0 : BlockProperties.getDyeColor(tECarpentersBlock, this.coverRendering));
        if (this.hasLightnessOffset) {
            if (renderBlocks._w) {
                f += this.lightnessOffset;
            } else {
                this.base_RGB[0] = this.base_RGB[0] + this.lightnessOffset;
                this.base_RGB[1] = this.base_RGB[1] + this.lightnessOffset;
                this.base_RGB[2] = this.base_RGB[2] + this.lightnessOffset;
            }
        }
        if (renderBlocks._w) {
            this.aoResetColor(renderBlocks);
            if (this.useColorComponent(tECarpentersBlock, block, block2, n, icon)) {
                this.aoSetColor(tECarpentersBlock, renderBlocks, block, n, fArray[0] * fArray2[0], fArray[1] * fArray2[1], fArray[2] * fArray2[2], f);
            } else {
                this.aoSetColor(tECarpentersBlock, renderBlocks, block, n, fArray2[0], fArray2[1], fArray2[2], f);
            }
        } else if (this.useColorComponent(tECarpentersBlock, block, block2, n, icon)) {
            tessellator.setColorOpaque_F(this.base_RGB[0] * fArray[0] * fArray2[0], this.base_RGB[1] * fArray[1] * fArray2[1], this.base_RGB[2] * fArray[2] * fArray2[2]);
        } else {
            tessellator.setColorOpaque_F(this.base_RGB[0] * fArray2[0], this.base_RGB[1] * fArray2[1], this.base_RGB[2] * fArray2[2]);
        }
    }

    protected boolean useColorComponent(TECarpentersBlock tECarpentersBlock, Block block, Block block2, int n, Icon icon) {
        boolean bl;
        if (block == Block.grass && n != 0) {
            return true;
        }
        if (block != Block.grass && BlockProperties.getOverlay(tECarpentersBlock, n) != 1) {
            return true;
        }
        boolean bl2 = bl = this.isSideSloped ? Slope.slopesList[BlockProperties.getData((TECarpentersBlock)tECarpentersBlock)].isPositive : false;
        return n != 1 && icon != BlockGrass._a() && !bl ? false : (block2 == BlockHandler.blockCarpentersDaylightSensor ? n != 1 : true);
    }

    protected void renderOverlay(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4, float f, Icon icon) {
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
        if (block == Block.grass) {
            icon = this.getGrassOverlayIcon(tECarpentersBlock, n);
            if (n == ForgeDirection.UP.ordinal()) {
                icon = ConnectedTextures.getConnectedTexture(tECarpentersBlock.worldObj, block, n2, n3, n4, n, icon);
            }
            if (icon == null) {
                return;
            }
            this.colorSide(tECarpentersBlock, renderBlocks, Block.grass, block2, n, n2, n3, n4, icon, f);
            if (n6 != 0) {
                this.renderSide(tECarpentersBlock, renderBlocks, n, 0.0, n2, n3, n4, icon);
            }
        }
        switch (n6) {
            case 1: {
                if (block == Block.grass) break;
                icon = this.getGrassOverlayIcon(tECarpentersBlock, n);
                if (icon == null) {
                    return;
                }
                this.colorSide(tECarpentersBlock, renderBlocks, Block.grass, block2, n, n2, n3, n4, icon, f);
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        icon = Block.snow.getBlockTextureFromSide(1);
                        break;
                    }
                    default: {
                        icon = IconHandler.icon_overlay_snow_side;
                    }
                }
                this.colorSide(tECarpentersBlock, renderBlocks, Block.blockSnow, block2, n, n2, n3, n4, icon, f);
                break;
            }
            case 3: {
                icon = Block.web.getBlockTextureFromSide(n);
                this.colorSide(tECarpentersBlock, renderBlocks, Block.web, block2, n, n2, n3, n4, icon, f);
                break;
            }
            case 4: {
                icon = Block.vine.getBlockTextureFromSide(n);
                this.colorSide(tECarpentersBlock, renderBlocks, Block.vine, block2, n, n2, n3, n4, icon, f);
                break;
            }
            case 5: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        icon = Block.hay.getBlockTextureFromSide(1);
                        break;
                    }
                    default: {
                        icon = IconHandler.icon_overlay_hay_side;
                    }
                }
                this.colorSide(tECarpentersBlock, renderBlocks, Block.hay, block2, n, n2, n3, n4, icon, f);
                break;
            }
            case 6: {
                switch (n) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        icon = Block.mycelium.getBlockTextureFromSide(1);
                        break;
                    }
                    default: {
                        icon = IconHandler.icon_overlay_mycelium_side;
                    }
                }
                this.colorSide(tECarpentersBlock, renderBlocks, Block.mycelium, block2, n, n2, n3, n4, icon, f);
            }
        }
        this.renderSide(tECarpentersBlock, renderBlocks, n, 0.0, n2, n3, n4, icon);
    }

    protected Icon getGrassOverlayIcon(TECarpentersBlock tECarpentersBlock, int n) {
        boolean bl;
        boolean bl2 = bl = this.isSideSloped ? Slope.slopesList[BlockProperties.getData((TECarpentersBlock)tECarpentersBlock)].isPositive : false;
        return n != 1 && !bl ? (n > 1 ? (RenderBlocks._e ? BlockGrass._a() : IconHandler.icon_overlay_fast_grass_side) : null) : Block.grass.getBlockTextureFromSide(1);
    }

    protected void renderPattern(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4, float f) {
        int n5 = BlockProperties.getPattern(tECarpentersBlock, this.coverRendering);
        Icon icon = IconHandler.icon_pattern[n5];
        if (icon == null) {
            return;
        }
        this.colorSide(tECarpentersBlock, renderBlocks, Block.glass, block, n, n2, n3, n4, icon, f);
        this.renderSide(tECarpentersBlock, renderBlocks, n, 0.0, n2, n3, n4, icon);
    }

    protected void renderSide(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, int n, double d, int n2, int n3, int n4, Icon icon) {
        if (d != 0.0) {
            renderBlocks.__aE.setOffset(d);
        }
        switch (n) {
            case 0: {
                this.renderHelper.renderFaceYNeg(renderBlocks, n2, n3, n4, icon);
                break;
            }
            case 1: {
                this.renderHelper.renderFaceYPos(renderBlocks, n2, n3, n4, icon);
                break;
            }
            case 2: {
                this.renderHelper.renderFaceZNeg(renderBlocks, n2, n3, n4, icon);
                break;
            }
            case 3: {
                this.renderHelper.renderFaceZPos(renderBlocks, n2, n3, n4, icon);
                break;
            }
            case 4: {
                this.renderHelper.renderFaceXNeg(renderBlocks, n2, n3, n4, icon);
                break;
            }
            case 5: {
                this.renderHelper.renderFaceXPos(renderBlocks, n2, n3, n4, icon);
            }
        }
        renderBlocks.__aE.clearOffset();
    }

    protected float[] writeRGB(float[] fArray, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3) {
        int n4 = FeatureHandler.enableOptifineIntegration ? OptifineHandler.getColorMultiplier(block, iBlockAccess, n, n2, n3) : block.colorMultiplier(iBlockAccess, n, n2, n3);
        fArray[0] = (float)(n4 >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n4 >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            fArray[0] = (fArray[0] * 30.0f + fArray[1] * 59.0f + fArray[2] * 11.0f) / 100.0f;
            fArray[1] = (fArray[0] * 30.0f + fArray[1] * 70.0f) / 100.0f;
            fArray[2] = (fArray[0] * 30.0f + fArray[2] * 70.0f) / 100.0f;
        }
        return fArray;
    }

    protected boolean renderStandardBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        if (block == null) {
            return true;
        }
        float[] fArray = this.writeRGB(tempRGB, renderBlocks._a, block, n, n2, n3);
        if (block2 == BlockHandler.blockCarpentersSlope && !this.isSideCover) {
            if (Minecraft._C() && Block.lightValue[block.blockID] == 0) {
                this.renderStandardSlopeWithAmbientOcclusion(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, fArray[0], fArray[1], fArray[2]);
            } else {
                this.renderStandardSlopeWithColorMultiplier(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, fArray[0], fArray[1], fArray[2]);
            }
        } else if (Minecraft._C() && !this.disableAO && Block.lightValue[block.blockID] == 0) {
            this.renderStandardBlockWithAmbientOcclusion(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, fArray[0], fArray[1], fArray[2]);
        } else {
            this.renderStandardBlockWithColorMultiplier(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3, fArray[0], fArray[1], fArray[2]);
        }
        return true;
    }

    protected boolean renderStandardSlopeWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        return false;
    }

    protected boolean renderStandardSlopeWithColorMultiplier(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        return false;
    }

    protected boolean renderStandardBlockWithAmbientOcclusion(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        renderBlocks._w = true;
        boolean bl = false;
        renderBlocks.__aF.setBrightness(983055);
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2 - 1, n3, 0) || renderBlocks._j > 0.0) {
            this.setLightnessYNeg(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 0, n, n2, n3, 0.5f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2 + 1, n3, 1) || renderBlocks._k < 1.0) {
            this.setLightnessYPos(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 1, n, n2, n3, 1.0f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 - 1, 2) || renderBlocks._l > 0.0) {
            this.setLightnessZNeg(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 2, n, n2, n3, 0.8f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 + 1, 3) || renderBlocks._m < 1.0) {
            this.setLightnessZPos(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 3, n, n2, n3, 0.8f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n - 1, n2, n3, 4) || renderBlocks._h > 0.0) {
            this.setLightnessXNeg(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 4, n, n2, n3, 0.6f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n + 1, n2, n3, 5) || renderBlocks._i < 1.0) {
            this.setLightnessXPos(renderBlocks, block, n, n2, n3);
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 5, n, n2, n3, 0.6f);
            bl = true;
        }
        if (this.base_ao[0] > 0.0f) {
            renderBlocks._w = false;
        }
        return bl;
    }

    protected void setLightnessYNeg(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._j >= 0.0 && renderBlocks._j <= 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks._S = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 -= bl ? 1 : 0, n3);
        renderBlocks._U = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks._V = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks._X = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3);
        renderBlocks._y = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3);
        renderBlocks._A = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks._B = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks._D = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2 - 1, n3)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2 - 1, n3)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 - 1, n3 + 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 - 1, n3 - 1)];
        if (!bl6 && !bl4) {
            renderBlocks._x = renderBlocks._y;
            renderBlocks._R = renderBlocks._S;
        } else {
            renderBlocks._x = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 - 1);
            renderBlocks._R = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3 - 1);
        }
        if (!bl5 && !bl4) {
            renderBlocks._z = renderBlocks._y;
            renderBlocks._T = renderBlocks._S;
        } else {
            renderBlocks._z = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 + 1);
            renderBlocks._T = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3 + 1);
        }
        if (!bl6 && !bl3) {
            renderBlocks._C = renderBlocks._D;
            renderBlocks._W = renderBlocks._X;
        } else {
            renderBlocks._C = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3 - 1);
            renderBlocks._W = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3 - 1);
        }
        if (!bl5 && !bl3) {
            renderBlocks._E = renderBlocks._D;
            renderBlocks._Y = renderBlocks._X;
        } else {
            renderBlocks._E = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3 + 1);
            renderBlocks._Y = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3 + 1);
        }
        int n5 = n4;
        if (renderBlocks._j <= 0.0 || !renderBlocks._a.isBlockOpaqueCube(n, (n2 += bl ? 1 : 0) - 1, n3)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3);
        if (bl2) {
            float f2 = (renderBlocks._z + renderBlocks._y + renderBlocks._B + f) / 4.0f;
            float f3 = (renderBlocks._B + f + renderBlocks._E + renderBlocks._D) / 4.0f;
            float f4 = (f + renderBlocks._A + renderBlocks._D + renderBlocks._C) / 4.0f;
            float f5 = (renderBlocks._y + renderBlocks._x + f + renderBlocks._A) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * renderBlocks._m * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._m * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._m) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._m) * (1.0 - renderBlocks._h));
            this.base_ao[1] = (float)((double)f2 * renderBlocks._m * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._m * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._m) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._m) * (1.0 - renderBlocks._i));
            this.base_ao[2] = (float)((double)f2 * renderBlocks._l * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._l * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._l) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._l) * (1.0 - renderBlocks._i));
            this.base_ao[3] = (float)((double)f2 * renderBlocks._l * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._l * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._l) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._l) * (1.0 - renderBlocks._h));
            int n6 = renderBlocks._a(renderBlocks._T, renderBlocks._S, renderBlocks._V, n5);
            int n7 = renderBlocks._a(renderBlocks._V, renderBlocks._Y, renderBlocks._X, n5);
            int n8 = renderBlocks._a(renderBlocks._U, renderBlocks._X, renderBlocks._W, n5);
            int n9 = renderBlocks._a(renderBlocks._S, renderBlocks._R, renderBlocks._U, n5);
            renderBlocks.__al = renderBlocks._a(n6, n9, n8, n7, renderBlocks._m * (1.0 - renderBlocks._h), renderBlocks._m * renderBlocks._h, (1.0 - renderBlocks._m) * renderBlocks._h, (1.0 - renderBlocks._m) * (1.0 - renderBlocks._h));
            renderBlocks.__am = renderBlocks._a(n6, n9, n8, n7, renderBlocks._m * (1.0 - renderBlocks._i), renderBlocks._m * renderBlocks._i, (1.0 - renderBlocks._m) * renderBlocks._i, (1.0 - renderBlocks._m) * (1.0 - renderBlocks._i));
            renderBlocks.__an = renderBlocks._a(n6, n9, n8, n7, renderBlocks._l * (1.0 - renderBlocks._i), renderBlocks._l * renderBlocks._i, (1.0 - renderBlocks._l) * renderBlocks._i, (1.0 - renderBlocks._l) * (1.0 - renderBlocks._i));
            renderBlocks.__ao = renderBlocks._a(n6, n9, n8, n7, renderBlocks._l * (1.0 - renderBlocks._h), renderBlocks._l * renderBlocks._h, (1.0 - renderBlocks._l) * renderBlocks._h, (1.0 - renderBlocks._l) * (1.0 - renderBlocks._h));
        } else {
            this.base_ao[0] = (renderBlocks._z + renderBlocks._y + renderBlocks._B + f) / 4.0f;
            this.base_ao[1] = (renderBlocks._B + f + renderBlocks._E + renderBlocks._D) / 4.0f;
            this.base_ao[2] = (f + renderBlocks._A + renderBlocks._D + renderBlocks._C) / 4.0f;
            this.base_ao[3] = (renderBlocks._y + renderBlocks._x + f + renderBlocks._A) / 4.0f;
            renderBlocks.__al = renderBlocks._a(renderBlocks._T, renderBlocks._S, renderBlocks._V, n5);
            renderBlocks.__ao = renderBlocks._a(renderBlocks._V, renderBlocks._Y, renderBlocks._X, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks._U, renderBlocks._X, renderBlocks._W, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks._S, renderBlocks._R, renderBlocks._U, n5);
        }
    }

    protected void setLightnessYPos(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._k <= 1.0 && renderBlocks._k > 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks.__aa = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 += bl ? 1 : 0, n3);
        renderBlocks.__ae = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3);
        renderBlocks.__ac = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks.__af = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks._G = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3);
        renderBlocks._K = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3);
        renderBlocks._I = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks._L = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 + 1);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2 + 1, n3)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2 + 1, n3)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 + 1, n3 + 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 + 1, n3 - 1)];
        if (!bl6 && !bl4) {
            renderBlocks._F = renderBlocks._G;
            renderBlocks._Z = renderBlocks.__aa;
        } else {
            renderBlocks._F = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 - 1);
            renderBlocks._Z = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3 - 1);
        }
        if (!bl6 && !bl3) {
            renderBlocks._J = renderBlocks._K;
            renderBlocks.__ad = renderBlocks.__ae;
        } else {
            renderBlocks._J = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3 - 1);
            renderBlocks.__ad = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3 - 1);
        }
        if (!bl5 && !bl4) {
            renderBlocks._H = renderBlocks._G;
            renderBlocks.__ab = renderBlocks.__aa;
        } else {
            renderBlocks._H = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 + 1);
            renderBlocks.__ab = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3 + 1);
        }
        if (!bl5 && !bl3) {
            renderBlocks._M = renderBlocks._K;
            renderBlocks.__ag = renderBlocks.__ae;
        } else {
            renderBlocks._M = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3 + 1);
            renderBlocks.__ag = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3 + 1);
        }
        int n5 = n4;
        if (renderBlocks._k >= 1.0 || !renderBlocks._a.isBlockOpaqueCube(n, (n2 -= bl ? 1 : 0) + 1, n3)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3);
        if (bl2) {
            float f2 = (renderBlocks._H + renderBlocks._G + renderBlocks._L + f) / 4.0f;
            float f3 = (renderBlocks._L + f + renderBlocks._M + renderBlocks._K) / 4.0f;
            float f4 = (f + renderBlocks._I + renderBlocks._K + renderBlocks._J) / 4.0f;
            float f5 = (renderBlocks._G + renderBlocks._F + f + renderBlocks._I) / 4.0f;
            this.base_ao[1] = (float)((double)f2 * renderBlocks._m * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._m * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._m) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._m) * (1.0 - renderBlocks._h));
            this.base_ao[0] = (float)((double)f2 * renderBlocks._m * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._m * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._m) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._m) * (1.0 - renderBlocks._i));
            this.base_ao[3] = (float)((double)f2 * renderBlocks._l * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._l * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._l) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._l) * (1.0 - renderBlocks._i));
            this.base_ao[2] = (float)((double)f2 * renderBlocks._l * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._l * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._l) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._l) * (1.0 - renderBlocks._h));
            int n6 = renderBlocks._a(renderBlocks.__ab, renderBlocks.__aa, renderBlocks.__af, n5);
            int n7 = renderBlocks._a(renderBlocks.__af, renderBlocks.__ag, renderBlocks.__ae, n5);
            int n8 = renderBlocks._a(renderBlocks.__ac, renderBlocks.__ae, renderBlocks.__ad, n5);
            int n9 = renderBlocks._a(renderBlocks.__aa, renderBlocks._Z, renderBlocks.__ac, n5);
            renderBlocks.__al = renderBlocks._a(n7, n8, n9, n6, renderBlocks._m * (1.0 - renderBlocks._h), renderBlocks._m * renderBlocks._h, (1.0 - renderBlocks._m) * renderBlocks._h, (1.0 - renderBlocks._m) * (1.0 - renderBlocks._h));
            renderBlocks.__am = renderBlocks._a(n7, n8, n9, n6, renderBlocks._m * (1.0 - renderBlocks._i), renderBlocks._m * renderBlocks._i, (1.0 - renderBlocks._m) * renderBlocks._i, (1.0 - renderBlocks._m) * (1.0 - renderBlocks._i));
            renderBlocks.__an = renderBlocks._a(n7, n8, n9, n6, renderBlocks._l * (1.0 - renderBlocks._i), renderBlocks._l * renderBlocks._i, (1.0 - renderBlocks._l) * renderBlocks._i, (1.0 - renderBlocks._l) * (1.0 - renderBlocks._i));
            renderBlocks.__ao = renderBlocks._a(n7, n8, n9, n6, renderBlocks._l * (1.0 - renderBlocks._h), renderBlocks._l * renderBlocks._h, (1.0 - renderBlocks._l) * renderBlocks._h, (1.0 - renderBlocks._l) * (1.0 - renderBlocks._h));
        } else {
            this.base_ao[1] = (renderBlocks._H + renderBlocks._G + renderBlocks._L + f) / 4.0f;
            this.base_ao[0] = (renderBlocks._L + f + renderBlocks._M + renderBlocks._K) / 4.0f;
            this.base_ao[3] = (f + renderBlocks._I + renderBlocks._K + renderBlocks._J) / 4.0f;
            this.base_ao[2] = (renderBlocks._G + renderBlocks._F + f + renderBlocks._I) / 4.0f;
            renderBlocks.__ao = renderBlocks._a(renderBlocks.__ab, renderBlocks.__aa, renderBlocks.__af, n5);
            renderBlocks.__al = renderBlocks._a(renderBlocks.__af, renderBlocks.__ag, renderBlocks.__ae, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks.__ac, renderBlocks.__ae, renderBlocks.__ad, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks.__aa, renderBlocks._Z, renderBlocks.__ac, n5);
        }
    }

    protected void setLightnessZNeg(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._l >= 0.0 && renderBlocks._l <= 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks._N = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 -= bl ? 1 : 0);
        renderBlocks._A = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks._I = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3);
        renderBlocks._O = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3);
        renderBlocks.__ah = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3);
        renderBlocks._U = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks.__ac = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3);
        renderBlocks.__ai = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2, n3 - 1)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2, n3 - 1)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 + 1, n3 - 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 - 1, n3 - 1)];
        if (!bl4 && !bl6) {
            renderBlocks._x = renderBlocks._N;
            renderBlocks._R = renderBlocks.__ah;
        } else {
            renderBlocks._x = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2 - 1, n3);
            renderBlocks._R = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 - 1, n3);
        }
        if (!bl4 && !bl5) {
            renderBlocks._F = renderBlocks._N;
            renderBlocks._Z = renderBlocks.__ah;
        } else {
            renderBlocks._F = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2 + 1, n3);
            renderBlocks._Z = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 + 1, n3);
        }
        if (!bl3 && !bl6) {
            renderBlocks._C = renderBlocks._O;
            renderBlocks._W = renderBlocks.__ai;
        } else {
            renderBlocks._C = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2 - 1, n3);
            renderBlocks._W = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2 - 1, n3);
        }
        if (!bl3 && !bl5) {
            renderBlocks._J = renderBlocks._O;
            renderBlocks.__ad = renderBlocks.__ai;
        } else {
            renderBlocks._J = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2 + 1, n3);
            renderBlocks.__ad = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2 + 1, n3);
        }
        int n5 = n4;
        if (renderBlocks._l <= 0.0 || !renderBlocks._a.isBlockOpaqueCube(n, n2, (n3 += bl ? 1 : 0) - 1)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 - 1);
        if (bl2) {
            float f2 = (renderBlocks._N + renderBlocks._F + f + renderBlocks._I) / 4.0f;
            float f3 = (f + renderBlocks._I + renderBlocks._O + renderBlocks._J) / 4.0f;
            float f4 = (renderBlocks._A + f + renderBlocks._C + renderBlocks._O) / 4.0f;
            float f5 = (renderBlocks._x + renderBlocks._N + renderBlocks._A + f) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * renderBlocks._k * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._k * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._k) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._h));
            this.base_ao[3] = (float)((double)f2 * renderBlocks._k * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._k * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._k) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._i));
            this.base_ao[2] = (float)((double)f2 * renderBlocks._j * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._j * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._j) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._i));
            this.base_ao[1] = (float)((double)f2 * renderBlocks._j * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._j * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._j) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._h));
            int n6 = renderBlocks._a(renderBlocks.__ah, renderBlocks._Z, renderBlocks.__ac, n5);
            int n7 = renderBlocks._a(renderBlocks.__ac, renderBlocks.__ai, renderBlocks.__ad, n5);
            int n8 = renderBlocks._a(renderBlocks._U, renderBlocks._W, renderBlocks.__ai, n5);
            int n9 = renderBlocks._a(renderBlocks._R, renderBlocks.__ah, renderBlocks._U, n5);
            renderBlocks.__al = renderBlocks._a(n6, n7, n8, n9, renderBlocks._k * (1.0 - renderBlocks._h), renderBlocks._k * renderBlocks._h, (1.0 - renderBlocks._k) * renderBlocks._h, (1.0 - renderBlocks._k) * (1.0 - renderBlocks._h));
            renderBlocks.__am = renderBlocks._a(n6, n7, n8, n9, renderBlocks._k * (1.0 - renderBlocks._i), renderBlocks._k * renderBlocks._i, (1.0 - renderBlocks._k) * renderBlocks._i, (1.0 - renderBlocks._k) * (1.0 - renderBlocks._i));
            renderBlocks.__an = renderBlocks._a(n6, n7, n8, n9, renderBlocks._j * (1.0 - renderBlocks._i), renderBlocks._j * renderBlocks._i, (1.0 - renderBlocks._j) * renderBlocks._i, (1.0 - renderBlocks._j) * (1.0 - renderBlocks._i));
            renderBlocks.__ao = renderBlocks._a(n6, n7, n8, n9, renderBlocks._j * (1.0 - renderBlocks._h), renderBlocks._j * renderBlocks._h, (1.0 - renderBlocks._j) * renderBlocks._h, (1.0 - renderBlocks._j) * (1.0 - renderBlocks._h));
        } else {
            this.base_ao[0] = (renderBlocks._N + renderBlocks._F + f + renderBlocks._I) / 4.0f;
            this.base_ao[3] = (f + renderBlocks._I + renderBlocks._O + renderBlocks._J) / 4.0f;
            this.base_ao[2] = (renderBlocks._A + f + renderBlocks._C + renderBlocks._O) / 4.0f;
            this.base_ao[1] = (renderBlocks._x + renderBlocks._N + renderBlocks._A + f) / 4.0f;
            renderBlocks.__al = renderBlocks._a(renderBlocks.__ah, renderBlocks._Z, renderBlocks.__ac, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks.__ac, renderBlocks.__ai, renderBlocks.__ad, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks._U, renderBlocks._W, renderBlocks.__ai, n5);
            renderBlocks.__ao = renderBlocks._a(renderBlocks._R, renderBlocks.__ah, renderBlocks._U, n5);
        }
    }

    protected void setLightnessZPos(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._m <= 1.0 && renderBlocks._m > 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks._P = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3 += bl ? 1 : 0);
        renderBlocks._Q = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3);
        renderBlocks._B = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks._L = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3);
        renderBlocks.__aj = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3);
        renderBlocks.__ak = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3);
        renderBlocks._V = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks.__af = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2, n3 + 1)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2, n3 + 1)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 + 1, n3 + 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n, n2 - 1, n3 + 1)];
        if (!bl4 && !bl6) {
            renderBlocks._z = renderBlocks._P;
            renderBlocks._T = renderBlocks.__aj;
        } else {
            renderBlocks._z = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2 - 1, n3);
            renderBlocks._T = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 - 1, n3);
        }
        if (!bl4 && !bl5) {
            renderBlocks._H = renderBlocks._P;
            renderBlocks.__ab = renderBlocks.__aj;
        } else {
            renderBlocks._H = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2 + 1, n3);
            renderBlocks.__ab = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2 + 1, n3);
        }
        if (!bl3 && !bl6) {
            renderBlocks._E = renderBlocks._Q;
            renderBlocks._Y = renderBlocks.__ak;
        } else {
            renderBlocks._E = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2 - 1, n3);
            renderBlocks._Y = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2 - 1, n3);
        }
        if (!bl3 && !bl5) {
            renderBlocks._M = renderBlocks._Q;
            renderBlocks.__ag = renderBlocks.__ak;
        } else {
            renderBlocks._M = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2 + 1, n3);
            renderBlocks.__ag = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2 + 1, n3);
        }
        int n5 = n4;
        if (renderBlocks._m >= 1.0 || !renderBlocks._a.isBlockOpaqueCube(n, n2, (n3 -= bl ? 1 : 0) + 1)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 + 1);
        if (bl2) {
            float f2 = (renderBlocks._P + renderBlocks._H + f + renderBlocks._L) / 4.0f;
            float f3 = (f + renderBlocks._L + renderBlocks._Q + renderBlocks._M) / 4.0f;
            float f4 = (renderBlocks._B + f + renderBlocks._E + renderBlocks._Q) / 4.0f;
            float f5 = (renderBlocks._z + renderBlocks._P + renderBlocks._B + f) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * renderBlocks._k * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._k * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._k) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._h));
            this.base_ao[3] = (float)((double)f2 * renderBlocks._j * (1.0 - renderBlocks._h) + (double)f3 * renderBlocks._j * renderBlocks._h + (double)f4 * (1.0 - renderBlocks._j) * renderBlocks._h + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._h));
            this.base_ao[2] = (float)((double)f2 * renderBlocks._j * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._j * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._j) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._i));
            this.base_ao[1] = (float)((double)f2 * renderBlocks._k * (1.0 - renderBlocks._i) + (double)f3 * renderBlocks._k * renderBlocks._i + (double)f4 * (1.0 - renderBlocks._k) * renderBlocks._i + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._i));
            int n6 = renderBlocks._a(renderBlocks.__aj, renderBlocks.__ab, renderBlocks.__af, n5);
            int n7 = renderBlocks._a(renderBlocks.__af, renderBlocks.__ak, renderBlocks.__ag, n5);
            int n8 = renderBlocks._a(renderBlocks._V, renderBlocks._Y, renderBlocks.__ak, n5);
            int n9 = renderBlocks._a(renderBlocks._T, renderBlocks.__aj, renderBlocks._V, n5);
            renderBlocks.__al = renderBlocks._a(n6, n9, n8, n7, renderBlocks._k * (1.0 - renderBlocks._h), (1.0 - renderBlocks._k) * (1.0 - renderBlocks._h), (1.0 - renderBlocks._k) * renderBlocks._h, renderBlocks._k * renderBlocks._h);
            renderBlocks.__am = renderBlocks._a(n6, n9, n8, n7, renderBlocks._j * (1.0 - renderBlocks._h), (1.0 - renderBlocks._j) * (1.0 - renderBlocks._h), (1.0 - renderBlocks._j) * renderBlocks._h, renderBlocks._j * renderBlocks._h);
            renderBlocks.__an = renderBlocks._a(n6, n9, n8, n7, renderBlocks._j * (1.0 - renderBlocks._i), (1.0 - renderBlocks._j) * (1.0 - renderBlocks._i), (1.0 - renderBlocks._j) * renderBlocks._i, renderBlocks._j * renderBlocks._i);
            renderBlocks.__ao = renderBlocks._a(n6, n9, n8, n7, renderBlocks._k * (1.0 - renderBlocks._i), (1.0 - renderBlocks._k) * (1.0 - renderBlocks._i), (1.0 - renderBlocks._k) * renderBlocks._i, renderBlocks._k * renderBlocks._i);
        } else {
            this.base_ao[0] = (renderBlocks._P + renderBlocks._H + f + renderBlocks._L) / 4.0f;
            this.base_ao[1] = (f + renderBlocks._L + renderBlocks._Q + renderBlocks._M) / 4.0f;
            this.base_ao[2] = (renderBlocks._B + f + renderBlocks._E + renderBlocks._Q) / 4.0f;
            this.base_ao[3] = (renderBlocks._z + renderBlocks._P + renderBlocks._B + f) / 4.0f;
            renderBlocks.__al = renderBlocks._a(renderBlocks.__aj, renderBlocks.__ab, renderBlocks.__af, n5);
            renderBlocks.__ao = renderBlocks._a(renderBlocks.__af, renderBlocks.__ak, renderBlocks.__ag, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks._V, renderBlocks._Y, renderBlocks.__ak, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks._T, renderBlocks.__aj, renderBlocks._V, n5);
        }
    }

    protected void setLightnessXNeg(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._h >= 0.0 && renderBlocks._h <= 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks._y = block.getAmbientOcclusionLightValue(renderBlocks._a, n -= bl ? 1 : 0, n2 - 1, n3);
        renderBlocks._N = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks._P = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks._G = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3);
        renderBlocks._S = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks.__ah = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks.__aj = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks.__aa = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2 + 1, n3)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2 - 1, n3)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2, n3 - 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n - 1, n2, n3 + 1)];
        if (!bl5 && !bl4) {
            renderBlocks._x = renderBlocks._N;
            renderBlocks._R = renderBlocks.__ah;
        } else {
            renderBlocks._x = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3 - 1);
            renderBlocks._R = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3 - 1);
        }
        if (!bl6 && !bl4) {
            renderBlocks._z = renderBlocks._P;
            renderBlocks._T = renderBlocks.__aj;
        } else {
            renderBlocks._z = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3 + 1);
            renderBlocks._T = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3 + 1);
        }
        if (!bl5 && !bl3) {
            renderBlocks._F = renderBlocks._N;
            renderBlocks._Z = renderBlocks.__ah;
        } else {
            renderBlocks._F = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3 - 1);
            renderBlocks._Z = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3 - 1);
        }
        if (!bl6 && !bl3) {
            renderBlocks._H = renderBlocks._P;
            renderBlocks.__ab = renderBlocks.__aj;
        } else {
            renderBlocks._H = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3 + 1);
            renderBlocks.__ab = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3 + 1);
        }
        int n5 = n4;
        if (renderBlocks._h <= 0.0 || !renderBlocks._a.isBlockOpaqueCube((n += bl ? 1 : 0) - 1, n2, n3)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n - 1, n2, n3);
        if (bl2) {
            float f2 = (renderBlocks._y + renderBlocks._z + f + renderBlocks._P) / 4.0f;
            float f3 = (f + renderBlocks._P + renderBlocks._G + renderBlocks._H) / 4.0f;
            float f4 = (renderBlocks._N + f + renderBlocks._F + renderBlocks._G) / 4.0f;
            float f5 = (renderBlocks._x + renderBlocks._y + renderBlocks._N + f) / 4.0f;
            this.base_ao[0] = (float)((double)f3 * renderBlocks._k * renderBlocks._m + (double)f4 * renderBlocks._k * (1.0 - renderBlocks._m) + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._m) + (double)f2 * (1.0 - renderBlocks._k) * renderBlocks._m);
            this.base_ao[3] = (float)((double)f3 * renderBlocks._k * renderBlocks._l + (double)f4 * renderBlocks._k * (1.0 - renderBlocks._l) + (double)f5 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._l) + (double)f2 * (1.0 - renderBlocks._k) * renderBlocks._l);
            this.base_ao[2] = (float)((double)f3 * renderBlocks._j * renderBlocks._l + (double)f4 * renderBlocks._j * (1.0 - renderBlocks._l) + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._l) + (double)f2 * (1.0 - renderBlocks._j) * renderBlocks._l);
            this.base_ao[1] = (float)((double)f3 * renderBlocks._j * renderBlocks._m + (double)f4 * renderBlocks._j * (1.0 - renderBlocks._m) + (double)f5 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._m) + (double)f2 * (1.0 - renderBlocks._j) * renderBlocks._m);
            int n6 = renderBlocks._a(renderBlocks._S, renderBlocks._T, renderBlocks.__aj, n5);
            int n7 = renderBlocks._a(renderBlocks.__aj, renderBlocks.__aa, renderBlocks.__ab, n5);
            int n8 = renderBlocks._a(renderBlocks.__ah, renderBlocks._Z, renderBlocks.__aa, n5);
            int n9 = renderBlocks._a(renderBlocks._R, renderBlocks._S, renderBlocks.__ah, n5);
            renderBlocks.__al = renderBlocks._a(n7, n8, n9, n6, renderBlocks._k * renderBlocks._m, renderBlocks._k * (1.0 - renderBlocks._m), (1.0 - renderBlocks._k) * (1.0 - renderBlocks._m), (1.0 - renderBlocks._k) * renderBlocks._m);
            renderBlocks.__am = renderBlocks._a(n7, n8, n9, n6, renderBlocks._k * renderBlocks._l, renderBlocks._k * (1.0 - renderBlocks._l), (1.0 - renderBlocks._k) * (1.0 - renderBlocks._l), (1.0 - renderBlocks._k) * renderBlocks._l);
            renderBlocks.__an = renderBlocks._a(n7, n8, n9, n6, renderBlocks._j * renderBlocks._l, renderBlocks._j * (1.0 - renderBlocks._l), (1.0 - renderBlocks._j) * (1.0 - renderBlocks._l), (1.0 - renderBlocks._j) * renderBlocks._l);
            renderBlocks.__ao = renderBlocks._a(n7, n8, n9, n6, renderBlocks._j * renderBlocks._m, renderBlocks._j * (1.0 - renderBlocks._m), (1.0 - renderBlocks._j) * (1.0 - renderBlocks._m), (1.0 - renderBlocks._j) * renderBlocks._m);
        } else {
            this.base_ao[1] = (renderBlocks._y + renderBlocks._z + f + renderBlocks._P) / 4.0f;
            this.base_ao[0] = (f + renderBlocks._P + renderBlocks._G + renderBlocks._H) / 4.0f;
            this.base_ao[3] = (renderBlocks._N + f + renderBlocks._F + renderBlocks._G) / 4.0f;
            this.base_ao[2] = (renderBlocks._x + renderBlocks._y + renderBlocks._N + f) / 4.0f;
            renderBlocks.__ao = renderBlocks._a(renderBlocks._S, renderBlocks._T, renderBlocks.__aj, n5);
            renderBlocks.__al = renderBlocks._a(renderBlocks.__aj, renderBlocks.__aa, renderBlocks.__ab, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks.__ah, renderBlocks._Z, renderBlocks.__aa, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks._R, renderBlocks._S, renderBlocks.__ah, n5);
        }
    }

    protected void setLightnessXPos(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        boolean bl = renderBlocks._i <= 1.0 && renderBlocks._i > 0.5;
        boolean bl2 = renderBlocks._o;
        renderBlocks._D = block.getAmbientOcclusionLightValue(renderBlocks._a, n += bl ? 1 : 0, n2 - 1, n3);
        renderBlocks._O = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks._Q = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks._K = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3);
        renderBlocks._X = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3);
        renderBlocks.__ai = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1);
        renderBlocks.__ak = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1);
        renderBlocks.__ae = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3);
        boolean bl3 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2 + 1, n3)];
        boolean bl4 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2 - 1, n3)];
        boolean bl5 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2, n3 + 1)];
        boolean bl6 = Block.canBlockGrass[renderBlocks._a.getBlockId(n + 1, n2, n3 - 1)];
        if (!bl4 && !bl6) {
            renderBlocks._C = renderBlocks._O;
            renderBlocks._W = renderBlocks.__ai;
        } else {
            renderBlocks._C = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3 - 1);
            renderBlocks._W = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3 - 1);
        }
        if (!bl4 && !bl5) {
            renderBlocks._E = renderBlocks._Q;
            renderBlocks._Y = renderBlocks.__ak;
        } else {
            renderBlocks._E = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 - 1, n3 + 1);
            renderBlocks._Y = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3 + 1);
        }
        if (!bl3 && !bl6) {
            renderBlocks._J = renderBlocks._O;
            renderBlocks.__ad = renderBlocks.__ai;
        } else {
            renderBlocks._J = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3 - 1);
            renderBlocks.__ad = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3 - 1);
        }
        if (!bl3 && !bl5) {
            renderBlocks._M = renderBlocks._Q;
            renderBlocks.__ag = renderBlocks.__ak;
        } else {
            renderBlocks._M = block.getAmbientOcclusionLightValue(renderBlocks._a, n, n2 + 1, n3 + 1);
            renderBlocks.__ag = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3 + 1);
        }
        int n5 = n4;
        if (renderBlocks._i >= 1.0 || !renderBlocks._a.isBlockOpaqueCube((n -= bl ? 1 : 0) + 1, n2, n3)) {
            n5 = block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3);
        }
        float f = block.getAmbientOcclusionLightValue(renderBlocks._a, n + 1, n2, n3);
        if (bl2) {
            float f2 = (renderBlocks._D + renderBlocks._E + f + renderBlocks._Q) / 4.0f;
            float f3 = (renderBlocks._C + renderBlocks._D + renderBlocks._O + f) / 4.0f;
            float f4 = (renderBlocks._O + f + renderBlocks._J + renderBlocks._K) / 4.0f;
            float f5 = (f + renderBlocks._Q + renderBlocks._K + renderBlocks._M) / 4.0f;
            this.base_ao[0] = (float)((double)f2 * (1.0 - renderBlocks._j) * renderBlocks._m + (double)f3 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._m) + (double)f4 * renderBlocks._j * (1.0 - renderBlocks._m) + (double)f5 * renderBlocks._j * renderBlocks._m);
            this.base_ao[3] = (float)((double)f2 * (1.0 - renderBlocks._j) * renderBlocks._l + (double)f3 * (1.0 - renderBlocks._j) * (1.0 - renderBlocks._l) + (double)f4 * renderBlocks._j * (1.0 - renderBlocks._l) + (double)f5 * renderBlocks._j * renderBlocks._l);
            this.base_ao[2] = (float)((double)f2 * (1.0 - renderBlocks._k) * renderBlocks._l + (double)f3 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._l) + (double)f4 * renderBlocks._k * (1.0 - renderBlocks._l) + (double)f5 * renderBlocks._k * renderBlocks._l);
            this.base_ao[1] = (float)((double)f2 * (1.0 - renderBlocks._k) * renderBlocks._m + (double)f3 * (1.0 - renderBlocks._k) * (1.0 - renderBlocks._m) + (double)f4 * renderBlocks._k * (1.0 - renderBlocks._m) + (double)f5 * renderBlocks._k * renderBlocks._m);
            int n6 = renderBlocks._a(renderBlocks._X, renderBlocks._Y, renderBlocks.__ak, n5);
            int n7 = renderBlocks._a(renderBlocks.__ak, renderBlocks.__ae, renderBlocks.__ag, n5);
            int n8 = renderBlocks._a(renderBlocks.__ai, renderBlocks.__ad, renderBlocks.__ae, n5);
            int n9 = renderBlocks._a(renderBlocks._W, renderBlocks._X, renderBlocks.__ai, n5);
            renderBlocks.__al = renderBlocks._a(n6, n9, n8, n7, (1.0 - renderBlocks._j) * renderBlocks._m, (1.0 - renderBlocks._j) * (1.0 - renderBlocks._m), renderBlocks._j * (1.0 - renderBlocks._m), renderBlocks._j * renderBlocks._m);
            renderBlocks.__am = renderBlocks._a(n6, n9, n8, n7, (1.0 - renderBlocks._j) * renderBlocks._l, (1.0 - renderBlocks._j) * (1.0 - renderBlocks._l), renderBlocks._j * (1.0 - renderBlocks._l), renderBlocks._j * renderBlocks._l);
            renderBlocks.__an = renderBlocks._a(n6, n9, n8, n7, (1.0 - renderBlocks._k) * renderBlocks._l, (1.0 - renderBlocks._k) * (1.0 - renderBlocks._l), renderBlocks._k * (1.0 - renderBlocks._l), renderBlocks._k * renderBlocks._l);
            renderBlocks.__ao = renderBlocks._a(n6, n9, n8, n7, (1.0 - renderBlocks._k) * renderBlocks._m, (1.0 - renderBlocks._k) * (1.0 - renderBlocks._m), renderBlocks._k * (1.0 - renderBlocks._m), renderBlocks._k * renderBlocks._m);
        } else {
            this.base_ao[0] = (renderBlocks._D + renderBlocks._E + f + renderBlocks._Q) / 4.0f;
            this.base_ao[3] = (renderBlocks._C + renderBlocks._D + renderBlocks._O + f) / 4.0f;
            this.base_ao[2] = (renderBlocks._O + f + renderBlocks._J + renderBlocks._K) / 4.0f;
            this.base_ao[1] = (f + renderBlocks._Q + renderBlocks._K + renderBlocks._M) / 4.0f;
            renderBlocks.__al = renderBlocks._a(renderBlocks._X, renderBlocks._Y, renderBlocks.__ak, n5);
            renderBlocks.__ao = renderBlocks._a(renderBlocks.__ak, renderBlocks.__ae, renderBlocks.__ag, n5);
            renderBlocks.__an = renderBlocks._a(renderBlocks.__ai, renderBlocks.__ad, renderBlocks.__ae, n5);
            renderBlocks.__am = renderBlocks._a(renderBlocks._W, renderBlocks._X, renderBlocks.__ai, n5);
        }
    }

    protected boolean renderStandardBlockWithColorMultiplier(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, float f, float f2, float f3) {
        renderBlocks._w = false;
        Tessellator tessellator = renderBlocks.__aF;
        boolean bl = false;
        int n4 = block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3);
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2 - 1, n3, 0) || renderBlocks._j > 0.0) {
            tessellator.setBrightness(renderBlocks._j > 0.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 - 1, n3));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 0, n, n2, n3, 0.5f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2 + 1, n3, 1) || renderBlocks._k < 1.0) {
            tessellator.setBrightness(renderBlocks._k < 1.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n, n2 + 1, n3));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 1, n, n2, n3, 1.0f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 - 1, 2) || renderBlocks._l > 0.0) {
            tessellator.setBrightness(renderBlocks._l > 0.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 - 1));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 2, n, n2, n3, 0.8f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n, n2, n3 + 1, 3) || renderBlocks._m < 1.0) {
            tessellator.setBrightness(renderBlocks._m < 1.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3 + 1));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 3, n, n2, n3, 0.8f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n - 1, n2, n3, 4) || renderBlocks._h > 0.0) {
            tessellator.setBrightness(renderBlocks._h > 0.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n - 1, n2, n3));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 4, n, n2, n3, 0.6f);
            bl = true;
        }
        if (renderBlocks._d || block2.shouldSideBeRendered(renderBlocks._a, n + 1, n2, n3, 5) || renderBlocks._i < 1.0) {
            tessellator.setBrightness(renderBlocks._i < 1.0 ? n4 : block.getMixedBrightnessForBlock(renderBlocks._a, n + 1, n2, n3));
            this.prepareRender(tECarpentersBlock, renderBlocks, block, block2, 5, n, n2, n3, 0.6f);
            bl = true;
        }
        return bl;
    }
}

