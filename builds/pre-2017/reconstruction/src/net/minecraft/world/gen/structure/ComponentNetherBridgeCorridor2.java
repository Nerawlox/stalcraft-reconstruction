/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCorridor2
extends ComponentNetherBridgePiece {
    public boolean _a;

    public ComponentNetherBridgeCorridor2() {
    }

    public ComponentNetherBridgeCorridor2(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt(3) == 0;
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._a = nBTTagCompound._o("Chest");
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Chest", this._a);
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._c((ozrz)structureComponent, list, random, 0, 1, true);
    }

    public static ComponentNetherBridgeCorridor2 _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, 0, 0, 5, 7, 5, n4);
        if (!ComponentNetherBridgeCorridor2._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentNetherBridgeCorridor2(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        this._a(world, uken2, 0, 0, 0, 4, 1, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 2, 0, 4, 5, 4, 0, 0, false);
        this._a(world, uken2, 0, 2, 0, 0, 5, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 3, 1, 0, 4, 1, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 0, 3, 3, 0, 4, 3, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 4, 2, 0, 4, 5, 0, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 2, 4, 4, 5, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 3, 4, 1, 4, 4, Block.netherFence.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 3, 3, 4, 3, 4, 4, Block.netherFence.blockID, Block.netherBrick.blockID, false);
        if (this._a) {
            int n3;
            n2 = this._b(2);
            n = this._c(1, 3);
            if (uken2._b(n, n2, n3 = this._d(1, 3))) {
                this._a = false;
                this._a(world, uken2, random, 1, 2, 3, _b, 2 + random.nextInt(4));
            }
        }
        this._a(world, uken2, 0, 6, 0, 4, 6, 4, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n2 = 0; n2 <= 4; ++n2) {
            for (n = 0; n <= 4; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
            }
        }
        return true;
    }
}

