/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class zzkp
extends BiomeGenBase {
    public WorldGenerator _U;

    public zzkp(int n) {
        super(n);
        this._U = new qoqx(Block.silverfish.blockID, 8);
    }

    @Override
    public void _a(World world, Random random, int n, int n2) {
        int n3;
        int n4;
        int n5;
        super._a(world, random, n, n2);
        int n6 = 3 + random.nextInt(6);
        for (n5 = 0; n5 < n6; ++n5) {
            int n7;
            n4 = n + random.nextInt(16);
            int n8 = world.getBlockId(n4, n3 = random.nextInt(28) + 4, n7 = n2 + random.nextInt(16));
            if (n8 != Block.stone.blockID) continue;
            world.setBlock(n4, n3, n7, Block.oreEmerald.blockID, 0, 2);
        }
        for (n6 = 0; n6 < 7; ++n6) {
            n5 = n + random.nextInt(16);
            n4 = random.nextInt(64);
            n3 = n2 + random.nextInt(16);
            this._U._a(world, random, n5, n4, n3);
        }
    }
}

