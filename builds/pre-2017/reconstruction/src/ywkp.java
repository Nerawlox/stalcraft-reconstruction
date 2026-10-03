/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class ywkp
extends ComponentNetherBridgePiece {
    public ywkp() {
    }

    public ywkp(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((ozrz)structureComponent, list2, random, 5, 3, true);
    }

    public static ywkp _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!ywkp._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new ywkp(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
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
        this._a(world, uken2, 5, 8, 0, 7, 8, 0, Block.netherFence.blockID, Block.netherFence.blockID, false);
        for (n2 = 1; n2 <= 11; n2 += 2) {
            this._a(world, uken2, n2, 10, 0, n2, 11, 0, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, n2, 10, 12, n2, 11, 12, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 0, 10, n2, 0, 11, n2, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 12, 10, n2, 12, 11, n2, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, Block.netherBrick.blockID, 0, n2, 13, 0, uken2);
            this._a(world, Block.netherBrick.blockID, 0, n2, 13, 12, uken2);
            this._a(world, Block.netherBrick.blockID, 0, 0, 13, n2, uken2);
            this._a(world, Block.netherBrick.blockID, 0, 12, 13, n2, uken2);
            this._a(world, Block.netherFence.blockID, 0, n2 + 1, 13, 0, uken2);
            this._a(world, Block.netherFence.blockID, 0, n2 + 1, 13, 12, uken2);
            this._a(world, Block.netherFence.blockID, 0, 0, 13, n2 + 1, uken2);
            this._a(world, Block.netherFence.blockID, 0, 12, 13, n2 + 1, uken2);
        }
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 0, uken2);
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 12, uken2);
        this._a(world, Block.netherFence.blockID, 0, 0, 13, 0, uken2);
        this._a(world, Block.netherFence.blockID, 0, 12, 13, 0, uken2);
        for (n2 = 3; n2 <= 9; n2 += 2) {
            this._a(world, uken2, 1, 7, n2, 1, 8, n2, Block.netherFence.blockID, Block.netherFence.blockID, false);
            this._a(world, uken2, 11, 7, n2, 11, 8, n2, Block.netherFence.blockID, Block.netherFence.blockID, false);
        }
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
        this._a(world, uken2, 5, 5, 5, 7, 5, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 6, 1, 6, 6, 4, 6, 0, 0, false);
        this._a(world, Block.netherBrick.blockID, 0, 6, 0, 6, uken2);
        this._a(world, Block.lavaMoving.blockID, 0, 6, 5, 6, uken2);
        n2 = this._c(6, 6);
        n = this._b(5);
        int n3 = this._d(6, 6);
        if (uken2._b(n2, n, n3)) {
            world.scheduledUpdatesAreImmediate = true;
            Block.blocksList[Block.lavaMoving.blockID].updateTick(world, n2, n, n3, random);
            world.scheduledUpdatesAreImmediate = false;
        }
        return true;
    }
}

