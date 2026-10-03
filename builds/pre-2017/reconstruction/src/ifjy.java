/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ifjy
extends Block {
    public ifjy(int n) {
        super(n, Material._y);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.snowball.itemID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 4;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock._b, n, n2, n3) > 11) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
    }
}

