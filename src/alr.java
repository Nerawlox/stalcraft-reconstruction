/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  als
 *  amc
 *  amd
 *  amf
 *  amg
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  lx
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class alr
implements amf {
    protected final File a;

    public alr(File par1File) {
        if (!par1File.exists()) {
            par1File.mkdirs();
        }
        this.a = par1File;
    }

    @SideOnly(value=Side.CLIENT)
    public List b() throws amd {
        ArrayList<amg> arraylist = new ArrayList<amg>();
        for (int i = 0; i < 5; ++i) {
            String s2 = "World" + (i + 1);
            als worldinfo = this.c(s2);
            if (worldinfo == null) continue;
            arraylist.add(new amg(s2, "", worldinfo.m(), worldinfo.h(), worldinfo.r(), false, worldinfo.t(), worldinfo.v()));
        }
        return arraylist;
    }

    public void d() {
    }

    public als c(String par1Str) {
        File file1 = new File(this.a, par1Str);
        if (!file1.exists()) {
            return null;
        }
        File file2 = new File(file1, "level.dat");
        if (file2.exists()) {
            try {
                by nbttagcompound = ci.a(new FileInputStream(file2));
                by nbttagcompound1 = nbttagcompound.l("Data");
                return new als(nbttagcompound1);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if ((file2 = new File(file1, "level.dat_old")).exists()) {
            try {
                by nbttagcompound = ci.a(new FileInputStream(file2));
                by nbttagcompound1 = nbttagcompound.l("Data");
                return new als(nbttagcompound1);
            }
            catch (Exception exception1) {
                exception1.printStackTrace();
            }
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(String par1Str, String par2Str) {
        File file2;
        File file1 = new File(this.a, par1Str);
        if (file1.exists() && (file2 = new File(file1, "level.dat")).exists()) {
            try {
                by nbttagcompound = ci.a(new FileInputStream(file2));
                by nbttagcompound1 = nbttagcompound.l("Data");
                nbttagcompound1.a("LevelName", par2Str);
                ci.a(nbttagcompound, new FileOutputStream(file2));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public boolean e(String par1Str) {
        File file1 = new File(this.a, par1Str);
        if (!file1.exists()) {
            return true;
        }
        System.out.println("Deleting level " + par1Str);
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Attempt " + i + "...");
            if (alr.a(file1.listFiles())) break;
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
        return file1.delete();
    }

    protected static boolean a(File[] par0ArrayOfFile) {
        for (int i = 0; i < par0ArrayOfFile.length; ++i) {
            File file1 = par0ArrayOfFile[i];
            System.out.println("Deleting " + file1);
            if (file1.isDirectory() && !alr.a(file1.listFiles())) {
                System.out.println("Couldn't delete directory " + file1);
                return false;
            }
            if (file1.delete()) continue;
            System.out.println("Couldn't delete file " + file1);
            return false;
        }
        return true;
    }

    public amc a(String par1Str, boolean par2) {
        return new alq(this.a, par1Str, par2);
    }

    public boolean b(String par1Str) {
        return false;
    }

    public boolean a(String par1Str, lx par2IProgressUpdate) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean f(String par1Str) {
        File file1 = new File(this.a, par1Str);
        return file1.isDirectory();
    }
}

