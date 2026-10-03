/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class zxyw
extends uznj {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;
    @SideOnly(value=Side.CLIENT)
    public Icon[] _c;

    public zxyw(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.wood.blockID;
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = 4;
        int n7 = n6 + 1;
        if (world.checkChunksExist(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            for (int i = -n6; i <= n6; ++i) {
                for (int j = -n6; j <= n6; ++j) {
                    for (int k = -n6; k <= n6; ++k) {
                        int n8 = world.getBlockId(n + i, n2 + j, n3 + k);
                        if (Block.blocksList[n8] == null) continue;
                        Block.blocksList[n8].beginLeavesDecay(world, n + i, n2 + j, n3 + k);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon _a(int n) {
        return this._b[n];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon _b(int n) {
        return this._c[n];
    }

    public static int _c(int n) {
        return n & 3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
        list.add(new ItemStack(n, 1, 1));
        list.add(new ItemStack(n, 1, 2));
        list.add(new ItemStack(n, 1, 3));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._b = new Icon[_a.length];
        this._c = new Icon[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(this.getTextureName() + "_" + _a[i]);
            this._c[i] = iconRegister._b(this.getTextureName() + "_" + _a[i] + "_top");
        }
    }

    @Override
    public boolean canSustainLeaves(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    public boolean isWood(World world, int n, int n2, int n3) {
        return true;
    }
}

