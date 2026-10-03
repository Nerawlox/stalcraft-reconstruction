/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipesDefault;

public class RecipeController {
    public static RecipeController instance;
    private static Collection prevRecipes;
    public HashMap globalRecipes = new HashMap();
    public HashMap anvilRecipes = new HashMap();

    public RecipeController() {
        instance = this;
        this.loadCategories();
        RecipeController.reloadGlobalRecipes(this.globalRecipes);
    }

    public static void reloadGlobalRecipes(HashMap hashMap) {
        List list2 = CraftingManager._a()._b();
        if (prevRecipes != null) {
            list2.removeAll(prevRecipes);
        }
        prevRecipes = new HashSet(hashMap.values());
        list2.addAll(prevRecipes);
    }

    private void loadCategories() {
        File file = CustomNpcs.getWorldSaveDirectory();
        try {
            File file2 = new File(file, "recipes.dat");
            if (file2.exists()) {
                this.loadCategories(file2);
            } else {
                this.loadDefaultRecipes();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            try {
                File file3 = new File(file, "recipes.dat_old");
                if (file3.exists()) {
                    this.loadCategories(file3);
                }
            }
            catch (Exception exception2) {
                exception.printStackTrace();
            }
        }
    }

    private void loadDefaultRecipes() {
        new RecipesDefault(this);
        this.saveCategories();
    }

    private void loadCategories(File file) throws Exception {
        NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
        NBTTagList nBTTagList = nBTTagCompound._n("Data");
        HashMap<Integer, RecipeCarpentry> hashMap = new HashMap<Integer, RecipeCarpentry>();
        HashMap<Integer, RecipeCarpentry> hashMap2 = new HashMap<Integer, RecipeCarpentry>();
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                RecipeCarpentry recipeCarpentry = new RecipeCarpentry();
                recipeCarpentry.readNBT((NBTTagCompound)nBTTagList._b(i));
                if (recipeCarpentry.isGlobal) {
                    hashMap.put(recipeCarpentry.id, recipeCarpentry);
                    continue;
                }
                hashMap2.put(recipeCarpentry.id, recipeCarpentry);
            }
        }
        this.anvilRecipes = hashMap2;
        this.globalRecipes = hashMap;
    }

    private void saveCategories() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            NBTTagList nBTTagList = new NBTTagList();
            for (RecipeCarpentry recipeCarpentry : this.globalRecipes.values()) {
                nBTTagList._a(recipeCarpentry.writeNBT());
            }
            for (RecipeCarpentry recipeCarpentry : this.anvilRecipes.values()) {
                nBTTagList._a(recipeCarpentry.writeNBT());
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Data", nBTTagList);
            File file2 = new File(file, "recipes.dat_new");
            File file3 = new File(file, "recipes.dat_old");
            File file4 = new File(file, "recipes.dat");
            bsvf._a(nBTTagCompound, new FileOutputStream(file2));
            if (file3.exists()) {
                file3.delete();
            }
            file4.renameTo(file3);
            if (file4.exists()) {
                file4.delete();
            }
            file2.renameTo(file4);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public RecipeCarpentry findMatchingRecipe(InventoryCrafting inventoryCrafting) {
        RecipeCarpentry recipeCarpentry;
        Iterator iterator2 = this.anvilRecipes.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return null;
        } while (!(recipeCarpentry = (RecipeCarpentry)iterator2.next()).matches(inventoryCrafting, null));
        return recipeCarpentry;
    }

    public RecipeCarpentry getRecipe(int n) {
        return this.globalRecipes.containsKey(n) ? (RecipeCarpentry)this.globalRecipes.get(n) : (this.anvilRecipes.containsKey(n) ? (RecipeCarpentry)this.anvilRecipes.get(n) : null);
    }

    public RecipeCarpentry saveRecipe(DataInputStream dataInputStream) throws IOException {
        RecipeCarpentry recipeCarpentry = new RecipeCarpentry();
        recipeCarpentry.readNBT(bsvf._a(dataInputStream));
        RecipeCarpentry recipeCarpentry2 = this.getRecipe(recipeCarpentry.id);
        if (recipeCarpentry2 != null && !recipeCarpentry2.name.equals(recipeCarpentry.name)) {
            while (this.containsRecipeName(recipeCarpentry.name)) {
                recipeCarpentry.name = recipeCarpentry.name + "_";
            }
        }
        if (recipeCarpentry.id == -1) {
            recipeCarpentry.id = this.getUniqueId();
            while (this.containsRecipeName(recipeCarpentry.name)) {
                recipeCarpentry.name = recipeCarpentry.name + "_";
            }
        }
        if (recipeCarpentry.isGlobal) {
            this.anvilRecipes.remove(recipeCarpentry.id);
            this.globalRecipes.put(recipeCarpentry.id, recipeCarpentry);
        } else {
            this.globalRecipes.remove(recipeCarpentry.id);
            this.anvilRecipes.put(recipeCarpentry.id, recipeCarpentry);
        }
        this.saveCategories();
        RecipeController.reloadGlobalRecipes(this.globalRecipes);
        return recipeCarpentry;
    }

    private int getUniqueId() {
        int n;
        int n2 = 0;
        Iterator iterator2 = this.globalRecipes.keySet().iterator();
        while (iterator2.hasNext()) {
            n = (Integer)iterator2.next();
            if (n <= n2) continue;
            n2 = n;
        }
        iterator2 = this.anvilRecipes.keySet().iterator();
        while (iterator2.hasNext()) {
            n = (Integer)iterator2.next();
            if (n <= n2) continue;
            n2 = n;
        }
        return ++n2;
    }

    private boolean containsRecipeName(String string) {
        RecipeCarpentry recipeCarpentry;
        string = string.toLowerCase();
        Iterator iterator2 = this.globalRecipes.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                iterator2 = this.anvilRecipes.values().iterator();
                do {
                    if (!iterator2.hasNext()) {
                        return false;
                    }
                    recipeCarpentry = (RecipeCarpentry)iterator2.next();
                } while (!recipeCarpentry.name.toLowerCase().equals(string));
                return true;
            }
            recipeCarpentry = (RecipeCarpentry)iterator2.next();
        } while (!recipeCarpentry.name.toLowerCase().equals(string));
        return true;
    }

    public RecipeCarpentry removeRecipe(int n) {
        RecipeCarpentry recipeCarpentry = this.getRecipe(n);
        this.globalRecipes.remove(recipeCarpentry.id);
        this.anvilRecipes.remove(recipeCarpentry.id);
        this.saveCategories();
        RecipeController.reloadGlobalRecipes(this.globalRecipes);
        return recipeCarpentry;
    }
}

