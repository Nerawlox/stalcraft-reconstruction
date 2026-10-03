/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class xtln
extends ComponentNetherBridgePiece {
    public xtln() {
    }

    public xtln(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._c((ozrz)structureComponent, list, random, 6, 2, false);
    }

    public static xtln _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -2, 0, 0, 7, 11, 7, n4);
        if (!xtln._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new xtln(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        this._a(world, uken2, 0, 0, 0, 6, 1, 6, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 0, 6, 10, 6, 0, 0, false);
        this._a(world, uken2, 0, 2, 0, 1, 8, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 5, 2, 0, 6, 8, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 1, 0, 8, 6, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 6, 2, 1, 6, 8, 6, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 2, 6, 5, 8, 6, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 3, 2, 0, 5, 4, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 6, 3, 2, 6, 5, 2, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 6, 3, 4, 6, 5, 4, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, Block.netherBrick.blockID, 0, 5, 2, 5, uken2);
        this._a(world, uken2, 4, 2, 5, 4, 3, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 3, 2, 5, 3, 4, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 2, 5, 2, 5, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 2, 5, 1, 6, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 7, 1, 5, 7, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 6, 8, 2, 6, 8, 4, 0, 0, false);
        this._a(world, uken2, 2, 6, 0, 4, 8, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 5, 0, 4, 5, 0, Block.netherFence.blockID, Block.netherFence.blockID, false);
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this._b(world, Block.netherBrick.blockID, 0, i, -1, j, uken2);
            }
        }
        return true;
    }
}

