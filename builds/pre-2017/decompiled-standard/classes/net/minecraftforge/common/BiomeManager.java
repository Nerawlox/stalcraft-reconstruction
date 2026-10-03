/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;

public class BiomeManager {
    public static void addVillageBiome(foqh foqh2, boolean bl) {
        if (!hvak._d.contains(foqh2)) {
            ArrayList<foqh> arrayList = new ArrayList<foqh>(hvak._d);
            arrayList.add(foqh2);
            hvak._d = arrayList;
        }
    }

    public static void removeVillageBiome(foqh foqh2) {
        if (hvak._d.contains(foqh2)) {
            ArrayList arrayList = new ArrayList(hvak._d);
            arrayList.remove(foqh2);
            hvak._d = arrayList;
        }
    }

    public static void addStrongholdBiome(foqh foqh2) {
        if (!fozd._d.contains(foqh2)) {
            fozd._d.add(foqh2);
        }
    }

    public static void removeStrongholdBiome(foqh foqh2) {
        if (fozd._d.contains(foqh2)) {
            fozd._d.remove(foqh2);
        }
    }

    public static void addSpawnBiome(foqh foqh2) {
        if (!foqg._a.contains(foqh2)) {
            foqg._a.add(foqh2);
        }
    }

    public static void removeSpawnBiome(foqh foqh2) {
        if (foqg._a.contains(foqh2)) {
            foqg._a.remove(foqh2);
        }
    }
}

