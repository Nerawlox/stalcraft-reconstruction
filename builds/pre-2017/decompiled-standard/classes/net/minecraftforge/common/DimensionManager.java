/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Multiset;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

public class DimensionManager {
    private static Hashtable<Integer, Class<? extends rrte>> providers = new Hashtable();
    private static Hashtable<Integer, Boolean> spawnSettings = new Hashtable();
    private static Hashtable<Integer, yfgy> worlds = new Hashtable();
    private static boolean hasInit = false;
    private static Hashtable<Integer, Integer> dimensions = new Hashtable();
    private static ArrayList<Integer> unloadQueue = new ArrayList();
    private static BitSet dimensionMap = new BitSet(1024);
    private static ConcurrentMap<ozlu, ozlu> weakWorldMap = new MapMaker().weakKeys().weakValues().makeMap();
    private static Multiset<Integer> leakedWorlds = HashMultiset.create();

    public static boolean registerProviderType(int n, Class<? extends rrte> clazz, boolean bl) {
        if (providers.containsKey(n)) {
            return false;
        }
        providers.put(n, clazz);
        spawnSettings.put(n, bl);
        return true;
    }

    public static int[] unregisterProviderType(int n) {
        if (!providers.containsKey(n)) {
            return new int[0];
        }
        providers.remove(n);
        spawnSettings.remove(n);
        int[] nArray = new int[dimensions.size()];
        int n2 = 0;
        for (Map.Entry<Integer, Integer> entry : dimensions.entrySet()) {
            if (entry.getValue() != n) continue;
            nArray[n2++] = entry.getKey();
        }
        return Arrays.copyOf(nArray, n2);
    }

    public static void init() {
        if (hasInit) {
            return;
        }
        hasInit = true;
        DimensionManager.registerProviderType(0, igyo.class, true);
        DimensionManager.registerProviderType(-1, zzlh.class, true);
        DimensionManager.registerProviderType(1, nwiw.class, false);
        DimensionManager.registerDimension(0, 0);
        DimensionManager.registerDimension(-1, -1);
        DimensionManager.registerDimension(1, 1);
    }

    public static void registerDimension(int n, int n2) {
        if (!providers.containsKey(n2)) {
            throw new IllegalArgumentException(String.format("Failed to register dimension for id %d, provider type %d does not exist", n, n2));
        }
        if (dimensions.containsKey(n)) {
            throw new IllegalArgumentException(String.format("Failed to register dimension for id %d, One is already registered", n));
        }
        dimensions.put(n, n2);
        if (n >= 0) {
            dimensionMap.set(n);
        }
    }

    public static void unregisterDimension(int n) {
        if (!dimensions.containsKey(n)) {
            throw new IllegalArgumentException(String.format("Failed to unregister dimension for id %d; No provider registered", n));
        }
        dimensions.remove(n);
    }

    public static boolean isDimensionRegistered(int n) {
        return dimensions.containsKey(n);
    }

    public static int getProviderType(int n) {
        if (!dimensions.containsKey(n)) {
            throw new IllegalArgumentException(String.format("Could not get provider type for dimension %d, does not exist", n));
        }
        return dimensions.get(n);
    }

    public static rrte getProvider(int n) {
        return DimensionManager.getWorld((int)n).field_73011_w;
    }

    public static Integer[] getIDs(boolean bl) {
        if (bl) {
            ArrayList<ozlu> arrayList = Lists.newArrayList(weakWorldMap.keySet());
            arrayList.removeAll(worlds.values());
            Iterator iterator2 = arrayList.listIterator();
            while (iterator2.hasNext()) {
                ozlu ozlu2 = (ozlu)iterator2.next();
                leakedWorlds.add(System.identityHashCode(ozlu2));
            }
            for (ozlu ozlu2 : arrayList) {
                int n = leakedWorlds.count(System.identityHashCode(ozlu2));
                if (n == 5) {
                    FMLLog.fine("The world %x (%s) may have leaked: first encounter (5 occurences).\n", System.identityHashCode(ozlu2), ozlu2.func_72912_H()._k());
                    continue;
                }
                if (n % 5 != 0) continue;
                FMLLog.fine("The world %x (%s) may have leaked: seen %d times.\n", System.identityHashCode(ozlu2), ozlu2.func_72912_H()._k(), n);
            }
        }
        return DimensionManager.getIDs();
    }

    public static Integer[] getIDs() {
        return worlds.keySet().toArray(new Integer[worlds.size()]);
    }

    public static void setWorld(int n, yfgy yfgy2) {
        if (yfgy2 != null) {
            worlds.put(n, yfgy2);
            weakWorldMap.put(yfgy2, yfgy2);
            dzfd._I()._I.put(n, new long[100]);
            FMLLog.info("Loading dimension %d (%s) (%s)", n, yfgy2.func_72912_H()._k(), yfgy2.func_73046_m());
        } else {
            worlds.remove(n);
            dzfd._I()._I.remove(n);
            FMLLog.info("Unloading dimension %d", n);
        }
        ArrayList<yfgy> arrayList = new ArrayList<yfgy>();
        if (worlds.get(0) != null) {
            arrayList.add(worlds.get(0));
        }
        if (worlds.get(-1) != null) {
            arrayList.add(worlds.get(-1));
        }
        if (worlds.get(1) != null) {
            arrayList.add(worlds.get(1));
        }
        for (Map.Entry<Integer, yfgy> entry : worlds.entrySet()) {
            int n2 = entry.getKey();
            if (n2 >= -1 && n2 <= 1) continue;
            arrayList.add(entry.getValue());
        }
        dzfd._I()._j = arrayList.toArray(new yfgy[arrayList.size()]);
    }

