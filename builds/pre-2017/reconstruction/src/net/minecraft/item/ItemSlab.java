/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemSlab
extends ItemBlock {
    public final boolean _a;
    public final BlockHalfSlab _b;
    public final BlockHalfSlab _c;

    public ItemSlab(int n, BlockHalfSlab blockHalfSlab, BlockHalfSlab blockHalfSlab2, boolean bl) {
        super(n);
        this._b = blockHalfSlab;
        this._c = blockHalfSlab2;
        this._a = bl;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return Block.blocksList[this.itemID].getIcon(2, n);
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return this._b._b(itemStack._j());
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        boolean bl;
        if (this._a) {
            return super.onItemUse(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3);
        }
        if (itemStack._b == 0) {
            return false;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        int n5 = world.getBlockId(n, n2, n3);
        int n6 = world.getBlockMetadata(n, n2, n3);
        int n7 = n6 & 7;
        boolean bl2 = bl = (n6 & 8) != 0;
        if ((n4 == 1 && !bl || n4 == 0 && bl) && n5 == this._b.blockID && n7 == itemStack._j()) {
            if (world.checkNoEntityCollision(this._c.getCollisionBoundingBoxFromPool(world, n, n2, n3)) && world.setBlock(n, n2, n3, this._c.blockID, n7, 3)) {
                world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._c.stepSound._e(), (this._c.stepSound._a() + 1.0f) / 2.0f, this._c.stepSound._b() * 0.8f);
                --itemStack._b;
            }
            return true;
        }
        if (this._a(itemStack, entityPlayer, world, n, n2, n3, n4)) {
            return true;
        }
        return super.onItemUse(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3);
    }

    @Override
    public boolean canPlaceItemBlockOnSide(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer, ItemStack itemStack) {
        boolean bl;
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        int n8 = world.getBlockId(n, n2, n3);
        int n9 = world.getBlockMetadata(n, n2, n3);
        int n10 = n9 & 7;
        boolean bl2 = bl = (n9 & 8) != 0;
        if ((n4 == 1 && !bl || n4 == 0 && bl) && n8 == this._b.blockID && n10 == itemStack._j()) {
            return true;
        }
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        n8 = world.getBlockId(n, n2, n3);
        n9 = world.getBlockMetadata(n, n2, n3);
        n10 = n9 & 7;
        boolean bl3 = bl = (n9 & 8) != 0;
        if (n8 == this._b.blockID && n10 == itemStack._j()) {
            return true;
        }
        return super.canPlaceItemBlockOnSide(world, n5, n6, n7, n4, entityPlayer, itemStack);
    }

    public boolean _a(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        int n5 = world.getBlockId(n, n2, n3);
        int n6 = world.getBlockMetadata(n, n2, n3);
        int n7 = n6 & 7;
        if (n5 == this._b.blockID && n7 == itemStack._j()) {
            if (world.checkNoEntityCollision(this._c.getCollisionBoundingBoxFromPool(world, n, n2, n3)) && world.setBlock(n, n2, n3, this._c.blockID, n7, 3)) {
                world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._c.stepSound._e(), (this._c.stepSound._a() + 1.0f) / 2.0f, this._c.stepSound._b() * 0.8f);
                --itemStack._b;
            }
            return true;
        }
        return false;
    }
}

