/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class rqca
extends BlockFlower {
    public rqca(int n) {
        super(n);
        float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (random.nextInt(25) == 0) {
            int n4;
            int n5;
            int n6;
            int n7 = 4;
            int n8 = 5;
            for (n6 = n - n7; n6 <= n + n7; ++n6) {
                for (n5 = n3 - n7; n5 <= n3 + n7; ++n5) {
                    for (n4 = n2 - 1; n4 <= n2 + 1; ++n4) {
                        if (world.getBlockId(n6, n4, n5) != this.blockID || --n8 > 0) continue;
                        return;
                    }
                }
            }
            n6 = n + random.nextInt(3) - 1;
            n5 = n2 + random.nextInt(2) - random.nextInt(2);
            n4 = n3 + random.nextInt(3) - 1;
            for (int i = 0; i < 4; ++i) {
                if (world.isAirBlock(n6, n5, n4) && this.canBlockStay(world, n6, n5, n4)) {
                    n = n6;
                    n2 = n5;
                    n3 = n4;
                }
                n6 = n + random.nextInt(3) - 1;
                n5 = n2 + random.nextInt(2) - random.nextInt(2);
                n4 = n3 + random.nextInt(3) - 1;
            }
            if (world.isAirBlock(n6, n5, n4) && this.canBlockStay(world, n6, n5, n4)) {
                world.setBlock(n6, n5, n4, this.blockID, 0, 2);
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return super.canPlaceBlockAt(world, n, n2, n3) && this.canBlockStay(world, n, n2, n3);
    }

    @Override
    public boolean _a(int n) {
        return Block.opaqueCubeLookup[n];
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        if (n2 >= 0 && n2 < 256) {
            int n4 = world.getBlockId(n, n2 - 1, n3);
            Block block = Block.blocksList[n4];
            return (n4 == Block.mycelium.blockID || world.getFullBlockLightValue(n, n2, n3) < 13) && block != null && block.canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, this);
        }
        return false;
    }

    public boolean _a(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        world.setBlockToAir(n, n2, n3);
        foso foso2 = null;
        if (this.blockID == Block.mushroomBrown.blockID) {
            foso2 = new foso(0);
        } else if (this.blockID == Block.mushroomRed.blockID) {
            foso2 = new foso(1);
        }
        if (foso2 != null && foso2._a(world, random, n, n2, n3)) {
            return true;
        }
        world.setBlock(n, n2, n3, this.blockID, n4, 3);
        return false;
    }
}

