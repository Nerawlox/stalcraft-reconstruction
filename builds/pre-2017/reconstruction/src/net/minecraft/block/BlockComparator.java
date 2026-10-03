/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Icon;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockComparator
extends BlockRedstoneLogic
implements stgn {
    public BlockComparator(int n, boolean bl) {
        super(n, bl);
        this.isBlockContainer = true;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.comparator.itemID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.comparator.itemID;
    }

    @Override
    public int _a(int n) {
        return 2;
    }

    @Override
    public BlockRedstoneLogic _a() {
        return Block.redstoneComparatorActive;
    }

    @Override
    public BlockRedstoneLogic _b() {
        return Block.redstoneComparatorIdle;
    }

    @Override
    public int getRenderType() {
        return 37;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = this._a || (n2 & 8) != 0;
        return n == 0 ? (bl ? Block.torchRedstoneActive.getBlockTextureFromSide(n) : Block.torchRedstoneIdle.getBlockTextureFromSide(n)) : (n == 1 ? (bl ? Block.redstoneComparatorActive.blockIcon : this.blockIcon) : Block.stoneDoubleSlab.getBlockTextureFromSide(1));
    }

    @Override
    public boolean _b(int n) {
        return this._a || (n & 8) != 0;
    }

    @Override
    public int _a(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this._a(iBlockAccess, n, n2, n3)._a();
    }

    public int _a(World world, int n, int n2, int n3, int n4) {
        return !this._c(n4) ? this._c(world, n, n2, n3, n4) : Math.max(this._c(world, n, n2, n3, n4) - this._c((IBlockAccess)world, n, n2, n3, n4), 0);
    }

    public boolean _c(int n) {
        return (n & 4) == 4;
    }

    @Override
    public boolean _b(World world, int n, int n2, int n3, int n4) {
        int n5 = this._c(world, n, n2, n3, n4);
        if (n5 >= 15) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        int n6 = this._c((IBlockAccess)world, n, n2, n3, n4);
        return n6 == 0 ? true : n5 >= n6;
    }

    @Override
    public int _c(World world, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = super._c(world, n, n2, n3, n4);
        int n7 = BlockComparator._d(n4);
        int n8 = n + ugqx._a[n7];
        int n9 = world.getBlockId(n8, n2, n5 = n3 + ugqx._b[n7]);
        if (n9 > 0) {
            if (Block.blocksList[n9].hasComparatorInputOverride()) {
                n6 = Block.blocksList[n9].getComparatorInputOverride(world, n8, n2, n5, ugqx._f[n7]);
            } else if (n6 < 15 && Block.isNormalCube(n9) && (n9 = world.getBlockId(n8 += ugqx._a[n7], n2, n5 += ugqx._b[n7])) > 0 && Block.blocksList[n9].hasComparatorInputOverride()) {
                n6 = Block.blocksList[n9].getComparatorInputOverride(world, n8, n2, n5, ugqx._f[n7]);
            }
        }
        return n6;
    }

    public TileEntityComparator _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return (TileEntityComparator)iBlockAccess.getBlockTileEntity(n, n2, n3);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        boolean bl = this._a | (n5 & 8) != 0;
        boolean bl2 = !this._c(n5);
        int n6 = bl2 ? 4 : 0;
        world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, bl2 ? 0.55f : 0.5f);
        world.func_72921_c(n, n2, n3, (n6 |= bl ? 8 : 0) | n5 & 3, 2);
        this._a(world, n, n2, n3, world.rand);
        return true;
    }

    @Override
    public void _d(World world, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        if (!(world.isBlockTickScheduledThisTick(n, n2, n3, this.blockID) || (n7 = this._a(world, n, n2, n3, n6 = world.getBlockMetadata(n, n2, n3))) == (n5 = this._a((IBlockAccess)world, n, n2, n3)._a()) && this._b(n6) == this._b(world, n, n2, n3, n6))) {
            if (this._e(world, n, n2, n3, n6)) {
                world.scheduleBlockUpdateWithPriority(n, n2, n3, this.blockID, this._a(0), -1);
            } else {
                world.scheduleBlockUpdateWithPriority(n, n2, n3, this.blockID, this._a(0), 0);
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = this._a(world, n, n2, n3, n4);
        int n6 = this._a((IBlockAccess)world, n, n2, n3)._a();
        this._a((IBlockAccess)world, n, n2, n3)._a(n5);
        if (n6 != n5 || !this._c(n4)) {
            boolean bl;
            boolean bl2 = this._b(world, n, n2, n3, n4);
            boolean bl3 = bl = this._a || (n4 & 8) != 0;
            if (bl && !bl2) {
                world.func_72921_c(n, n2, n3, n4 & 0xFFFFFFF7, 2);
            } else if (!bl && bl2) {
                world.func_72921_c(n, n2, n3, n4 | 8, 2);
            }
            this._a(world, n, n2, n3);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (this._a) {
            int n4 = world.getBlockMetadata(n, n2, n3);
            world.setBlock(n, n2, n3, this._b().blockID, n4 | 8, 4);
        }
        this._a(world, n, n2, n3, random);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        world.setBlockTileEntity(n, n2, n3, this.createNewTileEntity(world));
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
        world.removeBlockTileEntity(n, n2, n3);
        this._a(world, n, n2, n3);
    }

    @Override
    public boolean onBlockEventReceived(World world, int n, int n2, int n3, int n4, int n5) {
        super.onBlockEventReceived(world, n, n2, n3, n4, n5);
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        return tileEntity != null ? tileEntity.receiveClientEvent(n4, n5) : false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityComparator();
    }

    @Override
    public void onNeighborTileChange(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n2 == n5) {
            this.onNeighborBlockChange(world, n, n2, n3, world.getBlockId(n4, n5, n6));
        }
    }

    @Override
    public boolean weakTileChanges() {
        return true;
    }
}

