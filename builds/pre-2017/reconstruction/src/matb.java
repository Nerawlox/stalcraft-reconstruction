/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class matb
extends Block {
    public matb(int n) {
        super(n, Material._q);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
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
        return 2;
    }

    public boolean _b(World world, int n, int n2, int n3) {
        if (world.doesBlockHaveSolidTopSurface(n, n2, n3)) {
            return true;
        }
        int n4 = world.getBlockId(n, n2, n3);
        return Block.blocksList[n4] != null && Block.blocksList[n4].canPlaceTorchOnTop(world, n, n2, n3);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) || world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) || world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) || world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) || this._b(world, n, n2 - 1, n3);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5;
        if (n4 == 1 && this._b(world, n, n2 - 1, n3)) {
            n6 = 5;
        }
        if (n4 == 2 && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
            n6 = 4;
        }
        if (n4 == 3 && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
            n6 = 3;
        }
        if (n4 == 4 && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
            n6 = 2;
        }
        if (n4 == 5 && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
            n6 = 1;
        }
        return n6;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        super.updateTick(world, n, n2, n3, random);
        if (world.getBlockMetadata(n, n2, n3) == 0) {
            this.onBlockAdded(world, n, n2, n3);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (world.getBlockMetadata(n, n2, n3) == 0) {
            if (world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
                world.func_72921_c(n, n2, n3, 1, 2);
            } else if (world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
                world.func_72921_c(n, n2, n3, 2, 2);
            } else if (world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
                world.func_72921_c(n, n2, n3, 3, 2);
            } else if (world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
                world.func_72921_c(n, n2, n3, 4, 2);
            } else if (this._b(world, n, n2 - 1, n3)) {
                world.func_72921_c(n, n2, n3, 5, 2);
            }
        }
        this._c(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3, n4);
    }

    public boolean _a(World world, int n, int n2, int n3, int n4) {
        if (this._c(world, n, n2, n3)) {
            int n5 = world.getBlockMetadata(n, n2, n3);
            boolean bl = false;
            if (!world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) && n5 == 1) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) && n5 == 2) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) && n5 == 3) {
                bl = true;
            }
            if (!world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) && n5 == 4) {
                bl = true;
            }
            if (!this._b(world, n, n2 - 1, n3) && n5 == 5) {
                bl = true;
            }
            if (bl) {
                this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                world.setBlockToAir(n, n2, n3);
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean _c(World world, int n, int n2, int n3) {
        if (!this.canPlaceBlockAt(world, n, n2, n3)) {
            if (world.getBlockId(n, n2, n3) == this.blockID) {
                this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                world.setBlockToAir(n, n2, n3);
            }
            return false;
        }
        return true;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        int n4 = world.getBlockMetadata(n, n2, n3) & 7;
        float f = 0.15f;
        if (n4 == 1) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 2) {
            this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 3) {
            this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 4) {
            this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else {
            f = 0.1f;
            this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
        return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        double d = (float)n + 0.5f;
        double d2 = (float)n2 + 0.7f;
        double d3 = (float)n3 + 0.5f;
        double d4 = 0.22f;
        double d5 = 0.27f;
        if (n4 == 1) {
            world.spawnParticle("smoke", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            world.spawnParticle("smoke", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            world.spawnParticle("smoke", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
        } else if (n4 == 4) {
            world.spawnParticle("smoke", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
        } else {
            world.spawnParticle("smoke", d, d2, d3, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d, d2, d3, 0.0, 0.0, 0.0);
        }
    }
}

