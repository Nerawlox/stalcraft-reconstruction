/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class huzs
extends ComponentNetherBridgePiece {
    public huzs() {
    }

    public huzs(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._a((ozrz)structureComponent, list, random, 1, 0, true);
        this._b((ozrz)structureComponent, list, random, 0, 1, true);
        this._c((ozrz)structureComponent, list, random, 0, 1, true);
    }

    public static huzs _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, 0, 0, 5, 7, 5, n4);
        if (!huzs._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new huzs(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        this._a(world, uken2, 0, 0, 0, 4, 1, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 0, 4, 5, 4, 0, 0, false);
        this._a(world, uken2, 0, 2, 0, 0, 5, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 4, 2, 0, 4, 5, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 4, 0, 5, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 4, 2, 4, 4, 5, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 6, 0, 4, 6, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                this._b(world, Block.netherBrick.blockID, 0, i, -1, j, uken2);
            }
        }
        return true;
    }
}

