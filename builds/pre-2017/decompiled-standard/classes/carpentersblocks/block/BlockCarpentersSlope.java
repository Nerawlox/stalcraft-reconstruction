/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.SlopeBlock;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Slope;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersSlope
extends BlockBase
implements SlopeBlock {
    static final float[] tempBounds = new float[6];

    public BlockCarpentersSlope(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersSlope");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_111022_d("carpentersblocks:slope/slope");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n];
        switch (slope.slopeType.ordinal() + 1) {
            case 1: {
                if (++n <= 3) break;
                n = 0;
                break;
            }
            case 2: {
                if (slope.isPositive) {
                    if (++n <= 11) break;
                    n = 8;
                    break;
                }
                if (++n <= 7) break;
                n = 4;
                break;
            }
            case 3: {
                if (slope.isPositive) {
                    if ((n += 2) <= 18) break;
                    n = 12;
                    break;
                }
                if ((n += 2) <= 19) break;
                n = 13;
                break;
            }
            case 4: {
                if (slope.isPositive) {
                    if ((n += 2) <= 26) break;
                    n = 20;
                    break;
                }
                if ((n += 2) <= 27) break;
                n = 21;
                break;
            }
            case 5: {
                if (slope.isPositive) {
                    if ((n += 2) <= 34) break;
                    n = 28;
                    break;
                }
                if ((n += 2) <= 35) break;
                n = 29;
                break;
            }
            case 6: {
                if (slope.isPositive) {
                    if ((n += 2) <= 42) break;
                    n = 36;
                    break;
                }
                if ((n += 2) <= 43) break;
                n = 37;
                break;
            }
            case 7: {
                n = slope.equals(Slope.PYR_HALF_POS) ? Slope.PYR_HALF_NEG.slopeID : Slope.PYR_HALF_POS.slopeID;
            }
        }
        BlockProperties.setData(tECarpentersBlock, n);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n2];
        switch (slope.slopeType.ordinal() + 1) {
            case 1: {
                n2 = 8;
                break;
            }
            case 2: {
                if (slope.isPositive) {
                    n2 -= 4;
                    break;
                }
                n2 = 12;
                break;
            }
            case 3: {
                if (slope.isPositive) {
                    ++n2;
                    break;
                }
                if (n2 != 13 && n2 != 15) {
                    n2 += 3;
                    break;
                }
                n2 += 11;
                break;
            }
            case 4: {
                if (slope.isPositive) {
                    ++n2;
                    break;
                }
                if (n2 != 21 && n2 != 23) {
                    n2 += 3;
                    break;
                }
                n2 += 11;
                break;
            }
            case 5: {
                if (slope.isPositive) {
                    ++n2;
                    break;
                }
                if (n2 != 29 && n2 != 31) {
                    n2 += 3;
                    break;
                }
                n2 += 11;
                break;
            }
            case 6: {
                if (slope.isPositive) {
                    ++n2;
                    break;
                }
                n2 = 44;
                break;
            }
            case 7: {
                n2 = 0;
            }
        }
        BlockProperties.setData(tECarpentersBlock, n2);
        return true;
    }

    public static float[] getTempBounds(float f, float f2, float f3, float f4, float f5, float f6) {
        BlockCarpentersSlope.tempBounds[0] = f;
        BlockCarpentersSlope.tempBounds[1] = f2;
        BlockCarpentersSlope.tempBounds[2] = f3;
        BlockCarpentersSlope.tempBounds[3] = f4;
        BlockCarpentersSlope.tempBounds[4] = f5;
        BlockCarpentersSlope.tempBounds[5] = f6;
        return tempBounds;
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        hank hank2 = null;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        int n5 = this.getNumBoxesPerPass(slope);
        int n6 = this.getNumPasses(slope);
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < n6 && hank2 == null; ++i) {
            for (int j = 0; j < n5 && hank2 == null; ++j) {
                float[] fArray = this.genBounds(slope, j, n5, i);
                this.func_71905_a(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
                hank hank3 = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
                if (hank3 == null || !((d = hank3._h._e(ofbx3)) > d2)) continue;
                hank2 = hank3;
                d2 = d;
            }
            if (!slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) continue;
            --n5;
        }
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (hank2 != null) {
            hank2 = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
        }
        return hank2;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Slope slope = Slope.slopesList[n4];
        this.addSlopeCollision(slope, n, n2, n3, list2);
    }

    @Override
    public boolean isBlockSolidOnSide(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(ozlu2, n, n2, n3);
        if (tECarpentersBlock == null) {
            return false;
        }
        return this.isBlockSolid(ozlu2, n, n2, n3) ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock)].isFaceFull(forgeDirection) : false;
    }

    @Override
    protected boolean shareFaces(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2, ForgeDirection forgeDirection, ForgeDirection forgeDirection2) {
        if (tECarpentersBlock.func_70311_o() == this) {
            Slope slope = Slope.slopesList[BlockProperties.getData(tECarpentersBlock2)];
            Slope slope2 = Slope.slopesList[BlockProperties.getData(tECarpentersBlock)];
            return !slope2.hasSide(forgeDirection) ? false : slope.wedgeOrientation(forgeDirection2) == slope2.wedgeOrientation(forgeDirection);
        }
        return super.shareFaces(tECarpentersBlock, tECarpentersBlock2, forgeDirection, forgeDirection2);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        switch (n4) {
            case 2: {
                f = 1.0f - f;
            }
            default: {
                break;
            }
            case 4: {
                f = f3;
                break;
            }
            case 5: {
                f = 1.0f - f3;
            }
        }
        return n4 > 1 ? (f2 > 0.5f && f > 1.0f - f2 && f < f2 ? n4 + 2 : (f2 < 0.5f && f < 1.0f - f2 && f > f2 ? n4 + 6 : (f < 0.2f ? (n4 == 2 ? 1 : (n4 == 3 ? 0 : (n4 == 4 ? 3 : 2))) : (f > 0.8f ? (n4 == 2 ? 2 : (n4 == 3 ? 3 : (n4 == 4 ? 1 : 0))) : (f2 > 0.5f ? n4 + 2 : n4 + 6))))) : n4 + 12;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        BlockProperties.setData(tECarpentersBlock, ozlu2.func_72805_g(n, n2, n3));
        int n5 = BlockProperties.getData(tECarpentersBlock);
        if (n5 > 11) {
            switch (n4) {
                case 0: {
                    n5 = n5 == 12 ? 4 : 8;
                    break;
                }
                case 1: {
                    n5 = n5 == 12 ? 7 : 11;
                    break;
                }
                case 2: {
                    n5 = n5 == 12 ? 5 : 9;
                    break;
                }
                case 3: {
                    int n6 = n5 = n5 == 12 ? 6 : 10;
                }
            }
        }
        if (!entityLivingBase.func_70093_af()) {
            Slope slope;
            Slope slope2 = Slope.slopesList[n5];
            TECarpentersBlock tECarpentersBlock2 = ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock3 = ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock4 = ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock5 = ozlu2.func_72798_a(n, n2 - 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock6 = ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock7 = ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 + 1) : null;
            TECarpentersBlock tECarpentersBlock8 = ozlu2.func_72798_a(n - 1, n2 - 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock9 = ozlu2.func_72798_a(n + 1, n2 - 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock10 = ozlu2.func_72798_a(n, n2 - 1, n3 - 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 - 1, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock11 = ozlu2.func_72798_a(n, n2 - 1, n3 + 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 - 1, n3 + 1) : null;
            TECarpentersBlock tECarpentersBlock12 = ozlu2.func_72798_a(n - 1, n2 + 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock13 = ozlu2.func_72798_a(n + 1, n2 + 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock14 = ozlu2.func_72798_a(n, n2 + 1, n3 - 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock15 = ozlu2.func_72798_a(n, n2 + 1, n3 + 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3 + 1) : null;
            Slope slope3 = tECarpentersBlock2 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock2)] : (Slope)null;
            Slope slope4 = tECarpentersBlock3 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock3)] : (Slope)null;
            Slope slope5 = tECarpentersBlock6 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock6)] : (Slope)null;
            Slope slope6 = tECarpentersBlock7 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock7)] : (Slope)null;
            Slope slope7 = tECarpentersBlock4 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock4)] : (Slope)null;
            Slope slope8 = tECarpentersBlock5 != null ? Slope.slopesList[BlockProperties.getData(tECarpentersBlock5)] : (Slope)null;
            Slope slope9 = tECarpentersBlock2 != null ? slope3 : (Slope)null;
            Slope slope10 = tECarpentersBlock3 != null ? slope4 : (Slope)null;
            Slope slope11 = tECarpentersBlock4 != null ? slope7 : (Slope)null;
            Slope slope12 = tECarpentersBlock5 != null ? slope8 : (Slope)null;
            Slope slope13 = tECarpentersBlock6 != null ? slope5 : (Slope)null;
            Slope slope14 = slope = tECarpentersBlock7 != null ? slope6 : (Slope)null;
            if (slope2.slopeType.equals((Object)Slope.SlopeType.WEDGE_Y)) {
                if (tECarpentersBlock2 != null) {
                    if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
                        if (slope3.facings.contains((Object)ForgeDirection.SOUTH) && !slope3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n7 = n5 = slope3.isPositive ? 16 : 17;
                        }
                        if (slope3.facings.contains((Object)ForgeDirection.NORTH) && !slope3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n8 = n5 = slope3.isPositive ? 14 : 15;
                        }
                    }
                    if (slope2.facings.contains((Object)ForgeDirection.EAST)) {
                        if (slope3.facings.contains((Object)ForgeDirection.SOUTH) && !slope3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n9 = n5 = slope3.isPositive ? 22 : 23;
                        }
                        if (slope3.facings.contains((Object)ForgeDirection.NORTH) && !slope3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n10 = n5 = slope3.isPositive ? 24 : 25;
                        }
                    }
                }
                if (tECarpentersBlock3 != null) {
                    if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
                        if (slope4.facings.contains((Object)ForgeDirection.SOUTH) && !slope4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n11 = n5 = slope4.isPositive ? 20 : 21;
                        }
                        if (slope4.facings.contains((Object)ForgeDirection.NORTH) && !slope4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n12 = n5 = slope4.isPositive ? 26 : 27;
                        }
                    }
                    if (slope2.facings.contains((Object)ForgeDirection.EAST)) {
                        if (slope4.facings.contains((Object)ForgeDirection.SOUTH) && !slope4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n13 = n5 = slope4.isPositive ? 18 : 19;
                        }
                        if (slope4.facings.contains((Object)ForgeDirection.NORTH) && !slope4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n14 = n5 = slope4.isPositive ? 12 : 13;
                        }
                    }
                }
                if (tECarpentersBlock6 != null) {
                    if (slope2.facings.contains((Object)ForgeDirection.NORTH)) {
                        if (slope5.facings.contains((Object)ForgeDirection.EAST) && !slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n15 = n5 = slope5.isPositive ? 12 : 13;
                        }
                        if (slope5.facings.contains((Object)ForgeDirection.WEST) && !slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n16 = n5 = slope5.isPositive ? 14 : 15;
                        }
                    }
                    if (slope2.facings.contains((Object)ForgeDirection.SOUTH)) {
                        if (slope5.facings.contains((Object)ForgeDirection.EAST) && !slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n17 = n5 = slope5.isPositive ? 22 : 23;
                        }
                        if (slope5.facings.contains((Object)ForgeDirection.WEST) && !slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n18 = n5 = slope5.isPositive ? 20 : 21;
                        }
                    }
                }
                if (tECarpentersBlock7 != null) {
                    if (slope2.facings.contains((Object)ForgeDirection.NORTH)) {
                        if (slope6.facings.contains((Object)ForgeDirection.EAST) && !slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n19 = n5 = slope6.isPositive ? 24 : 25;
                        }
                        if (slope6.facings.contains((Object)ForgeDirection.WEST) && !slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n20 = n5 = slope6.isPositive ? 26 : 27;
                        }
                    }
                    if (slope2.facings.contains((Object)ForgeDirection.SOUTH)) {
                        if (slope6.facings.contains((Object)ForgeDirection.EAST) && !slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n21 = n5 = slope6.isPositive ? 18 : 19;
                        }
                        if (slope6.facings.contains((Object)ForgeDirection.WEST) && !slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n22 = n5 = slope6.isPositive ? 16 : 17;
                        }
                    }
                }
            }
            if (tECarpentersBlock6 != null) {
                if (tECarpentersBlock3 != null) {
                    if (slope5.facings.contains((Object)ForgeDirection.EAST) && slope4.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n23 = n5 = slope4.isPositive && slope5.isPositive ? 12 : 13;
                    }
                    if (slope5.facings.contains((Object)ForgeDirection.WEST) && slope4.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n24 = n5 = slope4.isPositive && slope5.isPositive ? 20 : 21;
                    }
                }
                if (tECarpentersBlock2 != null) {
                    if (slope5.facings.contains((Object)ForgeDirection.WEST) && slope3.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n25 = n5 = slope3.isPositive && slope5.isPositive ? 14 : 15;
                    }
                    if (slope5.facings.contains((Object)ForgeDirection.EAST) && slope3.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n26 = n5 = slope3.isPositive && slope5.isPositive ? 22 : 23;
                    }
                }
            }
            if (tECarpentersBlock7 != null) {
                if (tECarpentersBlock2 != null) {
                    if (slope6.facings.contains((Object)ForgeDirection.WEST) && slope3.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n27 = n5 = slope3.isPositive && slope6.isPositive ? 16 : 17;
                    }
                    if (slope6.facings.contains((Object)ForgeDirection.EAST) && slope3.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n28 = n5 = slope3.isPositive && slope6.isPositive ? 24 : 25;
                    }
                }
                if (tECarpentersBlock3 != null) {
                    if (slope6.facings.contains((Object)ForgeDirection.EAST) && slope4.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n29 = n5 = slope4.isPositive && slope6.isPositive ? 18 : 19;
                    }
                    if (slope6.facings.contains((Object)ForgeDirection.WEST) && slope4.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n30 = n5 = slope4.isPositive && slope6.isPositive ? 26 : 27;
                    }
                }
            }
            if (slope2.facings.contains((Object)ForgeDirection.WEST)) {
                if (tECarpentersBlock6 != null && slope2.isPositive == slope5.isPositive) {
                    if (slope5.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock6, slope2.isPositive ? 26 : 27);
                    }
                    if (slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock6, slope2.isPositive ? 16 : 17);
                    }
                }
                if (tECarpentersBlock7 != null && slope2.isPositive == slope6.isPositive) {
                    if (slope6.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock7, slope2.isPositive ? 20 : 21);
                    }
                    if (slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock7, slope2.isPositive ? 14 : 15);
                    }
                }
            }
            if (slope2.facings.contains((Object)ForgeDirection.EAST)) {
                if (tECarpentersBlock6 != null && slope2.isPositive && slope5.isPositive) {
                    if (slope5.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock6, slope2.isPositive ? 24 : 25);
                    }
                    if (slope5.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock6, slope2.isPositive ? 18 : 19);
                    }
                }
                if (tECarpentersBlock7 != null && slope2.isPositive && slope6.isPositive) {
                    if (slope6.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock7, slope2.isPositive ? 22 : 23);
                    }
                    if (slope6.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock7, slope2.isPositive ? 12 : 13);
                    }
                }
            }
            if (slope2.facings.contains((Object)ForgeDirection.NORTH)) {
                if (tECarpentersBlock2 != null && slope2.isPositive && slope3.isPositive) {
                    if (slope3.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock2, slope2.isPositive ? 26 : 27);
                    }
                    if (slope3.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock2, slope2.isPositive ? 12 : 13);
                    }
                }
                if (tECarpentersBlock3 != null && slope2.isPositive && slope4.isPositive) {
                    if (slope4.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock3, slope2.isPositive ? 24 : 25);
                    }
                    if (slope4.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock3, slope2.isPositive ? 14 : 15);
                    }
                }
            }
            if (slope2.facings.contains((Object)ForgeDirection.SOUTH)) {
                if (tECarpentersBlock2 != null && slope2.isPositive && slope3.isPositive) {
                    if (slope3.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock2, slope2.isPositive ? 20 : 21);
                    }
                    if (slope3.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock2, slope2.isPositive ? 18 : 19);
                    }
                }
                if (tECarpentersBlock3 != null && slope2.isPositive && slope4.isPositive) {
                    if (slope4.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock3, slope2.isPositive ? 22 : 23);
                    }
                    if (slope4.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock3, slope2.isPositive ? 16 : 17);
                    }
                }
            }
            if (tECarpentersBlock8 != null && tECarpentersBlock9 != null && tECarpentersBlock10 != null && tECarpentersBlock11 != null && Slope.slopesList[BlockProperties.getData(tECarpentersBlock8)] == Slope.WEDGE_POS_W && Slope.slopesList[BlockProperties.getData(tECarpentersBlock9)] == Slope.WEDGE_POS_E && Slope.slopesList[BlockProperties.getData(tECarpentersBlock10)] == Slope.WEDGE_POS_N && Slope.slopesList[BlockProperties.getData(tECarpentersBlock11)] == Slope.WEDGE_POS_S) {
                n5 = 44;
            }
            if (tECarpentersBlock12 != null && tECarpentersBlock13 != null && tECarpentersBlock14 != null && tECarpentersBlock15 != null && Slope.slopesList[BlockProperties.getData(tECarpentersBlock12)] == Slope.WEDGE_NEG_W && Slope.slopesList[BlockProperties.getData(tECarpentersBlock13)] == Slope.WEDGE_NEG_E && Slope.slopesList[BlockProperties.getData(tECarpentersBlock14)] == Slope.WEDGE_NEG_N && Slope.slopesList[BlockProperties.getData(tECarpentersBlock15)] == Slope.WEDGE_NEG_S) {
                n5 = 45;
            }
            if (tECarpentersBlock4 != null) {
                if (slope7 == Slope.WEDGE_INT_NEG_NW) {
                    n5 = 1;
                    BlockProperties.setData(tECarpentersBlock4, 31);
                } else if (slope7 == Slope.WEDGE_INT_NEG_SW) {
                    n5 = 3;
                    BlockProperties.setData(tECarpentersBlock4, 33);
                } else if (slope7 == Slope.WEDGE_INT_NEG_NE) {
                    n5 = 2;
                    BlockProperties.setData(tECarpentersBlock4, 29);
                } else if (slope7 == Slope.WEDGE_INT_NEG_SE) {
                    n5 = 0;
                    BlockProperties.setData(tECarpentersBlock4, 35);
                }
            }
            if (tECarpentersBlock5 != null) {
                if (slope8 == Slope.WEDGE_INT_POS_NW) {
                    n5 = 1;
                    BlockProperties.setData(tECarpentersBlock5, 30);
                } else if (slope8 == Slope.WEDGE_INT_POS_SW) {
                    n5 = 3;
                    BlockProperties.setData(tECarpentersBlock5, 32);
                } else if (slope8 == Slope.WEDGE_INT_POS_NE) {
                    n5 = 2;
                    BlockProperties.setData(tECarpentersBlock5, 28);
                } else if (slope8 == Slope.WEDGE_INT_POS_SE) {
                    n5 = 0;
                    BlockProperties.setData(tECarpentersBlock5, 34);
                }
            }
            if (tECarpentersBlock4 != null) {
                if (slope7.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ)) {
                    n5 = slope7.slopeID;
                } else if (slope7.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_INT)) {
                    switch (slope7.slopeID) {
                        case 29: {
                            n5 = 2;
                            break;
                        }
                        default: {
                            n5 = 0;
                            break;
                        }
                        case 31: {
                            n5 = 1;
                            break;
                        }
                        case 33: {
                            n5 = 3;
                        }
                    }
                }
            }
            if (tECarpentersBlock5 != null) {
                if (slope8.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ)) {
                    n5 = slope8.slopeID;
                } else if (slope8.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_INT)) {
                    switch (slope8.slopeID) {
                        case 28: {
                            n5 = 2;
                            break;
                        }
                        default: {
                            n5 = 0;
                            break;
                        }
                        case 30: {
                            n5 = 1;
                            break;
                        }
                        case 32: {
                            n5 = 3;
                        }
                    }
                }
            }
            if (tECarpentersBlock4 != null && (slope7.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT) || slope7.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ)) || tECarpentersBlock5 != null && (slope8.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT) || slope8.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ))) {
                if (tECarpentersBlock3 != null && tECarpentersBlock6 != null) {
                    if (slope4.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope5.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope4.isPositive == slope5.isPositive && slope4.facings.contains((Object)ForgeDirection.SOUTH) && slope5.facings.contains((Object)ForgeDirection.WEST)) {
                        n5 = slope4.isPositive ? 36 : 37;
                    }
                } else if (tECarpentersBlock6 != null && tECarpentersBlock2 != null) {
                    if (slope5.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope3.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope5.isPositive == slope3.isPositive && slope5.facings.contains((Object)ForgeDirection.EAST) && slope3.facings.contains((Object)ForgeDirection.SOUTH)) {
                        n5 = slope5.isPositive ? 38 : 39;
                    }
                } else if (tECarpentersBlock2 != null && tECarpentersBlock7 != null) {
                    if (slope3.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope6.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope3.isPositive == slope6.isPositive && slope3.facings.contains((Object)ForgeDirection.NORTH) && slope6.facings.contains((Object)ForgeDirection.EAST)) {
                        n5 = slope3.isPositive ? 40 : 41;
                    }
                } else if (tECarpentersBlock7 != null && tECarpentersBlock3 != null && slope6.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope4.slopeType.equals((Object)Slope.SlopeType.WEDGE_XZ) && slope6.isPositive == slope4.isPositive && slope6.facings.contains((Object)ForgeDirection.WEST) && slope4.facings.contains((Object)ForgeDirection.NORTH)) {
                    int n31 = n5 = slope6.isPositive ? 42 : 43;
                }
            }
            if (!ozlu2.field_72995_K) {
                if (tECarpentersBlock2 != null && slope3 != slope9) {
                    BlockProperties.setData(tECarpentersBlock2, slope3.slopeID);
                }
                if (tECarpentersBlock3 != null && slope4 != slope10) {
                    BlockProperties.setData(tECarpentersBlock3, slope4.slopeID);
                }
                if (tECarpentersBlock6 != null && slope5 != slope13) {
                    BlockProperties.setData(tECarpentersBlock6, slope5.slopeID);
                }
                if (tECarpentersBlock7 != null && slope6 != slope) {
                    BlockProperties.setData(tECarpentersBlock7, slope6.slopeID);
                }
                if (tECarpentersBlock5 != null && slope8 != slope12) {
                    BlockProperties.setData(tECarpentersBlock5, slope8.slopeID);
                }
                if (tECarpentersBlock4 != null && slope7 != slope11) {
                    BlockProperties.setData(tECarpentersBlock4, slope7.slopeID);
                }
            }
        }
        BlockProperties.setData(tECarpentersBlock, n5);
    }

    @Override
    public boolean canCoverSide(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        return this.isBlockSolidOnSide(ozlu2, n, n2, n3, ForgeDirection.getOrientation(n4));
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersSlopeRenderID;
    }
}

