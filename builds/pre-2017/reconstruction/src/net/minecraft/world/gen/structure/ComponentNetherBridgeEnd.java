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

public class ComponentNetherBridgeEnd
extends ComponentNetherBridgePiece {
    public int _a;

    public ComponentNetherBridgeEnd() {
    }

    public ComponentNetherBridgeEnd(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt();
    }

    public static ComponentNetherBridgeEnd _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -3, 0, 5, 10, 8, n4);
        if (!ComponentNetherBridgeEnd._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new ComponentNetherBridgeEnd(n5, random, uken2, n4);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._a = nBTTagCompound._f("Seed");
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Seed", this._a);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        Random random2 = new Random(this._a);
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 3; n2 <= 4; ++n2) {
                n = random2.nextInt(8);
                this._a(world, uken2, n3, n2, 0, n3, n2, n, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            }
        }
        n3 = random2.nextInt(8);
        this._a(world, uken2, 0, 5, 0, 0, 5, n3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        n3 = random2.nextInt(8);
        this._a(world, uken2, 4, 5, 0, 4, 5, n3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        for (n3 = 0; n3 <= 4; ++n3) {
            n2 = random2.nextInt(5);
            this._a(world, uken2, n3, 2, 0, n3, 2, n2, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        }
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 0; n2 <= 1; ++n2) {
                n = random2.nextInt(3);
                this._a(world, uken2, n3, n2, 0, n3, n2, n, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
            }
        }
        return true;
    }
}

