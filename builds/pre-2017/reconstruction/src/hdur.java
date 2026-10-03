/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class hdur
extends BiomeGenBase {
    public hdur(int n) {
        super(n);
        this._K.add(new yffo(EntityWolf.class, 8, 4, 4));
        this._I.treesPerChunk = 10;
        this._I.grassPerChunk = 1;
    }

    @Override
    public WorldGenerator _a(Random random) {
        if (random.nextInt(3) == 0) {
            return new bthg();
        }
        return new nwmw(false);
    }
}

