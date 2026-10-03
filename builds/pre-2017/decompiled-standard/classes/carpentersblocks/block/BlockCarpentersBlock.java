/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBlock
extends BlockBase {
    public BlockCarpentersBlock(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersBlock");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_111022_d("carpentersblocks:stairs/stairs");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        if (++n > 6) {
            n = 0;
        }
        BlockProperties.setData(tECarpentersBlock, n);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (n2 == 0) {
            switch (n) {
                case 0: {
                    n2 = 4;
                    break;
                }
                case 1: {
                    n2 = 3;
                    break;
                }
                case 2: {
                    n2 = 6;
                    break;
                }
                case 3: {
                    n2 = 5;
                    break;
                }
                case 4: {
                    n2 = 2;
                    break;
                }
                case 5: {
                    n2 = 1;
                }
            }
        } else {
            n2 = 0;
        }
        BlockProperties.setData(tECarpentersBlock, n2);
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        switch (n4) {
            case 1: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                this.func_71905_a(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 3: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                break;
            }
            case 4: {
                this.func_71905_a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                break;
            }
            case 6: {
                this.func_71905_a(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                break;
            }
            default: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        this.func_71902_a(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = 0;
        if (!entityLivingBase.func_70093_af()) {
            TECarpentersBlock tECarpentersBlock2;
            TECarpentersBlock tECarpentersBlock3 = ozlu2.func_72798_a(n, n2 - 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock4 = ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock5 = ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock6 = ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock7 = ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 + 1) : null;
            if (tECarpentersBlock3 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock3);
            } else if (tECarpentersBlock4 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock4);
            } else if (tECarpentersBlock5 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock5);
            } else if (tECarpentersBlock6 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock6);
            } else if (tECarpentersBlock7 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock7);
            } else if (tECarpentersBlock2 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock2);
            }
        }
        BlockProperties.setData(tECarpentersBlock, n4);
    }

    @Override
    public boolean isBlockNormalCube(ozlu ozlu2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        return BlockProperties.getData(tECarpentersBlock) == 0;
    }

    @Override
    public boolean isBlockSolidOnSide(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(ozlu2, n, n2, n3);
        if (tECarpentersBlock == null) {
            return false;
        }
        if (this.isBlockSolid(ozlu2, n, n2, n3)) {
            int n4 = BlockProperties.getData(tECarpentersBlock);
            if (n4 == 0) {
                return true;
            }
            if (n4 == 3 && forgeDirection == ForgeDirection.DOWN) {
                return true;
            }
            if (n4 == 4 && forgeDirection == ForgeDirection.UP) {
                return true;
            }
            if (n4 == 5 && forgeDirection == ForgeDirection.NORTH) {
                return true;
            }
            if (n4 == 6 && forgeDirection == ForgeDirection.SOUTH) {
                return true;
            }
            if (n4 == 1 && forgeDirection == ForgeDirection.WEST) {
                return true;
            }
            if (n4 == 2 && forgeDirection == ForgeDirection.EAST) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean shareFaces(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2, ForgeDirection forgeDirection, ForgeDirection forgeDirection2) {
        if (tECarpentersBlock.func_70311_o() != this) {
            return super.shareFaces(tECarpentersBlock, tECarpentersBlock2, forgeDirection, forgeDirection2);
        }
        twgu twgu2 = twgu.field_71973_m[tECarpentersBlock2.field_70331_k.func_72798_a(tECarpentersBlock2.field_70329_l, tECarpentersBlock2.field_70330_m, tECarpentersBlock2.field_70327_n)];
        this.func_71902_a(tECarpentersBlock2.field_70331_k, tECarpentersBlock2.field_70329_l, tECarpentersBlock2.field_70330_m, tECarpentersBlock2.field_70327_n);
        double[] dArray = new double[]{twgu2.func_83009_v(), twgu2.func_83008_x(), twgu2.func_83005_z(), twgu2.func_83007_w(), twgu2.func_83010_y(), twgu2.func_83006_A()};
        this.func_71902_a(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        switch (NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection2.ordinal()]) {
            case 1: {
                return this.field_72022_cl == 1.0 && dArray[1] == 0.0 && this.field_72026_ch == dArray[0] && this.field_72021_ck == dArray[3] && this.field_72024_cj == dArray[2] && this.field_72019_cm == dArray[5];
            }
            case 2: {
                return this.field_72023_ci == 0.0 && dArray[4] == 1.0 && this.field_72026_ch == dArray[0] && this.field_72021_ck == dArray[3] && this.field_72024_cj == dArray[2] && this.field_72019_cm == dArray[5];
            }
            case 3: {
                return this.field_72019_cm == 1.0 && dArray[2] == 0.0 && this.field_72026_ch == dArray[0] && this.field_72021_ck == dArray[3] && this.field_72023_ci == dArray[1] && this.field_72022_cl == dArray[4];
            }
            case 4: {
                return this.field_72024_cj == 0.0 && dArray[5] == 1.0 && this.field_72026_ch == dArray[0] && this.field_72021_ck == dArray[3] && this.field_72023_ci == dArray[1] && this.field_72022_cl == dArray[4];
            }
            case 5: {
                return this.field_72021_ck == 1.0 && dArray[0] == 0.0 && this.field_72023_ci == dArray[1] && this.field_72022_cl == dArray[4] && this.field_72024_cj == dArray[2] && this.field_72019_cm == dArray[5];
            }
            case 6: {
                return this.field_72026_ch == 0.0 && dArray[3] == 1.0 && this.field_72023_ci == dArray[1] && this.field_72022_cl == dArray[4] && this.field_72024_cj == dArray[2] && this.field_72019_cm == dArray[5];
            }
        }
        return false;
    }

    @Override
    public boolean canCoverSide(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersBlockRenderID;
    }

    static class NamelessClass446984519 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass446984519() {
        }

        static {
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

