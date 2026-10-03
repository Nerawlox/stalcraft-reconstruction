/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class cwkj
extends WorldGenerator {
    public int _a;

    public cwkj(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        if (!world.isAirBlock(n, n2, n3) || world.getBlockId(n, n2 - 1, n3) != this._a) {
            return false;
        }
        int n8 = random.nextInt(32) + 6;
        int n9 = random.nextInt(4) + 1;
        for (n7 = n - n9; n7 <= n + n9; ++n7) {
            for (n6 = n3 - n9; n6 <= n3 + n9; ++n6) {
                n5 = n7 - n;
                n4 = n6 - n3;
                if (n5 * n5 + n4 * n4 > n9 * n9 + 1 || world.getBlockId(n7, n2 - 1, n6) == this._a) continue;
                return false;
            }
        }
        for (n7 = n2; n7 < n2 + n8 && n7 < 128; ++n7) {
            for (n6 = n - n9; n6 <= n + n9; ++n6) {
                for (n5 = n3 - n9; n5 <= n3 + n9; ++n5) {
                    n4 = n6 - n;
                    int n10 = n5 - n3;
                    if (n4 * n4 + n10 * n10 > n9 * n9 + 1) continue;
                    world.setBlock(n6, n7, n5, Block.obsidian.blockID, 0, 2);
                }
            }
        }
        EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal(world);
        entityEnderCrystal.setLocationAndAngles((float)n + 0.5f, n2 + n8, (float)n3 + 0.5f, random.nextFloat() * 360.0f, 0.0f);
        world.spawnEntityInWorld(entityEnderCrystal);
        world.setBlock(n, n2 + n8, n3, Block.bedrock.blockID, 0, 2);
        return true;
    }
}

