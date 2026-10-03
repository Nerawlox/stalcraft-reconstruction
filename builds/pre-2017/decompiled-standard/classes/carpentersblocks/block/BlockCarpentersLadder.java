/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersLadder
extends BlockBase {
    public BlockCarpentersLadder(int n) {
        super(n, tflj._d);
        this.func_71848_c(twgu.field_72055_aF.field_71989_cb);
        this.func_71864_b("blockCarpentersLadder");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_71884_a(twgu.field_82507_n);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        float[] fArray;
        sdrg2.func_72796_p(n, n2, n3);
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        switch (n4) {
            case 0: {
                fArray = new float[]{0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f};
                break;
            }
            default: {
                fArray = new float[]{0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f};
                break;
            }
            case 2: {
                fArray = new float[]{0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f};
                break;
            }
            case 3: {
                fArray = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f};
                break;
            }
            case 4: {
                fArray = new float[]{0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
                break;
            }
            case 5: {
                fArray = new float[]{0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f};
            }
        }
        this.func_71905_a(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this.func_71902_a(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        switch (NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.getOrientation(n4).ordinal()]) {
            case 1: {
                return ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.SOUTH);
            }
            case 2: {
                return ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.NORTH);
            }
            case 3: {
                return ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.EAST);
            }
            case 4: {
                return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.WEST);
            }
        }
        return true;
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        return n4;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (ozlu2.func_72805_g(n, n2, n3) < 2) {
            if (ozlu2.func_72798_a(n, n2 - 1, n3) == this.field_71990_ca) {
                ozlu2.func_72921_c(n, n2, n3, ozlu2.func_72805_g(n, n2 - 1, n3), 2);
            } else if (ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca) {
                ozlu2.func_72921_c(n, n2, n3, ozlu2.func_72805_g(n, n2 + 1, n3), 2);
            } else {
                int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
                ozlu2.func_72921_c(n, n2, n3, n4 % 2 == 0 ? 0 : 1, 2);
            }
        }
        this.func_71863_a(ozlu2, n, n2, n3, this.field_71990_ca);
    }

    @Override
    public void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (n5 > 1 && (n5 == 2 && !ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || n5 == 3 && !ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || n5 == 4 && !ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || n5 == 5 && !ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST))) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public boolean isLadder(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayer) || ((EntityPlayer)entityLivingBase).field_71075_bZ._d;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersLadderRenderID;
    }

    static class NamelessClass1349103133 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass1349103133() {
        }

        static {
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

