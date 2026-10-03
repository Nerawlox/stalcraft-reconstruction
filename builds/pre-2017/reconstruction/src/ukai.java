/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ukai
extends WorldGenerator {
    public final vjvn[] _a;
    public final int _b;

    public ukai(vjvn[] vjvnArray, int n) {
        this._a = vjvnArray;
        this._b = n;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = 0;
        while (((n4 = world.getBlockId(n, n2, n3)) == 0 || n4 == Block.leaves.blockID) && n2 > 1) {
            --n2;
        }
        if (n2 < 1) {
            return false;
        }
        ++n2;
        for (int i = 0; i < 4; ++i) {
            int n5;
            int n6;
            int n7 = n + random.nextInt(4) - random.nextInt(4);
            if (!world.isAirBlock(n7, n6 = n2 + random.nextInt(3) - random.nextInt(3), n5 = n3 + random.nextInt(4) - random.nextInt(4)) || !world.doesBlockHaveSolidTopSurface(n7, n6 - 1, n5)) continue;
            world.setBlock(n7, n6, n5, Block.chest.blockID, 0, 2);
            TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n7, n6, n5);
            if (tileEntityChest != null && tileEntityChest != null) {
                vjvn._a(random, this._a, tileEntityChest, this._b);
            }
            if (world.isAirBlock(n7 - 1, n6, n5) && world.doesBlockHaveSolidTopSurface(n7 - 1, n6 - 1, n5)) {
                world.setBlock(n7 - 1, n6, n5, Block.torchWood.blockID, 0, 2);
            }
            if (world.isAirBlock(n7 + 1, n6, n5) && world.doesBlockHaveSolidTopSurface(n7 - 1, n6 - 1, n5)) {
                world.setBlock(n7 + 1, n6, n5, Block.torchWood.blockID, 0, 2);
            }
            if (world.isAirBlock(n7, n6, n5 - 1) && world.doesBlockHaveSolidTopSurface(n7 - 1, n6 - 1, n5)) {
                world.setBlock(n7, n6, n5 - 1, Block.torchWood.blockID, 0, 2);
            }
            if (world.isAirBlock(n7, n6, n5 + 1) && world.doesBlockHaveSolidTopSurface(n7 - 1, n6 - 1, n5)) {
                world.setBlock(n7, n6, n5 + 1, Block.torchWood.blockID, 0, 2);
            }
            return true;
        }
        return false;
    }
}

