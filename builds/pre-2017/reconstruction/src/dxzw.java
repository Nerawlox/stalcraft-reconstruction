/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class dxzw
extends BlockBasePressurePlate {
    public final int _b;

    public dxzw(int n, String string, Material material, int n2) {
        super(n, string, material);
        this._b = n2;
    }

    @Override
    public int _b(World world, int n, int n2, int n3) {
        int n4 = 0;
        for (EntityItem entityItem : world.getEntitiesWithinAABB(EntityItem.class, this._a(n, n2, n3))) {
            if ((n4 += entityItem.getEntityItem()._b) < this._b) continue;
            break;
        }
        if (n4 <= 0) {
            return 0;
        }
        float f = (float)Math.min(this._b, n4) / (float)this._b;
        return sajh._f(f * 15.0f);
    }

    @Override
    public int _b(int n) {
        return n;
    }

    @Override
    public int _c(int n) {
        return n;
    }

    @Override
    public int tickRate(World world) {
        return 10;
    }
}

