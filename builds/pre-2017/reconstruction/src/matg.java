/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class matg
extends Block {
    public static boolean _a = false;

    public matg(int n, Material material) {
        super(n, material);
        float f = 0.5f;
        float f2 = 1.0f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
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
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return !matg._b(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    public int getRenderType() {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.1875f;
        this.setBlockBounds(0.0f, 0.5f - f / 2.0f, 0.0f, 1.0f, 0.5f + f / 2.0f, 1.0f);
    }

    public void _a(int n) {
        float f = 0.1875f;
        if ((n & 8) != 0) {
            this.setBlockBounds(0.0f, 1.0f - f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
        }
        if (matg._b(n)) {
            if ((n & 3) == 0) {
                this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 1) {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
            }
            if ((n & 3) == 2) {
                this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 3) {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this.blockMaterial == Material._f) {
            return true;
        }
        int n5 = world.getBlockMetadata(n, n2, n3);
        world.func_72921_c(n, n2, n3, n5 ^ 4, 2);
        world.playAuxSFXAtEntity(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    public void _a(World world, int n, int n2, int n3, boolean bl) {
        boolean bl2;
        int n4 = world.getBlockMetadata(n, n2, n3);
        boolean bl3 = bl2 = (n4 & 4) > 0;
        if (bl2 != bl) {
            world.func_72921_c(n, n2, n3, n4 ^ 4, 2);
            world.playAuxSFXAtEntity(null, 1003, n, n2, n3, 0);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            boolean bl;
            int n5 = world.getBlockMetadata(n, n2, n3);
            int n6 = n;
            int n7 = n3;
            if ((n5 & 3) == 0) {
                n7 = n3 + 1;
            }
            if ((n5 & 3) == 1) {
                --n7;
            }
            if ((n5 & 3) == 2) {
                n6 = n + 1;
            }
            if ((n5 & 3) == 3) {
                --n6;
            }
            if (!matg._c(world.getBlockId(n6, n2, n7)) && !world.isBlockSolidOnSide(n6, n2, n7, ForgeDirection.getOrientation((n5 & 3) + 2))) {
                world.setBlockToAir(n, n2, n3);
                this.dropBlockAsItem(world, n, n2, n3, n5, 0);
            }
            if ((bl = world.isBlockIndirectlyGettingPowered(n, n2, n3)) || n4 > 0 && Block.blocksList[n4].canProvidePower()) {
                this._a(world, n, n2, n3, bl);
            }
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        if (n4 == 2) {
            n6 = 0;
        }
        if (n4 == 3) {
            n6 = 1;
        }
        if (n4 == 4) {
            n6 = 2;
        }
        if (n4 == 5) {
            n6 = 3;
        }
        if (n4 != 1 && n4 != 0 && f2 > 0.5f) {
            n6 |= 8;
        }
        return n6;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        if (_a) {
            return true;
        }
        if (n4 == 0) {
            return false;
        }
        if (n4 == 1) {
            return false;
        }
        if (n4 == 2) {
            ++n3;
        }
        if (n4 == 3) {
            --n3;
        }
        if (n4 == 4) {
            ++n;
        }
        if (n4 == 5) {
            --n;
        }
        return matg._c(world.getBlockId(n, n2, n3)) || world.isBlockSolidOnSide(n, n2, n3, ForgeDirection.UP);
    }

    public static boolean _b(int n) {
        return (n & 4) != 0;
    }

    public static boolean _c(int n) {
        if (_a) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        Block block = Block.blocksList[n];
        return block != null && block.blockMaterial._k() && block.renderAsNormalBlock() || block == Block.glowStone || block instanceof BlockHalfSlab || block instanceof yuxu;
    }
}

