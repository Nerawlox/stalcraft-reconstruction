/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Barrier;
import carpentersblocks.data.Gate;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpentersGate
extends BlockBase {
    public BlockCarpentersGate(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersGate");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = Gate.getType(n2);
        if (entityPlayer.isSneaking()) {
            if (n3 <= 3 && ++n3 > 3) {
                n3 = 0;
            }
        } else if (n3 <= 3) {
            n3 = 4;
        } else if (++n3 > 6) {
            n3 = 0;
        }
        Gate.setType(tECarpentersBlock, n3);
        return true;
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        if (Gate.getState(n5) == 1) {
            Gate.setState(tECarpentersBlock, 0, true);
            this.cycleNeighborGate(world, BlockProperties.getData(tECarpentersBlock), n, n2, n3);
        } else {
            int n6 = (sajh._c((double)(entityPlayer.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) % 4;
            Gate.setState(tECarpentersBlock, 1, true);
            if (Gate.getFacing(n5) == 0) {
                Gate.setDirOpen(tECarpentersBlock, n6 == 0 ? 0 : 1);
            } else {
                Gate.setDirOpen(tECarpentersBlock, n6 == 3 ? 0 : 1);
            }
            this.cycleNeighborGate(world, BlockProperties.getData(tECarpentersBlock), n, n2, n3);
        }
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return !world.getBlockMaterial(n, n2 - 1, n3)._a() ? false : super.canPlaceBlockAt(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock;
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock = world.getBlockId(n, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3) : null;
        if (tECarpentersBlock == null) {
            return null;
        }
        int n4 = BlockProperties.getData(tECarpentersBlock);
        return Gate.getState(n4) == 1 ? null : (Gate.getFacing(n4) == 1 ? (Gate.getType(n4) != 0 && Gate.getType(n4) != 6 ? AxisAlignedBB._a()._a((float)n + 0.375f, n2, n3, (float)n + 0.625f, (float)n2 + 1.5f, (float)n3 + 1.0f) : AxisAlignedBB._a()._a((float)n + 0.4375f, n2, n3, (float)n + 0.5625f, (float)n2 + 1.5f, (float)n3 + 1.0f)) : (Gate.getType(n4) != 0 && Gate.getType(n4) != 6 ? AxisAlignedBB._a()._a(n, n2, (float)n3 + 0.375f, (float)n + 1.0f, (float)n2 + 1.5f, (float)n3 + 0.625f) : AxisAlignedBB._a()._a(n, n2, (float)n3 + 0.4375f, (float)n + 1.0f, (float)n2 + 1.5f, (float)n3 + 0.5625f)));
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        if (Gate.getFacing(n4) == 1) {
            if (Gate.getType(n4) != 0 && Gate.getType(n4) != 6) {
                this.setBlockBounds(0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f);
            } else {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            }
        } else if (Gate.getType(n4) != 0 && Gate.getType(n4) != 6) {
            this.setBlockBounds(0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
        }
    }

    private void cycleNeighborGate(World world, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock;
        boolean bl;
        boolean bl2 = world.getBlockId(n2, n3 - 1, n4) == this.blockID;
        boolean bl3 = bl = world.getBlockId(n2, n3 + 1, n4) == this.blockID;
        if (bl2) {
            TECarpentersBlock tECarpentersBlock2 = (TECarpentersBlock)world.getBlockTileEntity(n2, n3 - 1, n4);
            if (Gate.getFacing(BlockProperties.getData(tECarpentersBlock2)) == Gate.getFacing(n)) {
                Gate.setDirOpen(tECarpentersBlock2, Gate.getDirOpen(n));
                Gate.setState(tECarpentersBlock2, Gate.getState(n), false);
            }
        } else if (bl && Gate.getFacing(BlockProperties.getData(tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n2, n3 + 1, n4))) == Gate.getFacing(n)) {
            Gate.setDirOpen(tECarpentersBlock, Gate.getDirOpen(n));
            Gate.setState(tECarpentersBlock, Gate.getState(n), false);
        }
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TECarpentersBlock tECarpentersBlock2;
        int n4 = (sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) % 4;
        Gate.setFacing(tECarpentersBlock, n4 != 3 && n4 != 1 ? 0 : 1);
        TECarpentersBlock tECarpentersBlock3 = world.getBlockId(n, n2 - 1, n3) != this.blockID && world.getBlockId(n, n2 - 1, n3) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2 - 1, n3);
        TECarpentersBlock tECarpentersBlock4 = world.getBlockId(n, n2 + 1, n3) != this.blockID && world.getBlockId(n, n2 + 1, n3) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2 + 1, n3);
        TECarpentersBlock tECarpentersBlock5 = world.getBlockId(n - 1, n2, n3) != this.blockID && world.getBlockId(n - 1, n2, n3) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n - 1, n2, n3);
        TECarpentersBlock tECarpentersBlock6 = world.getBlockId(n + 1, n2, n3) != this.blockID && world.getBlockId(n + 1, n2, n3) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n + 1, n2, n3);
        TECarpentersBlock tECarpentersBlock7 = world.getBlockId(n, n2, n3 - 1) != this.blockID && world.getBlockId(n, n2, n3 - 1) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 - 1);
        TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = world.getBlockId(n, n2, n3 + 1) != this.blockID && world.getBlockId(n, n2, n3 + 1) != BlockHandler.blockCarpentersBarrierID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 + 1);
        if (tECarpentersBlock3 != null) {
            int n5 = BlockProperties.getData(tECarpentersBlock3);
            Gate.setType(tECarpentersBlock, world.getBlockId(n, n2 - 1, n3) == this.blockID ? Gate.getType(n5) : Barrier.getType(n5));
        } else if (tECarpentersBlock4 != null) {
            int n6 = BlockProperties.getData(tECarpentersBlock4);
            Gate.setType(tECarpentersBlock, world.getBlockId(n, n2 + 1, n3) == this.blockID ? Gate.getType(n6) : Barrier.getType(n6));
        } else if (tECarpentersBlock5 != null) {
            int n7 = BlockProperties.getData(tECarpentersBlock5);
            Gate.setType(tECarpentersBlock, world.getBlockId(n - 1, n2, n3) == this.blockID ? Gate.getType(n7) : Barrier.getType(n7));
        } else if (tECarpentersBlock6 != null) {
            int n8 = BlockProperties.getData(tECarpentersBlock6);
            Gate.setType(tECarpentersBlock, world.getBlockId(n + 1, n2, n3) == this.blockID ? Gate.getType(n8) : Barrier.getType(n8));
        } else if (tECarpentersBlock7 != null) {
            int n9 = BlockProperties.getData(tECarpentersBlock7);
            Gate.setType(tECarpentersBlock, world.getBlockId(n, n2, n3 - 1) == this.blockID ? Gate.getType(n9) : Barrier.getType(n9));
        } else if (tECarpentersBlock2 != null) {
            int n10 = BlockProperties.getData(tECarpentersBlock2);
            Gate.setType(tECarpentersBlock, world.getBlockId(n, n2, n3 + 1) == this.blockID ? Gate.getType(n10) : Barrier.getType(n10));
        }
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        boolean bl = world.isBlockIndirectlyGettingPowered(n, n2, n3);
        if (bl || n4 > 0 && Block.blocksList[n4].canProvidePower()) {
            int n5 = BlockProperties.getData(tECarpentersBlock);
            int n6 = Gate.getState(n5);
            if (bl && n6 == 0) {
                Gate.setState(tECarpentersBlock, 1, true);
                this.cycleNeighborGate(world, BlockProperties.getData(tECarpentersBlock), n, n2, n3);
            } else if (!bl && n6 == 1) {
                Gate.setState(tECarpentersBlock, 0, true);
                this.cycleNeighborGate(world, BlockProperties.getData(tECarpentersBlock), n, n2, n3);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersGateRenderID;
    }
}

