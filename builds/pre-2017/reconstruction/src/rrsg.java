/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;

public class rrsg
extends BiomeGenBase {
    public rrsg(int n) {
        super(n);
        this._K.add(new yffo(EntityHorse.class, 5, 2, 6));
        this._I.treesPerChunk = -999;
        this._I.flowersPerChunk = 4;
        this._I.grassPerChunk = 10;
    }
}

