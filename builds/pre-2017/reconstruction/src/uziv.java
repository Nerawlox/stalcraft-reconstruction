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

public class uziv
extends Block {
    public Icon[] _a;

    public uziv(int n, Material material) {
        super(n, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return this._a[n2 % this._a.length];
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    public static int _a(int n) {
        return ~n & 0xF;
    }

    public static int _b(int n) {
        return ~n & 0xF;
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < 16; ++i) {
            list.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[16];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = iconRegister._b(this.getTextureName() + "_" + hugs._b[uziv._b(i)]);
        }
    }
}

