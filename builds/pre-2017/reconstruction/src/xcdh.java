/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class xcdh
extends BiomeGenBase {
    public xcdh(int n) {
        super(n);
        this._K.add(new yffo(EntityWolf.class, 5, 4, 4));
        this._I.treesPerChunk = 10;
        this._I.grassPerChunk = 2;
    }

    @Override
    public WorldGenerator _a(Random random) {
        if (random.nextInt(5) == 0) {
            return this._S;
        }
        if (random.nextInt(10) == 0) {
            return this._R;
        }
        return this._Q;
    }
}

