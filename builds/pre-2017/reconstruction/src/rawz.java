/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class rawz
extends lqhx {
    public rawz() {
    }

    public rawz(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static rawz _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 5, 12, 9, n4);
        if (!rawz._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new rawz(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 12 - 1, 0);
        }
        this._a(world, uken2, 1, 1, 1, 3, 3, 7, 0, 0, false);
        this._a(world, uken2, 1, 5, 1, 3, 9, 3, 0, 0, false);
        this._a(world, uken2, 1, 0, 0, 3, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 1, 0, 3, 10, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 1, 1, 0, 10, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 4, 1, 1, 4, 10, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 0, 4, 0, 4, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 4, 0, 4, 4, 4, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 1, 8, 3, 4, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 5, 4, 3, 10, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 5, 5, 3, 5, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 9, 0, 4, 9, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 4, 0, 4, 4, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, Block.cobblestone.blockID, 0, 0, 11, 2, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 11, 2, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 2, 11, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 2, 11, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 1, 1, 6, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 1, 1, 7, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 2, 1, 7, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 3, 1, 6, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 3, 1, 7, uken2);
        this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 1, 1, 5, uken2);
        this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 2, 1, 6, uken2);
        this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 3, 1, 5, uken2);
        this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 1), 1, 2, 7, uken2);
        this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 0), 3, 2, 7, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 3, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 3, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 6, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 7, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 6, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 7, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 6, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 7, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 6, 4, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 7, 4, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 3, 6, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 3, 6, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 3, 8, uken2);
        this._a(world, Block.torchWood.blockID, 0, 2, 4, 7, uken2);
        this._a(world, Block.torchWood.blockID, 0, 1, 4, 6, uken2);
        this._a(world, Block.torchWood.blockID, 0, 3, 4, 6, uken2);
        this._a(world, Block.torchWood.blockID, 0, 2, 4, 5, uken2);
        int n2 = this._e(Block.ladder.blockID, 4);
        for (n = 1; n <= 9; ++n) {
            this._a(world, Block.ladder.blockID, n2, 3, n, 3, uken2);
        }
        this._a(world, 0, 0, 2, 1, 0, uken2);
        this._a(world, 0, 0, 2, 2, 0, uken2);
        this._a(world, uken2, random, 2, 1, 0, this._e(Block.doorWood.blockID, 1));
        if (this._a(world, 2, 0, -1, uken2) == 0 && this._a(world, 2, -1, -1, uken2) != 0) {
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 2, 0, -1, uken2);
        }
        for (n = 0; n < 9; ++n) {
            for (int i = 0; i < 5; ++i) {
                this._b(world, i, 12, n, uken2);
                this._b(world, Block.cobblestone.blockID, 0, i, -1, n, uken2);
            }
        }
        this._a(world, uken2, 2, 1, 2, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 2;
    }
}

