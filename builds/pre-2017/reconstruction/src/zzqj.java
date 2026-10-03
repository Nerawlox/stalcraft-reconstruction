/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class zzqj
extends ComponentStronghold {
    public zzqj() {
    }

    public zzqj(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((xciz)structureComponent, list2, random, 1, 1);
    }

    public static zzqj _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 9, 5, 11, n4);
        if (!zzqj._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new zzqj(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 8, 4, 10, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 1, 0);
        this._a(world, uken2, 1, 1, 10, 3, 3, 10, 0, 0, false);
        this._a(world, uken2, 4, 1, 1, 4, 3, 1, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 3, 4, 3, 3, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 7, 4, 3, 7, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 9, 4, 3, 9, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 4, 4, 3, 6, Block.fenceIron.blockID, Block.fenceIron.blockID, false);
        this._a(world, uken2, 5, 1, 5, 7, 3, 5, Block.fenceIron.blockID, Block.fenceIron.blockID, false);
        this._a(world, Block.fenceIron.blockID, 0, 4, 3, 2, uken2);
        this._a(world, Block.fenceIron.blockID, 0, 4, 3, 8, uken2);
        this._a(world, Block.doorIron.blockID, this._e(Block.doorIron.blockID, 3), 4, 1, 2, uken2);
        this._a(world, Block.doorIron.blockID, this._e(Block.doorIron.blockID, 3) + 8, 4, 2, 2, uken2);
        this._a(world, Block.doorIron.blockID, this._e(Block.doorIron.blockID, 3), 4, 1, 8, uken2);
        this._a(world, Block.doorIron.blockID, this._e(Block.doorIron.blockID, 3) + 8, 4, 2, 8, uken2);
        return true;
    }
}

