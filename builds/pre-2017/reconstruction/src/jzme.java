/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.sajh;

public class jzme
extends Block {
    public jzme(int n, Material material) {
        super(n, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        return sajh._a(this.quantityDropped(random) + random.nextInt(n + 1), 1, 4);
    }

    @Override
    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.glowstone.itemID;
    }
}

