/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class tfgg
extends Block {
    public tfgg(int n) {
        super(n, Material._q);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 12;
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
        int n6 = n5 & 8;
        int n7 = n5 & 7;
        int n8 = -1;
        if (n4 == 0 && world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            n8 = 0;
        }
        if (n4 == 1 && world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP)) {
            n8 = 5;
        }
        if (n4 == 2 && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n8 = 4;
        }
        if (n4 == 3 && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n8 = 3;
        }
        if (n4 == 4 && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n8 = 2;
        }
        if (n4 == 5 && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n8 = 1;
        }
        return n8 + n6;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 7;
        int n6 = n4 & 8;
        if (n5 == tfgg._a(1)) {
            if ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                world.func_72921_c(n, n2, n3, 5 | n6, 2);
            } else {
                world.func_72921_c(n, n2, n3, 6 | n6, 2);
            }
        } else if (n5 == tfgg._a(0)) {
            if ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                world.func_72921_c(n, n2, n3, 7 | n6, 2);
            } else {
                world.func_72921_c(n, n2, n3, 0 | n6, 2);
            }
        }
    }

    public static int _a(int n) {
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
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (this._a(world, n, n2, n3)) {
            int n5 = world.getBlockMetadata(n, n2, n3) & 7;
            boolean bl = false;
            if (!world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n5 == 1) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n5 == 2) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n5 == 3) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n5 == 4) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n5 == 5) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n5 == 6) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n5 == 0) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n5 == 7) {
                bl = true;
            }
            if (bl) {
                this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                world.setBlockToAir(n, n2, n3);
            }
        }
    }

    public boolean _a(World world, int n, int n2, int n3) {
        if (!this.canPlaceBlockAt(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3) & 7;
        float f = 0.1875f;
        if (n4 == 1) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 2) {
            this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 3) {
            this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 4) {
            this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else if (n4 != 5 && n4 != 6) {
            if (n4 == 0 || n4 == 7) {
                f = 0.25f;
                this.setBlockBounds(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
            }
        } else {
            f = 0.25f;
            this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = n5 & 7;
        int n7 = 8 - (n5 & 8);
        world.func_72921_c(n, n2, n3, n6 + n7, 3);
        world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, n7 > 0 ? 0.6f : 0.5f);
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        if (n6 == 1) {
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
        } else if (n6 == 2) {
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
        } else if (n6 == 3) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
        } else if (n6 == 4) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
        } else if (n6 != 5 && n6 != 6) {
            if (n6 == 0 || n6 == 7) {
                world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            }
        } else {
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
        }
        return true;
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 8) > 0) {
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            int n6 = n5 & 7;
            if (n6 == 1) {
                world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            } else if (n6 == 2) {
                world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            } else if (n6 == 3) {
                world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            } else if (n6 == 4) {
                world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            } else if (n6 != 5 && n6 != 6) {
                if (n6 == 0 || n6 == 7) {
                    world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
                }
            } else {
                world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            }
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) > 0 ? 15 : 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if ((n5 & 8) == 0) {
            return 0;
        }
        int n6 = n5 & 7;
        return n6 == 0 && n4 == 0 ? 15 : (n6 == 7 && n4 == 0 ? 15 : (n6 == 6 && n4 == 1 ? 15 : (n6 == 5 && n4 == 1 ? 15 : (n6 == 4 && n4 == 2 ? 15 : (n6 == 3 && n4 == 3 ? 15 : (n6 == 2 && n4 == 4 ? 15 : (n6 == 1 && n4 == 5 ? 15 : 0)))))));
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }
}

