/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class zgzq
extends Block {
    public zgzq(int n) {
        super(n, Material._x);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this._a(0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("snow");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3) & 7;
        float f = 0.125f;
        return AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (float)n2 + (float)n4 * f, (double)n3 + this.maxZ);
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
    public void setBlockBoundsForItemRender() {
        this._a(0);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public void _a(int n) {
        int n2 = n & 7;
        float f = (float)(2 * (1 + n2)) / 16.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2 - 1, n3);
        Block block = Block.blocksList[n4];
        if (block == null) {
            return false;
        }
        if (block == this && (world.getBlockMetadata(n, n2 - 1, n3) & 7) == 7) {
            return true;
        }
        if (!block.isLeaves(world, n, n2 - 1, n3) && !Block.blocksList[n4].isOpaqueCube()) {
            return false;
        }
        return world.getBlockMaterial(n, n2 - 1, n3)._c();
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3);
    }

    public boolean _a(World world, int n, int n2, int n3) {
        if (!this.canPlaceBlockAt(world, n, n2, n3)) {
            world.setBlockToAir(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.harvestBlock(world, entityPlayer, n, n2, n3, n4);
        world.setBlockToAir(n, n2, n3);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.snowball.itemID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock._b, n, n2, n3) > 11) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return n4 == 1 ? true : super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public int quantityDropped(int n, int n2, Random random) {
        return (n & 7) + 1;
    }

    @Override
    public boolean isBlockReplaceable(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        return n4 >= 7 ? false : this.blockMaterial._j();
    }
}

