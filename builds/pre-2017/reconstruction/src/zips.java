/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureComponent;

public class zips
extends ComponentNetherBridgePiece {
    public boolean _a;

    public zips() {
    }

    public zips(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._a = nBTTagCompound._o("Mob");
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Mob", this._a);
    }

    public static zips _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -2, 0, 0, 7, 8, 9, n4);
        if (!zips._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new zips(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        this._a(world, uken2, 0, 2, 0, 6, 7, 7, 0, 0, false);
        this._a(world, uken2, 1, 0, 0, 5, 1, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 2, 1, 5, 2, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 3, 2, 5, 3, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 4, 3, 5, 4, 7, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 2, 0, 1, 4, 2, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 5, 2, 0, 5, 4, 2, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 5, 2, 1, 5, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 5, 5, 2, 5, 5, 3, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 0, 5, 3, 0, 5, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 6, 5, 3, 6, 5, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, uken2, 1, 5, 8, 5, 5, 8, Block.netherBrick.blockID, Block.netherBrick.blockID, false);
        this._a(world, Block.netherFence.blockID, 0, 1, 6, 3, uken2);
        this._a(world, Block.netherFence.blockID, 0, 5, 6, 3, uken2);
        this._a(world, uken2, 0, 6, 3, 0, 6, 8, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 6, 6, 3, 6, 6, 8, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 1, 6, 8, 5, 7, 8, Block.netherFence.blockID, Block.netherFence.blockID, false);
        this._a(world, uken2, 2, 8, 8, 4, 8, 8, Block.netherFence.blockID, Block.netherFence.blockID, false);
        if (!this._a) {
            int n3;
            n2 = this._b(5);
            n = this._c(3, 5);
            if (uken2._b(n, n2, n3 = this._d(3, 5))) {
                this._a = true;
                world.setBlock(n, n2, n3, Block.mobSpawner.blockID, 0, 2);
                xtcq xtcq2 = (xtcq)world.getBlockTileEntity(n, n2, n3);
                if (xtcq2 != null) {
                    xtcq2._a()._a("Blaze");
                }
            }
        }
        for (n2 = 0; n2 <= 6; ++n2) {
            for (n = 0; n <= 6; ++n) {
                this._b(world, Block.netherBrick.blockID, 0, n2, -1, n, uken2);
            }
        }
        return true;
    }
}

