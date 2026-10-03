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
        ArrayList<qoac> arrayList = new ArrayList<qoac>();
        qoac qoac2 = bsvf._a(new FileInputStream(file));
        bsyv bsyv2 = qoac2._n("Data");
        if (bsyv2 == null) {
            return arrayList;
        }
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            if (!qoac3._c("ClonedDate")) {
                qoac3._a("ClonedDate", System.currentTimeMillis());
                qoac3._a("ClonedName", qoac3._j("Name"));
            }
            arrayList.add(qoac3);
        }
        return arrayList;
    }

    public static void saveClones(Collection collection) {
        try {
            qoac qoac22;
            bsyv bsyv2 = new bsyv();
            for (qoac qoac22 : collection) {
                bsyv2._a(qoac22);
            }
            qoac22 = new qoac();
            qoac22._a("Data", bsyv2);
            File file = new File(CustomNpcs.Dir, "clonednpcs.dat_new");
            File file2 = new File(CustomNpcs.Dir, "clonednpcs.dat_old");
            File file3 = new File(CustomNpcs.Dir, "clonednpcs.dat");
            bsvf._a(qoac22, new FileOutputStream(file));
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
        qoac qoac2 = new qoac();
        entity.func_70039_c(qoac2);
        qoac2._a("ClonedDate", System.currentTimeMillis());
        qoac2._a("ClonedName", string);
        qoac2._a("ClonedTab", n);
        arrayList.add(qoac2);
        CloneController.saveClones(arrayList);
    }
}

