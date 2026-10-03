/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class ywng
extends lqhx {
    public ywng() {
    }

    public ywng(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static ywng _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 9, 9, 6, n4);
        if (!ywng._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ywng(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 9 - 1, 0);
        }
        this._a(world, uken2, 1, 1, 1, 7, 5, 4, 0, 0, false);
        this._a(world, uken2, 0, 0, 0, 8, 0, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 5, 0, 8, 5, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 6, 1, 8, 6, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 7, 2, 8, 7, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        int n3 = this._e(Block.stairsWoodOak.blockID, 3);
        int n4 = this._e(Block.stairsWoodOak.blockID, 2);
        for (n2 = -1; n2 <= 2; ++n2) {
            for (n = 0; n <= 8; ++n) {
                this._a(world, Block.stairsWoodOak.blockID, n3, n, 6 + n2, n2, uken2);
                this._a(world, Block.stairsWoodOak.blockID, n4, n, 6 + n2, 5 - n2, uken2);
            }
        }
        this._a(world, uken2, 0, 1, 0, 0, 1, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 1, 5, 8, 1, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 8, 1, 0, 8, 1, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 2, 1, 0, 7, 1, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 2, 0, 0, 4, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 2, 5, 0, 4, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 8, 2, 5, 8, 4, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 8, 2, 0, 8, 4, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 2, 1, 0, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 2, 5, 7, 4, 5, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 8, 2, 1, 8, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 2, 0, 7, 4, 0, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, Block.thinGlass.blockID, 0, 4, 2, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 5, 2, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 6, 2, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 3, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 5, 3, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 6, 3, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 3, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 3, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 2, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 3, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 3, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 2, 5, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 3, 2, 5, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 5, 2, 5, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 6, 2, 5, uken2);
        this._a(world, uken2, 1, 4, 1, 7, 4, 1, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 4, 4, 7, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 3, 4, 7, 3, 4, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
        this._a(world, Block.planks.blockID, 0, 7, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, this._e(Block.stairsWoodOak.blockID, 0), 7, 1, 3, uken2);
        n2 = this._e(Block.stairsWoodOak.blockID, 3);
        this._a(world, Block.stairsWoodOak.blockID, n2, 6, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, n2, 5, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, n2, 4, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, n2, 3, 1, 4, uken2);
        this._a(world, Block.fence.blockID, 0, 6, 1, 3, uken2);
        this._a(world, Block.pressurePlatePlanks.blockID, 0, 6, 2, 3, uken2);
        this._a(world, Block.fence.blockID, 0, 4, 1, 3, uken2);
        this._a(world, Block.pressurePlatePlanks.blockID, 0, 4, 2, 3, uken2);
        this._a(world, Block.workbench.blockID, 0, 7, 1, 1, uken2);
        this._a(world, 0, 0, 1, 1, 0, uken2);
        this._a(world, 0, 0, 1, 2, 0, uken2);
        this._a(world, uken2, random, 1, 1, 0, this._e(Block.doorWood.blockID, 1));
        if (this._a(world, 1, 0, -1, uken2) == 0 && this._a(world, 1, -1, -1, uken2) != 0) {
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 1, 0, -1, uken2);
        }
        for (n = 0; n < 6; ++n) {
            for (int i = 0; i < 9; ++i) {
                this._b(world, i, 9, n, uken2);
                this._b(world, Block.cobblestone.blockID, 0, i, -1, n, uken2);
            }
        }
        this._a(world, uken2, 2, 1, 2, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 1;
    }
}

