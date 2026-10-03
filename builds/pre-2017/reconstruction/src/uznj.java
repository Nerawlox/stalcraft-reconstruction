/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public abstract class uznj
extends Block {
    public Icon _d;

    public uznj(int n, Material material) {
        super(n, material);
    }

    @Override
    public int getRenderType() {
        return 31;
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5 & 3;
        int n7 = 0;
        switch (n4) {
            case 2: 
            case 3: {
                n7 = 8;
                break;
            }
            case 4: 
            case 5: {
                n7 = 4;
                break;
            }
            case 0: 
            case 1: {
                n7 = 0;
            }
        }
        return n6 | n7;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        int n3 = n2 & 0xC;
        int n4 = n2 & 3;
        if (n3 == 0 && (n == 1 || n == 0)) {
            return this._b(n4);
        }
        if (n3 == 4 && (n == 5 || n == 4)) {
            return this._b(n4);
        }
        if (n3 == 8 && (n == 2 || n == 3)) {
            return this._b(n4);
        }
        return this._a(n4);
    }

    public abstract Icon _a(int var1);

    public Icon _b(int n) {
        return this._d;
    }

    @Override
    public int damageDropped(int n) {
        return n & 3;
    }

    public int _d(int n) {
        return n & 3;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(this.blockID, 1, this._d(n));
    }
}

