/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class raya
extends ComponentNetherBridgePiece {
    public raya() {
    }

    public raya(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._a((ozrz)structureComponent, list, random, 5, 3, true);
        this._a((ozrz)structureComponent, list, random, 5, 11, true);
    }

    public static raya _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!raya._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new raya(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        this._a(world, uken2, 0, 3, 0, 12, 4, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 5, 0, 12, 13, 12, 0, 0, false);
        this._a(world, uken2, 0, 5, 0, 1, 12, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 11, 5, 0, 12, 12, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 5, 11, 4, 12, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 8, 5, 11, 10, 12, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 5, 9, 11, 7, 12, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 5, 0, 4, 12, 1, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 8, 5, 0, 10, 12, 1, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 5, 9, 0, 7, 12, 1, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 11, 2, 10, 12, 10, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n5 = 1; n5 <= 11; n5 += 2) {
            this._a(world, uken2, n5, 10, 0, n5, 11, 0, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, n5, 10, 12, n5, 11, 12, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 0, 10, n5, 0, 11, n5, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 12, 10, n5, 12, 11, n5, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, Block.netherBrick.blockID, 0, n5, 13, 0, uken2);
            this._a(world, Block.netherBrick.blockID, 0, n5, 13, 12, uken2);
            this._a(world, Block.netherBrick.blockID, 0, 0, 13, n5, uken2);
            this._a(world, Block.netherBrick.blockID, 0, 12, 13, n5, uken2);
            this._a(world, Block.netherFence.blockID, 0, n5 + 1, 13, 0, uken2);
            this._a(world, Block.netherFence.blockID, 0, n5 + 1, 13, 12, uken2);
            this._a(world, Block.netherFence.blockID, 0, 0, 13, n5 + 1, uken2);
            this._a(world, Block.netherFence.blockID, 0, 12, 13, n5 + 1, uken2);
        }
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 0, uken2);
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 12, uken2);
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 0, uken2);
        this._a(world, Block.netherFence.blockID, 0, 12, 13, 0, uken2);
        for (n5 = 3; n5 <= 9; n5 += 2) {
            this._a(world, uken2, 1, 7, n5, 1, 8, n5, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 11, 7, n5, 11, 8, n5, Block.netherFence.blockID, Block.netherFence.blockID, false);
        }
        n5 = this._e(Block.stairsNetherBrick.blockID, 3);
        for (n4 = 0; n4 <= 6; ++n4) {
            n3 = n4 + 4;
            for (n2 = 5; n2 <= 7; ++n2) {
                this._a(world, Block.stairsNetherBrick.blockID, n5, n2, 5 + n4, n3, uken2);
            }
            if (n3 >= 5 && n3 <= 8) {
                this._a(world, uken2, 5, 5, n3, 7, n4 + 4, n3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            } else if (n3 >= 9 && n3 <= 10) {
                this._a(world, uken2, 5, 8, n3, 7, n4 + 4, n3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            }
            if (n4 < 1) continue;
            this._a(world, uken2, 5, 6 + n4, n3, 7, 9 + n4, n3, 0, 0, false);
        }
        for (n4 = 5; n4 <= 7; ++n4) {
            this._a(world, Block.stairsNetherBrick.blockID, n5, n4, 12, 11, uken2);
        }
        this._a(world, uken2, 5, 6, 7, 5, 7, 7, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 7, 6, 7, 7, 7, 7, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 5, 13, 12, 7, 13, 12, 0, 0, false);
        this._a(world, uken2, 2, 5, 2, 3, 5, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 5, 9, 3, 5, 10, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 2, 5, 4, 2, 5, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 9, 5, 2, 10, 5, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 9, 5, 9, 10, 5, 10, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 10, 5, 4, 10, 5, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        n4 = this._e(Block.stairsNetherBrick.blockID, 0);
        n3 = this._e(Block.stairsNetherBrick.blockID, 1);
        this._a(world, Block.stairsNetherBrick.blockID, n3, 4, 5, 2, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n3, 4, 5, 3, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n3, 4, 5, 9, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n3, 4, 5, 10, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n4, 8, 5, 2, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n4, 8, 5, 3, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n4, 8, 5, 9, uken2);
        this._a(world, Block.stairsNetherBrick.blockID, n4, 8, 5, 10, uken2);
        this._a(world, uken2, 3, 4, 4, 4, 4, 8, Block.slowSand.blockID, Block.slowSand.blockID, false);
        this._a(world, uken2, 8, 4, 4, 9, 4, 8, Block.slowSand.blockID, Block.slowSand.blockID, false);
        this._a(world, uken2, 3, 5, 4, 4, 5, 8, Block.netherStalk.blockID, Block.netherStalk.blockID, false);
        this._a(world, uken2, 8, 5, 4, 9, 5, 8, Block.netherStalk.blockID, Block.netherStalk.blockID, false);
        this._a(world, uken2, 4, 2, 0, 8, 2, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 4, 12, 2, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 4, 0, 0, 8, 1, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 4, 0, 9, 8, 1, 12, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 0, 4, 3, 1, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 9, 0, 4, 12, 1, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n2 = 4; n2 <= 8; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, 12 - n, uken2);
            }
        }
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 4; n <= 8; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
                this._b(world, Block.netherBrick.blockID, 0, 12 - n2, -1, n, uken2);
            }
        }
        return true;
    }
}

