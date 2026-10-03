/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Lever;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersLever
extends BlockBase {
    public BlockCarpentersLever(int n) {
        super(n, Material._q);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersLever");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:lever/lever");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = Lever.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.worldObj.isRemote) {
            Lever.setPolarity(tECarpentersBlock, n);
            this.notifySideNeighbor(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, Lever.getType(n2));
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
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.DOWN && world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) || forgeDirection == ForgeDirection.UP && world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || forgeDirection == ForgeDirection.NORTH && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = -1;
        if (n4 == 0 && world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            n6 = 0;
        }
        if (n4 == 1 && world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP)) {
            n6 = 5;
        }
        if (n4 == 2 && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n6 = 4;
        }
        if (n4 == 3 && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n6 = 3;
        }
        if (n4 == 4 && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n6 = 2;
        }
        if (n4 == 5 && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n6 = 1;
        }
        return n6;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        BlockProperties.setData(tECarpentersBlock, world.getBlockMetadata(n, n2, n3));
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Lever.getType(n4);
        if (n5 == BlockCarpentersLever.invertType(1)) {
            if ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                Lever.setType(tECarpentersBlock, 5);
            } else {
                Lever.setType(tECarpentersBlock, 6);
            }
        } else if (n5 == BlockCarpentersLever.invertType(0)) {
            if ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                Lever.setType(tECarpentersBlock, 7);
            } else {
                Lever.setType(tECarpentersBlock, 0);
            }
        }
    }

    public static int invertType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        if (this.checkIfAttachedToBlock(world, n, n2, n3)) {
            boolean bl;
            int n5 = BlockProperties.getData(tECarpentersBlock);
            int n6 = Lever.getType(n5);
            boolean bl2 = bl = !world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 1 || !world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 2 || !world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 3 || !world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 4 || !world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n6 == 5 || !world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n6 == 6 || !world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n6 == 0 || !world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n6 == 7;
            if (bl) {
                world.setBlockToAir(n, n2, n3);
            }
        }
    }

    private boolean checkIfAttachedToBlock(World world, int n, int n2, int n3) {
        if (!this.canPlaceBlockAt(world, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = Lever.getType(n4);
            world.setBlockToAir(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Lever.getType(n4);
        float f = 0.1875f;
        switch (n5) {
            case 0: {
                f = 0.25f;
                this.setBlockBounds(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
                break;
            }
            case 1: {
                this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
                break;
            }
            case 2: {
                this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
                break;
            }
            default: {
                f = 0.25f;
                this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
                break;
            }
            case 7: {
                f = 0.25f;
                this.setBlockBounds(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
            }
        }
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Lever.getType(n5);
        Lever.setState(tECarpentersBlock, this.isActive(tECarpentersBlock) ? 0 : 1, true);
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        switch (n6) {
            case 0: {
                world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
                break;
            }
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
                break;
            }
            case 7: {
                world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            }
        }
        return true;
    }

    private boolean isActive(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return Lever.getState(n) == 1;
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
        int n6 = Lever.getType(n5);
        return !(n6 == 0 && n4 == 0 || n6 == 7 && n4 == 0 || n6 == 6 && n4 == 1 || n6 == 5 && n4 == 1 || n6 == 4 && n4 == 2 || n6 == 3 && n4 == 3 || n6 == 2 && n4 == 4 || n6 == 1 && n4 == 5) ? 0 : this.getPowerSupply(tECarpentersBlock, n5);
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = Lever.getPolarity(n);
        return this.isActive(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    private void notifySideNeighbor(World world, int n, int n2, int n3, int n4) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        switch (n4) {
            case 0: {
                world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
                break;
            }
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
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4, int n5) {
        if (this.isActive(tECarpentersBlock)) {
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            int n6 = BlockProperties.getData(tECarpentersBlock);
            int n7 = Lever.getType(n6);
            switch (n7) {
                case 0: {
                    world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
                    break;
                }
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
                    break;
                }
                case 7: {
                    world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
                }
            }
        }
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersLeverRenderID;
    }
}

