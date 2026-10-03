/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class cuwq
extends Block {
    public cuwq(int n) {
        super(n, Material._q);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public void _a(int n) {
        float f = 0.125f;
        if (n == 2) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 3) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (n == 4) {
            this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 5) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
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
        return 8;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5;
        if ((n6 == 0 || n4 == 2) && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n6 = 2;
        }
        if ((n6 == 0 || n4 == 3) && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n6 = 3;
        }
        if ((n6 == 0 || n4 == 4) && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n6 = 4;
        }
        if ((n6 == 0 || n4 == 5) && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n6 = 5;
        }
        return n6;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        boolean bl = false;
        if (n5 == 2 && world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            bl = true;
        }
        if (n5 == 3 && world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            bl = true;
        }
        if (n5 == 4 && world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            bl = true;
        }
        if (n5 == 5 && world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            bl = true;
        }
        if (!bl) {
            this.dropBlockAsItem(world, n, n2, n3, n5, 0);
            world.setBlockToAir(n, n2, n3);
        }
        super.onNeighborBlockChange(world, n, n2, n3, n4);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public boolean isLadder(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return true;
    }
}

