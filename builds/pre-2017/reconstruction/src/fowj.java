/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class fowj
extends lqhx {
    public int _e;
    public int _f;

    public fowj() {
    }

    public fowj(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = this._a(random);
        this._f = this._a(random);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("CA", this._e);
        nBTTagCompound._a("CB", this._f);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e = nBTTagCompound._f("CA");
        this._f = nBTTagCompound._f("CB");
    }

    public int _a(Random random) {
        switch (random.nextInt(5)) {
            default: {
                return Block.crops.blockID;
            }
            case 0: {
                return Block.carrot.blockID;
            }
            case 1: 
        }
        return Block.potato.blockID;
    }

    public static fowj _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 7, 4, 9, n4);
        if (!fowj._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new fowj(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 4 - 1, 0);
        }
        this._a(world, uken2, 0, 1, 0, 6, 4, 8, 0, 0, false);
        this._a(world, uken2, 1, 0, 1, 2, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this._a(world, uken2, 4, 0, 1, 5, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this._a(world, uken2, 0, 0, 0, 0, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 6, 0, 0, 6, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 1, 0, 0, 5, 0, 0, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 1, 0, 8, 5, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 3, 0, 1, 3, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        for (n = 1; n <= 7; ++n) {
            this._a(world, this._e, sajh._a(random, 2, 7), 1, 1, n, uken2);
            this._a(world, this._e, sajh._a(random, 2, 7), 2, 1, n, uken2);
            this._a(world, this._f, sajh._a(random, 2, 7), 4, 1, n, uken2);
            this._a(world, this._f, sajh._a(random, 2, 7), 5, 1, n, uken2);
        }
        for (n = 0; n < 9; ++n) {
            for (int i = 0; i < 7; ++i) {
                this._b(world, i, 4, n, uken2);
                this._b(world, Block.dirt.blockID, 0, i, -1, n, uken2);
            }
        }
        return true;
    }
}

