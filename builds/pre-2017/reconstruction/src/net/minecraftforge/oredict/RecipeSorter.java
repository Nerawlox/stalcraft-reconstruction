/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.toposort.TopologicalSort;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeSorter
implements Comparator<lpso> {
    private static Map<Class, Category> categories = Maps.newHashMap();
    private static Map<String, Class> types = Maps.newHashMap();
    private static Map<String, SortEntry> entries = Maps.newHashMap();
    private static Map<Class, Integer> priorities = Maps.newHashMap();
    public static RecipeSorter INSTANCE = new RecipeSorter();
    private static boolean isDirty = true;
    private static SortEntry before = new SortEntry("Before", null, Category.UNKNOWN, "");
    private static SortEntry after = new SortEntry("After", null, Category.UNKNOWN, "");
    private static Set<Class> warned = Sets.newHashSet();

    private RecipeSorter() {
        RecipeSorter.register("minecraft:shaped", xbtf.class, Category.SHAPED, "before:minecraft:shapeless");
        RecipeSorter.register("minecraft:mapextending", ixkn.class, Category.SHAPED, "after:minecraft:shaped before:minecraft:shapeless");
        RecipeSorter.register("minecraft:shapeless", vmoj.class, Category.SHAPELESS, "after:minecraft:shaped");
        RecipeSorter.register("minecraft:fireworks", gadn.class, Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("minecraft:armordyes", xbtl.class, Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("minecraft:mapcloning", qoaz.class, Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("forge:shapedore", ShapedOreRecipe.class, Category.SHAPED, "after:minecraft:shaped before:minecraft:shapeless");
        RecipeSorter.register("forge:shapelessore", ShapelessOreRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");
    }

    @Override
    public int compare(lpso lpso2, lpso lpso3) {
        Category category = RecipeSorter.getCategory(lpso2);
        Category category2 = RecipeSorter.getCategory(lpso3);
        if (category == Category.SHAPELESS && category2 == Category.SHAPED) {
            return 1;
        }
        if (category == Category.SHAPED && category2 == Category.SHAPELESS) {
            return -1;
        }
        if (lpso3.getRecipeSize() < lpso2.getRecipeSize()) {
            return -1;
        }
        if (lpso3.getRecipeSize() > lpso2.getRecipeSize()) {
            return 1;
        }
        return RecipeSorter.getPriority(lpso3) - RecipeSorter.getPriority(lpso2);
    }

    public static void sortCraftManager() {
        RecipeSorter.bake();
        FMLLog.fine("Sorting recipies", new Object[0]);
        warned.clear();
        Collections.sort(CraftingManager._a()._b(), INSTANCE);
    }

    public static void register(String string, Class clazz, Category category, String string2) {
        assert (category != Category.UNKNOWN) : "Category must not be unknown!";
        isDirty = true;
        SortEntry sortEntry = new SortEntry(string, clazz, category, string2);
        entries.put(string, sortEntry);
        RecipeSorter.setCategory(clazz, category);
    }

    public static void setCategory(Class clazz, Category category) {
        assert (category != Category.UNKNOWN) : "Category must not be unknown!";
        categories.put(clazz, category);
    }

    public static Category getCategory(lpso lpso2) {
        return RecipeSorter.getCategory(lpso2.getClass());
    }

    public static Category getCategory(Class clazz) {
        Class clazz2 = clazz;
        Category category = categories.get(clazz2);
        if (category == null) {
            clazz2 = clazz2.getSuperclass();
            while (clazz2 != Object.class) {
                category = categories.get(clazz2);
                if (category == null) continue;
                categories.put(clazz, category);
                return category;
            }
        }
        return category == null ? Category.UNKNOWN : category;
    }

    private static int getPriority(lpso lpso2) {
        Class<?> clazz = lpso2.getClass();
        Integer n = priorities.get(clazz);
        if (n == null) {
            if (!warned.contains(clazz)) {
                FMLLog.fine("  Unknown recipe class! %s Modder please refer to %s", clazz.getName(), RecipeSorter.class.getName());
                warned.add(clazz);
            }
            clazz = clazz.getSuperclass();
            while (clazz != Object.class) {
                n = priorities.get(clazz);
                if (n == null) continue;
                priorities.put(lpso2.getClass(), n);
                FMLLog.fine("    Parent Found: %d - %s", (int)n, clazz.getName());
                return n;
            }
        }
        return n == null ? 0 : n;
    }

    private static void bake() {
        Object object;
        if (!isDirty) {
            return;
        }
        FMLLog.fine("Forge RecipeSorter Baking:", new Object[0]);
        TopologicalSort.DirectedGraph<Object> directedGraph = new TopologicalSort.DirectedGraph<Object>();
        directedGraph.addNode(before);
        directedGraph.addNode(after);
        directedGraph.addEdge(before, after);
        for (Map.Entry<String, SortEntry> entry : entries.entrySet()) {
            directedGraph.addNode(entry.getValue());
        }
        for (Map.Entry<String, SortEntry> entry : entries.entrySet()) {
            object = entry.getValue();
            boolean bl = false;
            directedGraph.addEdge(before, object);
            for (String string : ((SortEntry)object).after) {
                if (!entries.containsKey(string)) continue;
                directedGraph.addEdge(entries.get(string), object);
            }
            for (String string : ((SortEntry)object).before) {
                bl = true;
                directedGraph.addEdge(object, after);
                if (!entries.containsKey(string)) continue;
                directedGraph.addEdge(object, entries.get(string));
            }
            if (bl) continue;
            directedGraph.addEdge(object, after);
        }
        List list2 = TopologicalSort.topologicalSort(directedGraph);
        int n = list2.size();
        object = list2.iterator();
        while (object.hasNext()) {
            SortEntry sortEntry = (SortEntry)object.next();
            FMLLog.fine("  %d: %s", n, sortEntry);
            priorities.put(sortEntry.cls, n--);
        }
    }

    private static class SortEntry {
        private String name;
        private Class cls;
        private Category cat;
        List<String> before = Lists.newArrayList();
        List<String> after = Lists.newArrayList();

        private SortEntry(String string, Class clazz, Category category, String string2) {
            this.name = string;
            this.cls = clazz;
            this.cat = category;
            this.parseDepends(string2);
        }

        private void parseDepends(String string) {
            if (string.isEmpty()) {
                return;
            }
            for (String string2 : string.split(" ")) {
                if (string2.startsWith("before:")) {
                    this.before.add(string2.substring(7));
                    continue;
                }
                if (string2.startsWith("after:")) {
                    this.after.add(string2.substring(6));
                    continue;
                }
                throw new IllegalArgumentException("Invalid dependancy: " + string2);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RecipeEntry(\"").append(this.name).append("\", ");
            stringBuilder.append(this.cat.name()).append(", ");
            stringBuilder.append(this.cls == null ? "" : this.cls.getName()).append(")");
            if (this.before.size() > 0) {
                stringBuilder.append(" Before: ").append(Joiner.on(", ").join(this.before));
            }
            if (this.after.size() > 0) {
                stringBuilder.append(" After: ").append(Joiner.on(", ").join(this.after));
            }
            return stringBuilder.toString();
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    public static enum Category {
        UNKNOWN,
        SHAPELESS,
        SHAPED;

    }
}

