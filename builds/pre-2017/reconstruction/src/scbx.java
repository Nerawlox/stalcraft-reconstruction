/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class scbx
extends Block {
    public boolean _a;

    public scbx(int n, boolean bl) {
        super(n, Material._q);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this._a = bl;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int tickRate(World world) {
        return this._a ? 30 : 20;
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
        int n6 = world.getBlockMetadata(n, n2, n3);
        int n7 = n6 & 8;
        n6 &= 7;
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        n6 = forgeDirection == ForgeDirection.NORTH && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : (forgeDirection == ForgeDirection.SOUTH && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (forgeDirection == ForgeDirection.WEST && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (forgeDirection == ForgeDirection.EAST && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : this._a(world, n, n2, n3))));
        return n6 + n7;
    }

    public int _a(World world, int n, int n2, int n3) {
        if (world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            return 1;
        }
        if (world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            return 2;
        }
        if (world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            return 3;
        }
        if (world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            return 4;
        }
        return 1;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (this._b(world, n, n2, n3)) {
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
            if (bl) {
                this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                world.setBlockToAir(n, n2, n3);
            }
        }
    }

    public boolean _b(World world, int n, int n2, int n3) {
        if (!this.canPlaceBlockAt(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        this._a(n4);
    }

    public void _a(int n) {
        int n2 = n & 7;
        boolean bl = (n & 8) > 0;
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.1875f;
        float f4 = 0.125f;
        if (bl) {
            f4 = 0.0625f;
        }
        if (n2 == 1) {
            this.setBlockBounds(0.0f, f, 0.5f - f3, f4, f2, 0.5f + f3);
        } else if (n2 == 2) {
            this.setBlockBounds(1.0f - f4, f, 0.5f - f3, 1.0f, f2, 0.5f + f3);
        } else if (n2 == 3) {
            this.setBlockBounds(0.5f - f3, f, 0.0f, 0.5f + f3, f2, f4);
        } else if (n2 == 4) {
            this.setBlockBounds(0.5f - f3, f, 1.0f - f4, 0.5f + f3, f2, 1.0f);
        }
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = n5 & 7;
        int n7 = 8 - (n5 & 8);
        if (n7 == 0) {
            return true;
        }
        world.func_72921_c(n, n2, n3, n6 + n7, 3);
        world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
        world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        this._a(world, n, n2, n3, n6);
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        return true;
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 8) > 0) {
            int n6 = n5 & 7;
            this._a(world, n, n2, n3, n6);
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
        return n6 == 5 && n4 == 1 ? 15 : (n6 == 4 && n4 == 2 ? 15 : (n6 == 3 && n4 == 3 ? 15 : (n6 == 2 && n4 == 4 ? 15 : (n6 == 1 && n4 == 5 ? 15 : 0))));
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        if (!world.isRemote && ((n4 = world.getBlockMetadata(n, n2, n3)) & 8) != 0) {
            if (this._a) {
                this._c(world, n, n2, n3);
            } else {
                world.func_72921_c(n, n2, n3, n4 & 7, 3);
                int n5 = n4 & 7;
                this._a(world, n, n2, n3, n5);
                world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
                world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
            }
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.1875f;
        float f2 = 0.125f;
        float f3 = 0.125f;
        this.setBlockBounds(0.5f - f, 0.5f - f2, 0.5f - f3, 0.5f + f, 0.5f + f2, 0.5f + f3);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (!world.isRemote && this._a && (world.getBlockMetadata(n, n2, n3) & 8) == 0) {
            this._c(world, n, n2, n3);
        }
    }

    public void _c(World world, int n, int n2, int n3) {
        boolean bl;
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 7;
        boolean bl2 = (n4 & 8) != 0;
        this._a(n4);
        List list = world.getEntitiesWithinAABB(EntityArrow.class, AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (double)n2 + this.maxY, (double)n3 + this.maxZ));
        boolean bl3 = bl = !list.isEmpty();
        if (bl && !bl2) {
            world.func_72921_c(n, n2, n3, n5 | 8, 3);
            this._a(world, n, n2, n3, n5);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!bl && bl2) {
            world.func_72921_c(n, n2, n3, n5, 3);
            this._a(world, n, n2, n3, n5);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (bl) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        if (n4 == 1) {
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
        } else if (n4 == 2) {
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
        } else if (n4 == 3) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
        } else if (n4 == 4) {
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
        } else {
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
    }
}