    public static void initDimension(int n) {
        yfgy yfgy2 = DimensionManager.getWorld(0);
        if (yfgy2 == null) {
            throw new RuntimeException("Cannot Hotload Dim: Overworld is not Loaded!");
        }
        try {
            DimensionManager.getProviderType(n);
        }
        catch (Exception exception) {
            System.err.println("Cannot Hotload Dim: " + exception.getMessage());
            return;
        }
        dzfd dzfd2 = yfgy2.func_73046_m();
        mtms mtms2 = yfgy2.func_72860_G();
        nfhj nfhj2 = new nfhj(yfgy2.func_72912_H());
        yfgy yfgy3 = n == 0 ? yfgy2 : new rasa(dzfd2, mtms2, yfgy2.func_72912_H()._k(), n, nfhj2, yfgy2, dzfd2._g, yfgy2.func_98180_V());
        yfgy3.func_72954_a(new foqx(dzfd2, yfgy3));
        MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(yfgy3));
        if (!dzfd2._N()) {
            yfgy3.func_72912_H()._a(dzfd2._r());
        }
        dzfd2._c(dzfd2._s());
    }

    public static yfgy getWorld(int n) {
        return worlds.get(n);
    }

    public static yfgy[] getWorlds() {
        return worlds.values().toArray(new yfgy[worlds.size()]);
    }

    public static boolean shouldLoadSpawn(int n) {
        int n2 = DimensionManager.getProviderType(n);
        return spawnSettings.containsKey(n2) && spawnSettings.get(n2) != false;
    }

    public static Integer[] getStaticDimensionIDs() {
        return dimensions.keySet().toArray(new Integer[dimensions.keySet().size()]);
    }

    public static rrte createProviderFor(int n) {
        try {
            if (dimensions.containsKey(n)) {
                rrte rrte2 = providers.get(DimensionManager.getProviderType(n)).newInstance();
                rrte2._b(n);
                return rrte2;
            }
            throw new RuntimeException(String.format("No WorldProvider bound for dimension %d", n));
        }
        catch (Exception exception) {
            FMLCommonHandler.instance().getFMLLogger().log(Level.SEVERE, String.format("An error occured trying to create an instance of WorldProvider %d (%s)", n, providers.get(DimensionManager.getProviderType(n)).getSimpleName()), exception);
            throw new RuntimeException(exception);
        }
    }

    public static void unloadWorld(int n) {
        unloadQueue.add(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void unloadWorlds(Hashtable<Integer, long[]> hashtable) {
        for (int n : unloadQueue) {
            yfgy yfgy2 = worlds.get(n);
            try {
                if (yfgy2 != null) {
                    yfgy2.func_73044_a(true, null);
                    continue;
                }
                FMLLog.warning("Unexpected world unload - world %d is already unloaded", n);
            }
            catch (xcad xcad2) {
                xcad2.printStackTrace();
            }
            finally {
                if (yfgy2 == null) continue;
                MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload(yfgy2));
                yfgy2.func_73041_k();
                DimensionManager.setWorld(n, null);
            }
        }
        unloadQueue.clear();
    }

    public static int getNextFreeDimId() {
        int n = 0;
        while (dimensions.containsKey(n = dimensionMap.nextClearBit(n))) {
            dimensionMap.set(n);
        }
        return n;
    }

    public static qoac saveDimensionDataMap() {
        int[] nArray = new int[(dimensionMap.length() + 32 - 1) / 32];
        qoac qoac2 = new qoac();
        for (int i = 0; i < nArray.length; ++i) {
            int n = 0;
            for (int j = 0; j < 32; ++j) {
                n |= dimensionMap.get(i * 32 + j) ? 1 << j : 0;
            }
            nArray[i] = n;
        }
        qoac2._a("DimensionArray", nArray);
        return qoac2;
    }

    public static void loadDimensionDataMap(qoac qoac2) {
        if (qoac2 == null) {
            dimensionMap.clear();
            for (Integer n : dimensions.keySet()) {
                if (n < 0) continue;
                dimensionMap.set(n);
            }
        } else {
            int[] nArray = qoac2._l("DimensionArray");
            for (int i = 0; i < nArray.length; ++i) {
                for (int j = 0; j < 32; ++j) {
                    dimensionMap.set(i * 32 + j, (nArray[i] & 1 << j) != 0);
                }
            }
        }
    }

    public static File getCurrentSaveRootDirectory() {
        if (DimensionManager.getWorld(0) != null) {
            return ((plxv)DimensionManager.getWorld(0).func_72860_G())._c();
        }
        if (dzfd._I() != null) {
            dzfd dzfd2 = dzfd._I();
            plxv plxv2 = (plxv)dzfd2._S()._a(dzfd2._j(), false);
            return plxv2._c();
        }
        return null;
    }

    static {
        DimensionManager.init();
    }
}

