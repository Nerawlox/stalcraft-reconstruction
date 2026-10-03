/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCauldron
extends Block {
    public Icon _a;
    public Icon _b;
    public Icon _c;

    public BlockCauldron(int n) {
        super(n, Material._f);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._b;
        }
        if (n == 0) {
            return this._c;
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a = iconRegister._b(this.getTextureName() + "_" + "inner");
        this._b = iconRegister._b(this.getTextureName() + "_top");
        this._c = iconRegister._b(this.getTextureName() + "_" + "bottom");
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
    }

    public static Icon _a(String string) {
        if (string.equals("inner")) {
            return Block.cauldron._a;
        }
        if (string.equals("bottom")) {
            return Block.cauldron._c;
        }
        return null;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.3125f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        float f = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        this.setBlockBoundsForItemRender();
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 24;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack == null) {
            return true;
        }
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = BlockCauldron._a(n5);
        if (itemStack._d == Item.bucketWater.itemID) {
            if (n6 < 3) {
                if (!entityPlayer.capabilities._d) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, new ItemStack(Item.bucketEmpty));
                }
                world.func_72921_c(n, n2, n3, 3, 2);
                world.func_96440_m(n, n2, n3, this.blockID);
            }
            return true;
        }
        if (itemStack._d == Item.glassBottle.itemID) {
            if (n6 > 0) {
                ItemStack itemStack2 = new ItemStack(Item.potion, 1, 0);
                if (!entityPlayer.inventory._c(itemStack2)) {
                    world.spawnEntityInWorld(new EntityItem(world, (double)n + 0.5, (double)n2 + 1.5, (double)n3 + 0.5, itemStack2));
                } else if (entityPlayer instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)entityPlayer).sendContainerToPlayer(entityPlayer.inventoryContainer);
                }
                --itemStack._b;
                if (itemStack._b <= 0) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                }
                world.func_72921_c(n, n2, n3, n6 - 1, 2);
                world.func_96440_m(n, n2, n3, this.blockID);
            }
        } else if (n6 > 0 && itemStack._a() instanceof ItemArmor && ((ItemArmor)itemStack._a()).getArmorMaterial() == EnumArmorMaterial._a) {
            ItemArmor itemArmor = (ItemArmor)itemStack._a();
            itemArmor.removeColor(itemStack);
            world.func_72921_c(n, n2, n3, n6 - 1, 2);
            world.func_96440_m(n, n2, n3, this.blockID);
            return true;
        }
        return true;
    }

    @Override
    public void fillWithRain(World world, int n, int n2, int n3) {
        if (world.rand.nextInt(20) != 1) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (n4 < 3) {
            world.func_72921_c(n, n2, n3, n4 + 1, 2);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.cauldron.itemID;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.cauldron.itemID;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        return BlockCauldron._a(n5);
    }

    public static int _a(int n) {
        return n;
    }
}

