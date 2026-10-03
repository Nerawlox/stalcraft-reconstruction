/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class yfge
extends BiomeGenBase {
    public yfge(int n) {
        super(n);
        this._K.clear();
        this._A = (byte)Block.sand.blockID;
        this._B = (byte)Block.sand.blockID;
        this._I.treesPerChunk = -999;
        this._I.deadBushPerChunk = 0;
        this._I.reedsPerChunk = 0;
        this._I.cactiPerChunk = 0;
    }
}

