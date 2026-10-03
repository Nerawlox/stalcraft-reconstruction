/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class huwa
extends BiomeGenBase {
    public huwa(int n) {
        super(n);
        this._I.treesPerChunk = 2;
        this._I.flowersPerChunk = -999;
        this._I.deadBushPerChunk = 1;
        this._I.mushroomsPerChunk = 8;
        this._I.reedsPerChunk = 10;
        this._I.clayPerChunk = 1;
        this._I.waterlilyPerChunk = 4;
        this._H = 14745518;
        this._J.add(new yffo(EntitySlime.class, 1, 1, 1));
    }

    @Override
    public WorldGenerator _a(Random random) {
        return this._T;
    }

    @Override
    public int _l() {
        double d = this._k();
        double d2 = this._j();
        return ((gapq._a(d, d2) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }

    @Override
    public int _m() {
        double d = this._k();
        double d2 = this._j();
        return ((igvq._a(d, d2) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }
}

