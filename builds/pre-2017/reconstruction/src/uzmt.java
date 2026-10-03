/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class uzmt
extends BlockHalfSlab {
    public static final String[] _b = new String[]{"oak", "spruce", "birch", "jungle"};

    public uzmt(int n, boolean bl) {
        super(n, bl, Material._d);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return Block.planks.getIcon(n, n2 & 7);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.woodSingleSlab.blockID;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(Block.woodSingleSlab.blockID, 2, n & 7);
    }

    @Override
    public String _b(int n) {
        if (n < 0 || n >= _b.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + _b[n];
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        if (n == Block.woodDoubleSlab.blockID) {
            return;
        }
        for (int i = 0; i < 4; ++i) {
            list.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

