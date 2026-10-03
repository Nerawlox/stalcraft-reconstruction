/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class rqbo
extends nuuf {
    public Icon[] _a;

    public rqbo(int n) {
        super(n);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 < 7) {
            if (n2 == 6) {
                n2 = 5;
            }
            return this._a[n2 >> 1];
        }
        return this._a[3];
    }

    @Override
    public int _a() {
        return Item.potato.itemID;
    }

    @Override
    public int _b() {
        return Item.potato.itemID;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
        if (world.isRemote) {
            return;
        }
        if (n4 >= 7 && world.rand.nextInt(50) == 0) {
            this.dropBlockAsItem_do(world, n, n2, n3, new ItemStack(Item.poisonousPotato));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[4];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = iconRegister._b(this.getTextureName() + "_stage_" + i);
        }
    }
}

