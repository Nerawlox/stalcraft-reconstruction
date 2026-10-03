/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIServerUtils;
import com.google.common.collect.HashMultimap;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;

public class IDConflictReporter {
    private static HashMultimap<Integer, Block> blockConflicts = HashMultimap.create();
    private static HashMap<Object, ModContainer> containers = new HashMap();
    private static boolean postInitReached = false;

    public static void blockConstructed(Block block, int n) {
        if (Block.blocksList[n] != null) {
            if (postInitReached) {
                throw new IllegalArgumentException("Slot " + n + " is already occupied by " + Block.blocksList[n] + " when adding " + block + "\n Blocks should be registered before postInit for NEI to do proper conflict reporting");
            }
            blockConflicts.put((Object)n, (Object)block);
        }
        IDConflictReporter.bindModContainer(block);
    }

    private static void bindModContainer(Block block) {
        containers.put(block, Loader.instance().activeModContainer());
    }

    private static boolean hasConflicts() {
        return !blockConflicts.isEmpty();
    }

    public static void postInit() {
        postInitReached = true;
        if (!IDConflictReporter.hasConflicts()) {
            return;
        }
        try {
            File file = new File("IDConflicts.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            IDConflictReporter.printConflicts(printWriter, blockConflicts, "Blocks", Block.blocksList);
            printWriter.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        NEIServerUtils.throwCME("A list of ID conflicts has been written to\nthe file 'IDConflicts.txt' in your minecraft directory");
    }

    private static void printConflicts(PrintWriter printWriter, HashMultimap<Integer, ?> hashMultimap, String string, Object[] objectArray) {
        if (!hashMultimap.isEmpty()) {
            printWriter.println("#" + string);
            int n = 0;
            ArrayList<IDConflict> arrayList = new ArrayList<IDConflict>(hashMultimap.size());
            Iterator iterator2 = hashMultimap.keySet().iterator();
            while (iterator2.hasNext()) {
                int n2 = (Integer)iterator2.next();
                Set set = hashMultimap.get((Object)n2);
                arrayList.add(new IDConflict(n2, set, objectArray));
                n += set.size();
            }
            Collections.sort(arrayList);
            for (IDConflict iDConflict : arrayList) {
                printWriter.println(iDConflict.msg);
            }
            IDConflictReporter.printSuggestions(printWriter, n, objectArray);
        }
    }

    private static void printSuggestions(PrintWriter printWriter, int n, Object[] objectArray) {
        Object object;
        int n2;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        int n3 = -1;
        for (int i = 0; i < objectArray.length; ++i) {
            int n4 = n2 = objectArray[i] == null ? 1 : 0;
            if (n2 != 0) {
                if (n3 != -1) continue;
                n3 = i;
                continue;
            }
            if (n3 < 0) continue;
            arrayList.add(new int[]{n3, i - 1});
            n3 = -1;
        }
        if (n3 >= 0) {
            arrayList.add(new int[]{n3, objectArray.length - 1});
        }
        Collections.sort(arrayList, new Comparator<int[]>(){

            @Override
            public int compare(int[] nArray, int[] nArray2) {
                int n = nArray[1] - nArray[0];
                int n2 = nArray2[1] - nArray2[0];
                return n == n2 ? 0 : (n > n2 ? -1 : 1);
            }
        });
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        n2 = 0;
        for (int i = 0; i < arrayList.size() && (n2 < n || arrayList2.size() < 3); n2 += object[1] - object[0], ++i) {
            object = (int[])arrayList.get(i);
            arrayList2.add(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = "";
        for (int[] nArray : arrayList2) {
            stringBuilder.append((String)object);
            if (nArray[0] == nArray[1]) {
                stringBuilder.append(nArray[0]);
            } else {
                stringBuilder.append(nArray[0] + "-" + nArray[1] + " (" + (nArray[1] - nArray[0] + 1) + " IDs)");
            }
            object = ", ";
        }
        printWriter.println("Suggested Ranges: " + stringBuilder.toString());
        if (n2 < n) {
            printWriter.println("You don't have enough blockIDs for all these mods, try uninstalling " + IDConflictReporter.modWithMostIDs(objectArray));
        }
    }

    private static String modWithMostIDs(Object[] objectArray) {
        HashMap<ModContainer, Integer> hashMap = new HashMap<ModContainer, Integer>();
        for (Object entry : objectArray) {
            ModContainer modContainer;
            if (entry == null || (modContainer = containers.get(entry)) == null) continue;
            Integer n = (Integer)hashMap.get(modContainer);
            hashMap.put(modContainer, n == null ? 1 : n + 1);
        }
        int n = 0;
        ModContainer modContainer = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            if ((Integer)entry.getValue() <= n) continue;
            n = (Integer)entry.getValue();
            modContainer = (ModContainer)entry.getKey();
        }
        return modContainer.getModId();
    }

    private static class IDConflict
    implements Comparable<IDConflict> {
        public int id;
        public String msg;

        public IDConflict(int n, Collection<?> collection, Object[] objectArray) {
            this.id = n;
            this.msg = n + ": " + IDConflict.identify(objectArray[n]);
            for (Object obj : collection) {
                this.msg = this.msg + " - " + IDConflict.identify(obj);
            }
        }

        @Override
        public int compareTo(IDConflict iDConflict) {
            return iDConflict.id == this.id ? 0 : (this.id > iDConflict.id ? 1 : -1);
        }

        public static String identify(Object object) {
            return IDConflict.name(object) + " from " + IDConflict.getContainerID(object);
        }

        public static String getContainerID(Object object) {
            ModContainer modContainer = (ModContainer)containers.get(object);
            if (modContainer != null) {
                return modContainer.getModId();
            }
            return "Unknown";
        }

        public static String name(Object object) {
            if (object instanceof Block) {
                return IDConflict.blockName((Block)object);
            }
            return object.toString();
        }

        public static String blockName(Block block) {
            String string = block.getUnlocalizedName();
            if (string != null && string.startsWith("tile.")) {
                string = string.substring(5);
            }
            if (string == null || string.length() == 0) {
                string = block.getClass().getName();
            }
            return string;
        }
    }
}

