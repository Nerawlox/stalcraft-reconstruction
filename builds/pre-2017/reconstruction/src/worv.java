/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class worv
extends Block {
    public worv(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.cobblestone.blockID;
    }
}

