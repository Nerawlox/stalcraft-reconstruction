/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.ComponentScatteredFeatureDesertPyramid;
import net.minecraft.world.gen.structure.ComponentScatteredFeatureJunglePyramid;

public class vnhh
extends tycc {
    public vnhh() {
    }

    public vnhh(World world, Random random, int n, int n2) {
        super(n, n2);
        BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(n * 16 + 8, n2 * 16 + 8);
        if (biomeGenBase == BiomeGenBase._w || biomeGenBase == BiomeGenBase._x) {
            ComponentScatteredFeatureJunglePyramid componentScatteredFeatureJunglePyramid = new ComponentScatteredFeatureJunglePyramid(random, n * 16, n2 * 16);
            this._a.add(componentScatteredFeatureJunglePyramid);
        } else if (biomeGenBase == BiomeGenBase._h) {
            nfmv nfmv2 = new nfmv(random, n * 16, n2 * 16);
            this._a.add(nfmv2);
        } else {
            ComponentScatteredFeatureDesertPyramid componentScatteredFeatureDesertPyramid = new ComponentScatteredFeatureDesertPyramid(random, n * 16, n2 * 16);
            this._a.add(componentScatteredFeatureDesertPyramid);
        }
        this._c();
    }
}

