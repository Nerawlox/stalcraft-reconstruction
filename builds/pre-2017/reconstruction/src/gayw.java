/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class gayw
extends ComponentNetherBridgePiece {
    public gayw() {
    }

    public gayw(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((ozrz)structureComponent, list2, random, 1, 3, false);
    }

    public static gayw _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -3, 0, 5, 10, 19, n4);
        if (!gayw._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new gayw(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        this._a(world, uken2, 0, 3, 0, 4, 4, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 5, 0, 3, 7, 18, 0, 0, false);
        this._a(world, uken2, 0, 5, 0, 0, 5, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 4, 5, 0, 4, 5, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 0, 4, 2, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 13, 4, 2, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 0, 0, 4, 1, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 0, 15, 4, 1, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 2; ++j) {
                this._b(world, Block.netherBrick.blockID, 0, i, -1, j, uken2);
                this._b(world, Block.netherBrick.blockID, 0, i, -1, 18 - j, uken2);
            }
        }
        this._a(world, uken2, 0, 1, 1, 0, 4, 1, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 0, 3, 4, 0, 4, 4, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 0, 3, 14, 0, 4, 14, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 0, 1, 17, 0, 4, 17, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 4, 1, 1, 4, 4, 1, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 4, 3, 4, 4, 4, 4, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 4, 3, 14, 4, 4, 14, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 4, 1, 17, 4, 4, 17, Block.netherFence.blockID, Block.netherFence.blockID, false);
        return true;
    }
}

