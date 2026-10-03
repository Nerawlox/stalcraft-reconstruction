/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class oxzc
extends Block {
    public Icon _a;

    public oxzc(int n) {
        super(n, Material._B);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1 || n == 0) {
            return this._a;
        }
        return this.blockIcon;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.melon.itemID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 3 + random.nextInt(5);
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        int n2 = this.quantityDropped(random) + random.nextInt(1 + n);
        if (n2 > 9) {
            n2 = 9;
        }
        return n2;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
    }
}

