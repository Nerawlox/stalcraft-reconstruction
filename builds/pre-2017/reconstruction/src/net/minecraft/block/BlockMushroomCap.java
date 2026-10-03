/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMushroomCap
extends Block {
    public static final String[] _a = new String[]{"skin_brown", "skin_red"};
    public final int _b;
    public Icon[] _c;
    public Icon _d;
    public Icon _e;

    public BlockMushroomCap(int n, Material material, int n2) {
        super(n, material);
        this._b = n2;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 == 10 && n > 1) {
            return this._d;
        }
        if (n2 >= 1 && n2 <= 9 && n == 1) {
            return this._c[this._b];
        }
        if (n2 >= 1 && n2 <= 3 && n == 2) {
            return this._c[this._b];
        }
        if (n2 >= 7 && n2 <= 9 && n == 3) {
            return this._c[this._b];
        }
        if ((n2 == 1 || n2 == 4 || n2 == 7) && n == 4) {
            return this._c[this._b];
        }
        if ((n2 == 3 || n2 == 6 || n2 == 9) && n == 5) {
            return this._c[this._b];
        }
        if (n2 == 14) {
            return this._c[this._b];
        }
        if (n2 == 15) {
            return this._d;
        }
        return this._e;
    }

    @Override
    public int quantityDropped(Random random) {
        int n = random.nextInt(10) - 7;
        if (n < 0) {
            n = 0;
        }
        return n;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.mushroomBrown.blockID + this._b;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Block.mushroomBrown.blockID + this._b;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._c = new Icon[_a.length];
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = iconRegister._b(this.getTextureName() + "_" + _a[i]);
        }
        this._e = iconRegister._b(this.getTextureName() + "_" + "inside");
        this._d = iconRegister._b(this.getTextureName() + "_" + "skin_stem");
    }
}

