/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class rryi
extends ComponentStronghold {
    public rryi() {
    }

    public rryi(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((xciz)structureComponent, list2, random, 1, 1);
    }

    public static rryi _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 11, 8, n4);
        if (!rryi._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new rryi(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 10, 7, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 7, 0);
        this._a(world, random, uken2, EnumDoor._a, 1, 1, 7);
        int n = this._e(Block.stairsCobblestone.blockID, 2);
        for (int i = 0; i < 6; ++i) {
            this._a(world, Block.stairsCobblestone.blockID, n, 1, 6 - i, 1 + i, uken2);
            this._a(world, Block.stairsCobblestone.blockID, n, 2, 6 - i, 1 + i, uken2);
            this._a(world, Block.stairsCobblestone.blockID, n, 3, 6 - i, 1 + i, uken2);
            if (i >= 5) continue;
            this._a(world, Block.stoneBrick.blockID, 0, 1, 5 - i, 1 + i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 2, 5 - i, 1 + i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 3, 5 - i, 1 + i, uken2);
        }
        return true;
    }
}

