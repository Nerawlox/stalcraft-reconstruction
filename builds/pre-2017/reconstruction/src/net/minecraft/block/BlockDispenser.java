/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.Icon;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public class BlockDispenser
extends BlockContainer {
    public static final zhqu _a = new dhrp(new bbmo());
    public Random _b = new Random();
    public Icon _c;
    public Icon _d;
    public Icon _e;

    public BlockDispenser(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public int tickRate(World world) {
        return 4;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        if (world.isRemote) {
            return;
        }
        int n4 = world.getBlockId(n, n2, n3 - 1);
        int n5 = world.getBlockId(n, n2, n3 + 1);
        int n6 = world.getBlockId(n - 1, n2, n3);
        int n7 = world.getBlockId(n + 1, n2, n3);
        int n8 = 3;
        if (Block.opaqueCubeLookup[n4] && !Block.opaqueCubeLookup[n5]) {
            n8 = 3;
        }
        if (Block.opaqueCubeLookup[n5] && !Block.opaqueCubeLookup[n4]) {
            n8 = 2;
        }
        if (Block.opaqueCubeLookup[n6] && !Block.opaqueCubeLookup[n7]) {
            n8 = 5;
        }
        if (Block.opaqueCubeLookup[n7] && !Block.opaqueCubeLookup[n6]) {
            n8 = 4;
        }
        world.func_72921_c(n, n2, n3, n8, 2);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        int n3 = n2 & 7;
        if (n == n3) {
            if (n3 == 1 || n3 == 0) {
                return this._e;
            }
            return this._d;
        }
        if (n3 == 1 || n3 == 0) {
            return this._c;
        }
        if (n == 1 || n == 0) {
            return this._c;
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("furnace_side");
        this._c = iconRegister._b("furnace_top");
        this._d = iconRegister._b(this.getTextureName() + "_front_horizontal");
        this._e = iconRegister._b(this.getTextureName() + "_front_vertical");
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityDispenser != null) {
            entityPlayer.displayGUIDispenser(tileEntityDispenser);
        }
        return true;
    }

    public void _b(World world, int n, int n2, int n3) {
        rqep rqep2 = new rqep(world, n, n2, n3);
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)rqep2._i();
        if (tileEntityDispenser == null) {
            return;
        }
        int n4 = tileEntityDispenser._a();
        if (n4 < 0) {
            world.playAuxSFX(1001, n, n2, n3, 0);
        } else {
            ItemStack itemStack = tileEntityDispenser.getStackInSlot(n4);
            vmgb vmgb2 = this._a(itemStack);
            if (vmgb2 != vmgb._c) {
                ItemStack itemStack2 = vmgb2._a(rqep2, itemStack);
                tileEntityDispenser.setInventorySlotContents(n4, itemStack2._b == 0 ? null : itemStack2);
            }
        }
    }

    public vmgb _a(ItemStack itemStack) {
        return (vmgb)_a._a(itemStack._a());
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = world.isBlockIndirectlyGettingPowered(n, n2, n3) || world.isBlockIndirectlyGettingPowered(n, n2 + 1, n3);
        int n5 = world.getBlockMetadata(n, n2, n3);
        boolean bl3 = bl = (n5 & 8) != 0;
        if (bl2 && !bl) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
            world.func_72921_c(n, n2, n3, n5 | 8, 4);
        } else if (!bl2 && bl) {
            world.func_72921_c(n, n2, n3, n5 & 0xFFFFFFF7, 4);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            this._b(world, n, n2, n3);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityDispenser();
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = BlockPistonBase._a(world, n, n2, n3, entityLivingBase);
        world.func_72921_c(n, n2, n3, n4, 2);
        if (itemStack._u()) {
            ((TileEntityDispenser)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityDispenser != null) {
            for (int i = 0; i < tileEntityDispenser.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityDispenser.getStackInSlot(i);
                if (itemStack == null) continue;
                float f = this._b.nextFloat() * 0.8f + 0.1f;
                float f2 = this._b.nextFloat() * 0.8f + 0.1f;
                float f3 = this._b.nextFloat() * 0.8f + 0.1f;
                while (itemStack._b > 0) {
                    int n6 = this._b.nextInt(21) + 10;
                    if (n6 > itemStack._b) {
                        n6 = itemStack._b;
                    }
                    itemStack._b -= n6;
                    EntityItem entityItem = new EntityItem(world, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack._d, n6, itemStack._j()));
                    if (itemStack._p()) {
                        entityItem.getEntityItem()._d((NBTTagCompound)itemStack._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._b.nextGaussian() * f4;
                    entityItem.motionY = (float)this._b.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._b.nextGaussian() * f4;
                    world.spawnEntityInWorld(entityItem);
                }
            }
            world.func_96440_m(n, n2, n3, n4);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    public static yent _a(ekuw ekuw2) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        double d = ekuw2._b() + 0.7 * (double)ezfa2._a();
        double d2 = ekuw2._c() + 0.7 * (double)ezfa2._b();
        double d3 = ekuw2._d() + 0.7 * (double)ezfa2._c();
        return new txbx(d, d2, d3);
    }

    public static ezfa _a(int n) {
        return ezfa._a(n & 7);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return Container.calcRedstoneFromInventory((IInventory)((Object)world.getBlockTileEntity(n, n2, n3)));
    }
}

