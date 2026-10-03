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
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBed
extends BlockBase {
    public BlockCarpentersBed(int n) {
        super(n, Material._d);
        this.setHardness(0.4f);
        this.setUnlocalizedName("blockCarpentersBed");
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    public boolean isBed(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return false;
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = BedDesignHandler.getPrev(Bed.getDesign(n));
        Bed.setDesign(tECarpentersBlock, n2);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
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
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        if (tECarpentersBlock2 != null) {
            Bed.setDesign(tECarpentersBlock2, n3);
        }
        return true;
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            int n5 = world.getBlockMetadata(n, n2, n3);
            ForgeDirection forgeDirection = Bed.getDirection(n5 & 3);
            if (!this.isBedFoot(world, n, n2, n3) && world.getBlockId(n -= forgeDirection.offsetX, n2, n3 -= forgeDirection.offsetZ) != this.blockID) {
                return true;
            }
            return true;
        }
        return true;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        ForgeDirection forgeDirection = Bed.getDirection(n5 & 3);
        if (this.isBedFoot(world, n, n2, n3)) {
            if (world.getBlockId(n + forgeDirection.offsetX, n2, n3 + forgeDirection.offsetZ) != this.blockID) {
                world.setBlockToAir(n, n2, n3);
            }
        } else if (world.getBlockId(n - forgeDirection.offsetX, n2, n3 - forgeDirection.offsetZ) != this.blockID) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return ItemHandler.itemCarpentersBedID;
    }

    @Override
    public void setBedOccupied(World world, int n, int n2, int n3, EntityPlayer entityPlayer, boolean bl) {
        BlockBed._a(world, n, n2, n3, bl);
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(world, n, n2, n3);
        Bed.setOccupied(tECarpentersBlock, bl);
        if (tECarpentersBlock2 != null) {
            Bed.setOccupied(tECarpentersBlock2, bl);
        }
    }

    private boolean isBedOccupied(World world, int n, int n2, int n3) {
        return (world.getBlockMetadata(n, n2, n3) & 8) != 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return ItemHandler.itemCarpentersBedID;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersBedRenderID;
    }
}

