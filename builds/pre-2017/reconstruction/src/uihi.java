/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class uihi
extends Block {
    public uihi(int n) {
        super(n, Material._A);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.clay.itemID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 4;
    }
}

