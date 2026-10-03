/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCrossing3
extends ComponentNetherBridgePiece {
    public ComponentNetherBridgeCrossing3() {
    }

    public ComponentNetherBridgeCrossing3(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    public ComponentNetherBridgeCrossing3(Random random, int n, int n2) {
        super(0);
        this._n = random.nextInt(4);
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
                break;
            }
            default: {
                this._m = new uken(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
            }
        }
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._a((ozrz)structureComponent, list, random, 8, 3, false);
        this._b((ozrz)structureComponent, list, random, 3, 8, false);
        this._c((ozrz)structureComponent, list, random, 3, 8, false);
    }

    public static ComponentNetherBridgeCrossing3 _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -8, -3, 0, 19, 10, 19, n4);
        if (!ComponentNetherBridgeCrossing3._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentNetherBridgeCrossing3(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        this._a(world, uken2, 7, 3, 0, 11, 4, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 3, 7, 18, 4, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 8, 5, 0, 10, 7, 18, 0, 0, false);
        this._a(world, uken2, 0, 5, 8, 18, 7, 10, 0, 0, false);
        this._a(world, uken2, 7, 5, 0, 7, 5, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 7, 5, 11, 7, 5, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 11, 5, 0, 11, 5, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 11, 5, 11, 11, 5, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 5, 7, 7, 5, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 11, 5, 7, 18, 5, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 5, 11, 7, 5, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 11, 5, 11, 18, 5, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 7, 2, 0, 11, 2, 5, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 7, 2, 13, 11, 2, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 7, 0, 0, 11, 1, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 7, 0, 15, 11, 1, 18, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n2 = 7; n2 <= 11; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, 18 - n, uken2);
            }
        }
        this._a(world, uken2, 0, 2, 7, 5, 2, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 13, 2, 7, 18, 2, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 0, 7, 3, 1, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 15, 0, 7, 18, 1, 11, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 7; n <= 11; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
                this._b(world, Block.netherBrick.blockID, 0, 18 - n2, -1, n, uken2);
            }
        }
        return true;
    }
}

