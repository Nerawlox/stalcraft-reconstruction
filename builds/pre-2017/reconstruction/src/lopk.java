/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class lopk
extends Block {
    public lopk(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1 || n == 0) {
            return Block.planks.getBlockTextureFromSide(n);
        }
        return super.getIcon(n, n2);
    }

    @Override
    public int quantityDropped(Random random) {
        return 3;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.book.itemID;
    }
}

