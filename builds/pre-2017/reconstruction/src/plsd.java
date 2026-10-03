/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class plsd
extends lqhx {
    public plsd() {
    }

    public plsd(fovt fovt2, int n, Random random, int n2, int n3) {
        super(fovt2, n);
        this._n = random.nextInt(4);
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n2, 64, n3, n2 + 6 - 1, 78, n3 + 6 - 1);
                break;
            }
            default: {
                this._m = new uken(n2, 64, n3, n2 + 6 - 1, 78, n3 + 6 - 1);
            }
        }
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        tybp._e((fovt)structureComponent, list, random, this._m._a - 1, this._m._e - 4, this._m._c + 1, 1, this._e());
        tybp._e((fovt)structureComponent, list, random, this._m._d + 1, this._m._e - 4, this._m._c + 1, 3, this._e());
        tybp._e((fovt)structureComponent, list, random, this._m._a + 1, this._m._e - 4, this._m._c - 1, 2, this._e());
        tybp._e((fovt)structureComponent, list, random, this._m._a + 1, this._m._e - 4, this._m._f + 1, 0, this._e());
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 3, 0);
        }
        this._a(world, uken2, 1, 0, 1, 4, 12, 4, Block.cobblestone.blockID, Block.waterMoving.blockID, false);
        this._a(world, 0, 0, 2, 12, 2, uken2);
        this._a(world, 0, 0, 3, 12, 2, uken2);
        this._a(world, 0, 0, 2, 12, 3, uken2);
        this._a(world, 0, 0, 3, 12, 3, uken2);
        this._a(world, Block.fence.blockID, 0, 1, 13, 1, uken2);
        this._a(world, Block.fence.blockID, 0, 1, 14, 1, uken2);
        this._a(world, Block.fence.blockID, 0, 4, 13, 1, uken2);
        this._a(world, Block.fence.blockID, 0, 4, 14, 1, uken2);
        this._a(world, Block.fence.blockID, 0, 1, 13, 4, uken2);
        this._a(world, Block.fence.blockID, 0, 1, 14, 4, uken2);
        this._a(world, Block.fence.blockID, 0, 4, 13, 4, uken2);
        this._a(world, Block.fence.blockID, 0, 4, 14, 4, uken2);
        this._a(world, uken2, 1, 15, 1, 4, 15, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 5; ++j) {
                if (j != 0 && j != 5 && i != 0 && i != 5) continue;
                this._a(world, Block.gravel.blockID, 0, j, 11, i, uken2);
                this._b(world, j, 12, i, uken2);
            }
        }
        return true;
    }
}

