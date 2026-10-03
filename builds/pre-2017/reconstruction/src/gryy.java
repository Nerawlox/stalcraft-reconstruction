/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class gryy
extends lqhx {
    public boolean _e;
    public int _f;

    public gryy() {
    }

    public gryy(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = random.nextBoolean();
        this._f = random.nextInt(3);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("T", this._f);
        nBTTagCompound._a("C", this._e);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._f = nBTTagCompound._f("T");
        this._e = nBTTagCompound._o("C");
    }

    public static gryy _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 4, 6, 5, n4);
        if (!gryy._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new gryy(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(world, uken2, 1, 1, 1, 3, 5, 4, 0, 0, false);
        this._a(world, uken2, 0, 0, 0, 3, 0, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 1, 0, 1, 2, 0, 3, Block.dirt.blockID, Block.dirt.blockID, false);
        if (this._e) {
            this._a(world, uken2, 1, 4, 1, 2, 4, 3, Block.wood.blockID, Block.wood.blockID, false);
        } else {
            this._a(world, uken2, 1, 5, 1, 2, 5, 3, Block.wood.blockID, Block.wood.blockID, false);
        }
        this._a(world, Block.wood.blockID, 0, 1, 4, 0, uken2);
        this._a(world, Block.wood.blockID, 0, 2, 4, 0, uken2);
        this._a(world, Block.wood.blockID, 0, 1, 4, 4, uken2);
        this._a(world, Block.wood.blockID, 0, 2, 4, 4, uken2);
        this._a(world, Block.wood.blockID, 0, 0, 4, 1, uken2);
        this._a(world, Block.wood.blockID, 0, 0, 4, 2, uken2);
        this._a(world, Block.wood.blockID, 0, 0, 4, 3, uken2);
        this._a(world, Block.wood.blockID, 0, 3, 4, 1, uken2);
        this._a(world, Block.wood.blockID, 0, 3, 4, 2, uken2);
        this._a(world, Block.wood.blockID, 0, 3, 4, 3, uken2);
        this._a(world, uken2, 0, 1, 0, 0, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 3, 1, 0, 3, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 0, 1, 4, 0, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 3, 1, 4, 3, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 0, 1, 1, 0, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 3, 1, 1, 3, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 1, 0, 2, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 1, 4, 2, 3, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 3, 2, 2, uken2);
        if (this._f > 0) {
            this._a(world, Block.fence.blockID, 0, this._f, 1, 3, uken2);
            this._a(world, Block.pressurePlatePlanks.blockID, 0, this._f, 2, 3, uken2);
        }
        this._a(world, 0, 0, 1, 1, 0, uken2);
        this._a(world, 0, 0, 1, 2, 0, uken2);
        this._a(world, uken2, random, 1, 1, 0, this._e(Block.doorWood.blockID, 1));
        if (this._a(world, 1, 0, -1, uken2) == 0 && this._a(world, 1, -1, -1, uken2) != 0) {
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 1, 0, -1, uken2);
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                this._b(world, j, 6, i, uken2);
                this._b(world, Block.cobblestone.blockID, 0, j, -1, i, uken2);
            }
        }
        this._a(world, uken2, 1, 1, 2, 1);
        return true;
    }
}

