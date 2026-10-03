/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockFlowerPot
extends Block {
    public BlockFlowerPot(int n) {
        super(n, Material._q);
        this.setBlockBoundsForItemRender();
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.375f;
        float f2 = f / 2.0f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f, 0.5f + f2);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 33;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack == null) {
            return false;
        }
        if (world.getBlockMetadata(n, n2, n3) != 0) {
            return false;
        }
        int n5 = BlockFlowerPot._a(itemStack);
        if (n5 > 0) {
            world.func_72921_c(n, n2, n3, n5, 2);
            if (!entityPlayer.capabilities._d && --itemStack._b <= 0) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
            }
            return true;
        }
        return false;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        ItemStack itemStack = BlockFlowerPot._a(world.getBlockMetadata(n, n2, n3));
        if (itemStack == null) {
            return Item.flowerPot.itemID;
        }
        return itemStack._d;
    }

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        ItemStack itemStack = BlockFlowerPot._a(world.getBlockMetadata(n, n2, n3));
        if (itemStack == null) {
            return Item.flowerPot.itemID;
        }
        return itemStack._j();
    }

    @Override
    public boolean isFlowerPot() {
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return super.canPlaceBlockAt(world, n, n2, n3) && world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        ItemStack itemStack;
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
        if (n4 > 0 && (itemStack = BlockFlowerPot._a(n4)) != null) {
            this.dropBlockAsItem_do(world, n, n2, n3, itemStack);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.flowerPot.itemID;
    }

    public static ItemStack _a(int n) {
        switch (n) {
            case 1: {
                return new ItemStack(Block.plantRed);
            }
            case 2: {
                return new ItemStack(Block.plantYellow);
            }
            case 9: {
                return new ItemStack(Block.cactus);
            }
            case 8: {
                return new ItemStack(Block.mushroomBrown);
            }
            case 7: {
                return new ItemStack(Block.mushroomRed);
            }
            case 10: {
                return new ItemStack(Block.deadBush);
            }
            case 3: {
                return new ItemStack(Block.sapling, 1, 0);
            }
            case 5: {
                return new ItemStack(Block.sapling, 1, 2);
            }
            case 4: {
                return new ItemStack(Block.sapling, 1, 1);
            }
            case 6: {
                return new ItemStack(Block.sapling, 1, 3);
            }
            case 11: {
                return new ItemStack(Block.tallGrass, 1, 2);
            }
        }
        return null;
    }

    public static int _a(ItemStack itemStack) {
        int n = itemStack._a().itemID;
        if (n == Block.plantRed.blockID) {
            return 1;
        }
        if (n == Block.plantYellow.blockID) {
            return 2;
        }
        if (n == Block.cactus.blockID) {
            return 9;
        }
        if (n == Block.mushroomBrown.blockID) {
            return 8;
        }
        if (n == Block.mushroomRed.blockID) {
            return 7;
        }
        if (n == Block.deadBush.blockID) {
            return 10;
        }
        if (n == Block.sapling.blockID) {
            switch (itemStack._j()) {
                case 0: {
                    return 3;
                }
                case 2: {
                    return 5;
                }
                case 1: {
                    return 4;
                }
                case 3: {
                    return 6;
                }
            }
        }
        if (n == Block.tallGrass.blockID) {
            switch (itemStack._j()) {
                case 2: {
                    return 11;
                }
            }
        }
        return 0;
    }
}

