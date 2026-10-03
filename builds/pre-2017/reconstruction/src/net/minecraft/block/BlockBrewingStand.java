/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockBrewingStand
extends BlockContainer {
    public Random _a = new Random();
    public Icon _b;

    public BlockBrewingStand(int n) {
        super(n, Material._f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 25;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityBrewingStand();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this.setBlockBounds(0.4375f, 0.0f, 0.4375f, 0.5625f, 0.875f, 0.5625f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        this.setBlockBoundsForItemRender();
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityBrewingStand != null) {
            entityPlayer.displayGUIBrewingStand(tileEntityBrewingStand);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (itemStack._u()) {
            ((TileEntityBrewingStand)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        double d = (float)n + 0.4f + random.nextFloat() * 0.2f;
        double d2 = (float)n2 + 0.7f + random.nextFloat() * 0.3f;
        double d3 = (float)n3 + 0.4f + random.nextFloat() * 0.2f;
        world.spawnParticle("smoke", d, d2, d3, 0.0, 0.0, 0.0);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TileEntityBrewingStand) {
            TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)tileEntity;
            for (int i = 0; i < tileEntityBrewingStand.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntityBrewingStand.getStackInSlot(i);
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
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this._a.nextGaussian() * f4;
                    entityItem.motionY = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this._a.nextGaussian() * f4;
                    world.spawnEntityInWorld(entityItem);
                }
            }
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.brewingStand.itemID;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.brewingStand.itemID;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return Container.calcRedstoneFromInventory((IInventory)((Object)world.getBlockTileEntity(n, n2, n3)));
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._b = iconRegister._b(this.getTextureName() + "_base");
    }

    public Icon _a() {
        return this._b;
    }
}

