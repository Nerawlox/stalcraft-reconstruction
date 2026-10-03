/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;

public class CloneController {
    public static Entity toClone = null;

    private static ArrayList loadClones() {
        try {
            File file = new File(CustomNpcs.Dir, "clonednpcs.dat");
            return !file.exists() ? new ArrayList() : CloneController.loadClones(file);
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
            try {
                File file = new File(CustomNpcs.Dir, "clonednpcs.dat_old");
                return CloneController.loadClones(file);
            }
            catch (Exception exception2) {
                System.err.println(exception2.getMessage());
                return new ArrayList();
            }
        }
    }

    private static ArrayList loadClones(File file) throws Exception {
        ArrayList<NBTTagCompound> arrayList = new ArrayList<NBTTagCompound>();
        NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
        NBTTagList nBTTagList = nBTTagCompound._n("Data");
        if (nBTTagList == null) {
            return arrayList;
        }
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            if (!nBTTagCompound2._c("ClonedDate")) {
                nBTTagCompound2._a("ClonedDate", System.currentTimeMillis());
                nBTTagCompound2._a("ClonedName", nBTTagCompound2._j("Name"));
            }
            arrayList.add(nBTTagCompound2);
        }
        return arrayList;
    }

    public static void saveClones(Collection collection) {
        try {
            NBTTagCompound nBTTagCompound2;
            NBTTagList nBTTagList = new NBTTagList();
            for (NBTTagCompound nBTTagCompound2 : collection) {
                nBTTagList._a(nBTTagCompound2);
            }
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Data", nBTTagList);
            File file = new File(CustomNpcs.Dir, "clonednpcs.dat_new");
            File file2 = new File(CustomNpcs.Dir, "clonednpcs.dat_old");
            File file3 = new File(CustomNpcs.Dir, "clonednpcs.dat");
            bsvf._a(nBTTagCompound2, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static ArrayList getClones() {
        return CloneController.loadClones();
    }

    public static void addClone(Entity entity, String string, int n) {
        ArrayList arrayList = CloneController.getClones();
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        entity.writeToNBTOptional(nBTTagCompound);
        nBTTagCompound._a("ClonedDate", System.currentTimeMillis());
        nBTTagCompound._a("ClonedName", string);
        nBTTagCompound._a("ClonedTab", n);
        arrayList.add(nBTTagCompound);
        CloneController.saveClones(arrayList);
    }
}

