/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.owak;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHopper
extends BlockContainer {
    public final Random _a = new Random();
    public Icon _b;
    public Icon _c;
    public Icon _d;

    public BlockHopper(int n) {
        super(n, Material._f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        float f = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = owak._a[n4];
        if (n6 == 1) {
            n6 = 0;
        }
        return n6;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityHopper();
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        if (itemStack._u()) {
            TileEntityHopper tileEntityHopper = BlockHopper._a(world, n, n2, n3);
            tileEntityHopper._a(itemStack._s());
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        this._a(world, n, n2, n3);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        TileEntityHopper tileEntityHopper = BlockHopper._a(world, n, n2, n3);
        if (tileEntityHopper != null) {
            entityPlayer.displayGUIHopper(tileEntityHopper);
        }
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        boolean bl;
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = BlockHopper._a(n4);
        boolean bl2 = !world.isBlockIndirectlyGettingPowered(n, n2, n3);
        if (bl2 != (bl = BlockHopper._b(n4))) {
            world.func_72921_c(n, n2, n3, n5 | (bl2 ? 0 : 8), 4);
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntityHopper tileEntityHopper = (TileEntityHopper)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityHopper != null) {
            for (int i = 0; i < tileEntityHopper.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityHopper.getStackInSlot(i);
                if (itemStack == null) continue;
                float f = this._a.nextFloat() * 0.8f + 0.1f;
                float f2 = this._a.nextFloat() * 0.8f + 0.1f;
                float f3 = this._a.nextFloat() * 0.8f + 0.1f;
                while (itemStack._b > 0) {
                    int n6 = this._a.nextInt(21) + 10;
                    if (n6 > itemStack._b) {
                        n6 = itemStack._b;
                    }
                    itemStack._b -= n6;
                    EntityItem entityItem = new EntityItem(world, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack._d, n6, itemStack._j()));
                    if (itemStack._p()) {
                        entityItem.getEntityItem()._d((NBTTagCompound)itemStack._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._a.nextGaussian() * f4;
                    entityItem.motionY = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._a.nextGaussian() * f4;
                    world.spawnEntityInWorld(entityItem);
                }
            }
            world.func_96440_m(n, n2, n3, n4);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public int getRenderType() {
        return 38;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._c;
        }
        return this._b;
    }

    public static int _a(int n) {
        return n & 7;
    }

    public static boolean _b(int n) {
        return (n & 8) != 8;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return Container.calcRedstoneFromInventory(BlockHopper._a(world, n, n2, n3));
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._b = iconRegister._b("hopper_outside");
        this._c = iconRegister._b("hopper_top");
        this._d = iconRegister._b("hopper_inside");
    }

    public static Icon _a(String string) {
        if (string.equals("hopper_outside")) {
            return Block.hopperBlock._b;
        }
        if (string.equals("hopper_inside")) {
            return Block.hopperBlock._d;
        }
        return null;
    }

    @Override
    public String getItemIconName() {
        return "hopper";
    }

    public static TileEntityHopper _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return (TileEntityHopper)iBlockAccess.getBlockTileEntity(n, n2, n3);
    }
}

