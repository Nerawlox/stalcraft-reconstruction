/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajz;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.WorldInfo;

public class SaveFormatOld
implements ISaveFormat {
    public final File _a;

    public SaveFormatOld(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this._a = file;
    }

    @Override
    public List _a() {
        ArrayList<SaveFormatComparator> arrayList = new ArrayList<SaveFormatComparator>();
        for (int i = 0; i < 5; ++i) {
            String string = "World" + (i + 1);
            WorldInfo worldInfo = this._c(string);
            if (worldInfo == null) continue;
            arrayList.add(new SaveFormatComparator(string, "", worldInfo._m(), worldInfo._h(), worldInfo._r(), false, worldInfo._t(), worldInfo._v()));
        }
        return arrayList;
    }

    @Override
    public void _c() {
    }

    @Override
    public WorldInfo _c(String string) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Data");
                return new WorldInfo(nBTTagCompound2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if ((file2 = new File(file, "level.dat_old")).exists()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound3 = nBTTagCompound._m("Data");
                return new WorldInfo(nBTTagCompound3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void _a(String string, String string2) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return;
        }
        File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Data");
                nBTTagCompound2._a("LevelName", string2);
                bsvf._a(nBTTagCompound, new FileOutputStream(file2));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public boolean _d(String string) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return true;
        }
        System.out.println("Deleting level " + string);
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Attempt " + i + "...");
            if (SaveFormatOld._a(file.listFiles())) break;
            System.out.println("Unsuccessful in deleting contents.");
            if (i >= 5) continue;
            try {
                Thread.sleep(500L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        return file.delete();
    }

    public static boolean _a(File[] fileArray) {
        for (int i = 0; i < fileArray.length; ++i) {
            File file = fileArray[i];
            System.out.println("Deleting " + file);
            if (file.isDirectory() && !SaveFormatOld._a(file.listFiles())) {
                System.out.println("Couldn't delete directory " + file);
                return false;
            }
            if (file.delete()) continue;
            System.out.println("Couldn't delete file " + file);
            return false;
        }
        return true;
    }

    @Override
    public ISaveHandler _a(String string, boolean bl) {
        return new plxv(this._a, string, bl);
    }

    @Override
    public boolean _a(String string) {
        return false;
    }

    @Override
    public boolean _a(String string, sajz sajz2) {
        return false;
    }

    @Override
    public boolean _e(String string) {
        File file = new File(this._a, string);
        return file.isDirectory();
    }
}

