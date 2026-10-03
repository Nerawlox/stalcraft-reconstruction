/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Bed;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BedDesignHandler;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBed
extends BlockBase {
    public BlockCarpentersBed(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.4f);
        this.func_71864_b("blockCarpentersBed");
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    public boolean isBed(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return false;
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = BedDesignHandler.getPrev(Bed.getDesign(n));
        Bed.setDesign(tECarpentersBlock, n2);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        if (tECarpentersBlock2 != null) {
            Bed.setDesign(tECarpentersBlock2, n2);
        }
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = BedDesignHandler.getNext(Bed.getDesign(n2));
        Bed.setDesign(tECarpentersBlock, n3);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        if (tECarpentersBlock2 != null) {
            Bed.setDesign(tECarpentersBlock2, n3);
        }
        return true;
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            ForgeDirection forgeDirection = Bed.getDirection(n5 & 3);
            if (!this.isBedFoot(ozlu2, n, n2, n3) && ozlu2.func_72798_a(n -= forgeDirection.offsetX, n2, n3 -= forgeDirection.offsetZ) != this.field_71990_ca) {
                return true;
            }
            return true;
        }
        return true;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        ForgeDirection forgeDirection = Bed.getDirection(n5 & 3);
        if (this.isBedFoot(ozlu2, n, n2, n3)) {
            if (ozlu2.func_72798_a(n + forgeDirection.offsetX, n2, n3 + forgeDirection.offsetZ) != this.field_71990_ca) {
                ozlu2.func_94571_i(n, n2, n3);
            }
        } else if (ozlu2.func_72798_a(n - forgeDirection.offsetX, n2, n3 - forgeDirection.offsetZ) != this.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return ItemHandler.itemCarpentersBedID;
    }

    @Override
    public void setBedOccupied(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, boolean bl) {
        gqbt._a(ozlu2, n, n2, n3, bl);
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(ozlu2, n, n2, n3);
        Bed.setOccupied(tECarpentersBlock, bl);
        if (tECarpentersBlock2 != null) {
            Bed.setOccupied(tECarpentersBlock2, bl);
        }
    }

    private boolean isBedOccupied(ozlu ozlu2, int n, int n2, int n3) {
        return (ozlu2.func_72805_g(n, n2, n3) & 8) != 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return ItemHandler.itemCarpentersBedID;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersBedRenderID;
    }
}

