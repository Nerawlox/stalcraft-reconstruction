/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class wqhh
extends lqhx {
    public wqhh() {
    }

    public wqhh(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static wqhh _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 9, 7, 11, n4);
        if (!wqhh._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new wqhh(fovt2, n5, random, uken2, n4);
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
            this._m._a(0, this._a - this._m._e + 7 - 1, 0);
        }
        this._a(world, uken2, 1, 1, 1, 7, 4, 4, 0, 0, false);
        this._a(world, uken2, 2, 1, 6, 8, 4, 10, 0, 0, false);
        this._a(world, uken2, 2, 0, 6, 8, 0, 10, Block.dirt.blockID, Block.dirt.blockID, false);
        this._a(world, Block.cobblestone.blockID, 0, 6, 0, 6, uken2);
        this._a(world, uken2, 2, 1, 6, 2, 1, 10, Block.fence.blockID, Block.fence.blockID, false);
        this._a(world, uken2, 8, 1, 6, 8, 1, 10, Block.fence.blockID, Block.fence.blockID, false);
        this._a(world, uken2, 3, 1, 10, 7, 1, 10, Block.fence.blockID, Block.fence.blockID, false);
        this._a(world, uken2, 1, 0, 1, 7, 0, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 0, 0, 0, 3, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 8, 0, 0, 8, 3, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 0, 0, 7, 1, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 0, 5, 7, 1, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 2, 0, 7, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 2, 5, 7, 3, 5, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 4, 1, 8, 4, 1, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 4, 4, 8, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 5, 2, 8, 5, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, Block.planks.blockID, 0, 0, 4, 2, uken2);
        this._a(world, Block.planks.blockID, 0, 0, 4, 3, uken2);
        this._a(world, Block.planks.blockID, 0, 8, 4, 2, uken2);
        this._a(world, Block.planks.blockID, 0, 8, 4, 3, uken2);
        int n3 = this._e(Block.stairsWoodOak.blockID, 3);
        int n4 = this._e(Block.stairsWoodOak.blockID, 2);
        for (n2 = -1; n2 <= 2; ++n2) {
            for (n = 0; n <= 8; ++n) {
                this._a(world, Block.stairsWoodOak.blockID, n3, n, 4 + n2, n2, uken2);
                this._a(world, Block.stairsWoodOak.blockID, n4, n, 4 + n2, 5 - n2, uken2);
            }
        }
        this._a(world, Block.wood.blockID, 0, 0, 2, 1, uken2);
        this._a(world, Block.wood.blockID, 0, 0, 2, 4, uken2);
        this._a(world, Block.wood.blockID, 0, 8, 2, 1, uken2);
        this._a(world, Block.wood.blockID, 0, 8, 2, 4, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 8, 2, 3, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 2, 5, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 3, 2, 5, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 5, 2, 0, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 6, 2, 5, uken2);
        this._a(world, Block.fence.blockID, 0, 2, 1, 3, uken2);
        this._a(world, Block.pressurePlatePlanks.blockID, 0, 2, 2, 3, uken2);
        this._a(world, Block.planks.blockID, 0, 1, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, this._e(Block.stairsWoodOak.blockID, 3), 2, 1, 4, uken2);
        this._a(world, Block.stairsWoodOak.blockID, this._e(Block.stairsWoodOak.blockID, 1), 1, 1, 3, uken2);
        this._a(world, uken2, 5, 0, 1, 7, 0, 3, Block.stoneDoubleSlab.blockID, Block.stoneDoubleSlab.blockID, false);
        this._a(world, Block.stoneDoubleSlab.blockID, 0, 6, 1, 1, uken2);
        this._a(world, Block.stoneDoubleSlab.blockID, 0, 6, 1, 2, uken2);
        this._a(world, 0, 0, 2, 1, 0, uken2);
        this._a(world, 0, 0, 2, 2, 0, uken2);
        this._a(world, Block.torchWood.blockID, 0, 2, 3, 1, uken2);
        this._a(world, uken2, random, 2, 1, 0, this._e(Block.doorWood.blockID, 1));
        if (this._a(world, 2, 0, -1, uken2) == 0 && this._a(world, 2, -1, -1, uken2) != 0) {
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 2, 0, -1, uken2);
        }
        this._a(world, 0, 0, 6, 1, 5, uken2);
        this._a(world, 0, 0, 6, 2, 5, uken2);
        this._a(world, Block.torchWood.blockID, 0, 6, 3, 4, uken2);
        this._a(world, uken2, random, 6, 1, 5, this._e(Block.doorWood.blockID, 1));
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 9; ++n) {
                this._b(world, n, 7, n2, uken2);
                this._b(world, Block.cobblestone.blockID, 0, n, -1, n2, uken2);
            }
        }
        this._a(world, uken2, 4, 1, 2, 2);
        return true;
    }

    @Override
    public int _a(int n) {
        if (n == 0) {
            return 4;
        }
        return 0;
    }
}

