/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public final class yvqb
extends bbmo {
    public final bbmo _a = new bbmo();

    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        Item item;
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        World world = ekuw2._a();
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        Material material = world.getBlockMaterial(n, n2, n3);
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (Material._h.equals(material) && n4 == 0) {
            item = Item.bucketWater;
        } else if (Material._i.equals(material) && n4 == 0) {
            item = Item.bucketLava;
        } else {
            return super._b(ekuw2, itemStack);
        }
        world.setBlockToAir(n, n2, n3);
        if (--itemStack._b == 0) {
            itemStack._d = item.itemID;
            itemStack._b = 1;
        } else if (((TileEntityDispenser)ekuw2._i())._a(new ItemStack(item)) < 0) {
            this._a._a(ekuw2, new ItemStack(item));
        }
        return itemStack;
    }
}

