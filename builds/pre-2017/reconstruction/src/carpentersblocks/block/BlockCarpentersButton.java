/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Button;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersButton
extends BlockBase {
    public BlockCarpentersButton(int n) {
        super(n, Material._q);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersButton");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTickRandomly(true);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = Button.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.worldObj.isRemote) {
            Button.setPolarity(tECarpentersBlock, n);
            this.notifySideNeighbor(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, Button.getType(n2));
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.polarity_pos.name"));
                    break;
                }
                case 1: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.polarity_neg.name"));
                }
            }
        }
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int tickRate(World world) {
        return 20;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.NORTH && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        n5 &= 7;
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        n5 = forgeDirection == ForgeDirection.NORTH && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : (forgeDirection == ForgeDirection.SOUTH && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (forgeDirection == ForgeDirection.WEST && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (forgeDirection == ForgeDirection.EAST && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : this.getOrientation(world, n, n2, n3))));
        return n5;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        Button.setType(tECarpentersBlock, world.getBlockMetadata(n, n2, n3));
    }

    private int getOrientation(World world, int n, int n2, int n3) {
        return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : (world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : 1)));
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        boolean bl = true;
        if (this.canPlaceBlockAt(world, n, n2, n3)) {
            if (world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 1) {
                bl = false;
            }
            if (world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 2) {
                bl = false;
            }
            if (world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 3) {
                bl = false;
            }
            if (world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 4) {
                bl = false;
            }
        }
        if (bl) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Button.getType(n4);
        float f = this.isDepressed(tECarpentersBlock) ? 0.0625f : 0.125f;
        switch (n5) {
            case 1: {
                this.setBlockBounds(0.0f, 0.375f, 0.3125f, f, 0.625f, 0.6875f);
                break;
            }
            case 2: {
                this.setBlockBounds(1.0f - f, 0.375f, 0.3125f, 1.0f, 0.625f, 0.6875f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.3125f, 0.375f, 0.0f, 0.6875f, 0.625f, f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.3125f, 0.375f, 1.0f - f, 0.6875f, 0.625f, 1.0f);
            }
        }
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        if (!this.isDepressed(tECarpentersBlock)) {
            Button.setState(tECarpentersBlock, 1, true);
            this.notifySideNeighbor(world, n, n2, n3, n6);
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
            return true;
        }
        return false;
    }

    @Override
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = BlockProperties.getData(tECarpentersBlock);
        int n7 = Button.getType(n6);
        if (this.isDepressed(tECarpentersBlock)) {
            this.notifySideNeighbor(world, n, n2, n3, n7);
        }
    }

    private boolean isDepressed(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return Button.getState(n) == 1;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return this.getPowerSupply(tECarpentersBlock, n5);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        return n6 == 5 && n4 == 1 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 4 && n4 == 2 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 3 && n4 == 3 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 2 && n4 == 4 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 1 && n4 == 5 ? this.getPowerSupply(tECarpentersBlock, n5) : 0))));
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = Button.getPolarity(n);
        return this.isDepressed(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = Button.getType(n4);
            Button.setState(tECarpentersBlock, 0, true);
            this.notifySideNeighbor(world, n, n2, n3, n5);
        }
    }

    private void notifySideNeighbor(World world, int n, int n2, int n3, int n4) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        switch (n4) {
            case 1: {
                world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
                break;
            }
            case 2: {
                world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
                break;
            }
            case 3: {
                world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
                break;
            }
            case 4: {
                world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
                break;
            }
            default: {
                world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            }
        }
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersButtonRenderID;
    }
}

