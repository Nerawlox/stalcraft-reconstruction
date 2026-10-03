/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class matf
extends Block {
    public matf(int n) {
        super(n, Material._q);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
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
        return 29;
    }

    @Override
    public int tickRate(World world) {
        return 10;
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
        int n6 = 0;
        if (n4 == 2 && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
            n6 = 2;
        }
        if (n4 == 3 && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
            n6 = 0;
        }
        if (n4 == 4 && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
            n6 = 1;
        }
        if (n4 == 5 && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
            n6 = 3;
        }
        return n6;
    }

    @Override
    public void onPostBlockPlaced(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3, this.blockID, n4, false, -1, 0);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (n4 != this.blockID && this._a(world, n, n2, n3)) {
            int n5 = world.getBlockMetadata(n, n2, n3);
            int n6 = n5 & 3;
            boolean bl = false;
            if (!world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 3) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 1) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 0) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 2) {
                bl = true;
            }
            if (bl) {
                this.dropBlockAsItem(world, n, n2, n3, n5, 0);
                world.setBlockToAir(n, n2, n3);
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7) {
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13 = n5 & 3;
        boolean bl2 = (n5 & 4) == 4;
        boolean bl3 = (n5 & 8) == 8;
        boolean bl4 = n4 == Block.tripWireSource.blockID;
        boolean bl5 = false;
        boolean bl6 = !world.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP);
        int n14 = ugqx._a[n13];
        int n15 = ugqx._b[n13];
        int n16 = 0;
        int[] nArray = new int[42];
        for (n12 = 1; n12 < 42; ++n12) {
            n11 = n + n14 * n12;
            n10 = n3 + n15 * n12;
            n9 = world.getBlockId(n11, n2, n10);
            if (n9 == Block.tripWireSource.blockID) {
                n8 = world.getBlockMetadata(n11, n2, n10);
                if ((n8 & 3) != ugqx._f[n13]) break;
                n16 = n12;
                break;
            }
            if (n9 != Block.tripWire.blockID && n12 != n6) {
                nArray[n12] = -1;
                bl4 = false;
                continue;
            }
            n8 = n12 == n6 ? n7 : world.getBlockMetadata(n11, n2, n10);
            boolean bl7 = (n8 & 8) != 8;
            boolean bl8 = (n8 & 1) == 1;
            boolean bl9 = (n8 & 2) == 2;
            bl4 &= bl9 == bl6;
            bl5 |= bl7 && bl8;
            nArray[n12] = n8;
            if (n12 != n6) continue;
            world.scheduleBlockUpdate(n, n2, n3, n4, this.tickRate(world));
            bl4 &= bl7;
        }
        n12 = (bl4 ? 4 : 0) | ((bl5 &= (bl4 &= n16 > 1)) ? 8 : 0);
        n5 = n13 | n12;
        if (n16 > 0) {
            n11 = n + n14 * n16;
            n10 = n3 + n15 * n16;
            n9 = ugqx._f[n13];
            world.func_72921_c(n11, n2, n10, n9 | n12, 3);
            this._a(world, n11, n2, n10, n9);
            this._a(world, n11, n2, n10, bl4, bl5, bl2, bl3);
        }
        this._a(world, n, n2, n3, bl4, bl5, bl2, bl3);
        if (n4 > 0) {
            world.func_72921_c(n, n2, n3, n5, 3);
            if (bl) {
                this._a(world, n, n2, n3, n13);
            }
        }
        if (bl2 != bl4) {
            for (n11 = 1; n11 < n16; ++n11) {
                n10 = n + n14 * n11;
                n9 = n3 + n15 * n11;
                n8 = nArray[n11];
                if (n8 < 0) continue;
                n8 = bl4 ? (n8 |= 4) : (n8 &= 0xFFFFFFFB);
                world.func_72921_c(n10, n2, n9, n8, 3);
            }
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        this._a(world, n, n2, n3, this.blockID, world.getBlockMetadata(n, n2, n3), true, -1, 0);
    }

    public void _a(World world, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2 && !bl4) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.6f);
        } else if (!bl2 && bl4) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.5f);
        } else if (bl && !bl3) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.7f);
        } else if (!bl && bl3) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.bowhit", 0.4f, 1.2f / (world.rand.nextFloat() * 0.2f + 0.9f));
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        if (n4 == 3) {
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
        } else if (n4 == 1) {
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
        } else if (n4 == 0) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
        } else if (n4 == 2) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
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
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3) & 3;
        float f = 0.1875f;
        if (n4 == 3) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 1) {
            this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 0) {
            this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 2) {
            this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        boolean bl2 = (n5 & 4) == 4;
        boolean bl3 = bl = (n5 & 8) == 8;
        if (bl2 || bl) {
            this._a(world, n, n2, n3, 0, n5, false, -1, 0);
        }
        if (bl) {
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            int n6 = n5 & 3;
            if (n6 == 3) {
                world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            } else if (n6 == 1) {
                world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            } else if (n6 == 0) {
                world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            } else if (n6 == 2) {
                world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            }
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) == 8 ? 15 : 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if ((n5 & 8) != 8) {
            return 0;
        }
        int n6 = n5 & 3;
        return n6 == 2 && n4 == 2 ? 15 : (n6 == 0 && n4 == 3 ? 15 : (n6 == 1 && n4 == 4 ? 15 : (n6 == 3 && n4 == 5 ? 15 : 0)));
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }
}

