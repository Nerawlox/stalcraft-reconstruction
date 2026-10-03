/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class iwkf
extends Block {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    public Icon[] _b;

    public iwkf(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 < 0 || n2 >= this._b.length) {
            n2 = 0;
        }
        return this._b[n2];
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        list2.add(new ItemStack(n, 1, 0));
        list2.add(new ItemStack(n, 1, 1));
        list2.add(new ItemStack(n, 1, 2));
        list2.add(new ItemStack(n, 1, 3));
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._b = new Icon[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(this.getTextureName() + "_" + _a[i]);
        }
    }
}

