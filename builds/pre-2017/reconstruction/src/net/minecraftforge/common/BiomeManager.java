/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class BiomeManager {
    public static void addVillageBiome(BiomeGenBase biomeGenBase, boolean bl) {
        if (!hvak._d.contains(biomeGenBase)) {
            ArrayList<BiomeGenBase> arrayList = new ArrayList<BiomeGenBase>(hvak._d);
            arrayList.add(biomeGenBase);
            hvak._d = arrayList;
        }
    }

    public static void removeVillageBiome(BiomeGenBase biomeGenBase) {
        if (hvak._d.contains(biomeGenBase)) {
            ArrayList arrayList = new ArrayList(hvak._d);
            arrayList.remove(biomeGenBase);
            hvak._d = arrayList;
        }
    }

    public static void addStrongholdBiome(BiomeGenBase biomeGenBase) {
        if (!fozd._d.contains(biomeGenBase)) {
            fozd._d.add(biomeGenBase);
        }
    }

    public static void removeStrongholdBiome(BiomeGenBase biomeGenBase) {
        if (fozd._d.contains(biomeGenBase)) {
            fozd._d.remove(biomeGenBase);
        }
    }

    public static void addSpawnBiome(BiomeGenBase biomeGenBase) {
        if (!WorldChunkManager._a.contains(biomeGenBase)) {
            WorldChunkManager._a.add(biomeGenBase);
        }
    }

    public static void removeSpawnBiome(BiomeGenBase biomeGenBase) {
        if (WorldChunkManager._a.contains(biomeGenBase)) {
            WorldChunkManager._a.remove(biomeGenBase);
        }
    }
}

