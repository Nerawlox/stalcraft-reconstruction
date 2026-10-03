/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.asm.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogCategory;
import noppes.npcs.controllers.DialogOption;

public class DialogController {
    private static final String lock = "lock";
    public static DialogController instance;
    public HashMap<Integer, DialogCategory> categories = new HashMap();
    public HashMap<Integer, Dialog> dialogs = new HashMap();
    private int lastUsedID = 0;
    private int nextDialogId = 1;

    public DialogController() {
        instance = this;
        this.loadCategories();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadCategories() {
        boolean bl = false;
        String string = lock;
        String string2 = lock;
        synchronized (lock) {
            File file = CustomNpcs.getWorldSaveDirectory();
            try {
                File file2 = new File(file, "dialog.dat");
                if (file2.exists()) {
                    this.loadCategories(file2);
                } else {
                    bl = true;
                }
            }
            catch (Exception exception) {
                try {
                    File file3 = new File(file, "dialog.dat_old");
                    if (file3.exists()) {
                        this.loadCategories(file3);
                    }
                }
                catch (Exception exception2) {
                    exception.printStackTrace();
                }
            }
            if (bl) {
                this.loadDefaultDialogs();
            }
            return;
        }
    }

    private void loadCategories(File file) throws Exception {
        int n;
        NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
        NBTTagList nBTTagList = nBTTagCompound._n("Data");
        HashMap<Integer, DialogCategory> hashMap = new HashMap<Integer, DialogCategory>();
        HashMap<Integer, Dialog> hashMap2 = new HashMap<Integer, Dialog>();
        if (nBTTagList != null) {
            for (n = 0; n < nBTTagList._d(); ++n) {
                DialogCategory dialogCategory = new DialogCategory();
                dialogCategory.readNBT((NBTTagCompound)nBTTagList._b(n));
                hashMap.put(dialogCategory.id, dialogCategory);
                Iterator<Dialog> iterator2 = dialogCategory.dialogs.values().iterator();
                while (iterator2.hasNext()) {
                    Dialog dialog = iterator2.next();
                    Dialog dialog2 = (Dialog)hashMap2.get(dialog.id);
                    if (dialog2 != null) {
                        iterator2.remove();
                        Logger.warning("Removed dialog " + dialog2.title + " with duplicated id " + dialog.id, new Object[0]);
                        continue;
                    }
                    hashMap2.put(dialog.id, dialog);
                }
            }
        }
        n = hashMap2.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        this.nextDialogId = Math.max(nBTTagCompound._f("nextDialogId"), n + 1);
        int n2 = hashMap.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        this.lastUsedID = Math.max(nBTTagCompound._f("lastID"), n2);
        this.categories = hashMap;
        this.dialogs = hashMap2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void saveCategories() {
        if (FileWriteBlocker._a) {
            return;
        }
        String string = lock;
        String string2 = lock;
        synchronized (lock) {
            try {
                Object object;
                System.out.println("Saving dialogs");
                File file = CustomNpcs.getWorldSaveDirectory();
                NBTTagList nBTTagList = new NBTTagList();
                for (DialogCategory object22 : this.categories.values()) {
                    object = new NBTTagCompound();
                    object22.writeNBT((NBTTagCompound)object);
                    nBTTagList._a((NBTBase)object);
                }
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                nBTTagCompound._a("lastID", this.lastUsedID);
                nBTTagCompound._a("nextDialogId", this.nextDialogId);
                nBTTagCompound._a("Data", nBTTagList);
                File file2 = new File(file, "dialog.dat_new");
                object = new File(file, "dialog.dat_old");
                File file3 = new File(file, "dialog.dat");
                bsvf._a(nBTTagCompound, new FileOutputStream(file2));
                if (((File)object).exists()) {
                    ((File)object).delete();
                }
                file3.renameTo((File)object);
                if (file3.exists()) {
                    file3.delete();
                }
                file2.renameTo(file3);
                if (file2.exists()) {
                    file2.delete();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return;
        }
    }

    private void loadDefaultDialogs() {
        if (this.categories.isEmpty() && this.categories.isEmpty()) {
            DialogCategory dialogCategory = new DialogCategory();
            dialogCategory.id = 1;
            dialogCategory.title = "Villager";
            Dialog dialog = new Dialog();
            dialog.id = 1;
            dialog.category = dialogCategory;
            dialog.title = "Start";
            dialog.text = "Hello {player}, \n\nWelcome to our village. I hope you enjoy your stay";
            Dialog dialog2 = new Dialog();
            dialog2.id = 2;
            dialog2.category = dialogCategory;
            dialog2.title = "Ask about village";
            dialog2.text = "This village has been around for ages. Enjoy your stay here.";
            Dialog dialog3 = new Dialog();
            dialog3.id = 3;
            dialog3.category = dialogCategory;
            dialog3.title = "Who are you";
            dialog3.text = "I'm a villager here. I have lived in this village my whole life.";
            dialogCategory.dialogs.put(dialog.id, dialog);
            dialogCategory.dialogs.put(dialog2.id, dialog2);
            dialogCategory.dialogs.put(dialog3.id, dialog3);
            DialogOption dialogOption = new DialogOption();
            dialogOption.title = "Tell me something about this village";
            dialogOption.dialogId = 2;
            dialogOption.optionType = EnumOptionType.DialogOption;
            DialogOption dialogOption2 = new DialogOption();
            dialogOption2.title = "Who are you?";
            dialogOption2.dialogId = 3;
            dialogOption2.optionType = EnumOptionType.DialogOption;
            DialogOption dialogOption3 = new DialogOption();
            dialogOption3.title = "Goodbye";
            dialogOption3.optionType = EnumOptionType.QuitOption;
            dialog.options.put(0, dialogOption2);
            dialog.options.put(1, dialogOption);
            dialog.options.put(2, dialogOption3);
            DialogOption dialogOption4 = new DialogOption();
            dialogOption4.title = "Back";
            dialogOption4.dialogId = 1;
            dialog2.options.put(1, dialogOption4);
            dialog3.options.put(1, dialogOption4);
            this.categories.put(dialogCategory.id, dialogCategory);
            this.dialogs.put(dialog.id, dialog);
            this.dialogs.put(dialog2.id, dialog2);
            this.dialogs.put(dialog3.id, dialog3);
            this.lastUsedID = 3;
            this.nextDialogId = 4;
            this.saveCategories();
        }
    }

    public void removeDialog(Dialog dialog, boolean bl) {
        DialogCategory dialogCategory = dialog.category;
        dialogCategory.dialogs.remove(dialog.id);
        this.dialogs.remove(dialog.id);
        if (bl) {
            this.saveCategories();
        }
    }

    public void saveCategory(DialogCategory dialogCategory) throws IOException {
        if (dialogCategory.id < 0) {
            if (this.lastUsedID == 0) {
                for (Integer object : this.categories.keySet()) {
                    if (object <= this.lastUsedID) continue;
                    this.lastUsedID = object;
                }
            }
            ++this.lastUsedID;
            dialogCategory.id = this.lastUsedID;
        }
        if (this.categories.containsKey(dialogCategory.id)) {
            Iterator<Dialog> iterator2 = this.categories.get(dialogCategory.id);
            if (!((DialogCategory)((Object)iterator2)).title.equals(dialogCategory.title)) {
                while (this.containsCategoryName(dialogCategory.title)) {
                    dialogCategory.title = dialogCategory.title + "_";
                }
            }
        } else {
            while (this.containsCategoryName(dialogCategory.title)) {
                dialogCategory.title = dialogCategory.title + "_";
            }
        }
        for (Dialog dialog : dialogCategory.dialogs.values()) {
            Dialog dialog2 = this.dialogs.get(dialog.id);
            if (dialog2 != null) {
                this.removeDialog(dialog2, false);
            }
            this.dialogs.put(dialog.id, dialog);
        }
        this.categories.put(dialogCategory.id, dialogCategory);
        this.saveCategories();
    }

    public void removeCategory(int n, boolean bl) {
        DialogCategory dialogCategory = this.categories.get(n);
        if (dialogCategory != null) {
            for (Integer n2 : dialogCategory.dialogs.keySet()) {
                this.dialogs.remove(n2);
            }
            this.categories.remove(n);
            if (bl) {
                this.saveCategories();
            }
        }
    }

    private boolean containsCategoryName(String string) {
        String string2 = string.toLowerCase();
        return this.categories.values().stream().anyMatch(dialogCategory -> dialogCategory.title.equals(string2));
    }

    private boolean containsDialogName(DialogCategory dialogCategory, String string) {
        String string2 = string.toLowerCase();
        return dialogCategory.dialogs.values().stream().anyMatch(dialog -> dialog.title.toLowerCase().equals(string2));
    }

    public void saveDialog(int n, Dialog dialog) throws IOException {
        DialogCategory dialogCategory = this.categories.get(n);
        if (dialogCategory != null) {
            dialog.category = dialogCategory;
            if (dialog.id < 0) {
                dialog.id = this.getNextDialogId();
                while (this.containsDialogName(dialog.category, dialog.title)) {
                    dialog.title = dialog.title + "_";
                }
            }
            if (this.dialogs.containsKey(dialog.id)) {
                this.removeDialog(this.dialogs.get(dialog.id), false);
            }
            this.dialogs.put(dialog.id, dialog);
            dialog.category.dialogs.put(dialog.id, dialog);
            this.saveCategories();
        }
    }

    public int getNextDialogId() {
        return this.nextDialogId++;
    }

    public boolean hasDialog(int n) {
        return this.dialogs.containsKey(n);
    }
}

