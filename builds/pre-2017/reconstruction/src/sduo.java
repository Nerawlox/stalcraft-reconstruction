/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.biome.BiomeGenBase;

public class sduo
extends BiomeGenBase {
    public sduo(int n) {
        super(n);
        this._I.treesPerChunk = -100;
        this._I.flowersPerChunk = -100;
        this._I.grassPerChunk = -100;
        this._I.mushroomsPerChunk = 1;
        this._I.bigMushroomsPerChunk = 1;
        this._A = (byte)Block.mycelium.blockID;
        this._J.clear();
        this._K.clear();
        this._L.clear();
        this._K.add(new yffo(EntityMooshroom.class, 8, 4, 8));
    }
}

