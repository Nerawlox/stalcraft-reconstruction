/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class ItemSkull
extends Item {
    public static final String[] _a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};
    public static final String[] _b = new String[]{"skeleton", "wither", "zombie", "steve", "creeper"};
    public Icon[] _c;

    public ItemSkull(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        TileEntity tileEntity;
        if (n4 == 0) {
            return false;
        }
        if (!world.getBlockMaterial(n, n2, n3)._a()) {
            return false;
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
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (!Block.skull.canPlaceBlockAt(world, n, n2, n3)) {
            return false;
        }
        world.setBlock(n, n2, n3, Block.skull.blockID, n4, 2);
        int n5 = 0;
        if (n4 == 1) {
            n5 = sajh._c((double)(entityPlayer.rotationYaw * 16.0f / 360.0f) + 0.5) & 0xF;
        }
        if ((tileEntity = world.getBlockTileEntity(n, n2, n3)) != null && tileEntity instanceof TileEntitySkull) {
            String string = "";
            if (itemStack._p() && itemStack._q()._c("SkullOwner")) {
                string = itemStack._q()._j("SkullOwner");
            }
            ((TileEntitySkull)tileEntity)._a(itemStack._j(), string);
            ((TileEntitySkull)tileEntity)._a(n5);
            ((uznu)Block.skull)._a(world, n, n2, n3, (TileEntitySkull)tileEntity);
        }
        --itemStack._b;
        return true;
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < _a.length; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public Icon getIconFromDamage(int n) {
        if (n < 0 || n >= _a.length) {
            n = 0;
        }
        return this._c[n];
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = itemStack._j();
        if (n < 0 || n >= _a.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + _a[n];
    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        if (itemStack._j() == 3 && itemStack._p() && itemStack._q()._c("SkullOwner")) {
            return tdpx._a("item.skull.player.name", itemStack._q()._j("SkullOwner"));
        }
        return super.getItemDisplayName(itemStack);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._c = new Icon[_b.length];
        for (int i = 0; i < _b.length; ++i) {
            this._c[i] = iconRegister._b(this.getIconString() + "_" + _b[i]);
        }
    }
}

