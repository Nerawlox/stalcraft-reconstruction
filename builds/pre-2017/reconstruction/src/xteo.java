/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class xteo
extends BiomeGenBase {
    public xteo(int n) {
        super(n);
        this._I.treesPerChunk = 50;
        this._I.grassPerChunk = 25;
        this._I.flowersPerChunk = 4;
        this._J.add(new yffo(EntityOcelot.class, 2, 1, 1));
        this._K.add(new yffo(EntityChicken.class, 10, 4, 4));
    }

    @Override
    public WorldGenerator _a(Random random) {
        if (random.nextInt(10) == 0) {
            return this._R;
        }
        if (random.nextInt(2) == 0) {
            return new rasl(3, 0);
        }
        if (random.nextInt(3) == 0) {
            return new mtgt(false, 10 + random.nextInt(20), 3, 3);
        }
        return new dzqi(false, 4 + random.nextInt(7), 3, 3, true);
    }

    @Override
    public WorldGenerator _b(Random random) {
        if (random.nextInt(4) == 0) {
            return new zinw(Block.tallGrass.blockID, 2);
        }
        return new zinw(Block.tallGrass.blockID, 1);
    }

    @Override
    public void _a(World world, Random random, int n, int n2) {
        super._a(world, random, n, n2);
        cflv cflv2 = new cflv();
        for (int i = 0; i < 50; ++i) {
            int n3 = n + random.nextInt(16) + 8;
            int n4 = 64;
            int n5 = n2 + random.nextInt(16) + 8;
            cflv2._a(world, random, n3, n4, n5);
        }
    }
}

