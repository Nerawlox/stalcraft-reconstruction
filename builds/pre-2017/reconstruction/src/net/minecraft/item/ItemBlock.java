/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemBlock
extends Item {
    public int blockID;
    @SideOnly(value=Side.CLIENT)
    public Icon field_94588_b;

    public ItemBlock(int n) {
        super(n);
        this.blockID = n + 256;
    }

    public int getBlockID() {
        return this.blockID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getSpriteNumber() {
        return Block.blocksList[this.blockID].getItemIconName() != null ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIconFromDamage(int n) {
        return this.field_94588_b != null ? this.field_94588_b : Block.blocksList[this.blockID].getBlockTextureFromSide(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockId(n, n2, n3);
        if (n5 == Block.snow.blockID && (world.getBlockMetadata(n, n2, n3) & 7) < 1) {
            n4 = 1;
        } else if (!(n5 == Block.vine.blockID || n5 == Block.tallGrass.blockID || n5 == Block.deadBush.blockID || Block.blocksList[n5] != null && Block.blocksList[n5].isBlockReplaceable(world, n, n2, n3))) {
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
        }
        if (itemStack._b == 0) {
            return false;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (n2 == 255 && Block.blocksList[this.blockID].blockMaterial._a()) {
            return false;
        }
        if (world.canPlaceEntityOnSide(this.blockID, n, n2, n3, false, n4, entityPlayer, itemStack)) {
            Block block = Block.blocksList[this.blockID];
            int n6 = this.getMetadata(itemStack._j());
            int n7 = Block.blocksList[this.blockID].onBlockPlaced(world, n, n2, n3, n4, f, f2, f3, n6);
            if (this.placeBlockAt(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3, n7)) {
                world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, block.stepSound._e(), (block.stepSound._a() + 1.0f) / 2.0f, block.stepSound._b() * 0.8f);
                --itemStack._b;
            }
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean canPlaceItemBlockOnSide(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer, ItemStack itemStack) {
        int n5 = world.getBlockId(n, n2, n3);
        if (n5 == Block.snow.blockID) {
            n4 = 1;
        } else if (!(n5 == Block.vine.blockID || n5 == Block.tallGrass.blockID || n5 == Block.deadBush.blockID || Block.blocksList[n5] != null && Block.blocksList[n5].isBlockReplaceable(world, n, n2, n3))) {
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
        }
        return world.canPlaceEntityOnSide(this.getBlockID(), n, n2, n3, false, n4, null, itemStack);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Block.blocksList[this.blockID].getUnlocalizedName();
    }

    @Override
    public String getUnlocalizedName() {
        return Block.blocksList[this.blockID].getUnlocalizedName();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return Block.blocksList[this.blockID].getCreativeTabToDisplayOn();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        Block.blocksList[this.blockID].getSubBlocks(n, creativeTabs, list2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        String string = Block.blocksList[this.blockID].getItemIconName();
        if (string != null) {
            this.field_94588_b = iconRegister._b(string);
        }
    }

    public boolean placeBlockAt(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (!world.setBlock(n, n2, n3, this.blockID, n5, 3)) {
            return false;
        }
        if (world.getBlockId(n, n2, n3) == this.blockID) {
            Block.blocksList[this.blockID].onBlockPlacedBy(world, n, n2, n3, entityPlayer, itemStack);
            Block.blocksList[this.blockID].onPostBlockPlaced(world, n, n2, n3, n5);
        }
        return true;
    }
}

