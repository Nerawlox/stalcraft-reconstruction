/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import java.util.ArrayList;
import java.util.EnumSet;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;

public class BiomeDictionary {
    private static final int BIOME_LIST_SIZE = 256;
    private static BiomeInfo[] biomeList = new BiomeInfo[256];
    private static ArrayList<BiomeGenBase>[] typeInfoList = new ArrayList[Type.values().length];

    public static boolean registerBiomeType(BiomeGenBase biomeGenBase, Type ... typeArray) {
        if (BiomeGenBase._a[biomeGenBase._P] != null) {
            for (Type type : typeArray) {
                if (typeInfoList[type.ordinal()] == null) {
                    BiomeDictionary.typeInfoList[type.ordinal()] = new ArrayList();
                }
                typeInfoList[type.ordinal()].add(biomeGenBase);
            }
            if (biomeList[biomeGenBase._P] == null) {
                BiomeDictionary.biomeList[biomeGenBase._P] = new BiomeInfo(typeArray);
            } else {
                for (Type type : typeArray) {
                    BiomeDictionary.biomeList[biomeGenBase._P].typeList.add(type);
                }
            }
            return true;
        }
        return false;
    }

    public static BiomeGenBase[] getBiomesForType(Type type) {
        if (typeInfoList[type.ordinal()] != null) {
            return typeInfoList[type.ordinal()].toArray(new BiomeGenBase[0]);
        }
        return new BiomeGenBase[0];
    }

    public static Type[] getTypesForBiome(BiomeGenBase biomeGenBase) {
        BiomeDictionary.checkRegistration(biomeGenBase);
        if (biomeList[biomeGenBase._P] != null) {
            return BiomeDictionary.biomeList[biomeGenBase._P].typeList.toArray(new Type[0]);
        }
        return new Type[0];
    }

    public static boolean areBiomesEquivalent(BiomeGenBase biomeGenBase, BiomeGenBase biomeGenBase2) {
        int n = biomeGenBase._P;
        int n2 = biomeGenBase2._P;
        BiomeDictionary.checkRegistration(biomeGenBase);
        BiomeDictionary.checkRegistration(biomeGenBase2);
        if (biomeList[n] != null && biomeList[n2] != null) {
            for (Type type : BiomeDictionary.biomeList[n].typeList) {
                if (!BiomeDictionary.containsType(biomeList[n2], type)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean isBiomeOfType(BiomeGenBase biomeGenBase, Type type) {
        BiomeDictionary.checkRegistration(biomeGenBase);
        if (biomeList[biomeGenBase._P] != null) {
            return BiomeDictionary.containsType(biomeList[biomeGenBase._P], type);
        }
        return false;
    }

    public static boolean isBiomeRegistered(BiomeGenBase biomeGenBase) {
        return biomeList[biomeGenBase._P] != null;
    }

    public static boolean isBiomeRegistered(int n) {
        return biomeList[n] != null;
    }

    public static void registerAllBiomes() {
        FMLLog.warning("Redundant call to BiomeDictionary.registerAllBiomes ignored", new Object[0]);
    }

    public static void registerAllBiomesAndGenerateEvents() {
        for (int i = 0; i < BiomeGenBase._a.length; ++i) {
            BiomeGenBase biomeGenBase = BiomeGenBase._a[i];
            if (biomeGenBase == null) continue;
            if (biomeGenBase._I instanceof DeferredBiomeDecorator) {
                DeferredBiomeDecorator deferredBiomeDecorator = (DeferredBiomeDecorator)biomeGenBase._I;
                deferredBiomeDecorator.fireCreateEventAndReplace();
            }
            BiomeDictionary.checkRegistration(biomeGenBase);
        }
    }

    public static void makeBestGuess(BiomeGenBase biomeGenBase) {
        if (biomeGenBase._I.treesPerChunk >= 3) {
            if (biomeGenBase._f() && biomeGenBase._F >= 1.0f) {
                BiomeDictionary.registerBiomeType(biomeGenBase, Type.JUNGLE);
            } else if (!biomeGenBase._f()) {
                BiomeDictionary.registerBiomeType(biomeGenBase, Type.FOREST);
            }
        } else if (biomeGenBase._E <= 0.3f && biomeGenBase._E >= 0.0f && (!biomeGenBase._f() || biomeGenBase._D >= 0.0f)) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.PLAINS);
        }
        if (biomeGenBase._f() && biomeGenBase._D < 0.0f && biomeGenBase._E <= 0.3f && biomeGenBase._E >= 0.0f) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.SWAMP);
        }
        if (biomeGenBase._D <= -0.5f) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.WATER);
        }
        if (biomeGenBase._E >= 1.5f) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.MOUNTAIN);
        }
        if (biomeGenBase._d() || biomeGenBase._F < 0.2f) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.FROZEN);
        }
        if (!biomeGenBase._f() && biomeGenBase._F >= 1.0f) {
            BiomeDictionary.registerBiomeType(biomeGenBase, Type.DESERT);
        }
    }

    private static void checkRegistration(BiomeGenBase biomeGenBase) {
        if (!BiomeDictionary.isBiomeRegistered(biomeGenBase)) {
            BiomeDictionary.makeBestGuess(biomeGenBase);
        }
    }

    private static boolean containsType(BiomeInfo biomeInfo, Type type) {
        return biomeInfo.typeList.contains((Object)type);
    }

    private static void registerVanillaBiomes() {
        BiomeDictionary.registerBiomeType(BiomeGenBase._b, Type.WATER);
        BiomeDictionary.registerBiomeType(BiomeGenBase._c, Type.PLAINS);
        BiomeDictionary.registerBiomeType(BiomeGenBase._d, Type.DESERT);
        BiomeDictionary.registerBiomeType(BiomeGenBase._e, Type.MOUNTAIN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._f, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBase._g, Type.FOREST, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._u, Type.FOREST, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._h, Type.SWAMP);
        BiomeDictionary.registerBiomeType(BiomeGenBase._i, Type.WATER);
        BiomeDictionary.registerBiomeType(BiomeGenBase._l, Type.WATER, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._m, Type.WATER, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._n, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._o, Type.FROZEN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._r, Type.BEACH);
        BiomeDictionary.registerBiomeType(BiomeGenBase._s, Type.DESERT);
        BiomeDictionary.registerBiomeType(BiomeGenBase._w, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(BiomeGenBase._x, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(BiomeGenBase._t, Type.FOREST);
        BiomeDictionary.registerBiomeType(BiomeGenBase._k, Type.END);
        BiomeDictionary.registerBiomeType(BiomeGenBase._j, Type.NETHER);
        BiomeDictionary.registerBiomeType(BiomeGenBase._p, Type.MUSHROOM);
        BiomeDictionary.registerBiomeType(BiomeGenBase._v, Type.MOUNTAIN);
        BiomeDictionary.registerBiomeType(BiomeGenBase._q, Type.MUSHROOM, Type.BEACH);
    }

    static {
        BiomeDictionary.registerVanillaBiomes();
    }

    private static class BiomeInfo {
        public EnumSet<Type> typeList = EnumSet.noneOf(Type.class);

        public BiomeInfo(Type[] typeArray) {
            for (Type type : typeArray) {
                this.typeList.add(type);
            }
        }
    }

    public static enum Type {
        FOREST,
        PLAINS,
        MOUNTAIN,
        HILLS,
        SWAMP,
        WATER,
        DESERT,
        FROZEN,
        JUNGLE,
        WASTELAND,
        BEACH,
        NETHER,
        END,
        MUSHROOM,
        MAGICAL;

    }
}

