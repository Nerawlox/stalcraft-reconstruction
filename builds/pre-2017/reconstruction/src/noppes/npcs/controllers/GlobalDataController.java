/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.CustomNpcs;

public class GlobalDataController {
    public static GlobalDataController instance;
    private int itemGiverId = 0;

    public GlobalDataController() {
        instance = this;
        this.load();
    }

    private void load() {
        File file = CustomNpcs.getWorldSaveDirectory();
        try {
            File file2 = new File(file, "global.dat");
            if (file2.exists()) {
                this.loadData(file2);
            }
        }
        catch (Exception exception) {
            try {
                File file3 = new File(file, "global.dat_old");
                if (file3.exists()) {
                    this.loadData(file3);
                }
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    private void loadData(File file) throws Exception {
        NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
        this.itemGiverId = nBTTagCompound._f("itemGiverId");
    }

    public void saveData() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("itemGiverId", this.itemGiverId);
            File file2 = new File(file, "global.dat_new");
            File file3 = new File(file, "global.dat_old");
            File file4 = new File(file, "global.dat");
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

    public int incrementItemGiverId() {
        ++this.itemGiverId;
        this.saveData();
        return this.itemGiverId;
    }
}

