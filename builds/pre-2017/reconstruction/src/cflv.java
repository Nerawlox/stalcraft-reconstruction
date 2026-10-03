/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.owak;
import net.minecraft.util.ugqx;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class cflv
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = n;
        int n5 = n3;
        while (n2 < 128) {
            if (world.isAirBlock(n, n2, n3)) {
                for (int i = 2; i <= 5; ++i) {
                    if (!Block.vine.canPlaceBlockOnSide(world, n, n2, n3, i)) continue;
                    world.setBlock(n, n2, n3, Block.vine.blockID, 1 << ugqx._e[owak._a[i]], 2);
                    break;
                }
            } else {
                n = n4 + random.nextInt(4) - random.nextInt(4);
                n3 = n5 + random.nextInt(4) - random.nextInt(4);
            }
            ++n2;
        }
        return true;
    }
}

