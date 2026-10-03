/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class htie
extends Block {
    public static final String[] _a = new String[]{"stone", "cobble", "brick"};

    public htie(int n) {
        super(n, Material._A);
        this.setHardness(0.0f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 == 1) {
            return Block.cobblestone.getBlockTextureFromSide(n);
        }
        if (n2 == 2) {
            return Block.stoneBrick.getBlockTextureFromSide(n);
        }
        return Block.stone.getBlockTextureFromSide(n);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            EntitySilverfish entitySilverfish = new EntitySilverfish(world);
            entitySilverfish.setLocationAndAngles((double)n + 0.5, n2, (double)n3 + 0.5, 0.0f, 0.0f);
            world.spawnEntityInWorld(entitySilverfish);
            entitySilverfish.spawnExplosionParticle();
        }
        super.onBlockDestroyedByPlayer(world, n, n2, n3, n4);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    public static boolean _a(int n) {
        return n == Block.stone.blockID || n == Block.cobblestone.blockID || n == Block.stoneBrick.blockID;
    }

    public static int _b(int n) {
        if (n == Block.cobblestone.blockID) {
            return 1;
        }
        if (n == Block.stoneBrick.blockID) {
            return 2;
        }
        return 0;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        Block block = Block.stone;
        if (n == 1) {
            block = Block.cobblestone;
        }
        if (n == 2) {
            block = Block.stoneBrick;
        }
        return new ItemStack(block);
    }

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        return world.getBlockMetadata(n, n2, n3);
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < 3; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }
}

