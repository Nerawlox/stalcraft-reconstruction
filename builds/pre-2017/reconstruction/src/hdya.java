/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class hdya
extends ComponentNetherBridgePiece {
    public hdya() {
    }

    public hdya(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((ozrz)structureComponent, list2, random, 1, 0, true);
    }

    public static hdya _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 14, 10, n4);
        if (!hdya._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new hdya(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n = this._e(Block.stairsNetherBrick.blockID, 2);
        for (int i = 0; i <= 9; ++i) {
            int n2 = Math.max(1, 7 - i);
            int n3 = Math.min(Math.max(n2 + 5, 14 - i), 13);
            int n4 = i;
            this._a(world, uken2, 0, 0, n4, 4, n2, n4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            this._a(world, uken2, 1, n2 + 1, n4, 3, n3 - 1, n4, 0, 0, false);
            if (i <= 6) {
                this._a(world, Block.stairsNetherBrick.blockID, n, 1, n2 + 1, n4, uken2);
                this._a(world, Block.stairsNetherBrick.blockID, n, 2, n2 + 1, n4, uken2);
                this._a(world, Block.stairsNetherBrick.blockID, n, 3, n2 + 1, n4, uken2);
            }
            this._a(world, uken2, 0, n3, n4, 4, n3, n4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            this._a(world, uken2, 0, n2 + 1, n4, 0, n3 - 1, n4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            this._a(world, uken2, 4, n2 + 1, n4, 4, n3 - 1, n4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            if ((i & 1) == 0) {
                this._a(world, uken2, 0, n2 + 2, n4, 0, n2 + 3, n4, Block.netherFence.blockID, Block.netherFence.blockID, false);
                this._a(world, uken2, 4, n2 + 2, n4, 4, n2 + 3, n4, Block.netherFence.blockID, Block.netherFence.blockID, false);
            }
            for (int j = 0; j <= 4; ++j) {
                this._b(world, Block.netherBrick.blockID, 0, j, -1, n4, uken2);
            }
        }
        return true;
    }
}

