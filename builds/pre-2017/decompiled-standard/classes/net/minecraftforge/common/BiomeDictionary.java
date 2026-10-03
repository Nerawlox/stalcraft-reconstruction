/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import java.util.ArrayList;
import java.util.EnumSet;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;

public class BiomeDictionary {
    private static final int BIOME_LIST_SIZE = 256;
    private static BiomeInfo[] biomeList = new BiomeInfo[256];
    private static ArrayList<foqh>[] typeInfoList = new ArrayList[Type.values().length];

    public static boolean registerBiomeType(foqh foqh2, Type ... typeArray) {
        if (foqh._a[foqh2._P] != null) {
            for (Type type : typeArray) {
                if (typeInfoList[type.ordinal()] == null) {
                    BiomeDictionary.typeInfoList[type.ordinal()] = new ArrayList();
                }
                typeInfoList[type.ordinal()].add(foqh2);
            }
            if (biomeList[foqh2._P] == null) {
                BiomeDictionary.biomeList[foqh2._P] = new BiomeInfo(typeArray);
            } else {
                for (Type type : typeArray) {
                    BiomeDictionary.biomeList[foqh2._P].typeList.add(type);
                }
            }
            return true;
        }
        return false;
    }

    public static foqh[] getBiomesForType(Type type) {
        if (typeInfoList[type.ordinal()] != null) {
            return typeInfoList[type.ordinal()].toArray(new foqh[0]);
        }
        return new foqh[0];
    }

    public static Type[] getTypesForBiome(foqh foqh2) {
        BiomeDictionary.checkRegistration(foqh2);
        if (biomeList[foqh2._P] != null) {
            return BiomeDictionary.biomeList[foqh2._P].typeList.toArray(new Type[0]);
        }
        return new Type[0];
    }

    public static boolean areBiomesEquivalent(foqh foqh2, foqh foqh3) {
        int n = foqh2._P;
        int n2 = foqh3._P;
        BiomeDictionary.checkRegistration(foqh2);
        BiomeDictionary.checkRegistration(foqh3);
        if (biomeList[n] != null && biomeList[n2] != null) {
            for (Type type : BiomeDictionary.biomeList[n].typeList) {
                if (!BiomeDictionary.containsType(biomeList[n2], type)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean isBiomeOfType(foqh foqh2, Type type) {
        BiomeDictionary.checkRegistration(foqh2);
        if (biomeList[foqh2._P] != null) {
            return BiomeDictionary.containsType(biomeList[foqh2._P], type);
        }
        return false;
    }

    public static boolean isBiomeRegistered(foqh foqh2) {
        return biomeList[foqh2._P] != null;
    }

    public static boolean isBiomeRegistered(int n) {
        return biomeList[n] != null;
    }

    public static void registerAllBiomes() {
        FMLLog.warning("Redundant call to BiomeDictionary.registerAllBiomes ignored", new Object[0]);
    }

    public static void registerAllBiomesAndGenerateEvents() {
        for (int i = 0; i < foqh._a.length; ++i) {
            foqh foqh2 = foqh._a[i];
            if (foqh2 == null) continue;
            if (foqh2._I instanceof DeferredBiomeDecorator) {
                DeferredBiomeDecorator deferredBiomeDecorator = (DeferredBiomeDecorator)foqh2._I;
                deferredBiomeDecorator.fireCreateEventAndReplace();
            }
            BiomeDictionary.checkRegistration(foqh2);
        }
    }

    public static void makeBestGuess(foqh foqh2) {
        if (foqh2._I.field_76832_z >= 3) {
            if (foqh2._f() && foqh2._F >= 1.0f) {
                BiomeDictionary.registerBiomeType(foqh2, Type.JUNGLE);
            } else if (!foqh2._f()) {
                BiomeDictionary.registerBiomeType(foqh2, Type.FOREST);
            }
        } else if (foqh2._E <= 0.3f && foqh2._E >= 0.0f && (!foqh2._f() || foqh2._D >= 0.0f)) {
            BiomeDictionary.registerBiomeType(foqh2, Type.PLAINS);
        }
        if (foqh2._f() && foqh2._D < 0.0f && foqh2._E <= 0.3f && foqh2._E >= 0.0f) {
            BiomeDictionary.registerBiomeType(foqh2, Type.SWAMP);
        }
        if (foqh2._D <= -0.5f) {
            BiomeDictionary.registerBiomeType(foqh2, Type.WATER);
        }
        if (foqh2._E >= 1.5f) {
            BiomeDictionary.registerBiomeType(foqh2, Type.MOUNTAIN);
        }
        if (foqh2._d() || foqh2._F < 0.2f) {
            BiomeDictionary.registerBiomeType(foqh2, Type.FROZEN);
        }
        if (!foqh2._f() && foqh2._F >= 1.0f) {
            BiomeDictionary.registerBiomeType(foqh2, Type.DESERT);
        }
    }

    private static void checkRegistration(foqh foqh2) {
        if (!BiomeDictionary.isBiomeRegistered(foqh2)) {
            BiomeDictionary.makeBestGuess(foqh2);
        }
    }

    private static boolean containsType(BiomeInfo biomeInfo, Type type) {
        return biomeInfo.typeList.contains((Object)type);
    }

    private static void registerVanillaBiomes() {
        BiomeDictionary.registerBiomeType(foqh._b, Type.WATER);
        BiomeDictionary.registerBiomeType(foqh._c, Type.PLAINS);
        BiomeDictionary.registerBiomeType(foqh._d, Type.DESERT);
        BiomeDictionary.registerBiomeType(foqh._e, Type.MOUNTAIN);
        BiomeDictionary.registerBiomeType(foqh._f, Type.FOREST);
        BiomeDictionary.registerBiomeType(foqh._g, Type.FOREST, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._u, Type.FOREST, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._h, Type.SWAMP);
        BiomeDictionary.registerBiomeType(foqh._i, Type.WATER);
        BiomeDictionary.registerBiomeType(foqh._l, Type.WATER, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._m, Type.WATER, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._n, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._o, Type.FROZEN);
        BiomeDictionary.registerBiomeType(foqh._r, Type.BEACH);
        BiomeDictionary.registerBiomeType(foqh._s, Type.DESERT);
        BiomeDictionary.registerBiomeType(foqh._w, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(foqh._x, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(foqh._t, Type.FOREST);
        BiomeDictionary.registerBiomeType(foqh._k, Type.END);
        BiomeDictionary.registerBiomeType(foqh._j, Type.NETHER);
        BiomeDictionary.registerBiomeType(foqh._p, Type.MUSHROOM);
        BiomeDictionary.registerBiomeType(foqh._v, Type.MOUNTAIN);
        BiomeDictionary.registerBiomeType(foqh._q, Type.MUSHROOM, Type.BEACH);
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

