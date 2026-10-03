/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class xteu
extends BiomeGenBase {
    public xteu(int n) {
        super(n);
        this._K.clear();
        this._A = (byte)Block.sand.blockID;
        this._B = (byte)Block.sand.blockID;
        this._I.treesPerChunk = -999;
        this._I.deadBushPerChunk = 2;
        this._I.reedsPerChunk = 50;
        this._I.cactiPerChunk = 10;
    }

    @Override
    public void _a(World world, Random random, int n, int n2) {
        super._a(world, random, n, n2);
        if (random.nextInt(1000) == 0) {
            int n3 = n + random.nextInt(16) + 8;
            int n4 = n2 + random.nextInt(16) + 8;
            zzmm zzmm2 = new zzmm();
            ((WorldGenerator)zzmm2)._a(world, random, n3, world.getHeightValue(n3, n4) + 1, n4);
        }
    }
}

